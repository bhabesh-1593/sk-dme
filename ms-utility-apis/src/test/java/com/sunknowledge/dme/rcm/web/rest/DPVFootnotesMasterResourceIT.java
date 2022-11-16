package com.sunknowledge.dme.rcm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.usps.DPVFootnotesMaster;
import com.sunknowledge.dme.rcm.repository.usps.DPVFootnotesMasterRepository;
import com.sunknowledge.dme.rcm.repository.EntityManager;
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
 * Integration tests for the {@link DPVFootnotesMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class DPVFootnotesMasterResourceIT {

    private static final String DEFAULT_ENUMERATIONS = "AAAAAAAAAA";
    private static final String UPDATED_ENUMERATIONS = "BBBBBBBBBB";

    private static final String DEFAULT_DEFINITION = "AAAAAAAAAA";
    private static final String UPDATED_DEFINITION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/dpv-footnotes-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{dpvFootnotesId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private DPVFootnotesMasterRepository dPVFootnotesMasterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private DPVFootnotesMaster dPVFootnotesMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DPVFootnotesMaster createEntity(EntityManager em) {
        DPVFootnotesMaster dPVFootnotesMaster = new DPVFootnotesMaster().enumerations(DEFAULT_ENUMERATIONS).definition(DEFAULT_DEFINITION);
        return dPVFootnotesMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DPVFootnotesMaster createUpdatedEntity(EntityManager em) {
        DPVFootnotesMaster dPVFootnotesMaster = new DPVFootnotesMaster().enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);
        return dPVFootnotesMaster;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(DPVFootnotesMaster.class).block();
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
        dPVFootnotesMaster = createEntity(em);
    }

    @Test
    void createDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeCreate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        // Create the DPVFootnotesMaster
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeCreate + 1);
        DPVFootnotesMaster testDPVFootnotesMaster = dPVFootnotesMasterList.get(dPVFootnotesMasterList.size() - 1);
        assertThat(testDPVFootnotesMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testDPVFootnotesMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void createDPVFootnotesMasterWithExistingId() throws Exception {
        // Create the DPVFootnotesMaster with an existing ID
        dPVFootnotesMaster.setDpvFootnotesId(1L);

        int databaseSizeBeforeCreate = dPVFootnotesMasterRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllDPVFootnotesMastersAsStream() {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        List<DPVFootnotesMaster> dPVFootnotesMasterList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(DPVFootnotesMaster.class)
            .getResponseBody()
            .filter(dPVFootnotesMaster::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(dPVFootnotesMasterList).isNotNull();
        assertThat(dPVFootnotesMasterList).hasSize(1);
        DPVFootnotesMaster testDPVFootnotesMaster = dPVFootnotesMasterList.get(0);
        assertThat(testDPVFootnotesMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testDPVFootnotesMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void getAllDPVFootnotesMasters() {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        // Get all the dPVFootnotesMasterList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=dpvFootnotesId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].dpvFootnotesId")
            .value(hasItem(dPVFootnotesMaster.getDpvFootnotesId().intValue()))
            .jsonPath("$.[*].enumerations")
            .value(hasItem(DEFAULT_ENUMERATIONS))
            .jsonPath("$.[*].definition")
            .value(hasItem(DEFAULT_DEFINITION));
    }

    @Test
    void getDPVFootnotesMaster() {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        // Get the dPVFootnotesMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, dPVFootnotesMaster.getDpvFootnotesId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.dpvFootnotesId")
            .value(is(dPVFootnotesMaster.getDpvFootnotesId().intValue()))
            .jsonPath("$.enumerations")
            .value(is(DEFAULT_ENUMERATIONS))
            .jsonPath("$.definition")
            .value(is(DEFAULT_DEFINITION));
    }

    @Test
    void getNonExistingDPVFootnotesMaster() {
        // Get the dPVFootnotesMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewDPVFootnotesMaster() throws Exception {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();

        // Update the dPVFootnotesMaster
        DPVFootnotesMaster updatedDPVFootnotesMaster = dPVFootnotesMasterRepository
            .findById(dPVFootnotesMaster.getDpvFootnotesId())
            .block();
        updatedDPVFootnotesMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedDPVFootnotesMaster.getDpvFootnotesId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedDPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
        DPVFootnotesMaster testDPVFootnotesMaster = dPVFootnotesMasterList.get(dPVFootnotesMasterList.size() - 1);
        assertThat(testDPVFootnotesMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testDPVFootnotesMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void putNonExistingDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        dPVFootnotesMaster.setDpvFootnotesId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, dPVFootnotesMaster.getDpvFootnotesId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        dPVFootnotesMaster.setDpvFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        dPVFootnotesMaster.setDpvFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateDPVFootnotesMasterWithPatch() throws Exception {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();

        // Update the dPVFootnotesMaster using partial update
        DPVFootnotesMaster partialUpdatedDPVFootnotesMaster = new DPVFootnotesMaster();
        partialUpdatedDPVFootnotesMaster.setDpvFootnotesId(dPVFootnotesMaster.getDpvFootnotesId());

        partialUpdatedDPVFootnotesMaster.enumerations(UPDATED_ENUMERATIONS);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedDPVFootnotesMaster.getDpvFootnotesId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedDPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
        DPVFootnotesMaster testDPVFootnotesMaster = dPVFootnotesMasterList.get(dPVFootnotesMasterList.size() - 1);
        assertThat(testDPVFootnotesMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testDPVFootnotesMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void fullUpdateDPVFootnotesMasterWithPatch() throws Exception {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();

        // Update the dPVFootnotesMaster using partial update
        DPVFootnotesMaster partialUpdatedDPVFootnotesMaster = new DPVFootnotesMaster();
        partialUpdatedDPVFootnotesMaster.setDpvFootnotesId(dPVFootnotesMaster.getDpvFootnotesId());

        partialUpdatedDPVFootnotesMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedDPVFootnotesMaster.getDpvFootnotesId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedDPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
        DPVFootnotesMaster testDPVFootnotesMaster = dPVFootnotesMasterList.get(dPVFootnotesMasterList.size() - 1);
        assertThat(testDPVFootnotesMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testDPVFootnotesMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void patchNonExistingDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        dPVFootnotesMaster.setDpvFootnotesId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, dPVFootnotesMaster.getDpvFootnotesId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        dPVFootnotesMaster.setDpvFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamDPVFootnotesMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVFootnotesMasterRepository.findAll().collectList().block().size();
        dPVFootnotesMaster.setDpvFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVFootnotesMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the DPVFootnotesMaster in the database
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteDPVFootnotesMaster() {
        // Initialize the database
        dPVFootnotesMasterRepository.save(dPVFootnotesMaster).block();

        int databaseSizeBeforeDelete = dPVFootnotesMasterRepository.findAll().collectList().block().size();

        // Delete the dPVFootnotesMaster
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, dPVFootnotesMaster.getDpvFootnotesId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<DPVFootnotesMaster> dPVFootnotesMasterList = dPVFootnotesMasterRepository.findAll().collectList().block();
        assertThat(dPVFootnotesMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
