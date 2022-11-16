package com.sunknowledge.dme.rcm.web.rest;

import static com.sunknowledge.dme.rcm.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.SalesOrderClinicalDetails;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.SalesOrderClinicalDetailsRepository;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderClinicalDetailsDTO;
import com.sunknowledge.dme.rcm.service.mapper.SalesOrderClinicalDetailsMapper;
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
 * Integration tests for the {@link SalesOrderClinicalDetailsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class SalesOrderClinicalDetailsResourceIT {

    private static final Long DEFAULT_SALES_ORDER_ID = 1L;
    private static final Long UPDATED_SALES_ORDER_ID = 2L;

    private static final Integer DEFAULT_PATIENT_ID = 1;
    private static final Integer UPDATED_PATIENT_ID = 2;

    private static final Double DEFAULT_PATIENT_WEIGHT_IN_KG = 1D;
    private static final Double UPDATED_PATIENT_WEIGHT_IN_KG = 2D;

    private static final Double DEFAULT_PATIENT_WEIGHT_IN_LBS = 1D;
    private static final Double UPDATED_PATIENT_WEIGHT_IN_LBS = 2D;

    private static final Double DEFAULT_HEIGHT_IN_INCHES = 1D;
    private static final Double UPDATED_HEIGHT_IN_INCHES = 2D;

    private static final Double DEFAULT_HEIGHT_IN_CM = 1D;
    private static final Double UPDATED_HEIGHT_IN_CM = 2D;

    private static final Integer DEFAULT_SALES_REP_ID = 1;
    private static final Integer UPDATED_SALES_REP_ID = 2;

    private static final String DEFAULT_SALESEP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SALESEP_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_PRACTITIONER_ID = 1;
    private static final Integer UPDATED_PRACTITIONER_ID = 2;

    private static final String DEFAULT_RENDERING_PROVIDER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_RENDERING_PROVIDER_FACILITY_ID = 1;
    private static final Integer UPDATED_RENDERING_PROVIDER_FACILITY_ID = 2;

    private static final String DEFAULT_RENDERING_PROVIDER_FACILITY_NAME = "Rkqyrb8";
    private static final String UPDATED_RENDERING_PROVIDER_FACILITY_NAME = "Hrvbb1";

    private static final Integer DEFAULT_RENDERING_PROVIDER_ID = 1;
    private static final Integer UPDATED_RENDERING_PROVIDER_ID = 2;

    private static final String DEFAULT_RENDERING_PROVIDER_FIRST_NAME = "Llv6";
    private static final String UPDATED_RENDERING_PROVIDER_FIRST_NAME = "Zquip1";

    private static final String DEFAULT_RENDERING_PROVIDER_MIDDLE_NAME = "Hmcnc4";
    private static final String UPDATED_RENDERING_PROVIDER_MIDDLE_NAME = "Hbil3";

    private static final String DEFAULT_RENDERING_PROVIDER_LAST_NAME = "Nvrt9";
    private static final String UPDATED_RENDERING_PROVIDER_LAST_NAME = "Dsn4";

    private static final String DEFAULT_RENDERING_PROVIDER_NPI = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_NPI = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_DEA = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_DEA = "BBBBBBBBBB";

    private static final Integer DEFAULT_RENDERING_PROVIDER_ADDRESS_ID = 1;
    private static final Integer UPDATED_RENDERING_PROVIDER_ADDRESS_ID = 2;

    private static final String DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_1 = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_2 = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_CITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_CITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_STATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_STATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_ZIP = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_ZIP = "BBBBBBBBBB";

    private static final Integer DEFAULT_RENDERING_PROVIDER_CONTACT_ID = 1;
    private static final Integer UPDATED_RENDERING_PROVIDER_CONTACT_ID = 2;

    private static final String DEFAULT_RENDERING_PROVIDER_PHONE_1 = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_PHONE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_PHONE_2 = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_PHONE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_RENDERING_PROVIDER_FAX = "AAAAAAAAAA";
    private static final String UPDATED_RENDERING_PROVIDER_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_REFERRING_PROVIDER_FACILITY_ID = 1;
    private static final Integer UPDATED_REFERRING_PROVIDER_FACILITY_ID = 2;

    private static final String DEFAULT_REFERRING_PROVIDER_FACILITY_NAME = "Cnlssa0";
    private static final String UPDATED_REFERRING_PROVIDER_FACILITY_NAME = "Urhpsq9";

    private static final Integer DEFAULT_REFERRING_PROVIDER_ID = 1;
    private static final Integer UPDATED_REFERRING_PROVIDER_ID = 2;

    private static final String DEFAULT_REFERRING_PROVIDER_FIRST_NAME = "Cf7";
    private static final String UPDATED_REFERRING_PROVIDER_FIRST_NAME = "Xsojlw3";

    private static final String DEFAULT_REFERRING_PROVIDER_MIDDLE_NAME = "Piac3";
    private static final String UPDATED_REFERRING_PROVIDER_MIDDLE_NAME = "Ipcmq5";

    private static final String DEFAULT_REFERRING_PROVIDER_LAST_NAME = "Fxle5";
    private static final String UPDATED_REFERRING_PROVIDER_LAST_NAME = "Gvaxpue8";

    private static final String DEFAULT_REFERRING_PROVIDER_NPI = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_NPI = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_DEA = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_DEA = "BBBBBBBBBB";

    private static final Integer DEFAULT_REFERRING_PROVIDER_ADDRESS_ID = 1;
    private static final Integer UPDATED_REFERRING_PROVIDER_ADDRESS_ID = 2;

    private static final String DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_1 = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_2 = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_CITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_CITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_STATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_STATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_ZIP = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_ZIP = "BBBBBBBBBB";

    private static final Integer DEFAULT_REFERRING_PROVIDER_CONTACT_ID = 1;
    private static final Integer UPDATED_REFERRING_PROVIDER_CONTACT_ID = 2;

    private static final String DEFAULT_REFERRING_PROVIDER_PHONE_1 = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_PHONE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_PHONE_2 = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_PHONE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_REFERRING_PROVIDER_FAX = "AAAAAAAAAA";
    private static final String UPDATED_REFERRING_PROVIDER_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORDERING_PROVIDER_FACILITY_ID = 1;
    private static final Integer UPDATED_ORDERING_PROVIDER_FACILITY_ID = 2;

    private static final String DEFAULT_ORDERING_PROVIDER_FACILITY_NAME = "Gomxh6";
    private static final String UPDATED_ORDERING_PROVIDER_FACILITY_NAME = "Fzbpne7";

    private static final Integer DEFAULT_ORDERING_PROVIDER_ID = 1;
    private static final Integer UPDATED_ORDERING_PROVIDER_ID = 2;

    private static final String DEFAULT_ORDERING_PROVIDER_FIRST_NAME = "Zkg8";
    private static final String UPDATED_ORDERING_PROVIDER_FIRST_NAME = "Dwqy5";

    private static final String DEFAULT_ORDERING_PROVIDER_MIDDLE_NAME = "Vozv6";
    private static final String UPDATED_ORDERING_PROVIDER_MIDDLE_NAME = "Ik3";

    private static final String DEFAULT_ORDERING_PROVIDER_LAST_NAME = "Snvie7";
    private static final String UPDATED_ORDERING_PROVIDER_LAST_NAME = "Wfubx4";

    private static final String DEFAULT_ORDERING_PROVIDER_NPI = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_NPI = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_DEA = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_DEA = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORDERING_PROVIDER_ADDRESS_ID = 1;
    private static final Integer UPDATED_ORDERING_PROVIDER_ADDRESS_ID = 2;

    private static final String DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_1 = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_2 = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_CITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_CITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_STATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_STATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_ZIP = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_ZIP = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORDERING_PROVIDER_CONTACT_ID = 1;
    private static final Integer UPDATED_ORDERING_PROVIDER_CONTACT_ID = 2;

    private static final String DEFAULT_ORDERING_PROVIDER_PHONE_1 = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_PHONE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_PHONE_2 = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_PHONE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_ORDERING_PROVIDER_FAX = "AAAAAAAAAA";
    private static final String UPDATED_ORDERING_PROVIDER_FAX = "BBBBBBBBBB";

    private static final Integer DEFAULT_MARKETING_REFERAL_TYPE_ID = 1;
    private static final Integer UPDATED_MARKETING_REFERAL_TYPE_ID = 2;

    private static final String DEFAULT_MARKETING_REFERAL_TYPE_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_MARKETING_REFERAL_TYPE_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_MARKETING_REFERAL_ID = 1;
    private static final Integer UPDATED_MARKETING_REFERAL_ID = 2;

    private static final String DEFAULT_MARKETING_REFERAL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MARKETING_REFERAL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_1 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_2 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_3 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_4 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_5 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_6 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_6 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_7 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_7 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_8 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_8 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_9 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_9 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_10 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_10 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_11 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_11 = "BBBBBBBBBB";

    private static final String DEFAULT_ICD_10_DIAGNOSIS_CODE_12 = "AAAAAAAAAA";
    private static final String UPDATED_ICD_10_DIAGNOSIS_CODE_12 = "BBBBBBBBBB";

    private static final String DEFAULT_EPSDT_CERTIFICATION_CONDITION_INDICATOR = "AAAAAAAAAA";
    private static final String UPDATED_EPSDT_CERTIFICATION_CONDITION_INDICATOR = "BBBBBBBBBB";

    private static final String DEFAULT_EPSDT_CERTIFICATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_EPSDT_CERTIFICATION_CODE = "BBBBBBBBBB";

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

    private static final String ENTITY_API_URL = "/api/sales-order-clinical-details";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{salesOderClinicalDetailsId}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SalesOrderClinicalDetailsRepository salesOrderClinicalDetailsRepository;

    @Autowired
    private SalesOrderClinicalDetailsMapper salesOrderClinicalDetailsMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private SalesOrderClinicalDetails salesOrderClinicalDetails;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SalesOrderClinicalDetails createEntity(EntityManager em) {
        SalesOrderClinicalDetails salesOrderClinicalDetails = new SalesOrderClinicalDetails()
            .salesOrderId(DEFAULT_SALES_ORDER_ID)
            .patientId(DEFAULT_PATIENT_ID)
            .patientWeightInKg(DEFAULT_PATIENT_WEIGHT_IN_KG)
            .patientWeightInLbs(DEFAULT_PATIENT_WEIGHT_IN_LBS)
            .heightInInches(DEFAULT_HEIGHT_IN_INCHES)
            .heightInCm(DEFAULT_HEIGHT_IN_CM)
            .salesRepId(DEFAULT_SALES_REP_ID)
            .salesepName(DEFAULT_SALESEP_NAME)
            .practitionerId(DEFAULT_PRACTITIONER_ID)
            .renderingProviderType(DEFAULT_RENDERING_PROVIDER_TYPE)
            .renderingProviderFacilityId(DEFAULT_RENDERING_PROVIDER_FACILITY_ID)
            .renderingProviderFacilityName(DEFAULT_RENDERING_PROVIDER_FACILITY_NAME)
            .renderingProviderId(DEFAULT_RENDERING_PROVIDER_ID)
            .renderingProviderFirstName(DEFAULT_RENDERING_PROVIDER_FIRST_NAME)
            .renderingProviderMiddleName(DEFAULT_RENDERING_PROVIDER_MIDDLE_NAME)
            .renderingProviderLastName(DEFAULT_RENDERING_PROVIDER_LAST_NAME)
            .renderingProviderNpi(DEFAULT_RENDERING_PROVIDER_NPI)
            .renderingProviderDea(DEFAULT_RENDERING_PROVIDER_DEA)
            .renderingProviderAddressId(DEFAULT_RENDERING_PROVIDER_ADDRESS_ID)
            .renderingProviderAddressLine1(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_1)
            .renderingProviderAddressLine2(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_2)
            .renderingProviderCityName(DEFAULT_RENDERING_PROVIDER_CITY_NAME)
            .renderingProviderStateName(DEFAULT_RENDERING_PROVIDER_STATE_NAME)
            .renderingProviderZip(DEFAULT_RENDERING_PROVIDER_ZIP)
            .renderingProviderContactId(DEFAULT_RENDERING_PROVIDER_CONTACT_ID)
            .renderingProviderPhone1(DEFAULT_RENDERING_PROVIDER_PHONE_1)
            .renderingProviderPhone2(DEFAULT_RENDERING_PROVIDER_PHONE_2)
            .renderingProviderEmail(DEFAULT_RENDERING_PROVIDER_EMAIL)
            .renderingProviderFax(DEFAULT_RENDERING_PROVIDER_FAX)
            .referringProviderType(DEFAULT_REFERRING_PROVIDER_TYPE)
            .referringProviderFacilityId(DEFAULT_REFERRING_PROVIDER_FACILITY_ID)
            .referringProviderFacilityName(DEFAULT_REFERRING_PROVIDER_FACILITY_NAME)
            .referringProviderId(DEFAULT_REFERRING_PROVIDER_ID)
            .referringProviderFirstName(DEFAULT_REFERRING_PROVIDER_FIRST_NAME)
            .referringProviderMiddleName(DEFAULT_REFERRING_PROVIDER_MIDDLE_NAME)
            .referringProviderLastName(DEFAULT_REFERRING_PROVIDER_LAST_NAME)
            .referringProviderNpi(DEFAULT_REFERRING_PROVIDER_NPI)
            .referringProviderDea(DEFAULT_REFERRING_PROVIDER_DEA)
            .referringProviderAddressId(DEFAULT_REFERRING_PROVIDER_ADDRESS_ID)
            .referringProviderAddressLine1(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_1)
            .referringProviderAddressLine2(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_2)
            .referringProviderCityName(DEFAULT_REFERRING_PROVIDER_CITY_NAME)
            .referringProviderStateName(DEFAULT_REFERRING_PROVIDER_STATE_NAME)
            .referringProviderZip(DEFAULT_REFERRING_PROVIDER_ZIP)
            .referringProviderContactId(DEFAULT_REFERRING_PROVIDER_CONTACT_ID)
            .referringProviderPhone1(DEFAULT_REFERRING_PROVIDER_PHONE_1)
            .referringProviderPhone2(DEFAULT_REFERRING_PROVIDER_PHONE_2)
            .referringProviderEmail(DEFAULT_REFERRING_PROVIDER_EMAIL)
            .referringProviderFax(DEFAULT_REFERRING_PROVIDER_FAX)
            .orderingProviderType(DEFAULT_ORDERING_PROVIDER_TYPE)
            .orderingProviderFacilityId(DEFAULT_ORDERING_PROVIDER_FACILITY_ID)
            .orderingProviderFacilityName(DEFAULT_ORDERING_PROVIDER_FACILITY_NAME)
            .orderingProviderId(DEFAULT_ORDERING_PROVIDER_ID)
            .orderingProviderFirstName(DEFAULT_ORDERING_PROVIDER_FIRST_NAME)
            .orderingProviderMiddleName(DEFAULT_ORDERING_PROVIDER_MIDDLE_NAME)
            .orderingProviderLastName(DEFAULT_ORDERING_PROVIDER_LAST_NAME)
            .orderingProviderNpi(DEFAULT_ORDERING_PROVIDER_NPI)
            .orderingProviderDea(DEFAULT_ORDERING_PROVIDER_DEA)
            .orderingProviderAddressId(DEFAULT_ORDERING_PROVIDER_ADDRESS_ID)
            .orderingProviderAddressLine1(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_1)
            .orderingProviderAddressLine2(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_2)
            .orderingProviderCityName(DEFAULT_ORDERING_PROVIDER_CITY_NAME)
            .orderingProviderStateName(DEFAULT_ORDERING_PROVIDER_STATE_NAME)
            .orderingProviderZip(DEFAULT_ORDERING_PROVIDER_ZIP)
            .orderingProviderContactId(DEFAULT_ORDERING_PROVIDER_CONTACT_ID)
            .orderingProviderPhone1(DEFAULT_ORDERING_PROVIDER_PHONE_1)
            .orderingProviderPhone2(DEFAULT_ORDERING_PROVIDER_PHONE_2)
            .orderingProviderEmail(DEFAULT_ORDERING_PROVIDER_EMAIL)
            .orderingProviderFax(DEFAULT_ORDERING_PROVIDER_FAX)
            .marketingReferalTypeId(DEFAULT_MARKETING_REFERAL_TYPE_ID)
            .marketingReferalTypeDescription(DEFAULT_MARKETING_REFERAL_TYPE_DESCRIPTION)
            .marketingReferalId(DEFAULT_MARKETING_REFERAL_ID)
            .marketingReferalName(DEFAULT_MARKETING_REFERAL_NAME)
            .icd10DiagnosisCode1(DEFAULT_ICD_10_DIAGNOSIS_CODE_1)
            .icd10DiagnosisCode2(DEFAULT_ICD_10_DIAGNOSIS_CODE_2)
            .icd10DiagnosisCode3(DEFAULT_ICD_10_DIAGNOSIS_CODE_3)
            .icd10DiagnosisCode4(DEFAULT_ICD_10_DIAGNOSIS_CODE_4)
            .icd10DiagnosisCode5(DEFAULT_ICD_10_DIAGNOSIS_CODE_5)
            .icd10DiagnosisCode6(DEFAULT_ICD_10_DIAGNOSIS_CODE_6)
            .icd10DiagnosisCode7(DEFAULT_ICD_10_DIAGNOSIS_CODE_7)
            .icd10DiagnosisCode8(DEFAULT_ICD_10_DIAGNOSIS_CODE_8)
            .icd10DiagnosisCode9(DEFAULT_ICD_10_DIAGNOSIS_CODE_9)
            .icd10DiagnosisCode10(DEFAULT_ICD_10_DIAGNOSIS_CODE_10)
            .icd10DiagnosisCode11(DEFAULT_ICD_10_DIAGNOSIS_CODE_11)
            .icd10DiagnosisCode12(DEFAULT_ICD_10_DIAGNOSIS_CODE_12)
            .epsdtCertificationConditionIndicator(DEFAULT_EPSDT_CERTIFICATION_CONDITION_INDICATOR)
            .epsdtCertificationCode(DEFAULT_EPSDT_CERTIFICATION_CODE)
            .status(DEFAULT_STATUS)
            .createdById(DEFAULT_CREATED_BY_ID)
            .createdByName(DEFAULT_CREATED_BY_NAME)
            .createdDate(DEFAULT_CREATED_DATE)
            .updatedById(DEFAULT_UPDATED_BY_ID)
            .updatedByName(DEFAULT_UPDATED_BY_NAME)
            .updatedDate(DEFAULT_UPDATED_DATE);
        return salesOrderClinicalDetails;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SalesOrderClinicalDetails createUpdatedEntity(EntityManager em) {
        SalesOrderClinicalDetails salesOrderClinicalDetails = new SalesOrderClinicalDetails()
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .patientId(UPDATED_PATIENT_ID)
            .patientWeightInKg(UPDATED_PATIENT_WEIGHT_IN_KG)
            .patientWeightInLbs(UPDATED_PATIENT_WEIGHT_IN_LBS)
            .heightInInches(UPDATED_HEIGHT_IN_INCHES)
            .heightInCm(UPDATED_HEIGHT_IN_CM)
            .salesRepId(UPDATED_SALES_REP_ID)
            .salesepName(UPDATED_SALESEP_NAME)
            .practitionerId(UPDATED_PRACTITIONER_ID)
            .renderingProviderType(UPDATED_RENDERING_PROVIDER_TYPE)
            .renderingProviderFacilityId(UPDATED_RENDERING_PROVIDER_FACILITY_ID)
            .renderingProviderFacilityName(UPDATED_RENDERING_PROVIDER_FACILITY_NAME)
            .renderingProviderId(UPDATED_RENDERING_PROVIDER_ID)
            .renderingProviderFirstName(UPDATED_RENDERING_PROVIDER_FIRST_NAME)
            .renderingProviderMiddleName(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME)
            .renderingProviderLastName(UPDATED_RENDERING_PROVIDER_LAST_NAME)
            .renderingProviderNpi(UPDATED_RENDERING_PROVIDER_NPI)
            .renderingProviderDea(UPDATED_RENDERING_PROVIDER_DEA)
            .renderingProviderAddressId(UPDATED_RENDERING_PROVIDER_ADDRESS_ID)
            .renderingProviderAddressLine1(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_1)
            .renderingProviderAddressLine2(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_2)
            .renderingProviderCityName(UPDATED_RENDERING_PROVIDER_CITY_NAME)
            .renderingProviderStateName(UPDATED_RENDERING_PROVIDER_STATE_NAME)
            .renderingProviderZip(UPDATED_RENDERING_PROVIDER_ZIP)
            .renderingProviderContactId(UPDATED_RENDERING_PROVIDER_CONTACT_ID)
            .renderingProviderPhone1(UPDATED_RENDERING_PROVIDER_PHONE_1)
            .renderingProviderPhone2(UPDATED_RENDERING_PROVIDER_PHONE_2)
            .renderingProviderEmail(UPDATED_RENDERING_PROVIDER_EMAIL)
            .renderingProviderFax(UPDATED_RENDERING_PROVIDER_FAX)
            .referringProviderType(UPDATED_REFERRING_PROVIDER_TYPE)
            .referringProviderFacilityId(UPDATED_REFERRING_PROVIDER_FACILITY_ID)
            .referringProviderFacilityName(UPDATED_REFERRING_PROVIDER_FACILITY_NAME)
            .referringProviderId(UPDATED_REFERRING_PROVIDER_ID)
            .referringProviderFirstName(UPDATED_REFERRING_PROVIDER_FIRST_NAME)
            .referringProviderMiddleName(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME)
            .referringProviderLastName(UPDATED_REFERRING_PROVIDER_LAST_NAME)
            .referringProviderNpi(UPDATED_REFERRING_PROVIDER_NPI)
            .referringProviderDea(UPDATED_REFERRING_PROVIDER_DEA)
            .referringProviderAddressId(UPDATED_REFERRING_PROVIDER_ADDRESS_ID)
            .referringProviderAddressLine1(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1)
            .referringProviderAddressLine2(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2)
            .referringProviderCityName(UPDATED_REFERRING_PROVIDER_CITY_NAME)
            .referringProviderStateName(UPDATED_REFERRING_PROVIDER_STATE_NAME)
            .referringProviderZip(UPDATED_REFERRING_PROVIDER_ZIP)
            .referringProviderContactId(UPDATED_REFERRING_PROVIDER_CONTACT_ID)
            .referringProviderPhone1(UPDATED_REFERRING_PROVIDER_PHONE_1)
            .referringProviderPhone2(UPDATED_REFERRING_PROVIDER_PHONE_2)
            .referringProviderEmail(UPDATED_REFERRING_PROVIDER_EMAIL)
            .referringProviderFax(UPDATED_REFERRING_PROVIDER_FAX)
            .orderingProviderType(UPDATED_ORDERING_PROVIDER_TYPE)
            .orderingProviderFacilityId(UPDATED_ORDERING_PROVIDER_FACILITY_ID)
            .orderingProviderFacilityName(UPDATED_ORDERING_PROVIDER_FACILITY_NAME)
            .orderingProviderId(UPDATED_ORDERING_PROVIDER_ID)
            .orderingProviderFirstName(UPDATED_ORDERING_PROVIDER_FIRST_NAME)
            .orderingProviderMiddleName(UPDATED_ORDERING_PROVIDER_MIDDLE_NAME)
            .orderingProviderLastName(UPDATED_ORDERING_PROVIDER_LAST_NAME)
            .orderingProviderNpi(UPDATED_ORDERING_PROVIDER_NPI)
            .orderingProviderDea(UPDATED_ORDERING_PROVIDER_DEA)
            .orderingProviderAddressId(UPDATED_ORDERING_PROVIDER_ADDRESS_ID)
            .orderingProviderAddressLine1(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_1)
            .orderingProviderAddressLine2(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_2)
            .orderingProviderCityName(UPDATED_ORDERING_PROVIDER_CITY_NAME)
            .orderingProviderStateName(UPDATED_ORDERING_PROVIDER_STATE_NAME)
            .orderingProviderZip(UPDATED_ORDERING_PROVIDER_ZIP)
            .orderingProviderContactId(UPDATED_ORDERING_PROVIDER_CONTACT_ID)
            .orderingProviderPhone1(UPDATED_ORDERING_PROVIDER_PHONE_1)
            .orderingProviderPhone2(UPDATED_ORDERING_PROVIDER_PHONE_2)
            .orderingProviderEmail(UPDATED_ORDERING_PROVIDER_EMAIL)
            .orderingProviderFax(UPDATED_ORDERING_PROVIDER_FAX)
            .marketingReferalTypeId(UPDATED_MARKETING_REFERAL_TYPE_ID)
            .marketingReferalTypeDescription(UPDATED_MARKETING_REFERAL_TYPE_DESCRIPTION)
            .marketingReferalId(UPDATED_MARKETING_REFERAL_ID)
            .marketingReferalName(UPDATED_MARKETING_REFERAL_NAME)
            .icd10DiagnosisCode1(UPDATED_ICD_10_DIAGNOSIS_CODE_1)
            .icd10DiagnosisCode2(UPDATED_ICD_10_DIAGNOSIS_CODE_2)
            .icd10DiagnosisCode3(UPDATED_ICD_10_DIAGNOSIS_CODE_3)
            .icd10DiagnosisCode4(UPDATED_ICD_10_DIAGNOSIS_CODE_4)
            .icd10DiagnosisCode5(UPDATED_ICD_10_DIAGNOSIS_CODE_5)
            .icd10DiagnosisCode6(UPDATED_ICD_10_DIAGNOSIS_CODE_6)
            .icd10DiagnosisCode7(UPDATED_ICD_10_DIAGNOSIS_CODE_7)
            .icd10DiagnosisCode8(UPDATED_ICD_10_DIAGNOSIS_CODE_8)
            .icd10DiagnosisCode9(UPDATED_ICD_10_DIAGNOSIS_CODE_9)
            .icd10DiagnosisCode10(UPDATED_ICD_10_DIAGNOSIS_CODE_10)
            .icd10DiagnosisCode11(UPDATED_ICD_10_DIAGNOSIS_CODE_11)
            .icd10DiagnosisCode12(UPDATED_ICD_10_DIAGNOSIS_CODE_12)
            .epsdtCertificationConditionIndicator(UPDATED_EPSDT_CERTIFICATION_CONDITION_INDICATOR)
            .epsdtCertificationCode(UPDATED_EPSDT_CERTIFICATION_CODE)
            .status(UPDATED_STATUS)
            .createdById(UPDATED_CREATED_BY_ID)
            .createdByName(UPDATED_CREATED_BY_NAME)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME)
            .updatedDate(UPDATED_UPDATED_DATE);
        return salesOrderClinicalDetails;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(SalesOrderClinicalDetails.class).block();
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
        salesOrderClinicalDetails = createEntity(em);
    }

    @Test
    void createSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeCreate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        SalesOrderClinicalDetails testSalesOrderClinicalDetails = salesOrderClinicalDetailsList.get(
            salesOrderClinicalDetailsList.size() - 1
        );
        assertThat(testSalesOrderClinicalDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInKg()).isEqualTo(DEFAULT_PATIENT_WEIGHT_IN_KG);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInLbs()).isEqualTo(DEFAULT_PATIENT_WEIGHT_IN_LBS);
        assertThat(testSalesOrderClinicalDetails.getHeightInInches()).isEqualTo(DEFAULT_HEIGHT_IN_INCHES);
        assertThat(testSalesOrderClinicalDetails.getHeightInCm()).isEqualTo(DEFAULT_HEIGHT_IN_CM);
        assertThat(testSalesOrderClinicalDetails.getSalesRepId()).isEqualTo(DEFAULT_SALES_REP_ID);
        assertThat(testSalesOrderClinicalDetails.getSalesepName()).isEqualTo(DEFAULT_SALESEP_NAME);
        assertThat(testSalesOrderClinicalDetails.getPractitionerId()).isEqualTo(DEFAULT_PRACTITIONER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderType()).isEqualTo(DEFAULT_RENDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityId()).isEqualTo(DEFAULT_RENDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderId()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFirstName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderMiddleName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderLastName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderNpi()).isEqualTo(DEFAULT_RENDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderDea()).isEqualTo(DEFAULT_RENDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressId()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine1()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine2()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderCityName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderStateName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderZip()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderContactId()).isEqualTo(DEFAULT_RENDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone1()).isEqualTo(DEFAULT_RENDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone2()).isEqualTo(DEFAULT_RENDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderEmail()).isEqualTo(DEFAULT_RENDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFax()).isEqualTo(DEFAULT_RENDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderType()).isEqualTo(DEFAULT_REFERRING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityId()).isEqualTo(DEFAULT_REFERRING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityName()).isEqualTo(DEFAULT_REFERRING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderId()).isEqualTo(DEFAULT_REFERRING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFirstName()).isEqualTo(DEFAULT_REFERRING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderMiddleName()).isEqualTo(DEFAULT_REFERRING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderLastName()).isEqualTo(DEFAULT_REFERRING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderNpi()).isEqualTo(DEFAULT_REFERRING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderDea()).isEqualTo(DEFAULT_REFERRING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressId()).isEqualTo(DEFAULT_REFERRING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine1()).isEqualTo(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine2()).isEqualTo(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderCityName()).isEqualTo(DEFAULT_REFERRING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderStateName()).isEqualTo(DEFAULT_REFERRING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderZip()).isEqualTo(DEFAULT_REFERRING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderContactId()).isEqualTo(DEFAULT_REFERRING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone1()).isEqualTo(DEFAULT_REFERRING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone2()).isEqualTo(DEFAULT_REFERRING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderEmail()).isEqualTo(DEFAULT_REFERRING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFax()).isEqualTo(DEFAULT_REFERRING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderType()).isEqualTo(DEFAULT_ORDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityId()).isEqualTo(DEFAULT_ORDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderId()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFirstName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderMiddleName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderLastName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderNpi()).isEqualTo(DEFAULT_ORDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderDea()).isEqualTo(DEFAULT_ORDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressId()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine1()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine2()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderCityName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderStateName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderZip()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderContactId()).isEqualTo(DEFAULT_ORDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone1()).isEqualTo(DEFAULT_ORDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone2()).isEqualTo(DEFAULT_ORDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderEmail()).isEqualTo(DEFAULT_ORDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFax()).isEqualTo(DEFAULT_ORDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeId()).isEqualTo(DEFAULT_MARKETING_REFERAL_TYPE_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeDescription())
            .isEqualTo(DEFAULT_MARKETING_REFERAL_TYPE_DESCRIPTION);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalId()).isEqualTo(DEFAULT_MARKETING_REFERAL_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalName()).isEqualTo(DEFAULT_MARKETING_REFERAL_NAME);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode1()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_1);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode2()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_2);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode3()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_3);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode4()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_4);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode5()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_5);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode6()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_6);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode7()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_7);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode8()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_8);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode9()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_9);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode10()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_10);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode11()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_11);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode12()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_12);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationConditionIndicator())
            .isEqualTo(DEFAULT_EPSDT_CERTIFICATION_CONDITION_INDICATOR);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationCode()).isEqualTo(DEFAULT_EPSDT_CERTIFICATION_CODE);
        assertThat(testSalesOrderClinicalDetails.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSalesOrderClinicalDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testSalesOrderClinicalDetails.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
    }

    @Test
    void createSalesOrderClinicalDetailsWithExistingId() throws Exception {
        // Create the SalesOrderClinicalDetails with an existing ID
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(1L);
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        int databaseSizeBeforeCreate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkSalesOrderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setSalesOrderId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkPatientIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setPatientId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkSalesepNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setSalesepName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderFirstNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderFirstName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderLastNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderLastName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderNpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderNpi(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderDeaIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderDea(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderAddressIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderAddressId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkRenderingProviderContactIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setRenderingProviderContactId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderFirstNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderFirstName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderLastNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderLastName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderNpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderNpi(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderDeaIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderDea(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderAddressIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderAddressId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkReferringProviderContactIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setReferringProviderContactId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderFirstNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderFirstName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderLastNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderLastName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderNpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderNpi(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderDeaIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderDea(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderAddressIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderAddressId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkOrderingProviderContactIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setOrderingProviderContactId(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkMarketingReferalNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        // set the field null
        salesOrderClinicalDetails.setMarketingReferalName(null);

        // Create the SalesOrderClinicalDetails, which fails.
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllSalesOrderClinicalDetails() {
        // Initialize the database
        salesOrderClinicalDetailsRepository.save(salesOrderClinicalDetails).block();

        // Get all the salesOrderClinicalDetailsList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=salesOderClinicalDetailsId,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].salesOderClinicalDetailsId")
            .value(hasItem(salesOrderClinicalDetails.getSalesOderClinicalDetailsId().intValue()))
            .jsonPath("$.[*].salesOrderId")
            .value(hasItem(DEFAULT_SALES_ORDER_ID.intValue()))
            .jsonPath("$.[*].patientId")
            .value(hasItem(DEFAULT_PATIENT_ID))
            .jsonPath("$.[*].patientWeightInKg")
            .value(hasItem(DEFAULT_PATIENT_WEIGHT_IN_KG.doubleValue()))
            .jsonPath("$.[*].patientWeightInLbs")
            .value(hasItem(DEFAULT_PATIENT_WEIGHT_IN_LBS.doubleValue()))
            .jsonPath("$.[*].heightInInches")
            .value(hasItem(DEFAULT_HEIGHT_IN_INCHES.doubleValue()))
            .jsonPath("$.[*].heightInCm")
            .value(hasItem(DEFAULT_HEIGHT_IN_CM.doubleValue()))
            .jsonPath("$.[*].salesRepId")
            .value(hasItem(DEFAULT_SALES_REP_ID))
            .jsonPath("$.[*].salesepName")
            .value(hasItem(DEFAULT_SALESEP_NAME))
            .jsonPath("$.[*].practitionerId")
            .value(hasItem(DEFAULT_PRACTITIONER_ID))
            .jsonPath("$.[*].renderingProviderType")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_TYPE))
            .jsonPath("$.[*].renderingProviderFacilityId")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_FACILITY_ID))
            .jsonPath("$.[*].renderingProviderFacilityName")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_FACILITY_NAME))
            .jsonPath("$.[*].renderingProviderId")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_ID))
            .jsonPath("$.[*].renderingProviderFirstName")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_FIRST_NAME))
            .jsonPath("$.[*].renderingProviderMiddleName")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_MIDDLE_NAME))
            .jsonPath("$.[*].renderingProviderLastName")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_LAST_NAME))
            .jsonPath("$.[*].renderingProviderNpi")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_NPI))
            .jsonPath("$.[*].renderingProviderDea")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_DEA))
            .jsonPath("$.[*].renderingProviderAddressId")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_ADDRESS_ID))
            .jsonPath("$.[*].renderingProviderAddressLine1")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_1))
            .jsonPath("$.[*].renderingProviderAddressLine2")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_2))
            .jsonPath("$.[*].renderingProviderCityName")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_CITY_NAME))
            .jsonPath("$.[*].renderingProviderStateName")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_STATE_NAME))
            .jsonPath("$.[*].renderingProviderZip")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_ZIP))
            .jsonPath("$.[*].renderingProviderContactId")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_CONTACT_ID))
            .jsonPath("$.[*].renderingProviderPhone1")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_PHONE_1))
            .jsonPath("$.[*].renderingProviderPhone2")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_PHONE_2))
            .jsonPath("$.[*].renderingProviderEmail")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_EMAIL))
            .jsonPath("$.[*].renderingProviderFax")
            .value(hasItem(DEFAULT_RENDERING_PROVIDER_FAX))
            .jsonPath("$.[*].referringProviderType")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_TYPE))
            .jsonPath("$.[*].referringProviderFacilityId")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_FACILITY_ID))
            .jsonPath("$.[*].referringProviderFacilityName")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_FACILITY_NAME))
            .jsonPath("$.[*].referringProviderId")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_ID))
            .jsonPath("$.[*].referringProviderFirstName")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_FIRST_NAME))
            .jsonPath("$.[*].referringProviderMiddleName")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_MIDDLE_NAME))
            .jsonPath("$.[*].referringProviderLastName")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_LAST_NAME))
            .jsonPath("$.[*].referringProviderNpi")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_NPI))
            .jsonPath("$.[*].referringProviderDea")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_DEA))
            .jsonPath("$.[*].referringProviderAddressId")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_ADDRESS_ID))
            .jsonPath("$.[*].referringProviderAddressLine1")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_1))
            .jsonPath("$.[*].referringProviderAddressLine2")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_2))
            .jsonPath("$.[*].referringProviderCityName")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_CITY_NAME))
            .jsonPath("$.[*].referringProviderStateName")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_STATE_NAME))
            .jsonPath("$.[*].referringProviderZip")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_ZIP))
            .jsonPath("$.[*].referringProviderContactId")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_CONTACT_ID))
            .jsonPath("$.[*].referringProviderPhone1")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_PHONE_1))
            .jsonPath("$.[*].referringProviderPhone2")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_PHONE_2))
            .jsonPath("$.[*].referringProviderEmail")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_EMAIL))
            .jsonPath("$.[*].referringProviderFax")
            .value(hasItem(DEFAULT_REFERRING_PROVIDER_FAX))
            .jsonPath("$.[*].orderingProviderType")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_TYPE))
            .jsonPath("$.[*].orderingProviderFacilityId")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_FACILITY_ID))
            .jsonPath("$.[*].orderingProviderFacilityName")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_FACILITY_NAME))
            .jsonPath("$.[*].orderingProviderId")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_ID))
            .jsonPath("$.[*].orderingProviderFirstName")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_FIRST_NAME))
            .jsonPath("$.[*].orderingProviderMiddleName")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_MIDDLE_NAME))
            .jsonPath("$.[*].orderingProviderLastName")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_LAST_NAME))
            .jsonPath("$.[*].orderingProviderNpi")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_NPI))
            .jsonPath("$.[*].orderingProviderDea")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_DEA))
            .jsonPath("$.[*].orderingProviderAddressId")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_ADDRESS_ID))
            .jsonPath("$.[*].orderingProviderAddressLine1")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_1))
            .jsonPath("$.[*].orderingProviderAddressLine2")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_2))
            .jsonPath("$.[*].orderingProviderCityName")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_CITY_NAME))
            .jsonPath("$.[*].orderingProviderStateName")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_STATE_NAME))
            .jsonPath("$.[*].orderingProviderZip")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_ZIP))
            .jsonPath("$.[*].orderingProviderContactId")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_CONTACT_ID))
            .jsonPath("$.[*].orderingProviderPhone1")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_PHONE_1))
            .jsonPath("$.[*].orderingProviderPhone2")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_PHONE_2))
            .jsonPath("$.[*].orderingProviderEmail")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_EMAIL))
            .jsonPath("$.[*].orderingProviderFax")
            .value(hasItem(DEFAULT_ORDERING_PROVIDER_FAX))
            .jsonPath("$.[*].marketingReferalTypeId")
            .value(hasItem(DEFAULT_MARKETING_REFERAL_TYPE_ID))
            .jsonPath("$.[*].marketingReferalTypeDescription")
            .value(hasItem(DEFAULT_MARKETING_REFERAL_TYPE_DESCRIPTION))
            .jsonPath("$.[*].marketingReferalId")
            .value(hasItem(DEFAULT_MARKETING_REFERAL_ID))
            .jsonPath("$.[*].marketingReferalName")
            .value(hasItem(DEFAULT_MARKETING_REFERAL_NAME))
            .jsonPath("$.[*].icd10DiagnosisCode1")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_1))
            .jsonPath("$.[*].icd10DiagnosisCode2")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_2))
            .jsonPath("$.[*].icd10DiagnosisCode3")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_3))
            .jsonPath("$.[*].icd10DiagnosisCode4")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_4))
            .jsonPath("$.[*].icd10DiagnosisCode5")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_5))
            .jsonPath("$.[*].icd10DiagnosisCode6")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_6))
            .jsonPath("$.[*].icd10DiagnosisCode7")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_7))
            .jsonPath("$.[*].icd10DiagnosisCode8")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_8))
            .jsonPath("$.[*].icd10DiagnosisCode9")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_9))
            .jsonPath("$.[*].icd10DiagnosisCode10")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_10))
            .jsonPath("$.[*].icd10DiagnosisCode11")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_11))
            .jsonPath("$.[*].icd10DiagnosisCode12")
            .value(hasItem(DEFAULT_ICD_10_DIAGNOSIS_CODE_12))
            .jsonPath("$.[*].epsdtCertificationConditionIndicator")
            .value(hasItem(DEFAULT_EPSDT_CERTIFICATION_CONDITION_INDICATOR))
            .jsonPath("$.[*].epsdtCertificationCode")
            .value(hasItem(DEFAULT_EPSDT_CERTIFICATION_CODE))
            .jsonPath("$.[*].status")
            .value(hasItem(DEFAULT_STATUS))
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
    void getSalesOrderClinicalDetails() {
        // Initialize the database
        salesOrderClinicalDetailsRepository.save(salesOrderClinicalDetails).block();

        // Get the salesOrderClinicalDetails
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, salesOrderClinicalDetails.getSalesOderClinicalDetailsId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.salesOderClinicalDetailsId")
            .value(is(salesOrderClinicalDetails.getSalesOderClinicalDetailsId().intValue()))
            .jsonPath("$.salesOrderId")
            .value(is(DEFAULT_SALES_ORDER_ID.intValue()))
            .jsonPath("$.patientId")
            .value(is(DEFAULT_PATIENT_ID))
            .jsonPath("$.patientWeightInKg")
            .value(is(DEFAULT_PATIENT_WEIGHT_IN_KG.doubleValue()))
            .jsonPath("$.patientWeightInLbs")
            .value(is(DEFAULT_PATIENT_WEIGHT_IN_LBS.doubleValue()))
            .jsonPath("$.heightInInches")
            .value(is(DEFAULT_HEIGHT_IN_INCHES.doubleValue()))
            .jsonPath("$.heightInCm")
            .value(is(DEFAULT_HEIGHT_IN_CM.doubleValue()))
            .jsonPath("$.salesRepId")
            .value(is(DEFAULT_SALES_REP_ID))
            .jsonPath("$.salesepName")
            .value(is(DEFAULT_SALESEP_NAME))
            .jsonPath("$.practitionerId")
            .value(is(DEFAULT_PRACTITIONER_ID))
            .jsonPath("$.renderingProviderType")
            .value(is(DEFAULT_RENDERING_PROVIDER_TYPE))
            .jsonPath("$.renderingProviderFacilityId")
            .value(is(DEFAULT_RENDERING_PROVIDER_FACILITY_ID))
            .jsonPath("$.renderingProviderFacilityName")
            .value(is(DEFAULT_RENDERING_PROVIDER_FACILITY_NAME))
            .jsonPath("$.renderingProviderId")
            .value(is(DEFAULT_RENDERING_PROVIDER_ID))
            .jsonPath("$.renderingProviderFirstName")
            .value(is(DEFAULT_RENDERING_PROVIDER_FIRST_NAME))
            .jsonPath("$.renderingProviderMiddleName")
            .value(is(DEFAULT_RENDERING_PROVIDER_MIDDLE_NAME))
            .jsonPath("$.renderingProviderLastName")
            .value(is(DEFAULT_RENDERING_PROVIDER_LAST_NAME))
            .jsonPath("$.renderingProviderNpi")
            .value(is(DEFAULT_RENDERING_PROVIDER_NPI))
            .jsonPath("$.renderingProviderDea")
            .value(is(DEFAULT_RENDERING_PROVIDER_DEA))
            .jsonPath("$.renderingProviderAddressId")
            .value(is(DEFAULT_RENDERING_PROVIDER_ADDRESS_ID))
            .jsonPath("$.renderingProviderAddressLine1")
            .value(is(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_1))
            .jsonPath("$.renderingProviderAddressLine2")
            .value(is(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_2))
            .jsonPath("$.renderingProviderCityName")
            .value(is(DEFAULT_RENDERING_PROVIDER_CITY_NAME))
            .jsonPath("$.renderingProviderStateName")
            .value(is(DEFAULT_RENDERING_PROVIDER_STATE_NAME))
            .jsonPath("$.renderingProviderZip")
            .value(is(DEFAULT_RENDERING_PROVIDER_ZIP))
            .jsonPath("$.renderingProviderContactId")
            .value(is(DEFAULT_RENDERING_PROVIDER_CONTACT_ID))
            .jsonPath("$.renderingProviderPhone1")
            .value(is(DEFAULT_RENDERING_PROVIDER_PHONE_1))
            .jsonPath("$.renderingProviderPhone2")
            .value(is(DEFAULT_RENDERING_PROVIDER_PHONE_2))
            .jsonPath("$.renderingProviderEmail")
            .value(is(DEFAULT_RENDERING_PROVIDER_EMAIL))
            .jsonPath("$.renderingProviderFax")
            .value(is(DEFAULT_RENDERING_PROVIDER_FAX))
            .jsonPath("$.referringProviderType")
            .value(is(DEFAULT_REFERRING_PROVIDER_TYPE))
            .jsonPath("$.referringProviderFacilityId")
            .value(is(DEFAULT_REFERRING_PROVIDER_FACILITY_ID))
            .jsonPath("$.referringProviderFacilityName")
            .value(is(DEFAULT_REFERRING_PROVIDER_FACILITY_NAME))
            .jsonPath("$.referringProviderId")
            .value(is(DEFAULT_REFERRING_PROVIDER_ID))
            .jsonPath("$.referringProviderFirstName")
            .value(is(DEFAULT_REFERRING_PROVIDER_FIRST_NAME))
            .jsonPath("$.referringProviderMiddleName")
            .value(is(DEFAULT_REFERRING_PROVIDER_MIDDLE_NAME))
            .jsonPath("$.referringProviderLastName")
            .value(is(DEFAULT_REFERRING_PROVIDER_LAST_NAME))
            .jsonPath("$.referringProviderNpi")
            .value(is(DEFAULT_REFERRING_PROVIDER_NPI))
            .jsonPath("$.referringProviderDea")
            .value(is(DEFAULT_REFERRING_PROVIDER_DEA))
            .jsonPath("$.referringProviderAddressId")
            .value(is(DEFAULT_REFERRING_PROVIDER_ADDRESS_ID))
            .jsonPath("$.referringProviderAddressLine1")
            .value(is(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_1))
            .jsonPath("$.referringProviderAddressLine2")
            .value(is(DEFAULT_REFERRING_PROVIDER_ADDRESS_LINE_2))
            .jsonPath("$.referringProviderCityName")
            .value(is(DEFAULT_REFERRING_PROVIDER_CITY_NAME))
            .jsonPath("$.referringProviderStateName")
            .value(is(DEFAULT_REFERRING_PROVIDER_STATE_NAME))
            .jsonPath("$.referringProviderZip")
            .value(is(DEFAULT_REFERRING_PROVIDER_ZIP))
            .jsonPath("$.referringProviderContactId")
            .value(is(DEFAULT_REFERRING_PROVIDER_CONTACT_ID))
            .jsonPath("$.referringProviderPhone1")
            .value(is(DEFAULT_REFERRING_PROVIDER_PHONE_1))
            .jsonPath("$.referringProviderPhone2")
            .value(is(DEFAULT_REFERRING_PROVIDER_PHONE_2))
            .jsonPath("$.referringProviderEmail")
            .value(is(DEFAULT_REFERRING_PROVIDER_EMAIL))
            .jsonPath("$.referringProviderFax")
            .value(is(DEFAULT_REFERRING_PROVIDER_FAX))
            .jsonPath("$.orderingProviderType")
            .value(is(DEFAULT_ORDERING_PROVIDER_TYPE))
            .jsonPath("$.orderingProviderFacilityId")
            .value(is(DEFAULT_ORDERING_PROVIDER_FACILITY_ID))
            .jsonPath("$.orderingProviderFacilityName")
            .value(is(DEFAULT_ORDERING_PROVIDER_FACILITY_NAME))
            .jsonPath("$.orderingProviderId")
            .value(is(DEFAULT_ORDERING_PROVIDER_ID))
            .jsonPath("$.orderingProviderFirstName")
            .value(is(DEFAULT_ORDERING_PROVIDER_FIRST_NAME))
            .jsonPath("$.orderingProviderMiddleName")
            .value(is(DEFAULT_ORDERING_PROVIDER_MIDDLE_NAME))
            .jsonPath("$.orderingProviderLastName")
            .value(is(DEFAULT_ORDERING_PROVIDER_LAST_NAME))
            .jsonPath("$.orderingProviderNpi")
            .value(is(DEFAULT_ORDERING_PROVIDER_NPI))
            .jsonPath("$.orderingProviderDea")
            .value(is(DEFAULT_ORDERING_PROVIDER_DEA))
            .jsonPath("$.orderingProviderAddressId")
            .value(is(DEFAULT_ORDERING_PROVIDER_ADDRESS_ID))
            .jsonPath("$.orderingProviderAddressLine1")
            .value(is(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_1))
            .jsonPath("$.orderingProviderAddressLine2")
            .value(is(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_2))
            .jsonPath("$.orderingProviderCityName")
            .value(is(DEFAULT_ORDERING_PROVIDER_CITY_NAME))
            .jsonPath("$.orderingProviderStateName")
            .value(is(DEFAULT_ORDERING_PROVIDER_STATE_NAME))
            .jsonPath("$.orderingProviderZip")
            .value(is(DEFAULT_ORDERING_PROVIDER_ZIP))
            .jsonPath("$.orderingProviderContactId")
            .value(is(DEFAULT_ORDERING_PROVIDER_CONTACT_ID))
            .jsonPath("$.orderingProviderPhone1")
            .value(is(DEFAULT_ORDERING_PROVIDER_PHONE_1))
            .jsonPath("$.orderingProviderPhone2")
            .value(is(DEFAULT_ORDERING_PROVIDER_PHONE_2))
            .jsonPath("$.orderingProviderEmail")
            .value(is(DEFAULT_ORDERING_PROVIDER_EMAIL))
            .jsonPath("$.orderingProviderFax")
            .value(is(DEFAULT_ORDERING_PROVIDER_FAX))
            .jsonPath("$.marketingReferalTypeId")
            .value(is(DEFAULT_MARKETING_REFERAL_TYPE_ID))
            .jsonPath("$.marketingReferalTypeDescription")
            .value(is(DEFAULT_MARKETING_REFERAL_TYPE_DESCRIPTION))
            .jsonPath("$.marketingReferalId")
            .value(is(DEFAULT_MARKETING_REFERAL_ID))
            .jsonPath("$.marketingReferalName")
            .value(is(DEFAULT_MARKETING_REFERAL_NAME))
            .jsonPath("$.icd10DiagnosisCode1")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_1))
            .jsonPath("$.icd10DiagnosisCode2")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_2))
            .jsonPath("$.icd10DiagnosisCode3")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_3))
            .jsonPath("$.icd10DiagnosisCode4")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_4))
            .jsonPath("$.icd10DiagnosisCode5")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_5))
            .jsonPath("$.icd10DiagnosisCode6")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_6))
            .jsonPath("$.icd10DiagnosisCode7")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_7))
            .jsonPath("$.icd10DiagnosisCode8")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_8))
            .jsonPath("$.icd10DiagnosisCode9")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_9))
            .jsonPath("$.icd10DiagnosisCode10")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_10))
            .jsonPath("$.icd10DiagnosisCode11")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_11))
            .jsonPath("$.icd10DiagnosisCode12")
            .value(is(DEFAULT_ICD_10_DIAGNOSIS_CODE_12))
            .jsonPath("$.epsdtCertificationConditionIndicator")
            .value(is(DEFAULT_EPSDT_CERTIFICATION_CONDITION_INDICATOR))
            .jsonPath("$.epsdtCertificationCode")
            .value(is(DEFAULT_EPSDT_CERTIFICATION_CODE))
            .jsonPath("$.status")
            .value(is(DEFAULT_STATUS))
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
    void getNonExistingSalesOrderClinicalDetails() {
        // Get the salesOrderClinicalDetails
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingSalesOrderClinicalDetails() throws Exception {
        // Initialize the database
        salesOrderClinicalDetailsRepository.save(salesOrderClinicalDetails).block();

        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();

        // Update the salesOrderClinicalDetails
        SalesOrderClinicalDetails updatedSalesOrderClinicalDetails = salesOrderClinicalDetailsRepository
            .findById(salesOrderClinicalDetails.getSalesOderClinicalDetailsId())
            .block();
        updatedSalesOrderClinicalDetails
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .patientId(UPDATED_PATIENT_ID)
            .patientWeightInKg(UPDATED_PATIENT_WEIGHT_IN_KG)
            .patientWeightInLbs(UPDATED_PATIENT_WEIGHT_IN_LBS)
            .heightInInches(UPDATED_HEIGHT_IN_INCHES)
            .heightInCm(UPDATED_HEIGHT_IN_CM)
            .salesRepId(UPDATED_SALES_REP_ID)
            .salesepName(UPDATED_SALESEP_NAME)
            .practitionerId(UPDATED_PRACTITIONER_ID)
            .renderingProviderType(UPDATED_RENDERING_PROVIDER_TYPE)
            .renderingProviderFacilityId(UPDATED_RENDERING_PROVIDER_FACILITY_ID)
            .renderingProviderFacilityName(UPDATED_RENDERING_PROVIDER_FACILITY_NAME)
            .renderingProviderId(UPDATED_RENDERING_PROVIDER_ID)
            .renderingProviderFirstName(UPDATED_RENDERING_PROVIDER_FIRST_NAME)
            .renderingProviderMiddleName(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME)
            .renderingProviderLastName(UPDATED_RENDERING_PROVIDER_LAST_NAME)
            .renderingProviderNpi(UPDATED_RENDERING_PROVIDER_NPI)
            .renderingProviderDea(UPDATED_RENDERING_PROVIDER_DEA)
            .renderingProviderAddressId(UPDATED_RENDERING_PROVIDER_ADDRESS_ID)
            .renderingProviderAddressLine1(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_1)
            .renderingProviderAddressLine2(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_2)
            .renderingProviderCityName(UPDATED_RENDERING_PROVIDER_CITY_NAME)
            .renderingProviderStateName(UPDATED_RENDERING_PROVIDER_STATE_NAME)
            .renderingProviderZip(UPDATED_RENDERING_PROVIDER_ZIP)
            .renderingProviderContactId(UPDATED_RENDERING_PROVIDER_CONTACT_ID)
            .renderingProviderPhone1(UPDATED_RENDERING_PROVIDER_PHONE_1)
            .renderingProviderPhone2(UPDATED_RENDERING_PROVIDER_PHONE_2)
            .renderingProviderEmail(UPDATED_RENDERING_PROVIDER_EMAIL)
            .renderingProviderFax(UPDATED_RENDERING_PROVIDER_FAX)
            .referringProviderType(UPDATED_REFERRING_PROVIDER_TYPE)
            .referringProviderFacilityId(UPDATED_REFERRING_PROVIDER_FACILITY_ID)
            .referringProviderFacilityName(UPDATED_REFERRING_PROVIDER_FACILITY_NAME)
            .referringProviderId(UPDATED_REFERRING_PROVIDER_ID)
            .referringProviderFirstName(UPDATED_REFERRING_PROVIDER_FIRST_NAME)
            .referringProviderMiddleName(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME)
            .referringProviderLastName(UPDATED_REFERRING_PROVIDER_LAST_NAME)
            .referringProviderNpi(UPDATED_REFERRING_PROVIDER_NPI)
            .referringProviderDea(UPDATED_REFERRING_PROVIDER_DEA)
            .referringProviderAddressId(UPDATED_REFERRING_PROVIDER_ADDRESS_ID)
            .referringProviderAddressLine1(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1)
            .referringProviderAddressLine2(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2)
            .referringProviderCityName(UPDATED_REFERRING_PROVIDER_CITY_NAME)
            .referringProviderStateName(UPDATED_REFERRING_PROVIDER_STATE_NAME)
            .referringProviderZip(UPDATED_REFERRING_PROVIDER_ZIP)
            .referringProviderContactId(UPDATED_REFERRING_PROVIDER_CONTACT_ID)
            .referringProviderPhone1(UPDATED_REFERRING_PROVIDER_PHONE_1)
            .referringProviderPhone2(UPDATED_REFERRING_PROVIDER_PHONE_2)
            .referringProviderEmail(UPDATED_REFERRING_PROVIDER_EMAIL)
            .referringProviderFax(UPDATED_REFERRING_PROVIDER_FAX)
            .orderingProviderType(UPDATED_ORDERING_PROVIDER_TYPE)
            .orderingProviderFacilityId(UPDATED_ORDERING_PROVIDER_FACILITY_ID)
            .orderingProviderFacilityName(UPDATED_ORDERING_PROVIDER_FACILITY_NAME)
            .orderingProviderId(UPDATED_ORDERING_PROVIDER_ID)
            .orderingProviderFirstName(UPDATED_ORDERING_PROVIDER_FIRST_NAME)
            .orderingProviderMiddleName(UPDATED_ORDERING_PROVIDER_MIDDLE_NAME)
            .orderingProviderLastName(UPDATED_ORDERING_PROVIDER_LAST_NAME)
            .orderingProviderNpi(UPDATED_ORDERING_PROVIDER_NPI)
            .orderingProviderDea(UPDATED_ORDERING_PROVIDER_DEA)
            .orderingProviderAddressId(UPDATED_ORDERING_PROVIDER_ADDRESS_ID)
            .orderingProviderAddressLine1(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_1)
            .orderingProviderAddressLine2(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_2)
            .orderingProviderCityName(UPDATED_ORDERING_PROVIDER_CITY_NAME)
            .orderingProviderStateName(UPDATED_ORDERING_PROVIDER_STATE_NAME)
            .orderingProviderZip(UPDATED_ORDERING_PROVIDER_ZIP)
            .orderingProviderContactId(UPDATED_ORDERING_PROVIDER_CONTACT_ID)
            .orderingProviderPhone1(UPDATED_ORDERING_PROVIDER_PHONE_1)
            .orderingProviderPhone2(UPDATED_ORDERING_PROVIDER_PHONE_2)
            .orderingProviderEmail(UPDATED_ORDERING_PROVIDER_EMAIL)
            .orderingProviderFax(UPDATED_ORDERING_PROVIDER_FAX)
            .marketingReferalTypeId(UPDATED_MARKETING_REFERAL_TYPE_ID)
            .marketingReferalTypeDescription(UPDATED_MARKETING_REFERAL_TYPE_DESCRIPTION)
            .marketingReferalId(UPDATED_MARKETING_REFERAL_ID)
            .marketingReferalName(UPDATED_MARKETING_REFERAL_NAME)
            .icd10DiagnosisCode1(UPDATED_ICD_10_DIAGNOSIS_CODE_1)
            .icd10DiagnosisCode2(UPDATED_ICD_10_DIAGNOSIS_CODE_2)
            .icd10DiagnosisCode3(UPDATED_ICD_10_DIAGNOSIS_CODE_3)
            .icd10DiagnosisCode4(UPDATED_ICD_10_DIAGNOSIS_CODE_4)
            .icd10DiagnosisCode5(UPDATED_ICD_10_DIAGNOSIS_CODE_5)
            .icd10DiagnosisCode6(UPDATED_ICD_10_DIAGNOSIS_CODE_6)
            .icd10DiagnosisCode7(UPDATED_ICD_10_DIAGNOSIS_CODE_7)
            .icd10DiagnosisCode8(UPDATED_ICD_10_DIAGNOSIS_CODE_8)
            .icd10DiagnosisCode9(UPDATED_ICD_10_DIAGNOSIS_CODE_9)
            .icd10DiagnosisCode10(UPDATED_ICD_10_DIAGNOSIS_CODE_10)
            .icd10DiagnosisCode11(UPDATED_ICD_10_DIAGNOSIS_CODE_11)
            .icd10DiagnosisCode12(UPDATED_ICD_10_DIAGNOSIS_CODE_12)
            .epsdtCertificationConditionIndicator(UPDATED_EPSDT_CERTIFICATION_CONDITION_INDICATOR)
            .epsdtCertificationCode(UPDATED_EPSDT_CERTIFICATION_CODE)
            .status(UPDATED_STATUS)
            .createdById(UPDATED_CREATED_BY_ID)
            .createdByName(UPDATED_CREATED_BY_NAME)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME)
            .updatedDate(UPDATED_UPDATED_DATE);
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(updatedSalesOrderClinicalDetails);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
        SalesOrderClinicalDetails testSalesOrderClinicalDetails = salesOrderClinicalDetailsList.get(
            salesOrderClinicalDetailsList.size() - 1
        );
        assertThat(testSalesOrderClinicalDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInKg()).isEqualTo(UPDATED_PATIENT_WEIGHT_IN_KG);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInLbs()).isEqualTo(UPDATED_PATIENT_WEIGHT_IN_LBS);
        assertThat(testSalesOrderClinicalDetails.getHeightInInches()).isEqualTo(UPDATED_HEIGHT_IN_INCHES);
        assertThat(testSalesOrderClinicalDetails.getHeightInCm()).isEqualTo(UPDATED_HEIGHT_IN_CM);
        assertThat(testSalesOrderClinicalDetails.getSalesRepId()).isEqualTo(UPDATED_SALES_REP_ID);
        assertThat(testSalesOrderClinicalDetails.getSalesepName()).isEqualTo(UPDATED_SALESEP_NAME);
        assertThat(testSalesOrderClinicalDetails.getPractitionerId()).isEqualTo(UPDATED_PRACTITIONER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderType()).isEqualTo(UPDATED_RENDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityId()).isEqualTo(UPDATED_RENDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityName()).isEqualTo(UPDATED_RENDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderId()).isEqualTo(UPDATED_RENDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFirstName()).isEqualTo(UPDATED_RENDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderMiddleName()).isEqualTo(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderLastName()).isEqualTo(UPDATED_RENDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderNpi()).isEqualTo(UPDATED_RENDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderDea()).isEqualTo(UPDATED_RENDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressId()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine1()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine2()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderCityName()).isEqualTo(UPDATED_RENDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderStateName()).isEqualTo(UPDATED_RENDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderZip()).isEqualTo(UPDATED_RENDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderContactId()).isEqualTo(UPDATED_RENDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone1()).isEqualTo(UPDATED_RENDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone2()).isEqualTo(UPDATED_RENDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderEmail()).isEqualTo(UPDATED_RENDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFax()).isEqualTo(UPDATED_RENDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderType()).isEqualTo(UPDATED_REFERRING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityId()).isEqualTo(UPDATED_REFERRING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityName()).isEqualTo(UPDATED_REFERRING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderId()).isEqualTo(UPDATED_REFERRING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFirstName()).isEqualTo(UPDATED_REFERRING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderMiddleName()).isEqualTo(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderLastName()).isEqualTo(UPDATED_REFERRING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderNpi()).isEqualTo(UPDATED_REFERRING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderDea()).isEqualTo(UPDATED_REFERRING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressId()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine1()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine2()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderCityName()).isEqualTo(UPDATED_REFERRING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderStateName()).isEqualTo(UPDATED_REFERRING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderZip()).isEqualTo(UPDATED_REFERRING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderContactId()).isEqualTo(UPDATED_REFERRING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone1()).isEqualTo(UPDATED_REFERRING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone2()).isEqualTo(UPDATED_REFERRING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderEmail()).isEqualTo(UPDATED_REFERRING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFax()).isEqualTo(UPDATED_REFERRING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderType()).isEqualTo(UPDATED_ORDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityId()).isEqualTo(UPDATED_ORDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityName()).isEqualTo(UPDATED_ORDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderId()).isEqualTo(UPDATED_ORDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFirstName()).isEqualTo(UPDATED_ORDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderMiddleName()).isEqualTo(UPDATED_ORDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderLastName()).isEqualTo(UPDATED_ORDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderNpi()).isEqualTo(UPDATED_ORDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderDea()).isEqualTo(UPDATED_ORDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressId()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine1()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine2()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderCityName()).isEqualTo(UPDATED_ORDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderStateName()).isEqualTo(UPDATED_ORDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderZip()).isEqualTo(UPDATED_ORDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderContactId()).isEqualTo(UPDATED_ORDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone1()).isEqualTo(UPDATED_ORDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone2()).isEqualTo(UPDATED_ORDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderEmail()).isEqualTo(UPDATED_ORDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFax()).isEqualTo(UPDATED_ORDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeId()).isEqualTo(UPDATED_MARKETING_REFERAL_TYPE_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeDescription())
            .isEqualTo(UPDATED_MARKETING_REFERAL_TYPE_DESCRIPTION);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalId()).isEqualTo(UPDATED_MARKETING_REFERAL_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalName()).isEqualTo(UPDATED_MARKETING_REFERAL_NAME);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode1()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_1);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode2()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_2);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode3()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_3);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode4()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_4);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode5()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_5);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode6()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_6);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode7()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_7);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode8()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_8);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode9()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_9);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode10()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_10);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode11()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_11);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode12()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_12);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationConditionIndicator())
            .isEqualTo(UPDATED_EPSDT_CERTIFICATION_CONDITION_INDICATOR);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationCode()).isEqualTo(UPDATED_EPSDT_CERTIFICATION_CODE);
        assertThat(testSalesOrderClinicalDetails.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSalesOrderClinicalDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testSalesOrderClinicalDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
    }

    @Test
    void putNonExistingSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(count.incrementAndGet());

        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(count.incrementAndGet());

        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(count.incrementAndGet());

        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateSalesOrderClinicalDetailsWithPatch() throws Exception {
        // Initialize the database
        salesOrderClinicalDetailsRepository.save(salesOrderClinicalDetails).block();

        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();

        // Update the salesOrderClinicalDetails using partial update
        SalesOrderClinicalDetails partialUpdatedSalesOrderClinicalDetails = new SalesOrderClinicalDetails();
        partialUpdatedSalesOrderClinicalDetails.setSalesOderClinicalDetailsId(salesOrderClinicalDetails.getSalesOderClinicalDetailsId());

        partialUpdatedSalesOrderClinicalDetails
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .heightInCm(UPDATED_HEIGHT_IN_CM)
            .renderingProviderFacilityId(UPDATED_RENDERING_PROVIDER_FACILITY_ID)
            .renderingProviderId(UPDATED_RENDERING_PROVIDER_ID)
            .renderingProviderFirstName(UPDATED_RENDERING_PROVIDER_FIRST_NAME)
            .renderingProviderMiddleName(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME)
            .renderingProviderNpi(UPDATED_RENDERING_PROVIDER_NPI)
            .renderingProviderDea(UPDATED_RENDERING_PROVIDER_DEA)
            .renderingProviderAddressId(UPDATED_RENDERING_PROVIDER_ADDRESS_ID)
            .renderingProviderZip(UPDATED_RENDERING_PROVIDER_ZIP)
            .renderingProviderContactId(UPDATED_RENDERING_PROVIDER_CONTACT_ID)
            .renderingProviderPhone1(UPDATED_RENDERING_PROVIDER_PHONE_1)
            .referringProviderFacilityId(UPDATED_REFERRING_PROVIDER_FACILITY_ID)
            .referringProviderFacilityName(UPDATED_REFERRING_PROVIDER_FACILITY_NAME)
            .referringProviderId(UPDATED_REFERRING_PROVIDER_ID)
            .referringProviderFirstName(UPDATED_REFERRING_PROVIDER_FIRST_NAME)
            .referringProviderMiddleName(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME)
            .referringProviderLastName(UPDATED_REFERRING_PROVIDER_LAST_NAME)
            .referringProviderNpi(UPDATED_REFERRING_PROVIDER_NPI)
            .referringProviderDea(UPDATED_REFERRING_PROVIDER_DEA)
            .referringProviderAddressLine1(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1)
            .referringProviderAddressLine2(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2)
            .referringProviderCityName(UPDATED_REFERRING_PROVIDER_CITY_NAME)
            .referringProviderStateName(UPDATED_REFERRING_PROVIDER_STATE_NAME)
            .referringProviderZip(UPDATED_REFERRING_PROVIDER_ZIP)
            .referringProviderContactId(UPDATED_REFERRING_PROVIDER_CONTACT_ID)
            .referringProviderPhone1(UPDATED_REFERRING_PROVIDER_PHONE_1)
            .referringProviderPhone2(UPDATED_REFERRING_PROVIDER_PHONE_2)
            .referringProviderFax(UPDATED_REFERRING_PROVIDER_FAX)
            .orderingProviderFacilityId(UPDATED_ORDERING_PROVIDER_FACILITY_ID)
            .orderingProviderFirstName(UPDATED_ORDERING_PROVIDER_FIRST_NAME)
            .orderingProviderLastName(UPDATED_ORDERING_PROVIDER_LAST_NAME)
            .orderingProviderNpi(UPDATED_ORDERING_PROVIDER_NPI)
            .orderingProviderAddressId(UPDATED_ORDERING_PROVIDER_ADDRESS_ID)
            .orderingProviderCityName(UPDATED_ORDERING_PROVIDER_CITY_NAME)
            .orderingProviderContactId(UPDATED_ORDERING_PROVIDER_CONTACT_ID)
            .orderingProviderPhone1(UPDATED_ORDERING_PROVIDER_PHONE_1)
            .orderingProviderEmail(UPDATED_ORDERING_PROVIDER_EMAIL)
            .marketingReferalTypeId(UPDATED_MARKETING_REFERAL_TYPE_ID)
            .icd10DiagnosisCode4(UPDATED_ICD_10_DIAGNOSIS_CODE_4)
            .icd10DiagnosisCode5(UPDATED_ICD_10_DIAGNOSIS_CODE_5)
            .icd10DiagnosisCode6(UPDATED_ICD_10_DIAGNOSIS_CODE_6)
            .icd10DiagnosisCode8(UPDATED_ICD_10_DIAGNOSIS_CODE_8)
            .icd10DiagnosisCode10(UPDATED_ICD_10_DIAGNOSIS_CODE_10)
            .icd10DiagnosisCode12(UPDATED_ICD_10_DIAGNOSIS_CODE_12)
            .status(UPDATED_STATUS)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderClinicalDetails.getSalesOderClinicalDetailsId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderClinicalDetails))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
        SalesOrderClinicalDetails testSalesOrderClinicalDetails = salesOrderClinicalDetailsList.get(
            salesOrderClinicalDetailsList.size() - 1
        );
        assertThat(testSalesOrderClinicalDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInKg()).isEqualTo(DEFAULT_PATIENT_WEIGHT_IN_KG);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInLbs()).isEqualTo(DEFAULT_PATIENT_WEIGHT_IN_LBS);
        assertThat(testSalesOrderClinicalDetails.getHeightInInches()).isEqualTo(DEFAULT_HEIGHT_IN_INCHES);
        assertThat(testSalesOrderClinicalDetails.getHeightInCm()).isEqualTo(UPDATED_HEIGHT_IN_CM);
        assertThat(testSalesOrderClinicalDetails.getSalesRepId()).isEqualTo(DEFAULT_SALES_REP_ID);
        assertThat(testSalesOrderClinicalDetails.getSalesepName()).isEqualTo(DEFAULT_SALESEP_NAME);
        assertThat(testSalesOrderClinicalDetails.getPractitionerId()).isEqualTo(DEFAULT_PRACTITIONER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderType()).isEqualTo(DEFAULT_RENDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityId()).isEqualTo(UPDATED_RENDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderId()).isEqualTo(UPDATED_RENDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFirstName()).isEqualTo(UPDATED_RENDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderMiddleName()).isEqualTo(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderLastName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderNpi()).isEqualTo(UPDATED_RENDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderDea()).isEqualTo(UPDATED_RENDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressId()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine1()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine2()).isEqualTo(DEFAULT_RENDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderCityName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderStateName()).isEqualTo(DEFAULT_RENDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderZip()).isEqualTo(UPDATED_RENDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderContactId()).isEqualTo(UPDATED_RENDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone1()).isEqualTo(UPDATED_RENDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone2()).isEqualTo(DEFAULT_RENDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderEmail()).isEqualTo(DEFAULT_RENDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFax()).isEqualTo(DEFAULT_RENDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderType()).isEqualTo(DEFAULT_REFERRING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityId()).isEqualTo(UPDATED_REFERRING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityName()).isEqualTo(UPDATED_REFERRING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderId()).isEqualTo(UPDATED_REFERRING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFirstName()).isEqualTo(UPDATED_REFERRING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderMiddleName()).isEqualTo(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderLastName()).isEqualTo(UPDATED_REFERRING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderNpi()).isEqualTo(UPDATED_REFERRING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderDea()).isEqualTo(UPDATED_REFERRING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressId()).isEqualTo(DEFAULT_REFERRING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine1()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine2()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderCityName()).isEqualTo(UPDATED_REFERRING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderStateName()).isEqualTo(UPDATED_REFERRING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderZip()).isEqualTo(UPDATED_REFERRING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderContactId()).isEqualTo(UPDATED_REFERRING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone1()).isEqualTo(UPDATED_REFERRING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone2()).isEqualTo(UPDATED_REFERRING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderEmail()).isEqualTo(DEFAULT_REFERRING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFax()).isEqualTo(UPDATED_REFERRING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderType()).isEqualTo(DEFAULT_ORDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityId()).isEqualTo(UPDATED_ORDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderId()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFirstName()).isEqualTo(UPDATED_ORDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderMiddleName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderLastName()).isEqualTo(UPDATED_ORDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderNpi()).isEqualTo(UPDATED_ORDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderDea()).isEqualTo(DEFAULT_ORDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressId()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine1()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine2()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderCityName()).isEqualTo(UPDATED_ORDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderStateName()).isEqualTo(DEFAULT_ORDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderZip()).isEqualTo(DEFAULT_ORDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderContactId()).isEqualTo(UPDATED_ORDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone1()).isEqualTo(UPDATED_ORDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone2()).isEqualTo(DEFAULT_ORDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderEmail()).isEqualTo(UPDATED_ORDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFax()).isEqualTo(DEFAULT_ORDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeId()).isEqualTo(UPDATED_MARKETING_REFERAL_TYPE_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeDescription())
            .isEqualTo(DEFAULT_MARKETING_REFERAL_TYPE_DESCRIPTION);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalId()).isEqualTo(DEFAULT_MARKETING_REFERAL_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalName()).isEqualTo(DEFAULT_MARKETING_REFERAL_NAME);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode1()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_1);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode2()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_2);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode3()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_3);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode4()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_4);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode5()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_5);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode6()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_6);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode7()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_7);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode8()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_8);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode9()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_9);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode10()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_10);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode11()).isEqualTo(DEFAULT_ICD_10_DIAGNOSIS_CODE_11);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode12()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_12);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationConditionIndicator())
            .isEqualTo(DEFAULT_EPSDT_CERTIFICATION_CONDITION_INDICATOR);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationCode()).isEqualTo(DEFAULT_EPSDT_CERTIFICATION_CODE);
        assertThat(testSalesOrderClinicalDetails.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSalesOrderClinicalDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testSalesOrderClinicalDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
    }

    @Test
    void fullUpdateSalesOrderClinicalDetailsWithPatch() throws Exception {
        // Initialize the database
        salesOrderClinicalDetailsRepository.save(salesOrderClinicalDetails).block();

        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();

        // Update the salesOrderClinicalDetails using partial update
        SalesOrderClinicalDetails partialUpdatedSalesOrderClinicalDetails = new SalesOrderClinicalDetails();
        partialUpdatedSalesOrderClinicalDetails.setSalesOderClinicalDetailsId(salesOrderClinicalDetails.getSalesOderClinicalDetailsId());

        partialUpdatedSalesOrderClinicalDetails
            .salesOrderId(UPDATED_SALES_ORDER_ID)
            .patientId(UPDATED_PATIENT_ID)
            .patientWeightInKg(UPDATED_PATIENT_WEIGHT_IN_KG)
            .patientWeightInLbs(UPDATED_PATIENT_WEIGHT_IN_LBS)
            .heightInInches(UPDATED_HEIGHT_IN_INCHES)
            .heightInCm(UPDATED_HEIGHT_IN_CM)
            .salesRepId(UPDATED_SALES_REP_ID)
            .salesepName(UPDATED_SALESEP_NAME)
            .practitionerId(UPDATED_PRACTITIONER_ID)
            .renderingProviderType(UPDATED_RENDERING_PROVIDER_TYPE)
            .renderingProviderFacilityId(UPDATED_RENDERING_PROVIDER_FACILITY_ID)
            .renderingProviderFacilityName(UPDATED_RENDERING_PROVIDER_FACILITY_NAME)
            .renderingProviderId(UPDATED_RENDERING_PROVIDER_ID)
            .renderingProviderFirstName(UPDATED_RENDERING_PROVIDER_FIRST_NAME)
            .renderingProviderMiddleName(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME)
            .renderingProviderLastName(UPDATED_RENDERING_PROVIDER_LAST_NAME)
            .renderingProviderNpi(UPDATED_RENDERING_PROVIDER_NPI)
            .renderingProviderDea(UPDATED_RENDERING_PROVIDER_DEA)
            .renderingProviderAddressId(UPDATED_RENDERING_PROVIDER_ADDRESS_ID)
            .renderingProviderAddressLine1(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_1)
            .renderingProviderAddressLine2(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_2)
            .renderingProviderCityName(UPDATED_RENDERING_PROVIDER_CITY_NAME)
            .renderingProviderStateName(UPDATED_RENDERING_PROVIDER_STATE_NAME)
            .renderingProviderZip(UPDATED_RENDERING_PROVIDER_ZIP)
            .renderingProviderContactId(UPDATED_RENDERING_PROVIDER_CONTACT_ID)
            .renderingProviderPhone1(UPDATED_RENDERING_PROVIDER_PHONE_1)
            .renderingProviderPhone2(UPDATED_RENDERING_PROVIDER_PHONE_2)
            .renderingProviderEmail(UPDATED_RENDERING_PROVIDER_EMAIL)
            .renderingProviderFax(UPDATED_RENDERING_PROVIDER_FAX)
            .referringProviderType(UPDATED_REFERRING_PROVIDER_TYPE)
            .referringProviderFacilityId(UPDATED_REFERRING_PROVIDER_FACILITY_ID)
            .referringProviderFacilityName(UPDATED_REFERRING_PROVIDER_FACILITY_NAME)
            .referringProviderId(UPDATED_REFERRING_PROVIDER_ID)
            .referringProviderFirstName(UPDATED_REFERRING_PROVIDER_FIRST_NAME)
            .referringProviderMiddleName(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME)
            .referringProviderLastName(UPDATED_REFERRING_PROVIDER_LAST_NAME)
            .referringProviderNpi(UPDATED_REFERRING_PROVIDER_NPI)
            .referringProviderDea(UPDATED_REFERRING_PROVIDER_DEA)
            .referringProviderAddressId(UPDATED_REFERRING_PROVIDER_ADDRESS_ID)
            .referringProviderAddressLine1(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1)
            .referringProviderAddressLine2(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2)
            .referringProviderCityName(UPDATED_REFERRING_PROVIDER_CITY_NAME)
            .referringProviderStateName(UPDATED_REFERRING_PROVIDER_STATE_NAME)
            .referringProviderZip(UPDATED_REFERRING_PROVIDER_ZIP)
            .referringProviderContactId(UPDATED_REFERRING_PROVIDER_CONTACT_ID)
            .referringProviderPhone1(UPDATED_REFERRING_PROVIDER_PHONE_1)
            .referringProviderPhone2(UPDATED_REFERRING_PROVIDER_PHONE_2)
            .referringProviderEmail(UPDATED_REFERRING_PROVIDER_EMAIL)
            .referringProviderFax(UPDATED_REFERRING_PROVIDER_FAX)
            .orderingProviderType(UPDATED_ORDERING_PROVIDER_TYPE)
            .orderingProviderFacilityId(UPDATED_ORDERING_PROVIDER_FACILITY_ID)
            .orderingProviderFacilityName(UPDATED_ORDERING_PROVIDER_FACILITY_NAME)
            .orderingProviderId(UPDATED_ORDERING_PROVIDER_ID)
            .orderingProviderFirstName(UPDATED_ORDERING_PROVIDER_FIRST_NAME)
            .orderingProviderMiddleName(UPDATED_ORDERING_PROVIDER_MIDDLE_NAME)
            .orderingProviderLastName(UPDATED_ORDERING_PROVIDER_LAST_NAME)
            .orderingProviderNpi(UPDATED_ORDERING_PROVIDER_NPI)
            .orderingProviderDea(UPDATED_ORDERING_PROVIDER_DEA)
            .orderingProviderAddressId(UPDATED_ORDERING_PROVIDER_ADDRESS_ID)
            .orderingProviderAddressLine1(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_1)
            .orderingProviderAddressLine2(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_2)
            .orderingProviderCityName(UPDATED_ORDERING_PROVIDER_CITY_NAME)
            .orderingProviderStateName(UPDATED_ORDERING_PROVIDER_STATE_NAME)
            .orderingProviderZip(UPDATED_ORDERING_PROVIDER_ZIP)
            .orderingProviderContactId(UPDATED_ORDERING_PROVIDER_CONTACT_ID)
            .orderingProviderPhone1(UPDATED_ORDERING_PROVIDER_PHONE_1)
            .orderingProviderPhone2(UPDATED_ORDERING_PROVIDER_PHONE_2)
            .orderingProviderEmail(UPDATED_ORDERING_PROVIDER_EMAIL)
            .orderingProviderFax(UPDATED_ORDERING_PROVIDER_FAX)
            .marketingReferalTypeId(UPDATED_MARKETING_REFERAL_TYPE_ID)
            .marketingReferalTypeDescription(UPDATED_MARKETING_REFERAL_TYPE_DESCRIPTION)
            .marketingReferalId(UPDATED_MARKETING_REFERAL_ID)
            .marketingReferalName(UPDATED_MARKETING_REFERAL_NAME)
            .icd10DiagnosisCode1(UPDATED_ICD_10_DIAGNOSIS_CODE_1)
            .icd10DiagnosisCode2(UPDATED_ICD_10_DIAGNOSIS_CODE_2)
            .icd10DiagnosisCode3(UPDATED_ICD_10_DIAGNOSIS_CODE_3)
            .icd10DiagnosisCode4(UPDATED_ICD_10_DIAGNOSIS_CODE_4)
            .icd10DiagnosisCode5(UPDATED_ICD_10_DIAGNOSIS_CODE_5)
            .icd10DiagnosisCode6(UPDATED_ICD_10_DIAGNOSIS_CODE_6)
            .icd10DiagnosisCode7(UPDATED_ICD_10_DIAGNOSIS_CODE_7)
            .icd10DiagnosisCode8(UPDATED_ICD_10_DIAGNOSIS_CODE_8)
            .icd10DiagnosisCode9(UPDATED_ICD_10_DIAGNOSIS_CODE_9)
            .icd10DiagnosisCode10(UPDATED_ICD_10_DIAGNOSIS_CODE_10)
            .icd10DiagnosisCode11(UPDATED_ICD_10_DIAGNOSIS_CODE_11)
            .icd10DiagnosisCode12(UPDATED_ICD_10_DIAGNOSIS_CODE_12)
            .epsdtCertificationConditionIndicator(UPDATED_EPSDT_CERTIFICATION_CONDITION_INDICATOR)
            .epsdtCertificationCode(UPDATED_EPSDT_CERTIFICATION_CODE)
            .status(UPDATED_STATUS)
            .createdById(UPDATED_CREATED_BY_ID)
            .createdByName(UPDATED_CREATED_BY_NAME)
            .createdDate(UPDATED_CREATED_DATE)
            .updatedById(UPDATED_UPDATED_BY_ID)
            .updatedByName(UPDATED_UPDATED_BY_NAME)
            .updatedDate(UPDATED_UPDATED_DATE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderClinicalDetails.getSalesOderClinicalDetailsId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderClinicalDetails))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
        SalesOrderClinicalDetails testSalesOrderClinicalDetails = salesOrderClinicalDetailsList.get(
            salesOrderClinicalDetailsList.size() - 1
        );
        assertThat(testSalesOrderClinicalDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInKg()).isEqualTo(UPDATED_PATIENT_WEIGHT_IN_KG);
        assertThat(testSalesOrderClinicalDetails.getPatientWeightInLbs()).isEqualTo(UPDATED_PATIENT_WEIGHT_IN_LBS);
        assertThat(testSalesOrderClinicalDetails.getHeightInInches()).isEqualTo(UPDATED_HEIGHT_IN_INCHES);
        assertThat(testSalesOrderClinicalDetails.getHeightInCm()).isEqualTo(UPDATED_HEIGHT_IN_CM);
        assertThat(testSalesOrderClinicalDetails.getSalesRepId()).isEqualTo(UPDATED_SALES_REP_ID);
        assertThat(testSalesOrderClinicalDetails.getSalesepName()).isEqualTo(UPDATED_SALESEP_NAME);
        assertThat(testSalesOrderClinicalDetails.getPractitionerId()).isEqualTo(UPDATED_PRACTITIONER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderType()).isEqualTo(UPDATED_RENDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityId()).isEqualTo(UPDATED_RENDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFacilityName()).isEqualTo(UPDATED_RENDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderId()).isEqualTo(UPDATED_RENDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFirstName()).isEqualTo(UPDATED_RENDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderMiddleName()).isEqualTo(UPDATED_RENDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderLastName()).isEqualTo(UPDATED_RENDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderNpi()).isEqualTo(UPDATED_RENDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderDea()).isEqualTo(UPDATED_RENDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressId()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine1()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderAddressLine2()).isEqualTo(UPDATED_RENDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderCityName()).isEqualTo(UPDATED_RENDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderStateName()).isEqualTo(UPDATED_RENDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderZip()).isEqualTo(UPDATED_RENDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderContactId()).isEqualTo(UPDATED_RENDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone1()).isEqualTo(UPDATED_RENDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderPhone2()).isEqualTo(UPDATED_RENDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderEmail()).isEqualTo(UPDATED_RENDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getRenderingProviderFax()).isEqualTo(UPDATED_RENDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderType()).isEqualTo(UPDATED_REFERRING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityId()).isEqualTo(UPDATED_REFERRING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFacilityName()).isEqualTo(UPDATED_REFERRING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderId()).isEqualTo(UPDATED_REFERRING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFirstName()).isEqualTo(UPDATED_REFERRING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderMiddleName()).isEqualTo(UPDATED_REFERRING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderLastName()).isEqualTo(UPDATED_REFERRING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderNpi()).isEqualTo(UPDATED_REFERRING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderDea()).isEqualTo(UPDATED_REFERRING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressId()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine1()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderAddressLine2()).isEqualTo(UPDATED_REFERRING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderCityName()).isEqualTo(UPDATED_REFERRING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderStateName()).isEqualTo(UPDATED_REFERRING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderZip()).isEqualTo(UPDATED_REFERRING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderContactId()).isEqualTo(UPDATED_REFERRING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone1()).isEqualTo(UPDATED_REFERRING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderPhone2()).isEqualTo(UPDATED_REFERRING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderEmail()).isEqualTo(UPDATED_REFERRING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getReferringProviderFax()).isEqualTo(UPDATED_REFERRING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderType()).isEqualTo(UPDATED_ORDERING_PROVIDER_TYPE);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityId()).isEqualTo(UPDATED_ORDERING_PROVIDER_FACILITY_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFacilityName()).isEqualTo(UPDATED_ORDERING_PROVIDER_FACILITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderId()).isEqualTo(UPDATED_ORDERING_PROVIDER_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFirstName()).isEqualTo(UPDATED_ORDERING_PROVIDER_FIRST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderMiddleName()).isEqualTo(UPDATED_ORDERING_PROVIDER_MIDDLE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderLastName()).isEqualTo(UPDATED_ORDERING_PROVIDER_LAST_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderNpi()).isEqualTo(UPDATED_ORDERING_PROVIDER_NPI);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderDea()).isEqualTo(UPDATED_ORDERING_PROVIDER_DEA);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressId()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine1()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderAddressLine2()).isEqualTo(UPDATED_ORDERING_PROVIDER_ADDRESS_LINE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderCityName()).isEqualTo(UPDATED_ORDERING_PROVIDER_CITY_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderStateName()).isEqualTo(UPDATED_ORDERING_PROVIDER_STATE_NAME);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderZip()).isEqualTo(UPDATED_ORDERING_PROVIDER_ZIP);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderContactId()).isEqualTo(UPDATED_ORDERING_PROVIDER_CONTACT_ID);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone1()).isEqualTo(UPDATED_ORDERING_PROVIDER_PHONE_1);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderPhone2()).isEqualTo(UPDATED_ORDERING_PROVIDER_PHONE_2);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderEmail()).isEqualTo(UPDATED_ORDERING_PROVIDER_EMAIL);
        assertThat(testSalesOrderClinicalDetails.getOrderingProviderFax()).isEqualTo(UPDATED_ORDERING_PROVIDER_FAX);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeId()).isEqualTo(UPDATED_MARKETING_REFERAL_TYPE_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalTypeDescription())
            .isEqualTo(UPDATED_MARKETING_REFERAL_TYPE_DESCRIPTION);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalId()).isEqualTo(UPDATED_MARKETING_REFERAL_ID);
        assertThat(testSalesOrderClinicalDetails.getMarketingReferalName()).isEqualTo(UPDATED_MARKETING_REFERAL_NAME);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode1()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_1);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode2()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_2);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode3()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_3);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode4()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_4);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode5()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_5);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode6()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_6);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode7()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_7);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode8()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_8);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode9()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_9);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode10()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_10);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode11()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_11);
        assertThat(testSalesOrderClinicalDetails.getIcd10DiagnosisCode12()).isEqualTo(UPDATED_ICD_10_DIAGNOSIS_CODE_12);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationConditionIndicator())
            .isEqualTo(UPDATED_EPSDT_CERTIFICATION_CONDITION_INDICATOR);
        assertThat(testSalesOrderClinicalDetails.getEpsdtCertificationCode()).isEqualTo(UPDATED_EPSDT_CERTIFICATION_CODE);
        assertThat(testSalesOrderClinicalDetails.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSalesOrderClinicalDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testSalesOrderClinicalDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
        assertThat(testSalesOrderClinicalDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
        assertThat(testSalesOrderClinicalDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
    }

    @Test
    void patchNonExistingSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(count.incrementAndGet());

        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(count.incrementAndGet());

        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamSalesOrderClinicalDetails() throws Exception {
        int databaseSizeBeforeUpdate = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();
        salesOrderClinicalDetails.setSalesOderClinicalDetailsId(count.incrementAndGet());

        // Create the SalesOrderClinicalDetails
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsMapper.toDto(salesOrderClinicalDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderClinicalDetailsDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the SalesOrderClinicalDetails in the database
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteSalesOrderClinicalDetails() {
        // Initialize the database
        salesOrderClinicalDetailsRepository.save(salesOrderClinicalDetails).block();

        int databaseSizeBeforeDelete = salesOrderClinicalDetailsRepository.findAll().collectList().block().size();

        // Delete the salesOrderClinicalDetails
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, salesOrderClinicalDetails.getSalesOderClinicalDetailsId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<SalesOrderClinicalDetails> salesOrderClinicalDetailsList = salesOrderClinicalDetailsRepository.findAll().collectList().block();
        assertThat(salesOrderClinicalDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
