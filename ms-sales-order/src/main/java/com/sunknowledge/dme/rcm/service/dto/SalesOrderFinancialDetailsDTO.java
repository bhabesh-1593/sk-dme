package com.sunknowledge.dme.rcm.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.sunknowledge.dme.rcm.domain.SalesOrderFinancialDetails} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesOrderFinancialDetailsDTO implements Serializable {

    private Long salesOrderFinancialId;

    @NotNull(message = "must not be null")
    private Long salesOrderId;

    @NotNull(message = "must not be null")
    private Integer patientId;

    @NotNull(message = "must not be null")
    private Long itemId;

    @NotNull(message = "must not be null")
    private String itemName;

    @NotNull(message = "must not be null")
    private String itemProcCode;

    @NotNull(message = "must not be null")
    private Double chargedAmount;

    @NotNull(message = "must not be null")
    private Double allowedAmount;

    private Integer primaryInsurerId;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String primaryInsurerName;

    private String primaryInsurerStatus;

    private Integer primaryInsurerCoveragePercentage;

    private Double primaryInsurerCoverageAmount;

    private Double primaryInsurerDeductibleAmount;

    private Double primaryInsurerPayment;

    private Double primaryInsurerBalanceAmount;

    private Integer secondaryInsurerId;

    private String secondaryInsurerName;

    private String secondaryInsurerStatus;

    private Integer secondaryInsurerCoveragerPercentage;

    private Double secondaryInsurerCoverageAmount;

    private Double secondaryInsurerPayment;

    private Double secondaryInsurerBalanceAmount;

    private Integer tertiaryInsurerId;

    private String tertiaryInsurerName;

    private String tertiaryInsurerStatus;

    private Integer tertiaryInsurerCoveragePercentage;

    private Double tertiaryInsurerCoverageAmount;

    private Double tertiaryInsurerPayment;

    private Double tertiaryInsurerBalanceAmount;

    private Integer patientCoinsurancePercentage;

    private Double patientCoinsuranceAmount;

    private Double totalPatientResponsibilityAmount;

    private Double patientPayAmount;

    private String narration;

    private String primaryInvoiceNo;

    private String secondaryInvoiceNo;

    private String tertiaryInvoiceNo;

    private ZonedDateTime primaryInvoiceDate;

    private ZonedDateTime secondaryInvoiceDate;

    private ZonedDateTime tertiaryInvoiceDate;

    private String primaryInvoiceStatus;

    private String secondaryInvoiceStatus;

    private String tertiaryInvoiceStatus;

    private String dos;

    private Integer createdById;

    private String createdByName;

    private ZonedDateTime createdDate;

    private Integer updatedById;

    private String updatedByName;

    private ZonedDateTime updatedDate;

    private SalesOrderMasterDTO salesOrderMaster;

    public Long getSalesOrderFinancialId() {
        return salesOrderFinancialId;
    }

    public void setSalesOrderFinancialId(Long salesOrderFinancialId) {
        this.salesOrderFinancialId = salesOrderFinancialId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemProcCode() {
        return itemProcCode;
    }

    public void setItemProcCode(String itemProcCode) {
        this.itemProcCode = itemProcCode;
    }

    public Double getChargedAmount() {
        return chargedAmount;
    }

    public void setChargedAmount(Double chargedAmount) {
        this.chargedAmount = chargedAmount;
    }

    public Double getAllowedAmount() {
        return allowedAmount;
    }

    public void setAllowedAmount(Double allowedAmount) {
        this.allowedAmount = allowedAmount;
    }

    public Integer getPrimaryInsurerId() {
        return primaryInsurerId;
    }

    public void setPrimaryInsurerId(Integer primaryInsurerId) {
        this.primaryInsurerId = primaryInsurerId;
    }

    public String getPrimaryInsurerName() {
        return primaryInsurerName;
    }

    public void setPrimaryInsurerName(String primaryInsurerName) {
        this.primaryInsurerName = primaryInsurerName;
    }

    public String getPrimaryInsurerStatus() {
        return primaryInsurerStatus;
    }

    public void setPrimaryInsurerStatus(String primaryInsurerStatus) {
        this.primaryInsurerStatus = primaryInsurerStatus;
    }

    public Integer getPrimaryInsurerCoveragePercentage() {
        return primaryInsurerCoveragePercentage;
    }

    public void setPrimaryInsurerCoveragePercentage(Integer primaryInsurerCoveragePercentage) {
        this.primaryInsurerCoveragePercentage = primaryInsurerCoveragePercentage;
    }

    public Double getPrimaryInsurerCoverageAmount() {
        return primaryInsurerCoverageAmount;
    }

    public void setPrimaryInsurerCoverageAmount(Double primaryInsurerCoverageAmount) {
        this.primaryInsurerCoverageAmount = primaryInsurerCoverageAmount;
    }

    public Double getPrimaryInsurerDeductibleAmount() {
        return primaryInsurerDeductibleAmount;
    }

    public void setPrimaryInsurerDeductibleAmount(Double primaryInsurerDeductibleAmount) {
        this.primaryInsurerDeductibleAmount = primaryInsurerDeductibleAmount;
    }

    public Double getPrimaryInsurerPayment() {
        return primaryInsurerPayment;
    }

    public void setPrimaryInsurerPayment(Double primaryInsurerPayment) {
        this.primaryInsurerPayment = primaryInsurerPayment;
    }

    public Double getPrimaryInsurerBalanceAmount() {
        return primaryInsurerBalanceAmount;
    }

    public void setPrimaryInsurerBalanceAmount(Double primaryInsurerBalanceAmount) {
        this.primaryInsurerBalanceAmount = primaryInsurerBalanceAmount;
    }

    public Integer getSecondaryInsurerId() {
        return secondaryInsurerId;
    }

    public void setSecondaryInsurerId(Integer secondaryInsurerId) {
        this.secondaryInsurerId = secondaryInsurerId;
    }

    public String getSecondaryInsurerName() {
        return secondaryInsurerName;
    }

    public void setSecondaryInsurerName(String secondaryInsurerName) {
        this.secondaryInsurerName = secondaryInsurerName;
    }

    public String getSecondaryInsurerStatus() {
        return secondaryInsurerStatus;
    }

    public void setSecondaryInsurerStatus(String secondaryInsurerStatus) {
        this.secondaryInsurerStatus = secondaryInsurerStatus;
    }

    public Integer getSecondaryInsurerCoveragerPercentage() {
        return secondaryInsurerCoveragerPercentage;
    }

    public void setSecondaryInsurerCoveragerPercentage(Integer secondaryInsurerCoveragerPercentage) {
        this.secondaryInsurerCoveragerPercentage = secondaryInsurerCoveragerPercentage;
    }

    public Double getSecondaryInsurerCoverageAmount() {
        return secondaryInsurerCoverageAmount;
    }

    public void setSecondaryInsurerCoverageAmount(Double secondaryInsurerCoverageAmount) {
        this.secondaryInsurerCoverageAmount = secondaryInsurerCoverageAmount;
    }

    public Double getSecondaryInsurerPayment() {
        return secondaryInsurerPayment;
    }

    public void setSecondaryInsurerPayment(Double secondaryInsurerPayment) {
        this.secondaryInsurerPayment = secondaryInsurerPayment;
    }

    public Double getSecondaryInsurerBalanceAmount() {
        return secondaryInsurerBalanceAmount;
    }

    public void setSecondaryInsurerBalanceAmount(Double secondaryInsurerBalanceAmount) {
        this.secondaryInsurerBalanceAmount = secondaryInsurerBalanceAmount;
    }

    public Integer getTertiaryInsurerId() {
        return tertiaryInsurerId;
    }

    public void setTertiaryInsurerId(Integer tertiaryInsurerId) {
        this.tertiaryInsurerId = tertiaryInsurerId;
    }

    public String getTertiaryInsurerName() {
        return tertiaryInsurerName;
    }

    public void setTertiaryInsurerName(String tertiaryInsurerName) {
        this.tertiaryInsurerName = tertiaryInsurerName;
    }

    public String getTertiaryInsurerStatus() {
        return tertiaryInsurerStatus;
    }

    public void setTertiaryInsurerStatus(String tertiaryInsurerStatus) {
        this.tertiaryInsurerStatus = tertiaryInsurerStatus;
    }

    public Integer getTertiaryInsurerCoveragePercentage() {
        return tertiaryInsurerCoveragePercentage;
    }

    public void setTertiaryInsurerCoveragePercentage(Integer tertiaryInsurerCoveragePercentage) {
        this.tertiaryInsurerCoveragePercentage = tertiaryInsurerCoveragePercentage;
    }

    public Double getTertiaryInsurerCoverageAmount() {
        return tertiaryInsurerCoverageAmount;
    }

    public void setTertiaryInsurerCoverageAmount(Double tertiaryInsurerCoverageAmount) {
        this.tertiaryInsurerCoverageAmount = tertiaryInsurerCoverageAmount;
    }

    public Double getTertiaryInsurerPayment() {
        return tertiaryInsurerPayment;
    }

    public void setTertiaryInsurerPayment(Double tertiaryInsurerPayment) {
        this.tertiaryInsurerPayment = tertiaryInsurerPayment;
    }

    public Double getTertiaryInsurerBalanceAmount() {
        return tertiaryInsurerBalanceAmount;
    }

    public void setTertiaryInsurerBalanceAmount(Double tertiaryInsurerBalanceAmount) {
        this.tertiaryInsurerBalanceAmount = tertiaryInsurerBalanceAmount;
    }

    public Integer getPatientCoinsurancePercentage() {
        return patientCoinsurancePercentage;
    }

    public void setPatientCoinsurancePercentage(Integer patientCoinsurancePercentage) {
        this.patientCoinsurancePercentage = patientCoinsurancePercentage;
    }

    public Double getPatientCoinsuranceAmount() {
        return patientCoinsuranceAmount;
    }

    public void setPatientCoinsuranceAmount(Double patientCoinsuranceAmount) {
        this.patientCoinsuranceAmount = patientCoinsuranceAmount;
    }

    public Double getTotalPatientResponsibilityAmount() {
        return totalPatientResponsibilityAmount;
    }

    public void setTotalPatientResponsibilityAmount(Double totalPatientResponsibilityAmount) {
        this.totalPatientResponsibilityAmount = totalPatientResponsibilityAmount;
    }

    public Double getPatientPayAmount() {
        return patientPayAmount;
    }

    public void setPatientPayAmount(Double patientPayAmount) {
        this.patientPayAmount = patientPayAmount;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getPrimaryInvoiceNo() {
        return primaryInvoiceNo;
    }

    public void setPrimaryInvoiceNo(String primaryInvoiceNo) {
        this.primaryInvoiceNo = primaryInvoiceNo;
    }

    public String getSecondaryInvoiceNo() {
        return secondaryInvoiceNo;
    }

    public void setSecondaryInvoiceNo(String secondaryInvoiceNo) {
        this.secondaryInvoiceNo = secondaryInvoiceNo;
    }

    public String getTertiaryInvoiceNo() {
        return tertiaryInvoiceNo;
    }

    public void setTertiaryInvoiceNo(String tertiaryInvoiceNo) {
        this.tertiaryInvoiceNo = tertiaryInvoiceNo;
    }

    public ZonedDateTime getPrimaryInvoiceDate() {
        return primaryInvoiceDate;
    }

    public void setPrimaryInvoiceDate(ZonedDateTime primaryInvoiceDate) {
        this.primaryInvoiceDate = primaryInvoiceDate;
    }

    public ZonedDateTime getSecondaryInvoiceDate() {
        return secondaryInvoiceDate;
    }

    public void setSecondaryInvoiceDate(ZonedDateTime secondaryInvoiceDate) {
        this.secondaryInvoiceDate = secondaryInvoiceDate;
    }

    public ZonedDateTime getTertiaryInvoiceDate() {
        return tertiaryInvoiceDate;
    }

    public void setTertiaryInvoiceDate(ZonedDateTime tertiaryInvoiceDate) {
        this.tertiaryInvoiceDate = tertiaryInvoiceDate;
    }

    public String getPrimaryInvoiceStatus() {
        return primaryInvoiceStatus;
    }

    public void setPrimaryInvoiceStatus(String primaryInvoiceStatus) {
        this.primaryInvoiceStatus = primaryInvoiceStatus;
    }

    public String getSecondaryInvoiceStatus() {
        return secondaryInvoiceStatus;
    }

    public void setSecondaryInvoiceStatus(String secondaryInvoiceStatus) {
        this.secondaryInvoiceStatus = secondaryInvoiceStatus;
    }

    public String getTertiaryInvoiceStatus() {
        return tertiaryInvoiceStatus;
    }

    public void setTertiaryInvoiceStatus(String tertiaryInvoiceStatus) {
        this.tertiaryInvoiceStatus = tertiaryInvoiceStatus;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
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

    public SalesOrderMasterDTO getSalesOrderMaster() {
        return salesOrderMaster;
    }

    public void setSalesOrderMaster(SalesOrderMasterDTO salesOrderMaster) {
        this.salesOrderMaster = salesOrderMaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesOrderFinancialDetailsDTO)) {
            return false;
        }

        SalesOrderFinancialDetailsDTO salesOrderFinancialDetailsDTO = (SalesOrderFinancialDetailsDTO) o;
        if (this.salesOrderFinancialId == null) {
            return false;
        }
        return Objects.equals(this.salesOrderFinancialId, salesOrderFinancialDetailsDTO.salesOrderFinancialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.salesOrderFinancialId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderFinancialDetailsDTO{" +
            "salesOrderFinancialId=" + getSalesOrderFinancialId() +
            ", salesOrderId=" + getSalesOrderId() +
            ", patientId=" + getPatientId() +
            ", itemId=" + getItemId() +
            ", itemName='" + getItemName() + "'" +
            ", itemProcCode='" + getItemProcCode() + "'" +
            ", chargedAmount=" + getChargedAmount() +
            ", allowedAmount=" + getAllowedAmount() +
            ", primaryInsurerId=" + getPrimaryInsurerId() +
            ", primaryInsurerName='" + getPrimaryInsurerName() + "'" +
            ", primaryInsurerStatus='" + getPrimaryInsurerStatus() + "'" +
            ", primaryInsurerCoveragePercentage=" + getPrimaryInsurerCoveragePercentage() +
            ", primaryInsurerCoverageAmount=" + getPrimaryInsurerCoverageAmount() +
            ", primaryInsurerDeductibleAmount=" + getPrimaryInsurerDeductibleAmount() +
            ", primaryInsurerPayment=" + getPrimaryInsurerPayment() +
            ", primaryInsurerBalanceAmount=" + getPrimaryInsurerBalanceAmount() +
            ", secondaryInsurerId=" + getSecondaryInsurerId() +
            ", secondaryInsurerName='" + getSecondaryInsurerName() + "'" +
            ", secondaryInsurerStatus='" + getSecondaryInsurerStatus() + "'" +
            ", secondaryInsurerCoveragerPercentage=" + getSecondaryInsurerCoveragerPercentage() +
            ", secondaryInsurerCoverageAmount=" + getSecondaryInsurerCoverageAmount() +
            ", secondaryInsurerPayment=" + getSecondaryInsurerPayment() +
            ", secondaryInsurerBalanceAmount=" + getSecondaryInsurerBalanceAmount() +
            ", tertiaryInsurerId=" + getTertiaryInsurerId() +
            ", tertiaryInsurerName='" + getTertiaryInsurerName() + "'" +
            ", tertiaryInsurerStatus='" + getTertiaryInsurerStatus() + "'" +
            ", tertiaryInsurerCoveragePercentage=" + getTertiaryInsurerCoveragePercentage() +
            ", tertiaryInsurerCoverageAmount=" + getTertiaryInsurerCoverageAmount() +
            ", tertiaryInsurerPayment=" + getTertiaryInsurerPayment() +
            ", tertiaryInsurerBalanceAmount=" + getTertiaryInsurerBalanceAmount() +
            ", patientCoinsurancePercentage=" + getPatientCoinsurancePercentage() +
            ", patientCoinsuranceAmount=" + getPatientCoinsuranceAmount() +
            ", totalPatientResponsibilityAmount=" + getTotalPatientResponsibilityAmount() +
            ", patientPayAmount=" + getPatientPayAmount() +
            ", narration='" + getNarration() + "'" +
            ", primaryInvoiceNo='" + getPrimaryInvoiceNo() + "'" +
            ", secondaryInvoiceNo='" + getSecondaryInvoiceNo() + "'" +
            ", tertiaryInvoiceNo='" + getTertiaryInvoiceNo() + "'" +
            ", primaryInvoiceDate='" + getPrimaryInvoiceDate() + "'" +
            ", secondaryInvoiceDate='" + getSecondaryInvoiceDate() + "'" +
            ", tertiaryInvoiceDate='" + getTertiaryInvoiceDate() + "'" +
            ", primaryInvoiceStatus='" + getPrimaryInvoiceStatus() + "'" +
            ", secondaryInvoiceStatus='" + getSecondaryInvoiceStatus() + "'" +
            ", tertiaryInvoiceStatus='" + getTertiaryInvoiceStatus() + "'" +
            ", dos='" + getDos() + "'" +
            ", createdById=" + getCreatedById() +
            ", createdByName='" + getCreatedByName() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", updatedById=" + getUpdatedById() +
            ", updatedByName='" + getUpdatedByName() + "'" +
            ", updatedDate='" + getUpdatedDate() + "'" +
            ", salesOrderMaster=" + getSalesOrderMaster() +
            "}";
    }
}
