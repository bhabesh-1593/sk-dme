package com.sunknowledge.dme.rcm.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesOrderInsuranceDetailsDTO implements Serializable {

    private Long salesOrderInsuranceDetailsId;

    @NotNull(message = "must not be null")
    private Long salesOrderId;

    @NotNull(message = "must not be null")
    private Integer patientId;

    @NotNull(message = "must not be null")
    private Integer primaryInsurerId;

    @NotNull(message = "must not be null")
    private String primaryInsurerName;

    @NotNull(message = "must not be null")
    private Integer primaryInsuranceGroupId;

    @NotNull(message = "must not be null")
    private String primaryInsuranceGroupName;

    private Integer primaryInsurancePlanId;

    private String primaryInsurancePlanType;

    private Integer primaryInsuranceStateId;

    private String primaryInsuranceStateName;

    private String primaryInsurerPolicyNo;

    private String primaryInsurerPatientIdNumber;

    private LocalDate primaryInsurerEffectiveDate;

    private String primaryInsurerVerificationStatus;

    private LocalDate primaryInsurerVerificationDate;

    private Integer primaryInsurerPayPercentage;

    private String primaryBox10d;

    private String primaryBox19;

    private String primaryBox24ia;

    private String primaryBox24ja;

    private String primaryBox24jb;

    private String primaryIncludeBox24Jbstatus;

    private String primaryIncludePayerSalesOrderStatus;

    private String primaryWaitForPreviousPayerBeforeBillingStatus;

    private String primaryPayPercentageStatus;

    private Integer secondaryInsurerId;

    private String secondaryInsurerName;

    @NotNull(message = "must not be null")
    private Integer secondaryInsuranceGroupId;

    @NotNull(message = "must not be null")
    private String secondaryInsuranceGroupName;

    private Integer secondaryInsurancePlanId;

    private String secondaryInsurancePlanType;

    private Integer secondaryInsuranceStateId;

    private String secondaryInsuranceStateName;

    private String secondaryInsurerPolicyNo;

    private String secondaryInsurerPatientIdNumber;

    private LocalDate secondaryInsurerEffectiveDate;

    private String secondaryInsurerVerificationStatus;

    private LocalDate secondaryInsurerVerificationDate;

    private Integer secondaryInsurerPayPercentage;

    private String secondaryBox10d;

    private String secondaryBox19;

    private String secondaryBox24ia;

    private String secondaryBox24ja;

    private String secondaryBox24jb;

    private String secondaryIncludeBox24jbStatus;

    private String secondaryIncludePayerSalesOrderStatus;

    private String secondaryWaitPreviousPayerBefrBillingStatus;

    private String secondaryPayPercentageStatus;

    private Integer tertiaryInsurerId;

    private String tertiaryInsurerName;

    @NotNull(message = "must not be null")
    private Integer tertiaryInsuranceGroupId;

    @NotNull(message = "must not be null")
    private String tertiaryInsuranceGroupName;

    private Integer tertiaryInsurancePlanId;

    private String tertiaryInsurancePlanType;

    private Integer tertiaryInsuranceStateId;

    private String tertiaryInsuranceStateName;

    private String tertiaryInsurerPolicyno;

    private String tertiaryInsurerPatientIdNumber;

    private LocalDate tertiaryInsurerEffectiveDate;

    private String tertiaryInsurerVerificationStatus;

    private LocalDate tertiaryInsurerVerificationDate;

    private Integer tertiaryInsurerPayPercentage;

    private String tertiaryBox10d;

    private String tertiaryBox19;

    private String tertiaryBox24ia;

    private String tertiaryBox24ja;

    private String tertiaryBox24jb;

    private String tertiaryIncludeBox24jbStatus;

    private String tertiaryIncludePayerInSalesOrderStatus;

    private String tertiaryWaitPreviousPayerBeforeBillingStatus;

    private String tertiaryPayPercentage0Status;

    private String insuranceVerificationStatus;

    private String coverageVerificationStatus;

    private String excludeFromEligibilityCheckStatus;

    private String patientPayPercentage;

    private String patientIncludeThisPayorInSalesOrderStatus;

    private String patientWaitForPreviousPayerBeforeBillingStatus;

    private LocalDate workersCompDateOfOnset;

    private String workersCompInjuryRelatedEmploymentStatus;

    private String workersCompInjuryRelatedAutoAccidentStatus;

    private Integer workersCompAutoAccidentStateId;

    private String workersCompInjuryRelatedToOtherAccidentStatus;

    private String eclaimsAttachmentStatus;

    private Integer attachmentNumber;

    private String typeCode;

    private String transactionCode;

    private String claimsNoteType;

    private String claimsNote;

    private String salesOrderNo;

    private String status;

    private Integer createdById;

    private String createdByName;

    private ZonedDateTime createdDate;

    private Integer updatedById;

    private String updatedByName;

    private ZonedDateTime updatedDate;

    private SalesOrderMasterDTO salesOrderMaster;

    public Long getSalesOrderInsuranceDetailsId() {
        return salesOrderInsuranceDetailsId;
    }

    public void setSalesOrderInsuranceDetailsId(Long salesOrderInsuranceDetailsId) {
        this.salesOrderInsuranceDetailsId = salesOrderInsuranceDetailsId;
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

    public Integer getPrimaryInsuranceGroupId() {
        return primaryInsuranceGroupId;
    }

    public void setPrimaryInsuranceGroupId(Integer primaryInsuranceGroupId) {
        this.primaryInsuranceGroupId = primaryInsuranceGroupId;
    }

    public String getPrimaryInsuranceGroupName() {
        return primaryInsuranceGroupName;
    }

    public void setPrimaryInsuranceGroupName(String primaryInsuranceGroupName) {
        this.primaryInsuranceGroupName = primaryInsuranceGroupName;
    }

    public Integer getPrimaryInsurancePlanId() {
        return primaryInsurancePlanId;
    }

    public void setPrimaryInsurancePlanId(Integer primaryInsurancePlanId) {
        this.primaryInsurancePlanId = primaryInsurancePlanId;
    }

    public String getPrimaryInsurancePlanType() {
        return primaryInsurancePlanType;
    }

    public void setPrimaryInsurancePlanType(String primaryInsurancePlanType) {
        this.primaryInsurancePlanType = primaryInsurancePlanType;
    }

    public Integer getPrimaryInsuranceStateId() {
        return primaryInsuranceStateId;
    }

    public void setPrimaryInsuranceStateId(Integer primaryInsuranceStateId) {
        this.primaryInsuranceStateId = primaryInsuranceStateId;
    }

    public String getPrimaryInsuranceStateName() {
        return primaryInsuranceStateName;
    }

    public void setPrimaryInsuranceStateName(String primaryInsuranceStateName) {
        this.primaryInsuranceStateName = primaryInsuranceStateName;
    }

    public String getPrimaryInsurerPolicyNo() {
        return primaryInsurerPolicyNo;
    }

    public void setPrimaryInsurerPolicyNo(String primaryInsurerPolicyNo) {
        this.primaryInsurerPolicyNo = primaryInsurerPolicyNo;
    }

    public String getPrimaryInsurerPatientIdNumber() {
        return primaryInsurerPatientIdNumber;
    }

    public void setPrimaryInsurerPatientIdNumber(String primaryInsurerPatientIdNumber) {
        this.primaryInsurerPatientIdNumber = primaryInsurerPatientIdNumber;
    }

    public LocalDate getPrimaryInsurerEffectiveDate() {
        return primaryInsurerEffectiveDate;
    }

    public void setPrimaryInsurerEffectiveDate(LocalDate primaryInsurerEffectiveDate) {
        this.primaryInsurerEffectiveDate = primaryInsurerEffectiveDate;
    }

    public String getPrimaryInsurerVerificationStatus() {
        return primaryInsurerVerificationStatus;
    }

    public void setPrimaryInsurerVerificationStatus(String primaryInsurerVerificationStatus) {
        this.primaryInsurerVerificationStatus = primaryInsurerVerificationStatus;
    }

    public LocalDate getPrimaryInsurerVerificationDate() {
        return primaryInsurerVerificationDate;
    }

    public void setPrimaryInsurerVerificationDate(LocalDate primaryInsurerVerificationDate) {
        this.primaryInsurerVerificationDate = primaryInsurerVerificationDate;
    }

    public Integer getPrimaryInsurerPayPercentage() {
        return primaryInsurerPayPercentage;
    }

    public void setPrimaryInsurerPayPercentage(Integer primaryInsurerPayPercentage) {
        this.primaryInsurerPayPercentage = primaryInsurerPayPercentage;
    }

    public String getPrimaryBox10d() {
        return primaryBox10d;
    }

    public void setPrimaryBox10d(String primaryBox10d) {
        this.primaryBox10d = primaryBox10d;
    }

    public String getPrimaryBox19() {
        return primaryBox19;
    }

    public void setPrimaryBox19(String primaryBox19) {
        this.primaryBox19 = primaryBox19;
    }

    public String getPrimaryBox24ia() {
        return primaryBox24ia;
    }

    public void setPrimaryBox24ia(String primaryBox24ia) {
        this.primaryBox24ia = primaryBox24ia;
    }

    public String getPrimaryBox24ja() {
        return primaryBox24ja;
    }

    public void setPrimaryBox24ja(String primaryBox24ja) {
        this.primaryBox24ja = primaryBox24ja;
    }

    public String getPrimaryBox24jb() {
        return primaryBox24jb;
    }

    public void setPrimaryBox24jb(String primaryBox24jb) {
        this.primaryBox24jb = primaryBox24jb;
    }

    public String getPrimaryIncludeBox24Jbstatus() {
        return primaryIncludeBox24Jbstatus;
    }

    public void setPrimaryIncludeBox24Jbstatus(String primaryIncludeBox24Jbstatus) {
        this.primaryIncludeBox24Jbstatus = primaryIncludeBox24Jbstatus;
    }

    public String getPrimaryIncludePayerSalesOrderStatus() {
        return primaryIncludePayerSalesOrderStatus;
    }

    public void setPrimaryIncludePayerSalesOrderStatus(String primaryIncludePayerSalesOrderStatus) {
        this.primaryIncludePayerSalesOrderStatus = primaryIncludePayerSalesOrderStatus;
    }

    public String getPrimaryWaitForPreviousPayerBeforeBillingStatus() {
        return primaryWaitForPreviousPayerBeforeBillingStatus;
    }

    public void setPrimaryWaitForPreviousPayerBeforeBillingStatus(String primaryWaitForPreviousPayerBeforeBillingStatus) {
        this.primaryWaitForPreviousPayerBeforeBillingStatus = primaryWaitForPreviousPayerBeforeBillingStatus;
    }

    public String getPrimaryPayPercentageStatus() {
        return primaryPayPercentageStatus;
    }

    public void setPrimaryPayPercentageStatus(String primaryPayPercentageStatus) {
        this.primaryPayPercentageStatus = primaryPayPercentageStatus;
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

    public Integer getSecondaryInsuranceGroupId() {
        return secondaryInsuranceGroupId;
    }

    public void setSecondaryInsuranceGroupId(Integer secondaryInsuranceGroupId) {
        this.secondaryInsuranceGroupId = secondaryInsuranceGroupId;
    }

    public String getSecondaryInsuranceGroupName() {
        return secondaryInsuranceGroupName;
    }

    public void setSecondaryInsuranceGroupName(String secondaryInsuranceGroupName) {
        this.secondaryInsuranceGroupName = secondaryInsuranceGroupName;
    }

    public Integer getSecondaryInsurancePlanId() {
        return secondaryInsurancePlanId;
    }

    public void setSecondaryInsurancePlanId(Integer secondaryInsurancePlanId) {
        this.secondaryInsurancePlanId = secondaryInsurancePlanId;
    }

    public String getSecondaryInsurancePlanType() {
        return secondaryInsurancePlanType;
    }

    public void setSecondaryInsurancePlanType(String secondaryInsurancePlanType) {
        this.secondaryInsurancePlanType = secondaryInsurancePlanType;
    }

    public Integer getSecondaryInsuranceStateId() {
        return secondaryInsuranceStateId;
    }

    public void setSecondaryInsuranceStateId(Integer secondaryInsuranceStateId) {
        this.secondaryInsuranceStateId = secondaryInsuranceStateId;
    }

    public String getSecondaryInsuranceStateName() {
        return secondaryInsuranceStateName;
    }

    public void setSecondaryInsuranceStateName(String secondaryInsuranceStateName) {
        this.secondaryInsuranceStateName = secondaryInsuranceStateName;
    }

    public String getSecondaryInsurerPolicyNo() {
        return secondaryInsurerPolicyNo;
    }

    public void setSecondaryInsurerPolicyNo(String secondaryInsurerPolicyNo) {
        this.secondaryInsurerPolicyNo = secondaryInsurerPolicyNo;
    }

    public String getSecondaryInsurerPatientIdNumber() {
        return secondaryInsurerPatientIdNumber;
    }

    public void setSecondaryInsurerPatientIdNumber(String secondaryInsurerPatientIdNumber) {
        this.secondaryInsurerPatientIdNumber = secondaryInsurerPatientIdNumber;
    }

    public LocalDate getSecondaryInsurerEffectiveDate() {
        return secondaryInsurerEffectiveDate;
    }

    public void setSecondaryInsurerEffectiveDate(LocalDate secondaryInsurerEffectiveDate) {
        this.secondaryInsurerEffectiveDate = secondaryInsurerEffectiveDate;
    }

    public String getSecondaryInsurerVerificationStatus() {
        return secondaryInsurerVerificationStatus;
    }

    public void setSecondaryInsurerVerificationStatus(String secondaryInsurerVerificationStatus) {
        this.secondaryInsurerVerificationStatus = secondaryInsurerVerificationStatus;
    }

    public LocalDate getSecondaryInsurerVerificationDate() {
        return secondaryInsurerVerificationDate;
    }

    public void setSecondaryInsurerVerificationDate(LocalDate secondaryInsurerVerificationDate) {
        this.secondaryInsurerVerificationDate = secondaryInsurerVerificationDate;
    }

    public Integer getSecondaryInsurerPayPercentage() {
        return secondaryInsurerPayPercentage;
    }

    public void setSecondaryInsurerPayPercentage(Integer secondaryInsurerPayPercentage) {
        this.secondaryInsurerPayPercentage = secondaryInsurerPayPercentage;
    }

    public String getSecondaryBox10d() {
        return secondaryBox10d;
    }

    public void setSecondaryBox10d(String secondaryBox10d) {
        this.secondaryBox10d = secondaryBox10d;
    }

    public String getSecondaryBox19() {
        return secondaryBox19;
    }

    public void setSecondaryBox19(String secondaryBox19) {
        this.secondaryBox19 = secondaryBox19;
    }

    public String getSecondaryBox24ia() {
        return secondaryBox24ia;
    }

    public void setSecondaryBox24ia(String secondaryBox24ia) {
        this.secondaryBox24ia = secondaryBox24ia;
    }

    public String getSecondaryBox24ja() {
        return secondaryBox24ja;
    }

    public void setSecondaryBox24ja(String secondaryBox24ja) {
        this.secondaryBox24ja = secondaryBox24ja;
    }

    public String getSecondaryBox24jb() {
        return secondaryBox24jb;
    }

    public void setSecondaryBox24jb(String secondaryBox24jb) {
        this.secondaryBox24jb = secondaryBox24jb;
    }

    public String getSecondaryIncludeBox24jbStatus() {
        return secondaryIncludeBox24jbStatus;
    }

    public void setSecondaryIncludeBox24jbStatus(String secondaryIncludeBox24jbStatus) {
        this.secondaryIncludeBox24jbStatus = secondaryIncludeBox24jbStatus;
    }

    public String getSecondaryIncludePayerSalesOrderStatus() {
        return secondaryIncludePayerSalesOrderStatus;
    }

    public void setSecondaryIncludePayerSalesOrderStatus(String secondaryIncludePayerSalesOrderStatus) {
        this.secondaryIncludePayerSalesOrderStatus = secondaryIncludePayerSalesOrderStatus;
    }

    public String getSecondaryWaitPreviousPayerBefrBillingStatus() {
        return secondaryWaitPreviousPayerBefrBillingStatus;
    }

    public void setSecondaryWaitPreviousPayerBefrBillingStatus(String secondaryWaitPreviousPayerBefrBillingStatus) {
        this.secondaryWaitPreviousPayerBefrBillingStatus = secondaryWaitPreviousPayerBefrBillingStatus;
    }

    public String getSecondaryPayPercentageStatus() {
        return secondaryPayPercentageStatus;
    }

    public void setSecondaryPayPercentageStatus(String secondaryPayPercentageStatus) {
        this.secondaryPayPercentageStatus = secondaryPayPercentageStatus;
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

    public Integer getTertiaryInsuranceGroupId() {
        return tertiaryInsuranceGroupId;
    }

    public void setTertiaryInsuranceGroupId(Integer tertiaryInsuranceGroupId) {
        this.tertiaryInsuranceGroupId = tertiaryInsuranceGroupId;
    }

    public String getTertiaryInsuranceGroupName() {
        return tertiaryInsuranceGroupName;
    }

    public void setTertiaryInsuranceGroupName(String tertiaryInsuranceGroupName) {
        this.tertiaryInsuranceGroupName = tertiaryInsuranceGroupName;
    }

    public Integer getTertiaryInsurancePlanId() {
        return tertiaryInsurancePlanId;
    }

    public void setTertiaryInsurancePlanId(Integer tertiaryInsurancePlanId) {
        this.tertiaryInsurancePlanId = tertiaryInsurancePlanId;
    }

    public String getTertiaryInsurancePlanType() {
        return tertiaryInsurancePlanType;
    }

    public void setTertiaryInsurancePlanType(String tertiaryInsurancePlanType) {
        this.tertiaryInsurancePlanType = tertiaryInsurancePlanType;
    }

    public Integer getTertiaryInsuranceStateId() {
        return tertiaryInsuranceStateId;
    }

    public void setTertiaryInsuranceStateId(Integer tertiaryInsuranceStateId) {
        this.tertiaryInsuranceStateId = tertiaryInsuranceStateId;
    }

    public String getTertiaryInsuranceStateName() {
        return tertiaryInsuranceStateName;
    }

    public void setTertiaryInsuranceStateName(String tertiaryInsuranceStateName) {
        this.tertiaryInsuranceStateName = tertiaryInsuranceStateName;
    }

    public String getTertiaryInsurerPolicyno() {
        return tertiaryInsurerPolicyno;
    }

    public void setTertiaryInsurerPolicyno(String tertiaryInsurerPolicyno) {
        this.tertiaryInsurerPolicyno = tertiaryInsurerPolicyno;
    }

    public String getTertiaryInsurerPatientIdNumber() {
        return tertiaryInsurerPatientIdNumber;
    }

    public void setTertiaryInsurerPatientIdNumber(String tertiaryInsurerPatientIdNumber) {
        this.tertiaryInsurerPatientIdNumber = tertiaryInsurerPatientIdNumber;
    }

    public LocalDate getTertiaryInsurerEffectiveDate() {
        return tertiaryInsurerEffectiveDate;
    }

    public void setTertiaryInsurerEffectiveDate(LocalDate tertiaryInsurerEffectiveDate) {
        this.tertiaryInsurerEffectiveDate = tertiaryInsurerEffectiveDate;
    }

    public String getTertiaryInsurerVerificationStatus() {
        return tertiaryInsurerVerificationStatus;
    }

    public void setTertiaryInsurerVerificationStatus(String tertiaryInsurerVerificationStatus) {
        this.tertiaryInsurerVerificationStatus = tertiaryInsurerVerificationStatus;
    }

    public LocalDate getTertiaryInsurerVerificationDate() {
        return tertiaryInsurerVerificationDate;
    }

    public void setTertiaryInsurerVerificationDate(LocalDate tertiaryInsurerVerificationDate) {
        this.tertiaryInsurerVerificationDate = tertiaryInsurerVerificationDate;
    }

    public Integer getTertiaryInsurerPayPercentage() {
        return tertiaryInsurerPayPercentage;
    }

    public void setTertiaryInsurerPayPercentage(Integer tertiaryInsurerPayPercentage) {
        this.tertiaryInsurerPayPercentage = tertiaryInsurerPayPercentage;
    }

    public String getTertiaryBox10d() {
        return tertiaryBox10d;
    }

    public void setTertiaryBox10d(String tertiaryBox10d) {
        this.tertiaryBox10d = tertiaryBox10d;
    }

    public String getTertiaryBox19() {
        return tertiaryBox19;
    }

    public void setTertiaryBox19(String tertiaryBox19) {
        this.tertiaryBox19 = tertiaryBox19;
    }

    public String getTertiaryBox24ia() {
        return tertiaryBox24ia;
    }

    public void setTertiaryBox24ia(String tertiaryBox24ia) {
        this.tertiaryBox24ia = tertiaryBox24ia;
    }

    public String getTertiaryBox24ja() {
        return tertiaryBox24ja;
    }

    public void setTertiaryBox24ja(String tertiaryBox24ja) {
        this.tertiaryBox24ja = tertiaryBox24ja;
    }

    public String getTertiaryBox24jb() {
        return tertiaryBox24jb;
    }

    public void setTertiaryBox24jb(String tertiaryBox24jb) {
        this.tertiaryBox24jb = tertiaryBox24jb;
    }

    public String getTertiaryIncludeBox24jbStatus() {
        return tertiaryIncludeBox24jbStatus;
    }

    public void setTertiaryIncludeBox24jbStatus(String tertiaryIncludeBox24jbStatus) {
        this.tertiaryIncludeBox24jbStatus = tertiaryIncludeBox24jbStatus;
    }

    public String getTertiaryIncludePayerInSalesOrderStatus() {
        return tertiaryIncludePayerInSalesOrderStatus;
    }

    public void setTertiaryIncludePayerInSalesOrderStatus(String tertiaryIncludePayerInSalesOrderStatus) {
        this.tertiaryIncludePayerInSalesOrderStatus = tertiaryIncludePayerInSalesOrderStatus;
    }

    public String getTertiaryWaitPreviousPayerBeforeBillingStatus() {
        return tertiaryWaitPreviousPayerBeforeBillingStatus;
    }

    public void setTertiaryWaitPreviousPayerBeforeBillingStatus(String tertiaryWaitPreviousPayerBeforeBillingStatus) {
        this.tertiaryWaitPreviousPayerBeforeBillingStatus = tertiaryWaitPreviousPayerBeforeBillingStatus;
    }

    public String getTertiaryPayPercentage0Status() {
        return tertiaryPayPercentage0Status;
    }

    public void setTertiaryPayPercentage0Status(String tertiaryPayPercentage0Status) {
        this.tertiaryPayPercentage0Status = tertiaryPayPercentage0Status;
    }

    public String getInsuranceVerificationStatus() {
        return insuranceVerificationStatus;
    }

    public void setInsuranceVerificationStatus(String insuranceVerificationStatus) {
        this.insuranceVerificationStatus = insuranceVerificationStatus;
    }

    public String getCoverageVerificationStatus() {
        return coverageVerificationStatus;
    }

    public void setCoverageVerificationStatus(String coverageVerificationStatus) {
        this.coverageVerificationStatus = coverageVerificationStatus;
    }

    public String getExcludeFromEligibilityCheckStatus() {
        return excludeFromEligibilityCheckStatus;
    }

    public void setExcludeFromEligibilityCheckStatus(String excludeFromEligibilityCheckStatus) {
        this.excludeFromEligibilityCheckStatus = excludeFromEligibilityCheckStatus;
    }

    public String getPatientPayPercentage() {
        return patientPayPercentage;
    }

    public void setPatientPayPercentage(String patientPayPercentage) {
        this.patientPayPercentage = patientPayPercentage;
    }

    public String getPatientIncludeThisPayorInSalesOrderStatus() {
        return patientIncludeThisPayorInSalesOrderStatus;
    }

    public void setPatientIncludeThisPayorInSalesOrderStatus(String patientIncludeThisPayorInSalesOrderStatus) {
        this.patientIncludeThisPayorInSalesOrderStatus = patientIncludeThisPayorInSalesOrderStatus;
    }

    public String getPatientWaitForPreviousPayerBeforeBillingStatus() {
        return patientWaitForPreviousPayerBeforeBillingStatus;
    }

    public void setPatientWaitForPreviousPayerBeforeBillingStatus(String patientWaitForPreviousPayerBeforeBillingStatus) {
        this.patientWaitForPreviousPayerBeforeBillingStatus = patientWaitForPreviousPayerBeforeBillingStatus;
    }

    public LocalDate getWorkersCompDateOfOnset() {
        return workersCompDateOfOnset;
    }

    public void setWorkersCompDateOfOnset(LocalDate workersCompDateOfOnset) {
        this.workersCompDateOfOnset = workersCompDateOfOnset;
    }

    public String getWorkersCompInjuryRelatedEmploymentStatus() {
        return workersCompInjuryRelatedEmploymentStatus;
    }

    public void setWorkersCompInjuryRelatedEmploymentStatus(String workersCompInjuryRelatedEmploymentStatus) {
        this.workersCompInjuryRelatedEmploymentStatus = workersCompInjuryRelatedEmploymentStatus;
    }

    public String getWorkersCompInjuryRelatedAutoAccidentStatus() {
        return workersCompInjuryRelatedAutoAccidentStatus;
    }

    public void setWorkersCompInjuryRelatedAutoAccidentStatus(String workersCompInjuryRelatedAutoAccidentStatus) {
        this.workersCompInjuryRelatedAutoAccidentStatus = workersCompInjuryRelatedAutoAccidentStatus;
    }

    public Integer getWorkersCompAutoAccidentStateId() {
        return workersCompAutoAccidentStateId;
    }

    public void setWorkersCompAutoAccidentStateId(Integer workersCompAutoAccidentStateId) {
        this.workersCompAutoAccidentStateId = workersCompAutoAccidentStateId;
    }

    public String getWorkersCompInjuryRelatedToOtherAccidentStatus() {
        return workersCompInjuryRelatedToOtherAccidentStatus;
    }

    public void setWorkersCompInjuryRelatedToOtherAccidentStatus(String workersCompInjuryRelatedToOtherAccidentStatus) {
        this.workersCompInjuryRelatedToOtherAccidentStatus = workersCompInjuryRelatedToOtherAccidentStatus;
    }

    public String getEclaimsAttachmentStatus() {
        return eclaimsAttachmentStatus;
    }

    public void setEclaimsAttachmentStatus(String eclaimsAttachmentStatus) {
        this.eclaimsAttachmentStatus = eclaimsAttachmentStatus;
    }

    public Integer getAttachmentNumber() {
        return attachmentNumber;
    }

    public void setAttachmentNumber(Integer attachmentNumber) {
        this.attachmentNumber = attachmentNumber;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getClaimsNoteType() {
        return claimsNoteType;
    }

    public void setClaimsNoteType(String claimsNoteType) {
        this.claimsNoteType = claimsNoteType;
    }

    public String getClaimsNote() {
        return claimsNote;
    }

    public void setClaimsNote(String claimsNote) {
        this.claimsNote = claimsNote;
    }

    public String getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
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
        if (!(o instanceof SalesOrderInsuranceDetailsDTO)) {
            return false;
        }

        SalesOrderInsuranceDetailsDTO salesOrderInsuranceDetailsDTO = (SalesOrderInsuranceDetailsDTO) o;
        if (this.salesOrderInsuranceDetailsId == null) {
            return false;
        }
        return Objects.equals(this.salesOrderInsuranceDetailsId, salesOrderInsuranceDetailsDTO.salesOrderInsuranceDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.salesOrderInsuranceDetailsId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderInsuranceDetailsDTO{" +
            "salesOrderInsuranceDetailsId=" + getSalesOrderInsuranceDetailsId() +
            ", salesOrderId=" + getSalesOrderId() +
            ", patientId=" + getPatientId() +
            ", primaryInsurerId=" + getPrimaryInsurerId() +
            ", primaryInsurerName='" + getPrimaryInsurerName() + "'" +
            ", primaryInsuranceGroupId=" + getPrimaryInsuranceGroupId() +
            ", primaryInsuranceGroupName='" + getPrimaryInsuranceGroupName() + "'" +
            ", primaryInsurancePlanId=" + getPrimaryInsurancePlanId() +
            ", primaryInsurancePlanType='" + getPrimaryInsurancePlanType() + "'" +
            ", primaryInsuranceStateId=" + getPrimaryInsuranceStateId() +
            ", primaryInsuranceStateName='" + getPrimaryInsuranceStateName() + "'" +
            ", primaryInsurerPolicyNo='" + getPrimaryInsurerPolicyNo() + "'" +
            ", primaryInsurerPatientIdNumber='" + getPrimaryInsurerPatientIdNumber() + "'" +
            ", primaryInsurerEffectiveDate='" + getPrimaryInsurerEffectiveDate() + "'" +
            ", primaryInsurerVerificationStatus='" + getPrimaryInsurerVerificationStatus() + "'" +
            ", primaryInsurerVerificationDate='" + getPrimaryInsurerVerificationDate() + "'" +
            ", primaryInsurerPayPercentage=" + getPrimaryInsurerPayPercentage() +
            ", primaryBox10d='" + getPrimaryBox10d() + "'" +
            ", primaryBox19='" + getPrimaryBox19() + "'" +
            ", primaryBox24ia='" + getPrimaryBox24ia() + "'" +
            ", primaryBox24ja='" + getPrimaryBox24ja() + "'" +
            ", primaryBox24jb='" + getPrimaryBox24jb() + "'" +
            ", primaryIncludeBox24Jbstatus='" + getPrimaryIncludeBox24Jbstatus() + "'" +
            ", primaryIncludePayerSalesOrderStatus='" + getPrimaryIncludePayerSalesOrderStatus() + "'" +
            ", primaryWaitForPreviousPayerBeforeBillingStatus='" + getPrimaryWaitForPreviousPayerBeforeBillingStatus() + "'" +
            ", primaryPayPercentageStatus='" + getPrimaryPayPercentageStatus() + "'" +
            ", secondaryInsurerId=" + getSecondaryInsurerId() +
            ", secondaryInsurerName='" + getSecondaryInsurerName() + "'" +
            ", secondaryInsuranceGroupId=" + getSecondaryInsuranceGroupId() +
            ", secondaryInsuranceGroupName='" + getSecondaryInsuranceGroupName() + "'" +
            ", secondaryInsurancePlanId=" + getSecondaryInsurancePlanId() +
            ", secondaryInsurancePlanType='" + getSecondaryInsurancePlanType() + "'" +
            ", secondaryInsuranceStateId=" + getSecondaryInsuranceStateId() +
            ", secondaryInsuranceStateName='" + getSecondaryInsuranceStateName() + "'" +
            ", secondaryInsurerPolicyNo='" + getSecondaryInsurerPolicyNo() + "'" +
            ", secondaryInsurerPatientIdNumber='" + getSecondaryInsurerPatientIdNumber() + "'" +
            ", secondaryInsurerEffectiveDate='" + getSecondaryInsurerEffectiveDate() + "'" +
            ", secondaryInsurerVerificationStatus='" + getSecondaryInsurerVerificationStatus() + "'" +
            ", secondaryInsurerVerificationDate='" + getSecondaryInsurerVerificationDate() + "'" +
            ", secondaryInsurerPayPercentage=" + getSecondaryInsurerPayPercentage() +
            ", secondaryBox10d='" + getSecondaryBox10d() + "'" +
            ", secondaryBox19='" + getSecondaryBox19() + "'" +
            ", secondaryBox24ia='" + getSecondaryBox24ia() + "'" +
            ", secondaryBox24ja='" + getSecondaryBox24ja() + "'" +
            ", secondaryBox24jb='" + getSecondaryBox24jb() + "'" +
            ", secondaryIncludeBox24jbStatus='" + getSecondaryIncludeBox24jbStatus() + "'" +
            ", secondaryIncludePayerSalesOrderStatus='" + getSecondaryIncludePayerSalesOrderStatus() + "'" +
            ", secondaryWaitPreviousPayerBefrBillingStatus='" + getSecondaryWaitPreviousPayerBefrBillingStatus() + "'" +
            ", secondaryPayPercentageStatus='" + getSecondaryPayPercentageStatus() + "'" +
            ", tertiaryInsurerId=" + getTertiaryInsurerId() +
            ", tertiaryInsurerName='" + getTertiaryInsurerName() + "'" +
            ", tertiaryInsuranceGroupId=" + getTertiaryInsuranceGroupId() +
            ", tertiaryInsuranceGroupName='" + getTertiaryInsuranceGroupName() + "'" +
            ", tertiaryInsurancePlanId=" + getTertiaryInsurancePlanId() +
            ", tertiaryInsurancePlanType='" + getTertiaryInsurancePlanType() + "'" +
            ", tertiaryInsuranceStateId=" + getTertiaryInsuranceStateId() +
            ", tertiaryInsuranceStateName='" + getTertiaryInsuranceStateName() + "'" +
            ", tertiaryInsurerPolicyno='" + getTertiaryInsurerPolicyno() + "'" +
            ", tertiaryInsurerPatientIdNumber='" + getTertiaryInsurerPatientIdNumber() + "'" +
            ", tertiaryInsurerEffectiveDate='" + getTertiaryInsurerEffectiveDate() + "'" +
            ", tertiaryInsurerVerificationStatus='" + getTertiaryInsurerVerificationStatus() + "'" +
            ", tertiaryInsurerVerificationDate='" + getTertiaryInsurerVerificationDate() + "'" +
            ", tertiaryInsurerPayPercentage=" + getTertiaryInsurerPayPercentage() +
            ", tertiaryBox10d='" + getTertiaryBox10d() + "'" +
            ", tertiaryBox19='" + getTertiaryBox19() + "'" +
            ", tertiaryBox24ia='" + getTertiaryBox24ia() + "'" +
            ", tertiaryBox24ja='" + getTertiaryBox24ja() + "'" +
            ", tertiaryBox24jb='" + getTertiaryBox24jb() + "'" +
            ", tertiaryIncludeBox24jbStatus='" + getTertiaryIncludeBox24jbStatus() + "'" +
            ", tertiaryIncludePayerInSalesOrderStatus='" + getTertiaryIncludePayerInSalesOrderStatus() + "'" +
            ", tertiaryWaitPreviousPayerBeforeBillingStatus='" + getTertiaryWaitPreviousPayerBeforeBillingStatus() + "'" +
            ", tertiaryPayPercentage0Status='" + getTertiaryPayPercentage0Status() + "'" +
            ", insuranceVerificationStatus='" + getInsuranceVerificationStatus() + "'" +
            ", coverageVerificationStatus='" + getCoverageVerificationStatus() + "'" +
            ", excludeFromEligibilityCheckStatus='" + getExcludeFromEligibilityCheckStatus() + "'" +
            ", patientPayPercentage='" + getPatientPayPercentage() + "'" +
            ", patientIncludeThisPayorInSalesOrderStatus='" + getPatientIncludeThisPayorInSalesOrderStatus() + "'" +
            ", patientWaitForPreviousPayerBeforeBillingStatus='" + getPatientWaitForPreviousPayerBeforeBillingStatus() + "'" +
            ", workersCompDateOfOnset='" + getWorkersCompDateOfOnset() + "'" +
            ", workersCompInjuryRelatedEmploymentStatus='" + getWorkersCompInjuryRelatedEmploymentStatus() + "'" +
            ", workersCompInjuryRelatedAutoAccidentStatus='" + getWorkersCompInjuryRelatedAutoAccidentStatus() + "'" +
            ", workersCompAutoAccidentStateId=" + getWorkersCompAutoAccidentStateId() +
            ", workersCompInjuryRelatedToOtherAccidentStatus='" + getWorkersCompInjuryRelatedToOtherAccidentStatus() + "'" +
            ", eclaimsAttachmentStatus='" + getEclaimsAttachmentStatus() + "'" +
            ", attachmentNumber=" + getAttachmentNumber() +
            ", typeCode='" + getTypeCode() + "'" +
            ", transactionCode='" + getTransactionCode() + "'" +
            ", claimsNoteType='" + getClaimsNoteType() + "'" +
            ", claimsNote='" + getClaimsNote() + "'" +
            ", salesOrderNo='" + getSalesOrderNo() + "'" +
            ", status='" + getStatus() + "'" +
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
