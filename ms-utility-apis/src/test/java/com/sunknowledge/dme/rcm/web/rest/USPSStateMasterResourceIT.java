package com.sunknowledge.dme.rcm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.usps.USPSStateMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.usps.USPSStateMasterRepository;
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
 * Integration tests for the {@link USPSStateMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class USPSStateMasterResourceIT {

    private static final String DEFAULT_STATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_STATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_POSTAL_ABBRIVIATION = "AAAAAAAAAA";
    private static final String UPDATED_POSTAL_ABBRIVIATION = "BBBBBBBBBB";

    private static final String DEFAULT_FIPS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_FIPS_CODE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/usps-state-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{stateId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private USPSStateMasterRepository uSPSStateMasterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private USPSStateMaster uSPSStateMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static USPSStateMaster createEntity(EntityManager em) {
        USPSStateMaster uSPSStateMaster = new USPSStateMaster()
            .stateName(DEFAULT_STATE_NAME)
            .postalAbbriviation(DEFAULT_POSTAL_ABBRIVIATION)
            .fipsCode(DEFAULT_FIPS_CODE);
        return uSPSStateMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static USPSStateMaster createUpdatedEntity(EntityManager em) {
        USPSStateMaster uSPSStateMaster = new USPSStateMaster()
            .stateName(UPDATED_STATE_NAME)
            .postalAbbriviation(UPDATED_POSTAL_ABBRIVIATION)
            .fipsCode(UPDATED_FIPS_CODE);
        return uSPSStateMaster;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(USPSStateMaster.class).block();
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
        uSPSStateMaster = createEntity(em);
    }

    @Test
    void createUSPSStateMaster() throws Exception {
        int databaseSizeBeforeCreate = uSPSStateMasterRepository.findAll().collectList().block().size();
        // Create the USPSStateMaster
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeCreate + 1);
        USPSStateMaster testUSPSStateMaster = uSPSStateMasterList.get(uSPSStateMasterList.size() - 1);
        assertThat(testUSPSStateMaster.getStateName()).isEqualTo(DEFAULT_STATE_NAME);
        assertThat(testUSPSStateMaster.getPostalAbbriviation()).isEqualTo(DEFAULT_POSTAL_ABBRIVIATION);
        assertThat(testUSPSStateMaster.getFipsCode()).isEqualTo(DEFAULT_FIPS_CODE);
    }

    @Test
    void createUSPSStateMasterWithExistingId() throws Exception {
        // Create the USPSStateMaster with an existing ID
        uSPSStateMaster.setStateId(1L);

        int databaseSizeBeforeCreate = uSPSStateMasterRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllUSPSStateMastersAsStream() {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        List<USPSStateMaster> uSPSStateMasterList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(USPSStateMaster.class)
            .getResponseBody()
            .filter(uSPSStateMaster::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(uSPSStateMasterList).isNotNull();
        assertThat(uSPSStateMasterList).hasSize(1);
        USPSStateMaster testUSPSStateMaster = uSPSStateMasterList.get(0);
        assertThat(testUSPSStateMaster.getStateName()).isEqualTo(DEFAULT_STATE_NAME);
        assertThat(testUSPSStateMaster.getPostalAbbriviation()).isEqualTo(DEFAULT_POSTAL_ABBRIVIATION);
        assertThat(testUSPSStateMaster.getFipsCode()).isEqualTo(DEFAULT_FIPS_CODE);
    }

    @Test
    void getAllUSPSStateMasters() {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        // Get all the uSPSStateMasterList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=stateId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].stateId")
            .value(hasItem(uSPSStateMaster.getStateId().intValue()))
            .jsonPath("$.[*].stateName")
            .value(hasItem(DEFAULT_STATE_NAME))
            .jsonPath("$.[*].postalAbbriviation")
            .value(hasItem(DEFAULT_POSTAL_ABBRIVIATION))
            .jsonPath("$.[*].fipsCode")
            .value(hasItem(DEFAULT_FIPS_CODE));
    }

    @Test
    void getUSPSStateMaster() {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        // Get the uSPSStateMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, uSPSStateMaster.getStateId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.stateId")
            .value(is(uSPSStateMaster.getStateId().intValue()))
            .jsonPath("$.stateName")
            .value(is(DEFAULT_STATE_NAME))
            .jsonPath("$.postalAbbriviation")
            .value(is(DEFAULT_POSTAL_ABBRIVIATION))
            .jsonPath("$.fipsCode")
            .value(is(DEFAULT_FIPS_CODE));
    }

    @Test
    void getNonExistingUSPSStateMaster() {
        // Get the uSPSStateMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewUSPSStateMaster() throws Exception {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();

        // Update the uSPSStateMaster
        USPSStateMaster updatedUSPSStateMaster = uSPSStateMasterRepository.findById(uSPSStateMaster.getStateId()).block();
        updatedUSPSStateMaster.stateName(UPDATED_STATE_NAME).postalAbbriviation(UPDATED_POSTAL_ABBRIVIATION).fipsCode(UPDATED_FIPS_CODE);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedUSPSStateMaster.getStateId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedUSPSStateMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
        USPSStateMaster testUSPSStateMaster = uSPSStateMasterList.get(uSPSStateMasterList.size() - 1);
        assertThat(testUSPSStateMaster.getStateName()).isEqualTo(UPDATED_STATE_NAME);
        assertThat(testUSPSStateMaster.getPostalAbbriviation()).isEqualTo(UPDATED_POSTAL_ABBRIVIATION);
        assertThat(testUSPSStateMaster.getFipsCode()).isEqualTo(UPDATED_FIPS_CODE);
    }

    @Test
    void putNonExistingUSPSStateMaster() throws Exception {
        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();
        uSPSStateMaster.setStateId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, uSPSStateMaster.getStateId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchUSPSStateMaster() throws Exception {
        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();
        uSPSStateMaster.setStateId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamUSPSStateMaster() throws Exception {
        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();
        uSPSStateMaster.setStateId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateUSPSStateMasterWithPatch() throws Exception {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();

        // Update the uSPSStateMaster using partial update
        USPSStateMaster partialUpdatedUSPSStateMaster = new USPSStateMaster();
        partialUpdatedUSPSStateMaster.setStateId(uSPSStateMaster.getStateId());

        partialUpdatedUSPSStateMaster.stateName(UPDATED_STATE_NAME).postalAbbriviation(UPDATED_POSTAL_ABBRIVIATION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedUSPSStateMaster.getStateId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedUSPSStateMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
        USPSStateMaster testUSPSStateMaster = uSPSStateMasterList.get(uSPSStateMasterList.size() - 1);
        assertThat(testUSPSStateMaster.getStateName()).isEqualTo(UPDATED_STATE_NAME);
        assertThat(testUSPSStateMaster.getPostalAbbriviation()).isEqualTo(UPDATED_POSTAL_ABBRIVIATION);
        assertThat(testUSPSStateMaster.getFipsCode()).isEqualTo(DEFAULT_FIPS_CODE);
    }

    @Test
    void fullUpdateUSPSStateMasterWithPatch() throws Exception {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();

        // Update the uSPSStateMaster using partial update
        USPSStateMaster partialUpdatedUSPSStateMaster = new USPSStateMaster();
        partialUpdatedUSPSStateMaster.setStateId(uSPSStateMaster.getStateId());

        partialUpdatedUSPSStateMaster
            .stateName(UPDATED_STATE_NAME)
            .postalAbbriviation(UPDATED_POSTAL_ABBRIVIATION)
            .fipsCode(UPDATED_FIPS_CODE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedUSPSStateMaster.getStateId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedUSPSStateMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
        USPSStateMaster testUSPSStateMaster = uSPSStateMasterList.get(uSPSStateMasterList.size() - 1);
        assertThat(testUSPSStateMaster.getStateName()).isEqualTo(UPDATED_STATE_NAME);
        assertThat(testUSPSStateMaster.getPostalAbbriviation()).isEqualTo(UPDATED_POSTAL_ABBRIVIATION);
        assertThat(testUSPSStateMaster.getFipsCode()).isEqualTo(UPDATED_FIPS_CODE);
    }

    @Test
    void patchNonExistingUSPSStateMaster() throws Exception {
        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();
        uSPSStateMaster.setStateId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, uSPSStateMaster.getStateId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchUSPSStateMaster() throws Exception {
        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();
        uSPSStateMaster.setStateId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamUSPSStateMaster() throws Exception {
        int databaseSizeBeforeUpdate = uSPSStateMasterRepository.findAll().collectList().block().size();
        uSPSStateMaster.setStateId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(uSPSStateMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the USPSStateMaster in the database
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteUSPSStateMaster() {
        // Initialize the database
        uSPSStateMasterRepository.save(uSPSStateMaster).block();

        int databaseSizeBeforeDelete = uSPSStateMasterRepository.findAll().collectList().block().size();

        // Delete the uSPSStateMaster
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, uSPSStateMaster.getStateId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<USPSStateMaster> uSPSStateMasterList = uSPSStateMasterRepository.findAll().collectList().block();
        assertThat(uSPSStateMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
