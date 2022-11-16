package com.sunknowledge.dme.rcm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.usps.UrbanizationMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.usps.UrbanizationMasterRepository;
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
 * Integration tests for the {@link UrbanizationMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class UrbanizationMasterResourceIT {

    private static final String DEFAULT_URBANIZATION = "AAAAAAAAAA";
    private static final String UPDATED_URBANIZATION = "BBBBBBBBBB";

    private static final String DEFAULT_ABBREVIATION = "AAAAAAAAAA";
    private static final String UPDATED_ABBREVIATION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/urbanization-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{urbanizationId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private UrbanizationMasterRepository urbanizationMasterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private UrbanizationMaster urbanizationMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UrbanizationMaster createEntity(EntityManager em) {
        UrbanizationMaster urbanizationMaster = new UrbanizationMaster()
            .urbanization(DEFAULT_URBANIZATION)
            .abbreviation(DEFAULT_ABBREVIATION);
        return urbanizationMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UrbanizationMaster createUpdatedEntity(EntityManager em) {
        UrbanizationMaster urbanizationMaster = new UrbanizationMaster()
            .urbanization(UPDATED_URBANIZATION)
            .abbreviation(UPDATED_ABBREVIATION);
        return urbanizationMaster;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(UrbanizationMaster.class).block();
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
        urbanizationMaster = createEntity(em);
    }

    @Test
    void createUrbanizationMaster() throws Exception {
        int databaseSizeBeforeCreate = urbanizationMasterRepository.findAll().collectList().block().size();
        // Create the UrbanizationMaster
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeCreate + 1);
        UrbanizationMaster testUrbanizationMaster = urbanizationMasterList.get(urbanizationMasterList.size() - 1);
        assertThat(testUrbanizationMaster.getUrbanization()).isEqualTo(DEFAULT_URBANIZATION);
        assertThat(testUrbanizationMaster.getAbbreviation()).isEqualTo(DEFAULT_ABBREVIATION);
    }

    @Test
    void createUrbanizationMasterWithExistingId() throws Exception {
        // Create the UrbanizationMaster with an existing ID
        urbanizationMaster.setUrbanizationId(1L);

        int databaseSizeBeforeCreate = urbanizationMasterRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllUrbanizationMastersAsStream() {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        List<UrbanizationMaster> urbanizationMasterList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(UrbanizationMaster.class)
            .getResponseBody()
            .filter(urbanizationMaster::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(urbanizationMasterList).isNotNull();
        assertThat(urbanizationMasterList).hasSize(1);
        UrbanizationMaster testUrbanizationMaster = urbanizationMasterList.get(0);
        assertThat(testUrbanizationMaster.getUrbanization()).isEqualTo(DEFAULT_URBANIZATION);
        assertThat(testUrbanizationMaster.getAbbreviation()).isEqualTo(DEFAULT_ABBREVIATION);
    }

    @Test
    void getAllUrbanizationMasters() {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        // Get all the urbanizationMasterList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=urbanizationId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].urbanizationId")
            .value(hasItem(urbanizationMaster.getUrbanizationId().intValue()))
            .jsonPath("$.[*].urbanization")
            .value(hasItem(DEFAULT_URBANIZATION))
            .jsonPath("$.[*].abbreviation")
            .value(hasItem(DEFAULT_ABBREVIATION));
    }

    @Test
    void getUrbanizationMaster() {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        // Get the urbanizationMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, urbanizationMaster.getUrbanizationId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.urbanizationId")
            .value(is(urbanizationMaster.getUrbanizationId().intValue()))
            .jsonPath("$.urbanization")
            .value(is(DEFAULT_URBANIZATION))
            .jsonPath("$.abbreviation")
            .value(is(DEFAULT_ABBREVIATION));
    }

    @Test
    void getNonExistingUrbanizationMaster() {
        // Get the urbanizationMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewUrbanizationMaster() throws Exception {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();

        // Update the urbanizationMaster
        UrbanizationMaster updatedUrbanizationMaster = urbanizationMasterRepository
            .findById(urbanizationMaster.getUrbanizationId())
            .block();
        updatedUrbanizationMaster.urbanization(UPDATED_URBANIZATION).abbreviation(UPDATED_ABBREVIATION);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedUrbanizationMaster.getUrbanizationId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedUrbanizationMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
        UrbanizationMaster testUrbanizationMaster = urbanizationMasterList.get(urbanizationMasterList.size() - 1);
        assertThat(testUrbanizationMaster.getUrbanization()).isEqualTo(UPDATED_URBANIZATION);
        assertThat(testUrbanizationMaster.getAbbreviation()).isEqualTo(UPDATED_ABBREVIATION);
    }

    @Test
    void putNonExistingUrbanizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();
        urbanizationMaster.setUrbanizationId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, urbanizationMaster.getUrbanizationId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchUrbanizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();
        urbanizationMaster.setUrbanizationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamUrbanizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();
        urbanizationMaster.setUrbanizationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateUrbanizationMasterWithPatch() throws Exception {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();

        // Update the urbanizationMaster using partial update
        UrbanizationMaster partialUpdatedUrbanizationMaster = new UrbanizationMaster();
        partialUpdatedUrbanizationMaster.setUrbanizationId(urbanizationMaster.getUrbanizationId());

        partialUpdatedUrbanizationMaster.urbanization(UPDATED_URBANIZATION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedUrbanizationMaster.getUrbanizationId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedUrbanizationMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
        UrbanizationMaster testUrbanizationMaster = urbanizationMasterList.get(urbanizationMasterList.size() - 1);
        assertThat(testUrbanizationMaster.getUrbanization()).isEqualTo(UPDATED_URBANIZATION);
        assertThat(testUrbanizationMaster.getAbbreviation()).isEqualTo(DEFAULT_ABBREVIATION);
    }

    @Test
    void fullUpdateUrbanizationMasterWithPatch() throws Exception {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();

        // Update the urbanizationMaster using partial update
        UrbanizationMaster partialUpdatedUrbanizationMaster = new UrbanizationMaster();
        partialUpdatedUrbanizationMaster.setUrbanizationId(urbanizationMaster.getUrbanizationId());

        partialUpdatedUrbanizationMaster.urbanization(UPDATED_URBANIZATION).abbreviation(UPDATED_ABBREVIATION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedUrbanizationMaster.getUrbanizationId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedUrbanizationMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
        UrbanizationMaster testUrbanizationMaster = urbanizationMasterList.get(urbanizationMasterList.size() - 1);
        assertThat(testUrbanizationMaster.getUrbanization()).isEqualTo(UPDATED_URBANIZATION);
        assertThat(testUrbanizationMaster.getAbbreviation()).isEqualTo(UPDATED_ABBREVIATION);
    }

    @Test
    void patchNonExistingUrbanizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();
        urbanizationMaster.setUrbanizationId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, urbanizationMaster.getUrbanizationId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchUrbanizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();
        urbanizationMaster.setUrbanizationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamUrbanizationMaster() throws Exception {
        int databaseSizeBeforeUpdate = urbanizationMasterRepository.findAll().collectList().block().size();
        urbanizationMaster.setUrbanizationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(urbanizationMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the UrbanizationMaster in the database
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteUrbanizationMaster() {
        // Initialize the database
        urbanizationMasterRepository.save(urbanizationMaster).block();

        int databaseSizeBeforeDelete = urbanizationMasterRepository.findAll().collectList().block().size();

        // Delete the urbanizationMaster
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, urbanizationMaster.getUrbanizationId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<UrbanizationMaster> urbanizationMasterList = urbanizationMasterRepository.findAll().collectList().block();
        assertThat(urbanizationMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
