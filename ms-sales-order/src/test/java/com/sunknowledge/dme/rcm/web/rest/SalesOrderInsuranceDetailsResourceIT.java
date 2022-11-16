package com.sunknowledge.dme.rcm.web.rest;

import static com.sunknowledge.dme.rcm.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.SalesOrderInsuranceDetailsRepository;
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
 * Integration tests for the {@link SalesOrderInsuranceDetailsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class SalesOrderInsuranceDetailsResourceIT {

//    private static final Integer DEFAULT_SALES_ORDER_INSURANCE_DETAILS_ID = 1;
//    private static final Integer UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_ID = 1;
//    private static final Integer UPDATED_SALES_ORDER_ID = 2;
//
//    private static final Integer DEFAULT_PATIENT_ID = 1;
//    private static final Integer UPDATED_PATIENT_ID = 2;
//
//    private static final Integer DEFAULT_PRIMARY_INSURER_ID = 1;
//    private static final Integer UPDATED_PRIMARY_INSURER_ID = 2;
//
//    private static final String DEFAULT_PRIMARY_INSURER_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURER_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_PRIMARY_INSURANCE_GROUP_ID = 1;
//    private static final Integer UPDATED_PRIMARY_INSURANCE_GROUP_ID = 2;
//
//    private static final String DEFAULT_PRIMARY_INSURANCE_GROUP_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURANCE_GROUP_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_PRIMARY_INSURANCE_PLAN_ID = 1;
//    private static final Integer UPDATED_PRIMARY_INSURANCE_PLAN_ID = 2;
//
//    private static final String DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURANCE_PLAN_TYPE = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_PRIMARY_INSURANCE_STATE_ID = 1;
//    private static final Integer UPDATED_PRIMARY_INSURANCE_STATE_ID = 2;
//
//    private static final String DEFAULT_PRIMARY_INSURANCE_STATE_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURANCE_STATE_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_INSURER_POLICY_NO = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURER_POLICY_NO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_INSURER_PATIENT_ID_NUMBER = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_PRIMARY_INSURER_EFFECTIVE_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INSURER_VERIFICATION_STATUS = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_PRIMARY_INSURER_VERIFICATION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Integer DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE = 1;
//    private static final Integer UPDATED_PRIMARY_INSURER_PAY_PERCENTAGE = 2;
//
//    private static final String DEFAULT_PRIMARY_BOX_10_D = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_BOX_10_D = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_BOX_19 = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_BOX_19 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_BOX_24_IA = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_BOX_24_IA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_BOX_24_JA = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_BOX_24_JA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_BOX_24_JB = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_BOX_24_JB = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_INCLUDE_BOX_24_JBSTATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PRIMARY_PAY_PERCENTAGE_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SECONDARY_INSURER_ID = 1;
//    private static final Integer UPDATED_SECONDARY_INSURER_ID = 2;
//
//    private static final String DEFAULT_SECONDARY_INSURER_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURER_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SECONDARY_INSURANCE_GROUP_ID = 1;
//    private static final Integer UPDATED_SECONDARY_INSURANCE_GROUP_ID = 2;
//
//    private static final String DEFAULT_SECONDARY_INSURANCE_GROUP_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURANCE_GROUP_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SECONDARY_INSURANCE_PLAN_ID = 1;
//    private static final Integer UPDATED_SECONDARY_INSURANCE_PLAN_ID = 2;
//
//    private static final String DEFAULT_SECONDARY_INSURANCE_PLAN_TYPE = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURANCE_PLAN_TYPE = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SECONDARY_INSURANCE_STATE_ID = 1;
//    private static final Integer UPDATED_SECONDARY_INSURANCE_STATE_ID = 2;
//
//    private static final String DEFAULT_SECONDARY_INSURANCE_STATE_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURANCE_STATE_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_INSURER_POLICY_NO = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURER_POLICY_NO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURER_PATIENT_ID_NUMBER = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_SECONDARY_INSURER_EFFECTIVE_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INSURER_VERIFICATION_STATUS = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_SECONDARY_INSURER_VERIFICATION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SECONDARY_INSURER_VERIFICATION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Integer DEFAULT_SECONDARY_INSURER_PAY_PERCENTAGE = 1;
//    private static final Integer UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE = 2;
//
//    private static final String DEFAULT_SECONDARY_BOX_10_D = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_BOX_10_D = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_BOX_19 = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_BOX_19 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_BOX_24_IA = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_BOX_24_IA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_BOX_24_JA = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_BOX_24_JA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_BOX_24_JB = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_BOX_24_JB = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INCLUDE_BOX_24_JB_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SECONDARY_PAY_PERCENTAGE_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_TERTIARY_INSURER_ID = 1;
//    private static final Integer UPDATED_TERTIARY_INSURER_ID = 2;
//
//    private static final String DEFAULT_TERTIARY_INSURER_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURER_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_TERTIARY_INSURANCE_GROUP_ID = 1;
//    private static final Integer UPDATED_TERTIARY_INSURANCE_GROUP_ID = 2;
//
//    private static final String DEFAULT_TERTIARY_INSURANCE_GROUP_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURANCE_GROUP_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_TERTIARY_INSURANCE_PLAN_ID = 1;
//    private static final Integer UPDATED_TERTIARY_INSURANCE_PLAN_ID = 2;
//
//    private static final String DEFAULT_TERTIARY_INSURANCE_PLAN_TYPE = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURANCE_PLAN_TYPE = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_TERTIARY_INSURANCE_STATE_ID = 1;
//    private static final Integer UPDATED_TERTIARY_INSURANCE_STATE_ID = 2;
//
//    private static final String DEFAULT_TERTIARY_INSURANCE_STATE_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURANCE_STATE_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_INSURER_POLICYNO = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURER_POLICYNO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURER_PATIENT_ID_NUMBER = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_TERTIARY_INSURER_EFFECTIVE_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_TERTIARY_INSURER_VERIFICATION_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_TERTIARY_INSURER_VERIFICATION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_TERTIARY_INSURER_VERIFICATION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Integer DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE = 1;
//    private static final Integer UPDATED_TERTIARY_INSURER_PAY_PERCENTAGE = 2;
//
//    private static final String DEFAULT_TERTIARY_BOX_10_D = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_BOX_10_D = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_BOX_19 = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_BOX_19 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_BOX_24_IA = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_BOX_24_IA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_BOX_24_JA = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_BOX_24_JA = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_BOX_24_JB = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_BOX_24_JB = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INCLUDE_BOX_24_JB_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_TERTIARY_PAY_PERCENTAGE_0_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_INSURANCE_VERIFICATION_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_INSURANCE_VERIFICATION_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_COVERAGE_VERIFICATION_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_COVERAGE_VERIFICATION_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PATIENT_PAY_PERCENTAGE = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_PAY_PERCENTAGE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_WORKERS_COMP_DATE_OF_ONSET = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_WORKERS_COMP_DATE_OF_ONSET = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID = 1;
//    private static final Integer UPDATED_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID = 2;
//
//    private static final String DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_ECLAIMS_ATTACHMENT_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_ECLAIMS_ATTACHMENT_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_ATTACHMENT_NUMBER = 1;
//    private static final Integer UPDATED_ATTACHMENT_NUMBER = 2;
//
//    private static final String DEFAULT_TYPE_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_TYPE_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_TRANSACTION_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_TRANSACTION_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_CLAIMS_NOTE_TYPE = "AAAAAAAAAA";
//    private static final String UPDATED_CLAIMS_NOTE_TYPE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_CLAIMS_NOTE = "AAAAAAAAAA";
//    private static final String UPDATED_CLAIMS_NOTE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_NO = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_NO = "BBBBBBBBBB";
//
//    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_CREATED_BY_ID = 1;
//    private static final Integer UPDATED_CREATED_BY_ID = 2;
//
//    private static final String DEFAULT_CREATED_BY_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_CREATED_BY_NAME = "BBBBBBBBBB";
//
//    private static final ZonedDateTime DEFAULT_CREATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
//    private static final ZonedDateTime UPDATED_CREATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
//
//    private static final Integer DEFAULT_UPDATED_BY_ID = 1;
//    private static final Integer UPDATED_UPDATED_BY_ID = 2;
//
//    private static final String DEFAULT_UPDATED_BY_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_UPDATED_BY_NAME = "BBBBBBBBBB";
//
//    private static final ZonedDateTime DEFAULT_UPDATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
//    private static final ZonedDateTime UPDATED_UPDATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
//
//    private static final String ENTITY_API_URL = "/api/sales-order-insurance-details";
//    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
//
//    private static Random random = new Random();
//    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
//
//    @Autowired
//    private SalesOrderInsuranceDetailsRepository salesOrderInsuranceDetailsRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    private SalesOrderInsuranceDetails salesOrderInsuranceDetails;
//
//    /**
//     * Create an entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static SalesOrderInsuranceDetails createEntity(EntityManager em) {
//        SalesOrderInsuranceDetails salesOrderInsuranceDetails = new SalesOrderInsuranceDetails()
//            .salesOrderInsuranceDetailsId(DEFAULT_SALES_ORDER_INSURANCE_DETAILS_ID)
//            .salesOrderId(DEFAULT_SALES_ORDER_ID)
//            .patientId(DEFAULT_PATIENT_ID)
//            .primaryInsurerId(DEFAULT_PRIMARY_INSURER_ID)
//            .primaryInsurerName(DEFAULT_PRIMARY_INSURER_NAME)
//            .primaryInsuranceGroupId(DEFAULT_PRIMARY_INSURANCE_GROUP_ID)
//            .primaryInsuranceGroupName(DEFAULT_PRIMARY_INSURANCE_GROUP_NAME)
//            .primaryInsurancePlanId(DEFAULT_PRIMARY_INSURANCE_PLAN_ID)
//            .primaryInsurancePlanType(DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE)
//            .primaryInsuranceStateId(DEFAULT_PRIMARY_INSURANCE_STATE_ID)
//            .primaryInsuranceStateName(DEFAULT_PRIMARY_INSURANCE_STATE_NAME)
//            .primaryInsurerPolicyNo(DEFAULT_PRIMARY_INSURER_POLICY_NO)
//            .primaryInsurerPatientIdNumber(DEFAULT_PRIMARY_INSURER_PATIENT_ID_NUMBER)
//            .primaryInsurerEffectiveDate(DEFAULT_PRIMARY_INSURER_EFFECTIVE_DATE)
//            .primaryInsurerVerificationStatus(DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS)
//            .primaryInsurerVerificationDate(DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE)
//            .primaryInsurerPayPercentage(DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE)
//            .primaryBox10d(DEFAULT_PRIMARY_BOX_10_D)
//            .primaryBox19(DEFAULT_PRIMARY_BOX_19)
//            .primaryBox24ia(DEFAULT_PRIMARY_BOX_24_IA)
//            .primaryBox24ja(DEFAULT_PRIMARY_BOX_24_JA)
//            .primaryBox24jb(DEFAULT_PRIMARY_BOX_24_JB)
//            .primaryIncludeBox24Jbstatus(DEFAULT_PRIMARY_INCLUDE_BOX_24_JBSTATUS)
//            .primaryIncludePayerSalesOrderStatus(DEFAULT_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .primaryWaitForPreviousPayerBeforeBillingStatus(DEFAULT_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .primaryPayPercentageStatus(DEFAULT_PRIMARY_PAY_PERCENTAGE_STATUS)
//            .secondaryInsurerId(DEFAULT_SECONDARY_INSURER_ID)
//            .secondaryInsurerName(DEFAULT_SECONDARY_INSURER_NAME)
//            .secondaryInsuranceGroupId(DEFAULT_SECONDARY_INSURANCE_GROUP_ID)
//            .secondaryInsuranceGroupName(DEFAULT_SECONDARY_INSURANCE_GROUP_NAME)
//            .secondaryInsurancePlanId(DEFAULT_SECONDARY_INSURANCE_PLAN_ID)
//            .secondaryInsurancePlanType(DEFAULT_SECONDARY_INSURANCE_PLAN_TYPE)
//            .secondaryInsuranceStateId(DEFAULT_SECONDARY_INSURANCE_STATE_ID)
//            .secondaryInsuranceStateName(DEFAULT_SECONDARY_INSURANCE_STATE_NAME)
//            .secondaryInsurerPolicyNo(DEFAULT_SECONDARY_INSURER_POLICY_NO)
//            .secondaryInsurerPatientIdNumber(DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER)
//            .secondaryInsurerEffectiveDate(DEFAULT_SECONDARY_INSURER_EFFECTIVE_DATE)
//            .secondaryInsurerVerificationStatus(DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS)
//            .secondaryInsurerVerificationDate(DEFAULT_SECONDARY_INSURER_VERIFICATION_DATE)
//            .secondaryInsurerPayPercentage(DEFAULT_SECONDARY_INSURER_PAY_PERCENTAGE)
//            .secondaryBox10d(DEFAULT_SECONDARY_BOX_10_D)
//            .secondaryBox19(DEFAULT_SECONDARY_BOX_19)
//            .secondaryBox24ia(DEFAULT_SECONDARY_BOX_24_IA)
//            .secondaryBox24ja(DEFAULT_SECONDARY_BOX_24_JA)
//            .secondaryBox24jb(DEFAULT_SECONDARY_BOX_24_JB)
//            .secondaryIncludeBox24jbStatus(DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS)
//            .secondaryIncludePayerSalesOrderStatus(DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .secondaryWaitPreviousPayerBefrBillingStatus(DEFAULT_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS)
//            .secondaryPayPercentageStatus(DEFAULT_SECONDARY_PAY_PERCENTAGE_STATUS)
//            .tertiaryInsurerId(DEFAULT_TERTIARY_INSURER_ID)
//            .tertiaryInsurerName(DEFAULT_TERTIARY_INSURER_NAME)
//            .tertiaryInsuranceGroupId(DEFAULT_TERTIARY_INSURANCE_GROUP_ID)
//            .tertiaryInsuranceGroupName(DEFAULT_TERTIARY_INSURANCE_GROUP_NAME)
//            .tertiaryInsurancePlanId(DEFAULT_TERTIARY_INSURANCE_PLAN_ID)
//            .tertiaryInsurancePlanType(DEFAULT_TERTIARY_INSURANCE_PLAN_TYPE)
//            .tertiaryInsuranceStateId(DEFAULT_TERTIARY_INSURANCE_STATE_ID)
//            .tertiaryInsuranceStateName(DEFAULT_TERTIARY_INSURANCE_STATE_NAME)
//            .tertiaryInsurerPolicyno(DEFAULT_TERTIARY_INSURER_POLICYNO)
//            .tertiaryInsurerPatientIdNumber(DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER)
//            .tertiaryInsurerEffectiveDate(DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE)
//            .tertiaryInsurerVerificationStatus(DEFAULT_TERTIARY_INSURER_VERIFICATION_STATUS)
//            .tertiaryInsurerVerificationDate(DEFAULT_TERTIARY_INSURER_VERIFICATION_DATE)
//            .tertiaryInsurerPayPercentage(DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE)
//            .tertiaryBox10d(DEFAULT_TERTIARY_BOX_10_D)
//            .tertiaryBox19(DEFAULT_TERTIARY_BOX_19)
//            .tertiaryBox24ia(DEFAULT_TERTIARY_BOX_24_IA)
//            .tertiaryBox24ja(DEFAULT_TERTIARY_BOX_24_JA)
//            .tertiaryBox24jb(DEFAULT_TERTIARY_BOX_24_JB)
//            .tertiaryIncludeBox24jbStatus(DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS)
//            .tertiaryIncludePayerInSalesOrderStatus(DEFAULT_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS)
//            .tertiaryWaitPreviousPayerBeforeBillingStatus(DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .tertiaryPayPercentage0Status(DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS)
//            .insuranceVerificationStatus(DEFAULT_INSURANCE_VERIFICATION_STATUS)
//            .coverageVerificationStatus(DEFAULT_COVERAGE_VERIFICATION_STATUS)
//            .excludeFromEligibilityCheckStatus(DEFAULT_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS)
//            .patientPayPercentage(DEFAULT_PATIENT_PAY_PERCENTAGE)
//            .patientIncludeThisPayorInSalesOrderStatus(DEFAULT_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS)
//            .patientWaitForPreviousPayerBeforeBillingStatus(DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .workersCompDateOfOnset(DEFAULT_WORKERS_COMP_DATE_OF_ONSET)
//            .workersCompInjuryRelatedEmploymentStatus(DEFAULT_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS)
//            .workersCompInjuryRelatedAutoAccidentStatus(DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS)
//            .workersCompAutoAccidentStateId(DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID)
//            .workersCompInjuryRelatedToOtherAccidentStatus(DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS)
//            .eclaimsAttachmentStatus(DEFAULT_ECLAIMS_ATTACHMENT_STATUS)
//            .attachmentNumber(DEFAULT_ATTACHMENT_NUMBER)
//            .typeCode(DEFAULT_TYPE_CODE)
//            .transactionCode(DEFAULT_TRANSACTION_CODE)
//            .claimsNoteType(DEFAULT_CLAIMS_NOTE_TYPE)
//            .claimsNote(DEFAULT_CLAIMS_NOTE)
//            .salesOrderNo(DEFAULT_SALES_ORDER_NO)
//            .status(DEFAULT_STATUS)
//            .createdById(DEFAULT_CREATED_BY_ID)
//            .createdByName(DEFAULT_CREATED_BY_NAME)
//            .createdDate(DEFAULT_CREATED_DATE)
//            .updatedById(DEFAULT_UPDATED_BY_ID)
//            .updatedByName(DEFAULT_UPDATED_BY_NAME)
//            .updatedDate(DEFAULT_UPDATED_DATE);
//        return salesOrderInsuranceDetails;
//    }
//
//    /**
//     * Create an updated entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static SalesOrderInsuranceDetails createUpdatedEntity(EntityManager em) {
//        SalesOrderInsuranceDetails salesOrderInsuranceDetails = new SalesOrderInsuranceDetails()
//            .salesOrderInsuranceDetailsId(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .primaryInsurerId(UPDATED_PRIMARY_INSURER_ID)
//            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
//            .primaryInsuranceGroupId(UPDATED_PRIMARY_INSURANCE_GROUP_ID)
//            .primaryInsuranceGroupName(UPDATED_PRIMARY_INSURANCE_GROUP_NAME)
//            .primaryInsurancePlanId(UPDATED_PRIMARY_INSURANCE_PLAN_ID)
//            .primaryInsurancePlanType(UPDATED_PRIMARY_INSURANCE_PLAN_TYPE)
//            .primaryInsuranceStateId(UPDATED_PRIMARY_INSURANCE_STATE_ID)
//            .primaryInsuranceStateName(UPDATED_PRIMARY_INSURANCE_STATE_NAME)
//            .primaryInsurerPolicyNo(UPDATED_PRIMARY_INSURER_POLICY_NO)
//            .primaryInsurerPatientIdNumber(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER)
//            .primaryInsurerEffectiveDate(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE)
//            .primaryInsurerVerificationStatus(UPDATED_PRIMARY_INSURER_VERIFICATION_STATUS)
//            .primaryInsurerVerificationDate(UPDATED_PRIMARY_INSURER_VERIFICATION_DATE)
//            .primaryInsurerPayPercentage(UPDATED_PRIMARY_INSURER_PAY_PERCENTAGE)
//            .primaryBox10d(UPDATED_PRIMARY_BOX_10_D)
//            .primaryBox19(UPDATED_PRIMARY_BOX_19)
//            .primaryBox24ia(UPDATED_PRIMARY_BOX_24_IA)
//            .primaryBox24ja(UPDATED_PRIMARY_BOX_24_JA)
//            .primaryBox24jb(UPDATED_PRIMARY_BOX_24_JB)
//            .primaryIncludeBox24Jbstatus(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS)
//            .primaryIncludePayerSalesOrderStatus(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .primaryWaitForPreviousPayerBeforeBillingStatus(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .primaryPayPercentageStatus(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS)
//            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
//            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
//            .secondaryInsuranceGroupId(UPDATED_SECONDARY_INSURANCE_GROUP_ID)
//            .secondaryInsuranceGroupName(UPDATED_SECONDARY_INSURANCE_GROUP_NAME)
//            .secondaryInsurancePlanId(UPDATED_SECONDARY_INSURANCE_PLAN_ID)
//            .secondaryInsurancePlanType(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE)
//            .secondaryInsuranceStateId(UPDATED_SECONDARY_INSURANCE_STATE_ID)
//            .secondaryInsuranceStateName(UPDATED_SECONDARY_INSURANCE_STATE_NAME)
//            .secondaryInsurerPolicyNo(UPDATED_SECONDARY_INSURER_POLICY_NO)
//            .secondaryInsurerPatientIdNumber(UPDATED_SECONDARY_INSURER_PATIENT_ID_NUMBER)
//            .secondaryInsurerEffectiveDate(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE)
//            .secondaryInsurerVerificationStatus(UPDATED_SECONDARY_INSURER_VERIFICATION_STATUS)
//            .secondaryInsurerVerificationDate(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE)
//            .secondaryInsurerPayPercentage(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE)
//            .secondaryBox10d(UPDATED_SECONDARY_BOX_10_D)
//            .secondaryBox19(UPDATED_SECONDARY_BOX_19)
//            .secondaryBox24ia(UPDATED_SECONDARY_BOX_24_IA)
//            .secondaryBox24ja(UPDATED_SECONDARY_BOX_24_JA)
//            .secondaryBox24jb(UPDATED_SECONDARY_BOX_24_JB)
//            .secondaryIncludeBox24jbStatus(UPDATED_SECONDARY_INCLUDE_BOX_24_JB_STATUS)
//            .secondaryIncludePayerSalesOrderStatus(UPDATED_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .secondaryWaitPreviousPayerBefrBillingStatus(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS)
//            .secondaryPayPercentageStatus(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS)
//            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
//            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
//            .tertiaryInsuranceGroupId(UPDATED_TERTIARY_INSURANCE_GROUP_ID)
//            .tertiaryInsuranceGroupName(UPDATED_TERTIARY_INSURANCE_GROUP_NAME)
//            .tertiaryInsurancePlanId(UPDATED_TERTIARY_INSURANCE_PLAN_ID)
//            .tertiaryInsurancePlanType(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE)
//            .tertiaryInsuranceStateId(UPDATED_TERTIARY_INSURANCE_STATE_ID)
//            .tertiaryInsuranceStateName(UPDATED_TERTIARY_INSURANCE_STATE_NAME)
//            .tertiaryInsurerPolicyno(UPDATED_TERTIARY_INSURER_POLICYNO)
//            .tertiaryInsurerPatientIdNumber(UPDATED_TERTIARY_INSURER_PATIENT_ID_NUMBER)
//            .tertiaryInsurerEffectiveDate(UPDATED_TERTIARY_INSURER_EFFECTIVE_DATE)
//            .tertiaryInsurerVerificationStatus(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS)
//            .tertiaryInsurerVerificationDate(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE)
//            .tertiaryInsurerPayPercentage(UPDATED_TERTIARY_INSURER_PAY_PERCENTAGE)
//            .tertiaryBox10d(UPDATED_TERTIARY_BOX_10_D)
//            .tertiaryBox19(UPDATED_TERTIARY_BOX_19)
//            .tertiaryBox24ia(UPDATED_TERTIARY_BOX_24_IA)
//            .tertiaryBox24ja(UPDATED_TERTIARY_BOX_24_JA)
//            .tertiaryBox24jb(UPDATED_TERTIARY_BOX_24_JB)
//            .tertiaryIncludeBox24jbStatus(UPDATED_TERTIARY_INCLUDE_BOX_24_JB_STATUS)
//            .tertiaryIncludePayerInSalesOrderStatus(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS)
//            .tertiaryWaitPreviousPayerBeforeBillingStatus(UPDATED_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .tertiaryPayPercentage0Status(UPDATED_TERTIARY_PAY_PERCENTAGE_0_STATUS)
//            .insuranceVerificationStatus(UPDATED_INSURANCE_VERIFICATION_STATUS)
//            .coverageVerificationStatus(UPDATED_COVERAGE_VERIFICATION_STATUS)
//            .excludeFromEligibilityCheckStatus(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS)
//            .patientPayPercentage(UPDATED_PATIENT_PAY_PERCENTAGE)
//            .patientIncludeThisPayorInSalesOrderStatus(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS)
//            .patientWaitForPreviousPayerBeforeBillingStatus(UPDATED_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .workersCompDateOfOnset(UPDATED_WORKERS_COMP_DATE_OF_ONSET)
//            .workersCompInjuryRelatedEmploymentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS)
//            .workersCompInjuryRelatedAutoAccidentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS)
//            .workersCompAutoAccidentStateId(UPDATED_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID)
//            .workersCompInjuryRelatedToOtherAccidentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS)
//            .eclaimsAttachmentStatus(UPDATED_ECLAIMS_ATTACHMENT_STATUS)
//            .attachmentNumber(UPDATED_ATTACHMENT_NUMBER)
//            .typeCode(UPDATED_TYPE_CODE)
//            .transactionCode(UPDATED_TRANSACTION_CODE)
//            .claimsNoteType(UPDATED_CLAIMS_NOTE_TYPE)
//            .claimsNote(UPDATED_CLAIMS_NOTE)
//            .salesOrderNo(UPDATED_SALES_ORDER_NO)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//        return salesOrderInsuranceDetails;
//    }
//
//    public static void deleteEntities(EntityManager em) {
//        try {
//            em.deleteAll(SalesOrderInsuranceDetails.class).block();
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
//        salesOrderInsuranceDetails = createEntity(em);
//    }
//
//    @Test
//    void createSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeCreate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // Create the SalesOrderInsuranceDetails
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isCreated();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeCreate + 1);
//        SalesOrderInsuranceDetails testSalesOrderInsuranceDetails = salesOrderInsuranceDetailsList.get(
//            salesOrderInsuranceDetailsList.size() - 1
//        );
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId()).isEqualTo(DEFAULT_SALES_ORDER_INSURANCE_DETAILS_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerId()).isEqualTo(DEFAULT_PRIMARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerName()).isEqualTo(DEFAULT_PRIMARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupId()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupName()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanId()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanType()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateId()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateName()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPolicyNo()).isEqualTo(DEFAULT_PRIMARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber()).isEqualTo(DEFAULT_PRIMARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate()).isEqualTo(DEFAULT_PRIMARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationDate()).isEqualTo(DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPayPercentage()).isEqualTo(DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox10d()).isEqualTo(DEFAULT_PRIMARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox19()).isEqualTo(DEFAULT_PRIMARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ia()).isEqualTo(DEFAULT_PRIMARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ja()).isEqualTo(DEFAULT_PRIMARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24jb()).isEqualTo(DEFAULT_PRIMARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus()).isEqualTo(DEFAULT_PRIMARY_INCLUDE_BOX_24_JBSTATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus())
//            .isEqualTo(DEFAULT_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryPayPercentageStatus()).isEqualTo(DEFAULT_PRIMARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerId()).isEqualTo(DEFAULT_SECONDARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerName()).isEqualTo(DEFAULT_SECONDARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupId()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupName()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanId()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanType()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateId()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateName()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPolicyNo()).isEqualTo(DEFAULT_SECONDARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate()).isEqualTo(DEFAULT_SECONDARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationDate())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPayPercentage()).isEqualTo(DEFAULT_SECONDARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox10d()).isEqualTo(DEFAULT_SECONDARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox19()).isEqualTo(DEFAULT_SECONDARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ia()).isEqualTo(DEFAULT_SECONDARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ja()).isEqualTo(DEFAULT_SECONDARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24jb()).isEqualTo(DEFAULT_SECONDARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus()).isEqualTo(DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus())
//            .isEqualTo(DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus())
//            .isEqualTo(DEFAULT_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryPayPercentageStatus()).isEqualTo(DEFAULT_SECONDARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerId()).isEqualTo(DEFAULT_TERTIARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerName()).isEqualTo(DEFAULT_TERTIARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupName()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanType()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateName()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPolicyno()).isEqualTo(DEFAULT_TERTIARY_INSURER_POLICYNO);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate()).isEqualTo(DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationDate())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPayPercentage()).isEqualTo(DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox10d()).isEqualTo(DEFAULT_TERTIARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox19()).isEqualTo(DEFAULT_TERTIARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ia()).isEqualTo(DEFAULT_TERTIARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ja()).isEqualTo(DEFAULT_TERTIARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24jb()).isEqualTo(DEFAULT_TERTIARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus()).isEqualTo(DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus())
//            .isEqualTo(DEFAULT_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryPayPercentage0Status()).isEqualTo(DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getInsuranceVerificationStatus()).isEqualTo(DEFAULT_INSURANCE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCoverageVerificationStatus()).isEqualTo(DEFAULT_COVERAGE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus())
//            .isEqualTo(DEFAULT_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientPayPercentage()).isEqualTo(DEFAULT_PATIENT_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus())
//            .isEqualTo(DEFAULT_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompDateOfOnset()).isEqualTo(DEFAULT_WORKERS_COMP_DATE_OF_ONSET);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId())
//            .isEqualTo(DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getEclaimsAttachmentStatus()).isEqualTo(DEFAULT_ECLAIMS_ATTACHMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getAttachmentNumber()).isEqualTo(DEFAULT_ATTACHMENT_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTypeCode()).isEqualTo(DEFAULT_TYPE_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getTransactionCode()).isEqualTo(DEFAULT_TRANSACTION_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNoteType()).isEqualTo(DEFAULT_CLAIMS_NOTE_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNote()).isEqualTo(DEFAULT_CLAIMS_NOTE);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderNo()).isEqualTo(DEFAULT_SALES_ORDER_NO);
//        assertThat(testSalesOrderInsuranceDetails.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void createSalesOrderInsuranceDetailsWithExistingId() throws Exception {
//        // Create the SalesOrderInsuranceDetails with an existing ID
//        salesOrderInsuranceDetails.setId(1L);
//
//        int databaseSizeBeforeCreate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//
//        // An entity with an existing ID cannot be created, so this API call must fail
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeCreate);
//    }
//
//    @Test
//    void checkSalesOrderInsuranceDetailsIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setSalesOrderInsuranceDetailsId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSalesOrderIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setSalesOrderId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setPatientId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPrimaryInsurerIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setPrimaryInsurerId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPrimaryInsurerNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setPrimaryInsurerName(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPrimaryInsuranceGroupIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setPrimaryInsuranceGroupId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPrimaryInsuranceGroupNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setPrimaryInsuranceGroupName(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSecondaryInsuranceGroupIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setSecondaryInsuranceGroupId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSecondaryInsuranceGroupNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setSecondaryInsuranceGroupName(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkTertiaryInsuranceGroupIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setTertiaryInsuranceGroupId(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkTertiaryInsuranceGroupNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderInsuranceDetails.setTertiaryInsuranceGroupName(null);
//
//        // Create the SalesOrderInsuranceDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void getAllSalesOrderInsuranceDetailsAsStream() {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = webTestClient
//            .get()
//            .uri(ENTITY_API_URL)
//            .accept(MediaType.APPLICATION_NDJSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
//            .returnResult(SalesOrderInsuranceDetails.class)
//            .getResponseBody()
//            .filter(salesOrderInsuranceDetails::equals)
//            .collectList()
//            .block(Duration.ofSeconds(5));
//
//        assertThat(salesOrderInsuranceDetailsList).isNotNull();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(1);
//        SalesOrderInsuranceDetails testSalesOrderInsuranceDetails = salesOrderInsuranceDetailsList.get(0);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId()).isEqualTo(DEFAULT_SALES_ORDER_INSURANCE_DETAILS_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerId()).isEqualTo(DEFAULT_PRIMARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerName()).isEqualTo(DEFAULT_PRIMARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupId()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupName()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanId()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanType()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateId()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateName()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPolicyNo()).isEqualTo(DEFAULT_PRIMARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber()).isEqualTo(DEFAULT_PRIMARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate()).isEqualTo(DEFAULT_PRIMARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationDate()).isEqualTo(DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPayPercentage()).isEqualTo(DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox10d()).isEqualTo(DEFAULT_PRIMARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox19()).isEqualTo(DEFAULT_PRIMARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ia()).isEqualTo(DEFAULT_PRIMARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ja()).isEqualTo(DEFAULT_PRIMARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24jb()).isEqualTo(DEFAULT_PRIMARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus()).isEqualTo(DEFAULT_PRIMARY_INCLUDE_BOX_24_JBSTATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus())
//            .isEqualTo(DEFAULT_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryPayPercentageStatus()).isEqualTo(DEFAULT_PRIMARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerId()).isEqualTo(DEFAULT_SECONDARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerName()).isEqualTo(DEFAULT_SECONDARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupId()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupName()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanId()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanType()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateId()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateName()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPolicyNo()).isEqualTo(DEFAULT_SECONDARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate()).isEqualTo(DEFAULT_SECONDARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationDate())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPayPercentage()).isEqualTo(DEFAULT_SECONDARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox10d()).isEqualTo(DEFAULT_SECONDARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox19()).isEqualTo(DEFAULT_SECONDARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ia()).isEqualTo(DEFAULT_SECONDARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ja()).isEqualTo(DEFAULT_SECONDARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24jb()).isEqualTo(DEFAULT_SECONDARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus()).isEqualTo(DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus())
//            .isEqualTo(DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus())
//            .isEqualTo(DEFAULT_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryPayPercentageStatus()).isEqualTo(DEFAULT_SECONDARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerId()).isEqualTo(DEFAULT_TERTIARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerName()).isEqualTo(DEFAULT_TERTIARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupName()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanType()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateName()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPolicyno()).isEqualTo(DEFAULT_TERTIARY_INSURER_POLICYNO);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate()).isEqualTo(DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationDate())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPayPercentage()).isEqualTo(DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox10d()).isEqualTo(DEFAULT_TERTIARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox19()).isEqualTo(DEFAULT_TERTIARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ia()).isEqualTo(DEFAULT_TERTIARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ja()).isEqualTo(DEFAULT_TERTIARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24jb()).isEqualTo(DEFAULT_TERTIARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus()).isEqualTo(DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus())
//            .isEqualTo(DEFAULT_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryPayPercentage0Status()).isEqualTo(DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getInsuranceVerificationStatus()).isEqualTo(DEFAULT_INSURANCE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCoverageVerificationStatus()).isEqualTo(DEFAULT_COVERAGE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus())
//            .isEqualTo(DEFAULT_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientPayPercentage()).isEqualTo(DEFAULT_PATIENT_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus())
//            .isEqualTo(DEFAULT_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompDateOfOnset()).isEqualTo(DEFAULT_WORKERS_COMP_DATE_OF_ONSET);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId())
//            .isEqualTo(DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getEclaimsAttachmentStatus()).isEqualTo(DEFAULT_ECLAIMS_ATTACHMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getAttachmentNumber()).isEqualTo(DEFAULT_ATTACHMENT_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTypeCode()).isEqualTo(DEFAULT_TYPE_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getTransactionCode()).isEqualTo(DEFAULT_TRANSACTION_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNoteType()).isEqualTo(DEFAULT_CLAIMS_NOTE_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNote()).isEqualTo(DEFAULT_CLAIMS_NOTE);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderNo()).isEqualTo(DEFAULT_SALES_ORDER_NO);
//        assertThat(testSalesOrderInsuranceDetails.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void getAllSalesOrderInsuranceDetails() {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        // Get all the salesOrderInsuranceDetailsList
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
//            .value(hasItem(salesOrderInsuranceDetails.getId().intValue()))
//            .jsonPath("$.[*].salesOrderInsuranceDetailsId")
//            .value(hasItem(DEFAULT_SALES_ORDER_INSURANCE_DETAILS_ID))
//            .jsonPath("$.[*].salesOrderId")
//            .value(hasItem(DEFAULT_SALES_ORDER_ID))
//            .jsonPath("$.[*].patientId")
//            .value(hasItem(DEFAULT_PATIENT_ID))
//            .jsonPath("$.[*].primaryInsurerId")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_ID))
//            .jsonPath("$.[*].primaryInsurerName")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_NAME))
//            .jsonPath("$.[*].primaryInsuranceGroupId")
//            .value(hasItem(DEFAULT_PRIMARY_INSURANCE_GROUP_ID))
//            .jsonPath("$.[*].primaryInsuranceGroupName")
//            .value(hasItem(DEFAULT_PRIMARY_INSURANCE_GROUP_NAME))
//            .jsonPath("$.[*].primaryInsurancePlanId")
//            .value(hasItem(DEFAULT_PRIMARY_INSURANCE_PLAN_ID))
//            .jsonPath("$.[*].primaryInsurancePlanType")
//            .value(hasItem(DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE))
//            .jsonPath("$.[*].primaryInsuranceStateId")
//            .value(hasItem(DEFAULT_PRIMARY_INSURANCE_STATE_ID))
//            .jsonPath("$.[*].primaryInsuranceStateName")
//            .value(hasItem(DEFAULT_PRIMARY_INSURANCE_STATE_NAME))
//            .jsonPath("$.[*].primaryInsurerPolicyNo")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_POLICY_NO))
//            .jsonPath("$.[*].primaryInsurerPatientIdNumber")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_PATIENT_ID_NUMBER))
//            .jsonPath("$.[*].primaryInsurerEffectiveDate")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_EFFECTIVE_DATE.toString()))
//            .jsonPath("$.[*].primaryInsurerVerificationStatus")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS))
//            .jsonPath("$.[*].primaryInsurerVerificationDate")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE.toString()))
//            .jsonPath("$.[*].primaryInsurerPayPercentage")
//            .value(hasItem(DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE))
//            .jsonPath("$.[*].primaryBox10d")
//            .value(hasItem(DEFAULT_PRIMARY_BOX_10_D))
//            .jsonPath("$.[*].primaryBox19")
//            .value(hasItem(DEFAULT_PRIMARY_BOX_19))
//            .jsonPath("$.[*].primaryBox24ia")
//            .value(hasItem(DEFAULT_PRIMARY_BOX_24_IA))
//            .jsonPath("$.[*].primaryBox24ja")
//            .value(hasItem(DEFAULT_PRIMARY_BOX_24_JA))
//            .jsonPath("$.[*].primaryBox24jb")
//            .value(hasItem(DEFAULT_PRIMARY_BOX_24_JB))
//            .jsonPath("$.[*].primaryIncludeBox24Jbstatus")
//            .value(hasItem(DEFAULT_PRIMARY_INCLUDE_BOX_24_JBSTATUS))
//            .jsonPath("$.[*].primaryIncludePayerSalesOrderStatus")
//            .value(hasItem(DEFAULT_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS))
//            .jsonPath("$.[*].primaryWaitForPreviousPayerBeforeBillingStatus")
//            .value(hasItem(DEFAULT_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS))
//            .jsonPath("$.[*].primaryPayPercentageStatus")
//            .value(hasItem(DEFAULT_PRIMARY_PAY_PERCENTAGE_STATUS))
//            .jsonPath("$.[*].secondaryInsurerId")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_ID))
//            .jsonPath("$.[*].secondaryInsurerName")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_NAME))
//            .jsonPath("$.[*].secondaryInsuranceGroupId")
//            .value(hasItem(DEFAULT_SECONDARY_INSURANCE_GROUP_ID))
//            .jsonPath("$.[*].secondaryInsuranceGroupName")
//            .value(hasItem(DEFAULT_SECONDARY_INSURANCE_GROUP_NAME))
//            .jsonPath("$.[*].secondaryInsurancePlanId")
//            .value(hasItem(DEFAULT_SECONDARY_INSURANCE_PLAN_ID))
//            .jsonPath("$.[*].secondaryInsurancePlanType")
//            .value(hasItem(DEFAULT_SECONDARY_INSURANCE_PLAN_TYPE))
//            .jsonPath("$.[*].secondaryInsuranceStateId")
//            .value(hasItem(DEFAULT_SECONDARY_INSURANCE_STATE_ID))
//            .jsonPath("$.[*].secondaryInsuranceStateName")
//            .value(hasItem(DEFAULT_SECONDARY_INSURANCE_STATE_NAME))
//            .jsonPath("$.[*].secondaryInsurerPolicyNo")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_POLICY_NO))
//            .jsonPath("$.[*].secondaryInsurerPatientIdNumber")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER))
//            .jsonPath("$.[*].secondaryInsurerEffectiveDate")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_EFFECTIVE_DATE.toString()))
//            .jsonPath("$.[*].secondaryInsurerVerificationStatus")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS))
//            .jsonPath("$.[*].secondaryInsurerVerificationDate")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_VERIFICATION_DATE.toString()))
//            .jsonPath("$.[*].secondaryInsurerPayPercentage")
//            .value(hasItem(DEFAULT_SECONDARY_INSURER_PAY_PERCENTAGE))
//            .jsonPath("$.[*].secondaryBox10d")
//            .value(hasItem(DEFAULT_SECONDARY_BOX_10_D))
//            .jsonPath("$.[*].secondaryBox19")
//            .value(hasItem(DEFAULT_SECONDARY_BOX_19))
//            .jsonPath("$.[*].secondaryBox24ia")
//            .value(hasItem(DEFAULT_SECONDARY_BOX_24_IA))
//            .jsonPath("$.[*].secondaryBox24ja")
//            .value(hasItem(DEFAULT_SECONDARY_BOX_24_JA))
//            .jsonPath("$.[*].secondaryBox24jb")
//            .value(hasItem(DEFAULT_SECONDARY_BOX_24_JB))
//            .jsonPath("$.[*].secondaryIncludeBox24jbStatus")
//            .value(hasItem(DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS))
//            .jsonPath("$.[*].secondaryIncludePayerSalesOrderStatus")
//            .value(hasItem(DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS))
//            .jsonPath("$.[*].secondaryWaitPreviousPayerBefrBillingStatus")
//            .value(hasItem(DEFAULT_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS))
//            .jsonPath("$.[*].secondaryPayPercentageStatus")
//            .value(hasItem(DEFAULT_SECONDARY_PAY_PERCENTAGE_STATUS))
//            .jsonPath("$.[*].tertiaryInsurerId")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_ID))
//            .jsonPath("$.[*].tertiaryInsurerName")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_NAME))
//            .jsonPath("$.[*].tertiaryInsuranceGroupId")
//            .value(hasItem(DEFAULT_TERTIARY_INSURANCE_GROUP_ID))
//            .jsonPath("$.[*].tertiaryInsuranceGroupName")
//            .value(hasItem(DEFAULT_TERTIARY_INSURANCE_GROUP_NAME))
//            .jsonPath("$.[*].tertiaryInsurancePlanId")
//            .value(hasItem(DEFAULT_TERTIARY_INSURANCE_PLAN_ID))
//            .jsonPath("$.[*].tertiaryInsurancePlanType")
//            .value(hasItem(DEFAULT_TERTIARY_INSURANCE_PLAN_TYPE))
//            .jsonPath("$.[*].tertiaryInsuranceStateId")
//            .value(hasItem(DEFAULT_TERTIARY_INSURANCE_STATE_ID))
//            .jsonPath("$.[*].tertiaryInsuranceStateName")
//            .value(hasItem(DEFAULT_TERTIARY_INSURANCE_STATE_NAME))
//            .jsonPath("$.[*].tertiaryInsurerPolicyno")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_POLICYNO))
//            .jsonPath("$.[*].tertiaryInsurerPatientIdNumber")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER))
//            .jsonPath("$.[*].tertiaryInsurerEffectiveDate")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE.toString()))
//            .jsonPath("$.[*].tertiaryInsurerVerificationStatus")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_VERIFICATION_STATUS))
//            .jsonPath("$.[*].tertiaryInsurerVerificationDate")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_VERIFICATION_DATE.toString()))
//            .jsonPath("$.[*].tertiaryInsurerPayPercentage")
//            .value(hasItem(DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE))
//            .jsonPath("$.[*].tertiaryBox10d")
//            .value(hasItem(DEFAULT_TERTIARY_BOX_10_D))
//            .jsonPath("$.[*].tertiaryBox19")
//            .value(hasItem(DEFAULT_TERTIARY_BOX_19))
//            .jsonPath("$.[*].tertiaryBox24ia")
//            .value(hasItem(DEFAULT_TERTIARY_BOX_24_IA))
//            .jsonPath("$.[*].tertiaryBox24ja")
//            .value(hasItem(DEFAULT_TERTIARY_BOX_24_JA))
//            .jsonPath("$.[*].tertiaryBox24jb")
//            .value(hasItem(DEFAULT_TERTIARY_BOX_24_JB))
//            .jsonPath("$.[*].tertiaryIncludeBox24jbStatus")
//            .value(hasItem(DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS))
//            .jsonPath("$.[*].tertiaryIncludePayerInSalesOrderStatus")
//            .value(hasItem(DEFAULT_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS))
//            .jsonPath("$.[*].tertiaryWaitPreviousPayerBeforeBillingStatus")
//            .value(hasItem(DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS))
//            .jsonPath("$.[*].tertiaryPayPercentage0Status")
//            .value(hasItem(DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS))
//            .jsonPath("$.[*].insuranceVerificationStatus")
//            .value(hasItem(DEFAULT_INSURANCE_VERIFICATION_STATUS))
//            .jsonPath("$.[*].coverageVerificationStatus")
//            .value(hasItem(DEFAULT_COVERAGE_VERIFICATION_STATUS))
//            .jsonPath("$.[*].excludeFromEligibilityCheckStatus")
//            .value(hasItem(DEFAULT_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS))
//            .jsonPath("$.[*].patientPayPercentage")
//            .value(hasItem(DEFAULT_PATIENT_PAY_PERCENTAGE))
//            .jsonPath("$.[*].patientIncludeThisPayorInSalesOrderStatus")
//            .value(hasItem(DEFAULT_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS))
//            .jsonPath("$.[*].patientWaitForPreviousPayerBeforeBillingStatus")
//            .value(hasItem(DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS))
//            .jsonPath("$.[*].workersCompDateOfOnset")
//            .value(hasItem(DEFAULT_WORKERS_COMP_DATE_OF_ONSET.toString()))
//            .jsonPath("$.[*].workersCompInjuryRelatedEmploymentStatus")
//            .value(hasItem(DEFAULT_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS))
//            .jsonPath("$.[*].workersCompInjuryRelatedAutoAccidentStatus")
//            .value(hasItem(DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS))
//            .jsonPath("$.[*].workersCompAutoAccidentStateId")
//            .value(hasItem(DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID))
//            .jsonPath("$.[*].workersCompInjuryRelatedToOtherAccidentStatus")
//            .value(hasItem(DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS))
//            .jsonPath("$.[*].eclaimsAttachmentStatus")
//            .value(hasItem(DEFAULT_ECLAIMS_ATTACHMENT_STATUS))
//            .jsonPath("$.[*].attachmentNumber")
//            .value(hasItem(DEFAULT_ATTACHMENT_NUMBER))
//            .jsonPath("$.[*].typeCode")
//            .value(hasItem(DEFAULT_TYPE_CODE))
//            .jsonPath("$.[*].transactionCode")
//            .value(hasItem(DEFAULT_TRANSACTION_CODE))
//            .jsonPath("$.[*].claimsNoteType")
//            .value(hasItem(DEFAULT_CLAIMS_NOTE_TYPE))
//            .jsonPath("$.[*].claimsNote")
//            .value(hasItem(DEFAULT_CLAIMS_NOTE))
//            .jsonPath("$.[*].salesOrderNo")
//            .value(hasItem(DEFAULT_SALES_ORDER_NO))
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
//    void getSalesOrderInsuranceDetails() {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        // Get the salesOrderInsuranceDetails
//        webTestClient
//            .get()
//            .uri(ENTITY_API_URL_ID, salesOrderInsuranceDetails.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentType(MediaType.APPLICATION_JSON)
//            .expectBody()
//            .jsonPath("$.id")
//            .value(is(salesOrderInsuranceDetails.getId().intValue()))
//            .jsonPath("$.salesOrderInsuranceDetailsId")
//            .value(is(DEFAULT_SALES_ORDER_INSURANCE_DETAILS_ID))
//            .jsonPath("$.salesOrderId")
//            .value(is(DEFAULT_SALES_ORDER_ID))
//            .jsonPath("$.patientId")
//            .value(is(DEFAULT_PATIENT_ID))
//            .jsonPath("$.primaryInsurerId")
//            .value(is(DEFAULT_PRIMARY_INSURER_ID))
//            .jsonPath("$.primaryInsurerName")
//            .value(is(DEFAULT_PRIMARY_INSURER_NAME))
//            .jsonPath("$.primaryInsuranceGroupId")
//            .value(is(DEFAULT_PRIMARY_INSURANCE_GROUP_ID))
//            .jsonPath("$.primaryInsuranceGroupName")
//            .value(is(DEFAULT_PRIMARY_INSURANCE_GROUP_NAME))
//            .jsonPath("$.primaryInsurancePlanId")
//            .value(is(DEFAULT_PRIMARY_INSURANCE_PLAN_ID))
//            .jsonPath("$.primaryInsurancePlanType")
//            .value(is(DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE))
//            .jsonPath("$.primaryInsuranceStateId")
//            .value(is(DEFAULT_PRIMARY_INSURANCE_STATE_ID))
//            .jsonPath("$.primaryInsuranceStateName")
//            .value(is(DEFAULT_PRIMARY_INSURANCE_STATE_NAME))
//            .jsonPath("$.primaryInsurerPolicyNo")
//            .value(is(DEFAULT_PRIMARY_INSURER_POLICY_NO))
//            .jsonPath("$.primaryInsurerPatientIdNumber")
//            .value(is(DEFAULT_PRIMARY_INSURER_PATIENT_ID_NUMBER))
//            .jsonPath("$.primaryInsurerEffectiveDate")
//            .value(is(DEFAULT_PRIMARY_INSURER_EFFECTIVE_DATE.toString()))
//            .jsonPath("$.primaryInsurerVerificationStatus")
//            .value(is(DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS))
//            .jsonPath("$.primaryInsurerVerificationDate")
//            .value(is(DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE.toString()))
//            .jsonPath("$.primaryInsurerPayPercentage")
//            .value(is(DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE))
//            .jsonPath("$.primaryBox10d")
//            .value(is(DEFAULT_PRIMARY_BOX_10_D))
//            .jsonPath("$.primaryBox19")
//            .value(is(DEFAULT_PRIMARY_BOX_19))
//            .jsonPath("$.primaryBox24ia")
//            .value(is(DEFAULT_PRIMARY_BOX_24_IA))
//            .jsonPath("$.primaryBox24ja")
//            .value(is(DEFAULT_PRIMARY_BOX_24_JA))
//            .jsonPath("$.primaryBox24jb")
//            .value(is(DEFAULT_PRIMARY_BOX_24_JB))
//            .jsonPath("$.primaryIncludeBox24Jbstatus")
//            .value(is(DEFAULT_PRIMARY_INCLUDE_BOX_24_JBSTATUS))
//            .jsonPath("$.primaryIncludePayerSalesOrderStatus")
//            .value(is(DEFAULT_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS))
//            .jsonPath("$.primaryWaitForPreviousPayerBeforeBillingStatus")
//            .value(is(DEFAULT_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS))
//            .jsonPath("$.primaryPayPercentageStatus")
//            .value(is(DEFAULT_PRIMARY_PAY_PERCENTAGE_STATUS))
//            .jsonPath("$.secondaryInsurerId")
//            .value(is(DEFAULT_SECONDARY_INSURER_ID))
//            .jsonPath("$.secondaryInsurerName")
//            .value(is(DEFAULT_SECONDARY_INSURER_NAME))
//            .jsonPath("$.secondaryInsuranceGroupId")
//            .value(is(DEFAULT_SECONDARY_INSURANCE_GROUP_ID))
//            .jsonPath("$.secondaryInsuranceGroupName")
//            .value(is(DEFAULT_SECONDARY_INSURANCE_GROUP_NAME))
//            .jsonPath("$.secondaryInsurancePlanId")
//            .value(is(DEFAULT_SECONDARY_INSURANCE_PLAN_ID))
//            .jsonPath("$.secondaryInsurancePlanType")
//            .value(is(DEFAULT_SECONDARY_INSURANCE_PLAN_TYPE))
//            .jsonPath("$.secondaryInsuranceStateId")
//            .value(is(DEFAULT_SECONDARY_INSURANCE_STATE_ID))
//            .jsonPath("$.secondaryInsuranceStateName")
//            .value(is(DEFAULT_SECONDARY_INSURANCE_STATE_NAME))
//            .jsonPath("$.secondaryInsurerPolicyNo")
//            .value(is(DEFAULT_SECONDARY_INSURER_POLICY_NO))
//            .jsonPath("$.secondaryInsurerPatientIdNumber")
//            .value(is(DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER))
//            .jsonPath("$.secondaryInsurerEffectiveDate")
//            .value(is(DEFAULT_SECONDARY_INSURER_EFFECTIVE_DATE.toString()))
//            .jsonPath("$.secondaryInsurerVerificationStatus")
//            .value(is(DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS))
//            .jsonPath("$.secondaryInsurerVerificationDate")
//            .value(is(DEFAULT_SECONDARY_INSURER_VERIFICATION_DATE.toString()))
//            .jsonPath("$.secondaryInsurerPayPercentage")
//            .value(is(DEFAULT_SECONDARY_INSURER_PAY_PERCENTAGE))
//            .jsonPath("$.secondaryBox10d")
//            .value(is(DEFAULT_SECONDARY_BOX_10_D))
//            .jsonPath("$.secondaryBox19")
//            .value(is(DEFAULT_SECONDARY_BOX_19))
//            .jsonPath("$.secondaryBox24ia")
//            .value(is(DEFAULT_SECONDARY_BOX_24_IA))
//            .jsonPath("$.secondaryBox24ja")
//            .value(is(DEFAULT_SECONDARY_BOX_24_JA))
//            .jsonPath("$.secondaryBox24jb")
//            .value(is(DEFAULT_SECONDARY_BOX_24_JB))
//            .jsonPath("$.secondaryIncludeBox24jbStatus")
//            .value(is(DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS))
//            .jsonPath("$.secondaryIncludePayerSalesOrderStatus")
//            .value(is(DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS))
//            .jsonPath("$.secondaryWaitPreviousPayerBefrBillingStatus")
//            .value(is(DEFAULT_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS))
//            .jsonPath("$.secondaryPayPercentageStatus")
//            .value(is(DEFAULT_SECONDARY_PAY_PERCENTAGE_STATUS))
//            .jsonPath("$.tertiaryInsurerId")
//            .value(is(DEFAULT_TERTIARY_INSURER_ID))
//            .jsonPath("$.tertiaryInsurerName")
//            .value(is(DEFAULT_TERTIARY_INSURER_NAME))
//            .jsonPath("$.tertiaryInsuranceGroupId")
//            .value(is(DEFAULT_TERTIARY_INSURANCE_GROUP_ID))
//            .jsonPath("$.tertiaryInsuranceGroupName")
//            .value(is(DEFAULT_TERTIARY_INSURANCE_GROUP_NAME))
//            .jsonPath("$.tertiaryInsurancePlanId")
//            .value(is(DEFAULT_TERTIARY_INSURANCE_PLAN_ID))
//            .jsonPath("$.tertiaryInsurancePlanType")
//            .value(is(DEFAULT_TERTIARY_INSURANCE_PLAN_TYPE))
//            .jsonPath("$.tertiaryInsuranceStateId")
//            .value(is(DEFAULT_TERTIARY_INSURANCE_STATE_ID))
//            .jsonPath("$.tertiaryInsuranceStateName")
//            .value(is(DEFAULT_TERTIARY_INSURANCE_STATE_NAME))
//            .jsonPath("$.tertiaryInsurerPolicyno")
//            .value(is(DEFAULT_TERTIARY_INSURER_POLICYNO))
//            .jsonPath("$.tertiaryInsurerPatientIdNumber")
//            .value(is(DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER))
//            .jsonPath("$.tertiaryInsurerEffectiveDate")
//            .value(is(DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE.toString()))
//            .jsonPath("$.tertiaryInsurerVerificationStatus")
//            .value(is(DEFAULT_TERTIARY_INSURER_VERIFICATION_STATUS))
//            .jsonPath("$.tertiaryInsurerVerificationDate")
//            .value(is(DEFAULT_TERTIARY_INSURER_VERIFICATION_DATE.toString()))
//            .jsonPath("$.tertiaryInsurerPayPercentage")
//            .value(is(DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE))
//            .jsonPath("$.tertiaryBox10d")
//            .value(is(DEFAULT_TERTIARY_BOX_10_D))
//            .jsonPath("$.tertiaryBox19")
//            .value(is(DEFAULT_TERTIARY_BOX_19))
//            .jsonPath("$.tertiaryBox24ia")
//            .value(is(DEFAULT_TERTIARY_BOX_24_IA))
//            .jsonPath("$.tertiaryBox24ja")
//            .value(is(DEFAULT_TERTIARY_BOX_24_JA))
//            .jsonPath("$.tertiaryBox24jb")
//            .value(is(DEFAULT_TERTIARY_BOX_24_JB))
//            .jsonPath("$.tertiaryIncludeBox24jbStatus")
//            .value(is(DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS))
//            .jsonPath("$.tertiaryIncludePayerInSalesOrderStatus")
//            .value(is(DEFAULT_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS))
//            .jsonPath("$.tertiaryWaitPreviousPayerBeforeBillingStatus")
//            .value(is(DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS))
//            .jsonPath("$.tertiaryPayPercentage0Status")
//            .value(is(DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS))
//            .jsonPath("$.insuranceVerificationStatus")
//            .value(is(DEFAULT_INSURANCE_VERIFICATION_STATUS))
//            .jsonPath("$.coverageVerificationStatus")
//            .value(is(DEFAULT_COVERAGE_VERIFICATION_STATUS))
//            .jsonPath("$.excludeFromEligibilityCheckStatus")
//            .value(is(DEFAULT_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS))
//            .jsonPath("$.patientPayPercentage")
//            .value(is(DEFAULT_PATIENT_PAY_PERCENTAGE))
//            .jsonPath("$.patientIncludeThisPayorInSalesOrderStatus")
//            .value(is(DEFAULT_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS))
//            .jsonPath("$.patientWaitForPreviousPayerBeforeBillingStatus")
//            .value(is(DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS))
//            .jsonPath("$.workersCompDateOfOnset")
//            .value(is(DEFAULT_WORKERS_COMP_DATE_OF_ONSET.toString()))
//            .jsonPath("$.workersCompInjuryRelatedEmploymentStatus")
//            .value(is(DEFAULT_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS))
//            .jsonPath("$.workersCompInjuryRelatedAutoAccidentStatus")
//            .value(is(DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS))
//            .jsonPath("$.workersCompAutoAccidentStateId")
//            .value(is(DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID))
//            .jsonPath("$.workersCompInjuryRelatedToOtherAccidentStatus")
//            .value(is(DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS))
//            .jsonPath("$.eclaimsAttachmentStatus")
//            .value(is(DEFAULT_ECLAIMS_ATTACHMENT_STATUS))
//            .jsonPath("$.attachmentNumber")
//            .value(is(DEFAULT_ATTACHMENT_NUMBER))
//            .jsonPath("$.typeCode")
//            .value(is(DEFAULT_TYPE_CODE))
//            .jsonPath("$.transactionCode")
//            .value(is(DEFAULT_TRANSACTION_CODE))
//            .jsonPath("$.claimsNoteType")
//            .value(is(DEFAULT_CLAIMS_NOTE_TYPE))
//            .jsonPath("$.claimsNote")
//            .value(is(DEFAULT_CLAIMS_NOTE))
//            .jsonPath("$.salesOrderNo")
//            .value(is(DEFAULT_SALES_ORDER_NO))
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
//    void getNonExistingSalesOrderInsuranceDetails() {
//        // Get the salesOrderInsuranceDetails
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
//    void putNewSalesOrderInsuranceDetails() throws Exception {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderInsuranceDetails
//        SalesOrderInsuranceDetails updatedSalesOrderInsuranceDetails = salesOrderInsuranceDetailsRepository
//            .findById(salesOrderInsuranceDetails.getId())
//            .block();
//        updatedSalesOrderInsuranceDetails
//            .salesOrderInsuranceDetailsId(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .primaryInsurerId(UPDATED_PRIMARY_INSURER_ID)
//            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
//            .primaryInsuranceGroupId(UPDATED_PRIMARY_INSURANCE_GROUP_ID)
//            .primaryInsuranceGroupName(UPDATED_PRIMARY_INSURANCE_GROUP_NAME)
//            .primaryInsurancePlanId(UPDATED_PRIMARY_INSURANCE_PLAN_ID)
//            .primaryInsurancePlanType(UPDATED_PRIMARY_INSURANCE_PLAN_TYPE)
//            .primaryInsuranceStateId(UPDATED_PRIMARY_INSURANCE_STATE_ID)
//            .primaryInsuranceStateName(UPDATED_PRIMARY_INSURANCE_STATE_NAME)
//            .primaryInsurerPolicyNo(UPDATED_PRIMARY_INSURER_POLICY_NO)
//            .primaryInsurerPatientIdNumber(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER)
//            .primaryInsurerEffectiveDate(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE)
//            .primaryInsurerVerificationStatus(UPDATED_PRIMARY_INSURER_VERIFICATION_STATUS)
//            .primaryInsurerVerificationDate(UPDATED_PRIMARY_INSURER_VERIFICATION_DATE)
//            .primaryInsurerPayPercentage(UPDATED_PRIMARY_INSURER_PAY_PERCENTAGE)
//            .primaryBox10d(UPDATED_PRIMARY_BOX_10_D)
//            .primaryBox19(UPDATED_PRIMARY_BOX_19)
//            .primaryBox24ia(UPDATED_PRIMARY_BOX_24_IA)
//            .primaryBox24ja(UPDATED_PRIMARY_BOX_24_JA)
//            .primaryBox24jb(UPDATED_PRIMARY_BOX_24_JB)
//            .primaryIncludeBox24Jbstatus(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS)
//            .primaryIncludePayerSalesOrderStatus(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .primaryWaitForPreviousPayerBeforeBillingStatus(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .primaryPayPercentageStatus(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS)
//            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
//            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
//            .secondaryInsuranceGroupId(UPDATED_SECONDARY_INSURANCE_GROUP_ID)
//            .secondaryInsuranceGroupName(UPDATED_SECONDARY_INSURANCE_GROUP_NAME)
//            .secondaryInsurancePlanId(UPDATED_SECONDARY_INSURANCE_PLAN_ID)
//            .secondaryInsurancePlanType(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE)
//            .secondaryInsuranceStateId(UPDATED_SECONDARY_INSURANCE_STATE_ID)
//            .secondaryInsuranceStateName(UPDATED_SECONDARY_INSURANCE_STATE_NAME)
//            .secondaryInsurerPolicyNo(UPDATED_SECONDARY_INSURER_POLICY_NO)
//            .secondaryInsurerPatientIdNumber(UPDATED_SECONDARY_INSURER_PATIENT_ID_NUMBER)
//            .secondaryInsurerEffectiveDate(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE)
//            .secondaryInsurerVerificationStatus(UPDATED_SECONDARY_INSURER_VERIFICATION_STATUS)
//            .secondaryInsurerVerificationDate(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE)
//            .secondaryInsurerPayPercentage(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE)
//            .secondaryBox10d(UPDATED_SECONDARY_BOX_10_D)
//            .secondaryBox19(UPDATED_SECONDARY_BOX_19)
//            .secondaryBox24ia(UPDATED_SECONDARY_BOX_24_IA)
//            .secondaryBox24ja(UPDATED_SECONDARY_BOX_24_JA)
//            .secondaryBox24jb(UPDATED_SECONDARY_BOX_24_JB)
//            .secondaryIncludeBox24jbStatus(UPDATED_SECONDARY_INCLUDE_BOX_24_JB_STATUS)
//            .secondaryIncludePayerSalesOrderStatus(UPDATED_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .secondaryWaitPreviousPayerBefrBillingStatus(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS)
//            .secondaryPayPercentageStatus(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS)
//            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
//            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
//            .tertiaryInsuranceGroupId(UPDATED_TERTIARY_INSURANCE_GROUP_ID)
//            .tertiaryInsuranceGroupName(UPDATED_TERTIARY_INSURANCE_GROUP_NAME)
//            .tertiaryInsurancePlanId(UPDATED_TERTIARY_INSURANCE_PLAN_ID)
//            .tertiaryInsurancePlanType(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE)
//            .tertiaryInsuranceStateId(UPDATED_TERTIARY_INSURANCE_STATE_ID)
//            .tertiaryInsuranceStateName(UPDATED_TERTIARY_INSURANCE_STATE_NAME)
//            .tertiaryInsurerPolicyno(UPDATED_TERTIARY_INSURER_POLICYNO)
//            .tertiaryInsurerPatientIdNumber(UPDATED_TERTIARY_INSURER_PATIENT_ID_NUMBER)
//            .tertiaryInsurerEffectiveDate(UPDATED_TERTIARY_INSURER_EFFECTIVE_DATE)
//            .tertiaryInsurerVerificationStatus(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS)
//            .tertiaryInsurerVerificationDate(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE)
//            .tertiaryInsurerPayPercentage(UPDATED_TERTIARY_INSURER_PAY_PERCENTAGE)
//            .tertiaryBox10d(UPDATED_TERTIARY_BOX_10_D)
//            .tertiaryBox19(UPDATED_TERTIARY_BOX_19)
//            .tertiaryBox24ia(UPDATED_TERTIARY_BOX_24_IA)
//            .tertiaryBox24ja(UPDATED_TERTIARY_BOX_24_JA)
//            .tertiaryBox24jb(UPDATED_TERTIARY_BOX_24_JB)
//            .tertiaryIncludeBox24jbStatus(UPDATED_TERTIARY_INCLUDE_BOX_24_JB_STATUS)
//            .tertiaryIncludePayerInSalesOrderStatus(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS)
//            .tertiaryWaitPreviousPayerBeforeBillingStatus(UPDATED_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .tertiaryPayPercentage0Status(UPDATED_TERTIARY_PAY_PERCENTAGE_0_STATUS)
//            .insuranceVerificationStatus(UPDATED_INSURANCE_VERIFICATION_STATUS)
//            .coverageVerificationStatus(UPDATED_COVERAGE_VERIFICATION_STATUS)
//            .excludeFromEligibilityCheckStatus(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS)
//            .patientPayPercentage(UPDATED_PATIENT_PAY_PERCENTAGE)
//            .patientIncludeThisPayorInSalesOrderStatus(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS)
//            .patientWaitForPreviousPayerBeforeBillingStatus(UPDATED_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .workersCompDateOfOnset(UPDATED_WORKERS_COMP_DATE_OF_ONSET)
//            .workersCompInjuryRelatedEmploymentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS)
//            .workersCompInjuryRelatedAutoAccidentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS)
//            .workersCompAutoAccidentStateId(UPDATED_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID)
//            .workersCompInjuryRelatedToOtherAccidentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS)
//            .eclaimsAttachmentStatus(UPDATED_ECLAIMS_ATTACHMENT_STATUS)
//            .attachmentNumber(UPDATED_ATTACHMENT_NUMBER)
//            .typeCode(UPDATED_TYPE_CODE)
//            .transactionCode(UPDATED_TRANSACTION_CODE)
//            .claimsNoteType(UPDATED_CLAIMS_NOTE_TYPE)
//            .claimsNote(UPDATED_CLAIMS_NOTE)
//            .salesOrderNo(UPDATED_SALES_ORDER_NO)
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
//            .uri(ENTITY_API_URL_ID, updatedSalesOrderInsuranceDetails.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedSalesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderInsuranceDetails testSalesOrderInsuranceDetails = salesOrderInsuranceDetailsList.get(
//            salesOrderInsuranceDetailsList.size() - 1
//        );
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId()).isEqualTo(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerId()).isEqualTo(UPDATED_PRIMARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerName()).isEqualTo(UPDATED_PRIMARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupName()).isEqualTo(UPDATED_PRIMARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanType()).isEqualTo(UPDATED_PRIMARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateName()).isEqualTo(UPDATED_PRIMARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPolicyNo()).isEqualTo(UPDATED_PRIMARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber()).isEqualTo(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate()).isEqualTo(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_PRIMARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationDate()).isEqualTo(UPDATED_PRIMARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPayPercentage()).isEqualTo(UPDATED_PRIMARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox10d()).isEqualTo(UPDATED_PRIMARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox19()).isEqualTo(UPDATED_PRIMARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ia()).isEqualTo(UPDATED_PRIMARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ja()).isEqualTo(UPDATED_PRIMARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24jb()).isEqualTo(UPDATED_PRIMARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus()).isEqualTo(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus())
//            .isEqualTo(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryPayPercentageStatus()).isEqualTo(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerId()).isEqualTo(UPDATED_SECONDARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerName()).isEqualTo(UPDATED_SECONDARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupName()).isEqualTo(UPDATED_SECONDARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanType()).isEqualTo(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateName()).isEqualTo(UPDATED_SECONDARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPolicyNo()).isEqualTo(UPDATED_SECONDARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate()).isEqualTo(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationDate())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPayPercentage()).isEqualTo(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox10d()).isEqualTo(UPDATED_SECONDARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox19()).isEqualTo(UPDATED_SECONDARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ia()).isEqualTo(UPDATED_SECONDARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ja()).isEqualTo(UPDATED_SECONDARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24jb()).isEqualTo(UPDATED_SECONDARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus()).isEqualTo(UPDATED_SECONDARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus())
//            .isEqualTo(UPDATED_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus())
//            .isEqualTo(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryPayPercentageStatus()).isEqualTo(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerId()).isEqualTo(UPDATED_TERTIARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerName()).isEqualTo(UPDATED_TERTIARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupName()).isEqualTo(UPDATED_TERTIARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanType()).isEqualTo(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateName()).isEqualTo(UPDATED_TERTIARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPolicyno()).isEqualTo(UPDATED_TERTIARY_INSURER_POLICYNO);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate()).isEqualTo(UPDATED_TERTIARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationDate())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPayPercentage()).isEqualTo(UPDATED_TERTIARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox10d()).isEqualTo(UPDATED_TERTIARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox19()).isEqualTo(UPDATED_TERTIARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ia()).isEqualTo(UPDATED_TERTIARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ja()).isEqualTo(UPDATED_TERTIARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24jb()).isEqualTo(UPDATED_TERTIARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus()).isEqualTo(UPDATED_TERTIARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus())
//            .isEqualTo(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryPayPercentage0Status()).isEqualTo(UPDATED_TERTIARY_PAY_PERCENTAGE_0_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getInsuranceVerificationStatus()).isEqualTo(UPDATED_INSURANCE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCoverageVerificationStatus()).isEqualTo(UPDATED_COVERAGE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus())
//            .isEqualTo(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientPayPercentage()).isEqualTo(UPDATED_PATIENT_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus())
//            .isEqualTo(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompDateOfOnset()).isEqualTo(UPDATED_WORKERS_COMP_DATE_OF_ONSET);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId())
//            .isEqualTo(UPDATED_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getEclaimsAttachmentStatus()).isEqualTo(UPDATED_ECLAIMS_ATTACHMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getAttachmentNumber()).isEqualTo(UPDATED_ATTACHMENT_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTypeCode()).isEqualTo(UPDATED_TYPE_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getTransactionCode()).isEqualTo(UPDATED_TRANSACTION_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNoteType()).isEqualTo(UPDATED_CLAIMS_NOTE_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNote()).isEqualTo(UPDATED_CLAIMS_NOTE);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderNo()).isEqualTo(UPDATED_SALES_ORDER_NO);
//        assertThat(testSalesOrderInsuranceDetails.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void putNonExistingSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        salesOrderInsuranceDetails.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, salesOrderInsuranceDetails.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithIdMismatchSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        salesOrderInsuranceDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithMissingIdPathParamSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        salesOrderInsuranceDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void partialUpdateSalesOrderInsuranceDetailsWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderInsuranceDetails using partial update
//        SalesOrderInsuranceDetails partialUpdatedSalesOrderInsuranceDetails = new SalesOrderInsuranceDetails();
//        partialUpdatedSalesOrderInsuranceDetails.setId(salesOrderInsuranceDetails.getId());
//
//        partialUpdatedSalesOrderInsuranceDetails
//            .salesOrderInsuranceDetailsId(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .primaryInsuranceGroupId(UPDATED_PRIMARY_INSURANCE_GROUP_ID)
//            .primaryInsurancePlanId(UPDATED_PRIMARY_INSURANCE_PLAN_ID)
//            .primaryInsuranceStateId(UPDATED_PRIMARY_INSURANCE_STATE_ID)
//            .primaryInsurerPatientIdNumber(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER)
//            .primaryInsurerEffectiveDate(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE)
//            .primaryBox10d(UPDATED_PRIMARY_BOX_10_D)
//            .primaryBox19(UPDATED_PRIMARY_BOX_19)
//            .primaryBox24ia(UPDATED_PRIMARY_BOX_24_IA)
//            .primaryBox24ja(UPDATED_PRIMARY_BOX_24_JA)
//            .primaryIncludeBox24Jbstatus(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS)
//            .primaryIncludePayerSalesOrderStatus(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .primaryWaitForPreviousPayerBeforeBillingStatus(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .primaryPayPercentageStatus(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS)
//            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
//            .secondaryInsuranceGroupId(UPDATED_SECONDARY_INSURANCE_GROUP_ID)
//            .secondaryInsurancePlanId(UPDATED_SECONDARY_INSURANCE_PLAN_ID)
//            .secondaryInsurancePlanType(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE)
//            .secondaryInsuranceStateId(UPDATED_SECONDARY_INSURANCE_STATE_ID)
//            .secondaryInsuranceStateName(UPDATED_SECONDARY_INSURANCE_STATE_NAME)
//            .secondaryInsurerEffectiveDate(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE)
//            .secondaryInsurerVerificationDate(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE)
//            .secondaryInsurerPayPercentage(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE)
//            .secondaryBox10d(UPDATED_SECONDARY_BOX_10_D)
//            .secondaryBox24ia(UPDATED_SECONDARY_BOX_24_IA)
//            .secondaryWaitPreviousPayerBefrBillingStatus(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS)
//            .secondaryPayPercentageStatus(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS)
//            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
//            .tertiaryInsurancePlanId(UPDATED_TERTIARY_INSURANCE_PLAN_ID)
//            .tertiaryInsurancePlanType(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE)
//            .tertiaryInsuranceStateName(UPDATED_TERTIARY_INSURANCE_STATE_NAME)
//            .tertiaryInsurerPolicyno(UPDATED_TERTIARY_INSURER_POLICYNO)
//            .tertiaryInsurerVerificationStatus(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS)
//            .tertiaryInsurerVerificationDate(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE)
//            .tertiaryBox19(UPDATED_TERTIARY_BOX_19)
//            .tertiaryBox24ja(UPDATED_TERTIARY_BOX_24_JA)
//            .tertiaryIncludePayerInSalesOrderStatus(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS)
//            .insuranceVerificationStatus(UPDATED_INSURANCE_VERIFICATION_STATUS)
//            .excludeFromEligibilityCheckStatus(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS)
//            .patientPayPercentage(UPDATED_PATIENT_PAY_PERCENTAGE)
//            .patientIncludeThisPayorInSalesOrderStatus(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS)
//            .workersCompDateOfOnset(UPDATED_WORKERS_COMP_DATE_OF_ONSET)
//            .workersCompInjuryRelatedEmploymentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS)
//            .attachmentNumber(UPDATED_ATTACHMENT_NUMBER)
//            .claimsNoteType(UPDATED_CLAIMS_NOTE_TYPE)
//            .claimsNote(UPDATED_CLAIMS_NOTE)
//            .salesOrderNo(UPDATED_SALES_ORDER_NO)
//            .status(UPDATED_STATUS)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME);
//
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderInsuranceDetails.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderInsuranceDetails testSalesOrderInsuranceDetails = salesOrderInsuranceDetailsList.get(
//            salesOrderInsuranceDetailsList.size() - 1
//        );
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId()).isEqualTo(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerId()).isEqualTo(DEFAULT_PRIMARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerName()).isEqualTo(DEFAULT_PRIMARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupName()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanType()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateName()).isEqualTo(DEFAULT_PRIMARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPolicyNo()).isEqualTo(DEFAULT_PRIMARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber()).isEqualTo(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate()).isEqualTo(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_PRIMARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationDate()).isEqualTo(DEFAULT_PRIMARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPayPercentage()).isEqualTo(DEFAULT_PRIMARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox10d()).isEqualTo(UPDATED_PRIMARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox19()).isEqualTo(UPDATED_PRIMARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ia()).isEqualTo(UPDATED_PRIMARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ja()).isEqualTo(UPDATED_PRIMARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24jb()).isEqualTo(DEFAULT_PRIMARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus()).isEqualTo(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus())
//            .isEqualTo(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryPayPercentageStatus()).isEqualTo(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerId()).isEqualTo(UPDATED_SECONDARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerName()).isEqualTo(DEFAULT_SECONDARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupName()).isEqualTo(DEFAULT_SECONDARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanType()).isEqualTo(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateName()).isEqualTo(UPDATED_SECONDARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPolicyNo()).isEqualTo(DEFAULT_SECONDARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate()).isEqualTo(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus())
//            .isEqualTo(DEFAULT_SECONDARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationDate())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPayPercentage()).isEqualTo(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox10d()).isEqualTo(UPDATED_SECONDARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox19()).isEqualTo(DEFAULT_SECONDARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ia()).isEqualTo(UPDATED_SECONDARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ja()).isEqualTo(DEFAULT_SECONDARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24jb()).isEqualTo(DEFAULT_SECONDARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus()).isEqualTo(DEFAULT_SECONDARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus())
//            .isEqualTo(DEFAULT_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus())
//            .isEqualTo(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryPayPercentageStatus()).isEqualTo(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerId()).isEqualTo(UPDATED_TERTIARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerName()).isEqualTo(DEFAULT_TERTIARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupName()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanType()).isEqualTo(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateId()).isEqualTo(DEFAULT_TERTIARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateName()).isEqualTo(UPDATED_TERTIARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPolicyno()).isEqualTo(UPDATED_TERTIARY_INSURER_POLICYNO);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber())
//            .isEqualTo(DEFAULT_TERTIARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate()).isEqualTo(DEFAULT_TERTIARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationDate())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPayPercentage()).isEqualTo(DEFAULT_TERTIARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox10d()).isEqualTo(DEFAULT_TERTIARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox19()).isEqualTo(UPDATED_TERTIARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ia()).isEqualTo(DEFAULT_TERTIARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ja()).isEqualTo(UPDATED_TERTIARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24jb()).isEqualTo(DEFAULT_TERTIARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus()).isEqualTo(DEFAULT_TERTIARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus())
//            .isEqualTo(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryPayPercentage0Status()).isEqualTo(DEFAULT_TERTIARY_PAY_PERCENTAGE_0_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getInsuranceVerificationStatus()).isEqualTo(UPDATED_INSURANCE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCoverageVerificationStatus()).isEqualTo(DEFAULT_COVERAGE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus())
//            .isEqualTo(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientPayPercentage()).isEqualTo(UPDATED_PATIENT_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus())
//            .isEqualTo(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(DEFAULT_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompDateOfOnset()).isEqualTo(UPDATED_WORKERS_COMP_DATE_OF_ONSET);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId())
//            .isEqualTo(DEFAULT_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus())
//            .isEqualTo(DEFAULT_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getEclaimsAttachmentStatus()).isEqualTo(DEFAULT_ECLAIMS_ATTACHMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getAttachmentNumber()).isEqualTo(UPDATED_ATTACHMENT_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTypeCode()).isEqualTo(DEFAULT_TYPE_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getTransactionCode()).isEqualTo(DEFAULT_TRANSACTION_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNoteType()).isEqualTo(UPDATED_CLAIMS_NOTE_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNote()).isEqualTo(UPDATED_CLAIMS_NOTE);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderNo()).isEqualTo(UPDATED_SALES_ORDER_NO);
//        assertThat(testSalesOrderInsuranceDetails.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void fullUpdateSalesOrderInsuranceDetailsWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderInsuranceDetails using partial update
//        SalesOrderInsuranceDetails partialUpdatedSalesOrderInsuranceDetails = new SalesOrderInsuranceDetails();
//        partialUpdatedSalesOrderInsuranceDetails.setId(salesOrderInsuranceDetails.getId());
//
//        partialUpdatedSalesOrderInsuranceDetails
//            .salesOrderInsuranceDetailsId(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .primaryInsurerId(UPDATED_PRIMARY_INSURER_ID)
//            .primaryInsurerName(UPDATED_PRIMARY_INSURER_NAME)
//            .primaryInsuranceGroupId(UPDATED_PRIMARY_INSURANCE_GROUP_ID)
//            .primaryInsuranceGroupName(UPDATED_PRIMARY_INSURANCE_GROUP_NAME)
//            .primaryInsurancePlanId(UPDATED_PRIMARY_INSURANCE_PLAN_ID)
//            .primaryInsurancePlanType(UPDATED_PRIMARY_INSURANCE_PLAN_TYPE)
//            .primaryInsuranceStateId(UPDATED_PRIMARY_INSURANCE_STATE_ID)
//            .primaryInsuranceStateName(UPDATED_PRIMARY_INSURANCE_STATE_NAME)
//            .primaryInsurerPolicyNo(UPDATED_PRIMARY_INSURER_POLICY_NO)
//            .primaryInsurerPatientIdNumber(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER)
//            .primaryInsurerEffectiveDate(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE)
//            .primaryInsurerVerificationStatus(UPDATED_PRIMARY_INSURER_VERIFICATION_STATUS)
//            .primaryInsurerVerificationDate(UPDATED_PRIMARY_INSURER_VERIFICATION_DATE)
//            .primaryInsurerPayPercentage(UPDATED_PRIMARY_INSURER_PAY_PERCENTAGE)
//            .primaryBox10d(UPDATED_PRIMARY_BOX_10_D)
//            .primaryBox19(UPDATED_PRIMARY_BOX_19)
//            .primaryBox24ia(UPDATED_PRIMARY_BOX_24_IA)
//            .primaryBox24ja(UPDATED_PRIMARY_BOX_24_JA)
//            .primaryBox24jb(UPDATED_PRIMARY_BOX_24_JB)
//            .primaryIncludeBox24Jbstatus(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS)
//            .primaryIncludePayerSalesOrderStatus(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .primaryWaitForPreviousPayerBeforeBillingStatus(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .primaryPayPercentageStatus(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS)
//            .secondaryInsurerId(UPDATED_SECONDARY_INSURER_ID)
//            .secondaryInsurerName(UPDATED_SECONDARY_INSURER_NAME)
//            .secondaryInsuranceGroupId(UPDATED_SECONDARY_INSURANCE_GROUP_ID)
//            .secondaryInsuranceGroupName(UPDATED_SECONDARY_INSURANCE_GROUP_NAME)
//            .secondaryInsurancePlanId(UPDATED_SECONDARY_INSURANCE_PLAN_ID)
//            .secondaryInsurancePlanType(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE)
//            .secondaryInsuranceStateId(UPDATED_SECONDARY_INSURANCE_STATE_ID)
//            .secondaryInsuranceStateName(UPDATED_SECONDARY_INSURANCE_STATE_NAME)
//            .secondaryInsurerPolicyNo(UPDATED_SECONDARY_INSURER_POLICY_NO)
//            .secondaryInsurerPatientIdNumber(UPDATED_SECONDARY_INSURER_PATIENT_ID_NUMBER)
//            .secondaryInsurerEffectiveDate(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE)
//            .secondaryInsurerVerificationStatus(UPDATED_SECONDARY_INSURER_VERIFICATION_STATUS)
//            .secondaryInsurerVerificationDate(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE)
//            .secondaryInsurerPayPercentage(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE)
//            .secondaryBox10d(UPDATED_SECONDARY_BOX_10_D)
//            .secondaryBox19(UPDATED_SECONDARY_BOX_19)
//            .secondaryBox24ia(UPDATED_SECONDARY_BOX_24_IA)
//            .secondaryBox24ja(UPDATED_SECONDARY_BOX_24_JA)
//            .secondaryBox24jb(UPDATED_SECONDARY_BOX_24_JB)
//            .secondaryIncludeBox24jbStatus(UPDATED_SECONDARY_INCLUDE_BOX_24_JB_STATUS)
//            .secondaryIncludePayerSalesOrderStatus(UPDATED_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS)
//            .secondaryWaitPreviousPayerBefrBillingStatus(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS)
//            .secondaryPayPercentageStatus(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS)
//            .tertiaryInsurerId(UPDATED_TERTIARY_INSURER_ID)
//            .tertiaryInsurerName(UPDATED_TERTIARY_INSURER_NAME)
//            .tertiaryInsuranceGroupId(UPDATED_TERTIARY_INSURANCE_GROUP_ID)
//            .tertiaryInsuranceGroupName(UPDATED_TERTIARY_INSURANCE_GROUP_NAME)
//            .tertiaryInsurancePlanId(UPDATED_TERTIARY_INSURANCE_PLAN_ID)
//            .tertiaryInsurancePlanType(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE)
//            .tertiaryInsuranceStateId(UPDATED_TERTIARY_INSURANCE_STATE_ID)
//            .tertiaryInsuranceStateName(UPDATED_TERTIARY_INSURANCE_STATE_NAME)
//            .tertiaryInsurerPolicyno(UPDATED_TERTIARY_INSURER_POLICYNO)
//            .tertiaryInsurerPatientIdNumber(UPDATED_TERTIARY_INSURER_PATIENT_ID_NUMBER)
//            .tertiaryInsurerEffectiveDate(UPDATED_TERTIARY_INSURER_EFFECTIVE_DATE)
//            .tertiaryInsurerVerificationStatus(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS)
//            .tertiaryInsurerVerificationDate(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE)
//            .tertiaryInsurerPayPercentage(UPDATED_TERTIARY_INSURER_PAY_PERCENTAGE)
//            .tertiaryBox10d(UPDATED_TERTIARY_BOX_10_D)
//            .tertiaryBox19(UPDATED_TERTIARY_BOX_19)
//            .tertiaryBox24ia(UPDATED_TERTIARY_BOX_24_IA)
//            .tertiaryBox24ja(UPDATED_TERTIARY_BOX_24_JA)
//            .tertiaryBox24jb(UPDATED_TERTIARY_BOX_24_JB)
//            .tertiaryIncludeBox24jbStatus(UPDATED_TERTIARY_INCLUDE_BOX_24_JB_STATUS)
//            .tertiaryIncludePayerInSalesOrderStatus(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS)
//            .tertiaryWaitPreviousPayerBeforeBillingStatus(UPDATED_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .tertiaryPayPercentage0Status(UPDATED_TERTIARY_PAY_PERCENTAGE_0_STATUS)
//            .insuranceVerificationStatus(UPDATED_INSURANCE_VERIFICATION_STATUS)
//            .coverageVerificationStatus(UPDATED_COVERAGE_VERIFICATION_STATUS)
//            .excludeFromEligibilityCheckStatus(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS)
//            .patientPayPercentage(UPDATED_PATIENT_PAY_PERCENTAGE)
//            .patientIncludeThisPayorInSalesOrderStatus(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS)
//            .patientWaitForPreviousPayerBeforeBillingStatus(UPDATED_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS)
//            .workersCompDateOfOnset(UPDATED_WORKERS_COMP_DATE_OF_ONSET)
//            .workersCompInjuryRelatedEmploymentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS)
//            .workersCompInjuryRelatedAutoAccidentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS)
//            .workersCompAutoAccidentStateId(UPDATED_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID)
//            .workersCompInjuryRelatedToOtherAccidentStatus(UPDATED_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS)
//            .eclaimsAttachmentStatus(UPDATED_ECLAIMS_ATTACHMENT_STATUS)
//            .attachmentNumber(UPDATED_ATTACHMENT_NUMBER)
//            .typeCode(UPDATED_TYPE_CODE)
//            .transactionCode(UPDATED_TRANSACTION_CODE)
//            .claimsNoteType(UPDATED_CLAIMS_NOTE_TYPE)
//            .claimsNote(UPDATED_CLAIMS_NOTE)
//            .salesOrderNo(UPDATED_SALES_ORDER_NO)
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
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderInsuranceDetails.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderInsuranceDetails testSalesOrderInsuranceDetails = salesOrderInsuranceDetailsList.get(
//            salesOrderInsuranceDetailsList.size() - 1
//        );
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId()).isEqualTo(UPDATED_SALES_ORDER_INSURANCE_DETAILS_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerId()).isEqualTo(UPDATED_PRIMARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerName()).isEqualTo(UPDATED_PRIMARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceGroupName()).isEqualTo(UPDATED_PRIMARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurancePlanType()).isEqualTo(UPDATED_PRIMARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateId()).isEqualTo(UPDATED_PRIMARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsuranceStateName()).isEqualTo(UPDATED_PRIMARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPolicyNo()).isEqualTo(UPDATED_PRIMARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber()).isEqualTo(UPDATED_PRIMARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate()).isEqualTo(UPDATED_PRIMARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_PRIMARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerVerificationDate()).isEqualTo(UPDATED_PRIMARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryInsurerPayPercentage()).isEqualTo(UPDATED_PRIMARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox10d()).isEqualTo(UPDATED_PRIMARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox19()).isEqualTo(UPDATED_PRIMARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ia()).isEqualTo(UPDATED_PRIMARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24ja()).isEqualTo(UPDATED_PRIMARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryBox24jb()).isEqualTo(UPDATED_PRIMARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus()).isEqualTo(UPDATED_PRIMARY_INCLUDE_BOX_24_JBSTATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus())
//            .isEqualTo(UPDATED_PRIMARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_PRIMARY_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPrimaryPayPercentageStatus()).isEqualTo(UPDATED_PRIMARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerId()).isEqualTo(UPDATED_SECONDARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerName()).isEqualTo(UPDATED_SECONDARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceGroupName()).isEqualTo(UPDATED_SECONDARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurancePlanType()).isEqualTo(UPDATED_SECONDARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateId()).isEqualTo(UPDATED_SECONDARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsuranceStateName()).isEqualTo(UPDATED_SECONDARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPolicyNo()).isEqualTo(UPDATED_SECONDARY_INSURER_POLICY_NO);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate()).isEqualTo(UPDATED_SECONDARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerVerificationDate())
//            .isEqualTo(UPDATED_SECONDARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryInsurerPayPercentage()).isEqualTo(UPDATED_SECONDARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox10d()).isEqualTo(UPDATED_SECONDARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox19()).isEqualTo(UPDATED_SECONDARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ia()).isEqualTo(UPDATED_SECONDARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24ja()).isEqualTo(UPDATED_SECONDARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryBox24jb()).isEqualTo(UPDATED_SECONDARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus()).isEqualTo(UPDATED_SECONDARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus())
//            .isEqualTo(UPDATED_SECONDARY_INCLUDE_PAYER_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus())
//            .isEqualTo(UPDATED_SECONDARY_WAIT_PREVIOUS_PAYER_BEFR_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getSecondaryPayPercentageStatus()).isEqualTo(UPDATED_SECONDARY_PAY_PERCENTAGE_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerId()).isEqualTo(UPDATED_TERTIARY_INSURER_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerName()).isEqualTo(UPDATED_TERTIARY_INSURER_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_GROUP_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceGroupName()).isEqualTo(UPDATED_TERTIARY_INSURANCE_GROUP_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_PLAN_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurancePlanType()).isEqualTo(UPDATED_TERTIARY_INSURANCE_PLAN_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateId()).isEqualTo(UPDATED_TERTIARY_INSURANCE_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsuranceStateName()).isEqualTo(UPDATED_TERTIARY_INSURANCE_STATE_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPolicyno()).isEqualTo(UPDATED_TERTIARY_INSURER_POLICYNO);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_PATIENT_ID_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate()).isEqualTo(UPDATED_TERTIARY_INSURER_EFFECTIVE_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerVerificationDate())
//            .isEqualTo(UPDATED_TERTIARY_INSURER_VERIFICATION_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryInsurerPayPercentage()).isEqualTo(UPDATED_TERTIARY_INSURER_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox10d()).isEqualTo(UPDATED_TERTIARY_BOX_10_D);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox19()).isEqualTo(UPDATED_TERTIARY_BOX_19);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ia()).isEqualTo(UPDATED_TERTIARY_BOX_24_IA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24ja()).isEqualTo(UPDATED_TERTIARY_BOX_24_JA);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryBox24jb()).isEqualTo(UPDATED_TERTIARY_BOX_24_JB);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus()).isEqualTo(UPDATED_TERTIARY_INCLUDE_BOX_24_JB_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus())
//            .isEqualTo(UPDATED_TERTIARY_INCLUDE_PAYER_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_TERTIARY_WAIT_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getTertiaryPayPercentage0Status()).isEqualTo(UPDATED_TERTIARY_PAY_PERCENTAGE_0_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getInsuranceVerificationStatus()).isEqualTo(UPDATED_INSURANCE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCoverageVerificationStatus()).isEqualTo(UPDATED_COVERAGE_VERIFICATION_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus())
//            .isEqualTo(UPDATED_EXCLUDE_FROM_ELIGIBILITY_CHECK_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientPayPercentage()).isEqualTo(UPDATED_PATIENT_PAY_PERCENTAGE);
//        assertThat(testSalesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus())
//            .isEqualTo(UPDATED_PATIENT_INCLUDE_THIS_PAYOR_IN_SALES_ORDER_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus())
//            .isEqualTo(UPDATED_PATIENT_WAIT_FOR_PREVIOUS_PAYER_BEFORE_BILLING_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompDateOfOnset()).isEqualTo(UPDATED_WORKERS_COMP_DATE_OF_ONSET);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_EMPLOYMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_AUTO_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId())
//            .isEqualTo(UPDATED_WORKERS_COMP_AUTO_ACCIDENT_STATE_ID);
//        assertThat(testSalesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus())
//            .isEqualTo(UPDATED_WORKERS_COMP_INJURY_RELATED_TO_OTHER_ACCIDENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getEclaimsAttachmentStatus()).isEqualTo(UPDATED_ECLAIMS_ATTACHMENT_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getAttachmentNumber()).isEqualTo(UPDATED_ATTACHMENT_NUMBER);
//        assertThat(testSalesOrderInsuranceDetails.getTypeCode()).isEqualTo(UPDATED_TYPE_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getTransactionCode()).isEqualTo(UPDATED_TRANSACTION_CODE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNoteType()).isEqualTo(UPDATED_CLAIMS_NOTE_TYPE);
//        assertThat(testSalesOrderInsuranceDetails.getClaimsNote()).isEqualTo(UPDATED_CLAIMS_NOTE);
//        assertThat(testSalesOrderInsuranceDetails.getSalesOrderNo()).isEqualTo(UPDATED_SALES_ORDER_NO);
//        assertThat(testSalesOrderInsuranceDetails.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderInsuranceDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void patchNonExistingSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        salesOrderInsuranceDetails.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, salesOrderInsuranceDetails.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithIdMismatchSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        salesOrderInsuranceDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithMissingIdPathParamSalesOrderInsuranceDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//        salesOrderInsuranceDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderInsuranceDetails))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderInsuranceDetails in the database
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void deleteSalesOrderInsuranceDetails() {
//        // Initialize the database
//        salesOrderInsuranceDetailsRepository.save(salesOrderInsuranceDetails).block();
//
//        int databaseSizeBeforeDelete = salesOrderInsuranceDetailsRepository.findAll().collectList().block().size();
//
//        // Delete the salesOrderInsuranceDetails
//        webTestClient
//            .delete()
//            .uri(ENTITY_API_URL_ID, salesOrderInsuranceDetails.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isNoContent();
//
//        // Validate the database contains one less item
//        List<SalesOrderInsuranceDetails> salesOrderInsuranceDetailsList = salesOrderInsuranceDetailsRepository
//            .findAll()
//            .collectList()
//            .block();
//        assertThat(salesOrderInsuranceDetailsList).hasSize(databaseSizeBeforeDelete - 1);
//    }
}
