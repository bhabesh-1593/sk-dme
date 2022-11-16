package com.sunknowledge.dme.rcm.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A SalesOrderClinicalDetails.
 */
@Table("t_sales_order_clinical_details")
public class SalesOrderClinicalDetails implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Column("id")
//    private Long id;

    @Id
    @NotNull(message = "must not be null")
    @Column("sales_oder_clinical_details_id")
    private Integer salesOderClinicalDetailsId;

    @NotNull(message = "must not be null")
    @Column("sales_oder_id")
    private Integer salesOderId;

    @NotNull(message = "must not be null")
    @Column("patient_id")
    private Integer patientId;

    @Column("patient_weight_in_kg")
    private Double patientWeightInKg;

    @Column("patient_weight_in_lbs")
    private Double patientWeightInLbs;

    @Column("height_in_inches")
    private Double heightInInches;

    @Column("height_in_cm")
    private Double heightInCm;

    @Column("sales_rep_id")
    private Integer salesRepId;

    @Column("sales_rep_name")
    private String salesepName;

    @Column("practitioner_id")
    private Integer practitionerId;

    @Column("rendering_provider_type")
    private String renderingProviderType;

    @Column("rendering_provider_facility_id")
    private Integer renderingProviderFacilityId;

    @Column("rendering_provider_facility_name")
    private String renderingProviderFacilityName;

    //@NotNull(message = "must not be null")
    @Column("rendering_provider_id")
    private Integer renderingProviderId;

    //@NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("rendering_provider_first_name")
    private String renderingProviderFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("rendering_provider_middle_name")
    private String renderingProviderMiddleName;

    //@NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("rendering_provider_last_name")
    private String renderingProviderLastName;

    //@NotNull(message = "must not be null")
    @Column("rendering_provider_npi")
    private String renderingProviderNpi;

    //@NotNull(message = "must not be null")
    @Column("rendering_provider_dea")
    private String renderingProviderDea;

    //@NotNull(message = "must not be null")
    @Column("rendering_provider_address_id")
    private Integer renderingProviderAddressId;

    @Column("rendering_provider_address_line_1")
    private String renderingProviderAddressLine1;

    @Column("rendering_provider_address_line_2")
    private String renderingProviderAddressLine2;

    @Column("rendering_provider_city_name")
    private String renderingProviderCityName;

    @Column("rendering_provider_state_name")
    private String renderingProviderStateName;

    @Column("rendering_provider_zip")
    private String renderingProviderZip;

    //@NotNull(message = "must not be null")
    @Column("rendering_provider_contact_id")
    private Integer renderingProviderContactId;

    @Column("rendering_provider_phone_1")
    private String renderingProviderPhone1;

    @Column("rendering_provider_phone_2")
    private String renderingProviderPhone2;

    @Column("rendering_provider_email")
    private String renderingProviderEmail;

    @Column("rendering_provider_fax")
    private String renderingProviderFax;

    @Column("referring_provider_type")
    private String referringProviderType;

    @Column("referring_provider_facility_id")
    private Integer referringProviderFacilityId;

    @Column("referring_provider_facility_name")
    private String referringProviderFacilityName;

    //@NotNull(message = "must not be null")
    @Column("referring_provider_id")
    private Integer referringProviderId;

    //@NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("referring_provider_first_name")
    private String referringProviderFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("referring_provider_middle_name")
    private String referringProviderMiddleName;

    //@NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("referring_provider_last_name")
    private String referringProviderLastName;

    //@NotNull(message = "must not be null")
    @Column("referring_provider_npi")
    private String referringProviderNpi;

    @NotNull(message = "must not be null")
    @Column("referring_provider_dea")
    private String referringProviderDea;

    @NotNull(message = "must not be null")
    @Column("referring_provider_address_id")
    private Integer referringProviderAddressId;

    @Column("referring_provider_address_line_1")
    private String referringProviderAddressLine1;

    @Column("referring_provider_address_line_2")
    private String referringProviderAddressLine2;

    @Column("referring_provider_city_name")
    private String referringProviderCityName;

    @Column("referring_provider_state_name")
    private String referringProviderStateName;

    @Column("referring_provider_zip")
    private String referringProviderZip;

    @NotNull(message = "must not be null")
    @Column("referring_provider_contact_id")
    private Integer referringProviderContactId;

    @Column("referring_provider_phone_1")
    private String referringProviderPhone1;

    @Column("referring_provider_phone_2")
    private String referringProviderPhone2;

    @Column("referring_provider_email")
    private String referringProviderEmail;

    @Column("referring_provider_fax")
    private String referringProviderFax;

    @Column("ordering_provider_type")
    private String orderingProviderType;

    @Column("ordering_provider_facility_id")
    private Integer orderingProviderFacilityId;

    @Column("ordering_provider_facility_name")
    private String orderingProviderFacilityName;

    @NotNull(message = "must not be null")
    @Column("ordering_provider_id")
    private Integer orderingProviderId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("ordering_provider_first_name")
    private String orderingProviderFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("ordering_provider_middle_name")
    private String orderingProviderMiddleName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("ordering_provider_last_name")
    private String orderingProviderLastName;

    @NotNull(message = "must not be null")
    @Column("ordering_provider_npi")
    private String orderingProviderNpi;

    @NotNull(message = "must not be null")
    @Column("ordering_provider_dea")
    private String orderingProviderDea;

    @NotNull(message = "must not be null")
    @Column("ordering_provider_address_id")
    private Integer orderingProviderAddressId;

    @Column("ordering_provider_address_line_1")
    private String orderingProviderAddressLine1;

    @Column("ordering_provider_address_line_2")
    private String orderingProviderAddressLine2;

    @Column("ordering_provider_city_name")
    private String orderingProviderCityName;

    @Column("ordering_provider_state_name")
    private String orderingProviderStateName;

    @Column("ordering_provider_zip")
    private String orderingProviderZip;

    @NotNull(message = "must not be null")
    @Column("ordering_provider_contact_id")
    private Integer orderingProviderContactId;

    @Column("ordering_provider_phone_1")
    private String orderingProviderPhone1;

    @Column("ordering_provider_phone_2")
    private String orderingProviderPhone2;

    @Column("ordering_provider_email")
    private String orderingProviderEmail;

    @Column("ordering_provider_fax")
    private String orderingProviderFax;

    @Column("marketing_referal_type_id")
    private Integer marketingReferalTypeId;

    @Column("marketing_referal_type_description")
    private String marketingReferalTypeDescription;

    @Column("marketing_referal_id")
    private Integer marketingReferalId;

    @NotNull(message = "must not be null")
    @Column("marketing_referal_name")
    private String marketingReferalName;

    @Column("icd_10_diagnosis_code_1")
    private String icd10DiagnosisCode1;

    @Column("icd_10_diagnosis_code_2")
    private String icd10DiagnosisCode2;

    @Column("icd_10_diagnosis_code_3")
    private String icd10DiagnosisCode3;

    @Column("icd_10_diagnosis_code_4")
    private String icd10DiagnosisCode4;

    @Column("icd_10_diagnosis_code_5")
    private String icd10DiagnosisCode5;

    @Column("icd_10_diagnosis_code_6")
    private String icd10DiagnosisCode6;

    @Column("icd_10_diagnosis_code_7")
    private String icd10DiagnosisCode7;

    @Column("icd_10_diagnosis_code_8")
    private String icd10DiagnosisCode8;

    @Column("icd_10_diagnosis_code_9")
    private String icd10DiagnosisCode9;

    @Column("icd_10_diagnosis_code_10")
    private String icd10DiagnosisCode10;

    @Column("icd_10_diagnosis_code_11")
    private String icd10DiagnosisCode11;

    @Column("icd_10_diagnosis_code_12")
    private String icd10DiagnosisCode12;

    @Column("epsdt_certification_condition_indicator")
    private String epsdtCertificationConditionIndicator;

    @Column("epsdt_certification_code")
    private String epsdtCertificationCode;

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

    public Integer getSalesOderClinicalDetailsId() {
        return this.salesOderClinicalDetailsId;
    }

    public SalesOrderClinicalDetails salesOderClinicalDetailsId(Integer salesOderClinicalDetailsId) {
        this.setSalesOderClinicalDetailsId(salesOderClinicalDetailsId);
        return this;
    }

    public void setSalesOderClinicalDetailsId(Integer salesOderClinicalDetailsId) {
        this.salesOderClinicalDetailsId = salesOderClinicalDetailsId;
    }

    public Integer getSalesOderId() {
        return this.salesOderId;
    }

    public SalesOrderClinicalDetails salesOderId(Integer salesOderId) {
        this.setSalesOderId(salesOderId);
        return this;
    }

    public void setSalesOderId(Integer salesOderId) {
        this.salesOderId = salesOderId;
    }

    public Integer getPatientId() {
        return this.patientId;
    }

    public SalesOrderClinicalDetails patientId(Integer patientId) {
        this.setPatientId(patientId);
        return this;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Double getPatientWeightInKg() {
        return this.patientWeightInKg;
    }

    public SalesOrderClinicalDetails patientWeightInKg(Double patientWeightInKg) {
        this.setPatientWeightInKg(patientWeightInKg);
        return this;
    }

    public void setPatientWeightInKg(Double patientWeightInKg) {
        this.patientWeightInKg = patientWeightInKg;
    }

    public Double getPatientWeightInLbs() {
        return this.patientWeightInLbs;
    }

    public SalesOrderClinicalDetails patientWeightInLbs(Double patientWeightInLbs) {
        this.setPatientWeightInLbs(patientWeightInLbs);
        return this;
    }

    public void setPatientWeightInLbs(Double patientWeightInLbs) {
        this.patientWeightInLbs = patientWeightInLbs;
    }

    public Double getHeightInInches() {
        return this.heightInInches;
    }

    public SalesOrderClinicalDetails heightInInches(Double heightInInches) {
        this.setHeightInInches(heightInInches);
        return this;
    }

    public void setHeightInInches(Double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public Double getHeightInCm() {
        return this.heightInCm;
    }

    public SalesOrderClinicalDetails heightInCm(Double heightInCm) {
        this.setHeightInCm(heightInCm);
        return this;
    }

    public void setHeightInCm(Double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public Integer getSalesRepId() {
        return this.salesRepId;
    }

    public SalesOrderClinicalDetails salesRepId(Integer salesRepId) {
        this.setSalesRepId(salesRepId);
        return this;
    }

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String getSalesepName() {
        return this.salesepName;
    }

    public SalesOrderClinicalDetails salesepName(String salesepName) {
        this.setSalesepName(salesepName);
        return this;
    }

    public void setSalesepName(String salesepName) {
        this.salesepName = salesepName;
    }

    public Integer getPractitionerId() {
        return this.practitionerId;
    }

    public SalesOrderClinicalDetails practitionerId(Integer practitionerId) {
        this.setPractitionerId(practitionerId);
        return this;
    }

    public void setPractitionerId(Integer practitionerId) {
        this.practitionerId = practitionerId;
    }

    public String getRenderingProviderType() {
        return this.renderingProviderType;
    }

    public SalesOrderClinicalDetails renderingProviderType(String renderingProviderType) {
        this.setRenderingProviderType(renderingProviderType);
        return this;
    }

    public void setRenderingProviderType(String renderingProviderType) {
        this.renderingProviderType = renderingProviderType;
    }

    public Integer getRenderingProviderFacilityId() {
        return this.renderingProviderFacilityId;
    }

    public SalesOrderClinicalDetails renderingProviderFacilityId(Integer renderingProviderFacilityId) {
        this.setRenderingProviderFacilityId(renderingProviderFacilityId);
        return this;
    }

    public void setRenderingProviderFacilityId(Integer renderingProviderFacilityId) {
        this.renderingProviderFacilityId = renderingProviderFacilityId;
    }

    public String getRenderingProviderFacilityName() {
        return this.renderingProviderFacilityName;
    }

    public SalesOrderClinicalDetails renderingProviderFacilityName(String renderingProviderFacilityName) {
        this.setRenderingProviderFacilityName(renderingProviderFacilityName);
        return this;
    }

    public void setRenderingProviderFacilityName(String renderingProviderFacilityName) {
        this.renderingProviderFacilityName = renderingProviderFacilityName;
    }

    public Integer getRenderingProviderId() {
        return this.renderingProviderId;
    }

    public SalesOrderClinicalDetails renderingProviderId(Integer renderingProviderId) {
        this.setRenderingProviderId(renderingProviderId);
        return this;
    }

    public void setRenderingProviderId(Integer renderingProviderId) {
        this.renderingProviderId = renderingProviderId;
    }

    public String getRenderingProviderFirstName() {
        return this.renderingProviderFirstName;
    }

    public SalesOrderClinicalDetails renderingProviderFirstName(String renderingProviderFirstName) {
        this.setRenderingProviderFirstName(renderingProviderFirstName);
        return this;
    }

    public void setRenderingProviderFirstName(String renderingProviderFirstName) {
        this.renderingProviderFirstName = renderingProviderFirstName;
    }

    public String getRenderingProviderMiddleName() {
        return this.renderingProviderMiddleName;
    }

    public SalesOrderClinicalDetails renderingProviderMiddleName(String renderingProviderMiddleName) {
        this.setRenderingProviderMiddleName(renderingProviderMiddleName);
        return this;
    }

    public void setRenderingProviderMiddleName(String renderingProviderMiddleName) {
        this.renderingProviderMiddleName = renderingProviderMiddleName;
    }

    public String getRenderingProviderLastName() {
        return this.renderingProviderLastName;
    }

    public SalesOrderClinicalDetails renderingProviderLastName(String renderingProviderLastName) {
        this.setRenderingProviderLastName(renderingProviderLastName);
        return this;
    }

    public void setRenderingProviderLastName(String renderingProviderLastName) {
        this.renderingProviderLastName = renderingProviderLastName;
    }

    public String getRenderingProviderNpi() {
        return this.renderingProviderNpi;
    }

    public SalesOrderClinicalDetails renderingProviderNpi(String renderingProviderNpi) {
        this.setRenderingProviderNpi(renderingProviderNpi);
        return this;
    }

    public void setRenderingProviderNpi(String renderingProviderNpi) {
        this.renderingProviderNpi = renderingProviderNpi;
    }

    public String getRenderingProviderDea() {
        return this.renderingProviderDea;
    }

    public SalesOrderClinicalDetails renderingProviderDea(String renderingProviderDea) {
        this.setRenderingProviderDea(renderingProviderDea);
        return this;
    }

    public void setRenderingProviderDea(String renderingProviderDea) {
        this.renderingProviderDea = renderingProviderDea;
    }

    public Integer getRenderingProviderAddressId() {
        return this.renderingProviderAddressId;
    }

    public SalesOrderClinicalDetails renderingProviderAddressId(Integer renderingProviderAddressId) {
        this.setRenderingProviderAddressId(renderingProviderAddressId);
        return this;
    }

    public void setRenderingProviderAddressId(Integer renderingProviderAddressId) {
        this.renderingProviderAddressId = renderingProviderAddressId;
    }

    public String getRenderingProviderAddressLine1() {
        return this.renderingProviderAddressLine1;
    }

    public SalesOrderClinicalDetails renderingProviderAddressLine1(String renderingProviderAddressLine1) {
        this.setRenderingProviderAddressLine1(renderingProviderAddressLine1);
        return this;
    }

    public void setRenderingProviderAddressLine1(String renderingProviderAddressLine1) {
        this.renderingProviderAddressLine1 = renderingProviderAddressLine1;
    }

    public String getRenderingProviderAddressLine2() {
        return this.renderingProviderAddressLine2;
    }

    public SalesOrderClinicalDetails renderingProviderAddressLine2(String renderingProviderAddressLine2) {
        this.setRenderingProviderAddressLine2(renderingProviderAddressLine2);
        return this;
    }

    public void setRenderingProviderAddressLine2(String renderingProviderAddressLine2) {
        this.renderingProviderAddressLine2 = renderingProviderAddressLine2;
    }

    public String getRenderingProviderCityName() {
        return this.renderingProviderCityName;
    }

    public SalesOrderClinicalDetails renderingProviderCityName(String renderingProviderCityName) {
        this.setRenderingProviderCityName(renderingProviderCityName);
        return this;
    }

    public void setRenderingProviderCityName(String renderingProviderCityName) {
        this.renderingProviderCityName = renderingProviderCityName;
    }

    public String getRenderingProviderStateName() {
        return this.renderingProviderStateName;
    }

    public SalesOrderClinicalDetails renderingProviderStateName(String renderingProviderStateName) {
        this.setRenderingProviderStateName(renderingProviderStateName);
        return this;
    }

    public void setRenderingProviderStateName(String renderingProviderStateName) {
        this.renderingProviderStateName = renderingProviderStateName;
    }

    public String getRenderingProviderZip() {
        return this.renderingProviderZip;
    }

    public SalesOrderClinicalDetails renderingProviderZip(String renderingProviderZip) {
        this.setRenderingProviderZip(renderingProviderZip);
        return this;
    }

    public void setRenderingProviderZip(String renderingProviderZip) {
        this.renderingProviderZip = renderingProviderZip;
    }

    public Integer getRenderingProviderContactId() {
        return this.renderingProviderContactId;
    }

    public SalesOrderClinicalDetails renderingProviderContactId(Integer renderingProviderContactId) {
        this.setRenderingProviderContactId(renderingProviderContactId);
        return this;
    }

    public void setRenderingProviderContactId(Integer renderingProviderContactId) {
        this.renderingProviderContactId = renderingProviderContactId;
    }

    public String getRenderingProviderPhone1() {
        return this.renderingProviderPhone1;
    }

    public SalesOrderClinicalDetails renderingProviderPhone1(String renderingProviderPhone1) {
        this.setRenderingProviderPhone1(renderingProviderPhone1);
        return this;
    }

    public void setRenderingProviderPhone1(String renderingProviderPhone1) {
        this.renderingProviderPhone1 = renderingProviderPhone1;
    }

    public String getRenderingProviderPhone2() {
        return this.renderingProviderPhone2;
    }

    public SalesOrderClinicalDetails renderingProviderPhone2(String renderingProviderPhone2) {
        this.setRenderingProviderPhone2(renderingProviderPhone2);
        return this;
    }

    public void setRenderingProviderPhone2(String renderingProviderPhone2) {
        this.renderingProviderPhone2 = renderingProviderPhone2;
    }

    public String getRenderingProviderEmail() {
        return this.renderingProviderEmail;
    }

    public SalesOrderClinicalDetails renderingProviderEmail(String renderingProviderEmail) {
        this.setRenderingProviderEmail(renderingProviderEmail);
        return this;
    }

    public void setRenderingProviderEmail(String renderingProviderEmail) {
        this.renderingProviderEmail = renderingProviderEmail;
    }

    public String getRenderingProviderFax() {
        return this.renderingProviderFax;
    }

    public SalesOrderClinicalDetails renderingProviderFax(String renderingProviderFax) {
        this.setRenderingProviderFax(renderingProviderFax);
        return this;
    }

    public void setRenderingProviderFax(String renderingProviderFax) {
        this.renderingProviderFax = renderingProviderFax;
    }

    public String getReferringProviderType() {
        return this.referringProviderType;
    }

    public SalesOrderClinicalDetails referringProviderType(String referringProviderType) {
        this.setReferringProviderType(referringProviderType);
        return this;
    }

    public void setReferringProviderType(String referringProviderType) {
        this.referringProviderType = referringProviderType;
    }

    public Integer getReferringProviderFacilityId() {
        return this.referringProviderFacilityId;
    }

    public SalesOrderClinicalDetails referringProviderFacilityId(Integer referringProviderFacilityId) {
        this.setReferringProviderFacilityId(referringProviderFacilityId);
        return this;
    }

    public void setReferringProviderFacilityId(Integer referringProviderFacilityId) {
        this.referringProviderFacilityId = referringProviderFacilityId;
    }

    public String getReferringProviderFacilityName() {
        return this.referringProviderFacilityName;
    }

    public SalesOrderClinicalDetails referringProviderFacilityName(String referringProviderFacilityName) {
        this.setReferringProviderFacilityName(referringProviderFacilityName);
        return this;
    }

    public void setReferringProviderFacilityName(String referringProviderFacilityName) {
        this.referringProviderFacilityName = referringProviderFacilityName;
    }

    public Integer getReferringProviderId() {
        return this.referringProviderId;
    }

    public SalesOrderClinicalDetails referringProviderId(Integer referringProviderId) {
        this.setReferringProviderId(referringProviderId);
        return this;
    }

    public void setReferringProviderId(Integer referringProviderId) {
        this.referringProviderId = referringProviderId;
    }

    public String getReferringProviderFirstName() {
        return this.referringProviderFirstName;
    }

    public SalesOrderClinicalDetails referringProviderFirstName(String referringProviderFirstName) {
        this.setReferringProviderFirstName(referringProviderFirstName);
        return this;
    }

    public void setReferringProviderFirstName(String referringProviderFirstName) {
        this.referringProviderFirstName = referringProviderFirstName;
    }

    public String getReferringProviderMiddleName() {
        return this.referringProviderMiddleName;
    }

    public SalesOrderClinicalDetails referringProviderMiddleName(String referringProviderMiddleName) {
        this.setReferringProviderMiddleName(referringProviderMiddleName);
        return this;
    }

    public void setReferringProviderMiddleName(String referringProviderMiddleName) {
        this.referringProviderMiddleName = referringProviderMiddleName;
    }

    public String getReferringProviderLastName() {
        return this.referringProviderLastName;
    }

    public SalesOrderClinicalDetails referringProviderLastName(String referringProviderLastName) {
        this.setReferringProviderLastName(referringProviderLastName);
        return this;
    }

    public void setReferringProviderLastName(String referringProviderLastName) {
        this.referringProviderLastName = referringProviderLastName;
    }

    public String getReferringProviderNpi() {
        return this.referringProviderNpi;
    }

    public SalesOrderClinicalDetails referringProviderNpi(String referringProviderNpi) {
        this.setReferringProviderNpi(referringProviderNpi);
        return this;
    }

    public void setReferringProviderNpi(String referringProviderNpi) {
        this.referringProviderNpi = referringProviderNpi;
    }

    public String getReferringProviderDea() {
        return this.referringProviderDea;
    }

    public SalesOrderClinicalDetails referringProviderDea(String referringProviderDea) {
        this.setReferringProviderDea(referringProviderDea);
        return this;
    }

    public void setReferringProviderDea(String referringProviderDea) {
        this.referringProviderDea = referringProviderDea;
    }

    public Integer getReferringProviderAddressId() {
        return this.referringProviderAddressId;
    }

    public SalesOrderClinicalDetails referringProviderAddressId(Integer referringProviderAddressId) {
        this.setReferringProviderAddressId(referringProviderAddressId);
        return this;
    }

    public void setReferringProviderAddressId(Integer referringProviderAddressId) {
        this.referringProviderAddressId = referringProviderAddressId;
    }

    public String getReferringProviderAddressLine1() {
        return this.referringProviderAddressLine1;
    }

    public SalesOrderClinicalDetails referringProviderAddressLine1(String referringProviderAddressLine1) {
        this.setReferringProviderAddressLine1(referringProviderAddressLine1);
        return this;
    }

    public void setReferringProviderAddressLine1(String referringProviderAddressLine1) {
        this.referringProviderAddressLine1 = referringProviderAddressLine1;
    }

    public String getReferringProviderAddressLine2() {
        return this.referringProviderAddressLine2;
    }

    public SalesOrderClinicalDetails referringProviderAddressLine2(String referringProviderAddressLine2) {
        this.setReferringProviderAddressLine2(referringProviderAddressLine2);
        return this;
    }

    public void setReferringProviderAddressLine2(String referringProviderAddressLine2) {
        this.referringProviderAddressLine2 = referringProviderAddressLine2;
    }

    public String getReferringProviderCityName() {
        return this.referringProviderCityName;
    }

    public SalesOrderClinicalDetails referringProviderCityName(String referringProviderCityName) {
        this.setReferringProviderCityName(referringProviderCityName);
        return this;
    }

    public void setReferringProviderCityName(String referringProviderCityName) {
        this.referringProviderCityName = referringProviderCityName;
    }

    public String getReferringProviderStateName() {
        return this.referringProviderStateName;
    }

    public SalesOrderClinicalDetails referringProviderStateName(String referringProviderStateName) {
        this.setReferringProviderStateName(referringProviderStateName);
        return this;
    }

    public void setReferringProviderStateName(String referringProviderStateName) {
        this.referringProviderStateName = referringProviderStateName;
    }

    public String getReferringProviderZip() {
        return this.referringProviderZip;
    }

    public SalesOrderClinicalDetails referringProviderZip(String referringProviderZip) {
        this.setReferringProviderZip(referringProviderZip);
        return this;
    }

    public void setReferringProviderZip(String referringProviderZip) {
        this.referringProviderZip = referringProviderZip;
    }

    public Integer getReferringProviderContactId() {
        return this.referringProviderContactId;
    }

    public SalesOrderClinicalDetails referringProviderContactId(Integer referringProviderContactId) {
        this.setReferringProviderContactId(referringProviderContactId);
        return this;
    }

    public void setReferringProviderContactId(Integer referringProviderContactId) {
        this.referringProviderContactId = referringProviderContactId;
    }

    public String getReferringProviderPhone1() {
        return this.referringProviderPhone1;
    }

    public SalesOrderClinicalDetails referringProviderPhone1(String referringProviderPhone1) {
        this.setReferringProviderPhone1(referringProviderPhone1);
        return this;
    }

    public void setReferringProviderPhone1(String referringProviderPhone1) {
        this.referringProviderPhone1 = referringProviderPhone1;
    }

    public String getReferringProviderPhone2() {
        return this.referringProviderPhone2;
    }

    public SalesOrderClinicalDetails referringProviderPhone2(String referringProviderPhone2) {
        this.setReferringProviderPhone2(referringProviderPhone2);
        return this;
    }

    public void setReferringProviderPhone2(String referringProviderPhone2) {
        this.referringProviderPhone2 = referringProviderPhone2;
    }

    public String getReferringProviderEmail() {
        return this.referringProviderEmail;
    }

    public SalesOrderClinicalDetails referringProviderEmail(String referringProviderEmail) {
        this.setReferringProviderEmail(referringProviderEmail);
        return this;
    }

    public void setReferringProviderEmail(String referringProviderEmail) {
        this.referringProviderEmail = referringProviderEmail;
    }

    public String getReferringProviderFax() {
        return this.referringProviderFax;
    }

    public SalesOrderClinicalDetails referringProviderFax(String referringProviderFax) {
        this.setReferringProviderFax(referringProviderFax);
        return this;
    }

    public void setReferringProviderFax(String referringProviderFax) {
        this.referringProviderFax = referringProviderFax;
    }

    public String getOrderingProviderType() {
        return this.orderingProviderType;
    }

    public SalesOrderClinicalDetails orderingProviderType(String orderingProviderType) {
        this.setOrderingProviderType(orderingProviderType);
        return this;
    }

    public void setOrderingProviderType(String orderingProviderType) {
        this.orderingProviderType = orderingProviderType;
    }

    public Integer getOrderingProviderFacilityId() {
        return this.orderingProviderFacilityId;
    }

    public SalesOrderClinicalDetails orderingProviderFacilityId(Integer orderingProviderFacilityId) {
        this.setOrderingProviderFacilityId(orderingProviderFacilityId);
        return this;
    }

    public void setOrderingProviderFacilityId(Integer orderingProviderFacilityId) {
        this.orderingProviderFacilityId = orderingProviderFacilityId;
    }

    public String getOrderingProviderFacilityName() {
        return this.orderingProviderFacilityName;
    }

    public SalesOrderClinicalDetails orderingProviderFacilityName(String orderingProviderFacilityName) {
        this.setOrderingProviderFacilityName(orderingProviderFacilityName);
        return this;
    }

    public void setOrderingProviderFacilityName(String orderingProviderFacilityName) {
        this.orderingProviderFacilityName = orderingProviderFacilityName;
    }

    public Integer getOrderingProviderId() {
        return this.orderingProviderId;
    }

    public SalesOrderClinicalDetails orderingProviderId(Integer orderingProviderId) {
        this.setOrderingProviderId(orderingProviderId);
        return this;
    }

    public void setOrderingProviderId(Integer orderingProviderId) {
        this.orderingProviderId = orderingProviderId;
    }

    public String getOrderingProviderFirstName() {
        return this.orderingProviderFirstName;
    }

    public SalesOrderClinicalDetails orderingProviderFirstName(String orderingProviderFirstName) {
        this.setOrderingProviderFirstName(orderingProviderFirstName);
        return this;
    }

    public void setOrderingProviderFirstName(String orderingProviderFirstName) {
        this.orderingProviderFirstName = orderingProviderFirstName;
    }

    public String getOrderingProviderMiddleName() {
        return this.orderingProviderMiddleName;
    }

    public SalesOrderClinicalDetails orderingProviderMiddleName(String orderingProviderMiddleName) {
        this.setOrderingProviderMiddleName(orderingProviderMiddleName);
        return this;
    }

    public void setOrderingProviderMiddleName(String orderingProviderMiddleName) {
        this.orderingProviderMiddleName = orderingProviderMiddleName;
    }

    public String getOrderingProviderLastName() {
        return this.orderingProviderLastName;
    }

    public SalesOrderClinicalDetails orderingProviderLastName(String orderingProviderLastName) {
        this.setOrderingProviderLastName(orderingProviderLastName);
        return this;
    }

    public void setOrderingProviderLastName(String orderingProviderLastName) {
        this.orderingProviderLastName = orderingProviderLastName;
    }

    public String getOrderingProviderNpi() {
        return this.orderingProviderNpi;
    }

    public SalesOrderClinicalDetails orderingProviderNpi(String orderingProviderNpi) {
        this.setOrderingProviderNpi(orderingProviderNpi);
        return this;
    }

    public void setOrderingProviderNpi(String orderingProviderNpi) {
        this.orderingProviderNpi = orderingProviderNpi;
    }

    public String getOrderingProviderDea() {
        return this.orderingProviderDea;
    }

    public SalesOrderClinicalDetails orderingProviderDea(String orderingProviderDea) {
        this.setOrderingProviderDea(orderingProviderDea);
        return this;
    }

    public void setOrderingProviderDea(String orderingProviderDea) {
        this.orderingProviderDea = orderingProviderDea;
    }

    public Integer getOrderingProviderAddressId() {
        return this.orderingProviderAddressId;
    }

    public SalesOrderClinicalDetails orderingProviderAddressId(Integer orderingProviderAddressId) {
        this.setOrderingProviderAddressId(orderingProviderAddressId);
        return this;
    }

    public void setOrderingProviderAddressId(Integer orderingProviderAddressId) {
        this.orderingProviderAddressId = orderingProviderAddressId;
    }

    public String getOrderingProviderAddressLine1() {
        return this.orderingProviderAddressLine1;
    }

    public SalesOrderClinicalDetails orderingProviderAddressLine1(String orderingProviderAddressLine1) {
        this.setOrderingProviderAddressLine1(orderingProviderAddressLine1);
        return this;
    }

    public void setOrderingProviderAddressLine1(String orderingProviderAddressLine1) {
        this.orderingProviderAddressLine1 = orderingProviderAddressLine1;
    }

    public String getOrderingProviderAddressLine2() {
        return this.orderingProviderAddressLine2;
    }

    public SalesOrderClinicalDetails orderingProviderAddressLine2(String orderingProviderAddressLine2) {
        this.setOrderingProviderAddressLine2(orderingProviderAddressLine2);
        return this;
    }

    public void setOrderingProviderAddressLine2(String orderingProviderAddressLine2) {
        this.orderingProviderAddressLine2 = orderingProviderAddressLine2;
    }

    public String getOrderingProviderCityName() {
        return this.orderingProviderCityName;
    }

    public SalesOrderClinicalDetails orderingProviderCityName(String orderingProviderCityName) {
        this.setOrderingProviderCityName(orderingProviderCityName);
        return this;
    }

    public void setOrderingProviderCityName(String orderingProviderCityName) {
        this.orderingProviderCityName = orderingProviderCityName;
    }

    public String getOrderingProviderStateName() {
        return this.orderingProviderStateName;
    }

    public SalesOrderClinicalDetails orderingProviderStateName(String orderingProviderStateName) {
        this.setOrderingProviderStateName(orderingProviderStateName);
        return this;
    }

    public void setOrderingProviderStateName(String orderingProviderStateName) {
        this.orderingProviderStateName = orderingProviderStateName;
    }

    public String getOrderingProviderZip() {
        return this.orderingProviderZip;
    }

    public SalesOrderClinicalDetails orderingProviderZip(String orderingProviderZip) {
        this.setOrderingProviderZip(orderingProviderZip);
        return this;
    }

    public void setOrderingProviderZip(String orderingProviderZip) {
        this.orderingProviderZip = orderingProviderZip;
    }

    public Integer getOrderingProviderContactId() {
        return this.orderingProviderContactId;
    }

    public SalesOrderClinicalDetails orderingProviderContactId(Integer orderingProviderContactId) {
        this.setOrderingProviderContactId(orderingProviderContactId);
        return this;
    }

    public void setOrderingProviderContactId(Integer orderingProviderContactId) {
        this.orderingProviderContactId = orderingProviderContactId;
    }

    public String getOrderingProviderPhone1() {
        return this.orderingProviderPhone1;
    }

    public SalesOrderClinicalDetails orderingProviderPhone1(String orderingProviderPhone1) {
        this.setOrderingProviderPhone1(orderingProviderPhone1);
        return this;
    }

    public void setOrderingProviderPhone1(String orderingProviderPhone1) {
        this.orderingProviderPhone1 = orderingProviderPhone1;
    }

    public String getOrderingProviderPhone2() {
        return this.orderingProviderPhone2;
    }

    public SalesOrderClinicalDetails orderingProviderPhone2(String orderingProviderPhone2) {
        this.setOrderingProviderPhone2(orderingProviderPhone2);
        return this;
    }

    public void setOrderingProviderPhone2(String orderingProviderPhone2) {
        this.orderingProviderPhone2 = orderingProviderPhone2;
    }

    public String getOrderingProviderEmail() {
        return this.orderingProviderEmail;
    }

    public SalesOrderClinicalDetails orderingProviderEmail(String orderingProviderEmail) {
        this.setOrderingProviderEmail(orderingProviderEmail);
        return this;
    }

    public void setOrderingProviderEmail(String orderingProviderEmail) {
        this.orderingProviderEmail = orderingProviderEmail;
    }

    public String getOrderingProviderFax() {
        return this.orderingProviderFax;
    }

    public SalesOrderClinicalDetails orderingProviderFax(String orderingProviderFax) {
        this.setOrderingProviderFax(orderingProviderFax);
        return this;
    }

    public void setOrderingProviderFax(String orderingProviderFax) {
        this.orderingProviderFax = orderingProviderFax;
    }

    public Integer getMarketingReferalTypeId() {
        return this.marketingReferalTypeId;
    }

    public SalesOrderClinicalDetails marketingReferalTypeId(Integer marketingReferalTypeId) {
        this.setMarketingReferalTypeId(marketingReferalTypeId);
        return this;
    }

    public void setMarketingReferalTypeId(Integer marketingReferalTypeId) {
        this.marketingReferalTypeId = marketingReferalTypeId;
    }

    public String getMarketingReferalTypeDescription() {
        return this.marketingReferalTypeDescription;
    }

    public SalesOrderClinicalDetails marketingReferalTypeDescription(String marketingReferalTypeDescription) {
        this.setMarketingReferalTypeDescription(marketingReferalTypeDescription);
        return this;
    }

    public void setMarketingReferalTypeDescription(String marketingReferalTypeDescription) {
        this.marketingReferalTypeDescription = marketingReferalTypeDescription;
    }

    public Integer getMarketingReferalId() {
        return this.marketingReferalId;
    }

    public SalesOrderClinicalDetails marketingReferalId(Integer marketingReferalId) {
        this.setMarketingReferalId(marketingReferalId);
        return this;
    }

    public void setMarketingReferalId(Integer marketingReferalId) {
        this.marketingReferalId = marketingReferalId;
    }

    public String getMarketingReferalName() {
        return this.marketingReferalName;
    }

    public SalesOrderClinicalDetails marketingReferalName(String marketingReferalName) {
        this.setMarketingReferalName(marketingReferalName);
        return this;
    }

    public void setMarketingReferalName(String marketingReferalName) {
        this.marketingReferalName = marketingReferalName;
    }

    public String getIcd10DiagnosisCode1() {
        return this.icd10DiagnosisCode1;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode1(String icd10DiagnosisCode1) {
        this.setIcd10DiagnosisCode1(icd10DiagnosisCode1);
        return this;
    }

    public void setIcd10DiagnosisCode1(String icd10DiagnosisCode1) {
        this.icd10DiagnosisCode1 = icd10DiagnosisCode1;
    }

    public String getIcd10DiagnosisCode2() {
        return this.icd10DiagnosisCode2;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode2(String icd10DiagnosisCode2) {
        this.setIcd10DiagnosisCode2(icd10DiagnosisCode2);
        return this;
    }

    public void setIcd10DiagnosisCode2(String icd10DiagnosisCode2) {
        this.icd10DiagnosisCode2 = icd10DiagnosisCode2;
    }

    public String getIcd10DiagnosisCode3() {
        return this.icd10DiagnosisCode3;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode3(String icd10DiagnosisCode3) {
        this.setIcd10DiagnosisCode3(icd10DiagnosisCode3);
        return this;
    }

    public void setIcd10DiagnosisCode3(String icd10DiagnosisCode3) {
        this.icd10DiagnosisCode3 = icd10DiagnosisCode3;
    }

    public String getIcd10DiagnosisCode4() {
        return this.icd10DiagnosisCode4;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode4(String icd10DiagnosisCode4) {
        this.setIcd10DiagnosisCode4(icd10DiagnosisCode4);
        return this;
    }

    public void setIcd10DiagnosisCode4(String icd10DiagnosisCode4) {
        this.icd10DiagnosisCode4 = icd10DiagnosisCode4;
    }

    public String getIcd10DiagnosisCode5() {
        return this.icd10DiagnosisCode5;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode5(String icd10DiagnosisCode5) {
        this.setIcd10DiagnosisCode5(icd10DiagnosisCode5);
        return this;
    }

    public void setIcd10DiagnosisCode5(String icd10DiagnosisCode5) {
        this.icd10DiagnosisCode5 = icd10DiagnosisCode5;
    }

    public String getIcd10DiagnosisCode6() {
        return this.icd10DiagnosisCode6;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode6(String icd10DiagnosisCode6) {
        this.setIcd10DiagnosisCode6(icd10DiagnosisCode6);
        return this;
    }

    public void setIcd10DiagnosisCode6(String icd10DiagnosisCode6) {
        this.icd10DiagnosisCode6 = icd10DiagnosisCode6;
    }

    public String getIcd10DiagnosisCode7() {
        return this.icd10DiagnosisCode7;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode7(String icd10DiagnosisCode7) {
        this.setIcd10DiagnosisCode7(icd10DiagnosisCode7);
        return this;
    }

    public void setIcd10DiagnosisCode7(String icd10DiagnosisCode7) {
        this.icd10DiagnosisCode7 = icd10DiagnosisCode7;
    }

    public String getIcd10DiagnosisCode8() {
        return this.icd10DiagnosisCode8;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode8(String icd10DiagnosisCode8) {
        this.setIcd10DiagnosisCode8(icd10DiagnosisCode8);
        return this;
    }

    public void setIcd10DiagnosisCode8(String icd10DiagnosisCode8) {
        this.icd10DiagnosisCode8 = icd10DiagnosisCode8;
    }

    public String getIcd10DiagnosisCode9() {
        return this.icd10DiagnosisCode9;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode9(String icd10DiagnosisCode9) {
        this.setIcd10DiagnosisCode9(icd10DiagnosisCode9);
        return this;
    }

    public void setIcd10DiagnosisCode9(String icd10DiagnosisCode9) {
        this.icd10DiagnosisCode9 = icd10DiagnosisCode9;
    }

    public String getIcd10DiagnosisCode10() {
        return this.icd10DiagnosisCode10;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode10(String icd10DiagnosisCode10) {
        this.setIcd10DiagnosisCode10(icd10DiagnosisCode10);
        return this;
    }

    public void setIcd10DiagnosisCode10(String icd10DiagnosisCode10) {
        this.icd10DiagnosisCode10 = icd10DiagnosisCode10;
    }

    public String getIcd10DiagnosisCode11() {
        return this.icd10DiagnosisCode11;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode11(String icd10DiagnosisCode11) {
        this.setIcd10DiagnosisCode11(icd10DiagnosisCode11);
        return this;
    }

    public void setIcd10DiagnosisCode11(String icd10DiagnosisCode11) {
        this.icd10DiagnosisCode11 = icd10DiagnosisCode11;
    }

    public String getIcd10DiagnosisCode12() {
        return this.icd10DiagnosisCode12;
    }

    public SalesOrderClinicalDetails icd10DiagnosisCode12(String icd10DiagnosisCode12) {
        this.setIcd10DiagnosisCode12(icd10DiagnosisCode12);
        return this;
    }

    public void setIcd10DiagnosisCode12(String icd10DiagnosisCode12) {
        this.icd10DiagnosisCode12 = icd10DiagnosisCode12;
    }

    public String getEpsdtCertificationConditionIndicator() {
        return this.epsdtCertificationConditionIndicator;
    }

    public SalesOrderClinicalDetails epsdtCertificationConditionIndicator(String epsdtCertificationConditionIndicator) {
        this.setEpsdtCertificationConditionIndicator(epsdtCertificationConditionIndicator);
        return this;
    }

    public void setEpsdtCertificationConditionIndicator(String epsdtCertificationConditionIndicator) {
        this.epsdtCertificationConditionIndicator = epsdtCertificationConditionIndicator;
    }

    public String getEpsdtCertificationCode() {
        return this.epsdtCertificationCode;
    }

    public SalesOrderClinicalDetails epsdtCertificationCode(String epsdtCertificationCode) {
        this.setEpsdtCertificationCode(epsdtCertificationCode);
        return this;
    }

    public void setEpsdtCertificationCode(String epsdtCertificationCode) {
        this.epsdtCertificationCode = epsdtCertificationCode;
    }

    public String getStatus() {
        return this.status;
    }

    public SalesOrderClinicalDetails status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return this.createdById;
    }

    public SalesOrderClinicalDetails createdById(Integer createdById) {
        this.setCreatedById(createdById);
        return this;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return this.createdByName;
    }

    public SalesOrderClinicalDetails createdByName(String createdByName) {
        this.setCreatedByName(createdByName);
        return this;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public SalesOrderClinicalDetails createdDate(ZonedDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedById() {
        return this.updatedById;
    }

    public SalesOrderClinicalDetails updatedById(Integer updatedById) {
        this.setUpdatedById(updatedById);
        return this;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return this.updatedByName;
    }

    public SalesOrderClinicalDetails updatedByName(String updatedByName) {
        this.setUpdatedByName(updatedByName);
        return this;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public SalesOrderClinicalDetails updatedDate(ZonedDateTime updatedDate) {
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
        return "SalesOrderClinicalDetails{" +
            ", salesOderClinicalDetailsId=" + getSalesOderClinicalDetailsId() +
            ", salesOderId=" + getSalesOderId() +
            ", patientId=" + getPatientId() +
            ", patientWeightInKg=" + getPatientWeightInKg() +
            ", patientWeightInLbs=" + getPatientWeightInLbs() +
            ", heightInInches=" + getHeightInInches() +
            ", heightInCm=" + getHeightInCm() +
            ", salesRepId=" + getSalesRepId() +
            ", salesepName='" + getSalesepName() + "'" +
            ", practitionerId=" + getPractitionerId() +
            ", renderingProviderType='" + getRenderingProviderType() + "'" +
            ", renderingProviderFacilityId=" + getRenderingProviderFacilityId() +
            ", renderingProviderFacilityName='" + getRenderingProviderFacilityName() + "'" +
            ", renderingProviderId=" + getRenderingProviderId() +
            ", renderingProviderFirstName='" + getRenderingProviderFirstName() + "'" +
            ", renderingProviderMiddleName='" + getRenderingProviderMiddleName() + "'" +
            ", renderingProviderLastName='" + getRenderingProviderLastName() + "'" +
            ", renderingProviderNpi='" + getRenderingProviderNpi() + "'" +
            ", renderingProviderDea='" + getRenderingProviderDea() + "'" +
            ", renderingProviderAddressId=" + getRenderingProviderAddressId() +
            ", renderingProviderAddressLine1='" + getRenderingProviderAddressLine1() + "'" +
            ", renderingProviderAddressLine2='" + getRenderingProviderAddressLine2() + "'" +
            ", renderingProviderCityName='" + getRenderingProviderCityName() + "'" +
            ", renderingProviderStateName='" + getRenderingProviderStateName() + "'" +
            ", renderingProviderZip='" + getRenderingProviderZip() + "'" +
            ", renderingProviderContactId=" + getRenderingProviderContactId() +
            ", renderingProviderPhone1='" + getRenderingProviderPhone1() + "'" +
            ", renderingProviderPhone2='" + getRenderingProviderPhone2() + "'" +
            ", renderingProviderEmail='" + getRenderingProviderEmail() + "'" +
            ", renderingProviderFax='" + getRenderingProviderFax() + "'" +
            ", referringProviderType='" + getReferringProviderType() + "'" +
            ", referringProviderFacilityId=" + getReferringProviderFacilityId() +
            ", referringProviderFacilityName='" + getReferringProviderFacilityName() + "'" +
            ", referringProviderId=" + getReferringProviderId() +
            ", referringProviderFirstName='" + getReferringProviderFirstName() + "'" +
            ", referringProviderMiddleName='" + getReferringProviderMiddleName() + "'" +
            ", referringProviderLastName='" + getReferringProviderLastName() + "'" +
            ", referringProviderNpi='" + getReferringProviderNpi() + "'" +
            ", referringProviderDea='" + getReferringProviderDea() + "'" +
            ", referringProviderAddressId=" + getReferringProviderAddressId() +
            ", referringProviderAddressLine1='" + getReferringProviderAddressLine1() + "'" +
            ", referringProviderAddressLine2='" + getReferringProviderAddressLine2() + "'" +
            ", referringProviderCityName='" + getReferringProviderCityName() + "'" +
            ", referringProviderStateName='" + getReferringProviderStateName() + "'" +
            ", referringProviderZip='" + getReferringProviderZip() + "'" +
            ", referringProviderContactId=" + getReferringProviderContactId() +
            ", referringProviderPhone1='" + getReferringProviderPhone1() + "'" +
            ", referringProviderPhone2='" + getReferringProviderPhone2() + "'" +
            ", referringProviderEmail='" + getReferringProviderEmail() + "'" +
            ", referringProviderFax='" + getReferringProviderFax() + "'" +
            ", orderingProviderType='" + getOrderingProviderType() + "'" +
            ", orderingProviderFacilityId=" + getOrderingProviderFacilityId() +
            ", orderingProviderFacilityName='" + getOrderingProviderFacilityName() + "'" +
            ", orderingProviderId=" + getOrderingProviderId() +
            ", orderingProviderFirstName='" + getOrderingProviderFirstName() + "'" +
            ", orderingProviderMiddleName='" + getOrderingProviderMiddleName() + "'" +
            ", orderingProviderLastName='" + getOrderingProviderLastName() + "'" +
            ", orderingProviderNpi='" + getOrderingProviderNpi() + "'" +
            ", orderingProviderDea='" + getOrderingProviderDea() + "'" +
            ", orderingProviderAddressId=" + getOrderingProviderAddressId() +
            ", orderingProviderAddressLine1='" + getOrderingProviderAddressLine1() + "'" +
            ", orderingProviderAddressLine2='" + getOrderingProviderAddressLine2() + "'" +
            ", orderingProviderCityName='" + getOrderingProviderCityName() + "'" +
            ", orderingProviderStateName='" + getOrderingProviderStateName() + "'" +
            ", orderingProviderZip='" + getOrderingProviderZip() + "'" +
            ", orderingProviderContactId=" + getOrderingProviderContactId() +
            ", orderingProviderPhone1='" + getOrderingProviderPhone1() + "'" +
            ", orderingProviderPhone2='" + getOrderingProviderPhone2() + "'" +
            ", orderingProviderEmail='" + getOrderingProviderEmail() + "'" +
            ", orderingProviderFax='" + getOrderingProviderFax() + "'" +
            ", marketingReferalTypeId=" + getMarketingReferalTypeId() +
            ", marketingReferalTypeDescription='" + getMarketingReferalTypeDescription() + "'" +
            ", marketingReferalId=" + getMarketingReferalId() +
            ", marketingReferalName='" + getMarketingReferalName() + "'" +
            ", icd10DiagnosisCode1='" + getIcd10DiagnosisCode1() + "'" +
            ", icd10DiagnosisCode2='" + getIcd10DiagnosisCode2() + "'" +
            ", icd10DiagnosisCode3='" + getIcd10DiagnosisCode3() + "'" +
            ", icd10DiagnosisCode4='" + getIcd10DiagnosisCode4() + "'" +
            ", icd10DiagnosisCode5='" + getIcd10DiagnosisCode5() + "'" +
            ", icd10DiagnosisCode6='" + getIcd10DiagnosisCode6() + "'" +
            ", icd10DiagnosisCode7='" + getIcd10DiagnosisCode7() + "'" +
            ", icd10DiagnosisCode8='" + getIcd10DiagnosisCode8() + "'" +
            ", icd10DiagnosisCode9='" + getIcd10DiagnosisCode9() + "'" +
            ", icd10DiagnosisCode10='" + getIcd10DiagnosisCode10() + "'" +
            ", icd10DiagnosisCode11='" + getIcd10DiagnosisCode11() + "'" +
            ", icd10DiagnosisCode12='" + getIcd10DiagnosisCode12() + "'" +
            ", epsdtCertificationConditionIndicator='" + getEpsdtCertificationConditionIndicator() + "'" +
            ", epsdtCertificationCode='" + getEpsdtCertificationCode() + "'" +
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
