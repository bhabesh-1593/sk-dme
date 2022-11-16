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
 * A SalesOrderInsuranceDetails.
 */

@Table("t_sales_order_insurance_details")
public class SalesOrderInsuranceDetails implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Column("id")
//    private Long id;

    @Id
    @NotNull(message = "must not be null")
    @Column("sales_order_insurance_details_id")
    private Integer salesOrderInsuranceDetailsId;

    @NotNull(message = "must not be null")
    @Column("sales_order_id")
    private Integer salesOrderId;

    @NotNull(message = "must not be null")
    @Column("patient_id")
    private Integer patientId;

    @NotNull(message = "must not be null")
    @Column("primary_insurer_id")
    private Integer primaryInsurerId;

    @NotNull(message = "must not be null")
    @Column("primary_insurer_name")
    private String primaryInsurerName;

    @Column("primary_insurance_group_id")
    private Integer primaryInsuranceGroupId;

    @Column("primary_insurance_group_name")
    private String primaryInsuranceGroupName;

    @Column("primary_insurance_plan_id")
    private Integer primaryInsurancePlanId;

    @Column("primary_insurance_plan_type")
    private String primaryInsurancePlanType;

    @Column("primary_insurance_state_id")
    private Integer primaryInsuranceStateId;

    @Column("primary_insurance_state_name")
    private String primaryInsuranceStateName;

    @Column("primary_insurer_policy_no")
    private String primaryInsurerPolicyNo;

    @Column("primary_insurer_patient_id_number")
    private String primaryInsurerPatientIdNumber;

    @Column("primary_insurer_effective_date")
    private LocalDate primaryInsurerEffectiveDate;

    @Column("primary_insurer_verification_status")
    private String primaryInsurerVerificationStatus;

    @Column("primary_insurer_verification_date")
    private LocalDate primaryInsurerVerificationDate;

    @Column("primary_insurer_pay_percentage")
    private Integer primaryInsurerPayPercentage;

    @Column("primary_box_10d")
    private String primaryBox10d;

    @Column("primary_box_19")
    private String primaryBox19;

    @Column("primary_box_24ia")
    private String primaryBox24ia;

    @Column("primary_box_24ja")
    private String primaryBox24ja;

    @Column("primary_box_24jb")
    private String primaryBox24jb;

    @Column("primary_include_box24_jbstatus")
    private String primaryIncludeBox24Jbstatus;

    @Column("primary_include_payer_sales_order_status")
    private String primaryIncludePayerSalesOrderStatus;

    @Column("primary_wait_for_previous_payer_before_billing_status")
    private String primaryWaitForPreviousPayerBeforeBillingStatus;

    @Column("primary_pay_percentage_status")
    private String primaryPayPercentageStatus;

    @Column("secondary_insurer_id")
    private Integer secondaryInsurerId;

    @Column("secondary_insurer_name")
    private String secondaryInsurerName;

    @Column("secondary_insurance_group_id")
    private Integer secondaryInsuranceGroupId;

    @Column("secondary_insurance_group_name")
    private String secondaryInsuranceGroupName;

    @Column("secondary_insurance_plan_id")
    private Integer secondaryInsurancePlanId;

    @Column("secondary_insurance_plan_type")
    private String secondaryInsurancePlanType;

    @Column("secondary_insurance_state_id")
    private Integer secondaryInsuranceStateId;

    @Column("secondary_insurance_state_name")
    private String secondaryInsuranceStateName;

    @Column("secondary_insurer_policy_no")
    private String secondaryInsurerPolicyNo;

    @Column("secondary_insurer_patient_id_number")
    private String secondaryInsurerPatientIdNumber;

    @Column("secondary_insurer_effective_date")
    private LocalDate secondaryInsurerEffectiveDate;

    @Column("secondary_insurer_verification_status")
    private String secondaryInsurerVerificationStatus;

    @Column("secondary_insurer_verification_date")
    private LocalDate secondaryInsurerVerificationDate;

    @Column("secondary_insurer_pay_percentage")
    private Integer secondaryInsurerPayPercentage;

    @Column("secondary_box_10d")
    private String secondaryBox10d;

    @Column("secondary_box_19")
    private String secondaryBox19;

    @Column("secondary_box_24ia")
    private String secondaryBox24ia;

    @Column("secondary_box_24ja")
    private String secondaryBox24ja;

    @Column("secondary_box_24jb")
    private String secondaryBox24jb;

    @Column("secondary_include_box_24jb_status")
    private String secondaryIncludeBox24jbStatus;

    @Column("secondary_include_payer_sales_order_status")
    private String secondaryIncludePayerSalesOrderStatus;

    @Column("secondary_wait_previous_payer_befr_billing_status")
    private String secondaryWaitPreviousPayerBefrBillingStatus;

    @Column("secondary_pay_percentage_status")
    private String secondaryPayPercentageStatus;

    @Column("tertiary_insurer_id")
    private Integer tertiaryInsurerId;

    @Column("tertiary_insurer_name")
    private String tertiaryInsurerName;

    @Column("tertiary_insurance_group_id")
    private Integer tertiaryInsuranceGroupId;

    @Column("tertiary_insurance_group_name")
    private String tertiaryInsuranceGroupName;

    @Column("tertiary_insurance_plan_id")
    private Integer tertiaryInsurancePlanId;

    @Column("tertiary_insurance_plan_type")
    private String tertiaryInsurancePlanType;

    @Column("tertiary_insurance_state_id")
    private Integer tertiaryInsuranceStateId;

    @Column("tertiary_insurance_state_name")
    private String tertiaryInsuranceStateName;

    @Column("tertiary_insurer_policyno")
    private String tertiaryInsurerPolicyno;

    @Column("tertiary_insurer_patient_id_number")
    private String tertiaryInsurerPatientIdNumber;

    @Column("tertiary_insurer_effective_date")
    private LocalDate tertiaryInsurerEffectiveDate;

    @Column("tertiary_insurer_verification_status")
    private String tertiaryInsurerVerificationStatus;

    @Column("tertiary_insurer_verification_date")
    private LocalDate tertiaryInsurerVerificationDate;

    @Column("tertiary_insurer_pay_percentage")
    private Integer tertiaryInsurerPayPercentage;

    @Column("tertiary_box_10d")
    private String tertiaryBox10d;

    @Column("tertiary_box_19")
    private String tertiaryBox19;

    @Column("tertiary_box_24ia")
    private String tertiaryBox24ia;

    @Column("tertiary_box_24ja")
    private String tertiaryBox24ja;

    @Column("tertiary_box_24jb")
    private String tertiaryBox24jb;

    @Column("tertiary_include_box_24jb_status")
    private String tertiaryIncludeBox24jbStatus;

    @Column("tertiary_include_payer_in_sales_order_status")
    private String tertiaryIncludePayerInSalesOrderStatus;

    @Column("tertiary_wait_previous_payer_before_billing_status")
    private String tertiaryWaitPreviousPayerBeforeBillingStatus;

    @Column("tertiary_pay_percentage_0_status")
    private String tertiaryPayPercentage0Status;

    @Column("insurance_verification_status")
    private String insuranceVerificationStatus;

    @Column("coverage_verification_status")
    private String coverageVerificationStatus;

    @Column("exclude_from_eligibility_check_status")
    private String excludeFromEligibilityCheckStatus;

    @Column("patient_pay_percentage")
    private String patientPayPercentage;

    @Column("patient_include_this_payor_in_sales_order_status")
    private String patientIncludeThisPayorInSalesOrderStatus;

    @Column("patient_wait_for_previous_payer_before_billing_status")
    private String patientWaitForPreviousPayerBeforeBillingStatus;

    @Column("workers_comp_date_of_onset")
    private LocalDate workersCompDateOfOnset;

    @Column("workers_comp_injury_related_employment_status")
    private String workersCompInjuryRelatedEmploymentStatus;

    @Column("workers_comp_injury_related_auto_accident_status")
    private String workersCompInjuryRelatedAutoAccidentStatus;

    @Column("workers_comp_auto_accident_state_id")
    private Integer workersCompAutoAccidentStateId;

    @Column("workers_comp_injury_related_to_other_accident_status")
    private String workersCompInjuryRelatedToOtherAccidentStatus;

    @Column("eclaims_attachment_status")
    private String eclaimsAttachmentStatus;

    @Column("attachment_number")
    private Integer attachmentNumber;

    @Column("type_code")
    private String typeCode;

    @Column("transaction_code")
    private String transactionCode;

    @Column("claims_note_type")
    private String claimsNoteType;

    @Column("claims_note")
    private String claimsNote;

    @Column("sales_order_no")
    private String salesOrderNo;

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

    public Integer getSalesOrderInsuranceDetailsId() {
        return this.salesOrderInsuranceDetailsId;
    }

    public SalesOrderInsuranceDetails salesOrderInsuranceDetailsId(Integer salesOrderInsuranceDetailsId) {
        this.setSalesOrderInsuranceDetailsId(salesOrderInsuranceDetailsId);
        return this;
    }

    public void setSalesOrderInsuranceDetailsId(Integer salesOrderInsuranceDetailsId) {
        this.salesOrderInsuranceDetailsId = salesOrderInsuranceDetailsId;
    }

    public Integer getSalesOrderId() {
        return this.salesOrderId;
    }

    public SalesOrderInsuranceDetails salesOrderId(Integer salesOrderId) {
        this.setSalesOrderId(salesOrderId);
        return this;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getPatientId() {
        return this.patientId;
    }

    public SalesOrderInsuranceDetails patientId(Integer patientId) {
        this.setPatientId(patientId);
        return this;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPrimaryInsurerId() {
        return this.primaryInsurerId;
    }

    public SalesOrderInsuranceDetails primaryInsurerId(Integer primaryInsurerId) {
        this.setPrimaryInsurerId(primaryInsurerId);
        return this;
    }

    public void setPrimaryInsurerId(Integer primaryInsurerId) {
        this.primaryInsurerId = primaryInsurerId;
    }

    public String getPrimaryInsurerName() {
        return this.primaryInsurerName;
    }

    public SalesOrderInsuranceDetails primaryInsurerName(String primaryInsurerName) {
        this.setPrimaryInsurerName(primaryInsurerName);
        return this;
    }

    public void setPrimaryInsurerName(String primaryInsurerName) {
        this.primaryInsurerName = primaryInsurerName;
    }

    public Integer getPrimaryInsuranceGroupId() {
        return this.primaryInsuranceGroupId;
    }

    public SalesOrderInsuranceDetails primaryInsuranceGroupId(Integer primaryInsuranceGroupId) {
        this.setPrimaryInsuranceGroupId(primaryInsuranceGroupId);
        return this;
    }

    public void setPrimaryInsuranceGroupId(Integer primaryInsuranceGroupId) {
        this.primaryInsuranceGroupId = primaryInsuranceGroupId;
    }

    public String getPrimaryInsuranceGroupName() {
        return this.primaryInsuranceGroupName;
    }

    public SalesOrderInsuranceDetails primaryInsuranceGroupName(String primaryInsuranceGroupName) {
        this.setPrimaryInsuranceGroupName(primaryInsuranceGroupName);
        return this;
    }

    public void setPrimaryInsuranceGroupName(String primaryInsuranceGroupName) {
        this.primaryInsuranceGroupName = primaryInsuranceGroupName;
    }

    public Integer getPrimaryInsurancePlanId() {
        return this.primaryInsurancePlanId;
    }

    public SalesOrderInsuranceDetails primaryInsurancePlanId(Integer primaryInsurancePlanId) {
        this.setPrimaryInsurancePlanId(primaryInsurancePlanId);
        return this;
    }

    public void setPrimaryInsurancePlanId(Integer primaryInsurancePlanId) {
        this.primaryInsurancePlanId = primaryInsurancePlanId;
    }

    public String getPrimaryInsurancePlanType() {
        return this.primaryInsurancePlanType;
    }

    public SalesOrderInsuranceDetails primaryInsurancePlanType(String primaryInsurancePlanType) {
        this.setPrimaryInsurancePlanType(primaryInsurancePlanType);
        return this;
    }

    public void setPrimaryInsurancePlanType(String primaryInsurancePlanType) {
        this.primaryInsurancePlanType = primaryInsurancePlanType;
    }

    public Integer getPrimaryInsuranceStateId() {
        return this.primaryInsuranceStateId;
    }

    public SalesOrderInsuranceDetails primaryInsuranceStateId(Integer primaryInsuranceStateId) {
        this.setPrimaryInsuranceStateId(primaryInsuranceStateId);
        return this;
    }

    public void setPrimaryInsuranceStateId(Integer primaryInsuranceStateId) {
        this.primaryInsuranceStateId = primaryInsuranceStateId;
    }

    public String getPrimaryInsuranceStateName() {
        return this.primaryInsuranceStateName;
    }

    public SalesOrderInsuranceDetails primaryInsuranceStateName(String primaryInsuranceStateName) {
        this.setPrimaryInsuranceStateName(primaryInsuranceStateName);
        return this;
    }

    public void setPrimaryInsuranceStateName(String primaryInsuranceStateName) {
        this.primaryInsuranceStateName = primaryInsuranceStateName;
    }

    public String getPrimaryInsurerPolicyNo() {
        return this.primaryInsurerPolicyNo;
    }

    public SalesOrderInsuranceDetails primaryInsurerPolicyNo(String primaryInsurerPolicyNo) {
        this.setPrimaryInsurerPolicyNo(primaryInsurerPolicyNo);
        return this;
    }

    public void setPrimaryInsurerPolicyNo(String primaryInsurerPolicyNo) {
        this.primaryInsurerPolicyNo = primaryInsurerPolicyNo;
    }

    public String getPrimaryInsurerPatientIdNumber() {
        return this.primaryInsurerPatientIdNumber;
    }

    public SalesOrderInsuranceDetails primaryInsurerPatientIdNumber(String primaryInsurerPatientIdNumber) {
        this.setPrimaryInsurerPatientIdNumber(primaryInsurerPatientIdNumber);
        return this;
    }

    public void setPrimaryInsurerPatientIdNumber(String primaryInsurerPatientIdNumber) {
        this.primaryInsurerPatientIdNumber = primaryInsurerPatientIdNumber;
    }

    public LocalDate getPrimaryInsurerEffectiveDate() {
        return this.primaryInsurerEffectiveDate;
    }

    public SalesOrderInsuranceDetails primaryInsurerEffectiveDate(LocalDate primaryInsurerEffectiveDate) {
        this.setPrimaryInsurerEffectiveDate(primaryInsurerEffectiveDate);
        return this;
    }

    public void setPrimaryInsurerEffectiveDate(LocalDate primaryInsurerEffectiveDate) {
        this.primaryInsurerEffectiveDate = primaryInsurerEffectiveDate;
    }

    public String getPrimaryInsurerVerificationStatus() {
        return this.primaryInsurerVerificationStatus;
    }

    public SalesOrderInsuranceDetails primaryInsurerVerificationStatus(String primaryInsurerVerificationStatus) {
        this.setPrimaryInsurerVerificationStatus(primaryInsurerVerificationStatus);
        return this;
    }

    public void setPrimaryInsurerVerificationStatus(String primaryInsurerVerificationStatus) {
        this.primaryInsurerVerificationStatus = primaryInsurerVerificationStatus;
    }

    public LocalDate getPrimaryInsurerVerificationDate() {
        return this.primaryInsurerVerificationDate;
    }

    public SalesOrderInsuranceDetails primaryInsurerVerificationDate(LocalDate primaryInsurerVerificationDate) {
        this.setPrimaryInsurerVerificationDate(primaryInsurerVerificationDate);
        return this;
    }

    public void setPrimaryInsurerVerificationDate(LocalDate primaryInsurerVerificationDate) {
        this.primaryInsurerVerificationDate = primaryInsurerVerificationDate;
    }

    public Integer getPrimaryInsurerPayPercentage() {
        return this.primaryInsurerPayPercentage;
    }

    public SalesOrderInsuranceDetails primaryInsurerPayPercentage(Integer primaryInsurerPayPercentage) {
        this.setPrimaryInsurerPayPercentage(primaryInsurerPayPercentage);
        return this;
    }

    public void setPrimaryInsurerPayPercentage(Integer primaryInsurerPayPercentage) {
        this.primaryInsurerPayPercentage = primaryInsurerPayPercentage;
    }

    public String getPrimaryBox10d() {
        return this.primaryBox10d;
    }

    public SalesOrderInsuranceDetails primaryBox10d(String primaryBox10d) {
        this.setPrimaryBox10d(primaryBox10d);
        return this;
    }

    public void setPrimaryBox10d(String primaryBox10d) {
        this.primaryBox10d = primaryBox10d;
    }

    public String getPrimaryBox19() {
        return this.primaryBox19;
    }

    public SalesOrderInsuranceDetails primaryBox19(String primaryBox19) {
        this.setPrimaryBox19(primaryBox19);
        return this;
    }

    public void setPrimaryBox19(String primaryBox19) {
        this.primaryBox19 = primaryBox19;
    }

    public String getPrimaryBox24ia() {
        return this.primaryBox24ia;
    }

    public SalesOrderInsuranceDetails primaryBox24ia(String primaryBox24ia) {
        this.setPrimaryBox24ia(primaryBox24ia);
        return this;
    }

    public void setPrimaryBox24ia(String primaryBox24ia) {
        this.primaryBox24ia = primaryBox24ia;
    }

    public String getPrimaryBox24ja() {
        return this.primaryBox24ja;
    }

    public SalesOrderInsuranceDetails primaryBox24ja(String primaryBox24ja) {
        this.setPrimaryBox24ja(primaryBox24ja);
        return this;
    }

    public void setPrimaryBox24ja(String primaryBox24ja) {
        this.primaryBox24ja = primaryBox24ja;
    }

    public String getPrimaryBox24jb() {
        return this.primaryBox24jb;
    }

    public SalesOrderInsuranceDetails primaryBox24jb(String primaryBox24jb) {
        this.setPrimaryBox24jb(primaryBox24jb);
        return this;
    }

    public void setPrimaryBox24jb(String primaryBox24jb) {
        this.primaryBox24jb = primaryBox24jb;
    }

    public String getPrimaryIncludeBox24Jbstatus() {
        return this.primaryIncludeBox24Jbstatus;
    }

    public SalesOrderInsuranceDetails primaryIncludeBox24Jbstatus(String primaryIncludeBox24Jbstatus) {
        this.setPrimaryIncludeBox24Jbstatus(primaryIncludeBox24Jbstatus);
        return this;
    }

    public void setPrimaryIncludeBox24Jbstatus(String primaryIncludeBox24Jbstatus) {
        this.primaryIncludeBox24Jbstatus = primaryIncludeBox24Jbstatus;
    }

    public String getPrimaryIncludePayerSalesOrderStatus() {
        return this.primaryIncludePayerSalesOrderStatus;
    }

    public SalesOrderInsuranceDetails primaryIncludePayerSalesOrderStatus(String primaryIncludePayerSalesOrderStatus) {
        this.setPrimaryIncludePayerSalesOrderStatus(primaryIncludePayerSalesOrderStatus);
        return this;
    }

    public void setPrimaryIncludePayerSalesOrderStatus(String primaryIncludePayerSalesOrderStatus) {
        this.primaryIncludePayerSalesOrderStatus = primaryIncludePayerSalesOrderStatus;
    }

    public String getPrimaryWaitForPreviousPayerBeforeBillingStatus() {
        return this.primaryWaitForPreviousPayerBeforeBillingStatus;
    }

    public SalesOrderInsuranceDetails primaryWaitForPreviousPayerBeforeBillingStatus(
        String primaryWaitForPreviousPayerBeforeBillingStatus
    ) {
        this.setPrimaryWaitForPreviousPayerBeforeBillingStatus(primaryWaitForPreviousPayerBeforeBillingStatus);
        return this;
    }

    public void setPrimaryWaitForPreviousPayerBeforeBillingStatus(String primaryWaitForPreviousPayerBeforeBillingStatus) {
        this.primaryWaitForPreviousPayerBeforeBillingStatus = primaryWaitForPreviousPayerBeforeBillingStatus;
    }

    public String getPrimaryPayPercentageStatus() {
        return this.primaryPayPercentageStatus;
    }

    public SalesOrderInsuranceDetails primaryPayPercentageStatus(String primaryPayPercentageStatus) {
        this.setPrimaryPayPercentageStatus(primaryPayPercentageStatus);
        return this;
    }

    public void setPrimaryPayPercentageStatus(String primaryPayPercentageStatus) {
        this.primaryPayPercentageStatus = primaryPayPercentageStatus;
    }

    public Integer getSecondaryInsurerId() {
        return this.secondaryInsurerId;
    }

    public SalesOrderInsuranceDetails secondaryInsurerId(Integer secondaryInsurerId) {
        this.setSecondaryInsurerId(secondaryInsurerId);
        return this;
    }

    public void setSecondaryInsurerId(Integer secondaryInsurerId) {
        this.secondaryInsurerId = secondaryInsurerId;
    }

    public String getSecondaryInsurerName() {
        return this.secondaryInsurerName;
    }

    public SalesOrderInsuranceDetails secondaryInsurerName(String secondaryInsurerName) {
        this.setSecondaryInsurerName(secondaryInsurerName);
        return this;
    }

    public void setSecondaryInsurerName(String secondaryInsurerName) {
        this.secondaryInsurerName = secondaryInsurerName;
    }

    public Integer getSecondaryInsuranceGroupId() {
        return this.secondaryInsuranceGroupId;
    }

    public SalesOrderInsuranceDetails secondaryInsuranceGroupId(Integer secondaryInsuranceGroupId) {
        this.setSecondaryInsuranceGroupId(secondaryInsuranceGroupId);
        return this;
    }

    public void setSecondaryInsuranceGroupId(Integer secondaryInsuranceGroupId) {
        this.secondaryInsuranceGroupId = secondaryInsuranceGroupId;
    }

    public String getSecondaryInsuranceGroupName() {
        return this.secondaryInsuranceGroupName;
    }

    public SalesOrderInsuranceDetails secondaryInsuranceGroupName(String secondaryInsuranceGroupName) {
        this.setSecondaryInsuranceGroupName(secondaryInsuranceGroupName);
        return this;
    }

    public void setSecondaryInsuranceGroupName(String secondaryInsuranceGroupName) {
        this.secondaryInsuranceGroupName = secondaryInsuranceGroupName;
    }

    public Integer getSecondaryInsurancePlanId() {
        return this.secondaryInsurancePlanId;
    }

    public SalesOrderInsuranceDetails secondaryInsurancePlanId(Integer secondaryInsurancePlanId) {
        this.setSecondaryInsurancePlanId(secondaryInsurancePlanId);
        return this;
    }

    public void setSecondaryInsurancePlanId(Integer secondaryInsurancePlanId) {
        this.secondaryInsurancePlanId = secondaryInsurancePlanId;
    }

    public String getSecondaryInsurancePlanType() {
        return this.secondaryInsurancePlanType;
    }

    public SalesOrderInsuranceDetails secondaryInsurancePlanType(String secondaryInsurancePlanType) {
        this.setSecondaryInsurancePlanType(secondaryInsurancePlanType);
        return this;
    }

    public void setSecondaryInsurancePlanType(String secondaryInsurancePlanType) {
        this.secondaryInsurancePlanType = secondaryInsurancePlanType;
    }

    public Integer getSecondaryInsuranceStateId() {
        return this.secondaryInsuranceStateId;
    }

    public SalesOrderInsuranceDetails secondaryInsuranceStateId(Integer secondaryInsuranceStateId) {
        this.setSecondaryInsuranceStateId(secondaryInsuranceStateId);
        return this;
    }

    public void setSecondaryInsuranceStateId(Integer secondaryInsuranceStateId) {
        this.secondaryInsuranceStateId = secondaryInsuranceStateId;
    }

    public String getSecondaryInsuranceStateName() {
        return this.secondaryInsuranceStateName;
    }

    public SalesOrderInsuranceDetails secondaryInsuranceStateName(String secondaryInsuranceStateName) {
        this.setSecondaryInsuranceStateName(secondaryInsuranceStateName);
        return this;
    }

    public void setSecondaryInsuranceStateName(String secondaryInsuranceStateName) {
        this.secondaryInsuranceStateName = secondaryInsuranceStateName;
    }

    public String getSecondaryInsurerPolicyNo() {
        return this.secondaryInsurerPolicyNo;
    }

    public SalesOrderInsuranceDetails secondaryInsurerPolicyNo(String secondaryInsurerPolicyNo) {
        this.setSecondaryInsurerPolicyNo(secondaryInsurerPolicyNo);
        return this;
    }

    public void setSecondaryInsurerPolicyNo(String secondaryInsurerPolicyNo) {
        this.secondaryInsurerPolicyNo = secondaryInsurerPolicyNo;
    }

    public String getSecondaryInsurerPatientIdNumber() {
        return this.secondaryInsurerPatientIdNumber;
    }

    public SalesOrderInsuranceDetails secondaryInsurerPatientIdNumber(String secondaryInsurerPatientIdNumber) {
        this.setSecondaryInsurerPatientIdNumber(secondaryInsurerPatientIdNumber);
        return this;
    }

    public void setSecondaryInsurerPatientIdNumber(String secondaryInsurerPatientIdNumber) {
        this.secondaryInsurerPatientIdNumber = secondaryInsurerPatientIdNumber;
    }

    public LocalDate getSecondaryInsurerEffectiveDate() {
        return this.secondaryInsurerEffectiveDate;
    }

    public SalesOrderInsuranceDetails secondaryInsurerEffectiveDate(LocalDate secondaryInsurerEffectiveDate) {
        this.setSecondaryInsurerEffectiveDate(secondaryInsurerEffectiveDate);
        return this;
    }

    public void setSecondaryInsurerEffectiveDate(LocalDate secondaryInsurerEffectiveDate) {
        this.secondaryInsurerEffectiveDate = secondaryInsurerEffectiveDate;
    }

    public String getSecondaryInsurerVerificationStatus() {
        return this.secondaryInsurerVerificationStatus;
    }

    public SalesOrderInsuranceDetails secondaryInsurerVerificationStatus(String secondaryInsurerVerificationStatus) {
        this.setSecondaryInsurerVerificationStatus(secondaryInsurerVerificationStatus);
        return this;
    }

    public void setSecondaryInsurerVerificationStatus(String secondaryInsurerVerificationStatus) {
        this.secondaryInsurerVerificationStatus = secondaryInsurerVerificationStatus;
    }

    public LocalDate getSecondaryInsurerVerificationDate() {
        return this.secondaryInsurerVerificationDate;
    }

    public SalesOrderInsuranceDetails secondaryInsurerVerificationDate(LocalDate secondaryInsurerVerificationDate) {
        this.setSecondaryInsurerVerificationDate(secondaryInsurerVerificationDate);
        return this;
    }

    public void setSecondaryInsurerVerificationDate(LocalDate secondaryInsurerVerificationDate) {
        this.secondaryInsurerVerificationDate = secondaryInsurerVerificationDate;
    }

    public Integer getSecondaryInsurerPayPercentage() {
        return this.secondaryInsurerPayPercentage;
    }

    public SalesOrderInsuranceDetails secondaryInsurerPayPercentage(Integer secondaryInsurerPayPercentage) {
        this.setSecondaryInsurerPayPercentage(secondaryInsurerPayPercentage);
        return this;
    }

    public void setSecondaryInsurerPayPercentage(Integer secondaryInsurerPayPercentage) {
        this.secondaryInsurerPayPercentage = secondaryInsurerPayPercentage;
    }

    public String getSecondaryBox10d() {
        return this.secondaryBox10d;
    }

    public SalesOrderInsuranceDetails secondaryBox10d(String secondaryBox10d) {
        this.setSecondaryBox10d(secondaryBox10d);
        return this;
    }

    public void setSecondaryBox10d(String secondaryBox10d) {
        this.secondaryBox10d = secondaryBox10d;
    }

    public String getSecondaryBox19() {
        return this.secondaryBox19;
    }

    public SalesOrderInsuranceDetails secondaryBox19(String secondaryBox19) {
        this.setSecondaryBox19(secondaryBox19);
        return this;
    }

    public void setSecondaryBox19(String secondaryBox19) {
        this.secondaryBox19 = secondaryBox19;
    }

    public String getSecondaryBox24ia() {
        return this.secondaryBox24ia;
    }

    public SalesOrderInsuranceDetails secondaryBox24ia(String secondaryBox24ia) {
        this.setSecondaryBox24ia(secondaryBox24ia);
        return this;
    }

    public void setSecondaryBox24ia(String secondaryBox24ia) {
        this.secondaryBox24ia = secondaryBox24ia;
    }

    public String getSecondaryBox24ja() {
        return this.secondaryBox24ja;
    }

    public SalesOrderInsuranceDetails secondaryBox24ja(String secondaryBox24ja) {
        this.setSecondaryBox24ja(secondaryBox24ja);
        return this;
    }

    public void setSecondaryBox24ja(String secondaryBox24ja) {
        this.secondaryBox24ja = secondaryBox24ja;
    }

    public String getSecondaryBox24jb() {
        return this.secondaryBox24jb;
    }

    public SalesOrderInsuranceDetails secondaryBox24jb(String secondaryBox24jb) {
        this.setSecondaryBox24jb(secondaryBox24jb);
        return this;
    }

    public void setSecondaryBox24jb(String secondaryBox24jb) {
        this.secondaryBox24jb = secondaryBox24jb;
    }

    public String getSecondaryIncludeBox24jbStatus() {
        return this.secondaryIncludeBox24jbStatus;
    }

    public SalesOrderInsuranceDetails secondaryIncludeBox24jbStatus(String secondaryIncludeBox24jbStatus) {
        this.setSecondaryIncludeBox24jbStatus(secondaryIncludeBox24jbStatus);
        return this;
    }

    public void setSecondaryIncludeBox24jbStatus(String secondaryIncludeBox24jbStatus) {
        this.secondaryIncludeBox24jbStatus = secondaryIncludeBox24jbStatus;
    }

    public String getSecondaryIncludePayerSalesOrderStatus() {
        return this.secondaryIncludePayerSalesOrderStatus;
    }

    public SalesOrderInsuranceDetails secondaryIncludePayerSalesOrderStatus(String secondaryIncludePayerSalesOrderStatus) {
        this.setSecondaryIncludePayerSalesOrderStatus(secondaryIncludePayerSalesOrderStatus);
        return this;
    }

    public void setSecondaryIncludePayerSalesOrderStatus(String secondaryIncludePayerSalesOrderStatus) {
        this.secondaryIncludePayerSalesOrderStatus = secondaryIncludePayerSalesOrderStatus;
    }

    public String getSecondaryWaitPreviousPayerBefrBillingStatus() {
        return this.secondaryWaitPreviousPayerBefrBillingStatus;
    }

    public SalesOrderInsuranceDetails secondaryWaitPreviousPayerBefrBillingStatus(String secondaryWaitPreviousPayerBefrBillingStatus) {
        this.setSecondaryWaitPreviousPayerBefrBillingStatus(secondaryWaitPreviousPayerBefrBillingStatus);
        return this;
    }

    public void setSecondaryWaitPreviousPayerBefrBillingStatus(String secondaryWaitPreviousPayerBefrBillingStatus) {
        this.secondaryWaitPreviousPayerBefrBillingStatus = secondaryWaitPreviousPayerBefrBillingStatus;
    }

    public String getSecondaryPayPercentageStatus() {
        return this.secondaryPayPercentageStatus;
    }

    public SalesOrderInsuranceDetails secondaryPayPercentageStatus(String secondaryPayPercentageStatus) {
        this.setSecondaryPayPercentageStatus(secondaryPayPercentageStatus);
        return this;
    }

    public void setSecondaryPayPercentageStatus(String secondaryPayPercentageStatus) {
        this.secondaryPayPercentageStatus = secondaryPayPercentageStatus;
    }

    public Integer getTertiaryInsurerId() {
        return this.tertiaryInsurerId;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerId(Integer tertiaryInsurerId) {
        this.setTertiaryInsurerId(tertiaryInsurerId);
        return this;
    }

    public void setTertiaryInsurerId(Integer tertiaryInsurerId) {
        this.tertiaryInsurerId = tertiaryInsurerId;
    }

    public String getTertiaryInsurerName() {
        return this.tertiaryInsurerName;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerName(String tertiaryInsurerName) {
        this.setTertiaryInsurerName(tertiaryInsurerName);
        return this;
    }

    public void setTertiaryInsurerName(String tertiaryInsurerName) {
        this.tertiaryInsurerName = tertiaryInsurerName;
    }

    public Integer getTertiaryInsuranceGroupId() {
        return this.tertiaryInsuranceGroupId;
    }

    public SalesOrderInsuranceDetails tertiaryInsuranceGroupId(Integer tertiaryInsuranceGroupId) {
        this.setTertiaryInsuranceGroupId(tertiaryInsuranceGroupId);
        return this;
    }

    public void setTertiaryInsuranceGroupId(Integer tertiaryInsuranceGroupId) {
        this.tertiaryInsuranceGroupId = tertiaryInsuranceGroupId;
    }

    public String getTertiaryInsuranceGroupName() {
        return this.tertiaryInsuranceGroupName;
    }

    public SalesOrderInsuranceDetails tertiaryInsuranceGroupName(String tertiaryInsuranceGroupName) {
        this.setTertiaryInsuranceGroupName(tertiaryInsuranceGroupName);
        return this;
    }

    public void setTertiaryInsuranceGroupName(String tertiaryInsuranceGroupName) {
        this.tertiaryInsuranceGroupName = tertiaryInsuranceGroupName;
    }

    public Integer getTertiaryInsurancePlanId() {
        return this.tertiaryInsurancePlanId;
    }

    public SalesOrderInsuranceDetails tertiaryInsurancePlanId(Integer tertiaryInsurancePlanId) {
        this.setTertiaryInsurancePlanId(tertiaryInsurancePlanId);
        return this;
    }

    public void setTertiaryInsurancePlanId(Integer tertiaryInsurancePlanId) {
        this.tertiaryInsurancePlanId = tertiaryInsurancePlanId;
    }

    public String getTertiaryInsurancePlanType() {
        return this.tertiaryInsurancePlanType;
    }

    public SalesOrderInsuranceDetails tertiaryInsurancePlanType(String tertiaryInsurancePlanType) {
        this.setTertiaryInsurancePlanType(tertiaryInsurancePlanType);
        return this;
    }

    public void setTertiaryInsurancePlanType(String tertiaryInsurancePlanType) {
        this.tertiaryInsurancePlanType = tertiaryInsurancePlanType;
    }

    public Integer getTertiaryInsuranceStateId() {
        return this.tertiaryInsuranceStateId;
    }

    public SalesOrderInsuranceDetails tertiaryInsuranceStateId(Integer tertiaryInsuranceStateId) {
        this.setTertiaryInsuranceStateId(tertiaryInsuranceStateId);
        return this;
    }

    public void setTertiaryInsuranceStateId(Integer tertiaryInsuranceStateId) {
        this.tertiaryInsuranceStateId = tertiaryInsuranceStateId;
    }

    public String getTertiaryInsuranceStateName() {
        return this.tertiaryInsuranceStateName;
    }

    public SalesOrderInsuranceDetails tertiaryInsuranceStateName(String tertiaryInsuranceStateName) {
        this.setTertiaryInsuranceStateName(tertiaryInsuranceStateName);
        return this;
    }

    public void setTertiaryInsuranceStateName(String tertiaryInsuranceStateName) {
        this.tertiaryInsuranceStateName = tertiaryInsuranceStateName;
    }

    public String getTertiaryInsurerPolicyno() {
        return this.tertiaryInsurerPolicyno;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerPolicyno(String tertiaryInsurerPolicyno) {
        this.setTertiaryInsurerPolicyno(tertiaryInsurerPolicyno);
        return this;
    }

    public void setTertiaryInsurerPolicyno(String tertiaryInsurerPolicyno) {
        this.tertiaryInsurerPolicyno = tertiaryInsurerPolicyno;
    }

    public String getTertiaryInsurerPatientIdNumber() {
        return this.tertiaryInsurerPatientIdNumber;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerPatientIdNumber(String tertiaryInsurerPatientIdNumber) {
        this.setTertiaryInsurerPatientIdNumber(tertiaryInsurerPatientIdNumber);
        return this;
    }

    public void setTertiaryInsurerPatientIdNumber(String tertiaryInsurerPatientIdNumber) {
        this.tertiaryInsurerPatientIdNumber = tertiaryInsurerPatientIdNumber;
    }

    public LocalDate getTertiaryInsurerEffectiveDate() {
        return this.tertiaryInsurerEffectiveDate;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerEffectiveDate(LocalDate tertiaryInsurerEffectiveDate) {
        this.setTertiaryInsurerEffectiveDate(tertiaryInsurerEffectiveDate);
        return this;
    }

    public void setTertiaryInsurerEffectiveDate(LocalDate tertiaryInsurerEffectiveDate) {
        this.tertiaryInsurerEffectiveDate = tertiaryInsurerEffectiveDate;
    }

    public String getTertiaryInsurerVerificationStatus() {
        return this.tertiaryInsurerVerificationStatus;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerVerificationStatus(String tertiaryInsurerVerificationStatus) {
        this.setTertiaryInsurerVerificationStatus(tertiaryInsurerVerificationStatus);
        return this;
    }

    public void setTertiaryInsurerVerificationStatus(String tertiaryInsurerVerificationStatus) {
        this.tertiaryInsurerVerificationStatus = tertiaryInsurerVerificationStatus;
    }

    public LocalDate getTertiaryInsurerVerificationDate() {
        return this.tertiaryInsurerVerificationDate;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerVerificationDate(LocalDate tertiaryInsurerVerificationDate) {
        this.setTertiaryInsurerVerificationDate(tertiaryInsurerVerificationDate);
        return this;
    }

    public void setTertiaryInsurerVerificationDate(LocalDate tertiaryInsurerVerificationDate) {
        this.tertiaryInsurerVerificationDate = tertiaryInsurerVerificationDate;
    }

    public Integer getTertiaryInsurerPayPercentage() {
        return this.tertiaryInsurerPayPercentage;
    }

    public SalesOrderInsuranceDetails tertiaryInsurerPayPercentage(Integer tertiaryInsurerPayPercentage) {
        this.setTertiaryInsurerPayPercentage(tertiaryInsurerPayPercentage);
        return this;
    }

    public void setTertiaryInsurerPayPercentage(Integer tertiaryInsurerPayPercentage) {
        this.tertiaryInsurerPayPercentage = tertiaryInsurerPayPercentage;
    }

    public String getTertiaryBox10d() {
        return this.tertiaryBox10d;
    }

    public SalesOrderInsuranceDetails tertiaryBox10d(String tertiaryBox10d) {
        this.setTertiaryBox10d(tertiaryBox10d);
        return this;
    }

    public void setTertiaryBox10d(String tertiaryBox10d) {
        this.tertiaryBox10d = tertiaryBox10d;
    }

    public String getTertiaryBox19() {
        return this.tertiaryBox19;
    }

    public SalesOrderInsuranceDetails tertiaryBox19(String tertiaryBox19) {
        this.setTertiaryBox19(tertiaryBox19);
        return this;
    }

    public void setTertiaryBox19(String tertiaryBox19) {
        this.tertiaryBox19 = tertiaryBox19;
    }

    public String getTertiaryBox24ia() {
        return this.tertiaryBox24ia;
    }

    public SalesOrderInsuranceDetails tertiaryBox24ia(String tertiaryBox24ia) {
        this.setTertiaryBox24ia(tertiaryBox24ia);
        return this;
    }

    public void setTertiaryBox24ia(String tertiaryBox24ia) {
        this.tertiaryBox24ia = tertiaryBox24ia;
    }

    public String getTertiaryBox24ja() {
        return this.tertiaryBox24ja;
    }

    public SalesOrderInsuranceDetails tertiaryBox24ja(String tertiaryBox24ja) {
        this.setTertiaryBox24ja(tertiaryBox24ja);
        return this;
    }

    public void setTertiaryBox24ja(String tertiaryBox24ja) {
        this.tertiaryBox24ja = tertiaryBox24ja;
    }

    public String getTertiaryBox24jb() {
        return this.tertiaryBox24jb;
    }

    public SalesOrderInsuranceDetails tertiaryBox24jb(String tertiaryBox24jb) {
        this.setTertiaryBox24jb(tertiaryBox24jb);
        return this;
    }

    public void setTertiaryBox24jb(String tertiaryBox24jb) {
        this.tertiaryBox24jb = tertiaryBox24jb;
    }

    public String getTertiaryIncludeBox24jbStatus() {
        return this.tertiaryIncludeBox24jbStatus;
    }

    public SalesOrderInsuranceDetails tertiaryIncludeBox24jbStatus(String tertiaryIncludeBox24jbStatus) {
        this.setTertiaryIncludeBox24jbStatus(tertiaryIncludeBox24jbStatus);
        return this;
    }

    public void setTertiaryIncludeBox24jbStatus(String tertiaryIncludeBox24jbStatus) {
        this.tertiaryIncludeBox24jbStatus = tertiaryIncludeBox24jbStatus;
    }

    public String getTertiaryIncludePayerInSalesOrderStatus() {
        return this.tertiaryIncludePayerInSalesOrderStatus;
    }

    public SalesOrderInsuranceDetails tertiaryIncludePayerInSalesOrderStatus(String tertiaryIncludePayerInSalesOrderStatus) {
        this.setTertiaryIncludePayerInSalesOrderStatus(tertiaryIncludePayerInSalesOrderStatus);
        return this;
    }

    public void setTertiaryIncludePayerInSalesOrderStatus(String tertiaryIncludePayerInSalesOrderStatus) {
        this.tertiaryIncludePayerInSalesOrderStatus = tertiaryIncludePayerInSalesOrderStatus;
    }

    public String getTertiaryWaitPreviousPayerBeforeBillingStatus() {
        return this.tertiaryWaitPreviousPayerBeforeBillingStatus;
    }

    public SalesOrderInsuranceDetails tertiaryWaitPreviousPayerBeforeBillingStatus(String tertiaryWaitPreviousPayerBeforeBillingStatus) {
        this.setTertiaryWaitPreviousPayerBeforeBillingStatus(tertiaryWaitPreviousPayerBeforeBillingStatus);
        return this;
    }

    public void setTertiaryWaitPreviousPayerBeforeBillingStatus(String tertiaryWaitPreviousPayerBeforeBillingStatus) {
        this.tertiaryWaitPreviousPayerBeforeBillingStatus = tertiaryWaitPreviousPayerBeforeBillingStatus;
    }

    public String getTertiaryPayPercentage0Status() {
        return this.tertiaryPayPercentage0Status;
    }

    public SalesOrderInsuranceDetails tertiaryPayPercentage0Status(String tertiaryPayPercentage0Status) {
        this.setTertiaryPayPercentage0Status(tertiaryPayPercentage0Status);
        return this;
    }

    public void setTertiaryPayPercentage0Status(String tertiaryPayPercentage0Status) {
        this.tertiaryPayPercentage0Status = tertiaryPayPercentage0Status;
    }

    public String getInsuranceVerificationStatus() {
        return this.insuranceVerificationStatus;
    }

    public SalesOrderInsuranceDetails insuranceVerificationStatus(String insuranceVerificationStatus) {
        this.setInsuranceVerificationStatus(insuranceVerificationStatus);
        return this;
    }

    public void setInsuranceVerificationStatus(String insuranceVerificationStatus) {
        this.insuranceVerificationStatus = insuranceVerificationStatus;
    }

    public String getCoverageVerificationStatus() {
        return this.coverageVerificationStatus;
    }

    public SalesOrderInsuranceDetails coverageVerificationStatus(String coverageVerificationStatus) {
        this.setCoverageVerificationStatus(coverageVerificationStatus);
        return this;
    }

    public void setCoverageVerificationStatus(String coverageVerificationStatus) {
        this.coverageVerificationStatus = coverageVerificationStatus;
    }

    public String getExcludeFromEligibilityCheckStatus() {
        return this.excludeFromEligibilityCheckStatus;
    }

    public SalesOrderInsuranceDetails excludeFromEligibilityCheckStatus(String excludeFromEligibilityCheckStatus) {
        this.setExcludeFromEligibilityCheckStatus(excludeFromEligibilityCheckStatus);
        return this;
    }

    public void setExcludeFromEligibilityCheckStatus(String excludeFromEligibilityCheckStatus) {
        this.excludeFromEligibilityCheckStatus = excludeFromEligibilityCheckStatus;
    }

    public String getPatientPayPercentage() {
        return this.patientPayPercentage;
    }

    public SalesOrderInsuranceDetails patientPayPercentage(String patientPayPercentage) {
        this.setPatientPayPercentage(patientPayPercentage);
        return this;
    }

    public void setPatientPayPercentage(String patientPayPercentage) {
        this.patientPayPercentage = patientPayPercentage;
    }

    public String getPatientIncludeThisPayorInSalesOrderStatus() {
        return this.patientIncludeThisPayorInSalesOrderStatus;
    }

    public SalesOrderInsuranceDetails patientIncludeThisPayorInSalesOrderStatus(String patientIncludeThisPayorInSalesOrderStatus) {
        this.setPatientIncludeThisPayorInSalesOrderStatus(patientIncludeThisPayorInSalesOrderStatus);
        return this;
    }

    public void setPatientIncludeThisPayorInSalesOrderStatus(String patientIncludeThisPayorInSalesOrderStatus) {
        this.patientIncludeThisPayorInSalesOrderStatus = patientIncludeThisPayorInSalesOrderStatus;
    }

    public String getPatientWaitForPreviousPayerBeforeBillingStatus() {
        return this.patientWaitForPreviousPayerBeforeBillingStatus;
    }

    public SalesOrderInsuranceDetails patientWaitForPreviousPayerBeforeBillingStatus(
        String patientWaitForPreviousPayerBeforeBillingStatus
    ) {
        this.setPatientWaitForPreviousPayerBeforeBillingStatus(patientWaitForPreviousPayerBeforeBillingStatus);
        return this;
    }

    public void setPatientWaitForPreviousPayerBeforeBillingStatus(String patientWaitForPreviousPayerBeforeBillingStatus) {
        this.patientWaitForPreviousPayerBeforeBillingStatus = patientWaitForPreviousPayerBeforeBillingStatus;
    }

    public LocalDate getWorkersCompDateOfOnset() {
        return this.workersCompDateOfOnset;
    }

    public SalesOrderInsuranceDetails workersCompDateOfOnset(LocalDate workersCompDateOfOnset) {
        this.setWorkersCompDateOfOnset(workersCompDateOfOnset);
        return this;
    }

    public void setWorkersCompDateOfOnset(LocalDate workersCompDateOfOnset) {
        this.workersCompDateOfOnset = workersCompDateOfOnset;
    }

    public String getWorkersCompInjuryRelatedEmploymentStatus() {
        return this.workersCompInjuryRelatedEmploymentStatus;
    }

    public SalesOrderInsuranceDetails workersCompInjuryRelatedEmploymentStatus(String workersCompInjuryRelatedEmploymentStatus) {
        this.setWorkersCompInjuryRelatedEmploymentStatus(workersCompInjuryRelatedEmploymentStatus);
        return this;
    }

    public void setWorkersCompInjuryRelatedEmploymentStatus(String workersCompInjuryRelatedEmploymentStatus) {
        this.workersCompInjuryRelatedEmploymentStatus = workersCompInjuryRelatedEmploymentStatus;
    }

    public String getWorkersCompInjuryRelatedAutoAccidentStatus() {
        return this.workersCompInjuryRelatedAutoAccidentStatus;
    }

    public SalesOrderInsuranceDetails workersCompInjuryRelatedAutoAccidentStatus(String workersCompInjuryRelatedAutoAccidentStatus) {
        this.setWorkersCompInjuryRelatedAutoAccidentStatus(workersCompInjuryRelatedAutoAccidentStatus);
        return this;
    }

    public void setWorkersCompInjuryRelatedAutoAccidentStatus(String workersCompInjuryRelatedAutoAccidentStatus) {
        this.workersCompInjuryRelatedAutoAccidentStatus = workersCompInjuryRelatedAutoAccidentStatus;
    }

    public Integer getWorkersCompAutoAccidentStateId() {
        return this.workersCompAutoAccidentStateId;
    }

    public SalesOrderInsuranceDetails workersCompAutoAccidentStateId(Integer workersCompAutoAccidentStateId) {
        this.setWorkersCompAutoAccidentStateId(workersCompAutoAccidentStateId);
        return this;
    }

    public void setWorkersCompAutoAccidentStateId(Integer workersCompAutoAccidentStateId) {
        this.workersCompAutoAccidentStateId = workersCompAutoAccidentStateId;
    }

    public String getWorkersCompInjuryRelatedToOtherAccidentStatus() {
        return this.workersCompInjuryRelatedToOtherAccidentStatus;
    }

    public SalesOrderInsuranceDetails workersCompInjuryRelatedToOtherAccidentStatus(String workersCompInjuryRelatedToOtherAccidentStatus) {
        this.setWorkersCompInjuryRelatedToOtherAccidentStatus(workersCompInjuryRelatedToOtherAccidentStatus);
        return this;
    }

    public void setWorkersCompInjuryRelatedToOtherAccidentStatus(String workersCompInjuryRelatedToOtherAccidentStatus) {
        this.workersCompInjuryRelatedToOtherAccidentStatus = workersCompInjuryRelatedToOtherAccidentStatus;
    }

    public String getEclaimsAttachmentStatus() {
        return this.eclaimsAttachmentStatus;
    }

    public SalesOrderInsuranceDetails eclaimsAttachmentStatus(String eclaimsAttachmentStatus) {
        this.setEclaimsAttachmentStatus(eclaimsAttachmentStatus);
        return this;
    }

    public void setEclaimsAttachmentStatus(String eclaimsAttachmentStatus) {
        this.eclaimsAttachmentStatus = eclaimsAttachmentStatus;
    }

    public Integer getAttachmentNumber() {
        return this.attachmentNumber;
    }

    public SalesOrderInsuranceDetails attachmentNumber(Integer attachmentNumber) {
        this.setAttachmentNumber(attachmentNumber);
        return this;
    }

    public void setAttachmentNumber(Integer attachmentNumber) {
        this.attachmentNumber = attachmentNumber;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public SalesOrderInsuranceDetails typeCode(String typeCode) {
        this.setTypeCode(typeCode);
        return this;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTransactionCode() {
        return this.transactionCode;
    }

    public SalesOrderInsuranceDetails transactionCode(String transactionCode) {
        this.setTransactionCode(transactionCode);
        return this;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getClaimsNoteType() {
        return this.claimsNoteType;
    }

    public SalesOrderInsuranceDetails claimsNoteType(String claimsNoteType) {
        this.setClaimsNoteType(claimsNoteType);
        return this;
    }

    public void setClaimsNoteType(String claimsNoteType) {
        this.claimsNoteType = claimsNoteType;
    }

    public String getClaimsNote() {
        return this.claimsNote;
    }

    public SalesOrderInsuranceDetails claimsNote(String claimsNote) {
        this.setClaimsNote(claimsNote);
        return this;
    }

    public void setClaimsNote(String claimsNote) {
        this.claimsNote = claimsNote;
    }

    public String getSalesOrderNo() {
        return this.salesOrderNo;
    }

    public SalesOrderInsuranceDetails salesOrderNo(String salesOrderNo) {
        this.setSalesOrderNo(salesOrderNo);
        return this;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public String getStatus() {
        return this.status;
    }

    public SalesOrderInsuranceDetails status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return this.createdById;
    }

    public SalesOrderInsuranceDetails createdById(Integer createdById) {
        this.setCreatedById(createdById);
        return this;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return this.createdByName;
    }

    public SalesOrderInsuranceDetails createdByName(String createdByName) {
        this.setCreatedByName(createdByName);
        return this;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public SalesOrderInsuranceDetails createdDate(ZonedDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedById() {
        return this.updatedById;
    }

    public SalesOrderInsuranceDetails updatedById(Integer updatedById) {
        this.setUpdatedById(updatedById);
        return this;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return this.updatedByName;
    }

    public SalesOrderInsuranceDetails updatedByName(String updatedByName) {
        this.setUpdatedByName(updatedByName);
        return this;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public SalesOrderInsuranceDetails updatedDate(ZonedDateTime updatedDate) {
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
        return "SalesOrderInsuranceDetails{" +
            ", salesOrderInsuranceDetailsId=" + getSalesOrderInsuranceDetailsId() +
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
            "}";
    }
}
