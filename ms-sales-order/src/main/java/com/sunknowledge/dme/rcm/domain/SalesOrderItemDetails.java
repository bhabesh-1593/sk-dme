package com.sunknowledge.dme.rcm.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A SalesOrderItemDetails.
 */

@Table("t_sales_order_item_details")
public class SalesOrderItemDetails implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Column("id")
//    private Long id;

    @Id
    @NotNull(message = "must not be null")
    @Column("sales_order_item_details_id")
    private Integer salesOrderItemDetailsId;

    @NotNull(message = "must not be null")
    @Column("sales_order_id")
    private Integer salesOrderId;

    @NotNull(message = "must not be null")
    @Column("patient_id")
    private Integer patientId;

    @NotNull(message = "must not be null")
    @Column("item_location_id")
    private Integer itemLocationId;

    @NotNull(message = "must not be null")
    @Column("sales_order_detail_item_id")
    private Integer salesOrderDetailItemId;

    @NotNull(message = "must not be null")
    @Column("sales_order_detail_item_name")
    private String salesOrderDetailItemName;

    @Column("sales_order_detail_stocking_uom")
    private String salesOrderDetailStockingUom;

    @Column("sales_order_detail_stocking_uom_name")
    private String salesOrderDetailStockingUomName;

    @Column("sales_order_detail_item_description")
    private String salesOrderDetailItemDescription;

    @Column("sales_order_detail_default_vendor")
    private String salesOrderDetailDefaultVendor;

    @Column("sales_order_detail_original_dos")
    private LocalDate salesOrderDetailOriginalDos;

    @Column("sales_order_detail_previous_billing_date")
    private LocalDate salesOrderDetailPreviousBillingDate;

    @Column("sales_order_detail_next_billing_date")
    private LocalDate salesOrderDetailNextBillingDate;

    @Column("sales_order_detail_dos_to")
    private LocalDate salesOrderDetailDosTo;

    @Column("sales_order_detail_next_period")
    private String salesOrderDetailNextPeriod;

    @Column("sales_order_detail_special_pricing")
    private String salesOrderDetailSpecialPricing;

    @Column("sales_order_detail_price_override")
    private String salesOrderDetailPriceOverride;

    @Column("sales_order_detail_special_tax_rate")
    private Integer salesOrderDetailSpecialTaxRate;

    @Column("sales_order_detail_qty")
    private Integer salesOrderDetailQty;

    @Column("sales_order_detail_bqty")
    private Integer salesOrderDetailBqty;

    @Column("sales_order_detail_line_qty")
    private Integer salesOrderDetailLineQty;

    @Column("sales_order_detail_proc_code")
    private String salesOrderDetailProcCode;

    @Column("sales_order_detail_price_option")
    private String salesOrderDetailPriceOption;

    @Column("sales_order_detail_modifier1")
    private String salesOrderDetailModifier1;

    @Column("sales_order_detail_modifier2")
    private String salesOrderDetailModifier2;

    @Column("sales_order_detail_modifier3")
    private String salesOrderDetailModifier3;

    @Column("sales_order_detail_modifier4")
    private String salesOrderDetailModifier4;

    @Column("sales_order_detail_charge_amt")
    private Double salesOrderDetailChargeAmt;

    @Column("sales_order_detail_allowed_amt")
    private Double salesOrderDetailAllowedAmt;

    @Column("sales_order_detail_taxable")
    private String salesOrderDetailTaxable;

    @Column("sales_order_detail_abn")
    private String salesOrderDetailAbn;

    @Column("sales_order_detail_abn_upgrade")
    private String salesOrderDetailAbnUpgrade;

    @Column("sales_order_detail_abn_print_date")
    private LocalDate salesOrderDetailAbnPrintDate;

    @Column("sales_order_detail_abn_item")
    private String salesOrderDetailAbnItem;

    @Column("sales_order_detail_abn_proc_code")
    private String salesOrderDetailAbnProcCode;

    @Column("sales_order_detail_abn_allow")
    private String salesOrderDetailAbnAllow;

    @Column("sales_order_detail_abn_charge")
    private Integer salesOrderDetailAbnCharge;

    @Column("sales_order_detail_abn_modifier1")
    private String salesOrderDetailAbnModifier1;

    @Column("sales_order_detail_abn_modifier2")
    private String salesOrderDetailAbnModifier2;

    @Column("sales_order_detail_tax_rate")
    private Integer salesOrderDetailTaxRate;

    @Column("sales_order_detail_tax_zone")
    private String salesOrderDetailTaxZone;

    @Column("sales_order_detail_non_tax_reason")
    private String salesOrderDetailNonTaxReason;

    @Column("sales_order_detail_note")
    private String salesOrderDetailNote;

    @Column("sales_order_detail_sale_type")
    private String salesOrderDetailSaleType;

    @Column("sales_order_detail_item_group")
    private String salesOrderDetailItemGroup;

    @Column("sales_order_detail_item_user1")
    private String salesOrderDetailItemUser1;

    @Column("sales_order_detail_item_user2")
    private String salesOrderDetailItemUser2;

    @Column("sales_order_detail_item_user3")
    private String salesOrderDetailItemUser3;

    @Column("sales_order_detail_item_user4")
    private String salesOrderDetailItemUser4;

    @Column("sales_order_detail_converted_to_purchase")
    private String salesOrderDetailConvertedToPurchase;

    @Column("sales_order_detail_manual_convert_to_purchase_mctp")
    private String salesOrderDetailManualConvertToPurchaseMctp;

    @Column("sales_order_detail_mctp_charge_amt")
    private Double salesOrderDetailMctpChargeAmt;

    @Column("sales_order_detail_mctp_allowed_amt")
    private Double salesOrderDetailMctpAllowedAmt;

    @Column("sales_order_detail_mctp_modifier1")
    private String salesOrderDetailMctpModifier1;

    @Column("sales_order_detail_mctp_modifier2")
    private String salesOrderDetailMctpModifier2;

    @Column("sales_order_detail_mctp_modifier3")
    private String salesOrderDetailMctpModifier3;

    @Column("sales_order_detail_mctp_modifier4")
    private String salesOrderDetailMctpModifier4;

    @Column("sales_order_detail_mctp_period")
    private Integer salesOrderDetailMctpPeriod;

    @Column("sales_order_detail_addtl_modifier1")
    private String salesOrderDetailAddtlModifier1;

    @Column("sales_order_detail_addtl_modifier2")
    private String salesOrderDetailAddtlModifier2;

    @Column("sales_order_detail_addtl_modifier3")
    private String salesOrderDetailAddtlModifier3;

    @Column("sales_order_detail_addtl_modifier4")
    private String salesOrderDetailAddtlModifier4;

    @Column("sales_order_detail_next_date_of_service")
    private LocalDate salesOrderDetailNextDateOfService;

    @Column("sales_order_detail_price_table")
    private String salesOrderDetailPriceTable;

    @Column("sales_order_detail_price_option_name")
    private String salesOrderDetailPriceOptionName;

    @Column("sales_order_detail_extended_charge_amount")
    private Double salesOrderDetailExtendedChargeAmount;

    @Column("sales_order_detail_extended_allowance_amount")
    private Double salesOrderDetailExtendedAllowanceAmount;

    @Column("sales_order_detail_item_ndc_code")
    private String salesOrderDetailItemNdcCode;

    @Column("sales_order_detail_manufacturer")
    private String salesOrderDetailManufacturer;

    @Column("sales_order_detail_cb_pricing")
    private String salesOrderDetailCbPricing;

    @Column("sales_order_detail_cb_price_table_override")
    private String salesOrderDetailCbPriceTableOverride;

    @Column("sales_order_detail_cb_override")
    private String salesOrderDetailCbOverride;

    @Column("sales_order_detail_messages")
    private String salesOrderDetailMessages;

    @Column("sales_order_detail_location")
    private Integer salesOrderDetailLocation;

    @Column("sales_order_detail_calories_per_day")
    private Integer salesOrderDetailCaloriesPerDay;

    @Column("sales_order_detail_secondary_billing_procudure_code")
    private String salesOrderDetailSecondaryBillingProcudureCode;

    @Column("sales_order_detail_secondary_billing_price_option")
    private String salesOrderDetailSecondaryBillingPriceOption;

    @Column("sales_order_detail_secondary_billing_price_option_name")
    private String salesOrderDetailSecondaryBillingPriceOptionName;

    @Column("sales_order_detail_secondary_billing_modifier1")
    private String salesOrderDetailSecondaryBillingModifier1;

    @Column("sales_order_detail_secondary_billing_modifier2")
    private String salesOrderDetailSecondaryBillingModifier2;

    @Column("sales_order_detail_secondary_billing_modifier3")
    private String salesOrderDetailSecondaryBillingModifier3;

    @Column("sales_order_detail_secondary_billing_modifier4")
    private String salesOrderDetailSecondaryBillingModifier4;

    @Column("sales_order_detail_secondary_billing_additional_modifier1")
    private String salesOrderDetailSecondaryBillingAdditionalModifier1;

    @Column("sales_order_detail_secondary_billingadditional_modifier2")
    private String salesOrderDetailSecondaryBillingadditionalModifier2;

    @Column("sales_order_detail_secondary_billingadditional_modifier3")
    private String salesOrderDetailSecondaryBillingadditionalModifier3;

    @Column("sales_order_detail_secondary_billingadditional_modifier4")
    private String salesOrderDetailSecondaryBillingadditionalModifier4;

    @Column("sales_order_detail_secondary_billing_ignore")
    private String salesOrderDetailSecondaryBillingIgnore;

    @Column("sales_order_detail_secondary_special_billing")
    private String salesOrderDetailSecondarySpecialBilling;

    @Column("sales_order_detail_span_date_split_billing")
    private String salesOrderDetailSpanDateSplitBilling;

    @Column("sales_order_detail_manufacturer_item_id_number")
    private String salesOrderDetailManufacturerItemIdNumber;

    @Column("cmn_id")
    private Integer cmnId;

    @Column("cmnpar_cmn_form_id")
    private Integer cmnparCmnFormId;

    @Column("cmnpar_cmn_key")
    private String cmnparCmnKey;

    @Column("cmnpar_cmn_create_date")
    private LocalDate cmnparCmnCreateDate;

    @Column("cmnpar_cmn_expiration_date")
    private LocalDate cmnparCmnExpirationDate;

    @Column("cmnpar_cmn_initial_date")
    private LocalDate cmnparCmnInitialDate;

    @Column("cmnpar_cmn_renewal_date")
    private LocalDate cmnparCmnRenewalDate;

    @Column("cmnpar_cmn_recertification_date")
    private LocalDate cmnparCmnRecertificationDate;

    @Column("cmnpar_cmn_physician_date")
    private LocalDate cmnparCmnPhysicianDate;

    @Column("cmnpar_cmn_status")
    private String cmnparCmnStatus;

    @Column("cmnpar_par_id")
    private Integer cmnparParId;

    @Column("cmnpar_par_descr")
    private String cmnparParDescr;

    @Column("cmnpar_par_initial_date")
    private LocalDate cmnparParInitialDate;

    @Column("cmnpar_par_expiration_date")
    private LocalDate cmnparParExpirationDate;

    @Column("cmnpar_cmn_log_date")
    private LocalDate cmnparCmnLogDate;

    @Column("cmnpar_cmn_length_of_need")
    private Integer cmnparCmnLengthOfNeed;

    @Column("cmnpar_cmn_printed_date")
    private LocalDate cmnparCmnPrintedDate;

    @Column("cmnpar_cmn_printed_by")
    private String cmnparCmnPrintedBy;

    @Column("cmnpar_faxed_date")
    private LocalDate cmnparFaxedDate;

    @Column("cmnpar_cmn_placeholder")
    private String cmnparCmnPlaceholder;

    @Column("cmnpar_cmn_faxed_by")
    private String cmnparCmnFaxedBy;

    @Column("cmnpar_cmn_logged_by")
    private String cmnparCmnLoggedBy;

    @Column("cmnpar_number_of_refills")
    private Integer cmnparNumberOfRefills;

    @Column("status")
    private String status;

    @Column("created_by_id")
    private Integer createdById;

    @Column("created_by_name")
    private String createdByName;

    @Column("created_date")
    private ZonedDateTime createdDate;

    @Column("updated_by_id")
    private Integer updatedById;

    @Column("updated_by_name")
    private String updatedByName;

    @Column("updated_date")
    private ZonedDateTime updatedDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Integer getSalesOrderItemDetailsId() {
        return this.salesOrderItemDetailsId;
    }

    public SalesOrderItemDetails salesOrderItemDetailsId(Integer salesOrderItemDetailsId) {
        this.setSalesOrderItemDetailsId(salesOrderItemDetailsId);
        return this;
    }

    public void setSalesOrderItemDetailsId(Integer salesOrderItemDetailsId) {
        this.salesOrderItemDetailsId = salesOrderItemDetailsId;
    }

    public Integer getSalesOrderId() {
        return this.salesOrderId;
    }

    public SalesOrderItemDetails salesOrderId(Integer salesOrderId) {
        this.setSalesOrderId(salesOrderId);
        return this;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getPatientId() {
        return this.patientId;
    }

    public SalesOrderItemDetails patientId(Integer patientId) {
        this.setPatientId(patientId);
        return this;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getItemLocationId() {
        return this.itemLocationId;
    }

    public SalesOrderItemDetails itemLocationId(Integer itemLocationId) {
        this.setItemLocationId(itemLocationId);
        return this;
    }

    public void setItemLocationId(Integer itemLocationId) {
        this.itemLocationId = itemLocationId;
    }

    public Integer getSalesOrderDetailItemId() {
        return this.salesOrderDetailItemId;
    }

    public SalesOrderItemDetails salesOrderDetailItemId(Integer salesOrderDetailItemId) {
        this.setSalesOrderDetailItemId(salesOrderDetailItemId);
        return this;
    }

    public void setSalesOrderDetailItemId(Integer salesOrderDetailItemId) {
        this.salesOrderDetailItemId = salesOrderDetailItemId;
    }

    public String getSalesOrderDetailItemName() {
        return this.salesOrderDetailItemName;
    }

    public SalesOrderItemDetails salesOrderDetailItemName(String salesOrderDetailItemName) {
        this.setSalesOrderDetailItemName(salesOrderDetailItemName);
        return this;
    }

    public void setSalesOrderDetailItemName(String salesOrderDetailItemName) {
        this.salesOrderDetailItemName = salesOrderDetailItemName;
    }

    public String getSalesOrderDetailStockingUom() {
        return this.salesOrderDetailStockingUom;
    }

    public SalesOrderItemDetails salesOrderDetailStockingUom(String salesOrderDetailStockingUom) {
        this.setSalesOrderDetailStockingUom(salesOrderDetailStockingUom);
        return this;
    }

    public void setSalesOrderDetailStockingUom(String salesOrderDetailStockingUom) {
        this.salesOrderDetailStockingUom = salesOrderDetailStockingUom;
    }

    public String getSalesOrderDetailStockingUomName() {
        return this.salesOrderDetailStockingUomName;
    }

    public SalesOrderItemDetails salesOrderDetailStockingUomName(String salesOrderDetailStockingUomName) {
        this.setSalesOrderDetailStockingUomName(salesOrderDetailStockingUomName);
        return this;
    }

    public void setSalesOrderDetailStockingUomName(String salesOrderDetailStockingUomName) {
        this.salesOrderDetailStockingUomName = salesOrderDetailStockingUomName;
    }

    public String getSalesOrderDetailItemDescription() {
        return this.salesOrderDetailItemDescription;
    }

    public SalesOrderItemDetails salesOrderDetailItemDescription(String salesOrderDetailItemDescription) {
        this.setSalesOrderDetailItemDescription(salesOrderDetailItemDescription);
        return this;
    }

    public void setSalesOrderDetailItemDescription(String salesOrderDetailItemDescription) {
        this.salesOrderDetailItemDescription = salesOrderDetailItemDescription;
    }

    public String getSalesOrderDetailDefaultVendor() {
        return this.salesOrderDetailDefaultVendor;
    }

    public SalesOrderItemDetails salesOrderDetailDefaultVendor(String salesOrderDetailDefaultVendor) {
        this.setSalesOrderDetailDefaultVendor(salesOrderDetailDefaultVendor);
        return this;
    }

    public void setSalesOrderDetailDefaultVendor(String salesOrderDetailDefaultVendor) {
        this.salesOrderDetailDefaultVendor = salesOrderDetailDefaultVendor;
    }

    public LocalDate getSalesOrderDetailOriginalDos() {
        return this.salesOrderDetailOriginalDos;
    }

    public SalesOrderItemDetails salesOrderDetailOriginalDos(LocalDate salesOrderDetailOriginalDos) {
        this.setSalesOrderDetailOriginalDos(salesOrderDetailOriginalDos);
        return this;
    }

    public void setSalesOrderDetailOriginalDos(LocalDate salesOrderDetailOriginalDos) {
        this.salesOrderDetailOriginalDos = salesOrderDetailOriginalDos;
    }

    public LocalDate getSalesOrderDetailPreviousBillingDate() {
        return this.salesOrderDetailPreviousBillingDate;
    }

    public SalesOrderItemDetails salesOrderDetailPreviousBillingDate(LocalDate salesOrderDetailPreviousBillingDate) {
        this.setSalesOrderDetailPreviousBillingDate(salesOrderDetailPreviousBillingDate);
        return this;
    }

    public void setSalesOrderDetailPreviousBillingDate(LocalDate salesOrderDetailPreviousBillingDate) {
        this.salesOrderDetailPreviousBillingDate = salesOrderDetailPreviousBillingDate;
    }

    public LocalDate getSalesOrderDetailNextBillingDate() {
        return this.salesOrderDetailNextBillingDate;
    }

    public SalesOrderItemDetails salesOrderDetailNextBillingDate(LocalDate salesOrderDetailNextBillingDate) {
        this.setSalesOrderDetailNextBillingDate(salesOrderDetailNextBillingDate);
        return this;
    }

    public void setSalesOrderDetailNextBillingDate(LocalDate salesOrderDetailNextBillingDate) {
        this.salesOrderDetailNextBillingDate = salesOrderDetailNextBillingDate;
    }

    public LocalDate getSalesOrderDetailDosTo() {
        return this.salesOrderDetailDosTo;
    }

    public SalesOrderItemDetails salesOrderDetailDosTo(LocalDate salesOrderDetailDosTo) {
        this.setSalesOrderDetailDosTo(salesOrderDetailDosTo);
        return this;
    }

    public void setSalesOrderDetailDosTo(LocalDate salesOrderDetailDosTo) {
        this.salesOrderDetailDosTo = salesOrderDetailDosTo;
    }

    public String getSalesOrderDetailNextPeriod() {
        return this.salesOrderDetailNextPeriod;
    }

    public SalesOrderItemDetails salesOrderDetailNextPeriod(String salesOrderDetailNextPeriod) {
        this.setSalesOrderDetailNextPeriod(salesOrderDetailNextPeriod);
        return this;
    }

    public void setSalesOrderDetailNextPeriod(String salesOrderDetailNextPeriod) {
        this.salesOrderDetailNextPeriod = salesOrderDetailNextPeriod;
    }

    public String getSalesOrderDetailSpecialPricing() {
        return this.salesOrderDetailSpecialPricing;
    }

    public SalesOrderItemDetails salesOrderDetailSpecialPricing(String salesOrderDetailSpecialPricing) {
        this.setSalesOrderDetailSpecialPricing(salesOrderDetailSpecialPricing);
        return this;
    }

    public void setSalesOrderDetailSpecialPricing(String salesOrderDetailSpecialPricing) {
        this.salesOrderDetailSpecialPricing = salesOrderDetailSpecialPricing;
    }

    public String getSalesOrderDetailPriceOverride() {
        return this.salesOrderDetailPriceOverride;
    }

    public SalesOrderItemDetails salesOrderDetailPriceOverride(String salesOrderDetailPriceOverride) {
        this.setSalesOrderDetailPriceOverride(salesOrderDetailPriceOverride);
        return this;
    }

    public void setSalesOrderDetailPriceOverride(String salesOrderDetailPriceOverride) {
        this.salesOrderDetailPriceOverride = salesOrderDetailPriceOverride;
    }

    public Integer getSalesOrderDetailSpecialTaxRate() {
        return this.salesOrderDetailSpecialTaxRate;
    }

    public SalesOrderItemDetails salesOrderDetailSpecialTaxRate(Integer salesOrderDetailSpecialTaxRate) {
        this.setSalesOrderDetailSpecialTaxRate(salesOrderDetailSpecialTaxRate);
        return this;
    }

    public void setSalesOrderDetailSpecialTaxRate(Integer salesOrderDetailSpecialTaxRate) {
        this.salesOrderDetailSpecialTaxRate = salesOrderDetailSpecialTaxRate;
    }

    public Integer getSalesOrderDetailQty() {
        return this.salesOrderDetailQty;
    }

    public SalesOrderItemDetails salesOrderDetailQty(Integer salesOrderDetailQty) {
        this.setSalesOrderDetailQty(salesOrderDetailQty);
        return this;
    }

    public void setSalesOrderDetailQty(Integer salesOrderDetailQty) {
        this.salesOrderDetailQty = salesOrderDetailQty;
    }

    public Integer getSalesOrderDetailBqty() {
        return this.salesOrderDetailBqty;
    }

    public SalesOrderItemDetails salesOrderDetailBqty(Integer salesOrderDetailBqty) {
        this.setSalesOrderDetailBqty(salesOrderDetailBqty);
        return this;
    }

    public void setSalesOrderDetailBqty(Integer salesOrderDetailBqty) {
        this.salesOrderDetailBqty = salesOrderDetailBqty;
    }

    public Integer getSalesOrderDetailLineQty() {
        return this.salesOrderDetailLineQty;
    }

    public SalesOrderItemDetails salesOrderDetailLineQty(Integer salesOrderDetailLineQty) {
        this.setSalesOrderDetailLineQty(salesOrderDetailLineQty);
        return this;
    }

    public void setSalesOrderDetailLineQty(Integer salesOrderDetailLineQty) {
        this.salesOrderDetailLineQty = salesOrderDetailLineQty;
    }

    public String getSalesOrderDetailProcCode() {
        return this.salesOrderDetailProcCode;
    }

    public SalesOrderItemDetails salesOrderDetailProcCode(String salesOrderDetailProcCode) {
        this.setSalesOrderDetailProcCode(salesOrderDetailProcCode);
        return this;
    }

    public void setSalesOrderDetailProcCode(String salesOrderDetailProcCode) {
        this.salesOrderDetailProcCode = salesOrderDetailProcCode;
    }

    public String getSalesOrderDetailPriceOption() {
        return this.salesOrderDetailPriceOption;
    }

    public SalesOrderItemDetails salesOrderDetailPriceOption(String salesOrderDetailPriceOption) {
        this.setSalesOrderDetailPriceOption(salesOrderDetailPriceOption);
        return this;
    }

    public void setSalesOrderDetailPriceOption(String salesOrderDetailPriceOption) {
        this.salesOrderDetailPriceOption = salesOrderDetailPriceOption;
    }

    public String getSalesOrderDetailModifier1() {
        return this.salesOrderDetailModifier1;
    }

    public SalesOrderItemDetails salesOrderDetailModifier1(String salesOrderDetailModifier1) {
        this.setSalesOrderDetailModifier1(salesOrderDetailModifier1);
        return this;
    }

    public void setSalesOrderDetailModifier1(String salesOrderDetailModifier1) {
        this.salesOrderDetailModifier1 = salesOrderDetailModifier1;
    }

    public String getSalesOrderDetailModifier2() {
        return this.salesOrderDetailModifier2;
    }

    public SalesOrderItemDetails salesOrderDetailModifier2(String salesOrderDetailModifier2) {
        this.setSalesOrderDetailModifier2(salesOrderDetailModifier2);
        return this;
    }

    public void setSalesOrderDetailModifier2(String salesOrderDetailModifier2) {
        this.salesOrderDetailModifier2 = salesOrderDetailModifier2;
    }

    public String getSalesOrderDetailModifier3() {
        return this.salesOrderDetailModifier3;
    }

    public SalesOrderItemDetails salesOrderDetailModifier3(String salesOrderDetailModifier3) {
        this.setSalesOrderDetailModifier3(salesOrderDetailModifier3);
        return this;
    }

    public void setSalesOrderDetailModifier3(String salesOrderDetailModifier3) {
        this.salesOrderDetailModifier3 = salesOrderDetailModifier3;
    }

    public String getSalesOrderDetailModifier4() {
        return this.salesOrderDetailModifier4;
    }

    public SalesOrderItemDetails salesOrderDetailModifier4(String salesOrderDetailModifier4) {
        this.setSalesOrderDetailModifier4(salesOrderDetailModifier4);
        return this;
    }

    public void setSalesOrderDetailModifier4(String salesOrderDetailModifier4) {
        this.salesOrderDetailModifier4 = salesOrderDetailModifier4;
    }

    public Double getSalesOrderDetailChargeAmt() {
        return this.salesOrderDetailChargeAmt;
    }

    public SalesOrderItemDetails salesOrderDetailChargeAmt(Double salesOrderDetailChargeAmt) {
        this.setSalesOrderDetailChargeAmt(salesOrderDetailChargeAmt);
        return this;
    }

    public void setSalesOrderDetailChargeAmt(Double salesOrderDetailChargeAmt) {
        this.salesOrderDetailChargeAmt = salesOrderDetailChargeAmt;
    }

    public Double getSalesOrderDetailAllowedAmt() {
        return this.salesOrderDetailAllowedAmt;
    }

    public SalesOrderItemDetails salesOrderDetailAllowedAmt(Double salesOrderDetailAllowedAmt) {
        this.setSalesOrderDetailAllowedAmt(salesOrderDetailAllowedAmt);
        return this;
    }

    public void setSalesOrderDetailAllowedAmt(Double salesOrderDetailAllowedAmt) {
        this.salesOrderDetailAllowedAmt = salesOrderDetailAllowedAmt;
    }

    public String getSalesOrderDetailTaxable() {
        return this.salesOrderDetailTaxable;
    }

    public SalesOrderItemDetails salesOrderDetailTaxable(String salesOrderDetailTaxable) {
        this.setSalesOrderDetailTaxable(salesOrderDetailTaxable);
        return this;
    }

    public void setSalesOrderDetailTaxable(String salesOrderDetailTaxable) {
        this.salesOrderDetailTaxable = salesOrderDetailTaxable;
    }

    public String getSalesOrderDetailAbn() {
        return this.salesOrderDetailAbn;
    }

    public SalesOrderItemDetails salesOrderDetailAbn(String salesOrderDetailAbn) {
        this.setSalesOrderDetailAbn(salesOrderDetailAbn);
        return this;
    }

    public void setSalesOrderDetailAbn(String salesOrderDetailAbn) {
        this.salesOrderDetailAbn = salesOrderDetailAbn;
    }

    public String getSalesOrderDetailAbnUpgrade() {
        return this.salesOrderDetailAbnUpgrade;
    }

    public SalesOrderItemDetails salesOrderDetailAbnUpgrade(String salesOrderDetailAbnUpgrade) {
        this.setSalesOrderDetailAbnUpgrade(salesOrderDetailAbnUpgrade);
        return this;
    }

    public void setSalesOrderDetailAbnUpgrade(String salesOrderDetailAbnUpgrade) {
        this.salesOrderDetailAbnUpgrade = salesOrderDetailAbnUpgrade;
    }

    public LocalDate getSalesOrderDetailAbnPrintDate() {
        return this.salesOrderDetailAbnPrintDate;
    }

    public SalesOrderItemDetails salesOrderDetailAbnPrintDate(LocalDate salesOrderDetailAbnPrintDate) {
        this.setSalesOrderDetailAbnPrintDate(salesOrderDetailAbnPrintDate);
        return this;
    }

    public void setSalesOrderDetailAbnPrintDate(LocalDate salesOrderDetailAbnPrintDate) {
        this.salesOrderDetailAbnPrintDate = salesOrderDetailAbnPrintDate;
    }

    public String getSalesOrderDetailAbnItem() {
        return this.salesOrderDetailAbnItem;
    }

    public SalesOrderItemDetails salesOrderDetailAbnItem(String salesOrderDetailAbnItem) {
        this.setSalesOrderDetailAbnItem(salesOrderDetailAbnItem);
        return this;
    }

    public void setSalesOrderDetailAbnItem(String salesOrderDetailAbnItem) {
        this.salesOrderDetailAbnItem = salesOrderDetailAbnItem;
    }

    public String getSalesOrderDetailAbnProcCode() {
        return this.salesOrderDetailAbnProcCode;
    }

    public SalesOrderItemDetails salesOrderDetailAbnProcCode(String salesOrderDetailAbnProcCode) {
        this.setSalesOrderDetailAbnProcCode(salesOrderDetailAbnProcCode);
        return this;
    }

    public void setSalesOrderDetailAbnProcCode(String salesOrderDetailAbnProcCode) {
        this.salesOrderDetailAbnProcCode = salesOrderDetailAbnProcCode;
    }

    public String getSalesOrderDetailAbnAllow() {
        return this.salesOrderDetailAbnAllow;
    }

    public SalesOrderItemDetails salesOrderDetailAbnAllow(String salesOrderDetailAbnAllow) {
        this.setSalesOrderDetailAbnAllow(salesOrderDetailAbnAllow);
        return this;
    }

    public void setSalesOrderDetailAbnAllow(String salesOrderDetailAbnAllow) {
        this.salesOrderDetailAbnAllow = salesOrderDetailAbnAllow;
    }

    public Integer getSalesOrderDetailAbnCharge() {
        return this.salesOrderDetailAbnCharge;
    }

    public SalesOrderItemDetails salesOrderDetailAbnCharge(Integer salesOrderDetailAbnCharge) {
        this.setSalesOrderDetailAbnCharge(salesOrderDetailAbnCharge);
        return this;
    }

    public void setSalesOrderDetailAbnCharge(Integer salesOrderDetailAbnCharge) {
        this.salesOrderDetailAbnCharge = salesOrderDetailAbnCharge;
    }

    public String getSalesOrderDetailAbnModifier1() {
        return this.salesOrderDetailAbnModifier1;
    }

    public SalesOrderItemDetails salesOrderDetailAbnModifier1(String salesOrderDetailAbnModifier1) {
        this.setSalesOrderDetailAbnModifier1(salesOrderDetailAbnModifier1);
        return this;
    }

    public void setSalesOrderDetailAbnModifier1(String salesOrderDetailAbnModifier1) {
        this.salesOrderDetailAbnModifier1 = salesOrderDetailAbnModifier1;
    }

    public String getSalesOrderDetailAbnModifier2() {
        return this.salesOrderDetailAbnModifier2;
    }

    public SalesOrderItemDetails salesOrderDetailAbnModifier2(String salesOrderDetailAbnModifier2) {
        this.setSalesOrderDetailAbnModifier2(salesOrderDetailAbnModifier2);
        return this;
    }

    public void setSalesOrderDetailAbnModifier2(String salesOrderDetailAbnModifier2) {
        this.salesOrderDetailAbnModifier2 = salesOrderDetailAbnModifier2;
    }

    public Integer getSalesOrderDetailTaxRate() {
        return this.salesOrderDetailTaxRate;
    }

    public SalesOrderItemDetails salesOrderDetailTaxRate(Integer salesOrderDetailTaxRate) {
        this.setSalesOrderDetailTaxRate(salesOrderDetailTaxRate);
        return this;
    }

    public void setSalesOrderDetailTaxRate(Integer salesOrderDetailTaxRate) {
        this.salesOrderDetailTaxRate = salesOrderDetailTaxRate;
    }

    public String getSalesOrderDetailTaxZone() {
        return this.salesOrderDetailTaxZone;
    }

    public SalesOrderItemDetails salesOrderDetailTaxZone(String salesOrderDetailTaxZone) {
        this.setSalesOrderDetailTaxZone(salesOrderDetailTaxZone);
        return this;
    }

    public void setSalesOrderDetailTaxZone(String salesOrderDetailTaxZone) {
        this.salesOrderDetailTaxZone = salesOrderDetailTaxZone;
    }

    public String getSalesOrderDetailNonTaxReason() {
        return this.salesOrderDetailNonTaxReason;
    }

    public SalesOrderItemDetails salesOrderDetailNonTaxReason(String salesOrderDetailNonTaxReason) {
        this.setSalesOrderDetailNonTaxReason(salesOrderDetailNonTaxReason);
        return this;
    }

    public void setSalesOrderDetailNonTaxReason(String salesOrderDetailNonTaxReason) {
        this.salesOrderDetailNonTaxReason = salesOrderDetailNonTaxReason;
    }

    public String getSalesOrderDetailNote() {
        return this.salesOrderDetailNote;
    }

    public SalesOrderItemDetails salesOrderDetailNote(String salesOrderDetailNote) {
        this.setSalesOrderDetailNote(salesOrderDetailNote);
        return this;
    }

    public void setSalesOrderDetailNote(String salesOrderDetailNote) {
        this.salesOrderDetailNote = salesOrderDetailNote;
    }

    public String getSalesOrderDetailSaleType() {
        return this.salesOrderDetailSaleType;
    }

    public SalesOrderItemDetails salesOrderDetailSaleType(String salesOrderDetailSaleType) {
        this.setSalesOrderDetailSaleType(salesOrderDetailSaleType);
        return this;
    }

    public void setSalesOrderDetailSaleType(String salesOrderDetailSaleType) {
        this.salesOrderDetailSaleType = salesOrderDetailSaleType;
    }

    public String getSalesOrderDetailItemGroup() {
        return this.salesOrderDetailItemGroup;
    }

    public SalesOrderItemDetails salesOrderDetailItemGroup(String salesOrderDetailItemGroup) {
        this.setSalesOrderDetailItemGroup(salesOrderDetailItemGroup);
        return this;
    }

    public void setSalesOrderDetailItemGroup(String salesOrderDetailItemGroup) {
        this.salesOrderDetailItemGroup = salesOrderDetailItemGroup;
    }

    public String getSalesOrderDetailItemUser1() {
        return this.salesOrderDetailItemUser1;
    }

    public SalesOrderItemDetails salesOrderDetailItemUser1(String salesOrderDetailItemUser1) {
        this.setSalesOrderDetailItemUser1(salesOrderDetailItemUser1);
        return this;
    }

    public void setSalesOrderDetailItemUser1(String salesOrderDetailItemUser1) {
        this.salesOrderDetailItemUser1 = salesOrderDetailItemUser1;
    }

    public String getSalesOrderDetailItemUser2() {
        return this.salesOrderDetailItemUser2;
    }

    public SalesOrderItemDetails salesOrderDetailItemUser2(String salesOrderDetailItemUser2) {
        this.setSalesOrderDetailItemUser2(salesOrderDetailItemUser2);
        return this;
    }

    public void setSalesOrderDetailItemUser2(String salesOrderDetailItemUser2) {
        this.salesOrderDetailItemUser2 = salesOrderDetailItemUser2;
    }

    public String getSalesOrderDetailItemUser3() {
        return this.salesOrderDetailItemUser3;
    }

    public SalesOrderItemDetails salesOrderDetailItemUser3(String salesOrderDetailItemUser3) {
        this.setSalesOrderDetailItemUser3(salesOrderDetailItemUser3);
        return this;
    }

    public void setSalesOrderDetailItemUser3(String salesOrderDetailItemUser3) {
        this.salesOrderDetailItemUser3 = salesOrderDetailItemUser3;
    }

    public String getSalesOrderDetailItemUser4() {
        return this.salesOrderDetailItemUser4;
    }

    public SalesOrderItemDetails salesOrderDetailItemUser4(String salesOrderDetailItemUser4) {
        this.setSalesOrderDetailItemUser4(salesOrderDetailItemUser4);
        return this;
    }

    public void setSalesOrderDetailItemUser4(String salesOrderDetailItemUser4) {
        this.salesOrderDetailItemUser4 = salesOrderDetailItemUser4;
    }

    public String getSalesOrderDetailConvertedToPurchase() {
        return this.salesOrderDetailConvertedToPurchase;
    }

    public SalesOrderItemDetails salesOrderDetailConvertedToPurchase(String salesOrderDetailConvertedToPurchase) {
        this.setSalesOrderDetailConvertedToPurchase(salesOrderDetailConvertedToPurchase);
        return this;
    }

    public void setSalesOrderDetailConvertedToPurchase(String salesOrderDetailConvertedToPurchase) {
        this.salesOrderDetailConvertedToPurchase = salesOrderDetailConvertedToPurchase;
    }

    public String getSalesOrderDetailManualConvertToPurchaseMctp() {
        return this.salesOrderDetailManualConvertToPurchaseMctp;
    }

    public SalesOrderItemDetails salesOrderDetailManualConvertToPurchaseMctp(String salesOrderDetailManualConvertToPurchaseMctp) {
        this.setSalesOrderDetailManualConvertToPurchaseMctp(salesOrderDetailManualConvertToPurchaseMctp);
        return this;
    }

    public void setSalesOrderDetailManualConvertToPurchaseMctp(String salesOrderDetailManualConvertToPurchaseMctp) {
        this.salesOrderDetailManualConvertToPurchaseMctp = salesOrderDetailManualConvertToPurchaseMctp;
    }

    public Double getSalesOrderDetailMctpChargeAmt() {
        return this.salesOrderDetailMctpChargeAmt;
    }

    public SalesOrderItemDetails salesOrderDetailMctpChargeAmt(Double salesOrderDetailMctpChargeAmt) {
        this.setSalesOrderDetailMctpChargeAmt(salesOrderDetailMctpChargeAmt);
        return this;
    }

    public void setSalesOrderDetailMctpChargeAmt(Double salesOrderDetailMctpChargeAmt) {
        this.salesOrderDetailMctpChargeAmt = salesOrderDetailMctpChargeAmt;
    }

    public Double getSalesOrderDetailMctpAllowedAmt() {
        return this.salesOrderDetailMctpAllowedAmt;
    }

    public SalesOrderItemDetails salesOrderDetailMctpAllowedAmt(Double salesOrderDetailMctpAllowedAmt) {
        this.setSalesOrderDetailMctpAllowedAmt(salesOrderDetailMctpAllowedAmt);
        return this;
    }

    public void setSalesOrderDetailMctpAllowedAmt(Double salesOrderDetailMctpAllowedAmt) {
        this.salesOrderDetailMctpAllowedAmt = salesOrderDetailMctpAllowedAmt;
    }

    public String getSalesOrderDetailMctpModifier1() {
        return this.salesOrderDetailMctpModifier1;
    }

    public SalesOrderItemDetails salesOrderDetailMctpModifier1(String salesOrderDetailMctpModifier1) {
        this.setSalesOrderDetailMctpModifier1(salesOrderDetailMctpModifier1);
        return this;
    }

    public void setSalesOrderDetailMctpModifier1(String salesOrderDetailMctpModifier1) {
        this.salesOrderDetailMctpModifier1 = salesOrderDetailMctpModifier1;
    }

    public String getSalesOrderDetailMctpModifier2() {
        return this.salesOrderDetailMctpModifier2;
    }

    public SalesOrderItemDetails salesOrderDetailMctpModifier2(String salesOrderDetailMctpModifier2) {
        this.setSalesOrderDetailMctpModifier2(salesOrderDetailMctpModifier2);
        return this;
    }

    public void setSalesOrderDetailMctpModifier2(String salesOrderDetailMctpModifier2) {
        this.salesOrderDetailMctpModifier2 = salesOrderDetailMctpModifier2;
    }

    public String getSalesOrderDetailMctpModifier3() {
        return this.salesOrderDetailMctpModifier3;
    }

    public SalesOrderItemDetails salesOrderDetailMctpModifier3(String salesOrderDetailMctpModifier3) {
        this.setSalesOrderDetailMctpModifier3(salesOrderDetailMctpModifier3);
        return this;
    }

    public void setSalesOrderDetailMctpModifier3(String salesOrderDetailMctpModifier3) {
        this.salesOrderDetailMctpModifier3 = salesOrderDetailMctpModifier3;
    }

    public String getSalesOrderDetailMctpModifier4() {
        return this.salesOrderDetailMctpModifier4;
    }

    public SalesOrderItemDetails salesOrderDetailMctpModifier4(String salesOrderDetailMctpModifier4) {
        this.setSalesOrderDetailMctpModifier4(salesOrderDetailMctpModifier4);
        return this;
    }

    public void setSalesOrderDetailMctpModifier4(String salesOrderDetailMctpModifier4) {
        this.salesOrderDetailMctpModifier4 = salesOrderDetailMctpModifier4;
    }

    public Integer getSalesOrderDetailMctpPeriod() {
        return this.salesOrderDetailMctpPeriod;
    }

    public SalesOrderItemDetails salesOrderDetailMctpPeriod(Integer salesOrderDetailMctpPeriod) {
        this.setSalesOrderDetailMctpPeriod(salesOrderDetailMctpPeriod);
        return this;
    }

    public void setSalesOrderDetailMctpPeriod(Integer salesOrderDetailMctpPeriod) {
        this.salesOrderDetailMctpPeriod = salesOrderDetailMctpPeriod;
    }

    public String getSalesOrderDetailAddtlModifier1() {
        return this.salesOrderDetailAddtlModifier1;
    }

    public SalesOrderItemDetails salesOrderDetailAddtlModifier1(String salesOrderDetailAddtlModifier1) {
        this.setSalesOrderDetailAddtlModifier1(salesOrderDetailAddtlModifier1);
        return this;
    }

    public void setSalesOrderDetailAddtlModifier1(String salesOrderDetailAddtlModifier1) {
        this.salesOrderDetailAddtlModifier1 = salesOrderDetailAddtlModifier1;
    }

    public String getSalesOrderDetailAddtlModifier2() {
        return this.salesOrderDetailAddtlModifier2;
    }

    public SalesOrderItemDetails salesOrderDetailAddtlModifier2(String salesOrderDetailAddtlModifier2) {
        this.setSalesOrderDetailAddtlModifier2(salesOrderDetailAddtlModifier2);
        return this;
    }

    public void setSalesOrderDetailAddtlModifier2(String salesOrderDetailAddtlModifier2) {
        this.salesOrderDetailAddtlModifier2 = salesOrderDetailAddtlModifier2;
    }

    public String getSalesOrderDetailAddtlModifier3() {
        return this.salesOrderDetailAddtlModifier3;
    }

    public SalesOrderItemDetails salesOrderDetailAddtlModifier3(String salesOrderDetailAddtlModifier3) {
        this.setSalesOrderDetailAddtlModifier3(salesOrderDetailAddtlModifier3);
        return this;
    }

    public void setSalesOrderDetailAddtlModifier3(String salesOrderDetailAddtlModifier3) {
        this.salesOrderDetailAddtlModifier3 = salesOrderDetailAddtlModifier3;
    }

    public String getSalesOrderDetailAddtlModifier4() {
        return this.salesOrderDetailAddtlModifier4;
    }

    public SalesOrderItemDetails salesOrderDetailAddtlModifier4(String salesOrderDetailAddtlModifier4) {
        this.setSalesOrderDetailAddtlModifier4(salesOrderDetailAddtlModifier4);
        return this;
    }

    public void setSalesOrderDetailAddtlModifier4(String salesOrderDetailAddtlModifier4) {
        this.salesOrderDetailAddtlModifier4 = salesOrderDetailAddtlModifier4;
    }

    public LocalDate getSalesOrderDetailNextDateOfService() {
        return this.salesOrderDetailNextDateOfService;
    }

    public SalesOrderItemDetails salesOrderDetailNextDateOfService(LocalDate salesOrderDetailNextDateOfService) {
        this.setSalesOrderDetailNextDateOfService(salesOrderDetailNextDateOfService);
        return this;
    }

    public void setSalesOrderDetailNextDateOfService(LocalDate salesOrderDetailNextDateOfService) {
        this.salesOrderDetailNextDateOfService = salesOrderDetailNextDateOfService;
    }

    public String getSalesOrderDetailPriceTable() {
        return this.salesOrderDetailPriceTable;
    }

    public SalesOrderItemDetails salesOrderDetailPriceTable(String salesOrderDetailPriceTable) {
        this.setSalesOrderDetailPriceTable(salesOrderDetailPriceTable);
        return this;
    }

    public void setSalesOrderDetailPriceTable(String salesOrderDetailPriceTable) {
        this.salesOrderDetailPriceTable = salesOrderDetailPriceTable;
    }

    public String getSalesOrderDetailPriceOptionName() {
        return this.salesOrderDetailPriceOptionName;
    }

    public SalesOrderItemDetails salesOrderDetailPriceOptionName(String salesOrderDetailPriceOptionName) {
        this.setSalesOrderDetailPriceOptionName(salesOrderDetailPriceOptionName);
        return this;
    }

    public void setSalesOrderDetailPriceOptionName(String salesOrderDetailPriceOptionName) {
        this.salesOrderDetailPriceOptionName = salesOrderDetailPriceOptionName;
    }

    public Double getSalesOrderDetailExtendedChargeAmount() {
        return this.salesOrderDetailExtendedChargeAmount;
    }

    public SalesOrderItemDetails salesOrderDetailExtendedChargeAmount(Double salesOrderDetailExtendedChargeAmount) {
        this.setSalesOrderDetailExtendedChargeAmount(salesOrderDetailExtendedChargeAmount);
        return this;
    }

    public void setSalesOrderDetailExtendedChargeAmount(Double salesOrderDetailExtendedChargeAmount) {
        this.salesOrderDetailExtendedChargeAmount = salesOrderDetailExtendedChargeAmount;
    }

    public Double getSalesOrderDetailExtendedAllowanceAmount() {
        return this.salesOrderDetailExtendedAllowanceAmount;
    }

    public SalesOrderItemDetails salesOrderDetailExtendedAllowanceAmount(Double salesOrderDetailExtendedAllowanceAmount) {
        this.setSalesOrderDetailExtendedAllowanceAmount(salesOrderDetailExtendedAllowanceAmount);
        return this;
    }

    public void setSalesOrderDetailExtendedAllowanceAmount(Double salesOrderDetailExtendedAllowanceAmount) {
        this.salesOrderDetailExtendedAllowanceAmount = salesOrderDetailExtendedAllowanceAmount;
    }

    public String getSalesOrderDetailItemNdcCode() {
        return this.salesOrderDetailItemNdcCode;
    }

    public SalesOrderItemDetails salesOrderDetailItemNdcCode(String salesOrderDetailItemNdcCode) {
        this.setSalesOrderDetailItemNdcCode(salesOrderDetailItemNdcCode);
        return this;
    }

    public void setSalesOrderDetailItemNdcCode(String salesOrderDetailItemNdcCode) {
        this.salesOrderDetailItemNdcCode = salesOrderDetailItemNdcCode;
    }

    public String getSalesOrderDetailManufacturer() {
        return this.salesOrderDetailManufacturer;
    }

    public SalesOrderItemDetails salesOrderDetailManufacturer(String salesOrderDetailManufacturer) {
        this.setSalesOrderDetailManufacturer(salesOrderDetailManufacturer);
        return this;
    }

    public void setSalesOrderDetailManufacturer(String salesOrderDetailManufacturer) {
        this.salesOrderDetailManufacturer = salesOrderDetailManufacturer;
    }

    public String getSalesOrderDetailCbPricing() {
        return this.salesOrderDetailCbPricing;
    }

    public SalesOrderItemDetails salesOrderDetailCbPricing(String salesOrderDetailCbPricing) {
        this.setSalesOrderDetailCbPricing(salesOrderDetailCbPricing);
        return this;
    }

    public void setSalesOrderDetailCbPricing(String salesOrderDetailCbPricing) {
        this.salesOrderDetailCbPricing = salesOrderDetailCbPricing;
    }

    public String getSalesOrderDetailCbPriceTableOverride() {
        return this.salesOrderDetailCbPriceTableOverride;
    }

    public SalesOrderItemDetails salesOrderDetailCbPriceTableOverride(String salesOrderDetailCbPriceTableOverride) {
        this.setSalesOrderDetailCbPriceTableOverride(salesOrderDetailCbPriceTableOverride);
        return this;
    }

    public void setSalesOrderDetailCbPriceTableOverride(String salesOrderDetailCbPriceTableOverride) {
        this.salesOrderDetailCbPriceTableOverride = salesOrderDetailCbPriceTableOverride;
    }

    public String getSalesOrderDetailCbOverride() {
        return this.salesOrderDetailCbOverride;
    }

    public SalesOrderItemDetails salesOrderDetailCbOverride(String salesOrderDetailCbOverride) {
        this.setSalesOrderDetailCbOverride(salesOrderDetailCbOverride);
        return this;
    }

    public void setSalesOrderDetailCbOverride(String salesOrderDetailCbOverride) {
        this.salesOrderDetailCbOverride = salesOrderDetailCbOverride;
    }

    public String getSalesOrderDetailMessages() {
        return this.salesOrderDetailMessages;
    }

    public SalesOrderItemDetails salesOrderDetailMessages(String salesOrderDetailMessages) {
        this.setSalesOrderDetailMessages(salesOrderDetailMessages);
        return this;
    }

    public void setSalesOrderDetailMessages(String salesOrderDetailMessages) {
        this.salesOrderDetailMessages = salesOrderDetailMessages;
    }

    public Integer getSalesOrderDetailLocation() {
        return this.salesOrderDetailLocation;
    }

    public SalesOrderItemDetails salesOrderDetailLocation(Integer salesOrderDetailLocation) {
        this.setSalesOrderDetailLocation(salesOrderDetailLocation);
        return this;
    }

    public void setSalesOrderDetailLocation(Integer salesOrderDetailLocation) {
        this.salesOrderDetailLocation = salesOrderDetailLocation;
    }

    public Integer getSalesOrderDetailCaloriesPerDay() {
        return this.salesOrderDetailCaloriesPerDay;
    }

    public SalesOrderItemDetails salesOrderDetailCaloriesPerDay(Integer salesOrderDetailCaloriesPerDay) {
        this.setSalesOrderDetailCaloriesPerDay(salesOrderDetailCaloriesPerDay);
        return this;
    }

    public void setSalesOrderDetailCaloriesPerDay(Integer salesOrderDetailCaloriesPerDay) {
        this.salesOrderDetailCaloriesPerDay = salesOrderDetailCaloriesPerDay;
    }

    public String getSalesOrderDetailSecondaryBillingProcudureCode() {
        return this.salesOrderDetailSecondaryBillingProcudureCode;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingProcudureCode(String salesOrderDetailSecondaryBillingProcudureCode) {
        this.setSalesOrderDetailSecondaryBillingProcudureCode(salesOrderDetailSecondaryBillingProcudureCode);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingProcudureCode(String salesOrderDetailSecondaryBillingProcudureCode) {
        this.salesOrderDetailSecondaryBillingProcudureCode = salesOrderDetailSecondaryBillingProcudureCode;
    }

    public String getSalesOrderDetailSecondaryBillingPriceOption() {
        return this.salesOrderDetailSecondaryBillingPriceOption;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingPriceOption(String salesOrderDetailSecondaryBillingPriceOption) {
        this.setSalesOrderDetailSecondaryBillingPriceOption(salesOrderDetailSecondaryBillingPriceOption);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingPriceOption(String salesOrderDetailSecondaryBillingPriceOption) {
        this.salesOrderDetailSecondaryBillingPriceOption = salesOrderDetailSecondaryBillingPriceOption;
    }

    public String getSalesOrderDetailSecondaryBillingPriceOptionName() {
        return this.salesOrderDetailSecondaryBillingPriceOptionName;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingPriceOptionName(String salesOrderDetailSecondaryBillingPriceOptionName) {
        this.setSalesOrderDetailSecondaryBillingPriceOptionName(salesOrderDetailSecondaryBillingPriceOptionName);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingPriceOptionName(String salesOrderDetailSecondaryBillingPriceOptionName) {
        this.salesOrderDetailSecondaryBillingPriceOptionName = salesOrderDetailSecondaryBillingPriceOptionName;
    }

    public String getSalesOrderDetailSecondaryBillingModifier1() {
        return this.salesOrderDetailSecondaryBillingModifier1;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingModifier1(String salesOrderDetailSecondaryBillingModifier1) {
        this.setSalesOrderDetailSecondaryBillingModifier1(salesOrderDetailSecondaryBillingModifier1);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingModifier1(String salesOrderDetailSecondaryBillingModifier1) {
        this.salesOrderDetailSecondaryBillingModifier1 = salesOrderDetailSecondaryBillingModifier1;
    }

    public String getSalesOrderDetailSecondaryBillingModifier2() {
        return this.salesOrderDetailSecondaryBillingModifier2;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingModifier2(String salesOrderDetailSecondaryBillingModifier2) {
        this.setSalesOrderDetailSecondaryBillingModifier2(salesOrderDetailSecondaryBillingModifier2);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingModifier2(String salesOrderDetailSecondaryBillingModifier2) {
        this.salesOrderDetailSecondaryBillingModifier2 = salesOrderDetailSecondaryBillingModifier2;
    }

    public String getSalesOrderDetailSecondaryBillingModifier3() {
        return this.salesOrderDetailSecondaryBillingModifier3;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingModifier3(String salesOrderDetailSecondaryBillingModifier3) {
        this.setSalesOrderDetailSecondaryBillingModifier3(salesOrderDetailSecondaryBillingModifier3);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingModifier3(String salesOrderDetailSecondaryBillingModifier3) {
        this.salesOrderDetailSecondaryBillingModifier3 = salesOrderDetailSecondaryBillingModifier3;
    }

    public String getSalesOrderDetailSecondaryBillingModifier4() {
        return this.salesOrderDetailSecondaryBillingModifier4;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingModifier4(String salesOrderDetailSecondaryBillingModifier4) {
        this.setSalesOrderDetailSecondaryBillingModifier4(salesOrderDetailSecondaryBillingModifier4);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingModifier4(String salesOrderDetailSecondaryBillingModifier4) {
        this.salesOrderDetailSecondaryBillingModifier4 = salesOrderDetailSecondaryBillingModifier4;
    }

    public String getSalesOrderDetailSecondaryBillingAdditionalModifier1() {
        return this.salesOrderDetailSecondaryBillingAdditionalModifier1;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingAdditionalModifier1(
        String salesOrderDetailSecondaryBillingAdditionalModifier1
    ) {
        this.setSalesOrderDetailSecondaryBillingAdditionalModifier1(salesOrderDetailSecondaryBillingAdditionalModifier1);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingAdditionalModifier1(String salesOrderDetailSecondaryBillingAdditionalModifier1) {
        this.salesOrderDetailSecondaryBillingAdditionalModifier1 = salesOrderDetailSecondaryBillingAdditionalModifier1;
    }

    public String getSalesOrderDetailSecondaryBillingadditionalModifier2() {
        return this.salesOrderDetailSecondaryBillingadditionalModifier2;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingadditionalModifier2(
        String salesOrderDetailSecondaryBillingadditionalModifier2
    ) {
        this.setSalesOrderDetailSecondaryBillingadditionalModifier2(salesOrderDetailSecondaryBillingadditionalModifier2);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingadditionalModifier2(String salesOrderDetailSecondaryBillingadditionalModifier2) {
        this.salesOrderDetailSecondaryBillingadditionalModifier2 = salesOrderDetailSecondaryBillingadditionalModifier2;
    }

    public String getSalesOrderDetailSecondaryBillingadditionalModifier3() {
        return this.salesOrderDetailSecondaryBillingadditionalModifier3;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingadditionalModifier3(
        String salesOrderDetailSecondaryBillingadditionalModifier3
    ) {
        this.setSalesOrderDetailSecondaryBillingadditionalModifier3(salesOrderDetailSecondaryBillingadditionalModifier3);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingadditionalModifier3(String salesOrderDetailSecondaryBillingadditionalModifier3) {
        this.salesOrderDetailSecondaryBillingadditionalModifier3 = salesOrderDetailSecondaryBillingadditionalModifier3;
    }

    public String getSalesOrderDetailSecondaryBillingadditionalModifier4() {
        return this.salesOrderDetailSecondaryBillingadditionalModifier4;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingadditionalModifier4(
        String salesOrderDetailSecondaryBillingadditionalModifier4
    ) {
        this.setSalesOrderDetailSecondaryBillingadditionalModifier4(salesOrderDetailSecondaryBillingadditionalModifier4);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingadditionalModifier4(String salesOrderDetailSecondaryBillingadditionalModifier4) {
        this.salesOrderDetailSecondaryBillingadditionalModifier4 = salesOrderDetailSecondaryBillingadditionalModifier4;
    }

    public String getSalesOrderDetailSecondaryBillingIgnore() {
        return this.salesOrderDetailSecondaryBillingIgnore;
    }

    public SalesOrderItemDetails salesOrderDetailSecondaryBillingIgnore(String salesOrderDetailSecondaryBillingIgnore) {
        this.setSalesOrderDetailSecondaryBillingIgnore(salesOrderDetailSecondaryBillingIgnore);
        return this;
    }

    public void setSalesOrderDetailSecondaryBillingIgnore(String salesOrderDetailSecondaryBillingIgnore) {
        this.salesOrderDetailSecondaryBillingIgnore = salesOrderDetailSecondaryBillingIgnore;
    }

    public String getSalesOrderDetailSecondarySpecialBilling() {
        return this.salesOrderDetailSecondarySpecialBilling;
    }

    public SalesOrderItemDetails salesOrderDetailSecondarySpecialBilling(String salesOrderDetailSecondarySpecialBilling) {
        this.setSalesOrderDetailSecondarySpecialBilling(salesOrderDetailSecondarySpecialBilling);
        return this;
    }

    public void setSalesOrderDetailSecondarySpecialBilling(String salesOrderDetailSecondarySpecialBilling) {
        this.salesOrderDetailSecondarySpecialBilling = salesOrderDetailSecondarySpecialBilling;
    }

    public String getSalesOrderDetailSpanDateSplitBilling() {
        return this.salesOrderDetailSpanDateSplitBilling;
    }

    public SalesOrderItemDetails salesOrderDetailSpanDateSplitBilling(String salesOrderDetailSpanDateSplitBilling) {
        this.setSalesOrderDetailSpanDateSplitBilling(salesOrderDetailSpanDateSplitBilling);
        return this;
    }

    public void setSalesOrderDetailSpanDateSplitBilling(String salesOrderDetailSpanDateSplitBilling) {
        this.salesOrderDetailSpanDateSplitBilling = salesOrderDetailSpanDateSplitBilling;
    }

    public String getSalesOrderDetailManufacturerItemIdNumber() {
        return this.salesOrderDetailManufacturerItemIdNumber;
    }

    public SalesOrderItemDetails salesOrderDetailManufacturerItemIdNumber(String salesOrderDetailManufacturerItemIdNumber) {
        this.setSalesOrderDetailManufacturerItemIdNumber(salesOrderDetailManufacturerItemIdNumber);
        return this;
    }

    public void setSalesOrderDetailManufacturerItemIdNumber(String salesOrderDetailManufacturerItemIdNumber) {
        this.salesOrderDetailManufacturerItemIdNumber = salesOrderDetailManufacturerItemIdNumber;
    }

    public Integer getCmnId() {
        return this.cmnId;
    }

    public SalesOrderItemDetails cmnId(Integer cmnId) {
        this.setCmnId(cmnId);
        return this;
    }

    public void setCmnId(Integer cmnId) {
        this.cmnId = cmnId;
    }

    public Integer getCmnparCmnFormId() {
        return this.cmnparCmnFormId;
    }

    public SalesOrderItemDetails cmnparCmnFormId(Integer cmnparCmnFormId) {
        this.setCmnparCmnFormId(cmnparCmnFormId);
        return this;
    }

    public void setCmnparCmnFormId(Integer cmnparCmnFormId) {
        this.cmnparCmnFormId = cmnparCmnFormId;
    }

    public String getCmnparCmnKey() {
        return this.cmnparCmnKey;
    }

    public SalesOrderItemDetails cmnparCmnKey(String cmnparCmnKey) {
        this.setCmnparCmnKey(cmnparCmnKey);
        return this;
    }

    public void setCmnparCmnKey(String cmnparCmnKey) {
        this.cmnparCmnKey = cmnparCmnKey;
    }

    public LocalDate getCmnparCmnCreateDate() {
        return this.cmnparCmnCreateDate;
    }

    public SalesOrderItemDetails cmnparCmnCreateDate(LocalDate cmnparCmnCreateDate) {
        this.setCmnparCmnCreateDate(cmnparCmnCreateDate);
        return this;
    }

    public void setCmnparCmnCreateDate(LocalDate cmnparCmnCreateDate) {
        this.cmnparCmnCreateDate = cmnparCmnCreateDate;
    }

    public LocalDate getCmnparCmnExpirationDate() {
        return this.cmnparCmnExpirationDate;
    }

    public SalesOrderItemDetails cmnparCmnExpirationDate(LocalDate cmnparCmnExpirationDate) {
        this.setCmnparCmnExpirationDate(cmnparCmnExpirationDate);
        return this;
    }

    public void setCmnparCmnExpirationDate(LocalDate cmnparCmnExpirationDate) {
        this.cmnparCmnExpirationDate = cmnparCmnExpirationDate;
    }

    public LocalDate getCmnparCmnInitialDate() {
        return this.cmnparCmnInitialDate;
    }

    public SalesOrderItemDetails cmnparCmnInitialDate(LocalDate cmnparCmnInitialDate) {
        this.setCmnparCmnInitialDate(cmnparCmnInitialDate);
        return this;
    }

    public void setCmnparCmnInitialDate(LocalDate cmnparCmnInitialDate) {
        this.cmnparCmnInitialDate = cmnparCmnInitialDate;
    }

    public LocalDate getCmnparCmnRenewalDate() {
        return this.cmnparCmnRenewalDate;
    }

    public SalesOrderItemDetails cmnparCmnRenewalDate(LocalDate cmnparCmnRenewalDate) {
        this.setCmnparCmnRenewalDate(cmnparCmnRenewalDate);
        return this;
    }

    public void setCmnparCmnRenewalDate(LocalDate cmnparCmnRenewalDate) {
        this.cmnparCmnRenewalDate = cmnparCmnRenewalDate;
    }

    public LocalDate getCmnparCmnRecertificationDate() {
        return this.cmnparCmnRecertificationDate;
    }

    public SalesOrderItemDetails cmnparCmnRecertificationDate(LocalDate cmnparCmnRecertificationDate) {
        this.setCmnparCmnRecertificationDate(cmnparCmnRecertificationDate);
        return this;
    }

    public void setCmnparCmnRecertificationDate(LocalDate cmnparCmnRecertificationDate) {
        this.cmnparCmnRecertificationDate = cmnparCmnRecertificationDate;
    }

    public LocalDate getCmnparCmnPhysicianDate() {
        return this.cmnparCmnPhysicianDate;
    }

    public SalesOrderItemDetails cmnparCmnPhysicianDate(LocalDate cmnparCmnPhysicianDate) {
        this.setCmnparCmnPhysicianDate(cmnparCmnPhysicianDate);
        return this;
    }

    public void setCmnparCmnPhysicianDate(LocalDate cmnparCmnPhysicianDate) {
        this.cmnparCmnPhysicianDate = cmnparCmnPhysicianDate;
    }

    public String getCmnparCmnStatus() {
        return this.cmnparCmnStatus;
    }

    public SalesOrderItemDetails cmnparCmnStatus(String cmnparCmnStatus) {
        this.setCmnparCmnStatus(cmnparCmnStatus);
        return this;
    }

    public void setCmnparCmnStatus(String cmnparCmnStatus) {
        this.cmnparCmnStatus = cmnparCmnStatus;
    }

    public Integer getCmnparParId() {
        return this.cmnparParId;
    }

    public SalesOrderItemDetails cmnparParId(Integer cmnparParId) {
        this.setCmnparParId(cmnparParId);
        return this;
    }

    public void setCmnparParId(Integer cmnparParId) {
        this.cmnparParId = cmnparParId;
    }

    public String getCmnparParDescr() {
        return this.cmnparParDescr;
    }

    public SalesOrderItemDetails cmnparParDescr(String cmnparParDescr) {
        this.setCmnparParDescr(cmnparParDescr);
        return this;
    }

    public void setCmnparParDescr(String cmnparParDescr) {
        this.cmnparParDescr = cmnparParDescr;
    }

    public LocalDate getCmnparParInitialDate() {
        return this.cmnparParInitialDate;
    }

    public SalesOrderItemDetails cmnparParInitialDate(LocalDate cmnparParInitialDate) {
        this.setCmnparParInitialDate(cmnparParInitialDate);
        return this;
    }

    public void setCmnparParInitialDate(LocalDate cmnparParInitialDate) {
        this.cmnparParInitialDate = cmnparParInitialDate;
    }

    public LocalDate getCmnparParExpirationDate() {
        return this.cmnparParExpirationDate;
    }

    public SalesOrderItemDetails cmnparParExpirationDate(LocalDate cmnparParExpirationDate) {
        this.setCmnparParExpirationDate(cmnparParExpirationDate);
        return this;
    }

    public void setCmnparParExpirationDate(LocalDate cmnparParExpirationDate) {
        this.cmnparParExpirationDate = cmnparParExpirationDate;
    }

    public LocalDate getCmnparCmnLogDate() {
        return this.cmnparCmnLogDate;
    }

    public SalesOrderItemDetails cmnparCmnLogDate(LocalDate cmnparCmnLogDate) {
        this.setCmnparCmnLogDate(cmnparCmnLogDate);
        return this;
    }

    public void setCmnparCmnLogDate(LocalDate cmnparCmnLogDate) {
        this.cmnparCmnLogDate = cmnparCmnLogDate;
    }

    public Integer getCmnparCmnLengthOfNeed() {
        return this.cmnparCmnLengthOfNeed;
    }

    public SalesOrderItemDetails cmnparCmnLengthOfNeed(Integer cmnparCmnLengthOfNeed) {
        this.setCmnparCmnLengthOfNeed(cmnparCmnLengthOfNeed);
        return this;
    }

    public void setCmnparCmnLengthOfNeed(Integer cmnparCmnLengthOfNeed) {
        this.cmnparCmnLengthOfNeed = cmnparCmnLengthOfNeed;
    }

    public LocalDate getCmnparCmnPrintedDate() {
        return this.cmnparCmnPrintedDate;
    }

    public SalesOrderItemDetails cmnparCmnPrintedDate(LocalDate cmnparCmnPrintedDate) {
        this.setCmnparCmnPrintedDate(cmnparCmnPrintedDate);
        return this;
    }

    public void setCmnparCmnPrintedDate(LocalDate cmnparCmnPrintedDate) {
        this.cmnparCmnPrintedDate = cmnparCmnPrintedDate;
    }

    public String getCmnparCmnPrintedBy() {
        return this.cmnparCmnPrintedBy;
    }

    public SalesOrderItemDetails cmnparCmnPrintedBy(String cmnparCmnPrintedBy) {
        this.setCmnparCmnPrintedBy(cmnparCmnPrintedBy);
        return this;
    }

    public void setCmnparCmnPrintedBy(String cmnparCmnPrintedBy) {
        this.cmnparCmnPrintedBy = cmnparCmnPrintedBy;
    }

    public LocalDate getCmnparFaxedDate() {
        return this.cmnparFaxedDate;
    }

    public SalesOrderItemDetails cmnparFaxedDate(LocalDate cmnparFaxedDate) {
        this.setCmnparFaxedDate(cmnparFaxedDate);
        return this;
    }

    public void setCmnparFaxedDate(LocalDate cmnparFaxedDate) {
        this.cmnparFaxedDate = cmnparFaxedDate;
    }

    public String getCmnparCmnPlaceholder() {
        return this.cmnparCmnPlaceholder;
    }

    public SalesOrderItemDetails cmnparCmnPlaceholder(String cmnparCmnPlaceholder) {
        this.setCmnparCmnPlaceholder(cmnparCmnPlaceholder);
        return this;
    }

    public void setCmnparCmnPlaceholder(String cmnparCmnPlaceholder) {
        this.cmnparCmnPlaceholder = cmnparCmnPlaceholder;
    }

    public String getCmnparCmnFaxedBy() {
        return this.cmnparCmnFaxedBy;
    }

    public SalesOrderItemDetails cmnparCmnFaxedBy(String cmnparCmnFaxedBy) {
        this.setCmnparCmnFaxedBy(cmnparCmnFaxedBy);
        return this;
    }

    public void setCmnparCmnFaxedBy(String cmnparCmnFaxedBy) {
        this.cmnparCmnFaxedBy = cmnparCmnFaxedBy;
    }

    public String getCmnparCmnLoggedBy() {
        return this.cmnparCmnLoggedBy;
    }

    public SalesOrderItemDetails cmnparCmnLoggedBy(String cmnparCmnLoggedBy) {
        this.setCmnparCmnLoggedBy(cmnparCmnLoggedBy);
        return this;
    }

    public void setCmnparCmnLoggedBy(String cmnparCmnLoggedBy) {
        this.cmnparCmnLoggedBy = cmnparCmnLoggedBy;
    }

    public Integer getCmnparNumberOfRefills() {
        return this.cmnparNumberOfRefills;
    }

    public SalesOrderItemDetails cmnparNumberOfRefills(Integer cmnparNumberOfRefills) {
        this.setCmnparNumberOfRefills(cmnparNumberOfRefills);
        return this;
    }

    public void setCmnparNumberOfRefills(Integer cmnparNumberOfRefills) {
        this.cmnparNumberOfRefills = cmnparNumberOfRefills;
    }

    public String getStatus() {
        return this.status;
    }

    public SalesOrderItemDetails status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return this.createdById;
    }

    public SalesOrderItemDetails createdById(Integer createdById) {
        this.setCreatedById(createdById);
        return this;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return this.createdByName;
    }

    public SalesOrderItemDetails createdByName(String createdByName) {
        this.setCreatedByName(createdByName);
        return this;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public SalesOrderItemDetails createdDate(ZonedDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedById() {
        return this.updatedById;
    }

    public SalesOrderItemDetails updatedById(Integer updatedById) {
        this.setUpdatedById(updatedById);
        return this;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return this.updatedByName;
    }

    public SalesOrderItemDetails updatedByName(String updatedByName) {
        this.setUpdatedByName(updatedByName);
        return this;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public SalesOrderItemDetails updatedDate(ZonedDateTime updatedDate) {
        this.setUpdatedDate(updatedDate);
        return this;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderItemDetails{" +
            ", salesOrderItemDetailsId=" + getSalesOrderItemDetailsId() +
            ", salesOrderId=" + getSalesOrderId() +
            ", patientId=" + getPatientId() +
            ", itemLocationId=" + getItemLocationId() +
            ", salesOrderDetailItemId=" + getSalesOrderDetailItemId() +
            ", salesOrderDetailItemName='" + getSalesOrderDetailItemName() + "'" +
            ", salesOrderDetailStockingUom='" + getSalesOrderDetailStockingUom() + "'" +
            ", salesOrderDetailStockingUomName='" + getSalesOrderDetailStockingUomName() + "'" +
            ", salesOrderDetailItemDescription='" + getSalesOrderDetailItemDescription() + "'" +
            ", salesOrderDetailDefaultVendor='" + getSalesOrderDetailDefaultVendor() + "'" +
            ", salesOrderDetailOriginalDos='" + getSalesOrderDetailOriginalDos() + "'" +
            ", salesOrderDetailPreviousBillingDate='" + getSalesOrderDetailPreviousBillingDate() + "'" +
            ", salesOrderDetailNextBillingDate='" + getSalesOrderDetailNextBillingDate() + "'" +
            ", salesOrderDetailDosTo='" + getSalesOrderDetailDosTo() + "'" +
            ", salesOrderDetailNextPeriod='" + getSalesOrderDetailNextPeriod() + "'" +
            ", salesOrderDetailSpecialPricing='" + getSalesOrderDetailSpecialPricing() + "'" +
            ", salesOrderDetailPriceOverride='" + getSalesOrderDetailPriceOverride() + "'" +
            ", salesOrderDetailSpecialTaxRate=" + getSalesOrderDetailSpecialTaxRate() +
            ", salesOrderDetailQty=" + getSalesOrderDetailQty() +
            ", salesOrderDetailBqty=" + getSalesOrderDetailBqty() +
            ", salesOrderDetailLineQty=" + getSalesOrderDetailLineQty() +
            ", salesOrderDetailProcCode='" + getSalesOrderDetailProcCode() + "'" +
            ", salesOrderDetailPriceOption='" + getSalesOrderDetailPriceOption() + "'" +
            ", salesOrderDetailModifier1='" + getSalesOrderDetailModifier1() + "'" +
            ", salesOrderDetailModifier2='" + getSalesOrderDetailModifier2() + "'" +
            ", salesOrderDetailModifier3='" + getSalesOrderDetailModifier3() + "'" +
            ", salesOrderDetailModifier4='" + getSalesOrderDetailModifier4() + "'" +
            ", salesOrderDetailChargeAmt=" + getSalesOrderDetailChargeAmt() +
            ", salesOrderDetailAllowedAmt=" + getSalesOrderDetailAllowedAmt() +
            ", salesOrderDetailTaxable='" + getSalesOrderDetailTaxable() + "'" +
            ", salesOrderDetailAbn='" + getSalesOrderDetailAbn() + "'" +
            ", salesOrderDetailAbnUpgrade='" + getSalesOrderDetailAbnUpgrade() + "'" +
            ", salesOrderDetailAbnPrintDate='" + getSalesOrderDetailAbnPrintDate() + "'" +
            ", salesOrderDetailAbnItem='" + getSalesOrderDetailAbnItem() + "'" +
            ", salesOrderDetailAbnProcCode='" + getSalesOrderDetailAbnProcCode() + "'" +
            ", salesOrderDetailAbnAllow='" + getSalesOrderDetailAbnAllow() + "'" +
            ", salesOrderDetailAbnCharge=" + getSalesOrderDetailAbnCharge() +
            ", salesOrderDetailAbnModifier1='" + getSalesOrderDetailAbnModifier1() + "'" +
            ", salesOrderDetailAbnModifier2='" + getSalesOrderDetailAbnModifier2() + "'" +
            ", salesOrderDetailTaxRate=" + getSalesOrderDetailTaxRate() +
            ", salesOrderDetailTaxZone='" + getSalesOrderDetailTaxZone() + "'" +
            ", salesOrderDetailNonTaxReason='" + getSalesOrderDetailNonTaxReason() + "'" +
            ", salesOrderDetailNote='" + getSalesOrderDetailNote() + "'" +
            ", salesOrderDetailSaleType='" + getSalesOrderDetailSaleType() + "'" +
            ", salesOrderDetailItemGroup='" + getSalesOrderDetailItemGroup() + "'" +
            ", salesOrderDetailItemUser1='" + getSalesOrderDetailItemUser1() + "'" +
            ", salesOrderDetailItemUser2='" + getSalesOrderDetailItemUser2() + "'" +
            ", salesOrderDetailItemUser3='" + getSalesOrderDetailItemUser3() + "'" +
            ", salesOrderDetailItemUser4='" + getSalesOrderDetailItemUser4() + "'" +
            ", salesOrderDetailConvertedToPurchase='" + getSalesOrderDetailConvertedToPurchase() + "'" +
            ", salesOrderDetailManualConvertToPurchaseMctp='" + getSalesOrderDetailManualConvertToPurchaseMctp() + "'" +
            ", salesOrderDetailMctpChargeAmt=" + getSalesOrderDetailMctpChargeAmt() +
            ", salesOrderDetailMctpAllowedAmt=" + getSalesOrderDetailMctpAllowedAmt() +
            ", salesOrderDetailMctpModifier1='" + getSalesOrderDetailMctpModifier1() + "'" +
            ", salesOrderDetailMctpModifier2='" + getSalesOrderDetailMctpModifier2() + "'" +
            ", salesOrderDetailMctpModifier3='" + getSalesOrderDetailMctpModifier3() + "'" +
            ", salesOrderDetailMctpModifier4='" + getSalesOrderDetailMctpModifier4() + "'" +
            ", salesOrderDetailMctpPeriod=" + getSalesOrderDetailMctpPeriod() +
            ", salesOrderDetailAddtlModifier1='" + getSalesOrderDetailAddtlModifier1() + "'" +
            ", salesOrderDetailAddtlModifier2='" + getSalesOrderDetailAddtlModifier2() + "'" +
            ", salesOrderDetailAddtlModifier3='" + getSalesOrderDetailAddtlModifier3() + "'" +
            ", salesOrderDetailAddtlModifier4='" + getSalesOrderDetailAddtlModifier4() + "'" +
            ", salesOrderDetailNextDateOfService='" + getSalesOrderDetailNextDateOfService() + "'" +
            ", salesOrderDetailPriceTable='" + getSalesOrderDetailPriceTable() + "'" +
            ", salesOrderDetailPriceOptionName='" + getSalesOrderDetailPriceOptionName() + "'" +
            ", salesOrderDetailExtendedChargeAmount=" + getSalesOrderDetailExtendedChargeAmount() +
            ", salesOrderDetailExtendedAllowanceAmount=" + getSalesOrderDetailExtendedAllowanceAmount() +
            ", salesOrderDetailItemNdcCode='" + getSalesOrderDetailItemNdcCode() + "'" +
            ", salesOrderDetailManufacturer='" + getSalesOrderDetailManufacturer() + "'" +
            ", salesOrderDetailCbPricing='" + getSalesOrderDetailCbPricing() + "'" +
            ", salesOrderDetailCbPriceTableOverride='" + getSalesOrderDetailCbPriceTableOverride() + "'" +
            ", salesOrderDetailCbOverride='" + getSalesOrderDetailCbOverride() + "'" +
            ", salesOrderDetailMessages='" + getSalesOrderDetailMessages() + "'" +
            ", salesOrderDetailLocation=" + getSalesOrderDetailLocation() +
            ", salesOrderDetailCaloriesPerDay=" + getSalesOrderDetailCaloriesPerDay() +
            ", salesOrderDetailSecondaryBillingProcudureCode='" + getSalesOrderDetailSecondaryBillingProcudureCode() + "'" +
            ", salesOrderDetailSecondaryBillingPriceOption='" + getSalesOrderDetailSecondaryBillingPriceOption() + "'" +
            ", salesOrderDetailSecondaryBillingPriceOptionName='" + getSalesOrderDetailSecondaryBillingPriceOptionName() + "'" +
            ", salesOrderDetailSecondaryBillingModifier1='" + getSalesOrderDetailSecondaryBillingModifier1() + "'" +
            ", salesOrderDetailSecondaryBillingModifier2='" + getSalesOrderDetailSecondaryBillingModifier2() + "'" +
            ", salesOrderDetailSecondaryBillingModifier3='" + getSalesOrderDetailSecondaryBillingModifier3() + "'" +
            ", salesOrderDetailSecondaryBillingModifier4='" + getSalesOrderDetailSecondaryBillingModifier4() + "'" +
            ", salesOrderDetailSecondaryBillingAdditionalModifier1='" + getSalesOrderDetailSecondaryBillingAdditionalModifier1() + "'" +
            ", salesOrderDetailSecondaryBillingadditionalModifier2='" + getSalesOrderDetailSecondaryBillingadditionalModifier2() + "'" +
            ", salesOrderDetailSecondaryBillingadditionalModifier3='" + getSalesOrderDetailSecondaryBillingadditionalModifier3() + "'" +
            ", salesOrderDetailSecondaryBillingadditionalModifier4='" + getSalesOrderDetailSecondaryBillingadditionalModifier4() + "'" +
            ", salesOrderDetailSecondaryBillingIgnore='" + getSalesOrderDetailSecondaryBillingIgnore() + "'" +
            ", salesOrderDetailSecondarySpecialBilling='" + getSalesOrderDetailSecondarySpecialBilling() + "'" +
            ", salesOrderDetailSpanDateSplitBilling='" + getSalesOrderDetailSpanDateSplitBilling() + "'" +
            ", salesOrderDetailManufacturerItemIdNumber='" + getSalesOrderDetailManufacturerItemIdNumber() + "'" +
            ", cmnId=" + getCmnId() +
            ", cmnparCmnFormId=" + getCmnparCmnFormId() +
            ", cmnparCmnKey='" + getCmnparCmnKey() + "'" +
            ", cmnparCmnCreateDate='" + getCmnparCmnCreateDate() + "'" +
            ", cmnparCmnExpirationDate='" + getCmnparCmnExpirationDate() + "'" +
            ", cmnparCmnInitialDate='" + getCmnparCmnInitialDate() + "'" +
            ", cmnparCmnRenewalDate='" + getCmnparCmnRenewalDate() + "'" +
            ", cmnparCmnRecertificationDate='" + getCmnparCmnRecertificationDate() + "'" +
            ", cmnparCmnPhysicianDate='" + getCmnparCmnPhysicianDate() + "'" +
            ", cmnparCmnStatus='" + getCmnparCmnStatus() + "'" +
            ", cmnparParId=" + getCmnparParId() +
            ", cmnparParDescr='" + getCmnparParDescr() + "'" +
            ", cmnparParInitialDate='" + getCmnparParInitialDate() + "'" +
            ", cmnparParExpirationDate='" + getCmnparParExpirationDate() + "'" +
            ", cmnparCmnLogDate='" + getCmnparCmnLogDate() + "'" +
            ", cmnparCmnLengthOfNeed=" + getCmnparCmnLengthOfNeed() +
            ", cmnparCmnPrintedDate='" + getCmnparCmnPrintedDate() + "'" +
            ", cmnparCmnPrintedBy='" + getCmnparCmnPrintedBy() + "'" +
            ", cmnparFaxedDate='" + getCmnparFaxedDate() + "'" +
            ", cmnparCmnPlaceholder='" + getCmnparCmnPlaceholder() + "'" +
            ", cmnparCmnFaxedBy='" + getCmnparCmnFaxedBy() + "'" +
            ", cmnparCmnLoggedBy='" + getCmnparCmnLoggedBy() + "'" +
            ", cmnparNumberOfRefills=" + getCmnparNumberOfRefills() +
            ", status='" + getStatus() + "'" +
            ", createdById=" + getCreatedById() +
            ", createdByName='" + getCreatedByName() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", updatedById=" + getUpdatedById() +
            ", updatedByName='" + getUpdatedByName() + "'" +
            ", updatedDate='" + getUpdatedDate() + "'" +
            "}";
    }
}
