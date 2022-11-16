package com.sunknowledge.dme.rcm.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesOrderItemDetailsDTO implements Serializable {

    private Long salesOrderItemDetailsId;

    @NotNull(message = "must not be null")
    private Long salesOrderId;

    @NotNull(message = "must not be null")
    private Integer patientId;

    @NotNull(message = "must not be null")
    private Integer itemLocationId;

    @NotNull(message = "must not be null")
    private Long salesOrderDetailItemId;

    @NotNull(message = "must not be null")
    private String salesOrderDetailItemName;

    private String salesOrderDetailStockingUom;

    private String salesOrderDetailStockingUomName;

    private String salesOrderDetailItemDescription;

    private String salesOrderDetailDefaultVendor;

    private LocalDate salesOrderDetailOriginalDos;

    private LocalDate salesOrderDetailPreviousBillingDate;

    private LocalDate salesOrderDetailNextBillingDate;

    private LocalDate salesOrderDetailDosTo;

    private String salesOrderDetailNextPeriod;

    private String salesOrderDetailSpecialPricing;

    private String salesOrderDetailPriceOverride;

    private Integer salesOrderDetailSpecialTaxRate;

    private Integer salesOrderDetailQty;

    private Integer salesOrderDetailBqty;

    private Integer salesOrderDetailLineQty;

    private String salesOrderDetailProcCode;

    private String salesOrderDetailPriceOption;

    private String salesOrderDetailModifier1;

    private String salesOrderDetailModifier2;

    private String salesOrderDetailModifier3;

    private String salesOrderDetailModifier4;

    private Double salesOrderDetailChargeAmt;

    private Double salesOrderDetailAllowedAmt;

    private String salesOrderDetailTaxable;

    private String salesOrderDetailAbn;

    private String salesOrderDetailAbnUpgrade;

    private LocalDate salesOrderDetailAbnPrintDate;

    private String salesOrderDetailAbnItem;

    private String salesOrderDetailAbnProcCode;

    private String salesOrderDetailAbnAllow;

    private Integer salesOrderDetailAbnCharge;

    private String salesOrderDetailAbnModifier1;

    private String salesOrderDetailAbnModifier2;

    private Integer salesOrderDetailTaxRate;

    private String salesOrderDetailTaxZone;

    private String salesOrderDetailNonTaxReason;

    private String salesOrderDetailNote;

    private String salesOrderDetailSaleType;

    private String salesOrderDetailItemGroup;

    private String salesOrderDetailItemUser1;

    private String salesOrderDetailItemUser2;

    private String salesOrderDetailItemUser3;

    private String salesOrderDetailItemUser4;

    private String salesOrderDetailConvertedToPurchase;

    private String salesOrderDetailManualConvertToPurchaseMctp;

    private Double salesOrderDetailMctpChargeAmt;

    private Double salesOrderDetailMctpAllowedAmt;

    private String salesOrderDetailMctpModifier1;

    private String salesOrderDetailMctpModifier2;

    private String salesOrderDetailMctpModifier3;

    private String salesOrderDetailMctpModifier4;

    private Integer salesOrderDetailMctpPeriod;

    private String salesOrderDetailAddtlModifier1;

    private String salesOrderDetailAddtlModifier2;

    private String salesOrderDetailAddtlModifier3;

    private String salesOrderDetailAddtlModifier4;

    private LocalDate salesOrderDetailNextDateOfService;

    private String salesOrderDetailPriceTable;

    private String salesOrderDetailPriceOptionName;

    private Double salesOrderDetailExtendedChargeAmount;

    private Double salesOrderDetailExtendedAllowanceAmount;

    private String salesOrderDetailItemNdcCode;

    private String salesOrderDetailManufacturer;

    private String salesOrderDetailCbPricing;

    private String salesOrderDetailCbPriceTableOverride;

    private String salesOrderDetailCbOverride;

    private String salesOrderDetailMessages;

    private Integer salesOrderDetailLocation;

    private Integer salesOrderDetailCaloriesPerDay;

    private String salesOrderDetailSecondaryBillingProcudureCode;

    private String salesOrderDetailSecondaryBillingPriceOption;

    private String salesOrderDetailSecondaryBillingPriceOptionName;

    private String salesOrderDetailSecondaryBillingModifier1;

    private String salesOrderDetailSecondaryBillingModifier2;

    private String salesOrderDetailSecondaryBillingModifier3;

    private String salesOrderDetailSecondaryBillingModifier4;

    private String salesOrderDetailSecondaryBillingAdditionalModifier1;

    private String salesOrderDetailSecondaryBillingadditionalModifier2;

    private String salesOrderDetailSecondaryBillingadditionalModifier3;

    private String salesOrderDetailSecondaryBillingadditionalModifier4;

    private String salesOrderDetailSecondaryBillingIgnore;

    private String salesOrderDetailSecondarySpecialBilling;

    private String salesOrderDetailSpanDateSplitBilling;

    private String salesOrderDetailManufacturerItemIdNumber;

    private Integer cmnId;

    private Integer cmnparCmnFormId;

    private String cmnparCmnKey;

    private LocalDate cmnparCmnCreateDate;

    private LocalDate cmnparCmnExpirationDate;

    private LocalDate cmnparCmnInitialDate;

    private LocalDate cmnparCmnRenewalDate;

    private LocalDate cmnparCmnRecertificationDate;

    private LocalDate cmnparCmnPhysicianDate;

    private String cmnparCmnStatus;

    private Integer cmnparParId;

    private String cmnparParDescr;

    private LocalDate cmnparParInitialDate;

    private LocalDate cmnparParExpirationDate;

    private LocalDate cmnparCmnLogDate;

    private Integer cmnparCmnLengthOfNeed;

    private LocalDate cmnparCmnPrintedDate;

    private String cmnparCmnPrintedBy;

    private LocalDate cmnparFaxedDate;

    private String cmnparCmnPlaceholder;

    private String cmnparCmnFaxedBy;

    private String cmnparCmnLoggedBy;

    private Integer cmnparNumberOfRefills;

    private String status;

    private Integer createdById;

    private String createdByName;

    private ZonedDateTime createdDate;

    private Integer updatedById;

    private String updatedByName;

    private ZonedDateTime updatedDate;

    private SalesOrderMasterDTO itemDetails;

    public Long getSalesOrderItemDetailsId() {
        return salesOrderItemDetailsId;
    }

    public void setSalesOrderItemDetailsId(Long salesOrderItemDetailsId) {
        this.salesOrderItemDetailsId = salesOrderItemDetailsId;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getItemLocationId() {
        return itemLocationId;
    }

    public void setItemLocationId(Integer itemLocationId) {
        this.itemLocationId = itemLocationId;
    }

    public Long getSalesOrderDetailItemId() {
        return salesOrderDetailItemId;
    }

    public void setSalesOrderDetailItemId(Long salesOrderDetailItemId) {
        this.salesOrderDetailItemId = salesOrderDetailItemId;
    }

    public String getSalesOrderDetailItemName() {
        return salesOrderDetailItemName;
    }

    public void setSalesOrderDetailItemName(String salesOrderDetailItemName) {
        this.salesOrderDetailItemName = salesOrderDetailItemName;
    }

    public String getSalesOrderDetailStockingUom() {
        return salesOrderDetailStockingUom;
    }

    public void setSalesOrderDetailStockingUom(String salesOrderDetailStockingUom) {
        this.salesOrderDetailStockingUom = salesOrderDetailStockingUom;
    }

    public String getSalesOrderDetailStockingUomName() {
        return salesOrderDetailStockingUomName;
    }

    public void setSalesOrderDetailStockingUomName(String salesOrderDetailStockingUomName) {
        this.salesOrderDetailStockingUomName = salesOrderDetailStockingUomName;
    }

    public String getSalesOrderDetailItemDescription() {
        return salesOrderDetailItemDescription;
    }

    public void setSalesOrderDetailItemDescription(String salesOrderDetailItemDescription) {
        this.salesOrderDetailItemDescription = salesOrderDetailItemDescription;
    }

    public String getSalesOrderDetailDefaultVendor() {
        return salesOrderDetailDefaultVendor;
    }

    public void setSalesOrderDetailDefaultVendor(String salesOrderDetailDefaultVendor) {
        this.salesOrderDetailDefaultVendor = salesOrderDetailDefaultVendor;
    }

    public LocalDate getSalesOrderDetailOriginalDos() {
        return salesOrderDetailOriginalDos;
    }

    public void setSalesOrderDetailOriginalDos(LocalDate salesOrderDetailOriginalDos) {
        this.salesOrderDetailOriginalDos = salesOrderDetailOriginalDos;
    }

    public LocalDate getSalesOrderDetailPreviousBillingDate() {
        return salesOrderDetailPreviousBillingDate;
    }

    public void setSalesOrderDetailPreviousBillingDate(LocalDate salesOrderDetailPreviousBillingDate) {
        this.salesOrderDetailPreviousBillingDate = salesOrderDetailPreviousBillingDate;
    }

    public LocalDate getSalesOrderDetailNextBillingDate() {
        return salesOrderDetailNextBillingDate;
    }

    public void setSalesOrderDetailNextBillingDate(LocalDate salesOrderDetailNextBillingDate) {
        this.salesOrderDetailNextBillingDate = salesOrderDetailNextBillingDate;
    }

    public LocalDate getSalesOrderDetailDosTo() {
        return salesOrderDetailDosTo;
    }

    public void setSalesOrderDetailDosTo(LocalDate salesOrderDetailDosTo) {
        this.salesOrderDetailDosTo = salesOrderDetailDosTo;
    }

    public String getSalesOrderDetailNextPeriod() {
        return salesOrderDetailNextPeriod;
    }

    public void setSalesOrderDetailNextPeriod(String salesOrderDetailNextPeriod) {
        this.salesOrderDetailNextPeriod = salesOrderDetailNextPeriod;
    }

    public String getSalesOrderDetailSpecialPricing() {
        return salesOrderDetailSpecialPricing;
    }

    public void setSalesOrderDetailSpecialPricing(String salesOrderDetailSpecialPricing) {
        this.salesOrderDetailSpecialPricing = salesOrderDetailSpecialPricing;
    }

    public String getSalesOrderDetailPriceOverride() {
        return salesOrderDetailPriceOverride;
    }

    public void setSalesOrderDetailPriceOverride(String salesOrderDetailPriceOverride) {
        this.salesOrderDetailPriceOverride = salesOrderDetailPriceOverride;
    }

    public Integer getSalesOrderDetailSpecialTaxRate() {
        return salesOrderDetailSpecialTaxRate;
    }

    public void setSalesOrderDetailSpecialTaxRate(Integer salesOrderDetailSpecialTaxRate) {
        this.salesOrderDetailSpecialTaxRate = salesOrderDetailSpecialTaxRate;
    }

    public Integer getSalesOrderDetailQty() {
        return salesOrderDetailQty;
    }

    public void setSalesOrderDetailQty(Integer salesOrderDetailQty) {
        this.salesOrderDetailQty = salesOrderDetailQty;
    }

    public Integer getSalesOrderDetailBqty() {
        return salesOrderDetailBqty;
    }

    public void setSalesOrderDetailBqty(Integer salesOrderDetailBqty) {
        this.salesOrderDetailBqty = salesOrderDetailBqty;
    }

    public Integer getSalesOrderDetailLineQty() {
        return salesOrderDetailLineQty;
    }

    public void setSalesOrderDetailLineQty(Integer salesOrderDetailLineQty) {
        this.salesOrderDetailLineQty = salesOrderDetailLineQty;
    }

    public String getSalesOrderDetailProcCode() {
        return salesOrderDetailProcCode;
    }

    public void setSalesOrderDetailProcCode(String salesOrderDetailProcCode) {
        this.salesOrderDetailProcCode = salesOrderDetailProcCode;
    }

    public String getSalesOrderDetailPriceOption() {
        return salesOrderDetailPriceOption;
    }

    public void setSalesOrderDetailPriceOption(String salesOrderDetailPriceOption) {
        this.salesOrderDetailPriceOption = salesOrderDetailPriceOption;
    }

    public String getSalesOrderDetailModifier1() {
        return salesOrderDetailModifier1;
    }

    public void setSalesOrderDetailModifier1(String salesOrderDetailModifier1) {
        this.salesOrderDetailModifier1 = salesOrderDetailModifier1;
    }

    public String getSalesOrderDetailModifier2() {
        return salesOrderDetailModifier2;
    }

    public void setSalesOrderDetailModifier2(String salesOrderDetailModifier2) {
        this.salesOrderDetailModifier2 = salesOrderDetailModifier2;
    }

    public String getSalesOrderDetailModifier3() {
        return salesOrderDetailModifier3;
    }

    public void setSalesOrderDetailModifier3(String salesOrderDetailModifier3) {
        this.salesOrderDetailModifier3 = salesOrderDetailModifier3;
    }

    public String getSalesOrderDetailModifier4() {
        return salesOrderDetailModifier4;
    }

    public void setSalesOrderDetailModifier4(String salesOrderDetailModifier4) {
        this.salesOrderDetailModifier4 = salesOrderDetailModifier4;
    }

    public Double getSalesOrderDetailChargeAmt() {
        return salesOrderDetailChargeAmt;
    }

    public void setSalesOrderDetailChargeAmt(Double salesOrderDetailChargeAmt) {
        this.salesOrderDetailChargeAmt = salesOrderDetailChargeAmt;
    }

    public Double getSalesOrderDetailAllowedAmt() {
        return salesOrderDetailAllowedAmt;
    }

    public void setSalesOrderDetailAllowedAmt(Double salesOrderDetailAllowedAmt) {
        this.salesOrderDetailAllowedAmt = salesOrderDetailAllowedAmt;
    }

    public String getSalesOrderDetailTaxable() {
        return salesOrderDetailTaxable;
    }

    public void setSalesOrderDetailTaxable(String salesOrderDetailTaxable) {
        this.salesOrderDetailTaxable = salesOrderDetailTaxable;
    }

    public String getSalesOrderDetailAbn() {
        return salesOrderDetailAbn;
    }

    public void setSalesOrderDetailAbn(String salesOrderDetailAbn) {
        this.salesOrderDetailAbn = salesOrderDetailAbn;
    }

    public String getSalesOrderDetailAbnUpgrade() {
        return salesOrderDetailAbnUpgrade;
    }

    public void setSalesOrderDetailAbnUpgrade(String salesOrderDetailAbnUpgrade) {
        this.salesOrderDetailAbnUpgrade = salesOrderDetailAbnUpgrade;
    }

    public LocalDate getSalesOrderDetailAbnPrintDate() {
        return salesOrderDetailAbnPrintDate;
    }

    public void setSalesOrderDetailAbnPrintDate(LocalDate salesOrderDetailAbnPrintDate) {
        this.salesOrderDetailAbnPrintDate = salesOrderDetailAbnPrintDate;
    }

    public String getSalesOrderDetailAbnItem() {
        return salesOrderDetailAbnItem;
    }

    public void setSalesOrderDetailAbnItem(String salesOrderDetailAbnItem) {
        this.salesOrderDetailAbnItem = salesOrderDetailAbnItem;
    }

    public String getSalesOrderDetailAbnProcCode() {
        return salesOrderDetailAbnProcCode;
    }

    public void setSalesOrderDetailAbnProcCode(String salesOrderDetailAbnProcCode) {
        this.salesOrderDetailAbnProcCode = salesOrderDetailAbnProcCode;
    }

    public String getSalesOrderDetailAbnAllow() {
        return salesOrderDetailAbnAllow;
    }

    public void setSalesOrderDetailAbnAllow(String salesOrderDetailAbnAllow) {
        this.salesOrderDetailAbnAllow = salesOrderDetailAbnAllow;
    }

    public Integer getSalesOrderDetailAbnCharge() {
        return salesOrderDetailAbnCharge;
    }

    public void setSalesOrderDetailAbnCharge(Integer salesOrderDetailAbnCharge) {
        this.salesOrderDetailAbnCharge = salesOrderDetailAbnCharge;
    }

    public String getSalesOrderDetailAbnModifier1() {
        return salesOrderDetailAbnModifier1;
    }

    public void setSalesOrderDetailAbnModifier1(String salesOrderDetailAbnModifier1) {
        this.salesOrderDetailAbnModifier1 = salesOrderDetailAbnModifier1;
    }

    public String getSalesOrderDetailAbnModifier2() {
        return salesOrderDetailAbnModifier2;
    }

    public void setSalesOrderDetailAbnModifier2(String salesOrderDetailAbnModifier2) {
        this.salesOrderDetailAbnModifier2 = salesOrderDetailAbnModifier2;
    }

    public Integer getSalesOrderDetailTaxRate() {
        return salesOrderDetailTaxRate;
    }

    public void setSalesOrderDetailTaxRate(Integer salesOrderDetailTaxRate) {
        this.salesOrderDetailTaxRate = salesOrderDetailTaxRate;
    }

    public String getSalesOrderDetailTaxZone() {
        return salesOrderDetailTaxZone;
    }

    public void setSalesOrderDetailTaxZone(String salesOrderDetailTaxZone) {
        this.salesOrderDetailTaxZone = salesOrderDetailTaxZone;
    }

    public String getSalesOrderDetailNonTaxReason() {
        return salesOrderDetailNonTaxReason;
    }

    public void setSalesOrderDetailNonTaxReason(String salesOrderDetailNonTaxReason) {
        this.salesOrderDetailNonTaxReason = salesOrderDetailNonTaxReason;
    }

    public String getSalesOrderDetailNote() {
        return salesOrderDetailNote;
    }

    public void setSalesOrderDetailNote(String salesOrderDetailNote) {
        this.salesOrderDetailNote = salesOrderDetailNote;
    }

    public String getSalesOrderDetailSaleType() {
        return salesOrderDetailSaleType;
    }

    public void setSalesOrderDetailSaleType(String salesOrderDetailSaleType) {
        this.salesOrderDetailSaleType = salesOrderDetailSaleType;
    }

    public String getSalesOrderDetailItemGroup() {
        return salesOrderDetailItemGroup;
    }

    public void setSalesOrderDetailItemGroup(String salesOrderDetailItemGroup) {
        this.salesOrderDetailItemGroup = salesOrderDetailItemGroup;
    }

    public String getSalesOrderDetailItemUser1() {
        return salesOrderDetailItemUser1;
    }

    public void setSalesOrderDetailItemUser1(String salesOrderDetailItemUser1) {
        this.salesOrderDetailItemUser1 = salesOrderDetailItemUser1;
    }

    public String getSalesOrderDetailItemUser2() {
        return salesOrderDetailItemUser2;
    }

    public void setSalesOrderDetailItemUser2(String salesOrderDetailItemUser2) {
        this.salesOrderDetailItemUser2 = salesOrderDetailItemUser2;
    }

    public String getSalesOrderDetailItemUser3() {
        return salesOrderDetailItemUser3;
    }

    public void setSalesOrderDetailItemUser3(String salesOrderDetailItemUser3) {
        this.salesOrderDetailItemUser3 = salesOrderDetailItemUser3;
    }

    public String getSalesOrderDetailItemUser4() {
        return salesOrderDetailItemUser4;
    }

    public void setSalesOrderDetailItemUser4(String salesOrderDetailItemUser4) {
        this.salesOrderDetailItemUser4 = salesOrderDetailItemUser4;
    }

    public String getSalesOrderDetailConvertedToPurchase() {
        return salesOrderDetailConvertedToPurchase;
    }

    public void setSalesOrderDetailConvertedToPurchase(String salesOrderDetailConvertedToPurchase) {
        this.salesOrderDetailConvertedToPurchase = salesOrderDetailConvertedToPurchase;
    }

    public String getSalesOrderDetailManualConvertToPurchaseMctp() {
        return salesOrderDetailManualConvertToPurchaseMctp;
    }

    public void setSalesOrderDetailManualConvertToPurchaseMctp(String salesOrderDetailManualConvertToPurchaseMctp) {
        this.salesOrderDetailManualConvertToPurchaseMctp = salesOrderDetailManualConvertToPurchaseMctp;
    }

    public Double getSalesOrderDetailMctpChargeAmt() {
        return salesOrderDetailMctpChargeAmt;
    }

    public void setSalesOrderDetailMctpChargeAmt(Double salesOrderDetailMctpChargeAmt) {
        this.salesOrderDetailMctpChargeAmt = salesOrderDetailMctpChargeAmt;
    }

    public Double getSalesOrderDetailMctpAllowedAmt() {
        return salesOrderDetailMctpAllowedAmt;
    }

    public void setSalesOrderDetailMctpAllowedAmt(Double salesOrderDetailMctpAllowedAmt) {
        this.salesOrderDetailMctpAllowedAmt = salesOrderDetailMctpAllowedAmt;
    }

    public String getSalesOrderDetailMctpModifier1() {
        return salesOrderDetailMctpModifier1;
    }

    public void setSalesOrderDetailMctpModifier1(String salesOrderDetailMctpModifier1) {
        this.salesOrderDetailMctpModifier1 = salesOrderDetailMctpModifier1;
    }

    public String getSalesOrderDetailMctpModifier2() {
        return salesOrderDetailMctpModifier2;
    }

    public void setSalesOrderDetailMctpModifier2(String salesOrderDetailMctpModifier2) {
        this.salesOrderDetailMctpModifier2 = salesOrderDetailMctpModifier2;
    }

    public String getSalesOrderDetailMctpModifier3() {
        return salesOrderDetailMctpModifier3;
    }

    public void setSalesOrderDetailMctpModifier3(String salesOrderDetailMctpModifier3) {
        this.salesOrderDetailMctpModifier3 = salesOrderDetailMctpModifier3;
    }

    public String getSalesOrderDetailMctpModifier4() {
        return salesOrderDetailMctpModifier4;
    }

    public void setSalesOrderDetailMctpModifier4(String salesOrderDetailMctpModifier4) {
        this.salesOrderDetailMctpModifier4 = salesOrderDetailMctpModifier4;
    }

    public Integer getSalesOrderDetailMctpPeriod() {
        return salesOrderDetailMctpPeriod;
    }

    public void setSalesOrderDetailMctpPeriod(Integer salesOrderDetailMctpPeriod) {
        this.salesOrderDetailMctpPeriod = salesOrderDetailMctpPeriod;
    }

    public String getSalesOrderDetailAddtlModifier1() {
        return salesOrderDetailAddtlModifier1;
    }

    public void setSalesOrderDetailAddtlModifier1(String salesOrderDetailAddtlModifier1) {
        this.salesOrderDetailAddtlModifier1 = salesOrderDetailAddtlModifier1;
    }

    public String getSalesOrderDetailAddtlModifier2() {
        return salesOrderDetailAddtlModifier2;
    }

    public void setSalesOrderDetailAddtlModifier2(String salesOrderDetailAddtlModifier2) {
        this.salesOrderDetailAddtlModifier2 = salesOrderDetailAddtlModifier2;
    }

    public String getSalesOrderDetailAddtlModifier3() {
        return salesOrderDetailAddtlModifier3;
    }

    public void setSalesOrderDetailAddtlModifier3(String salesOrderDetailAddtlModifier3) {
        this.salesOrderDetailAddtlModifier3 = salesOrderDetailAddtlModifier3;
    }

    public String getSalesOrderDetailAddtlModifier4() {
        return salesOrderDetailAddtlModifier4;
    }

    public void setSalesOrderDetailAddtlModifier4(String salesOrderDetailAddtlModifier4) {
        this.salesOrderDetailAddtlModifier4 = salesOrderDetailAddtlModifier4;
    }

    public LocalDate getSalesOrderDetailNextDateOfService() {
        return salesOrderDetailNextDateOfService;
    }

    public void setSalesOrderDetailNextDateOfService(LocalDate salesOrderDetailNextDateOfService) {
        this.salesOrderDetailNextDateOfService = salesOrderDetailNextDateOfService;
    }

    public String getSalesOrderDetailPriceTable() {
        return salesOrderDetailPriceTable;
    }

    public void setSalesOrderDetailPriceTable(String salesOrderDetailPriceTable) {
        this.salesOrderDetailPriceTable = salesOrderDetailPriceTable;
    }

    public String getSalesOrderDetailPriceOptionName() {
        return salesOrderDetailPriceOptionName;
    }

    public void setSalesOrderDetailPriceOptionName(String salesOrderDetailPriceOptionName) {
        this.salesOrderDetailPriceOptionName = salesOrderDetailPriceOptionName;
    }

    public Double getSalesOrderDetailExtendedChargeAmount() {
        return salesOrderDetailExtendedChargeAmount;
    }

    public void setSalesOrderDetailExtendedChargeAmount(Double salesOrderDetailExtendedChargeAmount) {
        this.salesOrderDetailExtendedChargeAmount = salesOrderDetailExtendedChargeAmount;
    }

    public Double getSalesOrderDetailExtendedAllowanceAmount() {
        return salesOrderDetailExtendedAllowanceAmount;
    }

    public void setSalesOrderDetailExtendedAllowanceAmount(Double salesOrderDetailExtendedAllowanceAmount) {
        this.salesOrderDetailExtendedAllowanceAmount = salesOrderDetailExtendedAllowanceAmount;
    }

    public String getSalesOrderDetailItemNdcCode() {
        return salesOrderDetailItemNdcCode;
    }

    public void setSalesOrderDetailItemNdcCode(String salesOrderDetailItemNdcCode) {
        this.salesOrderDetailItemNdcCode = salesOrderDetailItemNdcCode;
    }

    public String getSalesOrderDetailManufacturer() {
        return salesOrderDetailManufacturer;
    }

    public void setSalesOrderDetailManufacturer(String salesOrderDetailManufacturer) {
        this.salesOrderDetailManufacturer = salesOrderDetailManufacturer;
    }

    public String getSalesOrderDetailCbPricing() {
        return salesOrderDetailCbPricing;
    }

    public void setSalesOrderDetailCbPricing(String salesOrderDetailCbPricing) {
        this.salesOrderDetailCbPricing = salesOrderDetailCbPricing;
    }

    public String getSalesOrderDetailCbPriceTableOverride() {
        return salesOrderDetailCbPriceTableOverride;
    }

    public void setSalesOrderDetailCbPriceTableOverride(String salesOrderDetailCbPriceTableOverride) {
        this.salesOrderDetailCbPriceTableOverride = salesOrderDetailCbPriceTableOverride;
    }

    public String getSalesOrderDetailCbOverride() {
        return salesOrderDetailCbOverride;
    }

    public void setSalesOrderDetailCbOverride(String salesOrderDetailCbOverride) {
        this.salesOrderDetailCbOverride = salesOrderDetailCbOverride;
    }

    public String getSalesOrderDetailMessages() {
        return salesOrderDetailMessages;
    }

    public void setSalesOrderDetailMessages(String salesOrderDetailMessages) {
        this.salesOrderDetailMessages = salesOrderDetailMessages;
    }

    public Integer getSalesOrderDetailLocation() {
        return salesOrderDetailLocation;
    }

    public void setSalesOrderDetailLocation(Integer salesOrderDetailLocation) {
        this.salesOrderDetailLocation = salesOrderDetailLocation;
    }

    public Integer getSalesOrderDetailCaloriesPerDay() {
        return salesOrderDetailCaloriesPerDay;
    }

    public void setSalesOrderDetailCaloriesPerDay(Integer salesOrderDetailCaloriesPerDay) {
        this.salesOrderDetailCaloriesPerDay = salesOrderDetailCaloriesPerDay;
    }

    public String getSalesOrderDetailSecondaryBillingProcudureCode() {
        return salesOrderDetailSecondaryBillingProcudureCode;
    }

    public void setSalesOrderDetailSecondaryBillingProcudureCode(String salesOrderDetailSecondaryBillingProcudureCode) {
        this.salesOrderDetailSecondaryBillingProcudureCode = salesOrderDetailSecondaryBillingProcudureCode;
    }

    public String getSalesOrderDetailSecondaryBillingPriceOption() {
        return salesOrderDetailSecondaryBillingPriceOption;
    }

    public void setSalesOrderDetailSecondaryBillingPriceOption(String salesOrderDetailSecondaryBillingPriceOption) {
        this.salesOrderDetailSecondaryBillingPriceOption = salesOrderDetailSecondaryBillingPriceOption;
    }

    public String getSalesOrderDetailSecondaryBillingPriceOptionName() {
        return salesOrderDetailSecondaryBillingPriceOptionName;
    }

    public void setSalesOrderDetailSecondaryBillingPriceOptionName(String salesOrderDetailSecondaryBillingPriceOptionName) {
        this.salesOrderDetailSecondaryBillingPriceOptionName = salesOrderDetailSecondaryBillingPriceOptionName;
    }

    public String getSalesOrderDetailSecondaryBillingModifier1() {
        return salesOrderDetailSecondaryBillingModifier1;
    }

    public void setSalesOrderDetailSecondaryBillingModifier1(String salesOrderDetailSecondaryBillingModifier1) {
        this.salesOrderDetailSecondaryBillingModifier1 = salesOrderDetailSecondaryBillingModifier1;
    }

    public String getSalesOrderDetailSecondaryBillingModifier2() {
        return salesOrderDetailSecondaryBillingModifier2;
    }

    public void setSalesOrderDetailSecondaryBillingModifier2(String salesOrderDetailSecondaryBillingModifier2) {
        this.salesOrderDetailSecondaryBillingModifier2 = salesOrderDetailSecondaryBillingModifier2;
    }

    public String getSalesOrderDetailSecondaryBillingModifier3() {
        return salesOrderDetailSecondaryBillingModifier3;
    }

    public void setSalesOrderDetailSecondaryBillingModifier3(String salesOrderDetailSecondaryBillingModifier3) {
        this.salesOrderDetailSecondaryBillingModifier3 = salesOrderDetailSecondaryBillingModifier3;
    }

    public String getSalesOrderDetailSecondaryBillingModifier4() {
        return salesOrderDetailSecondaryBillingModifier4;
    }

    public void setSalesOrderDetailSecondaryBillingModifier4(String salesOrderDetailSecondaryBillingModifier4) {
        this.salesOrderDetailSecondaryBillingModifier4 = salesOrderDetailSecondaryBillingModifier4;
    }

    public String getSalesOrderDetailSecondaryBillingAdditionalModifier1() {
        return salesOrderDetailSecondaryBillingAdditionalModifier1;
    }

    public void setSalesOrderDetailSecondaryBillingAdditionalModifier1(String salesOrderDetailSecondaryBillingAdditionalModifier1) {
        this.salesOrderDetailSecondaryBillingAdditionalModifier1 = salesOrderDetailSecondaryBillingAdditionalModifier1;
    }

    public String getSalesOrderDetailSecondaryBillingadditionalModifier2() {
        return salesOrderDetailSecondaryBillingadditionalModifier2;
    }

    public void setSalesOrderDetailSecondaryBillingadditionalModifier2(String salesOrderDetailSecondaryBillingadditionalModifier2) {
        this.salesOrderDetailSecondaryBillingadditionalModifier2 = salesOrderDetailSecondaryBillingadditionalModifier2;
    }

    public String getSalesOrderDetailSecondaryBillingadditionalModifier3() {
        return salesOrderDetailSecondaryBillingadditionalModifier3;
    }

    public void setSalesOrderDetailSecondaryBillingadditionalModifier3(String salesOrderDetailSecondaryBillingadditionalModifier3) {
        this.salesOrderDetailSecondaryBillingadditionalModifier3 = salesOrderDetailSecondaryBillingadditionalModifier3;
    }

    public String getSalesOrderDetailSecondaryBillingadditionalModifier4() {
        return salesOrderDetailSecondaryBillingadditionalModifier4;
    }

    public void setSalesOrderDetailSecondaryBillingadditionalModifier4(String salesOrderDetailSecondaryBillingadditionalModifier4) {
        this.salesOrderDetailSecondaryBillingadditionalModifier4 = salesOrderDetailSecondaryBillingadditionalModifier4;
    }

    public String getSalesOrderDetailSecondaryBillingIgnore() {
        return salesOrderDetailSecondaryBillingIgnore;
    }

    public void setSalesOrderDetailSecondaryBillingIgnore(String salesOrderDetailSecondaryBillingIgnore) {
        this.salesOrderDetailSecondaryBillingIgnore = salesOrderDetailSecondaryBillingIgnore;
    }

    public String getSalesOrderDetailSecondarySpecialBilling() {
        return salesOrderDetailSecondarySpecialBilling;
    }

    public void setSalesOrderDetailSecondarySpecialBilling(String salesOrderDetailSecondarySpecialBilling) {
        this.salesOrderDetailSecondarySpecialBilling = salesOrderDetailSecondarySpecialBilling;
    }

    public String getSalesOrderDetailSpanDateSplitBilling() {
        return salesOrderDetailSpanDateSplitBilling;
    }

    public void setSalesOrderDetailSpanDateSplitBilling(String salesOrderDetailSpanDateSplitBilling) {
        this.salesOrderDetailSpanDateSplitBilling = salesOrderDetailSpanDateSplitBilling;
    }

    public String getSalesOrderDetailManufacturerItemIdNumber() {
        return salesOrderDetailManufacturerItemIdNumber;
    }

    public void setSalesOrderDetailManufacturerItemIdNumber(String salesOrderDetailManufacturerItemIdNumber) {
        this.salesOrderDetailManufacturerItemIdNumber = salesOrderDetailManufacturerItemIdNumber;
    }

    public Integer getCmnId() {
        return cmnId;
    }

    public void setCmnId(Integer cmnId) {
        this.cmnId = cmnId;
    }

    public Integer getCmnparCmnFormId() {
        return cmnparCmnFormId;
    }

    public void setCmnparCmnFormId(Integer cmnparCmnFormId) {
        this.cmnparCmnFormId = cmnparCmnFormId;
    }

    public String getCmnparCmnKey() {
        return cmnparCmnKey;
    }

    public void setCmnparCmnKey(String cmnparCmnKey) {
        this.cmnparCmnKey = cmnparCmnKey;
    }

    public LocalDate getCmnparCmnCreateDate() {
        return cmnparCmnCreateDate;
    }

    public void setCmnparCmnCreateDate(LocalDate cmnparCmnCreateDate) {
        this.cmnparCmnCreateDate = cmnparCmnCreateDate;
    }

    public LocalDate getCmnparCmnExpirationDate() {
        return cmnparCmnExpirationDate;
    }

    public void setCmnparCmnExpirationDate(LocalDate cmnparCmnExpirationDate) {
        this.cmnparCmnExpirationDate = cmnparCmnExpirationDate;
    }

    public LocalDate getCmnparCmnInitialDate() {
        return cmnparCmnInitialDate;
    }

    public void setCmnparCmnInitialDate(LocalDate cmnparCmnInitialDate) {
        this.cmnparCmnInitialDate = cmnparCmnInitialDate;
    }

    public LocalDate getCmnparCmnRenewalDate() {
        return cmnparCmnRenewalDate;
    }

    public void setCmnparCmnRenewalDate(LocalDate cmnparCmnRenewalDate) {
        this.cmnparCmnRenewalDate = cmnparCmnRenewalDate;
    }

    public LocalDate getCmnparCmnRecertificationDate() {
        return cmnparCmnRecertificationDate;
    }

    public void setCmnparCmnRecertificationDate(LocalDate cmnparCmnRecertificationDate) {
        this.cmnparCmnRecertificationDate = cmnparCmnRecertificationDate;
    }

    public LocalDate getCmnparCmnPhysicianDate() {
        return cmnparCmnPhysicianDate;
    }

    public void setCmnparCmnPhysicianDate(LocalDate cmnparCmnPhysicianDate) {
        this.cmnparCmnPhysicianDate = cmnparCmnPhysicianDate;
    }

    public String getCmnparCmnStatus() {
        return cmnparCmnStatus;
    }

    public void setCmnparCmnStatus(String cmnparCmnStatus) {
        this.cmnparCmnStatus = cmnparCmnStatus;
    }

    public Integer getCmnparParId() {
        return cmnparParId;
    }

    public void setCmnparParId(Integer cmnparParId) {
        this.cmnparParId = cmnparParId;
    }

    public String getCmnparParDescr() {
        return cmnparParDescr;
    }

    public void setCmnparParDescr(String cmnparParDescr) {
        this.cmnparParDescr = cmnparParDescr;
    }

    public LocalDate getCmnparParInitialDate() {
        return cmnparParInitialDate;
    }

    public void setCmnparParInitialDate(LocalDate cmnparParInitialDate) {
        this.cmnparParInitialDate = cmnparParInitialDate;
    }

    public LocalDate getCmnparParExpirationDate() {
        return cmnparParExpirationDate;
    }

    public void setCmnparParExpirationDate(LocalDate cmnparParExpirationDate) {
        this.cmnparParExpirationDate = cmnparParExpirationDate;
    }

    public LocalDate getCmnparCmnLogDate() {
        return cmnparCmnLogDate;
    }

    public void setCmnparCmnLogDate(LocalDate cmnparCmnLogDate) {
        this.cmnparCmnLogDate = cmnparCmnLogDate;
    }

    public Integer getCmnparCmnLengthOfNeed() {
        return cmnparCmnLengthOfNeed;
    }

    public void setCmnparCmnLengthOfNeed(Integer cmnparCmnLengthOfNeed) {
        this.cmnparCmnLengthOfNeed = cmnparCmnLengthOfNeed;
    }

    public LocalDate getCmnparCmnPrintedDate() {
        return cmnparCmnPrintedDate;
    }

    public void setCmnparCmnPrintedDate(LocalDate cmnparCmnPrintedDate) {
        this.cmnparCmnPrintedDate = cmnparCmnPrintedDate;
    }

    public String getCmnparCmnPrintedBy() {
        return cmnparCmnPrintedBy;
    }

    public void setCmnparCmnPrintedBy(String cmnparCmnPrintedBy) {
        this.cmnparCmnPrintedBy = cmnparCmnPrintedBy;
    }

    public LocalDate getCmnparFaxedDate() {
        return cmnparFaxedDate;
    }

    public void setCmnparFaxedDate(LocalDate cmnparFaxedDate) {
        this.cmnparFaxedDate = cmnparFaxedDate;
    }

    public String getCmnparCmnPlaceholder() {
        return cmnparCmnPlaceholder;
    }

    public void setCmnparCmnPlaceholder(String cmnparCmnPlaceholder) {
        this.cmnparCmnPlaceholder = cmnparCmnPlaceholder;
    }

    public String getCmnparCmnFaxedBy() {
        return cmnparCmnFaxedBy;
    }

    public void setCmnparCmnFaxedBy(String cmnparCmnFaxedBy) {
        this.cmnparCmnFaxedBy = cmnparCmnFaxedBy;
    }

    public String getCmnparCmnLoggedBy() {
        return cmnparCmnLoggedBy;
    }

    public void setCmnparCmnLoggedBy(String cmnparCmnLoggedBy) {
        this.cmnparCmnLoggedBy = cmnparCmnLoggedBy;
    }

    public Integer getCmnparNumberOfRefills() {
        return cmnparNumberOfRefills;
    }

    public void setCmnparNumberOfRefills(Integer cmnparNumberOfRefills) {
        this.cmnparNumberOfRefills = cmnparNumberOfRefills;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public SalesOrderMasterDTO getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(SalesOrderMasterDTO itemDetails) {
        this.itemDetails = itemDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesOrderItemDetailsDTO)) {
            return false;
        }

        SalesOrderItemDetailsDTO salesOrderItemDetailsDTO = (SalesOrderItemDetailsDTO) o;
        if (this.salesOrderItemDetailsId == null) {
            return false;
        }
        return Objects.equals(this.salesOrderItemDetailsId, salesOrderItemDetailsDTO.salesOrderItemDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.salesOrderItemDetailsId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderItemDetailsDTO{" +
            "salesOrderItemDetailsId=" + getSalesOrderItemDetailsId() +
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
            ", itemDetails=" + getItemDetails() +
            "}";
    }
}
