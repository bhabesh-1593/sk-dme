package com.sunknowledge.dme.rcm.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.usps.FootnoteMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.usps.FootnoteMasterRepository;
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
 * Integration tests for the {@link FootnoteMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class FootnoteMasterResourceIT {

    private static final String DEFAULT_ENUMERATIONS = "AAAAAAAAAA";
    private static final String UPDATED_ENUMERATIONS = "BBBBBBBBBB";

    private static final String DEFAULT_DEFINITION = "AAAAAAAAAA";
    private static final String UPDATED_DEFINITION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/footnote-masters";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{footnotesId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FootnoteMasterRepository footnoteMasterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private FootnoteMaster footnoteMaster;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FootnoteMaster createEntity(EntityManager em) {
        FootnoteMaster footnoteMaster = new FootnoteMaster().enumerations(DEFAULT_ENUMERATIONS).definition(DEFAULT_DEFINITION);
        return footnoteMaster;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FootnoteMaster createUpdatedEntity(EntityManager em) {
        FootnoteMaster footnoteMaster = new FootnoteMaster().enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);
        return footnoteMaster;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(FootnoteMaster.class).block();
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
        footnoteMaster = createEntity(em);
    }

    @Test
    void createFootnoteMaster() throws Exception {
        int databaseSizeBeforeCreate = footnoteMasterRepository.findAll().collectList().block().size();
        // Create the FootnoteMaster
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeCreate + 1);
        FootnoteMaster testFootnoteMaster = footnoteMasterList.get(footnoteMasterList.size() - 1);
        assertThat(testFootnoteMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testFootnoteMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void createFootnoteMasterWithExistingId() throws Exception {
        // Create the FootnoteMaster with an existing ID
        footnoteMaster.setFootnotesId(1L);

        int databaseSizeBeforeCreate = footnoteMasterRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllFootnoteMastersAsStream() {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        List<FootnoteMaster> footnoteMasterList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(FootnoteMaster.class)
            .getResponseBody()
            .filter(footnoteMaster::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(footnoteMasterList).isNotNull();
        assertThat(footnoteMasterList).hasSize(1);
        FootnoteMaster testFootnoteMaster = footnoteMasterList.get(0);
        assertThat(testFootnoteMaster.getEnumerations()).isEqualTo(DEFAULT_ENUMERATIONS);
        assertThat(testFootnoteMaster.getDefinition()).isEqualTo(DEFAULT_DEFINITION);
    }

    @Test
    void getAllFootnoteMasters() {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        // Get all the footnoteMasterList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=footnotesId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].footnotesId")
            .value(hasItem(footnoteMaster.getFootnotesId().intValue()))
            .jsonPath("$.[*].enumerations")
            .value(hasItem(DEFAULT_ENUMERATIONS))
            .jsonPath("$.[*].definition")
            .value(hasItem(DEFAULT_DEFINITION));
    }

    @Test
    void getFootnoteMaster() {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        // Get the footnoteMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, footnoteMaster.getFootnotesId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.footnotesId")
            .value(is(footnoteMaster.getFootnotesId().intValue()))
            .jsonPath("$.enumerations")
            .value(is(DEFAULT_ENUMERATIONS))
            .jsonPath("$.definition")
            .value(is(DEFAULT_DEFINITION));
    }

    @Test
    void getNonExistingFootnoteMaster() {
        // Get the footnoteMaster
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewFootnoteMaster() throws Exception {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();

        // Update the footnoteMaster
        FootnoteMaster updatedFootnoteMaster = footnoteMasterRepository.findById(footnoteMaster.getFootnotesId()).block();
        updatedFootnoteMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedFootnoteMaster.getFootnotesId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedFootnoteMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
        FootnoteMaster testFootnoteMaster = footnoteMasterList.get(footnoteMasterList.size() - 1);
        assertThat(testFootnoteMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testFootnoteMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void putNonExistingFootnoteMaster() throws Exception {
        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();
        footnoteMaster.setFootnotesId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, footnoteMaster.getFootnotesId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchFootnoteMaster() throws Exception {
        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();
        footnoteMaster.setFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamFootnoteMaster() throws Exception {
        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();
        footnoteMaster.setFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateFootnoteMasterWithPatch() throws Exception {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();

        // Update the footnoteMaster using partial update
        FootnoteMaster partialUpdatedFootnoteMaster = new FootnoteMaster();
        partialUpdatedFootnoteMaster.setFootnotesId(footnoteMaster.getFootnotesId());

        partialUpdatedFootnoteMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFootnoteMaster.getFootnotesId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFootnoteMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
        FootnoteMaster testFootnoteMaster = footnoteMasterList.get(footnoteMasterList.size() - 1);
        assertThat(testFootnoteMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testFootnoteMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void fullUpdateFootnoteMasterWithPatch() throws Exception {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();

        // Update the footnoteMaster using partial update
        FootnoteMaster partialUpdatedFootnoteMaster = new FootnoteMaster();
        partialUpdatedFootnoteMaster.setFootnotesId(footnoteMaster.getFootnotesId());

        partialUpdatedFootnoteMaster.enumerations(UPDATED_ENUMERATIONS).definition(UPDATED_DEFINITION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFootnoteMaster.getFootnotesId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFootnoteMaster))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
        FootnoteMaster testFootnoteMaster = footnoteMasterList.get(footnoteMasterList.size() - 1);
        assertThat(testFootnoteMaster.getEnumerations()).isEqualTo(UPDATED_ENUMERATIONS);
        assertThat(testFootnoteMaster.getDefinition()).isEqualTo(UPDATED_DEFINITION);
    }

    @Test
    void patchNonExistingFootnoteMaster() throws Exception {
        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();
        footnoteMaster.setFootnotesId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, footnoteMaster.getFootnotesId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchFootnoteMaster() throws Exception {
        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();
        footnoteMaster.setFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamFootnoteMaster() throws Exception {
        int databaseSizeBeforeUpdate = footnoteMasterRepository.findAll().collectList().block().size();
        footnoteMaster.setFootnotesId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(footnoteMaster))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FootnoteMaster in the database
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteFootnoteMaster() {
        // Initialize the database
        footnoteMasterRepository.save(footnoteMaster).block();

        int databaseSizeBeforeDelete = footnoteMasterRepository.findAll().collectList().block().size();

        // Delete the footnoteMaster
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, footnoteMaster.getFootnotesId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<FootnoteMaster> footnoteMasterList = footnoteMasterRepository.findAll().collectList().block();
        assertThat(footnoteMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
