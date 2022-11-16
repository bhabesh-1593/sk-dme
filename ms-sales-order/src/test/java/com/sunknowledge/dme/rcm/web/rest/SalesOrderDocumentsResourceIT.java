package com.sunknowledge.dme.rcm.web.rest;

import static com.sunknowledge.dme.rcm.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.SalesOrderDocuments;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.SalesOrderDocumentsRepository;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Integration tests for the {@link SalesOrderDocumentsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class SalesOrderDocumentsResourceIT {

    private static final Integer DEFAULT_PATIENT_ID = 1;
    private static final Integer UPDATED_PATIENT_ID = 2;

    private static final String DEFAULT_PATIENT_NAME = "Fyhdh0";
    private static final String UPDATED_PATIENT_NAME = "Ildlty3";

    private static final LocalDate DEFAULT_PATIENT_DOB = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PATIENT_DOB = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_PATIENT_DOD = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PATIENT_DOD = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PATIENT_SSN = "AAAAAAAAAA";
    private static final String UPDATED_PATIENT_SSN = "BBBBBBBBBB";

    private static final String DEFAULT_QMB_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_QMB_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PATIENT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_PATIENT_GENDER = "BBBBBBBBBB";

    private static final Integer DEFAULT_PATIENT_HEIGHT = 1;
    private static final Integer UPDATED_PATIENT_HEIGHT = 2;

    private static final Integer DEFAULT_PATIENT_WEIGHT = 1;
    private static final Integer UPDATED_PATIENT_WEIGHT = 2;

    private static final String DEFAULT_PATIENT_CONTACT_1 = "AAAAAAAAAA";
    private static final String UPDATED_PATIENT_CONTACT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_PATIENT_CONTACT_2 = "AAAAAAAAAA";
    private static final String UPDATED_PATIENT_CONTACT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_HIPAA_ON_FILE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_HIPAA_ON_FILE_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_BRANCH_ID = 1;
    private static final Integer UPDATED_BRANCH_ID = 2;

    private static final String DEFAULT_BRANCH_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BRANCH_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_DOCUMENT_TYPE_ID = 1;
    private static final Integer UPDATED_DOCUMENT_TYPE_ID = 2;

    private static final String DEFAULT_DOCUMENT_TYPE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_TYPE_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DOCUMENT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOCUMENT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DOCUMENT_NOTE = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_NOTE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SALES_ORDER_DOCUMENT_ID = 1;
    private static final Integer UPDATED_SALES_ORDER_DOCUMENT_ID = 2;

    private static final String DEFAULT_DOCUMENT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DOCUMENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DOCUMENT_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_SCAN_BY = 1;
    private static final Integer UPDATED_SCAN_BY = 2;

    private static final String DEFAULT_FILE_UPLOAD_PATH = "AAAAAAAAAA";
    private static final String UPDATED_FILE_UPLOAD_PATH = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_UPLOAD_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPLOAD_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPLOAD_BY = 1;
    private static final Integer UPDATED_UPLOAD_BY = 2;

    private static final LocalDate DEFAULT_SCAN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_SCAN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_REVIEW_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_REVIEW_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_REVIEW_REASON = "AAAAAAAAAA";
    private static final String UPDATED_REVIEW_REASON = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_REVIEW_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_REVIEW_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_REVIEW_BY = 1;
    private static final Integer UPDATED_REVIEW_BY = 2;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_CREATED_BY_ID = 1;
    private static final Integer UPDATED_CREATED_BY_ID = 2;

    private static final String DEFAULT_CREATED_BY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY_NAME = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Integer DEFAULT_UPDATED_BY_ID = 1;
    private static final Integer UPDATED_UPDATED_BY_ID = 2;

    private static final String DEFAULT_UPDATED_BY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY_NAME = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_UPDATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_UPDATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String ENTITY_API_URL = "/api/sales-order-documents";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SalesOrderDocumentsRepository salesOrderDocumentsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private SalesOrderDocuments salesOrderDocuments;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
//    public static SalesOrderDocuments createEntity(EntityManager em) {
//        SalesOrderDocuments salesOrderDocuments = new SalesOrderDocuments()
//            .patientId(DEFAULT_PATIENT_ID)
//            .patientName(DEFAULT_PATIENT_NAME)
//            .patientDob(DEFAULT_PATIENT_DOB)
//            .patientDod(DEFAULT_PATIENT_DOD)
//            .patientSsn(DEFAULT_PATIENT_SSN)
//            .qmbStatus(DEFAULT_QMB_STATUS)
//            .patientGender(DEFAULT_PATIENT_GENDER)
//            .patientHeight(DEFAULT_PATIENT_HEIGHT)
//            .patientWeight(DEFAULT_PATIENT_WEIGHT)
//            .patientContact1(DEFAULT_PATIENT_CONTACT_1)
//            .patientContact2(DEFAULT_PATIENT_CONTACT_2)
//            .email(DEFAULT_EMAIL)
//            .fax(DEFAULT_FAX)
//            .hipaaOnFileStatus(DEFAULT_HIPAA_ON_FILE_STATUS)
//            .branchId(DEFAULT_BRANCH_ID)
//            .branchName(DEFAULT_BRANCH_NAME)
//            .documentTypeId(DEFAULT_DOCUMENT_TYPE_ID)
//            .documentTypeName(DEFAULT_DOCUMENT_TYPE_NAME)
//            .documentDate(DEFAULT_DOCUMENT_DATE)
//            .documentNote(DEFAULT_DOCUMENT_NOTE)
//            .salesOrderDocumentId(DEFAULT_SALES_ORDER_DOCUMENT_ID)
//            .documentTitle(DEFAULT_DOCUMENT_TITLE)
//            .documentName(DEFAULT_DOCUMENT_NAME)
//            .scanBy(DEFAULT_SCAN_BY)
//            .fileUploadPath(DEFAULT_FILE_UPLOAD_PATH)
//            .uploadDate(DEFAULT_UPLOAD_DATE)
//            .uploadBy(DEFAULT_UPLOAD_BY)
//            .scanDate(DEFAULT_SCAN_DATE)
//            .reviewStatus(DEFAULT_REVIEW_STATUS)
//            .reviewReason(DEFAULT_REVIEW_REASON)
//            .reviewDate(DEFAULT_REVIEW_DATE)
//            .reviewBy(DEFAULT_REVIEW_BY)
//            .status(DEFAULT_STATUS)
//            .createdById(DEFAULT_CREATED_BY_ID)
//            .createdByName(DEFAULT_CREATED_BY_NAME)
//            .createdDate(DEFAULT_CREATED_DATE)
//            .updatedById(DEFAULT_UPDATED_BY_ID)
//            .updatedByName(DEFAULT_UPDATED_BY_NAME)
//            .updatedDate(DEFAULT_UPDATED_DATE);
//        return salesOrderDocuments;
//    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
//    public static SalesOrderDocuments createUpdatedEntity(EntityManager em) {
//        SalesOrderDocuments salesOrderDocuments = new SalesOrderDocuments()
//            .patientId(UPDATED_PATIENT_ID)
//            .patientName(UPDATED_PATIENT_NAME)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .qmbStatus(UPDATED_QMB_STATUS)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientWeight(UPDATED_PATIENT_WEIGHT)
//            .patientContact1(UPDATED_PATIENT_CONTACT_1)
//            .patientContact2(UPDATED_PATIENT_CONTACT_2)
//            .email(UPDATED_EMAIL)
//            .fax(UPDATED_FAX)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .branchId(UPDATED_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .documentTypeId(UPDATED_DOCUMENT_TYPE_ID)
//            .documentTypeName(UPDATED_DOCUMENT_TYPE_NAME)
//            .documentDate(UPDATED_DOCUMENT_DATE)
//            .documentNote(UPDATED_DOCUMENT_NOTE)
//            .salesOrderDocumentId(UPDATED_SALES_ORDER_DOCUMENT_ID)
//            .documentTitle(UPDATED_DOCUMENT_TITLE)
//            .documentName(UPDATED_DOCUMENT_NAME)
//            .scanBy(UPDATED_SCAN_BY)
//            .fileUploadPath(UPDATED_FILE_UPLOAD_PATH)
//            .uploadDate(UPDATED_UPLOAD_DATE)
//            .uploadBy(UPDATED_UPLOAD_BY)
//            .scanDate(UPDATED_SCAN_DATE)
//            .reviewStatus(UPDATED_REVIEW_STATUS)
//            .reviewReason(UPDATED_REVIEW_REASON)
//            .reviewDate(UPDATED_REVIEW_DATE)
//            .reviewBy(UPDATED_REVIEW_BY)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//        return salesOrderDocuments;
//    }
//
//    public static void deleteEntities(EntityManager em) {
//        try {
//            em.deleteAll(SalesOrderDocuments.class).block();
//        } catch (Exception e) {
//            // It can fail, if other entities are still referring this - it will be removed later.
//        }
//    }
//
//    @AfterEach
//    public void cleanup() {
//        deleteEntities(em);
//    }
//
//    @BeforeEach
//    public void setupCsrf() {
//        webTestClient = webTestClient.mutateWith(csrf());
//    }
//
//    @BeforeEach
//    public void initTest() {
//        deleteEntities(em);
//        salesOrderDocuments = createEntity(em);
//    }
//
//    @Test
//    void createSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeCreate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // Create the SalesOrderDocuments
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isCreated();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeCreate + 1);
//        SalesOrderDocuments testSalesOrderDocuments = salesOrderDocumentsList.get(salesOrderDocumentsList.size() - 1);
//        assertThat(testSalesOrderDocuments.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderDocuments.getPatientName()).isEqualTo(DEFAULT_PATIENT_NAME);
//        assertThat(testSalesOrderDocuments.getPatientDob()).isEqualTo(DEFAULT_PATIENT_DOB);
//        assertThat(testSalesOrderDocuments.getPatientDod()).isEqualTo(DEFAULT_PATIENT_DOD);
//        assertThat(testSalesOrderDocuments.getPatientSsn()).isEqualTo(DEFAULT_PATIENT_SSN);
//        assertThat(testSalesOrderDocuments.getQmbStatus()).isEqualTo(DEFAULT_QMB_STATUS);
//        assertThat(testSalesOrderDocuments.getPatientGender()).isEqualTo(DEFAULT_PATIENT_GENDER);
//        assertThat(testSalesOrderDocuments.getPatientHeight()).isEqualTo(DEFAULT_PATIENT_HEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientWeight()).isEqualTo(DEFAULT_PATIENT_WEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientContact1()).isEqualTo(DEFAULT_PATIENT_CONTACT_1);
//        assertThat(testSalesOrderDocuments.getPatientContact2()).isEqualTo(DEFAULT_PATIENT_CONTACT_2);
//        assertThat(testSalesOrderDocuments.getEmail()).isEqualTo(DEFAULT_EMAIL);
//        assertThat(testSalesOrderDocuments.getFax()).isEqualTo(DEFAULT_FAX);
//        assertThat(testSalesOrderDocuments.getHipaaOnFileStatus()).isEqualTo(DEFAULT_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderDocuments.getBranchId()).isEqualTo(DEFAULT_BRANCH_ID);
//        assertThat(testSalesOrderDocuments.getBranchName()).isEqualTo(DEFAULT_BRANCH_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentTypeId()).isEqualTo(DEFAULT_DOCUMENT_TYPE_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTypeName()).isEqualTo(DEFAULT_DOCUMENT_TYPE_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentDate()).isEqualTo(DEFAULT_DOCUMENT_DATE);
//        assertThat(testSalesOrderDocuments.getDocumentNote()).isEqualTo(DEFAULT_DOCUMENT_NOTE);
//        assertThat(testSalesOrderDocuments.getSalesOrderDocumentId()).isEqualTo(DEFAULT_SALES_ORDER_DOCUMENT_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTitle()).isEqualTo(DEFAULT_DOCUMENT_TITLE);
//        assertThat(testSalesOrderDocuments.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
//        assertThat(testSalesOrderDocuments.getScanBy()).isEqualTo(DEFAULT_SCAN_BY);
//        assertThat(testSalesOrderDocuments.getFileUploadPath()).isEqualTo(DEFAULT_FILE_UPLOAD_PATH);
//        assertThat(testSalesOrderDocuments.getUploadDate()).isEqualTo(DEFAULT_UPLOAD_DATE);
//        assertThat(testSalesOrderDocuments.getUploadBy()).isEqualTo(DEFAULT_UPLOAD_BY);
//        assertThat(testSalesOrderDocuments.getScanDate()).isEqualTo(DEFAULT_SCAN_DATE);
//        assertThat(testSalesOrderDocuments.getReviewStatus()).isEqualTo(DEFAULT_REVIEW_STATUS);
//        assertThat(testSalesOrderDocuments.getReviewReason()).isEqualTo(DEFAULT_REVIEW_REASON);
//        assertThat(testSalesOrderDocuments.getReviewDate()).isEqualTo(DEFAULT_REVIEW_DATE);
//        assertThat(testSalesOrderDocuments.getReviewBy()).isEqualTo(DEFAULT_REVIEW_BY);
//        assertThat(testSalesOrderDocuments.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderDocuments.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderDocuments.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void createSalesOrderDocumentsWithExistingId() throws Exception {
//        // Create the SalesOrderDocuments with an existing ID
//        salesOrderDocuments.setId(1L);
//
//        int databaseSizeBeforeCreate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//
//        // An entity with an existing ID cannot be created, so this API call must fail
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeCreate);
//    }
//
//    @Test
//    void checkPatientIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientId(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientName(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientDobIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientDob(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientSsnIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientSsn(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientGenderIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientGender(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientHeightIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientHeight(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientWeightIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientWeight(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientContact1IsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setPatientContact1(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkHipaaOnFileStatusIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setHipaaOnFileStatus(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkBranchIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setBranchId(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkBranchNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderDocuments.setBranchName(null);
//
//        // Create the SalesOrderDocuments, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void getAllSalesOrderDocumentsAsStream() {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        List<SalesOrderDocuments> salesOrderDocumentsList = webTestClient
//            .get()
//            .uri(ENTITY_API_URL)
//            .accept(MediaType.APPLICATION_NDJSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
//            .returnResult(SalesOrderDocuments.class)
//            .getResponseBody()
//            .filter(salesOrderDocuments::equals)
//            .collectList()
//            .block(Duration.ofSeconds(5));
//
//        assertThat(salesOrderDocumentsList).isNotNull();
//        assertThat(salesOrderDocumentsList).hasSize(1);
//        SalesOrderDocuments testSalesOrderDocuments = salesOrderDocumentsList.get(0);
//        assertThat(testSalesOrderDocuments.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderDocuments.getPatientName()).isEqualTo(DEFAULT_PATIENT_NAME);
//        assertThat(testSalesOrderDocuments.getPatientDob()).isEqualTo(DEFAULT_PATIENT_DOB);
//        assertThat(testSalesOrderDocuments.getPatientDod()).isEqualTo(DEFAULT_PATIENT_DOD);
//        assertThat(testSalesOrderDocuments.getPatientSsn()).isEqualTo(DEFAULT_PATIENT_SSN);
//        assertThat(testSalesOrderDocuments.getQmbStatus()).isEqualTo(DEFAULT_QMB_STATUS);
//        assertThat(testSalesOrderDocuments.getPatientGender()).isEqualTo(DEFAULT_PATIENT_GENDER);
//        assertThat(testSalesOrderDocuments.getPatientHeight()).isEqualTo(DEFAULT_PATIENT_HEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientWeight()).isEqualTo(DEFAULT_PATIENT_WEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientContact1()).isEqualTo(DEFAULT_PATIENT_CONTACT_1);
//        assertThat(testSalesOrderDocuments.getPatientContact2()).isEqualTo(DEFAULT_PATIENT_CONTACT_2);
//        assertThat(testSalesOrderDocuments.getEmail()).isEqualTo(DEFAULT_EMAIL);
//        assertThat(testSalesOrderDocuments.getFax()).isEqualTo(DEFAULT_FAX);
//        assertThat(testSalesOrderDocuments.getHipaaOnFileStatus()).isEqualTo(DEFAULT_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderDocuments.getBranchId()).isEqualTo(DEFAULT_BRANCH_ID);
//        assertThat(testSalesOrderDocuments.getBranchName()).isEqualTo(DEFAULT_BRANCH_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentTypeId()).isEqualTo(DEFAULT_DOCUMENT_TYPE_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTypeName()).isEqualTo(DEFAULT_DOCUMENT_TYPE_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentDate()).isEqualTo(DEFAULT_DOCUMENT_DATE);
//        assertThat(testSalesOrderDocuments.getDocumentNote()).isEqualTo(DEFAULT_DOCUMENT_NOTE);
//        assertThat(testSalesOrderDocuments.getSalesOrderDocumentId()).isEqualTo(DEFAULT_SALES_ORDER_DOCUMENT_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTitle()).isEqualTo(DEFAULT_DOCUMENT_TITLE);
//        assertThat(testSalesOrderDocuments.getDocumentName()).isEqualTo(DEFAULT_DOCUMENT_NAME);
//        assertThat(testSalesOrderDocuments.getScanBy()).isEqualTo(DEFAULT_SCAN_BY);
//        assertThat(testSalesOrderDocuments.getFileUploadPath()).isEqualTo(DEFAULT_FILE_UPLOAD_PATH);
//        assertThat(testSalesOrderDocuments.getUploadDate()).isEqualTo(DEFAULT_UPLOAD_DATE);
//        assertThat(testSalesOrderDocuments.getUploadBy()).isEqualTo(DEFAULT_UPLOAD_BY);
//        assertThat(testSalesOrderDocuments.getScanDate()).isEqualTo(DEFAULT_SCAN_DATE);
//        assertThat(testSalesOrderDocuments.getReviewStatus()).isEqualTo(DEFAULT_REVIEW_STATUS);
//        assertThat(testSalesOrderDocuments.getReviewReason()).isEqualTo(DEFAULT_REVIEW_REASON);
//        assertThat(testSalesOrderDocuments.getReviewDate()).isEqualTo(DEFAULT_REVIEW_DATE);
//        assertThat(testSalesOrderDocuments.getReviewBy()).isEqualTo(DEFAULT_REVIEW_BY);
//        assertThat(testSalesOrderDocuments.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderDocuments.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderDocuments.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void getAllSalesOrderDocuments() {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        // Get all the salesOrderDocumentsList
//        webTestClient
//            .get()
//            .uri(ENTITY_API_URL + "?sort=id,desc")
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentType(MediaType.APPLICATION_JSON)
//            .expectBody()
//            .jsonPath("$.[*].id")
//            .value(hasItem(salesOrderDocuments.getId().intValue()))
//            .jsonPath("$.[*].patientId")
//            .value(hasItem(DEFAULT_PATIENT_ID))
//            .jsonPath("$.[*].patientName")
//            .value(hasItem(DEFAULT_PATIENT_NAME))
//            .jsonPath("$.[*].patientDob")
//            .value(hasItem(DEFAULT_PATIENT_DOB.toString()))
//            .jsonPath("$.[*].patientDod")
//            .value(hasItem(DEFAULT_PATIENT_DOD.toString()))
//            .jsonPath("$.[*].patientSsn")
//            .value(hasItem(DEFAULT_PATIENT_SSN))
//            .jsonPath("$.[*].qmbStatus")
//            .value(hasItem(DEFAULT_QMB_STATUS))
//            .jsonPath("$.[*].patientGender")
//            .value(hasItem(DEFAULT_PATIENT_GENDER))
//            .jsonPath("$.[*].patientHeight")
//            .value(hasItem(DEFAULT_PATIENT_HEIGHT))
//            .jsonPath("$.[*].patientWeight")
//            .value(hasItem(DEFAULT_PATIENT_WEIGHT))
//            .jsonPath("$.[*].patientContact1")
//            .value(hasItem(DEFAULT_PATIENT_CONTACT_1))
//            .jsonPath("$.[*].patientContact2")
//            .value(hasItem(DEFAULT_PATIENT_CONTACT_2))
//            .jsonPath("$.[*].email")
//            .value(hasItem(DEFAULT_EMAIL))
//            .jsonPath("$.[*].fax")
//            .value(hasItem(DEFAULT_FAX))
//            .jsonPath("$.[*].hipaaOnFileStatus")
//            .value(hasItem(DEFAULT_HIPAA_ON_FILE_STATUS))
//            .jsonPath("$.[*].branchId")
//            .value(hasItem(DEFAULT_BRANCH_ID))
//            .jsonPath("$.[*].branchName")
//            .value(hasItem(DEFAULT_BRANCH_NAME))
//            .jsonPath("$.[*].documentTypeId")
//            .value(hasItem(DEFAULT_DOCUMENT_TYPE_ID))
//            .jsonPath("$.[*].documentTypeName")
//            .value(hasItem(DEFAULT_DOCUMENT_TYPE_NAME))
//            .jsonPath("$.[*].documentDate")
//            .value(hasItem(DEFAULT_DOCUMENT_DATE.toString()))
//            .jsonPath("$.[*].documentNote")
//            .value(hasItem(DEFAULT_DOCUMENT_NOTE))
//            .jsonPath("$.[*].salesOrderDocumentId")
//            .value(hasItem(DEFAULT_SALES_ORDER_DOCUMENT_ID))
//            .jsonPath("$.[*].documentTitle")
//            .value(hasItem(DEFAULT_DOCUMENT_TITLE))
//            .jsonPath("$.[*].documentName")
//            .value(hasItem(DEFAULT_DOCUMENT_NAME))
//            .jsonPath("$.[*].scanBy")
//            .value(hasItem(DEFAULT_SCAN_BY))
//            .jsonPath("$.[*].fileUploadPath")
//            .value(hasItem(DEFAULT_FILE_UPLOAD_PATH))
//            .jsonPath("$.[*].uploadDate")
//            .value(hasItem(DEFAULT_UPLOAD_DATE.toString()))
//            .jsonPath("$.[*].uploadBy")
//            .value(hasItem(DEFAULT_UPLOAD_BY))
//            .jsonPath("$.[*].scanDate")
//            .value(hasItem(DEFAULT_SCAN_DATE.toString()))
//            .jsonPath("$.[*].reviewStatus")
//            .value(hasItem(DEFAULT_REVIEW_STATUS))
//            .jsonPath("$.[*].reviewReason")
//            .value(hasItem(DEFAULT_REVIEW_REASON))
//            .jsonPath("$.[*].reviewDate")
//            .value(hasItem(DEFAULT_REVIEW_DATE.toString()))
//            .jsonPath("$.[*].reviewBy")
//            .value(hasItem(DEFAULT_REVIEW_BY))
//            .jsonPath("$.[*].status")
//            .value(hasItem(DEFAULT_STATUS))
//            .jsonPath("$.[*].createdById")
//            .value(hasItem(DEFAULT_CREATED_BY_ID))
//            .jsonPath("$.[*].createdByName")
//            .value(hasItem(DEFAULT_CREATED_BY_NAME))
//            .jsonPath("$.[*].createdDate")
//            .value(hasItem(sameInstant(DEFAULT_CREATED_DATE)))
//            .jsonPath("$.[*].updatedById")
//            .value(hasItem(DEFAULT_UPDATED_BY_ID))
//            .jsonPath("$.[*].updatedByName")
//            .value(hasItem(DEFAULT_UPDATED_BY_NAME))
//            .jsonPath("$.[*].updatedDate")
//            .value(hasItem(sameInstant(DEFAULT_UPDATED_DATE)));
//    }
//
//    @Test
//    void getSalesOrderDocuments() {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        // Get the salesOrderDocuments
//        webTestClient
//            .get()
//            .uri(ENTITY_API_URL_ID, salesOrderDocuments.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentType(MediaType.APPLICATION_JSON)
//            .expectBody()
//            .jsonPath("$.id")
//            .value(is(salesOrderDocuments.getId().intValue()))
//            .jsonPath("$.patientId")
//            .value(is(DEFAULT_PATIENT_ID))
//            .jsonPath("$.patientName")
//            .value(is(DEFAULT_PATIENT_NAME))
//            .jsonPath("$.patientDob")
//            .value(is(DEFAULT_PATIENT_DOB.toString()))
//            .jsonPath("$.patientDod")
//            .value(is(DEFAULT_PATIENT_DOD.toString()))
//            .jsonPath("$.patientSsn")
//            .value(is(DEFAULT_PATIENT_SSN))
//            .jsonPath("$.qmbStatus")
//            .value(is(DEFAULT_QMB_STATUS))
//            .jsonPath("$.patientGender")
//            .value(is(DEFAULT_PATIENT_GENDER))
//            .jsonPath("$.patientHeight")
//            .value(is(DEFAULT_PATIENT_HEIGHT))
//            .jsonPath("$.patientWeight")
//            .value(is(DEFAULT_PATIENT_WEIGHT))
//            .jsonPath("$.patientContact1")
//            .value(is(DEFAULT_PATIENT_CONTACT_1))
//            .jsonPath("$.patientContact2")
//            .value(is(DEFAULT_PATIENT_CONTACT_2))
//            .jsonPath("$.email")
//            .value(is(DEFAULT_EMAIL))
//            .jsonPath("$.fax")
//            .value(is(DEFAULT_FAX))
//            .jsonPath("$.hipaaOnFileStatus")
//            .value(is(DEFAULT_HIPAA_ON_FILE_STATUS))
//            .jsonPath("$.branchId")
//            .value(is(DEFAULT_BRANCH_ID))
//            .jsonPath("$.branchName")
//            .value(is(DEFAULT_BRANCH_NAME))
//            .jsonPath("$.documentTypeId")
//            .value(is(DEFAULT_DOCUMENT_TYPE_ID))
//            .jsonPath("$.documentTypeName")
//            .value(is(DEFAULT_DOCUMENT_TYPE_NAME))
//            .jsonPath("$.documentDate")
//            .value(is(DEFAULT_DOCUMENT_DATE.toString()))
//            .jsonPath("$.documentNote")
//            .value(is(DEFAULT_DOCUMENT_NOTE))
//            .jsonPath("$.salesOrderDocumentId")
//            .value(is(DEFAULT_SALES_ORDER_DOCUMENT_ID))
//            .jsonPath("$.documentTitle")
//            .value(is(DEFAULT_DOCUMENT_TITLE))
//            .jsonPath("$.documentName")
//            .value(is(DEFAULT_DOCUMENT_NAME))
//            .jsonPath("$.scanBy")
//            .value(is(DEFAULT_SCAN_BY))
//            .jsonPath("$.fileUploadPath")
//            .value(is(DEFAULT_FILE_UPLOAD_PATH))
//            .jsonPath("$.uploadDate")
//            .value(is(DEFAULT_UPLOAD_DATE.toString()))
//            .jsonPath("$.uploadBy")
//            .value(is(DEFAULT_UPLOAD_BY))
//            .jsonPath("$.scanDate")
//            .value(is(DEFAULT_SCAN_DATE.toString()))
//            .jsonPath("$.reviewStatus")
//            .value(is(DEFAULT_REVIEW_STATUS))
//            .jsonPath("$.reviewReason")
//            .value(is(DEFAULT_REVIEW_REASON))
//            .jsonPath("$.reviewDate")
//            .value(is(DEFAULT_REVIEW_DATE.toString()))
//            .jsonPath("$.reviewBy")
//            .value(is(DEFAULT_REVIEW_BY))
//            .jsonPath("$.status")
//            .value(is(DEFAULT_STATUS))
//            .jsonPath("$.createdById")
//            .value(is(DEFAULT_CREATED_BY_ID))
//            .jsonPath("$.createdByName")
//            .value(is(DEFAULT_CREATED_BY_NAME))
//            .jsonPath("$.createdDate")
//            .value(is(sameInstant(DEFAULT_CREATED_DATE)))
//            .jsonPath("$.updatedById")
//            .value(is(DEFAULT_UPDATED_BY_ID))
//            .jsonPath("$.updatedByName")
//            .value(is(DEFAULT_UPDATED_BY_NAME))
//            .jsonPath("$.updatedDate")
//            .value(is(sameInstant(DEFAULT_UPDATED_DATE)));
//    }
//
//    @Test
//    void getNonExistingSalesOrderDocuments() {
//        // Get the salesOrderDocuments
//        webTestClient
//            .get()
//            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isNotFound();
//    }
//
//    @Test
//    void putNewSalesOrderDocuments() throws Exception {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderDocuments
//        SalesOrderDocuments updatedSalesOrderDocuments = salesOrderDocumentsRepository.findById(salesOrderDocuments.getId()).block();
//        updatedSalesOrderDocuments
//            .patientId(UPDATED_PATIENT_ID)
//            .patientName(UPDATED_PATIENT_NAME)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .qmbStatus(UPDATED_QMB_STATUS)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientWeight(UPDATED_PATIENT_WEIGHT)
//            .patientContact1(UPDATED_PATIENT_CONTACT_1)
//            .patientContact2(UPDATED_PATIENT_CONTACT_2)
//            .email(UPDATED_EMAIL)
//            .fax(UPDATED_FAX)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .branchId(UPDATED_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .documentTypeId(UPDATED_DOCUMENT_TYPE_ID)
//            .documentTypeName(UPDATED_DOCUMENT_TYPE_NAME)
//            .documentDate(UPDATED_DOCUMENT_DATE)
//            .documentNote(UPDATED_DOCUMENT_NOTE)
//            .salesOrderDocumentId(UPDATED_SALES_ORDER_DOCUMENT_ID)
//            .documentTitle(UPDATED_DOCUMENT_TITLE)
//            .documentName(UPDATED_DOCUMENT_NAME)
//            .scanBy(UPDATED_SCAN_BY)
//            .fileUploadPath(UPDATED_FILE_UPLOAD_PATH)
//            .uploadDate(UPDATED_UPLOAD_DATE)
//            .uploadBy(UPDATED_UPLOAD_BY)
//            .scanDate(UPDATED_SCAN_DATE)
//            .reviewStatus(UPDATED_REVIEW_STATUS)
//            .reviewReason(UPDATED_REVIEW_REASON)
//            .reviewDate(UPDATED_REVIEW_DATE)
//            .reviewBy(UPDATED_REVIEW_BY)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, updatedSalesOrderDocuments.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedSalesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderDocuments testSalesOrderDocuments = salesOrderDocumentsList.get(salesOrderDocumentsList.size() - 1);
//        assertThat(testSalesOrderDocuments.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderDocuments.getPatientName()).isEqualTo(UPDATED_PATIENT_NAME);
//        assertThat(testSalesOrderDocuments.getPatientDob()).isEqualTo(UPDATED_PATIENT_DOB);
//        assertThat(testSalesOrderDocuments.getPatientDod()).isEqualTo(UPDATED_PATIENT_DOD);
//        assertThat(testSalesOrderDocuments.getPatientSsn()).isEqualTo(UPDATED_PATIENT_SSN);
//        assertThat(testSalesOrderDocuments.getQmbStatus()).isEqualTo(UPDATED_QMB_STATUS);
//        assertThat(testSalesOrderDocuments.getPatientGender()).isEqualTo(UPDATED_PATIENT_GENDER);
//        assertThat(testSalesOrderDocuments.getPatientHeight()).isEqualTo(UPDATED_PATIENT_HEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientWeight()).isEqualTo(UPDATED_PATIENT_WEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientContact1()).isEqualTo(UPDATED_PATIENT_CONTACT_1);
//        assertThat(testSalesOrderDocuments.getPatientContact2()).isEqualTo(UPDATED_PATIENT_CONTACT_2);
//        assertThat(testSalesOrderDocuments.getEmail()).isEqualTo(UPDATED_EMAIL);
//        assertThat(testSalesOrderDocuments.getFax()).isEqualTo(UPDATED_FAX);
//        assertThat(testSalesOrderDocuments.getHipaaOnFileStatus()).isEqualTo(UPDATED_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderDocuments.getBranchId()).isEqualTo(UPDATED_BRANCH_ID);
//        assertThat(testSalesOrderDocuments.getBranchName()).isEqualTo(UPDATED_BRANCH_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentTypeId()).isEqualTo(UPDATED_DOCUMENT_TYPE_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTypeName()).isEqualTo(UPDATED_DOCUMENT_TYPE_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentDate()).isEqualTo(UPDATED_DOCUMENT_DATE);
//        assertThat(testSalesOrderDocuments.getDocumentNote()).isEqualTo(UPDATED_DOCUMENT_NOTE);
//        assertThat(testSalesOrderDocuments.getSalesOrderDocumentId()).isEqualTo(UPDATED_SALES_ORDER_DOCUMENT_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTitle()).isEqualTo(UPDATED_DOCUMENT_TITLE);
//        assertThat(testSalesOrderDocuments.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
//        assertThat(testSalesOrderDocuments.getScanBy()).isEqualTo(UPDATED_SCAN_BY);
//        assertThat(testSalesOrderDocuments.getFileUploadPath()).isEqualTo(UPDATED_FILE_UPLOAD_PATH);
//        assertThat(testSalesOrderDocuments.getUploadDate()).isEqualTo(UPDATED_UPLOAD_DATE);
//        assertThat(testSalesOrderDocuments.getUploadBy()).isEqualTo(UPDATED_UPLOAD_BY);
//        assertThat(testSalesOrderDocuments.getScanDate()).isEqualTo(UPDATED_SCAN_DATE);
//        assertThat(testSalesOrderDocuments.getReviewStatus()).isEqualTo(UPDATED_REVIEW_STATUS);
//        assertThat(testSalesOrderDocuments.getReviewReason()).isEqualTo(UPDATED_REVIEW_REASON);
//        assertThat(testSalesOrderDocuments.getReviewDate()).isEqualTo(UPDATED_REVIEW_DATE);
//        assertThat(testSalesOrderDocuments.getReviewBy()).isEqualTo(UPDATED_REVIEW_BY);
//        assertThat(testSalesOrderDocuments.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderDocuments.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderDocuments.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void putNonExistingSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        salesOrderDocuments.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, salesOrderDocuments.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithIdMismatchSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        salesOrderDocuments.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithMissingIdPathParamSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        salesOrderDocuments.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void partialUpdateSalesOrderDocumentsWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderDocuments using partial update
//        SalesOrderDocuments partialUpdatedSalesOrderDocuments = new SalesOrderDocuments();
//        partialUpdatedSalesOrderDocuments.setId(salesOrderDocuments.getId());
//
//        partialUpdatedSalesOrderDocuments
//            .patientId(UPDATED_PATIENT_ID)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .qmbStatus(UPDATED_QMB_STATUS)
//            .email(UPDATED_EMAIL)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .branchId(UPDATED_BRANCH_ID)
//            .documentTypeName(UPDATED_DOCUMENT_TYPE_NAME)
//            .documentName(UPDATED_DOCUMENT_NAME)
//            .uploadBy(UPDATED_UPLOAD_BY)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME);
//
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderDocuments.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderDocuments testSalesOrderDocuments = salesOrderDocumentsList.get(salesOrderDocumentsList.size() - 1);
//        assertThat(testSalesOrderDocuments.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderDocuments.getPatientName()).isEqualTo(DEFAULT_PATIENT_NAME);
//        assertThat(testSalesOrderDocuments.getPatientDob()).isEqualTo(UPDATED_PATIENT_DOB);
//        assertThat(testSalesOrderDocuments.getPatientDod()).isEqualTo(UPDATED_PATIENT_DOD);
//        assertThat(testSalesOrderDocuments.getPatientSsn()).isEqualTo(UPDATED_PATIENT_SSN);
//        assertThat(testSalesOrderDocuments.getQmbStatus()).isEqualTo(UPDATED_QMB_STATUS);
//        assertThat(testSalesOrderDocuments.getPatientGender()).isEqualTo(DEFAULT_PATIENT_GENDER);
//        assertThat(testSalesOrderDocuments.getPatientHeight()).isEqualTo(DEFAULT_PATIENT_HEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientWeight()).isEqualTo(DEFAULT_PATIENT_WEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientContact1()).isEqualTo(DEFAULT_PATIENT_CONTACT_1);
//        assertThat(testSalesOrderDocuments.getPatientContact2()).isEqualTo(DEFAULT_PATIENT_CONTACT_2);
//        assertThat(testSalesOrderDocuments.getEmail()).isEqualTo(UPDATED_EMAIL);
//        assertThat(testSalesOrderDocuments.getFax()).isEqualTo(DEFAULT_FAX);
//        assertThat(testSalesOrderDocuments.getHipaaOnFileStatus()).isEqualTo(UPDATED_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderDocuments.getBranchId()).isEqualTo(UPDATED_BRANCH_ID);
//        assertThat(testSalesOrderDocuments.getBranchName()).isEqualTo(DEFAULT_BRANCH_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentTypeId()).isEqualTo(DEFAULT_DOCUMENT_TYPE_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTypeName()).isEqualTo(UPDATED_DOCUMENT_TYPE_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentDate()).isEqualTo(DEFAULT_DOCUMENT_DATE);
//        assertThat(testSalesOrderDocuments.getDocumentNote()).isEqualTo(DEFAULT_DOCUMENT_NOTE);
//        assertThat(testSalesOrderDocuments.getSalesOrderDocumentId()).isEqualTo(DEFAULT_SALES_ORDER_DOCUMENT_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTitle()).isEqualTo(DEFAULT_DOCUMENT_TITLE);
//        assertThat(testSalesOrderDocuments.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
//        assertThat(testSalesOrderDocuments.getScanBy()).isEqualTo(DEFAULT_SCAN_BY);
//        assertThat(testSalesOrderDocuments.getFileUploadPath()).isEqualTo(DEFAULT_FILE_UPLOAD_PATH);
//        assertThat(testSalesOrderDocuments.getUploadDate()).isEqualTo(DEFAULT_UPLOAD_DATE);
//        assertThat(testSalesOrderDocuments.getUploadBy()).isEqualTo(UPDATED_UPLOAD_BY);
//        assertThat(testSalesOrderDocuments.getScanDate()).isEqualTo(DEFAULT_SCAN_DATE);
//        assertThat(testSalesOrderDocuments.getReviewStatus()).isEqualTo(DEFAULT_REVIEW_STATUS);
//        assertThat(testSalesOrderDocuments.getReviewReason()).isEqualTo(DEFAULT_REVIEW_REASON);
//        assertThat(testSalesOrderDocuments.getReviewDate()).isEqualTo(DEFAULT_REVIEW_DATE);
//        assertThat(testSalesOrderDocuments.getReviewBy()).isEqualTo(DEFAULT_REVIEW_BY);
//        assertThat(testSalesOrderDocuments.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderDocuments.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderDocuments.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void fullUpdateSalesOrderDocumentsWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderDocuments using partial update
//        SalesOrderDocuments partialUpdatedSalesOrderDocuments = new SalesOrderDocuments();
//        partialUpdatedSalesOrderDocuments.setId(salesOrderDocuments.getId());
//
//        partialUpdatedSalesOrderDocuments
//            .patientId(UPDATED_PATIENT_ID)
//            .patientName(UPDATED_PATIENT_NAME)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .qmbStatus(UPDATED_QMB_STATUS)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientWeight(UPDATED_PATIENT_WEIGHT)
//            .patientContact1(UPDATED_PATIENT_CONTACT_1)
//            .patientContact2(UPDATED_PATIENT_CONTACT_2)
//            .email(UPDATED_EMAIL)
//            .fax(UPDATED_FAX)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .branchId(UPDATED_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .documentTypeId(UPDATED_DOCUMENT_TYPE_ID)
//            .documentTypeName(UPDATED_DOCUMENT_TYPE_NAME)
//            .documentDate(UPDATED_DOCUMENT_DATE)
//            .documentNote(UPDATED_DOCUMENT_NOTE)
//            .salesOrderDocumentId(UPDATED_SALES_ORDER_DOCUMENT_ID)
//            .documentTitle(UPDATED_DOCUMENT_TITLE)
//            .documentName(UPDATED_DOCUMENT_NAME)
//            .scanBy(UPDATED_SCAN_BY)
//            .fileUploadPath(UPDATED_FILE_UPLOAD_PATH)
//            .uploadDate(UPDATED_UPLOAD_DATE)
//            .uploadBy(UPDATED_UPLOAD_BY)
//            .scanDate(UPDATED_SCAN_DATE)
//            .reviewStatus(UPDATED_REVIEW_STATUS)
//            .reviewReason(UPDATED_REVIEW_REASON)
//            .reviewDate(UPDATED_REVIEW_DATE)
//            .reviewBy(UPDATED_REVIEW_BY)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderDocuments.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderDocuments testSalesOrderDocuments = salesOrderDocumentsList.get(salesOrderDocumentsList.size() - 1);
//        assertThat(testSalesOrderDocuments.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderDocuments.getPatientName()).isEqualTo(UPDATED_PATIENT_NAME);
//        assertThat(testSalesOrderDocuments.getPatientDob()).isEqualTo(UPDATED_PATIENT_DOB);
//        assertThat(testSalesOrderDocuments.getPatientDod()).isEqualTo(UPDATED_PATIENT_DOD);
//        assertThat(testSalesOrderDocuments.getPatientSsn()).isEqualTo(UPDATED_PATIENT_SSN);
//        assertThat(testSalesOrderDocuments.getQmbStatus()).isEqualTo(UPDATED_QMB_STATUS);
//        assertThat(testSalesOrderDocuments.getPatientGender()).isEqualTo(UPDATED_PATIENT_GENDER);
//        assertThat(testSalesOrderDocuments.getPatientHeight()).isEqualTo(UPDATED_PATIENT_HEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientWeight()).isEqualTo(UPDATED_PATIENT_WEIGHT);
//        assertThat(testSalesOrderDocuments.getPatientContact1()).isEqualTo(UPDATED_PATIENT_CONTACT_1);
//        assertThat(testSalesOrderDocuments.getPatientContact2()).isEqualTo(UPDATED_PATIENT_CONTACT_2);
//        assertThat(testSalesOrderDocuments.getEmail()).isEqualTo(UPDATED_EMAIL);
//        assertThat(testSalesOrderDocuments.getFax()).isEqualTo(UPDATED_FAX);
//        assertThat(testSalesOrderDocuments.getHipaaOnFileStatus()).isEqualTo(UPDATED_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderDocuments.getBranchId()).isEqualTo(UPDATED_BRANCH_ID);
//        assertThat(testSalesOrderDocuments.getBranchName()).isEqualTo(UPDATED_BRANCH_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentTypeId()).isEqualTo(UPDATED_DOCUMENT_TYPE_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTypeName()).isEqualTo(UPDATED_DOCUMENT_TYPE_NAME);
//        assertThat(testSalesOrderDocuments.getDocumentDate()).isEqualTo(UPDATED_DOCUMENT_DATE);
//        assertThat(testSalesOrderDocuments.getDocumentNote()).isEqualTo(UPDATED_DOCUMENT_NOTE);
//        assertThat(testSalesOrderDocuments.getSalesOrderDocumentId()).isEqualTo(UPDATED_SALES_ORDER_DOCUMENT_ID);
//        assertThat(testSalesOrderDocuments.getDocumentTitle()).isEqualTo(UPDATED_DOCUMENT_TITLE);
//        assertThat(testSalesOrderDocuments.getDocumentName()).isEqualTo(UPDATED_DOCUMENT_NAME);
//        assertThat(testSalesOrderDocuments.getScanBy()).isEqualTo(UPDATED_SCAN_BY);
//        assertThat(testSalesOrderDocuments.getFileUploadPath()).isEqualTo(UPDATED_FILE_UPLOAD_PATH);
//        assertThat(testSalesOrderDocuments.getUploadDate()).isEqualTo(UPDATED_UPLOAD_DATE);
//        assertThat(testSalesOrderDocuments.getUploadBy()).isEqualTo(UPDATED_UPLOAD_BY);
//        assertThat(testSalesOrderDocuments.getScanDate()).isEqualTo(UPDATED_SCAN_DATE);
//        assertThat(testSalesOrderDocuments.getReviewStatus()).isEqualTo(UPDATED_REVIEW_STATUS);
//        assertThat(testSalesOrderDocuments.getReviewReason()).isEqualTo(UPDATED_REVIEW_REASON);
//        assertThat(testSalesOrderDocuments.getReviewDate()).isEqualTo(UPDATED_REVIEW_DATE);
//        assertThat(testSalesOrderDocuments.getReviewBy()).isEqualTo(UPDATED_REVIEW_BY);
//        assertThat(testSalesOrderDocuments.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderDocuments.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderDocuments.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderDocuments.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderDocuments.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void patchNonExistingSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        salesOrderDocuments.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, salesOrderDocuments.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithIdMismatchSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        salesOrderDocuments.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithMissingIdPathParamSalesOrderDocuments() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderDocumentsRepository.findAll().collectList().block().size();
//        salesOrderDocuments.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderDocuments))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderDocuments in the database
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void deleteSalesOrderDocuments() {
//        // Initialize the database
//        salesOrderDocumentsRepository.save(salesOrderDocuments).block();
//
//        int databaseSizeBeforeDelete = salesOrderDocumentsRepository.findAll().collectList().block().size();
//
//        // Delete the salesOrderDocuments
//        webTestClient
//            .delete()
//            .uri(ENTITY_API_URL_ID, salesOrderDocuments.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isNoContent();
//
//        // Validate the database contains one less item
//        List<SalesOrderDocuments> salesOrderDocumentsList = salesOrderDocumentsRepository.findAll().collectList().block();
//        assertThat(salesOrderDocumentsList).hasSize(databaseSizeBeforeDelete - 1);
//    }
}
