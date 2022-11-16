package com.sunknowledge.dme.rcm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.nppes.NpiMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.nppes.NpiMasterRepository;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Integration tests for the {@link NpiMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class NpiMasterResourceIT {

    private static final String DEFAULT_NPI_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_NPI_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ENUMERATION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ENUMERATION_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_NPI_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NPI_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_PHONE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/npi-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{npiId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private NpiMasterRepository npiMasterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private NpiMaster npiMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NpiMaster createEntity(EntityManager em) {
        NpiMaster npiMaster = new NpiMaster()
            .npiNumber(DEFAULT_NPI_NUMBER)
            .enumerationType(DEFAULT_ENUMERATION_TYPE)
            .npiName(DEFAULT_NPI_NAME)
            .address(DEFAULT_ADDRESS)
            .phone(DEFAULT_PHONE);
        return npiMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NpiMaster createUpdatedEntity(EntityManager em) {
        NpiMaster npiMaster = new NpiMaster()
            .npiNumber(UPDATED_NPI_NUMBER)
            .enumerationType(UPDATED_ENUMERATION_TYPE)
            .npiName(UPDATED_NPI_NAME)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE);
        return npiMaster;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(NpiMaster.class).block();
        } catch (Exception e) {
            // It can fail, if other entities are still referring this - it will be removed later.
        }
    }

    @AfterEach
    public void cleanup() {
        deleteEntities(em);
    }

    @BeforeEach
    public void setupCsrf() {
        webTestClient = webTestClient.mutateWith(csrf());
    }

    @BeforeEach
    public void initTest() {
        deleteEntities(em);
        npiMaster = createEntity(em);
    }

    @Test
    void createNpiMaster() throws Exception {
        int databaseSizeBeforeCreate = npiMasterRepository.findAll().collectList().block().size();
        // Create the NpiMaster
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeCreate + 1);
        NpiMaster testNpiMaster = npiMasterList.get(npiMasterList.size() - 1);
        assertThat(testNpiMaster.getNpiNumber()).isEqualTo(DEFAULT_NPI_NUMBER);
        assertThat(testNpiMaster.getEnumerationType()).isEqualTo(DEFAULT_ENUMERATION_TYPE);
        assertThat(testNpiMaster.getNpiName()).isEqualTo(DEFAULT_NPI_NAME);
        assertThat(testNpiMaster.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testNpiMaster.getPhone()).isEqualTo(DEFAULT_PHONE);
    }

    @Test
    void createNpiMasterWithExistingId() throws Exception {
        // Create the NpiMaster with an existing ID
        npiMaster.setNpiId(1L);

        int databaseSizeBeforeCreate = npiMasterRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllNpiMastersAsStream() {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        List<NpiMaster> npiMasterList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(NpiMaster.class)
            .getResponseBody()
            .filter(npiMaster::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(npiMasterList).isNotNull();
        assertThat(npiMasterList).hasSize(1);
        NpiMaster testNpiMaster = npiMasterList.get(0);
        assertThat(testNpiMaster.getNpiNumber()).isEqualTo(DEFAULT_NPI_NUMBER);
        assertThat(testNpiMaster.getEnumerationType()).isEqualTo(DEFAULT_ENUMERATION_TYPE);
        assertThat(testNpiMaster.getNpiName()).isEqualTo(DEFAULT_NPI_NAME);
        assertThat(testNpiMaster.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testNpiMaster.getPhone()).isEqualTo(DEFAULT_PHONE);
    }

    @Test
    void getAllNpiMasters() {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        // Get all the npiMasterList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=npiId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].npiId")
            .value(hasItem(npiMaster.getNpiId().intValue()))
            .jsonPath("$.[*].npiNumber")
            .value(hasItem(DEFAULT_NPI_NUMBER))
            .jsonPath("$.[*].enumerationType")
            .value(hasItem(DEFAULT_ENUMERATION_TYPE))
            .jsonPath("$.[*].npiName")
            .value(hasItem(DEFAULT_NPI_NAME))
            .jsonPath("$.[*].address")
            .value(hasItem(DEFAULT_ADDRESS))
            .jsonPath("$.[*].phone")
            .value(hasItem(DEFAULT_PHONE));
    }

    @Test
    void getNpiMaster() {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        // Get the npiMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, npiMaster.getNpiId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.npiId")
            .value(is(npiMaster.getNpiId().intValue()))
            .jsonPath("$.npiNumber")
            .value(is(DEFAULT_NPI_NUMBER))
            .jsonPath("$.enumerationType")
            .value(is(DEFAULT_ENUMERATION_TYPE))
            .jsonPath("$.npiName")
            .value(is(DEFAULT_NPI_NAME))
            .jsonPath("$.address")
            .value(is(DEFAULT_ADDRESS))
            .jsonPath("$.phone")
            .value(is(DEFAULT_PHONE));
    }

    @Test
    void getNonExistingNpiMaster() {
        // Get the npiMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewNpiMaster() throws Exception {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();

        // Update the npiMaster
        NpiMaster updatedNpiMaster = npiMasterRepository.findById(npiMaster.getNpiId()).block();
        updatedNpiMaster
            .npiNumber(UPDATED_NPI_NUMBER)
            .enumerationType(UPDATED_ENUMERATION_TYPE)
            .npiName(UPDATED_NPI_NAME)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedNpiMaster.getNpiId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedNpiMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
        NpiMaster testNpiMaster = npiMasterList.get(npiMasterList.size() - 1);
        assertThat(testNpiMaster.getNpiNumber()).isEqualTo(UPDATED_NPI_NUMBER);
        assertThat(testNpiMaster.getEnumerationType()).isEqualTo(UPDATED_ENUMERATION_TYPE);
        assertThat(testNpiMaster.getNpiName()).isEqualTo(UPDATED_NPI_NAME);
        assertThat(testNpiMaster.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testNpiMaster.getPhone()).isEqualTo(UPDATED_PHONE);
    }

    @Test
    void putNonExistingNpiMaster() throws Exception {
        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();
        npiMaster.setNpiId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, npiMaster.getNpiId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchNpiMaster() throws Exception {
        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();
        npiMaster.setNpiId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamNpiMaster() throws Exception {
        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();
        npiMaster.setNpiId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateNpiMasterWithPatch() throws Exception {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();

        // Update the npiMaster using partial update
        NpiMaster partialUpdatedNpiMaster = new NpiMaster();
        partialUpdatedNpiMaster.setNpiId(npiMaster.getNpiId());

        partialUpdatedNpiMaster
            .npiNumber(UPDATED_NPI_NUMBER)
            .enumerationType(UPDATED_ENUMERATION_TYPE)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedNpiMaster.getNpiId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedNpiMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
        NpiMaster testNpiMaster = npiMasterList.get(npiMasterList.size() - 1);
        assertThat(testNpiMaster.getNpiNumber()).isEqualTo(UPDATED_NPI_NUMBER);
        assertThat(testNpiMaster.getEnumerationType()).isEqualTo(UPDATED_ENUMERATION_TYPE);
        assertThat(testNpiMaster.getNpiName()).isEqualTo(DEFAULT_NPI_NAME);
        assertThat(testNpiMaster.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testNpiMaster.getPhone()).isEqualTo(UPDATED_PHONE);
    }

    @Test
    void fullUpdateNpiMasterWithPatch() throws Exception {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();

        // Update the npiMaster using partial update
        NpiMaster partialUpdatedNpiMaster = new NpiMaster();
        partialUpdatedNpiMaster.setNpiId(npiMaster.getNpiId());

        partialUpdatedNpiMaster
            .npiNumber(UPDATED_NPI_NUMBER)
            .enumerationType(UPDATED_ENUMERATION_TYPE)
            .npiName(UPDATED_NPI_NAME)
            .address(UPDATED_ADDRESS)
            .phone(UPDATED_PHONE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedNpiMaster.getNpiId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedNpiMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
        NpiMaster testNpiMaster = npiMasterList.get(npiMasterList.size() - 1);
        assertThat(testNpiMaster.getNpiNumber()).isEqualTo(UPDATED_NPI_NUMBER);
        assertThat(testNpiMaster.getEnumerationType()).isEqualTo(UPDATED_ENUMERATION_TYPE);
        assertThat(testNpiMaster.getNpiName()).isEqualTo(UPDATED_NPI_NAME);
        assertThat(testNpiMaster.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testNpiMaster.getPhone()).isEqualTo(UPDATED_PHONE);
    }

    @Test
    void patchNonExistingNpiMaster() throws Exception {
        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();
        npiMaster.setNpiId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, npiMaster.getNpiId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchNpiMaster() throws Exception {
        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();
        npiMaster.setNpiId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamNpiMaster() throws Exception {
        int databaseSizeBeforeUpdate = npiMasterRepository.findAll().collectList().block().size();
        npiMaster.setNpiId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(npiMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the NpiMaster in the database
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteNpiMaster() {
        // Initialize the database
        npiMasterRepository.save(npiMaster).block();

        int databaseSizeBeforeDelete = npiMasterRepository.findAll().collectList().block().size();

        // Delete the npiMaster
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, npiMaster.getNpiId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<NpiMaster> npiMasterList = npiMasterRepository.findAll().collectList().block();
        assertThat(npiMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
