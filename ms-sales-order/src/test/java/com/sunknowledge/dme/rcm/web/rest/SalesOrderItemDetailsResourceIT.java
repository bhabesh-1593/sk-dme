package com.sunknowledge.dme.rcm.web.rest;

import static com.sunknowledge.dme.rcm.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

import com.sunknowledge.dme.rcm.IntegrationTest;
import com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails;
import com.sunknowledge.dme.rcm.repository.EntityManager;
import com.sunknowledge.dme.rcm.repository.SalesOrderItemDetailsRepository;
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
 * Integration tests for the {@link SalesOrderItemDetailsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class SalesOrderItemDetailsResourceIT {

//    private static final Integer DEFAULT_SALES_ORDER_ITEM_DETAILS_ID = 1;
//    private static final Integer UPDATED_SALES_ORDER_ITEM_DETAILS_ID = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_ID = 1;
//    private static final Integer UPDATED_SALES_ORDER_ID = 2;
//
//    private static final Integer DEFAULT_PATIENT_ID = 1;
//    private static final Integer UPDATED_PATIENT_ID = 2;
//
//    private static final Integer DEFAULT_ITEM_LOCATION_ID = 1;
//    private static final Integer UPDATED_ITEM_LOCATION_ID = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_ITEM_ID = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_ITEM_ID = 2;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_DESCRIPTION = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_DEFAULT_VENDOR = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SALES_ORDER_DETAIL_ORIGINAL_DOS = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_SALES_ORDER_DETAIL_NEXT_BILLING_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_SALES_ORDER_DETAIL_DOS_TO = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SALES_ORDER_DETAIL_DOS_TO = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_NEXT_PERIOD = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SPECIAL_PRICING = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_PRICE_OVERRIDE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_QTY = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_QTY = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_BQTY = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_BQTY = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_LINE_QTY = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_LINE_QTY = 2;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_PROC_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_PROC_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MODIFIER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MODIFIER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MODIFIER_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MODIFIER_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MODIFIER_4 = "BBBBBBBBBB";
//
//    private static final Double DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT = 1D;
//    private static final Double UPDATED_SALES_ORDER_DETAIL_CHARGE_AMT = 2D;
//
//    private static final Double DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT = 1D;
//    private static final Double UPDATED_SALES_ORDER_DETAIL_ALLOWED_AMT = 2D;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_TAXABLE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_TAXABLE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN_UPGRADE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SALES_ORDER_DETAIL_ABN_PRINT_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN_ITEM = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN_PROC_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN_ALLOW = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_ABN_CHARGE = 2;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_2 = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_TAX_RATE = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_TAX_RATE = 2;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_TAX_ZONE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_TAX_ZONE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_NON_TAX_REASON = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_NOTE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_NOTE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SALE_TYPE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_GROUP = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_USER_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_4 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP = "BBBBBBBBBB";
//
//    private static final Double DEFAULT_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT = 1D;
//    private static final Double UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT = 2D;
//
//    private static final Double DEFAULT_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT = 1D;
//    private static final Double UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT = 2D;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_3 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_4 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4 = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_MCTP_PERIOD = 2;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4 = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_PRICE_TABLE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION_NAME = "BBBBBBBBBB";
//
//    private static final Double DEFAULT_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT = 1D;
//    private static final Double UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT = 2D;
//
//    private static final Double DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT = 1D;
//    private static final Double UPDATED_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT = 2D;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_ITEM_NDC_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MANUFACTURER = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_CB_PRICING = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_CB_PRICING = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_CB_OVERRIDE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MESSAGES = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MESSAGES = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_LOCATION = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_LOCATION = 2;
//
//    private static final Integer DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY = 1;
//    private static final Integer UPDATED_SALES_ORDER_DETAIL_CALORIES_PER_DAY = 2;
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4 = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4 = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING = "BBBBBBBBBB";
//
//    private static final String DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER = "AAAAAAAAAA";
//    private static final String UPDATED_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_CMN_ID = 1;
//    private static final Integer UPDATED_CMN_ID = 2;
//
//    private static final Integer DEFAULT_CMNPAR_CMN_FORM_ID = 1;
//    private static final Integer UPDATED_CMNPAR_CMN_FORM_ID = 2;
//
//    private static final String DEFAULT_CMNPAR_CMN_KEY = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_CMN_KEY = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_CREATE_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_CREATE_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_EXPIRATION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_EXPIRATION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_INITIAL_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_INITIAL_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_RENEWAL_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_RENEWAL_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_RECERTIFICATION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_PHYSICIAN_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_PHYSICIAN_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_CMNPAR_CMN_STATUS = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_CMN_STATUS = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_CMNPAR_PAR_ID = 1;
//    private static final Integer UPDATED_CMNPAR_PAR_ID = 2;
//
//    private static final String DEFAULT_CMNPAR_PAR_DESCR = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_PAR_DESCR = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_CMNPAR_PAR_INITIAL_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_PAR_INITIAL_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_PAR_EXPIRATION_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_PAR_EXPIRATION_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_LOG_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_LOG_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final Integer DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED = 1;
//    private static final Integer UPDATED_CMNPAR_CMN_LENGTH_OF_NEED = 2;
//
//    private static final LocalDate DEFAULT_CMNPAR_CMN_PRINTED_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_CMN_PRINTED_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_CMNPAR_CMN_PRINTED_BY = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_CMN_PRINTED_BY = "BBBBBBBBBB";
//
//    private static final LocalDate DEFAULT_CMNPAR_FAXED_DATE = LocalDate.ofEpochDay(0L);
//    private static final LocalDate UPDATED_CMNPAR_FAXED_DATE = LocalDate.now(ZoneId.systemDefault());
//
//    private static final String DEFAULT_CMNPAR_CMN_PLACEHOLDER = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_CMN_PLACEHOLDER = "BBBBBBBBBB";
//
//    private static final String DEFAULT_CMNPAR_CMN_FAXED_BY = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_CMN_FAXED_BY = "BBBBBBBBBB";
//
//    private static final String DEFAULT_CMNPAR_CMN_LOGGED_BY = "AAAAAAAAAA";
//    private static final String UPDATED_CMNPAR_CMN_LOGGED_BY = "BBBBBBBBBB";
//
//    private static final Integer DEFAULT_CMNPAR_NUMBER_OF_REFILLS = 1;
//    private static final Integer UPDATED_CMNPAR_NUMBER_OF_REFILLS = 2;
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
//    private static final String ENTITY_API_URL = "/api/sales-order-item-details";
//    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
//
//    private static Random random = new Random();
//    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
//
//    @Autowired
//    private SalesOrderItemDetailsRepository salesOrderItemDetailsRepository;
//
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    private SalesOrderItemDetails salesOrderItemDetails;
//
//    /**
//     * Create an entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static SalesOrderItemDetails createEntity(EntityManager em) {
//        SalesOrderItemDetails salesOrderItemDetails = new SalesOrderItemDetails()
//            .salesOrderItemDetailsId(DEFAULT_SALES_ORDER_ITEM_DETAILS_ID)
//            .salesOrderId(DEFAULT_SALES_ORDER_ID)
//            .patientId(DEFAULT_PATIENT_ID)
//            .itemLocationId(DEFAULT_ITEM_LOCATION_ID)
//            .salesOrderDetailItemId(DEFAULT_SALES_ORDER_DETAIL_ITEM_ID)
//            .salesOrderDetailItemName(DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME)
//            .salesOrderDetailStockingUom(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM)
//            .salesOrderDetailStockingUomName(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME)
//            .salesOrderDetailItemDescription(DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION)
//            .salesOrderDetailDefaultVendor(DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR)
//            .salesOrderDetailOriginalDos(DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS)
//            .salesOrderDetailPreviousBillingDate(DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE)
//            .salesOrderDetailNextBillingDate(DEFAULT_SALES_ORDER_DETAIL_NEXT_BILLING_DATE)
//            .salesOrderDetailDosTo(DEFAULT_SALES_ORDER_DETAIL_DOS_TO)
//            .salesOrderDetailNextPeriod(DEFAULT_SALES_ORDER_DETAIL_NEXT_PERIOD)
//            .salesOrderDetailSpecialPricing(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING)
//            .salesOrderDetailPriceOverride(DEFAULT_SALES_ORDER_DETAIL_PRICE_OVERRIDE)
//            .salesOrderDetailSpecialTaxRate(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE)
//            .salesOrderDetailQty(DEFAULT_SALES_ORDER_DETAIL_QTY)
//            .salesOrderDetailBqty(DEFAULT_SALES_ORDER_DETAIL_BQTY)
//            .salesOrderDetailLineQty(DEFAULT_SALES_ORDER_DETAIL_LINE_QTY)
//            .salesOrderDetailProcCode(DEFAULT_SALES_ORDER_DETAIL_PROC_CODE)
//            .salesOrderDetailPriceOption(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION)
//            .salesOrderDetailModifier1(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1)
//            .salesOrderDetailModifier2(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_2)
//            .salesOrderDetailModifier3(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3)
//            .salesOrderDetailModifier4(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4)
//            .salesOrderDetailChargeAmt(DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT)
//            .salesOrderDetailAllowedAmt(DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT)
//            .salesOrderDetailTaxable(DEFAULT_SALES_ORDER_DETAIL_TAXABLE)
//            .salesOrderDetailAbn(DEFAULT_SALES_ORDER_DETAIL_ABN)
//            .salesOrderDetailAbnUpgrade(DEFAULT_SALES_ORDER_DETAIL_ABN_UPGRADE)
//            .salesOrderDetailAbnPrintDate(DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE)
//            .salesOrderDetailAbnItem(DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM)
//            .salesOrderDetailAbnProcCode(DEFAULT_SALES_ORDER_DETAIL_ABN_PROC_CODE)
//            .salesOrderDetailAbnAllow(DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW)
//            .salesOrderDetailAbnCharge(DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE)
//            .salesOrderDetailAbnModifier1(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_1)
//            .salesOrderDetailAbnModifier2(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2)
//            .salesOrderDetailTaxRate(DEFAULT_SALES_ORDER_DETAIL_TAX_RATE)
//            .salesOrderDetailTaxZone(DEFAULT_SALES_ORDER_DETAIL_TAX_ZONE)
//            .salesOrderDetailNonTaxReason(DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON)
//            .salesOrderDetailNote(DEFAULT_SALES_ORDER_DETAIL_NOTE)
//            .salesOrderDetailSaleType(DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE)
//            .salesOrderDetailItemGroup(DEFAULT_SALES_ORDER_DETAIL_ITEM_GROUP)
//            .salesOrderDetailItemUser1(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_1)
//            .salesOrderDetailItemUser2(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_2)
//            .salesOrderDetailItemUser3(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3)
//            .salesOrderDetailItemUser4(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_4)
//            .salesOrderDetailConvertedToPurchase(DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE)
//            .salesOrderDetailManualConvertToPurchaseMctp(DEFAULT_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP)
//            .salesOrderDetailMctpChargeAmt(DEFAULT_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT)
//            .salesOrderDetailMctpAllowedAmt(DEFAULT_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT)
//            .salesOrderDetailMctpModifier1(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1)
//            .salesOrderDetailMctpModifier2(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_2)
//            .salesOrderDetailMctpModifier3(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_3)
//            .salesOrderDetailMctpModifier4(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_4)
//            .salesOrderDetailMctpPeriod(DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD)
//            .salesOrderDetailAddtlModifier1(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1)
//            .salesOrderDetailAddtlModifier2(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2)
//            .salesOrderDetailAddtlModifier3(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3)
//            .salesOrderDetailAddtlModifier4(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4)
//            .salesOrderDetailNextDateOfService(DEFAULT_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE)
//            .salesOrderDetailPriceTable(DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE)
//            .salesOrderDetailPriceOptionName(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME)
//            .salesOrderDetailExtendedChargeAmount(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT)
//            .salesOrderDetailExtendedAllowanceAmount(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT)
//            .salesOrderDetailItemNdcCode(DEFAULT_SALES_ORDER_DETAIL_ITEM_NDC_CODE)
//            .salesOrderDetailManufacturer(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER)
//            .salesOrderDetailCbPricing(DEFAULT_SALES_ORDER_DETAIL_CB_PRICING)
//            .salesOrderDetailCbPriceTableOverride(DEFAULT_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE)
//            .salesOrderDetailCbOverride(DEFAULT_SALES_ORDER_DETAIL_CB_OVERRIDE)
//            .salesOrderDetailMessages(DEFAULT_SALES_ORDER_DETAIL_MESSAGES)
//            .salesOrderDetailLocation(DEFAULT_SALES_ORDER_DETAIL_LOCATION)
//            .salesOrderDetailCaloriesPerDay(DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY)
//            .salesOrderDetailSecondaryBillingProcudureCode(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE)
//            .salesOrderDetailSecondaryBillingPriceOption(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION)
//            .salesOrderDetailSecondaryBillingPriceOptionName(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME)
//            .salesOrderDetailSecondaryBillingModifier1(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingModifier2(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingModifier3(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingModifier4(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingAdditionalModifier1(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingadditionalModifier2(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingadditionalModifier3(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingadditionalModifier4(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingIgnore(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE)
//            .salesOrderDetailSecondarySpecialBilling(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING)
//            .salesOrderDetailSpanDateSplitBilling(DEFAULT_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING)
//            .salesOrderDetailManufacturerItemIdNumber(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER)
//            .cmnId(DEFAULT_CMN_ID)
//            .cmnparCmnFormId(DEFAULT_CMNPAR_CMN_FORM_ID)
//            .cmnparCmnKey(DEFAULT_CMNPAR_CMN_KEY)
//            .cmnparCmnCreateDate(DEFAULT_CMNPAR_CMN_CREATE_DATE)
//            .cmnparCmnExpirationDate(DEFAULT_CMNPAR_CMN_EXPIRATION_DATE)
//            .cmnparCmnInitialDate(DEFAULT_CMNPAR_CMN_INITIAL_DATE)
//            .cmnparCmnRenewalDate(DEFAULT_CMNPAR_CMN_RENEWAL_DATE)
//            .cmnparCmnRecertificationDate(DEFAULT_CMNPAR_CMN_RECERTIFICATION_DATE)
//            .cmnparCmnPhysicianDate(DEFAULT_CMNPAR_CMN_PHYSICIAN_DATE)
//            .cmnparCmnStatus(DEFAULT_CMNPAR_CMN_STATUS)
//            .cmnparParId(DEFAULT_CMNPAR_PAR_ID)
//            .cmnparParDescr(DEFAULT_CMNPAR_PAR_DESCR)
//            .cmnparParInitialDate(DEFAULT_CMNPAR_PAR_INITIAL_DATE)
//            .cmnparParExpirationDate(DEFAULT_CMNPAR_PAR_EXPIRATION_DATE)
//            .cmnparCmnLogDate(DEFAULT_CMNPAR_CMN_LOG_DATE)
//            .cmnparCmnLengthOfNeed(DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED)
//            .cmnparCmnPrintedDate(DEFAULT_CMNPAR_CMN_PRINTED_DATE)
//            .cmnparCmnPrintedBy(DEFAULT_CMNPAR_CMN_PRINTED_BY)
//            .cmnparFaxedDate(DEFAULT_CMNPAR_FAXED_DATE)
//            .cmnparCmnPlaceholder(DEFAULT_CMNPAR_CMN_PLACEHOLDER)
//            .cmnparCmnFaxedBy(DEFAULT_CMNPAR_CMN_FAXED_BY)
//            .cmnparCmnLoggedBy(DEFAULT_CMNPAR_CMN_LOGGED_BY)
//            .cmnparNumberOfRefills(DEFAULT_CMNPAR_NUMBER_OF_REFILLS)
//            .status(DEFAULT_STATUS)
//            .createdById(DEFAULT_CREATED_BY_ID)
//            .createdByName(DEFAULT_CREATED_BY_NAME)
//            .createdDate(DEFAULT_CREATED_DATE)
//            .updatedById(DEFAULT_UPDATED_BY_ID)
//            .updatedByName(DEFAULT_UPDATED_BY_NAME)
//            .updatedDate(DEFAULT_UPDATED_DATE);
//        return salesOrderItemDetails;
//    }
//
//    /**
//     * Create an updated entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static SalesOrderItemDetails createUpdatedEntity(EntityManager em) {
//        SalesOrderItemDetails salesOrderItemDetails = new SalesOrderItemDetails()
//            .salesOrderItemDetailsId(UPDATED_SALES_ORDER_ITEM_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .itemLocationId(UPDATED_ITEM_LOCATION_ID)
//            .salesOrderDetailItemId(UPDATED_SALES_ORDER_DETAIL_ITEM_ID)
//            .salesOrderDetailItemName(UPDATED_SALES_ORDER_DETAIL_ITEM_NAME)
//            .salesOrderDetailStockingUom(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM)
//            .salesOrderDetailStockingUomName(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM_NAME)
//            .salesOrderDetailItemDescription(UPDATED_SALES_ORDER_DETAIL_ITEM_DESCRIPTION)
//            .salesOrderDetailDefaultVendor(UPDATED_SALES_ORDER_DETAIL_DEFAULT_VENDOR)
//            .salesOrderDetailOriginalDos(UPDATED_SALES_ORDER_DETAIL_ORIGINAL_DOS)
//            .salesOrderDetailPreviousBillingDate(UPDATED_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE)
//            .salesOrderDetailNextBillingDate(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE)
//            .salesOrderDetailDosTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO)
//            .salesOrderDetailNextPeriod(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD)
//            .salesOrderDetailSpecialPricing(UPDATED_SALES_ORDER_DETAIL_SPECIAL_PRICING)
//            .salesOrderDetailPriceOverride(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE)
//            .salesOrderDetailSpecialTaxRate(UPDATED_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE)
//            .salesOrderDetailQty(UPDATED_SALES_ORDER_DETAIL_QTY)
//            .salesOrderDetailBqty(UPDATED_SALES_ORDER_DETAIL_BQTY)
//            .salesOrderDetailLineQty(UPDATED_SALES_ORDER_DETAIL_LINE_QTY)
//            .salesOrderDetailProcCode(UPDATED_SALES_ORDER_DETAIL_PROC_CODE)
//            .salesOrderDetailPriceOption(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION)
//            .salesOrderDetailModifier1(UPDATED_SALES_ORDER_DETAIL_MODIFIER_1)
//            .salesOrderDetailModifier2(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2)
//            .salesOrderDetailModifier3(UPDATED_SALES_ORDER_DETAIL_MODIFIER_3)
//            .salesOrderDetailModifier4(UPDATED_SALES_ORDER_DETAIL_MODIFIER_4)
//            .salesOrderDetailChargeAmt(UPDATED_SALES_ORDER_DETAIL_CHARGE_AMT)
//            .salesOrderDetailAllowedAmt(UPDATED_SALES_ORDER_DETAIL_ALLOWED_AMT)
//            .salesOrderDetailTaxable(UPDATED_SALES_ORDER_DETAIL_TAXABLE)
//            .salesOrderDetailAbn(UPDATED_SALES_ORDER_DETAIL_ABN)
//            .salesOrderDetailAbnUpgrade(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE)
//            .salesOrderDetailAbnPrintDate(UPDATED_SALES_ORDER_DETAIL_ABN_PRINT_DATE)
//            .salesOrderDetailAbnItem(UPDATED_SALES_ORDER_DETAIL_ABN_ITEM)
//            .salesOrderDetailAbnProcCode(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE)
//            .salesOrderDetailAbnAllow(UPDATED_SALES_ORDER_DETAIL_ABN_ALLOW)
//            .salesOrderDetailAbnCharge(UPDATED_SALES_ORDER_DETAIL_ABN_CHARGE)
//            .salesOrderDetailAbnModifier1(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1)
//            .salesOrderDetailAbnModifier2(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_2)
//            .salesOrderDetailTaxRate(UPDATED_SALES_ORDER_DETAIL_TAX_RATE)
//            .salesOrderDetailTaxZone(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE)
//            .salesOrderDetailNonTaxReason(UPDATED_SALES_ORDER_DETAIL_NON_TAX_REASON)
//            .salesOrderDetailNote(UPDATED_SALES_ORDER_DETAIL_NOTE)
//            .salesOrderDetailSaleType(UPDATED_SALES_ORDER_DETAIL_SALE_TYPE)
//            .salesOrderDetailItemGroup(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP)
//            .salesOrderDetailItemUser1(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1)
//            .salesOrderDetailItemUser2(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2)
//            .salesOrderDetailItemUser3(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_3)
//            .salesOrderDetailItemUser4(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4)
//            .salesOrderDetailConvertedToPurchase(UPDATED_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE)
//            .salesOrderDetailManualConvertToPurchaseMctp(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP)
//            .salesOrderDetailMctpChargeAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT)
//            .salesOrderDetailMctpAllowedAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT)
//            .salesOrderDetailMctpModifier1(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_1)
//            .salesOrderDetailMctpModifier2(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2)
//            .salesOrderDetailMctpModifier3(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3)
//            .salesOrderDetailMctpModifier4(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4)
//            .salesOrderDetailMctpPeriod(UPDATED_SALES_ORDER_DETAIL_MCTP_PERIOD)
//            .salesOrderDetailAddtlModifier1(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1)
//            .salesOrderDetailAddtlModifier2(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2)
//            .salesOrderDetailAddtlModifier3(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3)
//            .salesOrderDetailAddtlModifier4(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4)
//            .salesOrderDetailNextDateOfService(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE)
//            .salesOrderDetailPriceTable(UPDATED_SALES_ORDER_DETAIL_PRICE_TABLE)
//            .salesOrderDetailPriceOptionName(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION_NAME)
//            .salesOrderDetailExtendedChargeAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT)
//            .salesOrderDetailExtendedAllowanceAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT)
//            .salesOrderDetailItemNdcCode(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE)
//            .salesOrderDetailManufacturer(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER)
//            .salesOrderDetailCbPricing(UPDATED_SALES_ORDER_DETAIL_CB_PRICING)
//            .salesOrderDetailCbPriceTableOverride(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE)
//            .salesOrderDetailCbOverride(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE)
//            .salesOrderDetailMessages(UPDATED_SALES_ORDER_DETAIL_MESSAGES)
//            .salesOrderDetailLocation(UPDATED_SALES_ORDER_DETAIL_LOCATION)
//            .salesOrderDetailCaloriesPerDay(UPDATED_SALES_ORDER_DETAIL_CALORIES_PER_DAY)
//            .salesOrderDetailSecondaryBillingProcudureCode(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE)
//            .salesOrderDetailSecondaryBillingPriceOption(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION)
//            .salesOrderDetailSecondaryBillingPriceOptionName(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME)
//            .salesOrderDetailSecondaryBillingModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingAdditionalModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingadditionalModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingadditionalModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingadditionalModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingIgnore(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE)
//            .salesOrderDetailSecondarySpecialBilling(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING)
//            .salesOrderDetailSpanDateSplitBilling(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING)
//            .salesOrderDetailManufacturerItemIdNumber(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER)
//            .cmnId(UPDATED_CMN_ID)
//            .cmnparCmnFormId(UPDATED_CMNPAR_CMN_FORM_ID)
//            .cmnparCmnKey(UPDATED_CMNPAR_CMN_KEY)
//            .cmnparCmnCreateDate(UPDATED_CMNPAR_CMN_CREATE_DATE)
//            .cmnparCmnExpirationDate(UPDATED_CMNPAR_CMN_EXPIRATION_DATE)
//            .cmnparCmnInitialDate(UPDATED_CMNPAR_CMN_INITIAL_DATE)
//            .cmnparCmnRenewalDate(UPDATED_CMNPAR_CMN_RENEWAL_DATE)
//            .cmnparCmnRecertificationDate(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE)
//            .cmnparCmnPhysicianDate(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE)
//            .cmnparCmnStatus(UPDATED_CMNPAR_CMN_STATUS)
//            .cmnparParId(UPDATED_CMNPAR_PAR_ID)
//            .cmnparParDescr(UPDATED_CMNPAR_PAR_DESCR)
//            .cmnparParInitialDate(UPDATED_CMNPAR_PAR_INITIAL_DATE)
//            .cmnparParExpirationDate(UPDATED_CMNPAR_PAR_EXPIRATION_DATE)
//            .cmnparCmnLogDate(UPDATED_CMNPAR_CMN_LOG_DATE)
//            .cmnparCmnLengthOfNeed(UPDATED_CMNPAR_CMN_LENGTH_OF_NEED)
//            .cmnparCmnPrintedDate(UPDATED_CMNPAR_CMN_PRINTED_DATE)
//            .cmnparCmnPrintedBy(UPDATED_CMNPAR_CMN_PRINTED_BY)
//            .cmnparFaxedDate(UPDATED_CMNPAR_FAXED_DATE)
//            .cmnparCmnPlaceholder(UPDATED_CMNPAR_CMN_PLACEHOLDER)
//            .cmnparCmnFaxedBy(UPDATED_CMNPAR_CMN_FAXED_BY)
//            .cmnparCmnLoggedBy(UPDATED_CMNPAR_CMN_LOGGED_BY)
//            .cmnparNumberOfRefills(UPDATED_CMNPAR_NUMBER_OF_REFILLS)
//            .status(UPDATED_STATUS)
//            .createdById(UPDATED_CREATED_BY_ID)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//        return salesOrderItemDetails;
//    }
//
//    public static void deleteEntities(EntityManager em) {
//        try {
//            em.deleteAll(SalesOrderItemDetails.class).block();
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
//        salesOrderItemDetails = createEntity(em);
//    }
//
//    @Test
//    void createSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeCreate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // Create the SalesOrderItemDetails
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isCreated();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeCreate + 1);
//        SalesOrderItemDetails testSalesOrderItemDetails = salesOrderItemDetailsList.get(salesOrderItemDetailsList.size() - 1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderItemDetailsId()).isEqualTo(DEFAULT_SALES_ORDER_ITEM_DETAILS_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
//        assertThat(testSalesOrderItemDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderItemDetails.getItemLocationId()).isEqualTo(DEFAULT_ITEM_LOCATION_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemId()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUom()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUomName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemDescription()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDefaultVendor()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailOriginalDos()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPreviousBillingDate())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextBillingDate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NEXT_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDosTo()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_DOS_TO);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextPeriod()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NEXT_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialPricing()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOverride()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialTaxRate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailQty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailBqty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_BQTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLineQty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_LINE_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailProcCode()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOption()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailChargeAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAllowedAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxable()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAXABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbn()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnUpgrade()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_UPGRADE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnPrintDate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnItem()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnProcCode()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnAllow()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnCharge()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxRate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxZone()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAX_ZONE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNonTaxReason()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNote()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NOTE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSaleType()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemGroup()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_GROUP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailConvertedToPurchase())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpChargeAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpPeriod()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextDateOfService())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceTable()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOptionName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemNdcCode()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_NDC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturer()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPricing()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CB_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbOverride()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CB_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMessages()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MESSAGES);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLocation()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_LOCATION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCaloriesPerDay()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER);
//        assertThat(testSalesOrderItemDetails.getCmnId()).isEqualTo(DEFAULT_CMN_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFormId()).isEqualTo(DEFAULT_CMNPAR_CMN_FORM_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnKey()).isEqualTo(DEFAULT_CMNPAR_CMN_KEY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnCreateDate()).isEqualTo(DEFAULT_CMNPAR_CMN_CREATE_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnExpirationDate()).isEqualTo(DEFAULT_CMNPAR_CMN_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnInitialDate()).isEqualTo(DEFAULT_CMNPAR_CMN_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRenewalDate()).isEqualTo(DEFAULT_CMNPAR_CMN_RENEWAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRecertificationDate()).isEqualTo(DEFAULT_CMNPAR_CMN_RECERTIFICATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPhysicianDate()).isEqualTo(DEFAULT_CMNPAR_CMN_PHYSICIAN_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnStatus()).isEqualTo(DEFAULT_CMNPAR_CMN_STATUS);
//        assertThat(testSalesOrderItemDetails.getCmnparParId()).isEqualTo(DEFAULT_CMNPAR_PAR_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparParDescr()).isEqualTo(DEFAULT_CMNPAR_PAR_DESCR);
//        assertThat(testSalesOrderItemDetails.getCmnparParInitialDate()).isEqualTo(DEFAULT_CMNPAR_PAR_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparParExpirationDate()).isEqualTo(DEFAULT_CMNPAR_PAR_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLogDate()).isEqualTo(DEFAULT_CMNPAR_CMN_LOG_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLengthOfNeed()).isEqualTo(DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedDate()).isEqualTo(DEFAULT_CMNPAR_CMN_PRINTED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_PRINTED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparFaxedDate()).isEqualTo(DEFAULT_CMNPAR_FAXED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPlaceholder()).isEqualTo(DEFAULT_CMNPAR_CMN_PLACEHOLDER);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFaxedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_FAXED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLoggedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_LOGGED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparNumberOfRefills()).isEqualTo(DEFAULT_CMNPAR_NUMBER_OF_REFILLS);
//        assertThat(testSalesOrderItemDetails.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderItemDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderItemDetails.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void createSalesOrderItemDetailsWithExistingId() throws Exception {
//        // Create the SalesOrderItemDetails with an existing ID
//        salesOrderItemDetails.setId(1L);
//
//        int databaseSizeBeforeCreate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//
//        // An entity with an existing ID cannot be created, so this API call must fail
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeCreate);
//    }
//
//    @Test
//    void checkSalesOrderItemDetailsIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderItemDetails.setSalesOrderItemDetailsId(null);
//
//        // Create the SalesOrderItemDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSalesOrderIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderItemDetails.setSalesOrderId(null);
//
//        // Create the SalesOrderItemDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkPatientIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderItemDetails.setPatientId(null);
//
//        // Create the SalesOrderItemDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkItemLocationIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderItemDetails.setItemLocationId(null);
//
//        // Create the SalesOrderItemDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSalesOrderDetailItemIdIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderItemDetails.setSalesOrderDetailItemId(null);
//
//        // Create the SalesOrderItemDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void checkSalesOrderDetailItemNameIsRequired() throws Exception {
//        int databaseSizeBeforeTest = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        // set the field null
//        salesOrderItemDetails.setSalesOrderDetailItemName(null);
//
//        // Create the SalesOrderItemDetails, which fails.
//
//        webTestClient
//            .post()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeTest);
//    }
//
//    @Test
//    void getAllSalesOrderItemDetailsAsStream() {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = webTestClient
//            .get()
//            .uri(ENTITY_API_URL)
//            .accept(MediaType.APPLICATION_NDJSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
//            .returnResult(SalesOrderItemDetails.class)
//            .getResponseBody()
//            .filter(salesOrderItemDetails::equals)
//            .collectList()
//            .block(Duration.ofSeconds(5));
//
//        assertThat(salesOrderItemDetailsList).isNotNull();
//        assertThat(salesOrderItemDetailsList).hasSize(1);
//        SalesOrderItemDetails testSalesOrderItemDetails = salesOrderItemDetailsList.get(0);
//        assertThat(testSalesOrderItemDetails.getSalesOrderItemDetailsId()).isEqualTo(DEFAULT_SALES_ORDER_ITEM_DETAILS_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderId()).isEqualTo(DEFAULT_SALES_ORDER_ID);
//        assertThat(testSalesOrderItemDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderItemDetails.getItemLocationId()).isEqualTo(DEFAULT_ITEM_LOCATION_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemId()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUom()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUomName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemDescription()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDefaultVendor()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailOriginalDos()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPreviousBillingDate())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextBillingDate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NEXT_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDosTo()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_DOS_TO);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextPeriod()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NEXT_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialPricing()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOverride()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialTaxRate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailQty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailBqty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_BQTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLineQty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_LINE_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailProcCode()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOption()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailChargeAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAllowedAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxable()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAXABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbn()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnUpgrade()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_UPGRADE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnPrintDate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnItem()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnProcCode()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnAllow()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnCharge()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxRate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxZone()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAX_ZONE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNonTaxReason()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNote()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NOTE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSaleType()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemGroup()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_GROUP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailConvertedToPurchase())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpChargeAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpPeriod()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextDateOfService())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceTable()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOptionName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemNdcCode()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_NDC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturer()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPricing()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CB_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbOverride()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CB_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMessages()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MESSAGES);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLocation()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_LOCATION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCaloriesPerDay()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER);
//        assertThat(testSalesOrderItemDetails.getCmnId()).isEqualTo(DEFAULT_CMN_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFormId()).isEqualTo(DEFAULT_CMNPAR_CMN_FORM_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnKey()).isEqualTo(DEFAULT_CMNPAR_CMN_KEY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnCreateDate()).isEqualTo(DEFAULT_CMNPAR_CMN_CREATE_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnExpirationDate()).isEqualTo(DEFAULT_CMNPAR_CMN_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnInitialDate()).isEqualTo(DEFAULT_CMNPAR_CMN_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRenewalDate()).isEqualTo(DEFAULT_CMNPAR_CMN_RENEWAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRecertificationDate()).isEqualTo(DEFAULT_CMNPAR_CMN_RECERTIFICATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPhysicianDate()).isEqualTo(DEFAULT_CMNPAR_CMN_PHYSICIAN_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnStatus()).isEqualTo(DEFAULT_CMNPAR_CMN_STATUS);
//        assertThat(testSalesOrderItemDetails.getCmnparParId()).isEqualTo(DEFAULT_CMNPAR_PAR_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparParDescr()).isEqualTo(DEFAULT_CMNPAR_PAR_DESCR);
//        assertThat(testSalesOrderItemDetails.getCmnparParInitialDate()).isEqualTo(DEFAULT_CMNPAR_PAR_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparParExpirationDate()).isEqualTo(DEFAULT_CMNPAR_PAR_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLogDate()).isEqualTo(DEFAULT_CMNPAR_CMN_LOG_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLengthOfNeed()).isEqualTo(DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedDate()).isEqualTo(DEFAULT_CMNPAR_CMN_PRINTED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_PRINTED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparFaxedDate()).isEqualTo(DEFAULT_CMNPAR_FAXED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPlaceholder()).isEqualTo(DEFAULT_CMNPAR_CMN_PLACEHOLDER);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFaxedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_FAXED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLoggedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_LOGGED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparNumberOfRefills()).isEqualTo(DEFAULT_CMNPAR_NUMBER_OF_REFILLS);
//        assertThat(testSalesOrderItemDetails.getStatus()).isEqualTo(DEFAULT_STATUS);
//        assertThat(testSalesOrderItemDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getCreatedByName()).isEqualTo(DEFAULT_CREATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
//        assertThat(testSalesOrderItemDetails.getUpdatedById()).isEqualTo(DEFAULT_UPDATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getUpdatedByName()).isEqualTo(DEFAULT_UPDATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getUpdatedDate()).isEqualTo(DEFAULT_UPDATED_DATE);
//    }
//
//    @Test
//    void getAllSalesOrderItemDetails() {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        // Get all the salesOrderItemDetailsList
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
//            .value(hasItem(salesOrderItemDetails.getId().intValue()))
//            .jsonPath("$.[*].salesOrderItemDetailsId")
//            .value(hasItem(DEFAULT_SALES_ORDER_ITEM_DETAILS_ID))
//            .jsonPath("$.[*].salesOrderId")
//            .value(hasItem(DEFAULT_SALES_ORDER_ID))
//            .jsonPath("$.[*].patientId")
//            .value(hasItem(DEFAULT_PATIENT_ID))
//            .jsonPath("$.[*].itemLocationId")
//            .value(hasItem(DEFAULT_ITEM_LOCATION_ID))
//            .jsonPath("$.[*].salesOrderDetailItemId")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_ID))
//            .jsonPath("$.[*].salesOrderDetailItemName")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME))
//            .jsonPath("$.[*].salesOrderDetailStockingUom")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM))
//            .jsonPath("$.[*].salesOrderDetailStockingUomName")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME))
//            .jsonPath("$.[*].salesOrderDetailItemDescription")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION))
//            .jsonPath("$.[*].salesOrderDetailDefaultVendor")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR))
//            .jsonPath("$.[*].salesOrderDetailOriginalDos")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS.toString()))
//            .jsonPath("$.[*].salesOrderDetailPreviousBillingDate")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE.toString()))
//            .jsonPath("$.[*].salesOrderDetailNextBillingDate")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_NEXT_BILLING_DATE.toString()))
//            .jsonPath("$.[*].salesOrderDetailDosTo")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_DOS_TO.toString()))
//            .jsonPath("$.[*].salesOrderDetailNextPeriod")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_NEXT_PERIOD))
//            .jsonPath("$.[*].salesOrderDetailSpecialPricing")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING))
//            .jsonPath("$.[*].salesOrderDetailPriceOverride")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_PRICE_OVERRIDE))
//            .jsonPath("$.[*].salesOrderDetailSpecialTaxRate")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE))
//            .jsonPath("$.[*].salesOrderDetailQty")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_QTY))
//            .jsonPath("$.[*].salesOrderDetailBqty")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_BQTY))
//            .jsonPath("$.[*].salesOrderDetailLineQty")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_LINE_QTY))
//            .jsonPath("$.[*].salesOrderDetailProcCode")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_PROC_CODE))
//            .jsonPath("$.[*].salesOrderDetailPriceOption")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION))
//            .jsonPath("$.[*].salesOrderDetailModifier1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1))
//            .jsonPath("$.[*].salesOrderDetailModifier2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_2))
//            .jsonPath("$.[*].salesOrderDetailModifier3")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3))
//            .jsonPath("$.[*].salesOrderDetailModifier4")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4))
//            .jsonPath("$.[*].salesOrderDetailChargeAmt")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT.doubleValue()))
//            .jsonPath("$.[*].salesOrderDetailAllowedAmt")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT.doubleValue()))
//            .jsonPath("$.[*].salesOrderDetailTaxable")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_TAXABLE))
//            .jsonPath("$.[*].salesOrderDetailAbn")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN))
//            .jsonPath("$.[*].salesOrderDetailAbnUpgrade")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_UPGRADE))
//            .jsonPath("$.[*].salesOrderDetailAbnPrintDate")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE.toString()))
//            .jsonPath("$.[*].salesOrderDetailAbnItem")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM))
//            .jsonPath("$.[*].salesOrderDetailAbnProcCode")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_PROC_CODE))
//            .jsonPath("$.[*].salesOrderDetailAbnAllow")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW))
//            .jsonPath("$.[*].salesOrderDetailAbnCharge")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE))
//            .jsonPath("$.[*].salesOrderDetailAbnModifier1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_1))
//            .jsonPath("$.[*].salesOrderDetailAbnModifier2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2))
//            .jsonPath("$.[*].salesOrderDetailTaxRate")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_TAX_RATE))
//            .jsonPath("$.[*].salesOrderDetailTaxZone")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_TAX_ZONE))
//            .jsonPath("$.[*].salesOrderDetailNonTaxReason")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON))
//            .jsonPath("$.[*].salesOrderDetailNote")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_NOTE))
//            .jsonPath("$.[*].salesOrderDetailSaleType")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE))
//            .jsonPath("$.[*].salesOrderDetailItemGroup")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_GROUP))
//            .jsonPath("$.[*].salesOrderDetailItemUser1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_1))
//            .jsonPath("$.[*].salesOrderDetailItemUser2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_2))
//            .jsonPath("$.[*].salesOrderDetailItemUser3")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3))
//            .jsonPath("$.[*].salesOrderDetailItemUser4")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_4))
//            .jsonPath("$.[*].salesOrderDetailConvertedToPurchase")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE))
//            .jsonPath("$.[*].salesOrderDetailManualConvertToPurchaseMctp")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP))
//            .jsonPath("$.[*].salesOrderDetailMctpChargeAmt")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT.doubleValue()))
//            .jsonPath("$.[*].salesOrderDetailMctpAllowedAmt")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT.doubleValue()))
//            .jsonPath("$.[*].salesOrderDetailMctpModifier1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1))
//            .jsonPath("$.[*].salesOrderDetailMctpModifier2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_2))
//            .jsonPath("$.[*].salesOrderDetailMctpModifier3")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_3))
//            .jsonPath("$.[*].salesOrderDetailMctpModifier4")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_4))
//            .jsonPath("$.[*].salesOrderDetailMctpPeriod")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD))
//            .jsonPath("$.[*].salesOrderDetailAddtlModifier1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1))
//            .jsonPath("$.[*].salesOrderDetailAddtlModifier2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2))
//            .jsonPath("$.[*].salesOrderDetailAddtlModifier3")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3))
//            .jsonPath("$.[*].salesOrderDetailAddtlModifier4")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4))
//            .jsonPath("$.[*].salesOrderDetailNextDateOfService")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE.toString()))
//            .jsonPath("$.[*].salesOrderDetailPriceTable")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE))
//            .jsonPath("$.[*].salesOrderDetailPriceOptionName")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME))
//            .jsonPath("$.[*].salesOrderDetailExtendedChargeAmount")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT.doubleValue()))
//            .jsonPath("$.[*].salesOrderDetailExtendedAllowanceAmount")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT.doubleValue()))
//            .jsonPath("$.[*].salesOrderDetailItemNdcCode")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_ITEM_NDC_CODE))
//            .jsonPath("$.[*].salesOrderDetailManufacturer")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER))
//            .jsonPath("$.[*].salesOrderDetailCbPricing")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_CB_PRICING))
//            .jsonPath("$.[*].salesOrderDetailCbPriceTableOverride")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE))
//            .jsonPath("$.[*].salesOrderDetailCbOverride")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_CB_OVERRIDE))
//            .jsonPath("$.[*].salesOrderDetailMessages")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MESSAGES))
//            .jsonPath("$.[*].salesOrderDetailLocation")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_LOCATION))
//            .jsonPath("$.[*].salesOrderDetailCaloriesPerDay")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingProcudureCode")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingPriceOption")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingPriceOptionName")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingModifier1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingModifier2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingModifier3")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingModifier4")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingAdditionalModifier1")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingadditionalModifier2")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingadditionalModifier3")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingadditionalModifier4")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4))
//            .jsonPath("$.[*].salesOrderDetailSecondaryBillingIgnore")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE))
//            .jsonPath("$.[*].salesOrderDetailSecondarySpecialBilling")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING))
//            .jsonPath("$.[*].salesOrderDetailSpanDateSplitBilling")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING))
//            .jsonPath("$.[*].salesOrderDetailManufacturerItemIdNumber")
//            .value(hasItem(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER))
//            .jsonPath("$.[*].cmnId")
//            .value(hasItem(DEFAULT_CMN_ID))
//            .jsonPath("$.[*].cmnparCmnFormId")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_FORM_ID))
//            .jsonPath("$.[*].cmnparCmnKey")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_KEY))
//            .jsonPath("$.[*].cmnparCmnCreateDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_CREATE_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnExpirationDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_EXPIRATION_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnInitialDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_INITIAL_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnRenewalDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_RENEWAL_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnRecertificationDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_RECERTIFICATION_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnPhysicianDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_PHYSICIAN_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnStatus")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_STATUS))
//            .jsonPath("$.[*].cmnparParId")
//            .value(hasItem(DEFAULT_CMNPAR_PAR_ID))
//            .jsonPath("$.[*].cmnparParDescr")
//            .value(hasItem(DEFAULT_CMNPAR_PAR_DESCR))
//            .jsonPath("$.[*].cmnparParInitialDate")
//            .value(hasItem(DEFAULT_CMNPAR_PAR_INITIAL_DATE.toString()))
//            .jsonPath("$.[*].cmnparParExpirationDate")
//            .value(hasItem(DEFAULT_CMNPAR_PAR_EXPIRATION_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnLogDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_LOG_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnLengthOfNeed")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED))
//            .jsonPath("$.[*].cmnparCmnPrintedDate")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_PRINTED_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnPrintedBy")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_PRINTED_BY))
//            .jsonPath("$.[*].cmnparFaxedDate")
//            .value(hasItem(DEFAULT_CMNPAR_FAXED_DATE.toString()))
//            .jsonPath("$.[*].cmnparCmnPlaceholder")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_PLACEHOLDER))
//            .jsonPath("$.[*].cmnparCmnFaxedBy")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_FAXED_BY))
//            .jsonPath("$.[*].cmnparCmnLoggedBy")
//            .value(hasItem(DEFAULT_CMNPAR_CMN_LOGGED_BY))
//            .jsonPath("$.[*].cmnparNumberOfRefills")
//            .value(hasItem(DEFAULT_CMNPAR_NUMBER_OF_REFILLS))
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
//    void getSalesOrderItemDetails() {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        // Get the salesOrderItemDetails
//        webTestClient
//            .get()
//            .uri(ENTITY_API_URL_ID, salesOrderItemDetails.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isOk()
//            .expectHeader()
//            .contentType(MediaType.APPLICATION_JSON)
//            .expectBody()
//            .jsonPath("$.id")
//            .value(is(salesOrderItemDetails.getId().intValue()))
//            .jsonPath("$.salesOrderItemDetailsId")
//            .value(is(DEFAULT_SALES_ORDER_ITEM_DETAILS_ID))
//            .jsonPath("$.salesOrderId")
//            .value(is(DEFAULT_SALES_ORDER_ID))
//            .jsonPath("$.patientId")
//            .value(is(DEFAULT_PATIENT_ID))
//            .jsonPath("$.itemLocationId")
//            .value(is(DEFAULT_ITEM_LOCATION_ID))
//            .jsonPath("$.salesOrderDetailItemId")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_ID))
//            .jsonPath("$.salesOrderDetailItemName")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME))
//            .jsonPath("$.salesOrderDetailStockingUom")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM))
//            .jsonPath("$.salesOrderDetailStockingUomName")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME))
//            .jsonPath("$.salesOrderDetailItemDescription")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION))
//            .jsonPath("$.salesOrderDetailDefaultVendor")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR))
//            .jsonPath("$.salesOrderDetailOriginalDos")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS.toString()))
//            .jsonPath("$.salesOrderDetailPreviousBillingDate")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE.toString()))
//            .jsonPath("$.salesOrderDetailNextBillingDate")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_NEXT_BILLING_DATE.toString()))
//            .jsonPath("$.salesOrderDetailDosTo")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_DOS_TO.toString()))
//            .jsonPath("$.salesOrderDetailNextPeriod")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_NEXT_PERIOD))
//            .jsonPath("$.salesOrderDetailSpecialPricing")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING))
//            .jsonPath("$.salesOrderDetailPriceOverride")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_PRICE_OVERRIDE))
//            .jsonPath("$.salesOrderDetailSpecialTaxRate")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE))
//            .jsonPath("$.salesOrderDetailQty")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_QTY))
//            .jsonPath("$.salesOrderDetailBqty")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_BQTY))
//            .jsonPath("$.salesOrderDetailLineQty")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_LINE_QTY))
//            .jsonPath("$.salesOrderDetailProcCode")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_PROC_CODE))
//            .jsonPath("$.salesOrderDetailPriceOption")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION))
//            .jsonPath("$.salesOrderDetailModifier1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1))
//            .jsonPath("$.salesOrderDetailModifier2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_2))
//            .jsonPath("$.salesOrderDetailModifier3")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3))
//            .jsonPath("$.salesOrderDetailModifier4")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4))
//            .jsonPath("$.salesOrderDetailChargeAmt")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT.doubleValue()))
//            .jsonPath("$.salesOrderDetailAllowedAmt")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT.doubleValue()))
//            .jsonPath("$.salesOrderDetailTaxable")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_TAXABLE))
//            .jsonPath("$.salesOrderDetailAbn")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN))
//            .jsonPath("$.salesOrderDetailAbnUpgrade")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_UPGRADE))
//            .jsonPath("$.salesOrderDetailAbnPrintDate")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE.toString()))
//            .jsonPath("$.salesOrderDetailAbnItem")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM))
//            .jsonPath("$.salesOrderDetailAbnProcCode")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_PROC_CODE))
//            .jsonPath("$.salesOrderDetailAbnAllow")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW))
//            .jsonPath("$.salesOrderDetailAbnCharge")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE))
//            .jsonPath("$.salesOrderDetailAbnModifier1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_1))
//            .jsonPath("$.salesOrderDetailAbnModifier2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2))
//            .jsonPath("$.salesOrderDetailTaxRate")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_TAX_RATE))
//            .jsonPath("$.salesOrderDetailTaxZone")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_TAX_ZONE))
//            .jsonPath("$.salesOrderDetailNonTaxReason")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON))
//            .jsonPath("$.salesOrderDetailNote")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_NOTE))
//            .jsonPath("$.salesOrderDetailSaleType")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE))
//            .jsonPath("$.salesOrderDetailItemGroup")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_GROUP))
//            .jsonPath("$.salesOrderDetailItemUser1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_1))
//            .jsonPath("$.salesOrderDetailItemUser2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_2))
//            .jsonPath("$.salesOrderDetailItemUser3")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3))
//            .jsonPath("$.salesOrderDetailItemUser4")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_4))
//            .jsonPath("$.salesOrderDetailConvertedToPurchase")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE))
//            .jsonPath("$.salesOrderDetailManualConvertToPurchaseMctp")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP))
//            .jsonPath("$.salesOrderDetailMctpChargeAmt")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT.doubleValue()))
//            .jsonPath("$.salesOrderDetailMctpAllowedAmt")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT.doubleValue()))
//            .jsonPath("$.salesOrderDetailMctpModifier1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1))
//            .jsonPath("$.salesOrderDetailMctpModifier2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_2))
//            .jsonPath("$.salesOrderDetailMctpModifier3")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_3))
//            .jsonPath("$.salesOrderDetailMctpModifier4")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_4))
//            .jsonPath("$.salesOrderDetailMctpPeriod")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD))
//            .jsonPath("$.salesOrderDetailAddtlModifier1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1))
//            .jsonPath("$.salesOrderDetailAddtlModifier2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2))
//            .jsonPath("$.salesOrderDetailAddtlModifier3")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3))
//            .jsonPath("$.salesOrderDetailAddtlModifier4")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4))
//            .jsonPath("$.salesOrderDetailNextDateOfService")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE.toString()))
//            .jsonPath("$.salesOrderDetailPriceTable")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE))
//            .jsonPath("$.salesOrderDetailPriceOptionName")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME))
//            .jsonPath("$.salesOrderDetailExtendedChargeAmount")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT.doubleValue()))
//            .jsonPath("$.salesOrderDetailExtendedAllowanceAmount")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT.doubleValue()))
//            .jsonPath("$.salesOrderDetailItemNdcCode")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_ITEM_NDC_CODE))
//            .jsonPath("$.salesOrderDetailManufacturer")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER))
//            .jsonPath("$.salesOrderDetailCbPricing")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_CB_PRICING))
//            .jsonPath("$.salesOrderDetailCbPriceTableOverride")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE))
//            .jsonPath("$.salesOrderDetailCbOverride")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_CB_OVERRIDE))
//            .jsonPath("$.salesOrderDetailMessages")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MESSAGES))
//            .jsonPath("$.salesOrderDetailLocation")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_LOCATION))
//            .jsonPath("$.salesOrderDetailCaloriesPerDay")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY))
//            .jsonPath("$.salesOrderDetailSecondaryBillingProcudureCode")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE))
//            .jsonPath("$.salesOrderDetailSecondaryBillingPriceOption")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION))
//            .jsonPath("$.salesOrderDetailSecondaryBillingPriceOptionName")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME))
//            .jsonPath("$.salesOrderDetailSecondaryBillingModifier1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1))
//            .jsonPath("$.salesOrderDetailSecondaryBillingModifier2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2))
//            .jsonPath("$.salesOrderDetailSecondaryBillingModifier3")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3))
//            .jsonPath("$.salesOrderDetailSecondaryBillingModifier4")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4))
//            .jsonPath("$.salesOrderDetailSecondaryBillingAdditionalModifier1")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1))
//            .jsonPath("$.salesOrderDetailSecondaryBillingadditionalModifier2")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2))
//            .jsonPath("$.salesOrderDetailSecondaryBillingadditionalModifier3")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3))
//            .jsonPath("$.salesOrderDetailSecondaryBillingadditionalModifier4")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4))
//            .jsonPath("$.salesOrderDetailSecondaryBillingIgnore")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE))
//            .jsonPath("$.salesOrderDetailSecondarySpecialBilling")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING))
//            .jsonPath("$.salesOrderDetailSpanDateSplitBilling")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING))
//            .jsonPath("$.salesOrderDetailManufacturerItemIdNumber")
//            .value(is(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER))
//            .jsonPath("$.cmnId")
//            .value(is(DEFAULT_CMN_ID))
//            .jsonPath("$.cmnparCmnFormId")
//            .value(is(DEFAULT_CMNPAR_CMN_FORM_ID))
//            .jsonPath("$.cmnparCmnKey")
//            .value(is(DEFAULT_CMNPAR_CMN_KEY))
//            .jsonPath("$.cmnparCmnCreateDate")
//            .value(is(DEFAULT_CMNPAR_CMN_CREATE_DATE.toString()))
//            .jsonPath("$.cmnparCmnExpirationDate")
//            .value(is(DEFAULT_CMNPAR_CMN_EXPIRATION_DATE.toString()))
//            .jsonPath("$.cmnparCmnInitialDate")
//            .value(is(DEFAULT_CMNPAR_CMN_INITIAL_DATE.toString()))
//            .jsonPath("$.cmnparCmnRenewalDate")
//            .value(is(DEFAULT_CMNPAR_CMN_RENEWAL_DATE.toString()))
//            .jsonPath("$.cmnparCmnRecertificationDate")
//            .value(is(DEFAULT_CMNPAR_CMN_RECERTIFICATION_DATE.toString()))
//            .jsonPath("$.cmnparCmnPhysicianDate")
//            .value(is(DEFAULT_CMNPAR_CMN_PHYSICIAN_DATE.toString()))
//            .jsonPath("$.cmnparCmnStatus")
//            .value(is(DEFAULT_CMNPAR_CMN_STATUS))
//            .jsonPath("$.cmnparParId")
//            .value(is(DEFAULT_CMNPAR_PAR_ID))
//            .jsonPath("$.cmnparParDescr")
//            .value(is(DEFAULT_CMNPAR_PAR_DESCR))
//            .jsonPath("$.cmnparParInitialDate")
//            .value(is(DEFAULT_CMNPAR_PAR_INITIAL_DATE.toString()))
//            .jsonPath("$.cmnparParExpirationDate")
//            .value(is(DEFAULT_CMNPAR_PAR_EXPIRATION_DATE.toString()))
//            .jsonPath("$.cmnparCmnLogDate")
//            .value(is(DEFAULT_CMNPAR_CMN_LOG_DATE.toString()))
//            .jsonPath("$.cmnparCmnLengthOfNeed")
//            .value(is(DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED))
//            .jsonPath("$.cmnparCmnPrintedDate")
//            .value(is(DEFAULT_CMNPAR_CMN_PRINTED_DATE.toString()))
//            .jsonPath("$.cmnparCmnPrintedBy")
//            .value(is(DEFAULT_CMNPAR_CMN_PRINTED_BY))
//            .jsonPath("$.cmnparFaxedDate")
//            .value(is(DEFAULT_CMNPAR_FAXED_DATE.toString()))
//            .jsonPath("$.cmnparCmnPlaceholder")
//            .value(is(DEFAULT_CMNPAR_CMN_PLACEHOLDER))
//            .jsonPath("$.cmnparCmnFaxedBy")
//            .value(is(DEFAULT_CMNPAR_CMN_FAXED_BY))
//            .jsonPath("$.cmnparCmnLoggedBy")
//            .value(is(DEFAULT_CMNPAR_CMN_LOGGED_BY))
//            .jsonPath("$.cmnparNumberOfRefills")
//            .value(is(DEFAULT_CMNPAR_NUMBER_OF_REFILLS))
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
//    void getNonExistingSalesOrderItemDetails() {
//        // Get the salesOrderItemDetails
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
//    void putNewSalesOrderItemDetails() throws Exception {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderItemDetails
//        SalesOrderItemDetails updatedSalesOrderItemDetails = salesOrderItemDetailsRepository
//            .findById(salesOrderItemDetails.getId())
//            .block();
//        updatedSalesOrderItemDetails
//            .salesOrderItemDetailsId(UPDATED_SALES_ORDER_ITEM_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .itemLocationId(UPDATED_ITEM_LOCATION_ID)
//            .salesOrderDetailItemId(UPDATED_SALES_ORDER_DETAIL_ITEM_ID)
//            .salesOrderDetailItemName(UPDATED_SALES_ORDER_DETAIL_ITEM_NAME)
//            .salesOrderDetailStockingUom(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM)
//            .salesOrderDetailStockingUomName(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM_NAME)
//            .salesOrderDetailItemDescription(UPDATED_SALES_ORDER_DETAIL_ITEM_DESCRIPTION)
//            .salesOrderDetailDefaultVendor(UPDATED_SALES_ORDER_DETAIL_DEFAULT_VENDOR)
//            .salesOrderDetailOriginalDos(UPDATED_SALES_ORDER_DETAIL_ORIGINAL_DOS)
//            .salesOrderDetailPreviousBillingDate(UPDATED_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE)
//            .salesOrderDetailNextBillingDate(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE)
//            .salesOrderDetailDosTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO)
//            .salesOrderDetailNextPeriod(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD)
//            .salesOrderDetailSpecialPricing(UPDATED_SALES_ORDER_DETAIL_SPECIAL_PRICING)
//            .salesOrderDetailPriceOverride(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE)
//            .salesOrderDetailSpecialTaxRate(UPDATED_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE)
//            .salesOrderDetailQty(UPDATED_SALES_ORDER_DETAIL_QTY)
//            .salesOrderDetailBqty(UPDATED_SALES_ORDER_DETAIL_BQTY)
//            .salesOrderDetailLineQty(UPDATED_SALES_ORDER_DETAIL_LINE_QTY)
//            .salesOrderDetailProcCode(UPDATED_SALES_ORDER_DETAIL_PROC_CODE)
//            .salesOrderDetailPriceOption(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION)
//            .salesOrderDetailModifier1(UPDATED_SALES_ORDER_DETAIL_MODIFIER_1)
//            .salesOrderDetailModifier2(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2)
//            .salesOrderDetailModifier3(UPDATED_SALES_ORDER_DETAIL_MODIFIER_3)
//            .salesOrderDetailModifier4(UPDATED_SALES_ORDER_DETAIL_MODIFIER_4)
//            .salesOrderDetailChargeAmt(UPDATED_SALES_ORDER_DETAIL_CHARGE_AMT)
//            .salesOrderDetailAllowedAmt(UPDATED_SALES_ORDER_DETAIL_ALLOWED_AMT)
//            .salesOrderDetailTaxable(UPDATED_SALES_ORDER_DETAIL_TAXABLE)
//            .salesOrderDetailAbn(UPDATED_SALES_ORDER_DETAIL_ABN)
//            .salesOrderDetailAbnUpgrade(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE)
//            .salesOrderDetailAbnPrintDate(UPDATED_SALES_ORDER_DETAIL_ABN_PRINT_DATE)
//            .salesOrderDetailAbnItem(UPDATED_SALES_ORDER_DETAIL_ABN_ITEM)
//            .salesOrderDetailAbnProcCode(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE)
//            .salesOrderDetailAbnAllow(UPDATED_SALES_ORDER_DETAIL_ABN_ALLOW)
//            .salesOrderDetailAbnCharge(UPDATED_SALES_ORDER_DETAIL_ABN_CHARGE)
//            .salesOrderDetailAbnModifier1(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1)
//            .salesOrderDetailAbnModifier2(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_2)
//            .salesOrderDetailTaxRate(UPDATED_SALES_ORDER_DETAIL_TAX_RATE)
//            .salesOrderDetailTaxZone(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE)
//            .salesOrderDetailNonTaxReason(UPDATED_SALES_ORDER_DETAIL_NON_TAX_REASON)
//            .salesOrderDetailNote(UPDATED_SALES_ORDER_DETAIL_NOTE)
//            .salesOrderDetailSaleType(UPDATED_SALES_ORDER_DETAIL_SALE_TYPE)
//            .salesOrderDetailItemGroup(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP)
//            .salesOrderDetailItemUser1(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1)
//            .salesOrderDetailItemUser2(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2)
//            .salesOrderDetailItemUser3(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_3)
//            .salesOrderDetailItemUser4(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4)
//            .salesOrderDetailConvertedToPurchase(UPDATED_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE)
//            .salesOrderDetailManualConvertToPurchaseMctp(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP)
//            .salesOrderDetailMctpChargeAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT)
//            .salesOrderDetailMctpAllowedAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT)
//            .salesOrderDetailMctpModifier1(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_1)
//            .salesOrderDetailMctpModifier2(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2)
//            .salesOrderDetailMctpModifier3(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3)
//            .salesOrderDetailMctpModifier4(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4)
//            .salesOrderDetailMctpPeriod(UPDATED_SALES_ORDER_DETAIL_MCTP_PERIOD)
//            .salesOrderDetailAddtlModifier1(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1)
//            .salesOrderDetailAddtlModifier2(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2)
//            .salesOrderDetailAddtlModifier3(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3)
//            .salesOrderDetailAddtlModifier4(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4)
//            .salesOrderDetailNextDateOfService(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE)
//            .salesOrderDetailPriceTable(UPDATED_SALES_ORDER_DETAIL_PRICE_TABLE)
//            .salesOrderDetailPriceOptionName(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION_NAME)
//            .salesOrderDetailExtendedChargeAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT)
//            .salesOrderDetailExtendedAllowanceAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT)
//            .salesOrderDetailItemNdcCode(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE)
//            .salesOrderDetailManufacturer(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER)
//            .salesOrderDetailCbPricing(UPDATED_SALES_ORDER_DETAIL_CB_PRICING)
//            .salesOrderDetailCbPriceTableOverride(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE)
//            .salesOrderDetailCbOverride(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE)
//            .salesOrderDetailMessages(UPDATED_SALES_ORDER_DETAIL_MESSAGES)
//            .salesOrderDetailLocation(UPDATED_SALES_ORDER_DETAIL_LOCATION)
//            .salesOrderDetailCaloriesPerDay(UPDATED_SALES_ORDER_DETAIL_CALORIES_PER_DAY)
//            .salesOrderDetailSecondaryBillingProcudureCode(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE)
//            .salesOrderDetailSecondaryBillingPriceOption(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION)
//            .salesOrderDetailSecondaryBillingPriceOptionName(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME)
//            .salesOrderDetailSecondaryBillingModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingAdditionalModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingadditionalModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingadditionalModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingadditionalModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingIgnore(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE)
//            .salesOrderDetailSecondarySpecialBilling(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING)
//            .salesOrderDetailSpanDateSplitBilling(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING)
//            .salesOrderDetailManufacturerItemIdNumber(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER)
//            .cmnId(UPDATED_CMN_ID)
//            .cmnparCmnFormId(UPDATED_CMNPAR_CMN_FORM_ID)
//            .cmnparCmnKey(UPDATED_CMNPAR_CMN_KEY)
//            .cmnparCmnCreateDate(UPDATED_CMNPAR_CMN_CREATE_DATE)
//            .cmnparCmnExpirationDate(UPDATED_CMNPAR_CMN_EXPIRATION_DATE)
//            .cmnparCmnInitialDate(UPDATED_CMNPAR_CMN_INITIAL_DATE)
//            .cmnparCmnRenewalDate(UPDATED_CMNPAR_CMN_RENEWAL_DATE)
//            .cmnparCmnRecertificationDate(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE)
//            .cmnparCmnPhysicianDate(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE)
//            .cmnparCmnStatus(UPDATED_CMNPAR_CMN_STATUS)
//            .cmnparParId(UPDATED_CMNPAR_PAR_ID)
//            .cmnparParDescr(UPDATED_CMNPAR_PAR_DESCR)
//            .cmnparParInitialDate(UPDATED_CMNPAR_PAR_INITIAL_DATE)
//            .cmnparParExpirationDate(UPDATED_CMNPAR_PAR_EXPIRATION_DATE)
//            .cmnparCmnLogDate(UPDATED_CMNPAR_CMN_LOG_DATE)
//            .cmnparCmnLengthOfNeed(UPDATED_CMNPAR_CMN_LENGTH_OF_NEED)
//            .cmnparCmnPrintedDate(UPDATED_CMNPAR_CMN_PRINTED_DATE)
//            .cmnparCmnPrintedBy(UPDATED_CMNPAR_CMN_PRINTED_BY)
//            .cmnparFaxedDate(UPDATED_CMNPAR_FAXED_DATE)
//            .cmnparCmnPlaceholder(UPDATED_CMNPAR_CMN_PLACEHOLDER)
//            .cmnparCmnFaxedBy(UPDATED_CMNPAR_CMN_FAXED_BY)
//            .cmnparCmnLoggedBy(UPDATED_CMNPAR_CMN_LOGGED_BY)
//            .cmnparNumberOfRefills(UPDATED_CMNPAR_NUMBER_OF_REFILLS)
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
//            .uri(ENTITY_API_URL_ID, updatedSalesOrderItemDetails.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedSalesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderItemDetails testSalesOrderItemDetails = salesOrderItemDetailsList.get(salesOrderItemDetailsList.size() - 1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderItemDetailsId()).isEqualTo(UPDATED_SALES_ORDER_ITEM_DETAILS_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
//        assertThat(testSalesOrderItemDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderItemDetails.getItemLocationId()).isEqualTo(UPDATED_ITEM_LOCATION_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemId()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemName()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUom()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUomName()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemDescription()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_DESCRIPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDefaultVendor()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_DEFAULT_VENDOR);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailOriginalDos()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ORIGINAL_DOS);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPreviousBillingDate())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextBillingDate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDosTo()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextPeriod()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialPricing()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPECIAL_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOverride()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialTaxRate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailQty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailBqty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_BQTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLineQty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_LINE_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailProcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOption()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailChargeAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAllowedAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxable()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAXABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbn()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnUpgrade()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnPrintDate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_PRINT_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnItem()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_ITEM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnProcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnAllow()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_ALLOW);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnCharge()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_CHARGE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxRate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxZone()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNonTaxReason()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NON_TAX_REASON);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNote()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NOTE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSaleType()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_SALE_TYPE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemGroup()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailConvertedToPurchase())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpChargeAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpPeriod()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextDateOfService())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceTable()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_TABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOptionName()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemNdcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturer()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPricing()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbOverride()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMessages()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MESSAGES);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLocation()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_LOCATION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCaloriesPerDay()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CALORIES_PER_DAY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER);
//        assertThat(testSalesOrderItemDetails.getCmnId()).isEqualTo(UPDATED_CMN_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFormId()).isEqualTo(UPDATED_CMNPAR_CMN_FORM_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnKey()).isEqualTo(UPDATED_CMNPAR_CMN_KEY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnCreateDate()).isEqualTo(UPDATED_CMNPAR_CMN_CREATE_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnExpirationDate()).isEqualTo(UPDATED_CMNPAR_CMN_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnInitialDate()).isEqualTo(UPDATED_CMNPAR_CMN_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRenewalDate()).isEqualTo(UPDATED_CMNPAR_CMN_RENEWAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRecertificationDate()).isEqualTo(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPhysicianDate()).isEqualTo(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnStatus()).isEqualTo(UPDATED_CMNPAR_CMN_STATUS);
//        assertThat(testSalesOrderItemDetails.getCmnparParId()).isEqualTo(UPDATED_CMNPAR_PAR_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparParDescr()).isEqualTo(UPDATED_CMNPAR_PAR_DESCR);
//        assertThat(testSalesOrderItemDetails.getCmnparParInitialDate()).isEqualTo(UPDATED_CMNPAR_PAR_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparParExpirationDate()).isEqualTo(UPDATED_CMNPAR_PAR_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLogDate()).isEqualTo(UPDATED_CMNPAR_CMN_LOG_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLengthOfNeed()).isEqualTo(UPDATED_CMNPAR_CMN_LENGTH_OF_NEED);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedDate()).isEqualTo(UPDATED_CMNPAR_CMN_PRINTED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedBy()).isEqualTo(UPDATED_CMNPAR_CMN_PRINTED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparFaxedDate()).isEqualTo(UPDATED_CMNPAR_FAXED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPlaceholder()).isEqualTo(UPDATED_CMNPAR_CMN_PLACEHOLDER);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFaxedBy()).isEqualTo(UPDATED_CMNPAR_CMN_FAXED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLoggedBy()).isEqualTo(UPDATED_CMNPAR_CMN_LOGGED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparNumberOfRefills()).isEqualTo(UPDATED_CMNPAR_NUMBER_OF_REFILLS);
//        assertThat(testSalesOrderItemDetails.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderItemDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderItemDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void putNonExistingSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        salesOrderItemDetails.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, salesOrderItemDetails.getId())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithIdMismatchSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        salesOrderItemDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void putWithMissingIdPathParamSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        salesOrderItemDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .put()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.APPLICATION_JSON)
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void partialUpdateSalesOrderItemDetailsWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderItemDetails using partial update
//        SalesOrderItemDetails partialUpdatedSalesOrderItemDetails = new SalesOrderItemDetails();
//        partialUpdatedSalesOrderItemDetails.setId(salesOrderItemDetails.getId());
//
//        partialUpdatedSalesOrderItemDetails
//            .salesOrderItemDetailsId(UPDATED_SALES_ORDER_ITEM_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .itemLocationId(UPDATED_ITEM_LOCATION_ID)
//            .salesOrderDetailItemId(UPDATED_SALES_ORDER_DETAIL_ITEM_ID)
//            .salesOrderDetailNextBillingDate(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE)
//            .salesOrderDetailDosTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO)
//            .salesOrderDetailNextPeriod(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD)
//            .salesOrderDetailPriceOverride(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE)
//            .salesOrderDetailQty(UPDATED_SALES_ORDER_DETAIL_QTY)
//            .salesOrderDetailLineQty(UPDATED_SALES_ORDER_DETAIL_LINE_QTY)
//            .salesOrderDetailProcCode(UPDATED_SALES_ORDER_DETAIL_PROC_CODE)
//            .salesOrderDetailModifier2(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2)
//            .salesOrderDetailAbn(UPDATED_SALES_ORDER_DETAIL_ABN)
//            .salesOrderDetailAbnUpgrade(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE)
//            .salesOrderDetailAbnProcCode(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE)
//            .salesOrderDetailAbnModifier1(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1)
//            .salesOrderDetailTaxRate(UPDATED_SALES_ORDER_DETAIL_TAX_RATE)
//            .salesOrderDetailTaxZone(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE)
//            .salesOrderDetailNote(UPDATED_SALES_ORDER_DETAIL_NOTE)
//            .salesOrderDetailItemGroup(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP)
//            .salesOrderDetailItemUser1(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1)
//            .salesOrderDetailItemUser2(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2)
//            .salesOrderDetailItemUser4(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4)
//            .salesOrderDetailManualConvertToPurchaseMctp(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP)
//            .salesOrderDetailMctpChargeAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT)
//            .salesOrderDetailMctpAllowedAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT)
//            .salesOrderDetailMctpModifier2(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2)
//            .salesOrderDetailMctpModifier3(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3)
//            .salesOrderDetailMctpModifier4(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4)
//            .salesOrderDetailAddtlModifier1(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1)
//            .salesOrderDetailAddtlModifier4(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4)
//            .salesOrderDetailNextDateOfService(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE)
//            .salesOrderDetailExtendedChargeAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT)
//            .salesOrderDetailItemNdcCode(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE)
//            .salesOrderDetailManufacturer(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER)
//            .salesOrderDetailCbPricing(UPDATED_SALES_ORDER_DETAIL_CB_PRICING)
//            .salesOrderDetailCbPriceTableOverride(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE)
//            .salesOrderDetailCbOverride(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE)
//            .salesOrderDetailSecondaryBillingProcudureCode(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE)
//            .salesOrderDetailSecondaryBillingPriceOption(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION)
//            .salesOrderDetailSecondaryBillingPriceOptionName(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME)
//            .salesOrderDetailSecondaryBillingModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingAdditionalModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingadditionalModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingadditionalModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingIgnore(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE)
//            .salesOrderDetailSecondarySpecialBilling(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING)
//            .salesOrderDetailSpanDateSplitBilling(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING)
//            .cmnparCmnFormId(UPDATED_CMNPAR_CMN_FORM_ID)
//            .cmnparCmnCreateDate(UPDATED_CMNPAR_CMN_CREATE_DATE)
//            .cmnparCmnExpirationDate(UPDATED_CMNPAR_CMN_EXPIRATION_DATE)
//            .cmnparCmnRecertificationDate(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE)
//            .cmnparCmnPhysicianDate(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE)
//            .cmnparCmnStatus(UPDATED_CMNPAR_CMN_STATUS)
//            .cmnparParId(UPDATED_CMNPAR_PAR_ID)
//            .cmnparCmnLogDate(UPDATED_CMNPAR_CMN_LOG_DATE)
//            .cmnparCmnPrintedDate(UPDATED_CMNPAR_CMN_PRINTED_DATE)
//            .cmnparCmnPlaceholder(UPDATED_CMNPAR_CMN_PLACEHOLDER)
//            .cmnparCmnLoggedBy(UPDATED_CMNPAR_CMN_LOGGED_BY)
//            .cmnparNumberOfRefills(UPDATED_CMNPAR_NUMBER_OF_REFILLS)
//            .status(UPDATED_STATUS)
//            .createdByName(UPDATED_CREATED_BY_NAME)
//            .createdDate(UPDATED_CREATED_DATE)
//            .updatedById(UPDATED_UPDATED_BY_ID)
//            .updatedByName(UPDATED_UPDATED_BY_NAME)
//            .updatedDate(UPDATED_UPDATED_DATE);
//
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderItemDetails.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderItemDetails testSalesOrderItemDetails = salesOrderItemDetailsList.get(salesOrderItemDetailsList.size() - 1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderItemDetailsId()).isEqualTo(UPDATED_SALES_ORDER_ITEM_DETAILS_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
//        assertThat(testSalesOrderItemDetails.getPatientId()).isEqualTo(DEFAULT_PATIENT_ID);
//        assertThat(testSalesOrderItemDetails.getItemLocationId()).isEqualTo(UPDATED_ITEM_LOCATION_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemId()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUom()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUomName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_STOCKING_UOM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemDescription()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_DESCRIPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDefaultVendor()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_DEFAULT_VENDOR);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailOriginalDos()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ORIGINAL_DOS);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPreviousBillingDate())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextBillingDate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDosTo()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextPeriod()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialPricing()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOverride()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialTaxRate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailQty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailBqty()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_BQTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLineQty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_LINE_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailProcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOption()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier4()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailChargeAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAllowedAmt()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxable()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_TAXABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbn()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnUpgrade()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnPrintDate()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_PRINT_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnItem()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_ITEM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnProcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnAllow()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_ALLOW);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnCharge()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_CHARGE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ABN_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxRate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxZone()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNonTaxReason()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_NON_TAX_REASON);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNote()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NOTE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSaleType()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SALE_TYPE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemGroup()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ITEM_USER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailConvertedToPurchase())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpChargeAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier1()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpPeriod()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MCTP_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier2()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier3()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextDateOfService())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceTable()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_TABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOptionName()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemNdcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturer()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPricing()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbOverride()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMessages()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MESSAGES);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLocation()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_LOCATION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCaloriesPerDay()).isEqualTo(DEFAULT_SALES_ORDER_DETAIL_CALORIES_PER_DAY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber())
//            .isEqualTo(DEFAULT_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER);
//        assertThat(testSalesOrderItemDetails.getCmnId()).isEqualTo(DEFAULT_CMN_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFormId()).isEqualTo(UPDATED_CMNPAR_CMN_FORM_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnKey()).isEqualTo(DEFAULT_CMNPAR_CMN_KEY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnCreateDate()).isEqualTo(UPDATED_CMNPAR_CMN_CREATE_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnExpirationDate()).isEqualTo(UPDATED_CMNPAR_CMN_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnInitialDate()).isEqualTo(DEFAULT_CMNPAR_CMN_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRenewalDate()).isEqualTo(DEFAULT_CMNPAR_CMN_RENEWAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRecertificationDate()).isEqualTo(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPhysicianDate()).isEqualTo(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnStatus()).isEqualTo(UPDATED_CMNPAR_CMN_STATUS);
//        assertThat(testSalesOrderItemDetails.getCmnparParId()).isEqualTo(UPDATED_CMNPAR_PAR_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparParDescr()).isEqualTo(DEFAULT_CMNPAR_PAR_DESCR);
//        assertThat(testSalesOrderItemDetails.getCmnparParInitialDate()).isEqualTo(DEFAULT_CMNPAR_PAR_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparParExpirationDate()).isEqualTo(DEFAULT_CMNPAR_PAR_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLogDate()).isEqualTo(UPDATED_CMNPAR_CMN_LOG_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLengthOfNeed()).isEqualTo(DEFAULT_CMNPAR_CMN_LENGTH_OF_NEED);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedDate()).isEqualTo(UPDATED_CMNPAR_CMN_PRINTED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_PRINTED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparFaxedDate()).isEqualTo(DEFAULT_CMNPAR_FAXED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPlaceholder()).isEqualTo(UPDATED_CMNPAR_CMN_PLACEHOLDER);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFaxedBy()).isEqualTo(DEFAULT_CMNPAR_CMN_FAXED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLoggedBy()).isEqualTo(UPDATED_CMNPAR_CMN_LOGGED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparNumberOfRefills()).isEqualTo(UPDATED_CMNPAR_NUMBER_OF_REFILLS);
//        assertThat(testSalesOrderItemDetails.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderItemDetails.getCreatedById()).isEqualTo(DEFAULT_CREATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderItemDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void fullUpdateSalesOrderItemDetailsWithPatch() throws Exception {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//
//        // Update the salesOrderItemDetails using partial update
//        SalesOrderItemDetails partialUpdatedSalesOrderItemDetails = new SalesOrderItemDetails();
//        partialUpdatedSalesOrderItemDetails.setId(salesOrderItemDetails.getId());
//
//        partialUpdatedSalesOrderItemDetails
//            .salesOrderItemDetailsId(UPDATED_SALES_ORDER_ITEM_DETAILS_ID)
//            .salesOrderId(UPDATED_SALES_ORDER_ID)
//            .patientId(UPDATED_PATIENT_ID)
//            .itemLocationId(UPDATED_ITEM_LOCATION_ID)
//            .salesOrderDetailItemId(UPDATED_SALES_ORDER_DETAIL_ITEM_ID)
//            .salesOrderDetailItemName(UPDATED_SALES_ORDER_DETAIL_ITEM_NAME)
//            .salesOrderDetailStockingUom(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM)
//            .salesOrderDetailStockingUomName(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM_NAME)
//            .salesOrderDetailItemDescription(UPDATED_SALES_ORDER_DETAIL_ITEM_DESCRIPTION)
//            .salesOrderDetailDefaultVendor(UPDATED_SALES_ORDER_DETAIL_DEFAULT_VENDOR)
//            .salesOrderDetailOriginalDos(UPDATED_SALES_ORDER_DETAIL_ORIGINAL_DOS)
//            .salesOrderDetailPreviousBillingDate(UPDATED_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE)
//            .salesOrderDetailNextBillingDate(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE)
//            .salesOrderDetailDosTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO)
//            .salesOrderDetailNextPeriod(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD)
//            .salesOrderDetailSpecialPricing(UPDATED_SALES_ORDER_DETAIL_SPECIAL_PRICING)
//            .salesOrderDetailPriceOverride(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE)
//            .salesOrderDetailSpecialTaxRate(UPDATED_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE)
//            .salesOrderDetailQty(UPDATED_SALES_ORDER_DETAIL_QTY)
//            .salesOrderDetailBqty(UPDATED_SALES_ORDER_DETAIL_BQTY)
//            .salesOrderDetailLineQty(UPDATED_SALES_ORDER_DETAIL_LINE_QTY)
//            .salesOrderDetailProcCode(UPDATED_SALES_ORDER_DETAIL_PROC_CODE)
//            .salesOrderDetailPriceOption(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION)
//            .salesOrderDetailModifier1(UPDATED_SALES_ORDER_DETAIL_MODIFIER_1)
//            .salesOrderDetailModifier2(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2)
//            .salesOrderDetailModifier3(UPDATED_SALES_ORDER_DETAIL_MODIFIER_3)
//            .salesOrderDetailModifier4(UPDATED_SALES_ORDER_DETAIL_MODIFIER_4)
//            .salesOrderDetailChargeAmt(UPDATED_SALES_ORDER_DETAIL_CHARGE_AMT)
//            .salesOrderDetailAllowedAmt(UPDATED_SALES_ORDER_DETAIL_ALLOWED_AMT)
//            .salesOrderDetailTaxable(UPDATED_SALES_ORDER_DETAIL_TAXABLE)
//            .salesOrderDetailAbn(UPDATED_SALES_ORDER_DETAIL_ABN)
//            .salesOrderDetailAbnUpgrade(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE)
//            .salesOrderDetailAbnPrintDate(UPDATED_SALES_ORDER_DETAIL_ABN_PRINT_DATE)
//            .salesOrderDetailAbnItem(UPDATED_SALES_ORDER_DETAIL_ABN_ITEM)
//            .salesOrderDetailAbnProcCode(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE)
//            .salesOrderDetailAbnAllow(UPDATED_SALES_ORDER_DETAIL_ABN_ALLOW)
//            .salesOrderDetailAbnCharge(UPDATED_SALES_ORDER_DETAIL_ABN_CHARGE)
//            .salesOrderDetailAbnModifier1(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1)
//            .salesOrderDetailAbnModifier2(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_2)
//            .salesOrderDetailTaxRate(UPDATED_SALES_ORDER_DETAIL_TAX_RATE)
//            .salesOrderDetailTaxZone(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE)
//            .salesOrderDetailNonTaxReason(UPDATED_SALES_ORDER_DETAIL_NON_TAX_REASON)
//            .salesOrderDetailNote(UPDATED_SALES_ORDER_DETAIL_NOTE)
//            .salesOrderDetailSaleType(UPDATED_SALES_ORDER_DETAIL_SALE_TYPE)
//            .salesOrderDetailItemGroup(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP)
//            .salesOrderDetailItemUser1(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1)
//            .salesOrderDetailItemUser2(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2)
//            .salesOrderDetailItemUser3(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_3)
//            .salesOrderDetailItemUser4(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4)
//            .salesOrderDetailConvertedToPurchase(UPDATED_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE)
//            .salesOrderDetailManualConvertToPurchaseMctp(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP)
//            .salesOrderDetailMctpChargeAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT)
//            .salesOrderDetailMctpAllowedAmt(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT)
//            .salesOrderDetailMctpModifier1(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_1)
//            .salesOrderDetailMctpModifier2(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2)
//            .salesOrderDetailMctpModifier3(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3)
//            .salesOrderDetailMctpModifier4(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4)
//            .salesOrderDetailMctpPeriod(UPDATED_SALES_ORDER_DETAIL_MCTP_PERIOD)
//            .salesOrderDetailAddtlModifier1(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1)
//            .salesOrderDetailAddtlModifier2(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2)
//            .salesOrderDetailAddtlModifier3(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3)
//            .salesOrderDetailAddtlModifier4(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4)
//            .salesOrderDetailNextDateOfService(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE)
//            .salesOrderDetailPriceTable(UPDATED_SALES_ORDER_DETAIL_PRICE_TABLE)
//            .salesOrderDetailPriceOptionName(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION_NAME)
//            .salesOrderDetailExtendedChargeAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT)
//            .salesOrderDetailExtendedAllowanceAmount(UPDATED_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT)
//            .salesOrderDetailItemNdcCode(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE)
//            .salesOrderDetailManufacturer(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER)
//            .salesOrderDetailCbPricing(UPDATED_SALES_ORDER_DETAIL_CB_PRICING)
//            .salesOrderDetailCbPriceTableOverride(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE)
//            .salesOrderDetailCbOverride(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE)
//            .salesOrderDetailMessages(UPDATED_SALES_ORDER_DETAIL_MESSAGES)
//            .salesOrderDetailLocation(UPDATED_SALES_ORDER_DETAIL_LOCATION)
//            .salesOrderDetailCaloriesPerDay(UPDATED_SALES_ORDER_DETAIL_CALORIES_PER_DAY)
//            .salesOrderDetailSecondaryBillingProcudureCode(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE)
//            .salesOrderDetailSecondaryBillingPriceOption(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION)
//            .salesOrderDetailSecondaryBillingPriceOptionName(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME)
//            .salesOrderDetailSecondaryBillingModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingAdditionalModifier1(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1)
//            .salesOrderDetailSecondaryBillingadditionalModifier2(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2)
//            .salesOrderDetailSecondaryBillingadditionalModifier3(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3)
//            .salesOrderDetailSecondaryBillingadditionalModifier4(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4)
//            .salesOrderDetailSecondaryBillingIgnore(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE)
//            .salesOrderDetailSecondarySpecialBilling(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING)
//            .salesOrderDetailSpanDateSplitBilling(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING)
//            .salesOrderDetailManufacturerItemIdNumber(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER)
//            .cmnId(UPDATED_CMN_ID)
//            .cmnparCmnFormId(UPDATED_CMNPAR_CMN_FORM_ID)
//            .cmnparCmnKey(UPDATED_CMNPAR_CMN_KEY)
//            .cmnparCmnCreateDate(UPDATED_CMNPAR_CMN_CREATE_DATE)
//            .cmnparCmnExpirationDate(UPDATED_CMNPAR_CMN_EXPIRATION_DATE)
//            .cmnparCmnInitialDate(UPDATED_CMNPAR_CMN_INITIAL_DATE)
//            .cmnparCmnRenewalDate(UPDATED_CMNPAR_CMN_RENEWAL_DATE)
//            .cmnparCmnRecertificationDate(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE)
//            .cmnparCmnPhysicianDate(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE)
//            .cmnparCmnStatus(UPDATED_CMNPAR_CMN_STATUS)
//            .cmnparParId(UPDATED_CMNPAR_PAR_ID)
//            .cmnparParDescr(UPDATED_CMNPAR_PAR_DESCR)
//            .cmnparParInitialDate(UPDATED_CMNPAR_PAR_INITIAL_DATE)
//            .cmnparParExpirationDate(UPDATED_CMNPAR_PAR_EXPIRATION_DATE)
//            .cmnparCmnLogDate(UPDATED_CMNPAR_CMN_LOG_DATE)
//            .cmnparCmnLengthOfNeed(UPDATED_CMNPAR_CMN_LENGTH_OF_NEED)
//            .cmnparCmnPrintedDate(UPDATED_CMNPAR_CMN_PRINTED_DATE)
//            .cmnparCmnPrintedBy(UPDATED_CMNPAR_CMN_PRINTED_BY)
//            .cmnparFaxedDate(UPDATED_CMNPAR_FAXED_DATE)
//            .cmnparCmnPlaceholder(UPDATED_CMNPAR_CMN_PLACEHOLDER)
//            .cmnparCmnFaxedBy(UPDATED_CMNPAR_CMN_FAXED_BY)
//            .cmnparCmnLoggedBy(UPDATED_CMNPAR_CMN_LOGGED_BY)
//            .cmnparNumberOfRefills(UPDATED_CMNPAR_NUMBER_OF_REFILLS)
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
//            .uri(ENTITY_API_URL_ID, partialUpdatedSalesOrderItemDetails.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isOk();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//        SalesOrderItemDetails testSalesOrderItemDetails = salesOrderItemDetailsList.get(salesOrderItemDetailsList.size() - 1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderItemDetailsId()).isEqualTo(UPDATED_SALES_ORDER_ITEM_DETAILS_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderId()).isEqualTo(UPDATED_SALES_ORDER_ID);
//        assertThat(testSalesOrderItemDetails.getPatientId()).isEqualTo(UPDATED_PATIENT_ID);
//        assertThat(testSalesOrderItemDetails.getItemLocationId()).isEqualTo(UPDATED_ITEM_LOCATION_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemId()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_ID);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemName()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUom()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailStockingUomName()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_STOCKING_UOM_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemDescription()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_DESCRIPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDefaultVendor()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_DEFAULT_VENDOR);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailOriginalDos()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ORIGINAL_DOS);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPreviousBillingDate())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_PREVIOUS_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextBillingDate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_BILLING_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailDosTo()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_DOS_TO);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextPeriod()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialPricing()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPECIAL_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOverride()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpecialTaxRate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPECIAL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailQty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailBqty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_BQTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLineQty()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_LINE_QTY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailProcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOption()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailChargeAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAllowedAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxable()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAXABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbn()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnUpgrade()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_UPGRADE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnPrintDate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_PRINT_DATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnItem()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_ITEM);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnProcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_PROC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnAllow()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_ALLOW);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnCharge()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_CHARGE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAbnModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ABN_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxRate()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAX_RATE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailTaxZone()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_TAX_ZONE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNonTaxReason()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NON_TAX_REASON);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNote()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_NOTE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSaleType()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_SALE_TYPE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemGroup()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_GROUP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemUser4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_USER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailConvertedToPurchase())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_CONVERTED_TO_PURCHASE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUAL_CONVERT_TO_PURCHASE_MCTP);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpChargeAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_CHARGE_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_ALLOWED_AMT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMctpPeriod()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MCTP_PERIOD);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier1()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier2()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier3()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailAddtlModifier4()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ADDTL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailNextDateOfService())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_NEXT_DATE_OF_SERVICE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceTable()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_TABLE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailPriceOptionName()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_EXTENDED_CHARGE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_EXTENDED_ALLOWANCE_AMOUNT);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailItemNdcCode()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_ITEM_NDC_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturer()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPricing()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_PRICING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_PRICE_TABLE_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCbOverride()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CB_OVERRIDE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailMessages()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_MESSAGES);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailLocation()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_LOCATION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailCaloriesPerDay()).isEqualTo(UPDATED_SALES_ORDER_DETAIL_CALORIES_PER_DAY);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PROCUDURE_CODE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_PRICE_OPTION_NAME);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_ADDITIONAL_MODIFIER_1);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_2);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_3);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLINGADDITIONAL_MODIFIER_4);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_BILLING_IGNORE);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SECONDARY_SPECIAL_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_SPAN_DATE_SPLIT_BILLING);
//        assertThat(testSalesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber())
//            .isEqualTo(UPDATED_SALES_ORDER_DETAIL_MANUFACTURER_ITEM_ID_NUMBER);
//        assertThat(testSalesOrderItemDetails.getCmnId()).isEqualTo(UPDATED_CMN_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFormId()).isEqualTo(UPDATED_CMNPAR_CMN_FORM_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnKey()).isEqualTo(UPDATED_CMNPAR_CMN_KEY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnCreateDate()).isEqualTo(UPDATED_CMNPAR_CMN_CREATE_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnExpirationDate()).isEqualTo(UPDATED_CMNPAR_CMN_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnInitialDate()).isEqualTo(UPDATED_CMNPAR_CMN_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRenewalDate()).isEqualTo(UPDATED_CMNPAR_CMN_RENEWAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnRecertificationDate()).isEqualTo(UPDATED_CMNPAR_CMN_RECERTIFICATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPhysicianDate()).isEqualTo(UPDATED_CMNPAR_CMN_PHYSICIAN_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnStatus()).isEqualTo(UPDATED_CMNPAR_CMN_STATUS);
//        assertThat(testSalesOrderItemDetails.getCmnparParId()).isEqualTo(UPDATED_CMNPAR_PAR_ID);
//        assertThat(testSalesOrderItemDetails.getCmnparParDescr()).isEqualTo(UPDATED_CMNPAR_PAR_DESCR);
//        assertThat(testSalesOrderItemDetails.getCmnparParInitialDate()).isEqualTo(UPDATED_CMNPAR_PAR_INITIAL_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparParExpirationDate()).isEqualTo(UPDATED_CMNPAR_PAR_EXPIRATION_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLogDate()).isEqualTo(UPDATED_CMNPAR_CMN_LOG_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLengthOfNeed()).isEqualTo(UPDATED_CMNPAR_CMN_LENGTH_OF_NEED);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedDate()).isEqualTo(UPDATED_CMNPAR_CMN_PRINTED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPrintedBy()).isEqualTo(UPDATED_CMNPAR_CMN_PRINTED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparFaxedDate()).isEqualTo(UPDATED_CMNPAR_FAXED_DATE);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnPlaceholder()).isEqualTo(UPDATED_CMNPAR_CMN_PLACEHOLDER);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnFaxedBy()).isEqualTo(UPDATED_CMNPAR_CMN_FAXED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparCmnLoggedBy()).isEqualTo(UPDATED_CMNPAR_CMN_LOGGED_BY);
//        assertThat(testSalesOrderItemDetails.getCmnparNumberOfRefills()).isEqualTo(UPDATED_CMNPAR_NUMBER_OF_REFILLS);
//        assertThat(testSalesOrderItemDetails.getStatus()).isEqualTo(UPDATED_STATUS);
//        assertThat(testSalesOrderItemDetails.getCreatedById()).isEqualTo(UPDATED_CREATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getCreatedByName()).isEqualTo(UPDATED_CREATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
//        assertThat(testSalesOrderItemDetails.getUpdatedById()).isEqualTo(UPDATED_UPDATED_BY_ID);
//        assertThat(testSalesOrderItemDetails.getUpdatedByName()).isEqualTo(UPDATED_UPDATED_BY_NAME);
//        assertThat(testSalesOrderItemDetails.getUpdatedDate()).isEqualTo(UPDATED_UPDATED_DATE);
//    }
//
//    @Test
//    void patchNonExistingSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        salesOrderItemDetails.setId(count.incrementAndGet());
//
//        // If the entity doesn't have an ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, salesOrderItemDetails.getId())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithIdMismatchSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        salesOrderItemDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isBadRequest();
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void patchWithMissingIdPathParamSalesOrderItemDetails() throws Exception {
//        int databaseSizeBeforeUpdate = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//        salesOrderItemDetails.setId(count.incrementAndGet());
//
//        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
//        webTestClient
//            .patch()
//            .uri(ENTITY_API_URL)
//            .contentType(MediaType.valueOf("application/merge-patch+json"))
//            .bodyValue(TestUtil.convertObjectToJsonBytes(salesOrderItemDetails))
//            .exchange()
//            .expectStatus()
//            .isEqualTo(405);
//
//        // Validate the SalesOrderItemDetails in the database
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeUpdate);
//    }
//
//    @Test
//    void deleteSalesOrderItemDetails() {
//        // Initialize the database
//        salesOrderItemDetailsRepository.save(salesOrderItemDetails).block();
//
//        int databaseSizeBeforeDelete = salesOrderItemDetailsRepository.findAll().collectList().block().size();
//
//        // Delete the salesOrderItemDetails
//        webTestClient
//            .delete()
//            .uri(ENTITY_API_URL_ID, salesOrderItemDetails.getId())
//            .accept(MediaType.APPLICATION_JSON)
//            .exchange()
//            .expectStatus()
//            .isNoContent();
//
//        // Validate the database contains one less item
//        List<SalesOrderItemDetails> salesOrderItemDetailsList = salesOrderItemDetailsRepository.findAll().collectList().block();
//        assertThat(salesOrderItemDetailsList).hasSize(databaseSizeBeforeDelete - 1);
//    }
}
