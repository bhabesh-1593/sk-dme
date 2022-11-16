package com.sunknowledge.dme.rcm.web.rest;

import static com.sunknowledge.dme.rcm.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.SalesOrderFinancialDetails;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.SalesOrderFinancialDetailsRepository;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderFinancialDetailsDTO;
import com.sunknowledge.dme.rcm.service.mapper.SalesOrderFinancialDetailsMapper;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
 * Integration tests for the {@link SalesOrderFinancialDetailsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class SalesOrderFinancialDetailsResourceIT {

    private static final Long DEFAULT_SALES_ORDER_ID = 1L;
    private static final Long UPDATED_SALES_ORDER_ID = 2L;

    private static final Integer DEFAULT_PATIENT_ID = 1;
    private static final Integer UPDATED_PATIENT_ID = 2;

    private static final Long DEFAULT_ITEM_ID = 1L;
    private static final Long UPDATED_ITEM_ID = 2L;

    private static final String DEFAULT_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ITEM_PROC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_PROC_CODE = "BBBBBBBBBB";

    private static final Double DEFAULT_CHARGED_AMOUNT = 1D;
    private static final Double UPDATED_CHARGED_AMOUNT = 2D;

    private static final Double DEFAULT_ALLOWED_AMOUNT = 1D;
    private static final Double UPDATED_ALLOWED_AMOUNT = 2D;

    private static final Integer DEFAULT_PRIMARY_INSURER_ID = 1;
    private static final Integer UPDATED_PRIMARY_INSURER_ID = 2;

    private static final String DEFAULT_PRIMARY_INSURER_NAME = "Ibjq2";
    private static final String UPDATED_PRIMARY_INSURER_NAME = "Dtp0";

    private static final String DEFAULT_PRIMARY_INSURER_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PRIMARY_INSURER_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_PRIMARY_INSURER_COVERAGE_PERCENTAGE = 1;
    private static final Integer UPDATED_PRIMARY_INSURER_COVERAGE_PERCENTAGE = 2;

    private static final Double DEFAULT_PRIMARY_INSURER_COVERAGE_AMOUNT = 1D;
    private static final Double UPDATED_PRIMARY_INSURER_COVERAGE_AMOUNT = 2D;

    private static final Double DEFAULT_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT = 1D;
    private static final Double UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT = 2D;

    private static final Double DEFAULT_PRIMARY_INSURER_PAYMENT = 1D;
    private static final Double UPDATED_PRIMARY_INSURER_PAYMENT = 2D;

    private static final Double DEFAULT_PRIMARY_INSURER_BALANCE_AMOUNT = 1D;
    private static final Double UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT = 2D;

    private static final Integer DEFAULT_SECONDARY_INSURER_ID = 1;
    private static final Integer UPDATED_SECONDARY_INSURER_ID = 2;

    private static final String DEFAULT_SECONDARY_INSURER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SECONDARY_INSURER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SECONDARY_INSURER_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_SECONDARY_INSURER_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_SECONDARY_INSURER_COVERAGER_PERCENTAGE = 1;
    private static final Integer UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE = 2;

    private static final Double DEFAULT_SECONDARY_INSURER_COVERAGE_AMOUNT = 1D;
    private static final Double UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT = 2D;

    private static final Double DEFAULT_SECONDARY_INSURER_PAYMENT = 1D;
    private static final Double UPDATED_SECONDARY_INSURER_PAYMENT = 2D;

    private static final Double DEFAULT_SECONDARY_INSURER_BALANCE_AMOUNT = 1D;
    private static final Double UPDATED_SECONDARY_INSURER_BALANCE_AMOUNT = 2D;

    private static final Integer DEFAULT_TERTIARY_INSURER_ID = 1;
    private static final Integer UPDATED_TERTIARY_INSURER_ID = 2;

    private static final String DEFAULT_TERTIARY_INSURER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TERTIARY_INSURER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TERTIARY_INSURER_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_TERTIARY_INSURER_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_TERTIARY_INSURER_COVERAGE_PERCENTAGE = 1;
    private static final Integer UPDATED_TERTIARY_INSURER_COVERAGE_PERCENTAGE = 2;

    private static final Double DEFAULT_TERTIARY_INSURER_COVERAGE_AMOUNT = 1D;
    private static final Double UPDATED_TERTIARY_INSURER_COVERAGE_AMOUNT = 2D;

    private static final Double DEFAULT_TERTIARY_INSURER_PAYMENT = 1D;
    private static final Double UPDATED_TERTIARY_INSURER_PAYMENT = 2D;

    private static final Double DEFAULT_TERTIARY_INSURER_BALANCE_AMOUNT = 1D;
    private static final Double UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT = 2D;

    private static final Integer DEFAULT_PATIENT_COINSURANCE_PERCENTAGE = 1;
    private static final Integer UPDATED_PATIENT_COINSURANCE_PERCENTAGE = 2;

    private static final Double DEFAULT_PATIENT_COINSURANCE_AMOUNT = 1D;
    private static final Double UPDATED_PATIENT_COINSURANCE_AMOUNT = 2D;

    private static final Double DEFAULT_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT = 1D;
    private static final Double UPDATED_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT = 2D;

    private static final Double DEFAULT_PATIENT_PAY_AMOUNT = 1D;
    private static final Double UPDATED_PATIENT_PAY_AMOUNT = 2D;

    private static final String DEFAULT_NARRATION = "AAAAAAAAAA";
    private static final String UPDATED_NARRATION = "BBBBBBBBBB";

    private static final String DEFAULT_PRIMARY_INVOICE_NO = "AAAAAAAAAA";
    private static final String UPDATED_PRIMARY_INVOICE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_SECONDARY_INVOICE_NO = "AAAAAAAAAA";
    private static final String UPDATED_SECONDARY_INVOICE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_TERTIARY_INVOICE_NO = "AAAAAAAAAA";
    private static final String UPDATED_TERTIARY_INVOICE_NO = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_PRIMARY_INVOICE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_PRIMARY_INVOICE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_SECONDARY_INVOICE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_SECONDARY_INVOICE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_TERTIARY_INVOICE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_TERTIARY_INVOICE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_PRIMARY_INVOICE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PRIMARY_INVOICE_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_SECONDARY_INVOICE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_SECONDARY_INVOICE_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_TERTIARY_INVOICE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_TERTIARY_INVOICE_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_DOS = "AAAAAAAAAA";
    private static final String UPDATED_DOS = "BBBBBBBBBB";

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

    private static final String ENTITY_API_URL = "/api/sales-order-financial-details";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{salesOrderFinancialId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SalesOrderFinancialDetailsRepository salesOrderFinancialDetailsRepository;

    @Autowired
    private SalesOrderFinancialDetailsMapper salesOrderFinancialDetailsMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private SalesOrderFinancialDetails salesOrderFinancialDetails;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SalesOrderFinancialDetails createEntity(EntityManager em) {
        SalesOrderFinancialDetails salesOrderFinancialDetails = new SalesOrderFinancialDetails()
            .salesOrderId(DEFAULT_SALES_ORDER_ID)
            .patientId(DEFAULT_PATIENT_ID)
            .itemId(DEFAULT_ITEM_ID)
            .itemName(DEFAULT_ITEM_NAME)
            .itemProcCode(DEFAULT_ITEM_PROC_CODE)
            .chargedAmount(DEFAULT_CHARGED_AMOUNT)
            .allowedAmount(DEFAULT_ALLOWED_AMOUNT)
            .primaryInsurerId(DEFAULT_PRIMARY_INSURER_ID)
            .primaryInsurerName(DEFAULT_PRIMARY_INSURER_NAME)
            .primaryInsurerStatus(DEFAULT_PRIMARY_INSURER_STATUS)
            .primaryInsurerCoveragePercentage(DEFAULT_PRIMARY_INSURER_COVERAGE_PERCENTAGE)
            .primaryInsurerCoverageAmount(DEFAULT_PRIMARY_INSURER_COVERAGE_AMOUNT)
            .primaryInsurerDeductibleAmount(DEFAULT_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT)
            .primaryInsurerPayment(DEFAULT_PRIMARY_INSURER_PAYMENT)
            .primaryInsurerBalanceAmount(DEFAULT_PRIMARY_INSURER_BALANCE_AMOUNT)
            .secondaryInsurerId(DEFAULT_SECONDARY_INSURER_ID)
            .secondaryInsurerName(DEFAULT_SECONDARY_INSURER_NAME)
            .secondaryInsurerStatus(DEFAULT_SECONDARY_INSURER_STATUS)
            .secondaryInsurerCoveragerPercentage(DEFAULT_SECONDARY_INSURER_COVERAGER_PERCENTAGE)
            .secondaryInsurerCoverageAmount(DEFAULT_SECONDARY_INSURER_COVERAGE_AMOUNT)
            .secondaryInsurerPayment(DEFAULT_SECONDARY_INSURER_PAYMENT)
            .secondaryInsurerBalanceAmount(DEFAULT_SECONDARY_INSURER_BALANCE_AMOUNT)
            .tertiaryInsurerId(DEFAULT_TERTIARY_INSURER_ID)
            .tertiaryInsurerName(DEFAULT_TERTIARY_INSURER_NAME)
            .tertiaryInsurerStatus(DEFAULT_TERTIARY_INSURER_STATUS)
            .tertiaryInsurerCoveragePercentage(DEFAULT_TERTIARY_INSURER_COVERAGE_PERCENTAGE)
            .tertiaryInsurerCoverageAmount(DEFAULT_TERTIARY_INSURER_COVERAGE_AMOUNT)
            .tertiaryInsurerPayment(DEFAULT_TERTIARY_INSURER_PAYMENT)
            .tertiaryInsurerBalanceAmount(DEFAULT_TERTIARY_INSURER_BALANCE_AMOUNT)
            .patientCoinsurancePercentage(DEFAULT_PATIENT_COINSURANCE_PERCENTAGE)
            .patientCoinsuranceAmount(DEFAULT_PATIENT_COINSURANCE_AMOUNT)
            .totalPatientResponsibilityAmount(DEFAULT_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT)
            .patientPayAmount(DEFAULT_PATIENT_PAY_AMOUNT)
            .narration(DEFAULT_NARRATION)
            .primaryInvoiceNo(DEFAULT_PRIMARY_INVOICE_NO)
            .secondaryInvoiceNo(DEFAULT_SECONDARY_INVOICE_NO)
            .tertiaryInvoiceNo(DEFAULT_TERTIARY_INVOICE_NO)
            .primaryInvoiceDate(DEFAULT_PRIMARY_INVOICE_DATE)
            .secondaryInvoiceDate(DEFAULT_SECONDARY_INVOICE_DATE)
            .tertiaryInvoiceDate(DEFAULT_TERTIARY_INVOICE_DATE)
            .primaryInvoiceStatus(DEFAULT_PRIMARY_INVOICE_STATUS)
            .secondaryInvoiceStatus(DEFAULT_SECONDARY_INVOICE_STATUS)
            .tertiaryInvoiceStatus(DEFAULT_TERTIARY_INVOICE_STATUS)
            .dos(DEFAULT_DOS)
            .createdById(DEFAULT_CREATED_BY_ID)
            .createdByName(DEFAULT_CREATED_BY_NAME)
            .createdDate(DEFAULT_CREATED_DATE)
            .updatedById(DEFAULT_UPDATED_BY_ID)
            .updatedByName(DEFAULT_UPDATED_BY_NAME)
            .updatedDate(DEFAULT_UPDATED_DATE);
        return salesOrderFinancialDetails;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SalesOrderFinancialDetails createUpdatedEntity(EntityManager em) {
        SalesOrderFinancialDetails salesOrderFinancialDetails = new SalesOrderFinancialDetails()
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .patientId(UPDATED_PATIENT_ID)
            .itemId(UPDATED_ITEM_ID)
            .itemName(UPDATED_ITEM_NAME)
            .itemProcCode(UPDATED_ITEM_PROC_CODE)
            .chargedAmount(UPDATED_CHARGED_AMOUNT)
            .allowedAmount(UPDATED_ALLOWED_AMOUNT)
            .primaryInsurerId(UPDATED_PRIMARY_INSURER_ID)
            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
            .primaryInsurerStatus(UPDATED_PRIMARY_INSURER_STATUS)
            .primaryInsurerCoveragePercentage(UPDATED_PRIMARY_INSURER_COVERAGE_PERCENTAGE)
            .primaryInsurerCoverageAmount(UPDATED_PRIMARY_INSURER_COVERAGE_AMOUNT)
            .primaryInsurerDeductibleAmount(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT)
            .primaryInsurerPayment(UPDATED_PRIMARY_INSURER_PAYMENT)
            .primaryInsurerBalanceAmount(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT)
            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
            .secondaryInsurerStatus(UPDATED_SECONDARY_INSURER_STATUS)
            .secondaryInsurerCoveragerPercentage(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE)
            .secondaryInsurerCoverageAmount(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT)
            .secondaryInsurerPayment(UPDATED_SECONDARY_INSURER_PAYMENT)
            .secondaryInsurerBalanceAmount(UPDATED_SECONDARY_INSURER_BALANCE_AMOUNT)
            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
            .tertiaryInsurerStatus(UPDATED_TERTIARY_INSURER_STATUS)
            .tertiaryInsurerCoveragePercentage(UPDATED_TERTIARY_INSURER_COVERAGE_PERCENTAGE)
            .tertiaryInsurerCoverageAmount(UPDATED_TERTIARY_INSURER_COVERAGE_AMOUNT)
            .tertiaryInsurerPayment(UPDATED_TERTIARY_INSURER_PAYMENT)
            .tertiaryInsurerBalanceAmount(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT)
            .patientCoinsurancePercentage(UPDATED_PATIENT_COINSURANCE_PERCENTAGE)
            .patientCoinsuranceAmount(UPDATED_PATIENT_COINSURANCE_AMOUNT)
            .totalPatientResponsibilityAmount(UPDATED_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT)
            .patientPayAmount(UPDATED_PATIENT_PAY_AMOUNT)
            .narration(UPDATED_NARRATION)
            .primaryInvoiceNo(UPDATED_PRIMARY_INVOICE_NO)
            .secondaryInvoiceNo(UPDATED_SECONDARY_INVOICE_NO)
            .tertiaryInvoiceNo(UPDATED_TERTIARY_INVOICE_NO)
            .primaryInvoiceDate(UPDATED_PRIMARY_INVOICE_DATE)
            .secondaryInvoiceDate(UPDATED_SECONDARY_INVOICE_DATE)
            .tertiaryInvoiceDate(UPDATED_TERTIARY_INVOICE_DATE)
            .primaryInvoiceStatus(UPDATED_PRIMARY_INVOICE_STATUS)
            .secondaryInvoiceStatus(UPDATED_SECONDARY_INVOICE_STATUS)
            .tertiaryInvoiceStatus(UPDATED_TERTIARY_INVOICE_STATUS)
            .dos(UPDATED_DOS)
            .createdById(UPDATED_CREATED_BY_ID)
            .createdByName(UPDATED_CREATED_BY_NAME)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME)
            .updatedDate(UPDATED_UPDATED_DATE);
        return salesOrderFinancialDetails;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(SalesOrderFinancialDetails.class).block();
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
        salesOrderFinancialDetails = createEntity(em);
    }

    @Test
    void createSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeCreate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        SalesOrderFinancialDetails testSalesOrderFinancialDetails = salesOrderFinancialDetailsList.get(
            salesOrderFinancialDetailsList.size() - 1
        );
        assertThat(testSalesOrderFinancialDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
        assertThat(testSalesOrderFinancialDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
        assertThat(testSalesOrderFinancialDetails.getItemId()).isEqualTo(DEFAULT_ITEM_ID);
        assertThat(testSalesOrderFinancialDetails.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testSalesOrderFinancialDetails.getItemProcCode()).isEqualTo(DEFAULT_ITEM_PROC_CODE);
        assertThat(testSalesOrderFinancialDetails.getChargedAmount()).isEqualTo(DEFAULT_CHARGED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getAllowedAmount()).isEqualTo(DEFAULT_ALLOWED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerId()).isEqualTo(DEFAULT_PRIMARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerName()).isEqualTo(DEFAULT_PRIMARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerStatus()).isEqualTo(DEFAULT_PRIMARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoveragePercentage())
            .isEqualTo(DEFAULT_PRIMARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoverageAmount()).isEqualTo(DEFAULT_PRIMARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerDeductibleAmount()).isEqualTo(DEFAULT_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerPayment()).isEqualTo(DEFAULT_PRIMARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerBalanceAmount()).isEqualTo(DEFAULT_PRIMARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerId()).isEqualTo(DEFAULT_SECONDARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerName()).isEqualTo(DEFAULT_SECONDARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerStatus()).isEqualTo(DEFAULT_SECONDARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoveragerPercentage())
            .isEqualTo(DEFAULT_SECONDARY_INSURER_COVERAGER_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoverageAmount()).isEqualTo(DEFAULT_SECONDARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerPayment()).isEqualTo(DEFAULT_SECONDARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerBalanceAmount()).isEqualTo(DEFAULT_SECONDARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerId()).isEqualTo(DEFAULT_TERTIARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerName()).isEqualTo(DEFAULT_TERTIARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerStatus()).isEqualTo(DEFAULT_TERTIARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoveragePercentage())
            .isEqualTo(DEFAULT_TERTIARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoverageAmount()).isEqualTo(DEFAULT_TERTIARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerPayment()).isEqualTo(DEFAULT_TERTIARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerBalanceAmount()).isEqualTo(DEFAULT_TERTIARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsurancePercentage()).isEqualTo(DEFAULT_PATIENT_COINSURANCE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsuranceAmount()).isEqualTo(DEFAULT_PATIENT_COINSURANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTotalPatientResponsibilityAmount())
            .isEqualTo(DEFAULT_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientPayAmount()).isEqualTo(DEFAULT_PATIENT_PAY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getNarration()).isEqualTo(DEFAULT_NARRATION);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceNo()).isEqualTo(DEFAULT_PRIMARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceNo()).isEqualTo(DEFAULT_SECONDARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceNo()).isEqualTo(DEFAULT_TERTIARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceDate()).isEqualTo(DEFAULT_PRIMARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceDate()).isEqualTo(DEFAULT_SECONDARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceDate()).isEqualTo(DEFAULT_TERTIARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceStatus()).isEqualTo(DEFAULT_PRIMARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceStatus()).isEqualTo(DEFAULT_SECONDARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceStatus()).isEqualTo(DEFAULT_TERTIARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getDos()).isEqualTo(DEFAULT_DOS);
        assertThat(testSalesOrderFinancialDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testSalesOrderFinancialDetails.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
    }

    @Test
    void createSalesOrderFinancialDetailsWithExistingId() throws Exception {
        // Create the SalesOrderFinancialDetails with an existing ID
        salesOrderFinancialDetails.setSalesOrderFinancialId(1L);
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        int databaseSizeBeforeCreate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkSalesOrderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setSalesOrderId(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkPatientIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setPatientId(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkItemIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setItemId(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkItemNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setItemName(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkItemProcCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setItemProcCode(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkChargedAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setChargedAmount(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkAllowedAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderFinancialDetails.setAllowedAmount(null);

        // Create the SalesOrderFinancialDetails, which fails.
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllSalesOrderFinancialDetails() {
        // Initialize the database
        salesOrderFinancialDetailsRepository.save(salesOrderFinancialDetails).block();

        // Get all the salesOrderFinancialDetailsList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=salesOrderFinancialId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].salesOrderFinancialId")
            .value(hasItem(salesOrderFinancialDetails.getSalesOrderFinancialId().intValue()))
            .jsonPath("$.[*].salesOrderId")
            .value(hasItem(DEFAULT_SALES_ORDER_ID.intValue()))
            .jsonPath("$.[*].patientId")
            .value(hasItem(DEFAULT_PATIENT_ID))
            .jsonPath("$.[*].itemId")
            .value(hasItem(DEFAULT_ITEM_ID.intValue()))
            .jsonPath("$.[*].itemName")
            .value(hasItem(DEFAULT_ITEM_NAME))
            .jsonPath("$.[*].itemProcCode")
            .value(hasItem(DEFAULT_ITEM_PROC_CODE))
            .jsonPath("$.[*].chargedAmount")
            .value(hasItem(DEFAULT_CHARGED_AMOUNT.doubleValue()))
            .jsonPath("$.[*].allowedAmount")
            .value(hasItem(DEFAULT_ALLOWED_AMOUNT.doubleValue()))
            .jsonPath("$.[*].primaryInsurerId")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_ID))
            .jsonPath("$.[*].primaryInsurerName")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_NAME))
            .jsonPath("$.[*].primaryInsurerStatus")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_STATUS))
            .jsonPath("$.[*].primaryInsurerCoveragePercentage")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_COVERAGE_PERCENTAGE))
            .jsonPath("$.[*].primaryInsurerCoverageAmount")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_COVERAGE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].primaryInsurerDeductibleAmount")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].primaryInsurerPayment")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_PAYMENT.doubleValue()))
            .jsonPath("$.[*].primaryInsurerBalanceAmount")
            .value(hasItem(DEFAULT_PRIMARY_INSURER_BALANCE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].secondaryInsurerId")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_ID))
            .jsonPath("$.[*].secondaryInsurerName")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_NAME))
            .jsonPath("$.[*].secondaryInsurerStatus")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_STATUS))
            .jsonPath("$.[*].secondaryInsurerCoveragerPercentage")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_COVERAGER_PERCENTAGE))
            .jsonPath("$.[*].secondaryInsurerCoverageAmount")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_COVERAGE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].secondaryInsurerPayment")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_PAYMENT.doubleValue()))
            .jsonPath("$.[*].secondaryInsurerBalanceAmount")
            .value(hasItem(DEFAULT_SECONDARY_INSURER_BALANCE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].tertiaryInsurerId")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_ID))
            .jsonPath("$.[*].tertiaryInsurerName")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_NAME))
            .jsonPath("$.[*].tertiaryInsurerStatus")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_STATUS))
            .jsonPath("$.[*].tertiaryInsurerCoveragePercentage")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_COVERAGE_PERCENTAGE))
            .jsonPath("$.[*].tertiaryInsurerCoverageAmount")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_COVERAGE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].tertiaryInsurerPayment")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_PAYMENT.doubleValue()))
            .jsonPath("$.[*].tertiaryInsurerBalanceAmount")
            .value(hasItem(DEFAULT_TERTIARY_INSURER_BALANCE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].patientCoinsurancePercentage")
            .value(hasItem(DEFAULT_PATIENT_COINSURANCE_PERCENTAGE))
            .jsonPath("$.[*].patientCoinsuranceAmount")
            .value(hasItem(DEFAULT_PATIENT_COINSURANCE_AMOUNT.doubleValue()))
            .jsonPath("$.[*].totalPatientResponsibilityAmount")
            .value(hasItem(DEFAULT_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT.doubleValue()))
            .jsonPath("$.[*].patientPayAmount")
            .value(hasItem(DEFAULT_PATIENT_PAY_AMOUNT.doubleValue()))
            .jsonPath("$.[*].narration")
            .value(hasItem(DEFAULT_NARRATION))
            .jsonPath("$.[*].primaryInvoiceNo")
            .value(hasItem(DEFAULT_PRIMARY_INVOICE_NO))
            .jsonPath("$.[*].secondaryInvoiceNo")
            .value(hasItem(DEFAULT_SECONDARY_INVOICE_NO))
            .jsonPath("$.[*].tertiaryInvoiceNo")
            .value(hasItem(DEFAULT_TERTIARY_INVOICE_NO))
            .jsonPath("$.[*].primaryInvoiceDate")
            .value(hasItem(sameInstant(DEFAULT_PRIMARY_INVOICE_DATE)))
            .jsonPath("$.[*].secondaryInvoiceDate")
            .value(hasItem(sameInstant(DEFAULT_SECONDARY_INVOICE_DATE)))
            .jsonPath("$.[*].tertiaryInvoiceDate")
            .value(hasItem(sameInstant(DEFAULT_TERTIARY_INVOICE_DATE)))
            .jsonPath("$.[*].primaryInvoiceStatus")
            .value(hasItem(DEFAULT_PRIMARY_INVOICE_STATUS))
            .jsonPath("$.[*].secondaryInvoiceStatus")
            .value(hasItem(DEFAULT_SECONDARY_INVOICE_STATUS))
            .jsonPath("$.[*].tertiaryInvoiceStatus")
            .value(hasItem(DEFAULT_TERTIARY_INVOICE_STATUS))
            .jsonPath("$.[*].dos")
            .value(hasItem(DEFAULT_DOS))
            .jsonPath("$.[*].createdById")
            .value(hasItem(DEFAULT_CREATED_BY_ID))
            .jsonPath("$.[*].createdByName")
            .value(hasItem(DEFAULT_CREATED_BY_NAME))
            .jsonPath("$.[*].createdDate")
            .value(hasItem(sameInstant(DEFAULT_CREATED_DATE)))
            .jsonPath("$.[*].updatedById")
            .value(hasItem(DEFAULT_UPDATED_BY_ID))
            .jsonPath("$.[*].updatedByName")
            .value(hasItem(DEFAULT_UPDATED_BY_NAME))
            .jsonPath("$.[*].updatedDate")
            .value(hasItem(sameInstant(DEFAULT_UPDATED_DATE)));
    }

    @Test
    void getSalesOrderFinancialDetails() {
        // Initialize the database
        salesOrderFinancialDetailsRepository.save(salesOrderFinancialDetails).block();

        // Get the salesOrderFinancialDetails
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, salesOrderFinancialDetails.getSalesOrderFinancialId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.salesOrderFinancialId")
            .value(is(salesOrderFinancialDetails.getSalesOrderFinancialId().intValue()))
            .jsonPath("$.salesOrderId")
            .value(is(DEFAULT_SALES_ORDER_ID.intValue()))
            .jsonPath("$.patientId")
            .value(is(DEFAULT_PATIENT_ID))
            .jsonPath("$.itemId")
            .value(is(DEFAULT_ITEM_ID.intValue()))
            .jsonPath("$.itemName")
            .value(is(DEFAULT_ITEM_NAME))
            .jsonPath("$.itemProcCode")
            .value(is(DEFAULT_ITEM_PROC_CODE))
            .jsonPath("$.chargedAmount")
            .value(is(DEFAULT_CHARGED_AMOUNT.doubleValue()))
            .jsonPath("$.allowedAmount")
            .value(is(DEFAULT_ALLOWED_AMOUNT.doubleValue()))
            .jsonPath("$.primaryInsurerId")
            .value(is(DEFAULT_PRIMARY_INSURER_ID))
            .jsonPath("$.primaryInsurerName")
            .value(is(DEFAULT_PRIMARY_INSURER_NAME))
            .jsonPath("$.primaryInsurerStatus")
            .value(is(DEFAULT_PRIMARY_INSURER_STATUS))
            .jsonPath("$.primaryInsurerCoveragePercentage")
            .value(is(DEFAULT_PRIMARY_INSURER_COVERAGE_PERCENTAGE))
            .jsonPath("$.primaryInsurerCoverageAmount")
            .value(is(DEFAULT_PRIMARY_INSURER_COVERAGE_AMOUNT.doubleValue()))
            .jsonPath("$.primaryInsurerDeductibleAmount")
            .value(is(DEFAULT_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT.doubleValue()))
            .jsonPath("$.primaryInsurerPayment")
            .value(is(DEFAULT_PRIMARY_INSURER_PAYMENT.doubleValue()))
            .jsonPath("$.primaryInsurerBalanceAmount")
            .value(is(DEFAULT_PRIMARY_INSURER_BALANCE_AMOUNT.doubleValue()))
            .jsonPath("$.secondaryInsurerId")
            .value(is(DEFAULT_SECONDARY_INSURER_ID))
            .jsonPath("$.secondaryInsurerName")
            .value(is(DEFAULT_SECONDARY_INSURER_NAME))
            .jsonPath("$.secondaryInsurerStatus")
            .value(is(DEFAULT_SECONDARY_INSURER_STATUS))
            .jsonPath("$.secondaryInsurerCoveragerPercentage")
            .value(is(DEFAULT_SECONDARY_INSURER_COVERAGER_PERCENTAGE))
            .jsonPath("$.secondaryInsurerCoverageAmount")
            .value(is(DEFAULT_SECONDARY_INSURER_COVERAGE_AMOUNT.doubleValue()))
            .jsonPath("$.secondaryInsurerPayment")
            .value(is(DEFAULT_SECONDARY_INSURER_PAYMENT.doubleValue()))
            .jsonPath("$.secondaryInsurerBalanceAmount")
            .value(is(DEFAULT_SECONDARY_INSURER_BALANCE_AMOUNT.doubleValue()))
            .jsonPath("$.tertiaryInsurerId")
            .value(is(DEFAULT_TERTIARY_INSURER_ID))
            .jsonPath("$.tertiaryInsurerName")
            .value(is(DEFAULT_TERTIARY_INSURER_NAME))
            .jsonPath("$.tertiaryInsurerStatus")
            .value(is(DEFAULT_TERTIARY_INSURER_STATUS))
            .jsonPath("$.tertiaryInsurerCoveragePercentage")
            .value(is(DEFAULT_TERTIARY_INSURER_COVERAGE_PERCENTAGE))
            .jsonPath("$.tertiaryInsurerCoverageAmount")
            .value(is(DEFAULT_TERTIARY_INSURER_COVERAGE_AMOUNT.doubleValue()))
            .jsonPath("$.tertiaryInsurerPayment")
            .value(is(DEFAULT_TERTIARY_INSURER_PAYMENT.doubleValue()))
            .jsonPath("$.tertiaryInsurerBalanceAmount")
            .value(is(DEFAULT_TERTIARY_INSURER_BALANCE_AMOUNT.doubleValue()))
            .jsonPath("$.patientCoinsurancePercentage")
            .value(is(DEFAULT_PATIENT_COINSURANCE_PERCENTAGE))
            .jsonPath("$.patientCoinsuranceAmount")
            .value(is(DEFAULT_PATIENT_COINSURANCE_AMOUNT.doubleValue()))
            .jsonPath("$.totalPatientResponsibilityAmount")
            .value(is(DEFAULT_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT.doubleValue()))
            .jsonPath("$.patientPayAmount")
            .value(is(DEFAULT_PATIENT_PAY_AMOUNT.doubleValue()))
            .jsonPath("$.narration")
            .value(is(DEFAULT_NARRATION))
            .jsonPath("$.primaryInvoiceNo")
            .value(is(DEFAULT_PRIMARY_INVOICE_NO))
            .jsonPath("$.secondaryInvoiceNo")
            .value(is(DEFAULT_SECONDARY_INVOICE_NO))
            .jsonPath("$.tertiaryInvoiceNo")
            .value(is(DEFAULT_TERTIARY_INVOICE_NO))
            .jsonPath("$.primaryInvoiceDate")
            .value(is(sameInstant(DEFAULT_PRIMARY_INVOICE_DATE)))
            .jsonPath("$.secondaryInvoiceDate")
            .value(is(sameInstant(DEFAULT_SECONDARY_INVOICE_DATE)))
            .jsonPath("$.tertiaryInvoiceDate")
            .value(is(sameInstant(DEFAULT_TERTIARY_INVOICE_DATE)))
            .jsonPath("$.primaryInvoiceStatus")
            .value(is(DEFAULT_PRIMARY_INVOICE_STATUS))
            .jsonPath("$.secondaryInvoiceStatus")
            .value(is(DEFAULT_SECONDARY_INVOICE_STATUS))
            .jsonPath("$.tertiaryInvoiceStatus")
            .value(is(DEFAULT_TERTIARY_INVOICE_STATUS))
            .jsonPath("$.dos")
            .value(is(DEFAULT_DOS))
            .jsonPath("$.createdById")
            .value(is(DEFAULT_CREATED_BY_ID))
            .jsonPath("$.createdByName")
            .value(is(DEFAULT_CREATED_BY_NAME))
            .jsonPath("$.createdDate")
            .value(is(sameInstant(DEFAULT_CREATED_DATE)))
            .jsonPath("$.updatedById")
            .value(is(DEFAULT_UPDATED_BY_ID))
            .jsonPath("$.updatedByName")
            .value(is(DEFAULT_UPDATED_BY_NAME))
            .jsonPath("$.updatedDate")
            .value(is(sameInstant(DEFAULT_UPDATED_DATE)));
    }

    @Test
    void getNonExistingSalesOrderFinancialDetails() {
        // Get the salesOrderFinancialDetails
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingSalesOrderFinancialDetails() throws Exception {
        // Initialize the database
        salesOrderFinancialDetailsRepository.save(salesOrderFinancialDetails).block();

        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();

        // Update the salesOrderFinancialDetails
        SalesOrderFinancialDetails updatedSalesOrderFinancialDetails = salesOrderFinancialDetailsRepository
            .findById(salesOrderFinancialDetails.getSalesOrderFinancialId())
            .block();
        updatedSalesOrderFinancialDetails
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .patientId(UPDATED_PATIENT_ID)
            .itemId(UPDATED_ITEM_ID)
            .itemName(UPDATED_ITEM_NAME)
            .itemProcCode(UPDATED_ITEM_PROC_CODE)
            .chargedAmount(UPDATED_CHARGED_AMOUNT)
            .allowedAmount(UPDATED_ALLOWED_AMOUNT)
            .primaryInsurerId(UPDATED_PRIMARY_INSURER_ID)
            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
            .primaryInsurerStatus(UPDATED_PRIMARY_INSURER_STATUS)
            .primaryInsurerCoveragePercentage(UPDATED_PRIMARY_INSURER_COVERAGE_PERCENTAGE)
            .primaryInsurerCoverageAmount(UPDATED_PRIMARY_INSURER_COVERAGE_AMOUNT)
            .primaryInsurerDeductibleAmount(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT)
            .primaryInsurerPayment(UPDATED_PRIMARY_INSURER_PAYMENT)
            .primaryInsurerBalanceAmount(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT)
            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
            .secondaryInsurerStatus(UPDATED_SECONDARY_INSURER_STATUS)
            .secondaryInsurerCoveragerPercentage(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE)
            .secondaryInsurerCoverageAmount(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT)
            .secondaryInsurerPayment(UPDATED_SECONDARY_INSURER_PAYMENT)
            .secondaryInsurerBalanceAmount(UPDATED_SECONDARY_INSURER_BALANCE_AMOUNT)
            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
            .tertiaryInsurerStatus(UPDATED_TERTIARY_INSURER_STATUS)
            .tertiaryInsurerCoveragePercentage(UPDATED_TERTIARY_INSURER_COVERAGE_PERCENTAGE)
            .tertiaryInsurerCoverageAmount(UPDATED_TERTIARY_INSURER_COVERAGE_AMOUNT)
            .tertiaryInsurerPayment(UPDATED_TERTIARY_INSURER_PAYMENT)
            .tertiaryInsurerBalanceAmount(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT)
            .patientCoinsurancePercentage(UPDATED_PATIENT_COINSURANCE_PERCENTAGE)
            .patientCoinsuranceAmount(UPDATED_PATIENT_COINSURANCE_AMOUNT)
            .totalPatientResponsibilityAmount(UPDATED_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT)
            .patientPayAmount(UPDATED_PATIENT_PAY_AMOUNT)
            .narration(UPDATED_NARRATION)
            .primaryInvoiceNo(UPDATED_PRIMARY_INVOICE_NO)
            .secondaryInvoiceNo(UPDATED_SECONDARY_INVOICE_NO)
            .tertiaryInvoiceNo(UPDATED_TERTIARY_INVOICE_NO)
            .primaryInvoiceDate(UPDATED_PRIMARY_INVOICE_DATE)
            .secondaryInvoiceDate(UPDATED_SECONDARY_INVOICE_DATE)
            .tertiaryInvoiceDate(UPDATED_TERTIARY_INVOICE_DATE)
            .primaryInvoiceStatus(UPDATED_PRIMARY_INVOICE_STATUS)
            .secondaryInvoiceStatus(UPDATED_SECONDARY_INVOICE_STATUS)
            .tertiaryInvoiceStatus(UPDATED_TERTIARY_INVOICE_STATUS)
            .dos(UPDATED_DOS)
            .createdById(UPDATED_CREATED_BY_ID)
            .createdByName(UPDATED_CREATED_BY_NAME)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME)
            .updatedDate(UPDATED_UPDATED_DATE);
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(
            updatedSalesOrderFinancialDetails
        );

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, salesOrderFinancialDetailsDTO.getSalesOrderFinancialId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
        SalesOrderFinancialDetails testSalesOrderFinancialDetails = salesOrderFinancialDetailsList.get(
            salesOrderFinancialDetailsList.size() - 1
        );
        assertThat(testSalesOrderFinancialDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
        assertThat(testSalesOrderFinancialDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
        assertThat(testSalesOrderFinancialDetails.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testSalesOrderFinancialDetails.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testSalesOrderFinancialDetails.getItemProcCode()).isEqualTo(UPDATED_ITEM_PROC_CODE);
        assertThat(testSalesOrderFinancialDetails.getChargedAmount()).isEqualTo(UPDATED_CHARGED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getAllowedAmount()).isEqualTo(UPDATED_ALLOWED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerId()).isEqualTo(UPDATED_PRIMARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerName()).isEqualTo(UPDATED_PRIMARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerStatus()).isEqualTo(UPDATED_PRIMARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoveragePercentage())
            .isEqualTo(UPDATED_PRIMARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoverageAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerDeductibleAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerPayment()).isEqualTo(UPDATED_PRIMARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerBalanceAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerId()).isEqualTo(UPDATED_SECONDARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerName()).isEqualTo(UPDATED_SECONDARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerStatus()).isEqualTo(UPDATED_SECONDARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoveragerPercentage())
            .isEqualTo(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoverageAmount()).isEqualTo(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerPayment()).isEqualTo(UPDATED_SECONDARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerBalanceAmount()).isEqualTo(UPDATED_SECONDARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerId()).isEqualTo(UPDATED_TERTIARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerName()).isEqualTo(UPDATED_TERTIARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerStatus()).isEqualTo(UPDATED_TERTIARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoveragePercentage())
            .isEqualTo(UPDATED_TERTIARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoverageAmount()).isEqualTo(UPDATED_TERTIARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerPayment()).isEqualTo(UPDATED_TERTIARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerBalanceAmount()).isEqualTo(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsurancePercentage()).isEqualTo(UPDATED_PATIENT_COINSURANCE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsuranceAmount()).isEqualTo(UPDATED_PATIENT_COINSURANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTotalPatientResponsibilityAmount())
            .isEqualTo(UPDATED_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientPayAmount()).isEqualTo(UPDATED_PATIENT_PAY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getNarration()).isEqualTo(UPDATED_NARRATION);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceNo()).isEqualTo(UPDATED_PRIMARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceNo()).isEqualTo(UPDATED_SECONDARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceNo()).isEqualTo(UPDATED_TERTIARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceDate()).isEqualTo(UPDATED_PRIMARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceDate()).isEqualTo(UPDATED_SECONDARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceDate()).isEqualTo(UPDATED_TERTIARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceStatus()).isEqualTo(UPDATED_PRIMARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceStatus()).isEqualTo(UPDATED_SECONDARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceStatus()).isEqualTo(UPDATED_TERTIARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getDos()).isEqualTo(UPDATED_DOS);
        assertThat(testSalesOrderFinancialDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testSalesOrderFinancialDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
    }

    @Test
    void putNonExistingSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        salesOrderFinancialDetails.setSalesOrderFinancialId(count.incrementAndGet());

        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, salesOrderFinancialDetailsDTO.getSalesOrderFinancialId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        salesOrderFinancialDetails.setSalesOrderFinancialId(count.incrementAndGet());

        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        salesOrderFinancialDetails.setSalesOrderFinancialId(count.incrementAndGet());

        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateSalesOrderFinancialDetailsWithPatch() throws Exception {
        // Initialize the database
        salesOrderFinancialDetailsRepository.save(salesOrderFinancialDetails).block();

        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();

        // Update the salesOrderFinancialDetails using partial update
        SalesOrderFinancialDetails partialUpdatedSalesOrderFinancialDetails = new SalesOrderFinancialDetails();
        partialUpdatedSalesOrderFinancialDetails.setSalesOrderFinancialId(salesOrderFinancialDetails.getSalesOrderFinancialId());

        partialUpdatedSalesOrderFinancialDetails
            .patientId(UPDATED_PATIENT_ID)
            .itemId(UPDATED_ITEM_ID)
            .itemProcCode(UPDATED_ITEM_PROC_CODE)
            .chargedAmount(UPDATED_CHARGED_AMOUNT)
            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
            .primaryInsurerStatus(UPDATED_PRIMARY_INSURER_STATUS)
            .primaryInsurerDeductibleAmount(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT)
            .primaryInsurerBalanceAmount(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT)
            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
            .secondaryInsurerStatus(UPDATED_SECONDARY_INSURER_STATUS)
            .secondaryInsurerCoveragerPercentage(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE)
            .secondaryInsurerCoverageAmount(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT)
            .secondaryInsurerPayment(UPDATED_SECONDARY_INSURER_PAYMENT)
            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
            .tertiaryInsurerStatus(UPDATED_TERTIARY_INSURER_STATUS)
            .tertiaryInsurerBalanceAmount(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT)
            .patientCoinsuranceAmount(UPDATED_PATIENT_COINSURANCE_AMOUNT)
            .narration(UPDATED_NARRATION)
            .primaryInvoiceNo(UPDATED_PRIMARY_INVOICE_NO)
            .primaryInvoiceDate(UPDATED_PRIMARY_INVOICE_DATE)
            .tertiaryInvoiceDate(UPDATED_TERTIARY_INVOICE_DATE)
            .primaryInvoiceStatus(UPDATED_PRIMARY_INVOICE_STATUS)
            .secondaryInvoiceStatus(UPDATED_SECONDARY_INVOICE_STATUS)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderFinancialDetails.getSalesOrderFinancialId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderFinancialDetails))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
        SalesOrderFinancialDetails testSalesOrderFinancialDetails = salesOrderFinancialDetailsList.get(
            salesOrderFinancialDetailsList.size() - 1
        );
        assertThat(testSalesOrderFinancialDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
        assertThat(testSalesOrderFinancialDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
        assertThat(testSalesOrderFinancialDetails.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testSalesOrderFinancialDetails.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testSalesOrderFinancialDetails.getItemProcCode()).isEqualTo(UPDATED_ITEM_PROC_CODE);
        assertThat(testSalesOrderFinancialDetails.getChargedAmount()).isEqualTo(UPDATED_CHARGED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getAllowedAmount()).isEqualTo(DEFAULT_ALLOWED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerId()).isEqualTo(DEFAULT_PRIMARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerName()).isEqualTo(UPDATED_PRIMARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerStatus()).isEqualTo(UPDATED_PRIMARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoveragePercentage())
            .isEqualTo(DEFAULT_PRIMARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoverageAmount()).isEqualTo(DEFAULT_PRIMARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerDeductibleAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerPayment()).isEqualTo(DEFAULT_PRIMARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerBalanceAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerId()).isEqualTo(DEFAULT_SECONDARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerName()).isEqualTo(UPDATED_SECONDARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerStatus()).isEqualTo(UPDATED_SECONDARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoveragerPercentage())
            .isEqualTo(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoverageAmount()).isEqualTo(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerPayment()).isEqualTo(UPDATED_SECONDARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerBalanceAmount()).isEqualTo(DEFAULT_SECONDARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerId()).isEqualTo(UPDATED_TERTIARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerName()).isEqualTo(UPDATED_TERTIARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerStatus()).isEqualTo(UPDATED_TERTIARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoveragePercentage())
            .isEqualTo(DEFAULT_TERTIARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoverageAmount()).isEqualTo(DEFAULT_TERTIARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerPayment()).isEqualTo(DEFAULT_TERTIARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerBalanceAmount()).isEqualTo(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsurancePercentage()).isEqualTo(DEFAULT_PATIENT_COINSURANCE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsuranceAmount()).isEqualTo(UPDATED_PATIENT_COINSURANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTotalPatientResponsibilityAmount())
            .isEqualTo(DEFAULT_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientPayAmount()).isEqualTo(DEFAULT_PATIENT_PAY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getNarration()).isEqualTo(UPDATED_NARRATION);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceNo()).isEqualTo(UPDATED_PRIMARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceNo()).isEqualTo(DEFAULT_SECONDARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceNo()).isEqualTo(DEFAULT_TERTIARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceDate()).isEqualTo(UPDATED_PRIMARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceDate()).isEqualTo(DEFAULT_SECONDARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceDate()).isEqualTo(UPDATED_TERTIARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceStatus()).isEqualTo(UPDATED_PRIMARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceStatus()).isEqualTo(UPDATED_SECONDARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceStatus()).isEqualTo(DEFAULT_TERTIARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getDos()).isEqualTo(DEFAULT_DOS);
        assertThat(testSalesOrderFinancialDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testSalesOrderFinancialDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
    }

    @Test
    void fullUpdateSalesOrderFinancialDetailsWithPatch() throws Exception {
        // Initialize the database
        salesOrderFinancialDetailsRepository.save(salesOrderFinancialDetails).block();

        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();

        // Update the salesOrderFinancialDetails using partial update
        SalesOrderFinancialDetails partialUpdatedSalesOrderFinancialDetails = new SalesOrderFinancialDetails();
        partialUpdatedSalesOrderFinancialDetails.setSalesOrderFinancialId(salesOrderFinancialDetails.getSalesOrderFinancialId());

        partialUpdatedSalesOrderFinancialDetails
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .patientId(UPDATED_PATIENT_ID)
            .itemId(UPDATED_ITEM_ID)
            .itemName(UPDATED_ITEM_NAME)
            .itemProcCode(UPDATED_ITEM_PROC_CODE)
            .chargedAmount(UPDATED_CHARGED_AMOUNT)
            .allowedAmount(UPDATED_ALLOWED_AMOUNT)
            .primaryInsurerId(UPDATED_PRIMARY_INSURER_ID)
            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
            .primaryInsurerStatus(UPDATED_PRIMARY_INSURER_STATUS)
            .primaryInsurerCoveragePercentage(UPDATED_PRIMARY_INSURER_COVERAGE_PERCENTAGE)
            .primaryInsurerCoverageAmount(UPDATED_PRIMARY_INSURER_COVERAGE_AMOUNT)
            .primaryInsurerDeductibleAmount(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT)
            .primaryInsurerPayment(UPDATED_PRIMARY_INSURER_PAYMENT)
            .primaryInsurerBalanceAmount(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT)
            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
            .secondaryInsurerStatus(UPDATED_SECONDARY_INSURER_STATUS)
            .secondaryInsurerCoveragerPercentage(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE)
            .secondaryInsurerCoverageAmount(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT)
            .secondaryInsurerPayment(UPDATED_SECONDARY_INSURER_PAYMENT)
            .secondaryInsurerBalanceAmount(UPDATED_SECONDARY_INSURER_BALANCE_AMOUNT)
            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
            .tertiaryInsurerStatus(UPDATED_TERTIARY_INSURER_STATUS)
            .tertiaryInsurerCoveragePercentage(UPDATED_TERTIARY_INSURER_COVERAGE_PERCENTAGE)
            .tertiaryInsurerCoverageAmount(UPDATED_TERTIARY_INSURER_COVERAGE_AMOUNT)
            .tertiaryInsurerPayment(UPDATED_TERTIARY_INSURER_PAYMENT)
            .tertiaryInsurerBalanceAmount(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT)
            .patientCoinsurancePercentage(UPDATED_PATIENT_COINSURANCE_PERCENTAGE)
            .patientCoinsuranceAmount(UPDATED_PATIENT_COINSURANCE_AMOUNT)
            .totalPatientResponsibilityAmount(UPDATED_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT)
            .patientPayAmount(UPDATED_PATIENT_PAY_AMOUNT)
            .narration(UPDATED_NARRATION)
            .primaryInvoiceNo(UPDATED_PRIMARY_INVOICE_NO)
            .secondaryInvoiceNo(UPDATED_SECONDARY_INVOICE_NO)
            .tertiaryInvoiceNo(UPDATED_TERTIARY_INVOICE_NO)
            .primaryInvoiceDate(UPDATED_PRIMARY_INVOICE_DATE)
            .secondaryInvoiceDate(UPDATED_SECONDARY_INVOICE_DATE)
            .tertiaryInvoiceDate(UPDATED_TERTIARY_INVOICE_DATE)
            .primaryInvoiceStatus(UPDATED_PRIMARY_INVOICE_STATUS)
            .secondaryInvoiceStatus(UPDATED_SECONDARY_INVOICE_STATUS)
            .tertiaryInvoiceStatus(UPDATED_TERTIARY_INVOICE_STATUS)
            .dos(UPDATED_DOS)
            .createdById(UPDATED_CREATED_BY_ID)
            .createdByName(UPDATED_CREATED_BY_NAME)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME)
            .updatedDate(UPDATED_UPDATED_DATE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderFinancialDetails.getSalesOrderFinancialId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderFinancialDetails))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
        SalesOrderFinancialDetails testSalesOrderFinancialDetails = salesOrderFinancialDetailsList.get(
            salesOrderFinancialDetailsList.size() - 1
        );
        assertThat(testSalesOrderFinancialDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
        assertThat(testSalesOrderFinancialDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
        assertThat(testSalesOrderFinancialDetails.getItemId()).isEqualTo(UPDATED_ITEM_ID);
        assertThat(testSalesOrderFinancialDetails.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testSalesOrderFinancialDetails.getItemProcCode()).isEqualTo(UPDATED_ITEM_PROC_CODE);
        assertThat(testSalesOrderFinancialDetails.getChargedAmount()).isEqualTo(UPDATED_CHARGED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getAllowedAmount()).isEqualTo(UPDATED_ALLOWED_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerId()).isEqualTo(UPDATED_PRIMARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerName()).isEqualTo(UPDATED_PRIMARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerStatus()).isEqualTo(UPDATED_PRIMARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoveragePercentage())
            .isEqualTo(UPDATED_PRIMARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerCoverageAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerDeductibleAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_DEDUCTIBLE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerPayment()).isEqualTo(UPDATED_PRIMARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInsurerBalanceAmount()).isEqualTo(UPDATED_PRIMARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerId()).isEqualTo(UPDATED_SECONDARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerName()).isEqualTo(UPDATED_SECONDARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerStatus()).isEqualTo(UPDATED_SECONDARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoveragerPercentage())
            .isEqualTo(UPDATED_SECONDARY_INSURER_COVERAGER_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerCoverageAmount()).isEqualTo(UPDATED_SECONDARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerPayment()).isEqualTo(UPDATED_SECONDARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInsurerBalanceAmount()).isEqualTo(UPDATED_SECONDARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerId()).isEqualTo(UPDATED_TERTIARY_INSURER_ID);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerName()).isEqualTo(UPDATED_TERTIARY_INSURER_NAME);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerStatus()).isEqualTo(UPDATED_TERTIARY_INSURER_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoveragePercentage())
            .isEqualTo(UPDATED_TERTIARY_INSURER_COVERAGE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerCoverageAmount()).isEqualTo(UPDATED_TERTIARY_INSURER_COVERAGE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerPayment()).isEqualTo(UPDATED_TERTIARY_INSURER_PAYMENT);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInsurerBalanceAmount()).isEqualTo(UPDATED_TERTIARY_INSURER_BALANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsurancePercentage()).isEqualTo(UPDATED_PATIENT_COINSURANCE_PERCENTAGE);
        assertThat(testSalesOrderFinancialDetails.getPatientCoinsuranceAmount()).isEqualTo(UPDATED_PATIENT_COINSURANCE_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getTotalPatientResponsibilityAmount())
            .isEqualTo(UPDATED_TOTAL_PATIENT_RESPONSIBILITY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getPatientPayAmount()).isEqualTo(UPDATED_PATIENT_PAY_AMOUNT);
        assertThat(testSalesOrderFinancialDetails.getNarration()).isEqualTo(UPDATED_NARRATION);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceNo()).isEqualTo(UPDATED_PRIMARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceNo()).isEqualTo(UPDATED_SECONDARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceNo()).isEqualTo(UPDATED_TERTIARY_INVOICE_NO);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceDate()).isEqualTo(UPDATED_PRIMARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceDate()).isEqualTo(UPDATED_SECONDARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceDate()).isEqualTo(UPDATED_TERTIARY_INVOICE_DATE);
        assertThat(testSalesOrderFinancialDetails.getPrimaryInvoiceStatus()).isEqualTo(UPDATED_PRIMARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getSecondaryInvoiceStatus()).isEqualTo(UPDATED_SECONDARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getTertiaryInvoiceStatus()).isEqualTo(UPDATED_TERTIARY_INVOICE_STATUS);
        assertThat(testSalesOrderFinancialDetails.getDos()).isEqualTo(UPDATED_DOS);
        assertThat(testSalesOrderFinancialDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testSalesOrderFinancialDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
        assertThat(testSalesOrderFinancialDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
        assertThat(testSalesOrderFinancialDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
    }

    @Test
    void patchNonExistingSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        salesOrderFinancialDetails.setSalesOrderFinancialId(count.incrementAndGet());

        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, salesOrderFinancialDetailsDTO.getSalesOrderFinancialId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        salesOrderFinancialDetails.setSalesOrderFinancialId(count.incrementAndGet());

        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamSalesOrderFinancialDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();
        salesOrderFinancialDetails.setSalesOrderFinancialId(count.incrementAndGet());

        // Create the SalesOrderFinancialDetails
        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = salesOrderFinancialDetailsMapper.toDto(salesOrderFinancialDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderFinancialDetailsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the SalesOrderFinancialDetails in the database
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteSalesOrderFinancialDetails() {
        // Initialize the database
        salesOrderFinancialDetailsRepository.save(salesOrderFinancialDetails).block();

        int databaseSizeBeforeDelete = salesOrderFinancialDetailsRepository.findAll().collectList().block().size();

        // Delete the salesOrderFinancialDetails
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, salesOrderFinancialDetails.getSalesOrderFinancialId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<SalesOrderFinancialDetails> salesOrderFinancialDetailsList = salesOrderFinancialDetailsRepository
            .findAll()
            .collectList()
            .block();
        assertThat(salesOrderFinancialDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
