package com.sunknowledge.dme.rcm.web.rest;

import static com.sunknowledge.dme.rcm.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.SalesOrderMasterRepository;
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
 * Integration tests for the {@link SalesOrderMasterResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class SalesOrderMasterResourceIT {

//    private static final Integer DEFAULT_SALES_ODER_ID = 1;
//    private static final Integer UPDATED_SALES_ODER_ID = 2;
//
//    private static final String DEFAULT_SALES_ODER_NO = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ODER_NO = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_PATIENT_ID = 1;
//    private static final Integer UPDATED_PATIENT_ID = 2;
//
//    private static final String DEFAULT_PATIENT_FIRST_NAME = "Bkbbsus4";
//    private static final String UPDATED_PATIENT_FIRST_NAME = "Kcuqaqc9";
//
//    private static final String DEFAULT_PATIENT_MIDDLE_NAME = "Zvhg6";
//    private static final String UPDATED_PATIENT_MIDDLE_NAME = "Lgguzj2";
//
//    private static final String DEFAULT_PATIENT_LAST_NAME = "Rqqd1";
//    private static final String UPDATED_PATIENT_LAST_NAME = "Ti9";
//
//    private static final Integer DEFAULT_PATIENT_ADDRESS_ID = 1;
//    private static final Integer UPDATED_PATIENT_ADDRESS_ID = 2;
//
//    private static final String DEFAULT_PATIENT_ADDRESS_LINE_1 = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_ADDRESS_LINE_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PATIENT_ADDRESS_LINE_2 = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_ADDRESS_LINE_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_CITY_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_CITY_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_STATE_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_STATE_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_ZIP_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_ZIP_CODE = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_PATIENT_CONTACT_ID = 1;
//    private static final Integer UPDATED_PATIENT_CONTACT_ID = 2;
//
//    private static final String DEFAULT_PHONE_1 = "AAAAAAAAAA";
//    private static final String UPDATED_PHONE_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PHONE_2 = "AAAAAAAAAA";
//    private static final String UPDATED_PHONE_2 = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_PATIENT_DOB = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_PATIENT_DOB = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Double DEFAULT_PATIENT_HEIGHT = 1D;
//    private static final Double UPDATED_PATIENT_HEIGHT = 2D;
//
//    private static final Double DEFAULT_PATIENT_WEIGHT = 1D;
//    private static final Double UPDATED_PATIENT_WEIGHT = 2D;
//
//    private static final String DEFAULT_PATIENT_SSN = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_SSN = "BBBBBBBBBB";
//
//    private static final String DEFAULT_PATIENT_GENDER = "AAAAAAAAAA";
//    private static final String UPDATED_PATIENT_GENDER = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_PATIENT_BRANCH_ID = 1;
//    private static final Integer UPDATED_PATIENT_BRANCH_ID = 2;
//
//    private static final String DEFAULT_BRANCH_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_BRANCH_NAME = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_PATIENT_DOD = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_PATIENT_DOD = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_HIPAA_ON_FILE_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_HIPAA_ON_FILE_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_FACILITY_ID = 1;
//    private static final Integer UPDATED_FACILITY_ID = 2;
//
//    private static final String DEFAULT_FACILITY_NAME = "Axb4";
//    private static final String UPDATED_FACILITY_NAME = "Prmxfp9";
//
//    private static final String DEFAULT_FACILITY_NPI = "AAAAAAAAAA";
//    private static final String UPDATED_FACILITY_NPI = "BBBBBBBBBB";
//
//    private static final ZonedDateTime DEFAULT_DELIVERY_SCHEDULE_DATETIME = ZonedDateTime.ofInstant(
//        Instant.ofEpochMilli(0L),
//        ZoneOffset.UTC
//    );
//    private static final ZonedDateTime UPDATED_DELIVERY_SCHEDULE_DATETIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
//
//    private static final ZonedDateTime DEFAULT_DELIVERY_ACTUAL_DATETIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
//    private static final ZonedDateTime UPDATED_DELIVERY_ACTUAL_DATETIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
//
//    private static final String DEFAULT_DELIVERY_ADDRESS_LINE_1 = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_ADDRESS_LINE_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_ADDRESS_LINE_2 = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_ADDRESS_LINE_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_CITY_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_CITY_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_STATE_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_STATE_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_ZIP_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_ZIP_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_PHONE_NO_1 = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_PHONE_NO_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_PHONE_NO_2 = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_PHONE_NO_2 = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_DELIVERY_BRANCH_ID = 1;
//    private static final Integer UPDATED_DELIVERY_BRANCH_ID = 2;
//
//    private static final String DEFAULT_DELIVERY_BRANCH_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_BRANCH_NAME = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_TAX_ZONE_ID = 1;
//    private static final Integer UPDATED_TAX_ZONE_ID = 2;
//
//    private static final Double DEFAULT_TAX_RATE = 1D;
//    private static final Double UPDATED_TAX_RATE = 2D;
//
//    private static final String DEFAULT_SALES_ORDER_NOTE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_NOTE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_NOTE = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_NOTE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_DELIVERY_TECHNICIAN = "AAAAAAAAAA";
//    private static final String UPDATED_DELIVERY_TECHNICIAN = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SIGNATURE_REQUIRED_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_SIGNATURE_REQUIRED_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_POD_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_POD_STATUS = "BBBBBBBBBB";
//
//    private static final ZonedDateTime DEFAULT_POD_STATUS_DATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
//    private static final ZonedDateTime UPDATED_POD_STATUS_DATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
//
//    private static final String DEFAULT_POD_LAST_MESSAGE = "AAAAAAAAAA";
//    private static final String UPDATED_POD_LAST_MESSAGE = "BBBBBBBBBB";
//
//    private static final ZonedDateTime DEFAULT_POD_MESSAGE_DATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
//    private static final ZonedDateTime UPDATED_POD_MESSAGE_DATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
//
//    private static final String DEFAULT_MUTUAL_HOLD_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_MUTUAL_HOLD_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_HOLD_REASON_ID = 1;
//    private static final Integer UPDATED_HOLD_REASON_ID = 2;
//
//    private static final String DEFAULT_HOLD_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_HOLD_STATUS = "BBBBBBBBBB";
//
//    private static final String DEFAULT_HOLD_REASON_DESCRIPTION = "AAAAAAAAAA";
//    private static final String UPDATED_HOLD_REASON_DESCRIPTION = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_STOP_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_STOP_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Integer DEFAULT_STOP_REASON_ID = 1;
//    private static final Integer UPDATED_STOP_REASON_ID = 2;
//
//    private static final String DEFAULT_STOP_REASON_DESCRIPTION = "AAAAAAAAAA";
//    private static final String UPDATED_STOP_REASON_DESCRIPTION = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_INVENTORY_LOCATION_ID = 1;
//    private static final Integer UPDATED_INVENTORY_LOCATION_ID = 2;
//
//    private static final String DEFAULT_ORDER_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_ORDER_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_ORDER_CLASSIFICATION_ID = 1;
//    private static final Integer UPDATED_ORDER_CLASSIFICATION_ID = 2;
//
//    private static final Integer DEFAULT_POS_ID = 1;
//    private static final Integer UPDATED_POS_ID = 2;
//
//    private static final String DEFAULT_POS_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_POS_NAME = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_ADMISSION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_ADMISSION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_DISCHARGE_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_DISCHARGE_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 1;
//    private static final Integer UPDATED_DISCOUNT_PERCENTAGE = 2;
//
//    private static final String DEFAULT_PO_NUMBER = "AAAAAAAAAA";
//    private static final String UPDATED_PO_NUMBER = "BBBBBBBBBB";
//
//    private static final String DEFAULT_USER_FIELD_1 = "AAAAAAAAAA";
//    private static final String UPDATED_USER_FIELD_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_USER_FIELD_2 = "AAAAAAAAAA";
//    private static final String UPDATED_USER_FIELD_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_USER_FIELD_3 = "AAAAAAAAAA";
//    private static final String UPDATED_USER_FIELD_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_USER_FIELD_4 = "AAAAAAAAAA";
//    private static final String UPDATED_USER_FIELD_4 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_REFERENCE = "AAAAAAAAAA";
//    private static final String UPDATED_REFERENCE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_WIP_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_WIP_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_WIP_DAYS_IN_STATE = 1;
//    private static final Integer UPDATED_WIP_DAYS_IN_STATE = 2;
//
//    private static final Integer DEFAULT_WIP_ASSIGNED_TO_ID = 1;
//    private static final Integer UPDATED_WIP_ASSIGNED_TO_ID = 2;
//
//    private static final LocalDate DEFAULT_WIP_DATE_NEEDED = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_WIP_DATE_NEEDED = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_COMPLETED_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_COMPLETED_STATUS = "BBBBBBBBBB";
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
//    private static final Integer DEFAULT_CONFIRMATION_BY_ID = 1;
//    private static final Integer UPDATED_CONFIRMATION_BY_ID = 2;
//
//    private static final String DEFAULT_CONFIRMATION_BY_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_CONFIRMATION_BY_NAME = "BBBBBBBBBB";
//
//    private static final ZonedDateTime DEFAULT_CONFIRMATION_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
//    private static final ZonedDateTime UPDATED_CONFIRMATION_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
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
//    private static final String ENTITY_API_URL = "/api/sales-order-masters";
//    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
//
//    private static Random random = new Random();
//    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
//
//    @Autowired
//    private SalesOrderMasterRepository salesOrderMasterRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    private SalesOrderMaster salesOrderMaster;
//
//    /**
//     * Create an entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static SalesOrderMaster createEntity(EntityManager em) {
//        SalesOrderMaster salesOrderMaster = new SalesOrderMaster()
//            .salesOderId(DEFAULT_SALES_ODER_ID)
//            .salesOderNo(DEFAULT_SALES_ODER_NO)
//            .patientId(DEFAULT_PATIENT_ID)
//            .patientFirstName(DEFAULT_PATIENT_FIRST_NAME)
//            .patientMiddleName(DEFAULT_PATIENT_MIDDLE_NAME)
//            .patientLastName(DEFAULT_PATIENT_LAST_NAME)
//            .patientAddressId(DEFAULT_PATIENT_ADDRESS_ID)
//            .patientAddressLine1(DEFAULT_PATIENT_ADDRESS_LINE_1)
//            .patientAddressLine2(DEFAULT_PATIENT_ADDRESS_LINE_2)
//            .cityName(DEFAULT_CITY_NAME)
//            .stateName(DEFAULT_STATE_NAME)
//            .zipCode(DEFAULT_ZIP_CODE)
//            .patientContactId(DEFAULT_PATIENT_CONTACT_ID)
//            .phone1(DEFAULT_PHONE_1)
//            .phone2(DEFAULT_PHONE_2)
//            .patientDob(DEFAULT_PATIENT_DOB)
//            .patientHeight(DEFAULT_PATIENT_HEIGHT)
//            .patientWeight(DEFAULT_PATIENT_WEIGHT)
//            .patientSsn(DEFAULT_PATIENT_SSN)
//            .patientGender(DEFAULT_PATIENT_GENDER)
//            .patientBranchId(DEFAULT_PATIENT_BRANCH_ID)
//            .branchName(DEFAULT_BRANCH_NAME)
//            .patientDod(DEFAULT_PATIENT_DOD)
//            .hipaaOnFileStatus(DEFAULT_HIPAA_ON_FILE_STATUS)
//            .facilityId(DEFAULT_FACILITY_ID)
//            .facilityName(DEFAULT_FACILITY_NAME)
//            .facilityNPI(DEFAULT_FACILITY_NPI)
//            .deliveryScheduleDatetime(DEFAULT_DELIVERY_SCHEDULE_DATETIME)
//            .deliveryActualDatetime(DEFAULT_DELIVERY_ACTUAL_DATETIME)
//            .deliveryAddressLine1(DEFAULT_DELIVERY_ADDRESS_LINE_1)
//            .deliveryAddressLine2(DEFAULT_DELIVERY_ADDRESS_LINE_2)
//            .deliveryCityName(DEFAULT_DELIVERY_CITY_NAME)
//            .deliveryStateName(DEFAULT_DELIVERY_STATE_NAME)
//            .deliveryZipCode(DEFAULT_DELIVERY_ZIP_CODE)
//            .deliveryPhoneNo1(DEFAULT_DELIVERY_PHONE_NO_1)
//            .deliveryPhoneNo2(DEFAULT_DELIVERY_PHONE_NO_2)
//            .deliveryBranchId(DEFAULT_DELIVERY_BRANCH_ID)
//            .deliveryBranchName(DEFAULT_DELIVERY_BRANCH_NAME)
//            .taxZoneId(DEFAULT_TAX_ZONE_ID)
//            .taxRate(DEFAULT_TAX_RATE)
//            .salesOrderNote(DEFAULT_SALES_ORDER_NOTE)
//            .deliveryNote(DEFAULT_DELIVERY_NOTE)
//            .deliveryTechnician(DEFAULT_DELIVERY_TECHNICIAN)
//            .signatureRequiredStatus(DEFAULT_SIGNATURE_REQUIRED_STATUS)
//            .podStatus(DEFAULT_POD_STATUS)
//            .podStatusDateTime(DEFAULT_POD_STATUS_DATE_TIME)
//            .podLastMessage(DEFAULT_POD_LAST_MESSAGE)
//            .podMessageDateTime(DEFAULT_POD_MESSAGE_DATE_TIME)
//            .mutualHoldStatus(DEFAULT_MUTUAL_HOLD_STATUS)
//            .holdReasonId(DEFAULT_HOLD_REASON_ID)
//            .holdStatus(DEFAULT_HOLD_STATUS)
//            .holdReasonDescription(DEFAULT_HOLD_REASON_DESCRIPTION)
//            .stopDate(DEFAULT_STOP_DATE)
//            .stopReasonId(DEFAULT_STOP_REASON_ID)
//            .stopReasonDescription(DEFAULT_STOP_REASON_DESCRIPTION)
//            .inventoryLocationId(DEFAULT_INVENTORY_LOCATION_ID)
//            .orderStatus(DEFAULT_ORDER_STATUS)
//            .orderClassificationId(DEFAULT_ORDER_CLASSIFICATION_ID)
//            .posId(DEFAULT_POS_ID)
//            .posName(DEFAULT_POS_NAME)
//            .admissionDate(DEFAULT_ADMISSION_DATE)
//            .dischargeDate(DEFAULT_DISCHARGE_DATE)
//            .discountPercentage(DEFAULT_DISCOUNT_PERCENTAGE)
//            .poNumber(DEFAULT_PO_NUMBER)
//            .userField1(DEFAULT_USER_FIELD_1)
//            .userField2(DEFAULT_USER_FIELD_2)
//            .userField3(DEFAULT_USER_FIELD_3)
//            .userField4(DEFAULT_USER_FIELD_4)
//            .reference(DEFAULT_REFERENCE)
//            .wipStatus(DEFAULT_WIP_STATUS)
//            .wipDaysInState(DEFAULT_WIP_DAYS_IN_STATE)
//            .wipAssignedToId(DEFAULT_WIP_ASSIGNED_TO_ID)
//            .wipDateNeeded(DEFAULT_WIP_DATE_NEEDED)
//            .completedStatus(DEFAULT_COMPLETED_STATUS)
//            .status(DEFAULT_STATUS)
//            .createdById(DEFAULT_CREATED_BY_ID)
//            .createdByName(DEFAULT_CREATED_BY_NAME)
//            .createdDate(DEFAULT_CREATED_DATE)
//            .confirmationById(DEFAULT_CONFIRMATION_BY_ID)
//            .confirmationByName(DEFAULT_CONFIRMATION_BY_NAME)
//            .confirmationDate(DEFAULT_CONFIRMATION_DATE)
//            .updatedById(DEFAULT_UPDATED_BY_ID)
//            .updatedByName(DEFAULT_UPDATED_BY_NAME)
//            .updatedDate(DEFAULT_UPDATED_DATE);
//        return salesOrderMaster;
//    }
//
//    /**
//     * Create an updated entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static SalesOrderMaster createUpdatedEntity(EntityManager em) {
//        SalesOrderMaster salesOrderMaster = new SalesOrderMaster()
//            .salesOderId(UPDATED_SALES_ODER_ID)
//            .salesOderNo(UPDATED_SALES_ODER_NO)
//            .patientId(UPDATED_PATIENT_ID)
//            .patientFirstName(UPDATED_PATIENT_FIRST_NAME)
//            .patientMiddleName(UPDATED_PATIENT_MIDDLE_NAME)
//            .patientLastName(UPDATED_PATIENT_LAST_NAME)
//            .patientAddressId(UPDATED_PATIENT_ADDRESS_ID)
//            .patientAddressLine1(UPDATED_PATIENT_ADDRESS_LINE_1)
//            .patientAddressLine2(UPDATED_PATIENT_ADDRESS_LINE_2)
//            .cityName(UPDATED_CITY_NAME)
//            .stateName(UPDATED_STATE_NAME)
//            .zipCode(UPDATED_ZIP_CODE)
//            .patientContactId(UPDATED_PATIENT_CONTACT_ID)
//            .phone1(UPDATED_PHONE_1)
//            .phone2(UPDATED_PHONE_2)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientWeight(UPDATED_PATIENT_WEIGHT)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientBranchId(UPDATED_PATIENT_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .facilityId(UPDATED_FACILITY_ID)
//            .facilityName(UPDATED_FACILITY_NAME)
//            .facilityNPI(UPDATED_FACILITY_NPI)
//            .deliveryScheduleDatetime(UPDATED_DELIVERY_SCHEDULE_DATETIME)
//            .deliveryActualDatetime(UPDATED_DELIVERY_ACTUAL_DATETIME)
//            .deliveryAddressLine1(UPDATED_DELIVERY_ADDRESS_LINE_1)
//            .deliveryAddressLine2(UPDATED_DELIVERY_ADDRESS_LINE_2)
//            .deliveryCityName(UPDATED_DELIVERY_CITY_NAME)
//            .deliveryStateName(UPDATED_DELIVERY_STATE_NAME)
//            .deliveryZipCode(UPDATED_DELIVERY_ZIP_CODE)
//            .deliveryPhoneNo1(UPDATED_DELIVERY_PHONE_NO_1)
//            .deliveryPhoneNo2(UPDATED_DELIVERY_PHONE_NO_2)
//            .deliveryBranchId(UPDATED_DELIVERY_BRANCH_ID)
//            .deliveryBranchName(UPDATED_DELIVERY_BRANCH_NAME)
//            .taxZoneId(UPDATED_TAX_ZONE_ID)
//            .taxRate(UPDATED_TAX_RATE)
//            .salesOrderNote(UPDATED_SALES_ORDER_NOTE)
//            .deliveryNote(UPDATED_DELIVERY_NOTE)
//            .deliveryTechnician(UPDATED_DELIVERY_TECHNICIAN)
//            .signatureRequiredStatus(UPDATED_SIGNATURE_REQUIRED_STATUS)
//            .podStatus(UPDATED_POD_STATUS)
//            .podStatusDateTime(UPDATED_POD_STATUS_DATE_TIME)
//            .podLastMessage(UPDATED_POD_LAST_MESSAGE)
//            .podMessageDateTime(UPDATED_POD_MESSAGE_DATE_TIME)
//            .mutualHoldStatus(UPDATED_MUTUAL_HOLD_STATUS)
//            .holdReasonId(UPDATED_HOLD_REASON_ID)
//            .holdStatus(UPDATED_HOLD_STATUS)
//            .holdReasonDescription(UPDATED_HOLD_REASON_DESCRIPTION)
//            .stopDate(UPDATED_STOP_DATE)
//            .stopReasonId(UPDATED_STOP_REASON_ID)
//            .stopReasonDescription(UPDATED_STOP_REASON_DESCRIPTION)
//            .inventoryLocationId(UPDATED_INVENTORY_LOCATION_ID)
//            .orderStatus(UPDATED_ORDER_STATUS)
//            .orderClassificationId(UPDATED_ORDER_CLASSIFICATION_ID)
//            .posId(UPDATED_POS_ID)
//            .posName(UPDATED_POS_NAME)
//            .admissionDate(UPDATED_ADMISSION_DATE)
//            .dischargeDate(UPDATED_DISCHARGE_DATE)
//            .discountPercentage(UPDATED_DISCOUNT_PERCENTAGE)
//            .poNumber(UPDATED_PO_NUMBER)
//            .userField1(UPDATED_USER_FIELD_1)
//            .userField2(UPDATED_USER_FIELD_2)
//            .userField3(UPDATED_USER_FIELD_3)
//            .userField4(UPDATED_USER_FIELD_4)
//            .reference(UPDATED_REFERENCE)
//            .wipStatus(UPDATED_WIP_STATUS)
//            .wipDaysInState(UPDATED_WIP_DAYS_IN_STATE)
//            .wipAssignedToId(UPDATED_WIP_ASSIGNED_TO_ID)
//            .wipDateNeeded(UPDATED_WIP_DATE_NEEDED)
//            .completedStatus(UPDATED_COMPLETED_STATUS)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .confirmationById(UPDATED_CONFIRMATION_BY_ID)
//            .confirmationByName(UPDATED_CONFIRMATION_BY_NAME)
//            .confirmationDate(UPDATED_CONFIRMATION_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//        return salesOrderMaster;
//    }
//
//    public static void deleteEntities(EntityManager em) {
//        try {
//            em.deleteAll(SalesOrderMaster.class).block();
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
//        salesOrderMaster = createEntity(em);
//    }
//
//    @Test
//    void createSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeCreate = salesOrderMasterRepository.findAll().collectList().block().size();
//        // Create the SalesOrderMaster
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isCreated();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeCreate + 1);
//        SalesOrderMaster testSalesOrderMaster = salesOrderMasterList.get(salesOrderMasterList.size() - 1);
//        assertThat(testSalesOrderMaster.getSalesOderId()).isEqualTo(DEFAULT_SALES_ODER_ID);
//        assertThat(testSalesOrderMaster.getSalesOderNo()).isEqualTo(DEFAULT_SALES_ODER_NO);
//        assertThat(testSalesOrderMaster.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderMaster.getPatientFirstName()).isEqualTo(DEFAULT_PATIENT_FIRST_NAME);
//        assertThat(testSalesOrderMaster.getPatientMiddleName()).isEqualTo(DEFAULT_PATIENT_MIDDLE_NAME);
//        assertThat(testSalesOrderMaster.getPatientLastName()).isEqualTo(DEFAULT_PATIENT_LAST_NAME);
//        assertThat(testSalesOrderMaster.getPatientAddressId()).isEqualTo(DEFAULT_PATIENT_ADDRESS_ID);
//        assertThat(testSalesOrderMaster.getPatientAddressLine1()).isEqualTo(DEFAULT_PATIENT_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getPatientAddressLine2()).isEqualTo(DEFAULT_PATIENT_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getCityName()).isEqualTo(DEFAULT_CITY_NAME);
//        assertThat(testSalesOrderMaster.getStateName()).isEqualTo(DEFAULT_STATE_NAME);
//        assertThat(testSalesOrderMaster.getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getPatientContactId()).isEqualTo(DEFAULT_PATIENT_CONTACT_ID);
//        assertThat(testSalesOrderMaster.getPhone1()).isEqualTo(DEFAULT_PHONE_1);
//        assertThat(testSalesOrderMaster.getPhone2()).isEqualTo(DEFAULT_PHONE_2);
//        assertThat(testSalesOrderMaster.getPatientDob()).isEqualTo(DEFAULT_PATIENT_DOB);
//        assertThat(testSalesOrderMaster.getPatientHeight()).isEqualTo(DEFAULT_PATIENT_HEIGHT);
//        assertThat(testSalesOrderMaster.getPatientWeight()).isEqualTo(DEFAULT_PATIENT_WEIGHT);
//        assertThat(testSalesOrderMaster.getPatientSsn()).isEqualTo(DEFAULT_PATIENT_SSN);
//        assertThat(testSalesOrderMaster.getPatientGender()).isEqualTo(DEFAULT_PATIENT_GENDER);
//        assertThat(testSalesOrderMaster.getPatientBranchId()).isEqualTo(DEFAULT_PATIENT_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getBranchName()).isEqualTo(DEFAULT_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getPatientDod()).isEqualTo(DEFAULT_PATIENT_DOD);
//        assertThat(testSalesOrderMaster.getHipaaOnFileStatus()).isEqualTo(DEFAULT_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderMaster.getFacilityId()).isEqualTo(DEFAULT_FACILITY_ID);
//        assertThat(testSalesOrderMaster.getFacilityName()).isEqualTo(DEFAULT_FACILITY_NAME);
//        assertThat(testSalesOrderMaster.getFacilityNPI()).isEqualTo(DEFAULT_FACILITY_NPI);
//        assertThat(testSalesOrderMaster.getDeliveryScheduleDatetime()).isEqualTo(DEFAULT_DELIVERY_SCHEDULE_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryActualDatetime()).isEqualTo(DEFAULT_DELIVERY_ACTUAL_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine1()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine2()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getDeliveryCityName()).isEqualTo(DEFAULT_DELIVERY_CITY_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryStateName()).isEqualTo(DEFAULT_DELIVERY_STATE_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryZipCode()).isEqualTo(DEFAULT_DELIVERY_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo1()).isEqualTo(DEFAULT_DELIVERY_PHONE_NO_1);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo2()).isEqualTo(DEFAULT_DELIVERY_PHONE_NO_2);
//        assertThat(testSalesOrderMaster.getDeliveryBranchId()).isEqualTo(DEFAULT_DELIVERY_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getDeliveryBranchName()).isEqualTo(DEFAULT_DELIVERY_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getTaxZoneId()).isEqualTo(DEFAULT_TAX_ZONE_ID);
//        assertThat(testSalesOrderMaster.getTaxRate()).isEqualTo(DEFAULT_TAX_RATE);
//        assertThat(testSalesOrderMaster.getSalesOrderNote()).isEqualTo(DEFAULT_SALES_ORDER_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryNote()).isEqualTo(DEFAULT_DELIVERY_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryTechnician()).isEqualTo(DEFAULT_DELIVERY_TECHNICIAN);
//        assertThat(testSalesOrderMaster.getSignatureRequiredStatus()).isEqualTo(DEFAULT_SIGNATURE_REQUIRED_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatus()).isEqualTo(DEFAULT_POD_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatusDateTime()).isEqualTo(DEFAULT_POD_STATUS_DATE_TIME);
//        assertThat(testSalesOrderMaster.getPodLastMessage()).isEqualTo(DEFAULT_POD_LAST_MESSAGE);
//        assertThat(testSalesOrderMaster.getPodMessageDateTime()).isEqualTo(DEFAULT_POD_MESSAGE_DATE_TIME);
//        assertThat(testSalesOrderMaster.getMutualHoldStatus()).isEqualTo(DEFAULT_MUTUAL_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonId()).isEqualTo(DEFAULT_HOLD_REASON_ID);
//        assertThat(testSalesOrderMaster.getHoldStatus()).isEqualTo(DEFAULT_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonDescription()).isEqualTo(DEFAULT_HOLD_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getStopDate()).isEqualTo(DEFAULT_STOP_DATE);
//        assertThat(testSalesOrderMaster.getStopReasonId()).isEqualTo(DEFAULT_STOP_REASON_ID);
//        assertThat(testSalesOrderMaster.getStopReasonDescription()).isEqualTo(DEFAULT_STOP_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getInventoryLocationId()).isEqualTo(DEFAULT_INVENTORY_LOCATION_ID);
//        assertThat(testSalesOrderMaster.getOrderStatus()).isEqualTo(DEFAULT_ORDER_STATUS);
//        assertThat(testSalesOrderMaster.getOrderClassificationId()).isEqualTo(DEFAULT_ORDER_CLASSIFICATION_ID);
//        assertThat(testSalesOrderMaster.getPosId()).isEqualTo(DEFAULT_POS_ID);
//        assertThat(testSalesOrderMaster.getPosName()).isEqualTo(DEFAULT_POS_NAME);
//        assertThat(testSalesOrderMaster.getAdmissionDate()).isEqualTo(DEFAULT_ADMISSION_DATE);
//        assertThat(testSalesOrderMaster.getDischargeDate()).isEqualTo(DEFAULT_DISCHARGE_DATE);
//        assertThat(testSalesOrderMaster.getDiscountPercentage()).isEqualTo(DEFAULT_DISCOUNT_PERCENTAGE);
//        assertThat(testSalesOrderMaster.getPoNumber()).isEqualTo(DEFAULT_PO_NUMBER);
//        assertThat(testSalesOrderMaster.getUserField1()).isEqualTo(DEFAULT_USER_FIELD_1);
//        assertThat(testSalesOrderMaster.getUserField2()).isEqualTo(DEFAULT_USER_FIELD_2);
//        assertThat(testSalesOrderMaster.getUserField3()).isEqualTo(DEFAULT_USER_FIELD_3);
//        assertThat(testSalesOrderMaster.getUserField4()).isEqualTo(DEFAULT_USER_FIELD_4);
//        assertThat(testSalesOrderMaster.getReference()).isEqualTo(DEFAULT_REFERENCE);
//        assertThat(testSalesOrderMaster.getWipStatus()).isEqualTo(DEFAULT_WIP_STATUS);
//        assertThat(testSalesOrderMaster.getWipDaysInState()).isEqualTo(DEFAULT_WIP_DAYS_IN_STATE);
//        assertThat(testSalesOrderMaster.getWipAssignedToId()).isEqualTo(DEFAULT_WIP_ASSIGNED_TO_ID);
//        assertThat(testSalesOrderMaster.getWipDateNeeded()).isEqualTo(DEFAULT_WIP_DATE_NEEDED);
//        assertThat(testSalesOrderMaster.getCompletedStatus()).isEqualTo(DEFAULT_COMPLETED_STATUS);
//        assertThat(testSalesOrderMaster.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderMaster.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderMaster.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderMaster.getConfirmationById()).isEqualTo(DEFAULT_CONFIRMATION_BY_ID);
//        assertThat(testSalesOrderMaster.getConfirmationByName()).isEqualTo(DEFAULT_CONFIRMATION_BY_NAME);
//        assertThat(testSalesOrderMaster.getConfirmationDate()).isEqualTo(DEFAULT_CONFIRMATION_DATE);
//        assertThat(testSalesOrderMaster.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderMaster.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void createSalesOrderMasterWithExistingId() throws Exception {
//        // Create the SalesOrderMaster with an existing ID
//        salesOrderMaster.setId(1L);
//
//        int databaseSizeBeforeCreate = salesOrderMasterRepository.findAll().collectList().block().size();
//
//        // An entity with an existing ID cannot be created, so this API call must fail
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeCreate);
//    }
//
//    @Test
//    void checkSalesOderIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setSalesOderId(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSalesOderNoIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setSalesOderNo(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientId(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientFirstNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientFirstName(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientMiddleNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientMiddleName(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientLastNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientLastName(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientAddressIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientAddressId(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientContactIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientContactId(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientDobIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientDob(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientSsnIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientSsn(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientGenderIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientGender(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientDodIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setPatientDod(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkFacilityIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setFacilityId(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkFacilityNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setFacilityName(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkFacilityNPIIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderMasterRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderMaster.setFacilityNPI(null);
//
//        // Create the SalesOrderMaster, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void getAllSalesOrderMastersAsStream() {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        List<SalesOrderMaster> salesOrderMasterList = webTestClient
//            .get()
//            .uri(ENTITY_API_URL)
//            .accept(MediaType.APPLICATION_NDJSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
//            .returnResult(SalesOrderMaster.class)
//            .getResponseBody()
//            .filter(salesOrderMaster::equals)
//            .collectList()
//            .block(Duration.ofSeconds(5));
//
//        assertThat(salesOrderMasterList).isNotNull();
//        assertThat(salesOrderMasterList).hasSize(1);
//        SalesOrderMaster testSalesOrderMaster = salesOrderMasterList.get(0);
//        assertThat(testSalesOrderMaster.getSalesOderId()).isEqualTo(DEFAULT_SALES_ODER_ID);
//        assertThat(testSalesOrderMaster.getSalesOderNo()).isEqualTo(DEFAULT_SALES_ODER_NO);
//        assertThat(testSalesOrderMaster.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderMaster.getPatientFirstName()).isEqualTo(DEFAULT_PATIENT_FIRST_NAME);
//        assertThat(testSalesOrderMaster.getPatientMiddleName()).isEqualTo(DEFAULT_PATIENT_MIDDLE_NAME);
//        assertThat(testSalesOrderMaster.getPatientLastName()).isEqualTo(DEFAULT_PATIENT_LAST_NAME);
//        assertThat(testSalesOrderMaster.getPatientAddressId()).isEqualTo(DEFAULT_PATIENT_ADDRESS_ID);
//        assertThat(testSalesOrderMaster.getPatientAddressLine1()).isEqualTo(DEFAULT_PATIENT_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getPatientAddressLine2()).isEqualTo(DEFAULT_PATIENT_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getCityName()).isEqualTo(DEFAULT_CITY_NAME);
//        assertThat(testSalesOrderMaster.getStateName()).isEqualTo(DEFAULT_STATE_NAME);
//        assertThat(testSalesOrderMaster.getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getPatientContactId()).isEqualTo(DEFAULT_PATIENT_CONTACT_ID);
//        assertThat(testSalesOrderMaster.getPhone1()).isEqualTo(DEFAULT_PHONE_1);
//        assertThat(testSalesOrderMaster.getPhone2()).isEqualTo(DEFAULT_PHONE_2);
//        assertThat(testSalesOrderMaster.getPatientDob()).isEqualTo(DEFAULT_PATIENT_DOB);
//        assertThat(testSalesOrderMaster.getPatientHeight()).isEqualTo(DEFAULT_PATIENT_HEIGHT);
//        assertThat(testSalesOrderMaster.getPatientWeight()).isEqualTo(DEFAULT_PATIENT_WEIGHT);
//        assertThat(testSalesOrderMaster.getPatientSsn()).isEqualTo(DEFAULT_PATIENT_SSN);
//        assertThat(testSalesOrderMaster.getPatientGender()).isEqualTo(DEFAULT_PATIENT_GENDER);
//        assertThat(testSalesOrderMaster.getPatientBranchId()).isEqualTo(DEFAULT_PATIENT_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getBranchName()).isEqualTo(DEFAULT_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getPatientDod()).isEqualTo(DEFAULT_PATIENT_DOD);
//        assertThat(testSalesOrderMaster.getHipaaOnFileStatus()).isEqualTo(DEFAULT_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderMaster.getFacilityId()).isEqualTo(DEFAULT_FACILITY_ID);
//        assertThat(testSalesOrderMaster.getFacilityName()).isEqualTo(DEFAULT_FACILITY_NAME);
//        assertThat(testSalesOrderMaster.getFacilityNPI()).isEqualTo(DEFAULT_FACILITY_NPI);
//        assertThat(testSalesOrderMaster.getDeliveryScheduleDatetime()).isEqualTo(DEFAULT_DELIVERY_SCHEDULE_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryActualDatetime()).isEqualTo(DEFAULT_DELIVERY_ACTUAL_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine1()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine2()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getDeliveryCityName()).isEqualTo(DEFAULT_DELIVERY_CITY_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryStateName()).isEqualTo(DEFAULT_DELIVERY_STATE_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryZipCode()).isEqualTo(DEFAULT_DELIVERY_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo1()).isEqualTo(DEFAULT_DELIVERY_PHONE_NO_1);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo2()).isEqualTo(DEFAULT_DELIVERY_PHONE_NO_2);
//        assertThat(testSalesOrderMaster.getDeliveryBranchId()).isEqualTo(DEFAULT_DELIVERY_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getDeliveryBranchName()).isEqualTo(DEFAULT_DELIVERY_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getTaxZoneId()).isEqualTo(DEFAULT_TAX_ZONE_ID);
//        assertThat(testSalesOrderMaster.getTaxRate()).isEqualTo(DEFAULT_TAX_RATE);
//        assertThat(testSalesOrderMaster.getSalesOrderNote()).isEqualTo(DEFAULT_SALES_ORDER_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryNote()).isEqualTo(DEFAULT_DELIVERY_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryTechnician()).isEqualTo(DEFAULT_DELIVERY_TECHNICIAN);
//        assertThat(testSalesOrderMaster.getSignatureRequiredStatus()).isEqualTo(DEFAULT_SIGNATURE_REQUIRED_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatus()).isEqualTo(DEFAULT_POD_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatusDateTime()).isEqualTo(DEFAULT_POD_STATUS_DATE_TIME);
//        assertThat(testSalesOrderMaster.getPodLastMessage()).isEqualTo(DEFAULT_POD_LAST_MESSAGE);
//        assertThat(testSalesOrderMaster.getPodMessageDateTime()).isEqualTo(DEFAULT_POD_MESSAGE_DATE_TIME);
//        assertThat(testSalesOrderMaster.getMutualHoldStatus()).isEqualTo(DEFAULT_MUTUAL_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonId()).isEqualTo(DEFAULT_HOLD_REASON_ID);
//        assertThat(testSalesOrderMaster.getHoldStatus()).isEqualTo(DEFAULT_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonDescription()).isEqualTo(DEFAULT_HOLD_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getStopDate()).isEqualTo(DEFAULT_STOP_DATE);
//        assertThat(testSalesOrderMaster.getStopReasonId()).isEqualTo(DEFAULT_STOP_REASON_ID);
//        assertThat(testSalesOrderMaster.getStopReasonDescription()).isEqualTo(DEFAULT_STOP_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getInventoryLocationId()).isEqualTo(DEFAULT_INVENTORY_LOCATION_ID);
//        assertThat(testSalesOrderMaster.getOrderStatus()).isEqualTo(DEFAULT_ORDER_STATUS);
//        assertThat(testSalesOrderMaster.getOrderClassificationId()).isEqualTo(DEFAULT_ORDER_CLASSIFICATION_ID);
//        assertThat(testSalesOrderMaster.getPosId()).isEqualTo(DEFAULT_POS_ID);
//        assertThat(testSalesOrderMaster.getPosName()).isEqualTo(DEFAULT_POS_NAME);
//        assertThat(testSalesOrderMaster.getAdmissionDate()).isEqualTo(DEFAULT_ADMISSION_DATE);
//        assertThat(testSalesOrderMaster.getDischargeDate()).isEqualTo(DEFAULT_DISCHARGE_DATE);
//        assertThat(testSalesOrderMaster.getDiscountPercentage()).isEqualTo(DEFAULT_DISCOUNT_PERCENTAGE);
//        assertThat(testSalesOrderMaster.getPoNumber()).isEqualTo(DEFAULT_PO_NUMBER);
//        assertThat(testSalesOrderMaster.getUserField1()).isEqualTo(DEFAULT_USER_FIELD_1);
//        assertThat(testSalesOrderMaster.getUserField2()).isEqualTo(DEFAULT_USER_FIELD_2);
//        assertThat(testSalesOrderMaster.getUserField3()).isEqualTo(DEFAULT_USER_FIELD_3);
//        assertThat(testSalesOrderMaster.getUserField4()).isEqualTo(DEFAULT_USER_FIELD_4);
//        assertThat(testSalesOrderMaster.getReference()).isEqualTo(DEFAULT_REFERENCE);
//        assertThat(testSalesOrderMaster.getWipStatus()).isEqualTo(DEFAULT_WIP_STATUS);
//        assertThat(testSalesOrderMaster.getWipDaysInState()).isEqualTo(DEFAULT_WIP_DAYS_IN_STATE);
//        assertThat(testSalesOrderMaster.getWipAssignedToId()).isEqualTo(DEFAULT_WIP_ASSIGNED_TO_ID);
//        assertThat(testSalesOrderMaster.getWipDateNeeded()).isEqualTo(DEFAULT_WIP_DATE_NEEDED);
//        assertThat(testSalesOrderMaster.getCompletedStatus()).isEqualTo(DEFAULT_COMPLETED_STATUS);
//        assertThat(testSalesOrderMaster.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderMaster.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderMaster.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderMaster.getConfirmationById()).isEqualTo(DEFAULT_CONFIRMATION_BY_ID);
//        assertThat(testSalesOrderMaster.getConfirmationByName()).isEqualTo(DEFAULT_CONFIRMATION_BY_NAME);
//        assertThat(testSalesOrderMaster.getConfirmationDate()).isEqualTo(DEFAULT_CONFIRMATION_DATE);
//        assertThat(testSalesOrderMaster.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderMaster.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void getAllSalesOrderMasters() {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        // Get all the salesOrderMasterList
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
//            .value(hasItem(salesOrderMaster.getId().intValue()))
//            .jsonPath("$.[*].salesOderId")
//            .value(hasItem(DEFAULT_SALES_ODER_ID))
//            .jsonPath("$.[*].salesOderNo")
//            .value(hasItem(DEFAULT_SALES_ODER_NO))
//            .jsonPath("$.[*].patientId")
//            .value(hasItem(DEFAULT_PATIENT_ID))
//            .jsonPath("$.[*].patientFirstName")
//            .value(hasItem(DEFAULT_PATIENT_FIRST_NAME))
//            .jsonPath("$.[*].patientMiddleName")
//            .value(hasItem(DEFAULT_PATIENT_MIDDLE_NAME))
//            .jsonPath("$.[*].patientLastName")
//            .value(hasItem(DEFAULT_PATIENT_LAST_NAME))
//            .jsonPath("$.[*].patientAddressId")
//            .value(hasItem(DEFAULT_PATIENT_ADDRESS_ID))
//            .jsonPath("$.[*].patientAddressLine1")
//            .value(hasItem(DEFAULT_PATIENT_ADDRESS_LINE_1))
//            .jsonPath("$.[*].patientAddressLine2")
//            .value(hasItem(DEFAULT_PATIENT_ADDRESS_LINE_2))
//            .jsonPath("$.[*].cityName")
//            .value(hasItem(DEFAULT_CITY_NAME))
//            .jsonPath("$.[*].stateName")
//            .value(hasItem(DEFAULT_STATE_NAME))
//            .jsonPath("$.[*].zipCode")
//            .value(hasItem(DEFAULT_ZIP_CODE))
//            .jsonPath("$.[*].patientContactId")
//            .value(hasItem(DEFAULT_PATIENT_CONTACT_ID))
//            .jsonPath("$.[*].phone1")
//            .value(hasItem(DEFAULT_PHONE_1))
//            .jsonPath("$.[*].phone2")
//            .value(hasItem(DEFAULT_PHONE_2))
//            .jsonPath("$.[*].patientDob")
//            .value(hasItem(DEFAULT_PATIENT_DOB.toString()))
//            .jsonPath("$.[*].patientHeight")
//            .value(hasItem(DEFAULT_PATIENT_HEIGHT.doubleValue()))
//            .jsonPath("$.[*].patientWeight")
//            .value(hasItem(DEFAULT_PATIENT_WEIGHT.doubleValue()))
//            .jsonPath("$.[*].patientSsn")
//            .value(hasItem(DEFAULT_PATIENT_SSN))
//            .jsonPath("$.[*].patientGender")
//            .value(hasItem(DEFAULT_PATIENT_GENDER))
//            .jsonPath("$.[*].patientBranchId")
//            .value(hasItem(DEFAULT_PATIENT_BRANCH_ID))
//            .jsonPath("$.[*].branchName")
//            .value(hasItem(DEFAULT_BRANCH_NAME))
//            .jsonPath("$.[*].patientDod")
//            .value(hasItem(DEFAULT_PATIENT_DOD.toString()))
//            .jsonPath("$.[*].hipaaOnFileStatus")
//            .value(hasItem(DEFAULT_HIPAA_ON_FILE_STATUS))
//            .jsonPath("$.[*].facilityId")
//            .value(hasItem(DEFAULT_FACILITY_ID))
//            .jsonPath("$.[*].facilityName")
//            .value(hasItem(DEFAULT_FACILITY_NAME))
//            .jsonPath("$.[*].facilityNPI")
//            .value(hasItem(DEFAULT_FACILITY_NPI))
//            .jsonPath("$.[*].deliveryScheduleDatetime")
//            .value(hasItem(sameInstant(DEFAULT_DELIVERY_SCHEDULE_DATETIME)))
//            .jsonPath("$.[*].deliveryActualDatetime")
//            .value(hasItem(sameInstant(DEFAULT_DELIVERY_ACTUAL_DATETIME)))
//            .jsonPath("$.[*].deliveryAddressLine1")
//            .value(hasItem(DEFAULT_DELIVERY_ADDRESS_LINE_1))
//            .jsonPath("$.[*].deliveryAddressLine2")
//            .value(hasItem(DEFAULT_DELIVERY_ADDRESS_LINE_2))
//            .jsonPath("$.[*].deliveryCityName")
//            .value(hasItem(DEFAULT_DELIVERY_CITY_NAME))
//            .jsonPath("$.[*].deliveryStateName")
//            .value(hasItem(DEFAULT_DELIVERY_STATE_NAME))
//            .jsonPath("$.[*].deliveryZipCode")
//            .value(hasItem(DEFAULT_DELIVERY_ZIP_CODE))
//            .jsonPath("$.[*].deliveryPhoneNo1")
//            .value(hasItem(DEFAULT_DELIVERY_PHONE_NO_1))
//            .jsonPath("$.[*].deliveryPhoneNo2")
//            .value(hasItem(DEFAULT_DELIVERY_PHONE_NO_2))
//            .jsonPath("$.[*].deliveryBranchId")
//            .value(hasItem(DEFAULT_DELIVERY_BRANCH_ID))
//            .jsonPath("$.[*].deliveryBranchName")
//            .value(hasItem(DEFAULT_DELIVERY_BRANCH_NAME))
//            .jsonPath("$.[*].taxZoneId")
//            .value(hasItem(DEFAULT_TAX_ZONE_ID))
//            .jsonPath("$.[*].taxRate")
//            .value(hasItem(DEFAULT_TAX_RATE.doubleValue()))
//            .jsonPath("$.[*].salesOrderNote")
//            .value(hasItem(DEFAULT_SALES_ORDER_NOTE))
//            .jsonPath("$.[*].deliveryNote")
//            .value(hasItem(DEFAULT_DELIVERY_NOTE))
//            .jsonPath("$.[*].deliveryTechnician")
//            .value(hasItem(DEFAULT_DELIVERY_TECHNICIAN))
//            .jsonPath("$.[*].signatureRequiredStatus")
//            .value(hasItem(DEFAULT_SIGNATURE_REQUIRED_STATUS))
//            .jsonPath("$.[*].podStatus")
//            .value(hasItem(DEFAULT_POD_STATUS))
//            .jsonPath("$.[*].podStatusDateTime")
//            .value(hasItem(sameInstant(DEFAULT_POD_STATUS_DATE_TIME)))
//            .jsonPath("$.[*].podLastMessage")
//            .value(hasItem(DEFAULT_POD_LAST_MESSAGE))
//            .jsonPath("$.[*].podMessageDateTime")
//            .value(hasItem(sameInstant(DEFAULT_POD_MESSAGE_DATE_TIME)))
//            .jsonPath("$.[*].mutualHoldStatus")
//            .value(hasItem(DEFAULT_MUTUAL_HOLD_STATUS))
//            .jsonPath("$.[*].holdReasonId")
//            .value(hasItem(DEFAULT_HOLD_REASON_ID))
//            .jsonPath("$.[*].holdStatus")
//            .value(hasItem(DEFAULT_HOLD_STATUS))
//            .jsonPath("$.[*].holdReasonDescription")
//            .value(hasItem(DEFAULT_HOLD_REASON_DESCRIPTION))
//            .jsonPath("$.[*].stopDate")
//            .value(hasItem(DEFAULT_STOP_DATE.toString()))
//            .jsonPath("$.[*].stopReasonId")
//            .value(hasItem(DEFAULT_STOP_REASON_ID))
//            .jsonPath("$.[*].stopReasonDescription")
//            .value(hasItem(DEFAULT_STOP_REASON_DESCRIPTION))
//            .jsonPath("$.[*].inventoryLocationId")
//            .value(hasItem(DEFAULT_INVENTORY_LOCATION_ID))
//            .jsonPath("$.[*].orderStatus")
//            .value(hasItem(DEFAULT_ORDER_STATUS))
//            .jsonPath("$.[*].orderClassificationId")
//            .value(hasItem(DEFAULT_ORDER_CLASSIFICATION_ID))
//            .jsonPath("$.[*].posId")
//            .value(hasItem(DEFAULT_POS_ID))
//            .jsonPath("$.[*].posName")
//            .value(hasItem(DEFAULT_POS_NAME))
//            .jsonPath("$.[*].admissionDate")
//            .value(hasItem(DEFAULT_ADMISSION_DATE.toString()))
//            .jsonPath("$.[*].dischargeDate")
//            .value(hasItem(DEFAULT_DISCHARGE_DATE.toString()))
//            .jsonPath("$.[*].discountPercentage")
//            .value(hasItem(DEFAULT_DISCOUNT_PERCENTAGE))
//            .jsonPath("$.[*].poNumber")
//            .value(hasItem(DEFAULT_PO_NUMBER))
//            .jsonPath("$.[*].userField1")
//            .value(hasItem(DEFAULT_USER_FIELD_1))
//            .jsonPath("$.[*].userField2")
//            .value(hasItem(DEFAULT_USER_FIELD_2))
//            .jsonPath("$.[*].userField3")
//            .value(hasItem(DEFAULT_USER_FIELD_3))
//            .jsonPath("$.[*].userField4")
//            .value(hasItem(DEFAULT_USER_FIELD_4))
//            .jsonPath("$.[*].reference")
//            .value(hasItem(DEFAULT_REFERENCE))
//            .jsonPath("$.[*].wipStatus")
//            .value(hasItem(DEFAULT_WIP_STATUS))
//            .jsonPath("$.[*].wipDaysInState")
//            .value(hasItem(DEFAULT_WIP_DAYS_IN_STATE))
//            .jsonPath("$.[*].wipAssignedToId")
//            .value(hasItem(DEFAULT_WIP_ASSIGNED_TO_ID))
//            .jsonPath("$.[*].wipDateNeeded")
//            .value(hasItem(DEFAULT_WIP_DATE_NEEDED.toString()))
//            .jsonPath("$.[*].completedStatus")
//            .value(hasItem(DEFAULT_COMPLETED_STATUS))
//            .jsonPath("$.[*].status")
//            .value(hasItem(DEFAULT_STATUS))
//            .jsonPath("$.[*].createdById")
//            .value(hasItem(DEFAULT_CREATED_BY_ID))
//            .jsonPath("$.[*].createdByName")
//            .value(hasItem(DEFAULT_CREATED_BY_NAME))
//            .jsonPath("$.[*].createdDate")
//            .value(hasItem(sameInstant(DEFAULT_CREATED_DATE)))
//            .jsonPath("$.[*].confirmationById")
//            .value(hasItem(DEFAULT_CONFIRMATION_BY_ID))
//            .jsonPath("$.[*].confirmationByName")
//            .value(hasItem(DEFAULT_CONFIRMATION_BY_NAME))
//            .jsonPath("$.[*].confirmationDate")
//            .value(hasItem(sameInstant(DEFAULT_CONFIRMATION_DATE)))
//            .jsonPath("$.[*].updatedById")
//            .value(hasItem(DEFAULT_UPDATED_BY_ID))
//            .jsonPath("$.[*].updatedByName")
//            .value(hasItem(DEFAULT_UPDATED_BY_NAME))
//            .jsonPath("$.[*].updatedDate")
//            .value(hasItem(sameInstant(DEFAULT_UPDATED_DATE)));
//    }
//
//    @Test
//    void getSalesOrderMaster() {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        // Get the salesOrderMaster
//        webTestClient
//            .get()
//            .uri(ENTITY_API_URL_ID, salesOrderMaster.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentType(MediaType.APPLICATION_JSON)
//            .expectBody()
//            .jsonPath("$.id")
//            .value(is(salesOrderMaster.getId().intValue()))
//            .jsonPath("$.salesOderId")
//            .value(is(DEFAULT_SALES_ODER_ID))
//            .jsonPath("$.salesOderNo")
//            .value(is(DEFAULT_SALES_ODER_NO))
//            .jsonPath("$.patientId")
//            .value(is(DEFAULT_PATIENT_ID))
//            .jsonPath("$.patientFirstName")
//            .value(is(DEFAULT_PATIENT_FIRST_NAME))
//            .jsonPath("$.patientMiddleName")
//            .value(is(DEFAULT_PATIENT_MIDDLE_NAME))
//            .jsonPath("$.patientLastName")
//            .value(is(DEFAULT_PATIENT_LAST_NAME))
//            .jsonPath("$.patientAddressId")
//            .value(is(DEFAULT_PATIENT_ADDRESS_ID))
//            .jsonPath("$.patientAddressLine1")
//            .value(is(DEFAULT_PATIENT_ADDRESS_LINE_1))
//            .jsonPath("$.patientAddressLine2")
//            .value(is(DEFAULT_PATIENT_ADDRESS_LINE_2))
//            .jsonPath("$.cityName")
//            .value(is(DEFAULT_CITY_NAME))
//            .jsonPath("$.stateName")
//            .value(is(DEFAULT_STATE_NAME))
//            .jsonPath("$.zipCode")
//            .value(is(DEFAULT_ZIP_CODE))
//            .jsonPath("$.patientContactId")
//            .value(is(DEFAULT_PATIENT_CONTACT_ID))
//            .jsonPath("$.phone1")
//            .value(is(DEFAULT_PHONE_1))
//            .jsonPath("$.phone2")
//            .value(is(DEFAULT_PHONE_2))
//            .jsonPath("$.patientDob")
//            .value(is(DEFAULT_PATIENT_DOB.toString()))
//            .jsonPath("$.patientHeight")
//            .value(is(DEFAULT_PATIENT_HEIGHT.doubleValue()))
//            .jsonPath("$.patientWeight")
//            .value(is(DEFAULT_PATIENT_WEIGHT.doubleValue()))
//            .jsonPath("$.patientSsn")
//            .value(is(DEFAULT_PATIENT_SSN))
//            .jsonPath("$.patientGender")
//            .value(is(DEFAULT_PATIENT_GENDER))
//            .jsonPath("$.patientBranchId")
//            .value(is(DEFAULT_PATIENT_BRANCH_ID))
//            .jsonPath("$.branchName")
//            .value(is(DEFAULT_BRANCH_NAME))
//            .jsonPath("$.patientDod")
//            .value(is(DEFAULT_PATIENT_DOD.toString()))
//            .jsonPath("$.hipaaOnFileStatus")
//            .value(is(DEFAULT_HIPAA_ON_FILE_STATUS))
//            .jsonPath("$.facilityId")
//            .value(is(DEFAULT_FACILITY_ID))
//            .jsonPath("$.facilityName")
//            .value(is(DEFAULT_FACILITY_NAME))
//            .jsonPath("$.facilityNPI")
//            .value(is(DEFAULT_FACILITY_NPI))
//            .jsonPath("$.deliveryScheduleDatetime")
//            .value(is(sameInstant(DEFAULT_DELIVERY_SCHEDULE_DATETIME)))
//            .jsonPath("$.deliveryActualDatetime")
//            .value(is(sameInstant(DEFAULT_DELIVERY_ACTUAL_DATETIME)))
//            .jsonPath("$.deliveryAddressLine1")
//            .value(is(DEFAULT_DELIVERY_ADDRESS_LINE_1))
//            .jsonPath("$.deliveryAddressLine2")
//            .value(is(DEFAULT_DELIVERY_ADDRESS_LINE_2))
//            .jsonPath("$.deliveryCityName")
//            .value(is(DEFAULT_DELIVERY_CITY_NAME))
//            .jsonPath("$.deliveryStateName")
//            .value(is(DEFAULT_DELIVERY_STATE_NAME))
//            .jsonPath("$.deliveryZipCode")
//            .value(is(DEFAULT_DELIVERY_ZIP_CODE))
//            .jsonPath("$.deliveryPhoneNo1")
//            .value(is(DEFAULT_DELIVERY_PHONE_NO_1))
//            .jsonPath("$.deliveryPhoneNo2")
//            .value(is(DEFAULT_DELIVERY_PHONE_NO_2))
//            .jsonPath("$.deliveryBranchId")
//            .value(is(DEFAULT_DELIVERY_BRANCH_ID))
//            .jsonPath("$.deliveryBranchName")
//            .value(is(DEFAULT_DELIVERY_BRANCH_NAME))
//            .jsonPath("$.taxZoneId")
//            .value(is(DEFAULT_TAX_ZONE_ID))
//            .jsonPath("$.taxRate")
//            .value(is(DEFAULT_TAX_RATE.doubleValue()))
//            .jsonPath("$.salesOrderNote")
//            .value(is(DEFAULT_SALES_ORDER_NOTE))
//            .jsonPath("$.deliveryNote")
//            .value(is(DEFAULT_DELIVERY_NOTE))
//            .jsonPath("$.deliveryTechnician")
//            .value(is(DEFAULT_DELIVERY_TECHNICIAN))
//            .jsonPath("$.signatureRequiredStatus")
//            .value(is(DEFAULT_SIGNATURE_REQUIRED_STATUS))
//            .jsonPath("$.podStatus")
//            .value(is(DEFAULT_POD_STATUS))
//            .jsonPath("$.podStatusDateTime")
//            .value(is(sameInstant(DEFAULT_POD_STATUS_DATE_TIME)))
//            .jsonPath("$.podLastMessage")
//            .value(is(DEFAULT_POD_LAST_MESSAGE))
//            .jsonPath("$.podMessageDateTime")
//            .value(is(sameInstant(DEFAULT_POD_MESSAGE_DATE_TIME)))
//            .jsonPath("$.mutualHoldStatus")
//            .value(is(DEFAULT_MUTUAL_HOLD_STATUS))
//            .jsonPath("$.holdReasonId")
//            .value(is(DEFAULT_HOLD_REASON_ID))
//            .jsonPath("$.holdStatus")
//            .value(is(DEFAULT_HOLD_STATUS))
//            .jsonPath("$.holdReasonDescription")
//            .value(is(DEFAULT_HOLD_REASON_DESCRIPTION))
//            .jsonPath("$.stopDate")
//            .value(is(DEFAULT_STOP_DATE.toString()))
//            .jsonPath("$.stopReasonId")
//            .value(is(DEFAULT_STOP_REASON_ID))
//            .jsonPath("$.stopReasonDescription")
//            .value(is(DEFAULT_STOP_REASON_DESCRIPTION))
//            .jsonPath("$.inventoryLocationId")
//            .value(is(DEFAULT_INVENTORY_LOCATION_ID))
//            .jsonPath("$.orderStatus")
//            .value(is(DEFAULT_ORDER_STATUS))
//            .jsonPath("$.orderClassificationId")
//            .value(is(DEFAULT_ORDER_CLASSIFICATION_ID))
//            .jsonPath("$.posId")
//            .value(is(DEFAULT_POS_ID))
//            .jsonPath("$.posName")
//            .value(is(DEFAULT_POS_NAME))
//            .jsonPath("$.admissionDate")
//            .value(is(DEFAULT_ADMISSION_DATE.toString()))
//            .jsonPath("$.dischargeDate")
//            .value(is(DEFAULT_DISCHARGE_DATE.toString()))
//            .jsonPath("$.discountPercentage")
//            .value(is(DEFAULT_DISCOUNT_PERCENTAGE))
//            .jsonPath("$.poNumber")
//            .value(is(DEFAULT_PO_NUMBER))
//            .jsonPath("$.userField1")
//            .value(is(DEFAULT_USER_FIELD_1))
//            .jsonPath("$.userField2")
//            .value(is(DEFAULT_USER_FIELD_2))
//            .jsonPath("$.userField3")
//            .value(is(DEFAULT_USER_FIELD_3))
//            .jsonPath("$.userField4")
//            .value(is(DEFAULT_USER_FIELD_4))
//            .jsonPath("$.reference")
//            .value(is(DEFAULT_REFERENCE))
//            .jsonPath("$.wipStatus")
//            .value(is(DEFAULT_WIP_STATUS))
//            .jsonPath("$.wipDaysInState")
//            .value(is(DEFAULT_WIP_DAYS_IN_STATE))
//            .jsonPath("$.wipAssignedToId")
//            .value(is(DEFAULT_WIP_ASSIGNED_TO_ID))
//            .jsonPath("$.wipDateNeeded")
//            .value(is(DEFAULT_WIP_DATE_NEEDED.toString()))
//            .jsonPath("$.completedStatus")
//            .value(is(DEFAULT_COMPLETED_STATUS))
//            .jsonPath("$.status")
//            .value(is(DEFAULT_STATUS))
//            .jsonPath("$.createdById")
//            .value(is(DEFAULT_CREATED_BY_ID))
//            .jsonPath("$.createdByName")
//            .value(is(DEFAULT_CREATED_BY_NAME))
//            .jsonPath("$.createdDate")
//            .value(is(sameInstant(DEFAULT_CREATED_DATE)))
//            .jsonPath("$.confirmationById")
//            .value(is(DEFAULT_CONFIRMATION_BY_ID))
//            .jsonPath("$.confirmationByName")
//            .value(is(DEFAULT_CONFIRMATION_BY_NAME))
//            .jsonPath("$.confirmationDate")
//            .value(is(sameInstant(DEFAULT_CONFIRMATION_DATE)))
//            .jsonPath("$.updatedById")
//            .value(is(DEFAULT_UPDATED_BY_ID))
//            .jsonPath("$.updatedByName")
//            .value(is(DEFAULT_UPDATED_BY_NAME))
//            .jsonPath("$.updatedDate")
//            .value(is(sameInstant(DEFAULT_UPDATED_DATE)));
//    }
//
//    @Test
//    void getNonExistingSalesOrderMaster() {
//        // Get the salesOrderMaster
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
//    void putNewSalesOrderMaster() throws Exception {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderMaster
//        SalesOrderMaster updatedSalesOrderMaster = salesOrderMasterRepository.findById(salesOrderMaster.getId()).block();
//        updatedSalesOrderMaster
//            .salesOderId(UPDATED_SALES_ODER_ID)
//            .salesOderNo(UPDATED_SALES_ODER_NO)
//            .patientId(UPDATED_PATIENT_ID)
//            .patientFirstName(UPDATED_PATIENT_FIRST_NAME)
//            .patientMiddleName(UPDATED_PATIENT_MIDDLE_NAME)
//            .patientLastName(UPDATED_PATIENT_LAST_NAME)
//            .patientAddressId(UPDATED_PATIENT_ADDRESS_ID)
//            .patientAddressLine1(UPDATED_PATIENT_ADDRESS_LINE_1)
//            .patientAddressLine2(UPDATED_PATIENT_ADDRESS_LINE_2)
//            .cityName(UPDATED_CITY_NAME)
//            .stateName(UPDATED_STATE_NAME)
//            .zipCode(UPDATED_ZIP_CODE)
//            .patientContactId(UPDATED_PATIENT_CONTACT_ID)
//            .phone1(UPDATED_PHONE_1)
//            .phone2(UPDATED_PHONE_2)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientWeight(UPDATED_PATIENT_WEIGHT)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientBranchId(UPDATED_PATIENT_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .facilityId(UPDATED_FACILITY_ID)
//            .facilityName(UPDATED_FACILITY_NAME)
//            .facilityNPI(UPDATED_FACILITY_NPI)
//            .deliveryScheduleDatetime(UPDATED_DELIVERY_SCHEDULE_DATETIME)
//            .deliveryActualDatetime(UPDATED_DELIVERY_ACTUAL_DATETIME)
//            .deliveryAddressLine1(UPDATED_DELIVERY_ADDRESS_LINE_1)
//            .deliveryAddressLine2(UPDATED_DELIVERY_ADDRESS_LINE_2)
//            .deliveryCityName(UPDATED_DELIVERY_CITY_NAME)
//            .deliveryStateName(UPDATED_DELIVERY_STATE_NAME)
//            .deliveryZipCode(UPDATED_DELIVERY_ZIP_CODE)
//            .deliveryPhoneNo1(UPDATED_DELIVERY_PHONE_NO_1)
//            .deliveryPhoneNo2(UPDATED_DELIVERY_PHONE_NO_2)
//            .deliveryBranchId(UPDATED_DELIVERY_BRANCH_ID)
//            .deliveryBranchName(UPDATED_DELIVERY_BRANCH_NAME)
//            .taxZoneId(UPDATED_TAX_ZONE_ID)
//            .taxRate(UPDATED_TAX_RATE)
//            .salesOrderNote(UPDATED_SALES_ORDER_NOTE)
//            .deliveryNote(UPDATED_DELIVERY_NOTE)
//            .deliveryTechnician(UPDATED_DELIVERY_TECHNICIAN)
//            .signatureRequiredStatus(UPDATED_SIGNATURE_REQUIRED_STATUS)
//            .podStatus(UPDATED_POD_STATUS)
//            .podStatusDateTime(UPDATED_POD_STATUS_DATE_TIME)
//            .podLastMessage(UPDATED_POD_LAST_MESSAGE)
//            .podMessageDateTime(UPDATED_POD_MESSAGE_DATE_TIME)
//            .mutualHoldStatus(UPDATED_MUTUAL_HOLD_STATUS)
//            .holdReasonId(UPDATED_HOLD_REASON_ID)
//            .holdStatus(UPDATED_HOLD_STATUS)
//            .holdReasonDescription(UPDATED_HOLD_REASON_DESCRIPTION)
//            .stopDate(UPDATED_STOP_DATE)
//            .stopReasonId(UPDATED_STOP_REASON_ID)
//            .stopReasonDescription(UPDATED_STOP_REASON_DESCRIPTION)
//            .inventoryLocationId(UPDATED_INVENTORY_LOCATION_ID)
//            .orderStatus(UPDATED_ORDER_STATUS)
//            .orderClassificationId(UPDATED_ORDER_CLASSIFICATION_ID)
//            .posId(UPDATED_POS_ID)
//            .posName(UPDATED_POS_NAME)
//            .admissionDate(UPDATED_ADMISSION_DATE)
//            .dischargeDate(UPDATED_DISCHARGE_DATE)
//            .discountPercentage(UPDATED_DISCOUNT_PERCENTAGE)
//            .poNumber(UPDATED_PO_NUMBER)
//            .userField1(UPDATED_USER_FIELD_1)
//            .userField2(UPDATED_USER_FIELD_2)
//            .userField3(UPDATED_USER_FIELD_3)
//            .userField4(UPDATED_USER_FIELD_4)
//            .reference(UPDATED_REFERENCE)
//            .wipStatus(UPDATED_WIP_STATUS)
//            .wipDaysInState(UPDATED_WIP_DAYS_IN_STATE)
//            .wipAssignedToId(UPDATED_WIP_ASSIGNED_TO_ID)
//            .wipDateNeeded(UPDATED_WIP_DATE_NEEDED)
//            .completedStatus(UPDATED_COMPLETED_STATUS)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .confirmationById(UPDATED_CONFIRMATION_BY_ID)
//            .confirmationByName(UPDATED_CONFIRMATION_BY_NAME)
//            .confirmationDate(UPDATED_CONFIRMATION_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, updatedSalesOrderMaster.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedSalesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderMaster testSalesOrderMaster = salesOrderMasterList.get(salesOrderMasterList.size() - 1);
//        assertThat(testSalesOrderMaster.getSalesOderId()).isEqualTo(UPDATED_SALES_ODER_ID);
//        assertThat(testSalesOrderMaster.getSalesOderNo()).isEqualTo(UPDATED_SALES_ODER_NO);
//        assertThat(testSalesOrderMaster.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderMaster.getPatientFirstName()).isEqualTo(UPDATED_PATIENT_FIRST_NAME);
//        assertThat(testSalesOrderMaster.getPatientMiddleName()).isEqualTo(UPDATED_PATIENT_MIDDLE_NAME);
//        assertThat(testSalesOrderMaster.getPatientLastName()).isEqualTo(UPDATED_PATIENT_LAST_NAME);
//        assertThat(testSalesOrderMaster.getPatientAddressId()).isEqualTo(UPDATED_PATIENT_ADDRESS_ID);
//        assertThat(testSalesOrderMaster.getPatientAddressLine1()).isEqualTo(UPDATED_PATIENT_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getPatientAddressLine2()).isEqualTo(UPDATED_PATIENT_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getCityName()).isEqualTo(UPDATED_CITY_NAME);
//        assertThat(testSalesOrderMaster.getStateName()).isEqualTo(UPDATED_STATE_NAME);
//        assertThat(testSalesOrderMaster.getZipCode()).isEqualTo(UPDATED_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getPatientContactId()).isEqualTo(UPDATED_PATIENT_CONTACT_ID);
//        assertThat(testSalesOrderMaster.getPhone1()).isEqualTo(UPDATED_PHONE_1);
//        assertThat(testSalesOrderMaster.getPhone2()).isEqualTo(UPDATED_PHONE_2);
//        assertThat(testSalesOrderMaster.getPatientDob()).isEqualTo(UPDATED_PATIENT_DOB);
//        assertThat(testSalesOrderMaster.getPatientHeight()).isEqualTo(UPDATED_PATIENT_HEIGHT);
//        assertThat(testSalesOrderMaster.getPatientWeight()).isEqualTo(UPDATED_PATIENT_WEIGHT);
//        assertThat(testSalesOrderMaster.getPatientSsn()).isEqualTo(UPDATED_PATIENT_SSN);
//        assertThat(testSalesOrderMaster.getPatientGender()).isEqualTo(UPDATED_PATIENT_GENDER);
//        assertThat(testSalesOrderMaster.getPatientBranchId()).isEqualTo(UPDATED_PATIENT_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getBranchName()).isEqualTo(UPDATED_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getPatientDod()).isEqualTo(UPDATED_PATIENT_DOD);
//        assertThat(testSalesOrderMaster.getHipaaOnFileStatus()).isEqualTo(UPDATED_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderMaster.getFacilityId()).isEqualTo(UPDATED_FACILITY_ID);
//        assertThat(testSalesOrderMaster.getFacilityName()).isEqualTo(UPDATED_FACILITY_NAME);
//        assertThat(testSalesOrderMaster.getFacilityNPI()).isEqualTo(UPDATED_FACILITY_NPI);
//        assertThat(testSalesOrderMaster.getDeliveryScheduleDatetime()).isEqualTo(UPDATED_DELIVERY_SCHEDULE_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryActualDatetime()).isEqualTo(UPDATED_DELIVERY_ACTUAL_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine1()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine2()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getDeliveryCityName()).isEqualTo(UPDATED_DELIVERY_CITY_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryStateName()).isEqualTo(UPDATED_DELIVERY_STATE_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryZipCode()).isEqualTo(UPDATED_DELIVERY_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo1()).isEqualTo(UPDATED_DELIVERY_PHONE_NO_1);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo2()).isEqualTo(UPDATED_DELIVERY_PHONE_NO_2);
//        assertThat(testSalesOrderMaster.getDeliveryBranchId()).isEqualTo(UPDATED_DELIVERY_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getDeliveryBranchName()).isEqualTo(UPDATED_DELIVERY_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getTaxZoneId()).isEqualTo(UPDATED_TAX_ZONE_ID);
//        assertThat(testSalesOrderMaster.getTaxRate()).isEqualTo(UPDATED_TAX_RATE);
//        assertThat(testSalesOrderMaster.getSalesOrderNote()).isEqualTo(UPDATED_SALES_ORDER_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryNote()).isEqualTo(UPDATED_DELIVERY_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryTechnician()).isEqualTo(UPDATED_DELIVERY_TECHNICIAN);
//        assertThat(testSalesOrderMaster.getSignatureRequiredStatus()).isEqualTo(UPDATED_SIGNATURE_REQUIRED_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatus()).isEqualTo(UPDATED_POD_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatusDateTime()).isEqualTo(UPDATED_POD_STATUS_DATE_TIME);
//        assertThat(testSalesOrderMaster.getPodLastMessage()).isEqualTo(UPDATED_POD_LAST_MESSAGE);
//        assertThat(testSalesOrderMaster.getPodMessageDateTime()).isEqualTo(UPDATED_POD_MESSAGE_DATE_TIME);
//        assertThat(testSalesOrderMaster.getMutualHoldStatus()).isEqualTo(UPDATED_MUTUAL_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonId()).isEqualTo(UPDATED_HOLD_REASON_ID);
//        assertThat(testSalesOrderMaster.getHoldStatus()).isEqualTo(UPDATED_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonDescription()).isEqualTo(UPDATED_HOLD_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getStopDate()).isEqualTo(UPDATED_STOP_DATE);
//        assertThat(testSalesOrderMaster.getStopReasonId()).isEqualTo(UPDATED_STOP_REASON_ID);
//        assertThat(testSalesOrderMaster.getStopReasonDescription()).isEqualTo(UPDATED_STOP_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getInventoryLocationId()).isEqualTo(UPDATED_INVENTORY_LOCATION_ID);
//        assertThat(testSalesOrderMaster.getOrderStatus()).isEqualTo(UPDATED_ORDER_STATUS);
//        assertThat(testSalesOrderMaster.getOrderClassificationId()).isEqualTo(UPDATED_ORDER_CLASSIFICATION_ID);
//        assertThat(testSalesOrderMaster.getPosId()).isEqualTo(UPDATED_POS_ID);
//        assertThat(testSalesOrderMaster.getPosName()).isEqualTo(UPDATED_POS_NAME);
//        assertThat(testSalesOrderMaster.getAdmissionDate()).isEqualTo(UPDATED_ADMISSION_DATE);
//        assertThat(testSalesOrderMaster.getDischargeDate()).isEqualTo(UPDATED_DISCHARGE_DATE);
//        assertThat(testSalesOrderMaster.getDiscountPercentage()).isEqualTo(UPDATED_DISCOUNT_PERCENTAGE);
//        assertThat(testSalesOrderMaster.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
//        assertThat(testSalesOrderMaster.getUserField1()).isEqualTo(UPDATED_USER_FIELD_1);
//        assertThat(testSalesOrderMaster.getUserField2()).isEqualTo(UPDATED_USER_FIELD_2);
//        assertThat(testSalesOrderMaster.getUserField3()).isEqualTo(UPDATED_USER_FIELD_3);
//        assertThat(testSalesOrderMaster.getUserField4()).isEqualTo(UPDATED_USER_FIELD_4);
//        assertThat(testSalesOrderMaster.getReference()).isEqualTo(UPDATED_REFERENCE);
//        assertThat(testSalesOrderMaster.getWipStatus()).isEqualTo(UPDATED_WIP_STATUS);
//        assertThat(testSalesOrderMaster.getWipDaysInState()).isEqualTo(UPDATED_WIP_DAYS_IN_STATE);
//        assertThat(testSalesOrderMaster.getWipAssignedToId()).isEqualTo(UPDATED_WIP_ASSIGNED_TO_ID);
//        assertThat(testSalesOrderMaster.getWipDateNeeded()).isEqualTo(UPDATED_WIP_DATE_NEEDED);
//        assertThat(testSalesOrderMaster.getCompletedStatus()).isEqualTo(UPDATED_COMPLETED_STATUS);
//        assertThat(testSalesOrderMaster.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderMaster.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderMaster.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderMaster.getConfirmationById()).isEqualTo(UPDATED_CONFIRMATION_BY_ID);
//        assertThat(testSalesOrderMaster.getConfirmationByName()).isEqualTo(UPDATED_CONFIRMATION_BY_NAME);
//        assertThat(testSalesOrderMaster.getConfirmationDate()).isEqualTo(UPDATED_CONFIRMATION_DATE);
//        assertThat(testSalesOrderMaster.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderMaster.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void putNonExistingSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//        salesOrderMaster.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, salesOrderMaster.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithIdMismatchSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//        salesOrderMaster.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithMissingIdPathParamSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//        salesOrderMaster.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void partialUpdateSalesOrderMasterWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderMaster using partial update
//        SalesOrderMaster partialUpdatedSalesOrderMaster = new SalesOrderMaster();
//        partialUpdatedSalesOrderMaster.setId(salesOrderMaster.getId());
//
//        partialUpdatedSalesOrderMaster
//            .salesOderId(UPDATED_SALES_ODER_ID)
//            .salesOderNo(UPDATED_SALES_ODER_NO)
//            .patientId(UPDATED_PATIENT_ID)
//            .patientFirstName(UPDATED_PATIENT_FIRST_NAME)
//            .cityName(UPDATED_CITY_NAME)
//            .zipCode(UPDATED_ZIP_CODE)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientBranchId(UPDATED_PATIENT_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .deliveryScheduleDatetime(UPDATED_DELIVERY_SCHEDULE_DATETIME)
//            .deliveryAddressLine1(UPDATED_DELIVERY_ADDRESS_LINE_1)
//            .deliveryBranchId(UPDATED_DELIVERY_BRANCH_ID)
//            .taxZoneId(UPDATED_TAX_ZONE_ID)
//            .taxRate(UPDATED_TAX_RATE)
//            .salesOrderNote(UPDATED_SALES_ORDER_NOTE)
//            .deliveryNote(UPDATED_DELIVERY_NOTE)
//            .signatureRequiredStatus(UPDATED_SIGNATURE_REQUIRED_STATUS)
//            .podStatus(UPDATED_POD_STATUS)
//            .podLastMessage(UPDATED_POD_LAST_MESSAGE)
//            .podMessageDateTime(UPDATED_POD_MESSAGE_DATE_TIME)
//            .mutualHoldStatus(UPDATED_MUTUAL_HOLD_STATUS)
//            .holdStatus(UPDATED_HOLD_STATUS)
//            .holdReasonDescription(UPDATED_HOLD_REASON_DESCRIPTION)
//            .stopDate(UPDATED_STOP_DATE)
//            .orderStatus(UPDATED_ORDER_STATUS)
//            .admissionDate(UPDATED_ADMISSION_DATE)
//            .userField1(UPDATED_USER_FIELD_1)
//            .userField3(UPDATED_USER_FIELD_3)
//            .wipDaysInState(UPDATED_WIP_DAYS_IN_STATE)
//            .wipDateNeeded(UPDATED_WIP_DATE_NEEDED)
//            .completedStatus(UPDATED_COMPLETED_STATUS)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .confirmationByName(UPDATED_CONFIRMATION_BY_NAME)
//            .confirmationDate(UPDATED_CONFIRMATION_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID);
//
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderMaster.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderMaster testSalesOrderMaster = salesOrderMasterList.get(salesOrderMasterList.size() - 1);
//        assertThat(testSalesOrderMaster.getSalesOderId()).isEqualTo(UPDATED_SALES_ODER_ID);
//        assertThat(testSalesOrderMaster.getSalesOderNo()).isEqualTo(UPDATED_SALES_ODER_NO);
//        assertThat(testSalesOrderMaster.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderMaster.getPatientFirstName()).isEqualTo(UPDATED_PATIENT_FIRST_NAME);
//        assertThat(testSalesOrderMaster.getPatientMiddleName()).isEqualTo(DEFAULT_PATIENT_MIDDLE_NAME);
//        assertThat(testSalesOrderMaster.getPatientLastName()).isEqualTo(DEFAULT_PATIENT_LAST_NAME);
//        assertThat(testSalesOrderMaster.getPatientAddressId()).isEqualTo(DEFAULT_PATIENT_ADDRESS_ID);
//        assertThat(testSalesOrderMaster.getPatientAddressLine1()).isEqualTo(DEFAULT_PATIENT_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getPatientAddressLine2()).isEqualTo(DEFAULT_PATIENT_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getCityName()).isEqualTo(UPDATED_CITY_NAME);
//        assertThat(testSalesOrderMaster.getStateName()).isEqualTo(DEFAULT_STATE_NAME);
//        assertThat(testSalesOrderMaster.getZipCode()).isEqualTo(UPDATED_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getPatientContactId()).isEqualTo(DEFAULT_PATIENT_CONTACT_ID);
//        assertThat(testSalesOrderMaster.getPhone1()).isEqualTo(DEFAULT_PHONE_1);
//        assertThat(testSalesOrderMaster.getPhone2()).isEqualTo(DEFAULT_PHONE_2);
//        assertThat(testSalesOrderMaster.getPatientDob()).isEqualTo(DEFAULT_PATIENT_DOB);
//        assertThat(testSalesOrderMaster.getPatientHeight()).isEqualTo(UPDATED_PATIENT_HEIGHT);
//        assertThat(testSalesOrderMaster.getPatientWeight()).isEqualTo(DEFAULT_PATIENT_WEIGHT);
//        assertThat(testSalesOrderMaster.getPatientSsn()).isEqualTo(DEFAULT_PATIENT_SSN);
//        assertThat(testSalesOrderMaster.getPatientGender()).isEqualTo(UPDATED_PATIENT_GENDER);
//        assertThat(testSalesOrderMaster.getPatientBranchId()).isEqualTo(UPDATED_PATIENT_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getBranchName()).isEqualTo(UPDATED_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getPatientDod()).isEqualTo(DEFAULT_PATIENT_DOD);
//        assertThat(testSalesOrderMaster.getHipaaOnFileStatus()).isEqualTo(DEFAULT_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderMaster.getFacilityId()).isEqualTo(DEFAULT_FACILITY_ID);
//        assertThat(testSalesOrderMaster.getFacilityName()).isEqualTo(DEFAULT_FACILITY_NAME);
//        assertThat(testSalesOrderMaster.getFacilityNPI()).isEqualTo(DEFAULT_FACILITY_NPI);
//        assertThat(testSalesOrderMaster.getDeliveryScheduleDatetime()).isEqualTo(UPDATED_DELIVERY_SCHEDULE_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryActualDatetime()).isEqualTo(DEFAULT_DELIVERY_ACTUAL_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine1()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine2()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getDeliveryCityName()).isEqualTo(DEFAULT_DELIVERY_CITY_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryStateName()).isEqualTo(DEFAULT_DELIVERY_STATE_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryZipCode()).isEqualTo(DEFAULT_DELIVERY_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo1()).isEqualTo(DEFAULT_DELIVERY_PHONE_NO_1);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo2()).isEqualTo(DEFAULT_DELIVERY_PHONE_NO_2);
//        assertThat(testSalesOrderMaster.getDeliveryBranchId()).isEqualTo(UPDATED_DELIVERY_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getDeliveryBranchName()).isEqualTo(DEFAULT_DELIVERY_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getTaxZoneId()).isEqualTo(UPDATED_TAX_ZONE_ID);
//        assertThat(testSalesOrderMaster.getTaxRate()).isEqualTo(UPDATED_TAX_RATE);
//        assertThat(testSalesOrderMaster.getSalesOrderNote()).isEqualTo(UPDATED_SALES_ORDER_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryNote()).isEqualTo(UPDATED_DELIVERY_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryTechnician()).isEqualTo(DEFAULT_DELIVERY_TECHNICIAN);
//        assertThat(testSalesOrderMaster.getSignatureRequiredStatus()).isEqualTo(UPDATED_SIGNATURE_REQUIRED_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatus()).isEqualTo(UPDATED_POD_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatusDateTime()).isEqualTo(DEFAULT_POD_STATUS_DATE_TIME);
//        assertThat(testSalesOrderMaster.getPodLastMessage()).isEqualTo(UPDATED_POD_LAST_MESSAGE);
//        assertThat(testSalesOrderMaster.getPodMessageDateTime()).isEqualTo(UPDATED_POD_MESSAGE_DATE_TIME);
//        assertThat(testSalesOrderMaster.getMutualHoldStatus()).isEqualTo(UPDATED_MUTUAL_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonId()).isEqualTo(DEFAULT_HOLD_REASON_ID);
//        assertThat(testSalesOrderMaster.getHoldStatus()).isEqualTo(UPDATED_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonDescription()).isEqualTo(UPDATED_HOLD_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getStopDate()).isEqualTo(UPDATED_STOP_DATE);
//        assertThat(testSalesOrderMaster.getStopReasonId()).isEqualTo(DEFAULT_STOP_REASON_ID);
//        assertThat(testSalesOrderMaster.getStopReasonDescription()).isEqualTo(DEFAULT_STOP_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getInventoryLocationId()).isEqualTo(DEFAULT_INVENTORY_LOCATION_ID);
//        assertThat(testSalesOrderMaster.getOrderStatus()).isEqualTo(UPDATED_ORDER_STATUS);
//        assertThat(testSalesOrderMaster.getOrderClassificationId()).isEqualTo(DEFAULT_ORDER_CLASSIFICATION_ID);
//        assertThat(testSalesOrderMaster.getPosId()).isEqualTo(DEFAULT_POS_ID);
//        assertThat(testSalesOrderMaster.getPosName()).isEqualTo(DEFAULT_POS_NAME);
//        assertThat(testSalesOrderMaster.getAdmissionDate()).isEqualTo(UPDATED_ADMISSION_DATE);
//        assertThat(testSalesOrderMaster.getDischargeDate()).isEqualTo(DEFAULT_DISCHARGE_DATE);
//        assertThat(testSalesOrderMaster.getDiscountPercentage()).isEqualTo(DEFAULT_DISCOUNT_PERCENTAGE);
//        assertThat(testSalesOrderMaster.getPoNumber()).isEqualTo(DEFAULT_PO_NUMBER);
//        assertThat(testSalesOrderMaster.getUserField1()).isEqualTo(UPDATED_USER_FIELD_1);
//        assertThat(testSalesOrderMaster.getUserField2()).isEqualTo(DEFAULT_USER_FIELD_2);
//        assertThat(testSalesOrderMaster.getUserField3()).isEqualTo(UPDATED_USER_FIELD_3);
//        assertThat(testSalesOrderMaster.getUserField4()).isEqualTo(DEFAULT_USER_FIELD_4);
//        assertThat(testSalesOrderMaster.getReference()).isEqualTo(DEFAULT_REFERENCE);
//        assertThat(testSalesOrderMaster.getWipStatus()).isEqualTo(DEFAULT_WIP_STATUS);
//        assertThat(testSalesOrderMaster.getWipDaysInState()).isEqualTo(UPDATED_WIP_DAYS_IN_STATE);
//        assertThat(testSalesOrderMaster.getWipAssignedToId()).isEqualTo(DEFAULT_WIP_ASSIGNED_TO_ID);
//        assertThat(testSalesOrderMaster.getWipDateNeeded()).isEqualTo(UPDATED_WIP_DATE_NEEDED);
//        assertThat(testSalesOrderMaster.getCompletedStatus()).isEqualTo(UPDATED_COMPLETED_STATUS);
//        assertThat(testSalesOrderMaster.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderMaster.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderMaster.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderMaster.getConfirmationById()).isEqualTo(DEFAULT_CONFIRMATION_BY_ID);
//        assertThat(testSalesOrderMaster.getConfirmationByName()).isEqualTo(UPDATED_CONFIRMATION_BY_NAME);
//        assertThat(testSalesOrderMaster.getConfirmationDate()).isEqualTo(UPDATED_CONFIRMATION_DATE);
//        assertThat(testSalesOrderMaster.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderMaster.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void fullUpdateSalesOrderMasterWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderMaster using partial update
//        SalesOrderMaster partialUpdatedSalesOrderMaster = new SalesOrderMaster();
//        partialUpdatedSalesOrderMaster.setId(salesOrderMaster.getId());
//
//        partialUpdatedSalesOrderMaster
//            .salesOderId(UPDATED_SALES_ODER_ID)
//            .salesOderNo(UPDATED_SALES_ODER_NO)
//            .patientId(UPDATED_PATIENT_ID)
//            .patientFirstName(UPDATED_PATIENT_FIRST_NAME)
//            .patientMiddleName(UPDATED_PATIENT_MIDDLE_NAME)
//            .patientLastName(UPDATED_PATIENT_LAST_NAME)
//            .patientAddressId(UPDATED_PATIENT_ADDRESS_ID)
//            .patientAddressLine1(UPDATED_PATIENT_ADDRESS_LINE_1)
//            .patientAddressLine2(UPDATED_PATIENT_ADDRESS_LINE_2)
//            .cityName(UPDATED_CITY_NAME)
//            .stateName(UPDATED_STATE_NAME)
//            .zipCode(UPDATED_ZIP_CODE)
//            .patientContactId(UPDATED_PATIENT_CONTACT_ID)
//            .phone1(UPDATED_PHONE_1)
//            .phone2(UPDATED_PHONE_2)
//            .patientDob(UPDATED_PATIENT_DOB)
//            .patientHeight(UPDATED_PATIENT_HEIGHT)
//            .patientWeight(UPDATED_PATIENT_WEIGHT)
//            .patientSsn(UPDATED_PATIENT_SSN)
//            .patientGender(UPDATED_PATIENT_GENDER)
//            .patientBranchId(UPDATED_PATIENT_BRANCH_ID)
//            .branchName(UPDATED_BRANCH_NAME)
//            .patientDod(UPDATED_PATIENT_DOD)
//            .hipaaOnFileStatus(UPDATED_HIPAA_ON_FILE_STATUS)
//            .facilityId(UPDATED_FACILITY_ID)
//            .facilityName(UPDATED_FACILITY_NAME)
//            .facilityNPI(UPDATED_FACILITY_NPI)
//            .deliveryScheduleDatetime(UPDATED_DELIVERY_SCHEDULE_DATETIME)
//            .deliveryActualDatetime(UPDATED_DELIVERY_ACTUAL_DATETIME)
//            .deliveryAddressLine1(UPDATED_DELIVERY_ADDRESS_LINE_1)
//            .deliveryAddressLine2(UPDATED_DELIVERY_ADDRESS_LINE_2)
//            .deliveryCityName(UPDATED_DELIVERY_CITY_NAME)
//            .deliveryStateName(UPDATED_DELIVERY_STATE_NAME)
//            .deliveryZipCode(UPDATED_DELIVERY_ZIP_CODE)
//            .deliveryPhoneNo1(UPDATED_DELIVERY_PHONE_NO_1)
//            .deliveryPhoneNo2(UPDATED_DELIVERY_PHONE_NO_2)
//            .deliveryBranchId(UPDATED_DELIVERY_BRANCH_ID)
//            .deliveryBranchName(UPDATED_DELIVERY_BRANCH_NAME)
//            .taxZoneId(UPDATED_TAX_ZONE_ID)
//            .taxRate(UPDATED_TAX_RATE)
//            .salesOrderNote(UPDATED_SALES_ORDER_NOTE)
//            .deliveryNote(UPDATED_DELIVERY_NOTE)
//            .deliveryTechnician(UPDATED_DELIVERY_TECHNICIAN)
//            .signatureRequiredStatus(UPDATED_SIGNATURE_REQUIRED_STATUS)
//            .podStatus(UPDATED_POD_STATUS)
//            .podStatusDateTime(UPDATED_POD_STATUS_DATE_TIME)
//            .podLastMessage(UPDATED_POD_LAST_MESSAGE)
//            .podMessageDateTime(UPDATED_POD_MESSAGE_DATE_TIME)
//            .mutualHoldStatus(UPDATED_MUTUAL_HOLD_STATUS)
//            .holdReasonId(UPDATED_HOLD_REASON_ID)
//            .holdStatus(UPDATED_HOLD_STATUS)
//            .holdReasonDescription(UPDATED_HOLD_REASON_DESCRIPTION)
//            .stopDate(UPDATED_STOP_DATE)
//            .stopReasonId(UPDATED_STOP_REASON_ID)
//            .stopReasonDescription(UPDATED_STOP_REASON_DESCRIPTION)
//            .inventoryLocationId(UPDATED_INVENTORY_LOCATION_ID)
//            .orderStatus(UPDATED_ORDER_STATUS)
//            .orderClassificationId(UPDATED_ORDER_CLASSIFICATION_ID)
//            .posId(UPDATED_POS_ID)
//            .posName(UPDATED_POS_NAME)
//            .admissionDate(UPDATED_ADMISSION_DATE)
//            .dischargeDate(UPDATED_DISCHARGE_DATE)
//            .discountPercentage(UPDATED_DISCOUNT_PERCENTAGE)
//            .poNumber(UPDATED_PO_NUMBER)
//            .userField1(UPDATED_USER_FIELD_1)
//            .userField2(UPDATED_USER_FIELD_2)
//            .userField3(UPDATED_USER_FIELD_3)
//            .userField4(UPDATED_USER_FIELD_4)
//            .reference(UPDATED_REFERENCE)
//            .wipStatus(UPDATED_WIP_STATUS)
//            .wipDaysInState(UPDATED_WIP_DAYS_IN_STATE)
//            .wipAssignedToId(UPDATED_WIP_ASSIGNED_TO_ID)
//            .wipDateNeeded(UPDATED_WIP_DATE_NEEDED)
//            .completedStatus(UPDATED_COMPLETED_STATUS)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .confirmationById(UPDATED_CONFIRMATION_BY_ID)
//            .confirmationByName(UPDATED_CONFIRMATION_BY_NAME)
//            .confirmationDate(UPDATED_CONFIRMATION_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderMaster.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderMaster testSalesOrderMaster = salesOrderMasterList.get(salesOrderMasterList.size() - 1);
//        assertThat(testSalesOrderMaster.getSalesOderId()).isEqualTo(UPDATED_SALES_ODER_ID);
//        assertThat(testSalesOrderMaster.getSalesOderNo()).isEqualTo(UPDATED_SALES_ODER_NO);
//        assertThat(testSalesOrderMaster.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderMaster.getPatientFirstName()).isEqualTo(UPDATED_PATIENT_FIRST_NAME);
//        assertThat(testSalesOrderMaster.getPatientMiddleName()).isEqualTo(UPDATED_PATIENT_MIDDLE_NAME);
//        assertThat(testSalesOrderMaster.getPatientLastName()).isEqualTo(UPDATED_PATIENT_LAST_NAME);
//        assertThat(testSalesOrderMaster.getPatientAddressId()).isEqualTo(UPDATED_PATIENT_ADDRESS_ID);
//        assertThat(testSalesOrderMaster.getPatientAddressLine1()).isEqualTo(UPDATED_PATIENT_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getPatientAddressLine2()).isEqualTo(UPDATED_PATIENT_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getCityName()).isEqualTo(UPDATED_CITY_NAME);
//        assertThat(testSalesOrderMaster.getStateName()).isEqualTo(UPDATED_STATE_NAME);
//        assertThat(testSalesOrderMaster.getZipCode()).isEqualTo(UPDATED_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getPatientContactId()).isEqualTo(UPDATED_PATIENT_CONTACT_ID);
//        assertThat(testSalesOrderMaster.getPhone1()).isEqualTo(UPDATED_PHONE_1);
//        assertThat(testSalesOrderMaster.getPhone2()).isEqualTo(UPDATED_PHONE_2);
//        assertThat(testSalesOrderMaster.getPatientDob()).isEqualTo(UPDATED_PATIENT_DOB);
//        assertThat(testSalesOrderMaster.getPatientHeight()).isEqualTo(UPDATED_PATIENT_HEIGHT);
//        assertThat(testSalesOrderMaster.getPatientWeight()).isEqualTo(UPDATED_PATIENT_WEIGHT);
//        assertThat(testSalesOrderMaster.getPatientSsn()).isEqualTo(UPDATED_PATIENT_SSN);
//        assertThat(testSalesOrderMaster.getPatientGender()).isEqualTo(UPDATED_PATIENT_GENDER);
//        assertThat(testSalesOrderMaster.getPatientBranchId()).isEqualTo(UPDATED_PATIENT_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getBranchName()).isEqualTo(UPDATED_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getPatientDod()).isEqualTo(UPDATED_PATIENT_DOD);
//        assertThat(testSalesOrderMaster.getHipaaOnFileStatus()).isEqualTo(UPDATED_HIPAA_ON_FILE_STATUS);
//        assertThat(testSalesOrderMaster.getFacilityId()).isEqualTo(UPDATED_FACILITY_ID);
//        assertThat(testSalesOrderMaster.getFacilityName()).isEqualTo(UPDATED_FACILITY_NAME);
//        assertThat(testSalesOrderMaster.getFacilityNPI()).isEqualTo(UPDATED_FACILITY_NPI);
//        assertThat(testSalesOrderMaster.getDeliveryScheduleDatetime()).isEqualTo(UPDATED_DELIVERY_SCHEDULE_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryActualDatetime()).isEqualTo(UPDATED_DELIVERY_ACTUAL_DATETIME);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine1()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_1);
//        assertThat(testSalesOrderMaster.getDeliveryAddressLine2()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_2);
//        assertThat(testSalesOrderMaster.getDeliveryCityName()).isEqualTo(UPDATED_DELIVERY_CITY_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryStateName()).isEqualTo(UPDATED_DELIVERY_STATE_NAME);
//        assertThat(testSalesOrderMaster.getDeliveryZipCode()).isEqualTo(UPDATED_DELIVERY_ZIP_CODE);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo1()).isEqualTo(UPDATED_DELIVERY_PHONE_NO_1);
//        assertThat(testSalesOrderMaster.getDeliveryPhoneNo2()).isEqualTo(UPDATED_DELIVERY_PHONE_NO_2);
//        assertThat(testSalesOrderMaster.getDeliveryBranchId()).isEqualTo(UPDATED_DELIVERY_BRANCH_ID);
//        assertThat(testSalesOrderMaster.getDeliveryBranchName()).isEqualTo(UPDATED_DELIVERY_BRANCH_NAME);
//        assertThat(testSalesOrderMaster.getTaxZoneId()).isEqualTo(UPDATED_TAX_ZONE_ID);
//        assertThat(testSalesOrderMaster.getTaxRate()).isEqualTo(UPDATED_TAX_RATE);
//        assertThat(testSalesOrderMaster.getSalesOrderNote()).isEqualTo(UPDATED_SALES_ORDER_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryNote()).isEqualTo(UPDATED_DELIVERY_NOTE);
//        assertThat(testSalesOrderMaster.getDeliveryTechnician()).isEqualTo(UPDATED_DELIVERY_TECHNICIAN);
//        assertThat(testSalesOrderMaster.getSignatureRequiredStatus()).isEqualTo(UPDATED_SIGNATURE_REQUIRED_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatus()).isEqualTo(UPDATED_POD_STATUS);
//        assertThat(testSalesOrderMaster.getPodStatusDateTime()).isEqualTo(UPDATED_POD_STATUS_DATE_TIME);
//        assertThat(testSalesOrderMaster.getPodLastMessage()).isEqualTo(UPDATED_POD_LAST_MESSAGE);
//        assertThat(testSalesOrderMaster.getPodMessageDateTime()).isEqualTo(UPDATED_POD_MESSAGE_DATE_TIME);
//        assertThat(testSalesOrderMaster.getMutualHoldStatus()).isEqualTo(UPDATED_MUTUAL_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonId()).isEqualTo(UPDATED_HOLD_REASON_ID);
//        assertThat(testSalesOrderMaster.getHoldStatus()).isEqualTo(UPDATED_HOLD_STATUS);
//        assertThat(testSalesOrderMaster.getHoldReasonDescription()).isEqualTo(UPDATED_HOLD_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getStopDate()).isEqualTo(UPDATED_STOP_DATE);
//        assertThat(testSalesOrderMaster.getStopReasonId()).isEqualTo(UPDATED_STOP_REASON_ID);
//        assertThat(testSalesOrderMaster.getStopReasonDescription()).isEqualTo(UPDATED_STOP_REASON_DESCRIPTION);
//        assertThat(testSalesOrderMaster.getInventoryLocationId()).isEqualTo(UPDATED_INVENTORY_LOCATION_ID);
//        assertThat(testSalesOrderMaster.getOrderStatus()).isEqualTo(UPDATED_ORDER_STATUS);
//        assertThat(testSalesOrderMaster.getOrderClassificationId()).isEqualTo(UPDATED_ORDER_CLASSIFICATION_ID);
//        assertThat(testSalesOrderMaster.getPosId()).isEqualTo(UPDATED_POS_ID);
//        assertThat(testSalesOrderMaster.getPosName()).isEqualTo(UPDATED_POS_NAME);
//        assertThat(testSalesOrderMaster.getAdmissionDate()).isEqualTo(UPDATED_ADMISSION_DATE);
//        assertThat(testSalesOrderMaster.getDischargeDate()).isEqualTo(UPDATED_DISCHARGE_DATE);
//        assertThat(testSalesOrderMaster.getDiscountPercentage()).isEqualTo(UPDATED_DISCOUNT_PERCENTAGE);
//        assertThat(testSalesOrderMaster.getPoNumber()).isEqualTo(UPDATED_PO_NUMBER);
//        assertThat(testSalesOrderMaster.getUserField1()).isEqualTo(UPDATED_USER_FIELD_1);
//        assertThat(testSalesOrderMaster.getUserField2()).isEqualTo(UPDATED_USER_FIELD_2);
//        assertThat(testSalesOrderMaster.getUserField3()).isEqualTo(UPDATED_USER_FIELD_3);
//        assertThat(testSalesOrderMaster.getUserField4()).isEqualTo(UPDATED_USER_FIELD_4);
//        assertThat(testSalesOrderMaster.getReference()).isEqualTo(UPDATED_REFERENCE);
//        assertThat(testSalesOrderMaster.getWipStatus()).isEqualTo(UPDATED_WIP_STATUS);
//        assertThat(testSalesOrderMaster.getWipDaysInState()).isEqualTo(UPDATED_WIP_DAYS_IN_STATE);
//        assertThat(testSalesOrderMaster.getWipAssignedToId()).isEqualTo(UPDATED_WIP_ASSIGNED_TO_ID);
//        assertThat(testSalesOrderMaster.getWipDateNeeded()).isEqualTo(UPDATED_WIP_DATE_NEEDED);
//        assertThat(testSalesOrderMaster.getCompletedStatus()).isEqualTo(UPDATED_COMPLETED_STATUS);
//        assertThat(testSalesOrderMaster.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderMaster.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderMaster.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderMaster.getConfirmationById()).isEqualTo(UPDATED_CONFIRMATION_BY_ID);
//        assertThat(testSalesOrderMaster.getConfirmationByName()).isEqualTo(UPDATED_CONFIRMATION_BY_NAME);
//        assertThat(testSalesOrderMaster.getConfirmationDate()).isEqualTo(UPDATED_CONFIRMATION_DATE);
//        assertThat(testSalesOrderMaster.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderMaster.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderMaster.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void patchNonExistingSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//        salesOrderMaster.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, salesOrderMaster.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithIdMismatchSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//        salesOrderMaster.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithMissingIdPathParamSalesOrderMaster() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderMasterRepository.findAll().collectList().block().size();
//        salesOrderMaster.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderMaster))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderMaster in the database
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void deleteSalesOrderMaster() {
//        // Initialize the database
//        salesOrderMasterRepository.save(salesOrderMaster).block();
//
//        int databaseSizeBeforeDelete = salesOrderMasterRepository.findAll().collectList().block().size();
//
//        // Delete the salesOrderMaster
//        webTestClient
//            .delete()
//            .uri(ENTITY_API_URL_ID, salesOrderMaster.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isNoContent();
//
//        // Validate the database contains one less item
//        List<SalesOrderMaster> salesOrderMasterList = salesOrderMasterRepository.findAll().collectList().block();
//        assertThat(salesOrderMasterList).hasSize(databaseSizeBeforeDelete - 1);
//    }
}
