package com.sunknowledge.dme.rcm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import com.sunknowledge.dme.rcm.repository.usps.DPVConfirmationMasterRepository;
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
 * Integration tests for the {@link DPVConfirmationMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class DPVConfirmationMasterResourceIT {

    private static final String DEFAULT_ENUMERATIONS = "AAAAAAAAAA";
    private static final String UPDATED_ENUMERATIONS = "BBBBBBBBBB";

    private static final String DEFAULT_DEFINITION = "AAAAAAAAAA";
    private static final String UPDATED_DEFINITION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/dpv-confirmation-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{dpvConfirmationId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private DPVConfirmationMasterRepository dPVConfirmationMasterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private DPVConfirmationMaster dPVConfirmationMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DPVConfirmationMaster createEntity(EntityManager em) {
        DPVConfirmationMaster dPVConfirmationMaster = new DPVConfirmationMaster()
            .enumerations(DEFAULT_ENUMERATIONS)
            .definition(DEFAULT_DEFINITION);
        return dPVConfirmationMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DPVConfirmationMaster createUpdatedEntity(EntityManager em) {
        DPVConfirmationMaster dPVConfirmationMaster = new DPVConfirmationMaster()
            .enumerations(UPDATED_ENUMERATIONS)
            .definition(UPDATED_DEFINITION);
        return dPVConfirmationMaster;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(DPVConfirmationMaster.class).block();
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
        dPVConfirmationMaster = createEntity(em);
    }

    @Test
    void createDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeCreate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        // Create the DPVConfirmationMaster
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeCreate + 1);
        DPVConfirmationMaster testDPVConfirmationMaster = dPVConfirmationMasterList.get(dPVConfirmationMasterList.size() - 1);
        assertThat(testDPVConfirmationMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testDPVConfirmationMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void createDPVConfirmationMasterWithExistingId() throws Exception {
        // Create the DPVConfirmationMaster with an existing ID
        dPVConfirmationMaster.setDpvConfirmationId(1L);

        int databaseSizeBeforeCreate = dPVConfirmationMasterRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllDPVConfirmationMastersAsStream() {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        List<DPVConfirmationMaster> dPVConfirmationMasterList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(DPVConfirmationMaster.class)
            .getResponseBody()
            .filter(dPVConfirmationMaster::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(dPVConfirmationMasterList).isNotNull();
        assertThat(dPVConfirmationMasterList).hasSize(1);
        DPVConfirmationMaster testDPVConfirmationMaster = dPVConfirmationMasterList.get(0);
        assertThat(testDPVConfirmationMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testDPVConfirmationMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void getAllDPVConfirmationMasters() {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        // Get all the dPVConfirmationMasterList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=dpvConfirmationId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].dpvConfirmationId")
            .value(hasItem(dPVConfirmationMaster.getDpvConfirmationId().intValue()))
            .jsonPath("$.[*].enumerations")
            .value(hasItem(DEFAULT_ENUMERATIONS))
            .jsonPath("$.[*].definition")
            .value(hasItem(DEFAULT_DEFINITION));
    }

    @Test
    void getDPVConfirmationMaster() {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        // Get the dPVConfirmationMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, dPVConfirmationMaster.getDpvConfirmationId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.dpvConfirmationId")
            .value(is(dPVConfirmationMaster.getDpvConfirmationId().intValue()))
            .jsonPath("$.enumerations")
            .value(is(DEFAULT_ENUMERATIONS))
            .jsonPath("$.definition")
            .value(is(DEFAULT_DEFINITION));
    }

    @Test
    void getNonExistingDPVConfirmationMaster() {
        // Get the dPVConfirmationMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewDPVConfirmationMaster() throws Exception {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();

        // Update the dPVConfirmationMaster
        DPVConfirmationMaster updatedDPVConfirmationMaster = dPVConfirmationMasterRepository
            .findById(dPVConfirmationMaster.getDpvConfirmationId())
            .block();
        updatedDPVConfirmationMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedDPVConfirmationMaster.getDpvConfirmationId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedDPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
        DPVConfirmationMaster testDPVConfirmationMaster = dPVConfirmationMasterList.get(dPVConfirmationMasterList.size() - 1);
        assertThat(testDPVConfirmationMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testDPVConfirmationMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void putNonExistingDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        dPVConfirmationMaster.setDpvConfirmationId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, dPVConfirmationMaster.getDpvConfirmationId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        dPVConfirmationMaster.setDpvConfirmationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        dPVConfirmationMaster.setDpvConfirmationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateDPVConfirmationMasterWithPatch() throws Exception {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();

        // Update the dPVConfirmationMaster using partial update
        DPVConfirmationMaster partialUpdatedDPVConfirmationMaster = new DPVConfirmationMaster();
        partialUpdatedDPVConfirmationMaster.setDpvConfirmationId(dPVConfirmationMaster.getDpvConfirmationId());

        partialUpdatedDPVConfirmationMaster.definition(UPDATED_DEFINITION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedDPVConfirmationMaster.getDpvConfirmationId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedDPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
        DPVConfirmationMaster testDPVConfirmationMaster = dPVConfirmationMasterList.get(dPVConfirmationMasterList.size() - 1);
        assertThat(testDPVConfirmationMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testDPVConfirmationMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void fullUpdateDPVConfirmationMasterWithPatch() throws Exception {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();

        // Update the dPVConfirmationMaster using partial update
        DPVConfirmationMaster partialUpdatedDPVConfirmationMaster = new DPVConfirmationMaster();
        partialUpdatedDPVConfirmationMaster.setDpvConfirmationId(dPVConfirmationMaster.getDpvConfirmationId());

        partialUpdatedDPVConfirmationMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedDPVConfirmationMaster.getDpvConfirmationId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedDPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
        DPVConfirmationMaster testDPVConfirmationMaster = dPVConfirmationMasterList.get(dPVConfirmationMasterList.size() - 1);
        assertThat(testDPVConfirmationMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testDPVConfirmationMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void patchNonExistingDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        dPVConfirmationMaster.setDpvConfirmationId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, dPVConfirmationMaster.getDpvConfirmationId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        dPVConfirmationMaster.setDpvConfirmationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamDPVConfirmationMaster() throws Exception {
        int databaseSizeBeforeUpdate = dPVConfirmationMasterRepository.findAll().collectList().block().size();
        dPVConfirmationMaster.setDpvConfirmationId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(dPVConfirmationMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the DPVConfirmationMaster in the database
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteDPVConfirmationMaster() {
        // Initialize the database
        dPVConfirmationMasterRepository.save(dPVConfirmationMaster).block();

        int databaseSizeBeforeDelete = dPVConfirmationMasterRepository.findAll().collectList().block().size();

        // Delete the dPVConfirmationMaster
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, dPVConfirmationMaster.getDpvConfirmationId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<DPVConfirmationMaster> dPVConfirmationMasterList = dPVConfirmationMasterRepository.findAll().collectList().block();
        assertThat(dPVConfirmationMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
