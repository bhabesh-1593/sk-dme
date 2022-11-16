package com.sunknowledge.dme.rcm.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.sunknowledge.dme.rcm.domain.SalesOrderClinicalDetails} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesOrderClinicalDetailsDTO implements Serializable {

    private Long salesOderClinicalDetailsId;

    @NotNull(message = "must not be null")
    private Long salesOrderId;

    @NotNull(message = "must not be null")
    private Integer patientId;

    private Double patientWeightInKg;

    private Double patientWeightInLbs;

    private Double heightInInches;

    private Double heightInCm;

    private Integer salesRepId;

    @NotNull(message = "must not be null")
    private String salesepName;

    private Integer practitionerId;

    private String renderingProviderType;

    private Integer renderingProviderFacilityId;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String renderingProviderFacilityName;

    @NotNull(message = "must not be null")
    private Integer renderingProviderId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String renderingProviderFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String renderingProviderMiddleName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String renderingProviderLastName;

    @NotNull(message = "must not be null")
    private String renderingProviderNpi;

    @NotNull(message = "must not be null")
    private String renderingProviderDea;

    @NotNull(message = "must not be null")
    private Integer renderingProviderAddressId;

    private String renderingProviderAddressLine1;

    private String renderingProviderAddressLine2;

    private String renderingProviderCityName;

    private String renderingProviderStateName;

    private String renderingProviderZip;

    @NotNull(message = "must not be null")
    private Integer renderingProviderContactId;

    private String renderingProviderPhone1;

    private String renderingProviderPhone2;

    private String renderingProviderEmail;

    private String renderingProviderFax;

    private String referringProviderType;

    private Integer referringProviderFacilityId;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String referringProviderFacilityName;

    @NotNull(message = "must not be null")
    private Integer referringProviderId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String referringProviderFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String referringProviderMiddleName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String referringProviderLastName;

    @NotNull(message = "must not be null")
    private String referringProviderNpi;

    @NotNull(message = "must not be null")
    private String referringProviderDea;

    @NotNull(message = "must not be null")
    private Integer referringProviderAddressId;

    private String referringProviderAddressLine1;

    private String referringProviderAddressLine2;

    private String referringProviderCityName;

    private String referringProviderStateName;

    private String referringProviderZip;

    @NotNull(message = "must not be null")
    private Integer referringProviderContactId;

    private String referringProviderPhone1;

    private String referringProviderPhone2;

    private String referringProviderEmail;

    private String referringProviderFax;

    private String orderingProviderType;

    private Integer orderingProviderFacilityId;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String orderingProviderFacilityName;

    @NotNull(message = "must not be null")
    private Integer orderingProviderId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String orderingProviderFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String orderingProviderMiddleName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String orderingProviderLastName;

    @NotNull(message = "must not be null")
    private String orderingProviderNpi;

    @NotNull(message = "must not be null")
    private String orderingProviderDea;

    @NotNull(message = "must not be null")
    private Integer orderingProviderAddressId;

    private String orderingProviderAddressLine1;

    private String orderingProviderAddressLine2;

    private String orderingProviderCityName;

    private String orderingProviderStateName;

    private String orderingProviderZip;

    @NotNull(message = "must not be null")
    private Integer orderingProviderContactId;

    private String orderingProviderPhone1;

    private String orderingProviderPhone2;

    private String orderingProviderEmail;

    private String orderingProviderFax;

    private Integer marketingReferalTypeId;

    private String marketingReferalTypeDescription;

    private Integer marketingReferalId;

    @NotNull(message = "must not be null")
    private String marketingReferalName;

    private String icd10DiagnosisCode1;

    private String icd10DiagnosisCode2;

    private String icd10DiagnosisCode3;

    private String icd10DiagnosisCode4;

    private String icd10DiagnosisCode5;

    private String icd10DiagnosisCode6;

    private String icd10DiagnosisCode7;

    private String icd10DiagnosisCode8;

    private String icd10DiagnosisCode9;

    private String icd10DiagnosisCode10;

    private String icd10DiagnosisCode11;

    private String icd10DiagnosisCode12;

    private String epsdtCertificationConditionIndicator;

    private String epsdtCertificationCode;

    private String status;

    private Integer createdById;

    private String createdByName;

    private ZonedDateTime createdDate;

    private Integer updatedById;

    private String updatedByName;

    private ZonedDateTime updatedDate;

    private SalesOrderMasterDTO salesOrderMaster;

    public Long getSalesOderClinicalDetailsId() {
        return salesOderClinicalDetailsId;
    }

    public void setSalesOderClinicalDetailsId(Long salesOderClinicalDetailsId) {
        this.salesOderClinicalDetailsId = salesOderClinicalDetailsId;
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

    public Double getPatientWeightInKg() {
        return patientWeightInKg;
    }

    public void setPatientWeightInKg(Double patientWeightInKg) {
        this.patientWeightInKg = patientWeightInKg;
    }

    public Double getPatientWeightInLbs() {
        return patientWeightInLbs;
    }

    public void setPatientWeightInLbs(Double patientWeightInLbs) {
        this.patientWeightInLbs = patientWeightInLbs;
    }

    public Double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(Double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public Double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public Integer getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String getSalesepName() {
        return salesepName;
    }

    public void setSalesepName(String salesepName) {
        this.salesepName = salesepName;
    }

    public Integer getPractitionerId() {
        return practitionerId;
    }

    public void setPractitionerId(Integer practitionerId) {
        this.practitionerId = practitionerId;
    }

    public String getRenderingProviderType() {
        return renderingProviderType;
    }

    public void setRenderingProviderType(String renderingProviderType) {
        this.renderingProviderType = renderingProviderType;
    }

    public Integer getRenderingProviderFacilityId() {
        return renderingProviderFacilityId;
    }

    public void setRenderingProviderFacilityId(Integer renderingProviderFacilityId) {
        this.renderingProviderFacilityId = renderingProviderFacilityId;
    }

    public String getRenderingProviderFacilityName() {
        return renderingProviderFacilityName;
    }

    public void setRenderingProviderFacilityName(String renderingProviderFacilityName) {
        this.renderingProviderFacilityName = renderingProviderFacilityName;
    }

    public Integer getRenderingProviderId() {
        return renderingProviderId;
    }

    public void setRenderingProviderId(Integer renderingProviderId) {
        this.renderingProviderId = renderingProviderId;
    }

    public String getRenderingProviderFirstName() {
        return renderingProviderFirstName;
    }

    public void setRenderingProviderFirstName(String renderingProviderFirstName) {
        this.renderingProviderFirstName = renderingProviderFirstName;
    }

    public String getRenderingProviderMiddleName() {
        return renderingProviderMiddleName;
    }

    public void setRenderingProviderMiddleName(String renderingProviderMiddleName) {
        this.renderingProviderMiddleName = renderingProviderMiddleName;
    }

    public String getRenderingProviderLastName() {
        return renderingProviderLastName;
    }

    public void setRenderingProviderLastName(String renderingProviderLastName) {
        this.renderingProviderLastName = renderingProviderLastName;
    }

    public String getRenderingProviderNpi() {
        return renderingProviderNpi;
    }

    public void setRenderingProviderNpi(String renderingProviderNpi) {
        this.renderingProviderNpi = renderingProviderNpi;
    }

    public String getRenderingProviderDea() {
        return renderingProviderDea;
    }

    public void setRenderingProviderDea(String renderingProviderDea) {
        this.renderingProviderDea = renderingProviderDea;
    }

    public Integer getRenderingProviderAddressId() {
        return renderingProviderAddressId;
    }

    public void setRenderingProviderAddressId(Integer renderingProviderAddressId) {
        this.renderingProviderAddressId = renderingProviderAddressId;
    }

    public String getRenderingProviderAddressLine1() {
        return renderingProviderAddressLine1;
    }

    public void setRenderingProviderAddressLine1(String renderingProviderAddressLine1) {
        this.renderingProviderAddressLine1 = renderingProviderAddressLine1;
    }

    public String getRenderingProviderAddressLine2() {
        return renderingProviderAddressLine2;
    }

    public void setRenderingProviderAddressLine2(String renderingProviderAddressLine2) {
        this.renderingProviderAddressLine2 = renderingProviderAddressLine2;
    }

    public String getRenderingProviderCityName() {
        return renderingProviderCityName;
    }

    public void setRenderingProviderCityName(String renderingProviderCityName) {
        this.renderingProviderCityName = renderingProviderCityName;
    }

    public String getRenderingProviderStateName() {
        return renderingProviderStateName;
    }

    public void setRenderingProviderStateName(String renderingProviderStateName) {
        this.renderingProviderStateName = renderingProviderStateName;
    }

    public String getRenderingProviderZip() {
        return renderingProviderZip;
    }

    public void setRenderingProviderZip(String renderingProviderZip) {
        this.renderingProviderZip = renderingProviderZip;
    }

    public Integer getRenderingProviderContactId() {
        return renderingProviderContactId;
    }

    public void setRenderingProviderContactId(Integer renderingProviderContactId) {
        this.renderingProviderContactId = renderingProviderContactId;
    }

    public String getRenderingProviderPhone1() {
        return renderingProviderPhone1;
    }

    public void setRenderingProviderPhone1(String renderingProviderPhone1) {
        this.renderingProviderPhone1 = renderingProviderPhone1;
    }

    public String getRenderingProviderPhone2() {
        return renderingProviderPhone2;
    }

    public void setRenderingProviderPhone2(String renderingProviderPhone2) {
        this.renderingProviderPhone2 = renderingProviderPhone2;
    }

    public String getRenderingProviderEmail() {
        return renderingProviderEmail;
    }

    public void setRenderingProviderEmail(String renderingProviderEmail) {
        this.renderingProviderEmail = renderingProviderEmail;
    }

    public String getRenderingProviderFax() {
        return renderingProviderFax;
    }

    public void setRenderingProviderFax(String renderingProviderFax) {
        this.renderingProviderFax = renderingProviderFax;
    }

    public String getReferringProviderType() {
        return referringProviderType;
    }

    public void setReferringProviderType(String referringProviderType) {
        this.referringProviderType = referringProviderType;
    }

    public Integer getReferringProviderFacilityId() {
        return referringProviderFacilityId;
    }

    public void setReferringProviderFacilityId(Integer referringProviderFacilityId) {
        this.referringProviderFacilityId = referringProviderFacilityId;
    }

    public String getReferringProviderFacilityName() {
        return referringProviderFacilityName;
    }

    public void setReferringProviderFacilityName(String referringProviderFacilityName) {
        this.referringProviderFacilityName = referringProviderFacilityName;
    }

    public Integer getReferringProviderId() {
        return referringProviderId;
    }

    public void setReferringProviderId(Integer referringProviderId) {
        this.referringProviderId = referringProviderId;
    }

    public String getReferringProviderFirstName() {
        return referringProviderFirstName;
    }

    public void setReferringProviderFirstName(String referringProviderFirstName) {
        this.referringProviderFirstName = referringProviderFirstName;
    }

    public String getReferringProviderMiddleName() {
        return referringProviderMiddleName;
    }

    public void setReferringProviderMiddleName(String referringProviderMiddleName) {
        this.referringProviderMiddleName = referringProviderMiddleName;
    }

    public String getReferringProviderLastName() {
        return referringProviderLastName;
    }

    public void setReferringProviderLastName(String referringProviderLastName) {
        this.referringProviderLastName = referringProviderLastName;
    }

    public String getReferringProviderNpi() {
        return referringProviderNpi;
    }

    public void setReferringProviderNpi(String referringProviderNpi) {
        this.referringProviderNpi = referringProviderNpi;
    }

    public String getReferringProviderDea() {
        return referringProviderDea;
    }

    public void setReferringProviderDea(String referringProviderDea) {
        this.referringProviderDea = referringProviderDea;
    }

    public Integer getReferringProviderAddressId() {
        return referringProviderAddressId;
    }

    public void setReferringProviderAddressId(Integer referringProviderAddressId) {
        this.referringProviderAddressId = referringProviderAddressId;
    }

    public String getReferringProviderAddressLine1() {
        return referringProviderAddressLine1;
    }

    public void setReferringProviderAddressLine1(String referringProviderAddressLine1) {
        this.referringProviderAddressLine1 = referringProviderAddressLine1;
    }

    public String getReferringProviderAddressLine2() {
        return referringProviderAddressLine2;
    }

    public void setReferringProviderAddressLine2(String referringProviderAddressLine2) {
        this.referringProviderAddressLine2 = referringProviderAddressLine2;
    }

    public String getReferringProviderCityName() {
        return referringProviderCityName;
    }

    public void setReferringProviderCityName(String referringProviderCityName) {
        this.referringProviderCityName = referringProviderCityName;
    }

    public String getReferringProviderStateName() {
        return referringProviderStateName;
    }

    public void setReferringProviderStateName(String referringProviderStateName) {
        this.referringProviderStateName = referringProviderStateName;
    }

    public String getReferringProviderZip() {
        return referringProviderZip;
    }

    public void setReferringProviderZip(String referringProviderZip) {
        this.referringProviderZip = referringProviderZip;
    }

    public Integer getReferringProviderContactId() {
        return referringProviderContactId;
    }

    public void setReferringProviderContactId(Integer referringProviderContactId) {
        this.referringProviderContactId = referringProviderContactId;
    }

    public String getReferringProviderPhone1() {
        return referringProviderPhone1;
    }

    public void setReferringProviderPhone1(String referringProviderPhone1) {
        this.referringProviderPhone1 = referringProviderPhone1;
    }

    public String getReferringProviderPhone2() {
        return referringProviderPhone2;
    }

    public void setReferringProviderPhone2(String referringProviderPhone2) {
        this.referringProviderPhone2 = referringProviderPhone2;
    }

    public String getReferringProviderEmail() {
        return referringProviderEmail;
    }

    public void setReferringProviderEmail(String referringProviderEmail) {
        this.referringProviderEmail = referringProviderEmail;
    }

    public String getReferringProviderFax() {
        return referringProviderFax;
    }

    public void setReferringProviderFax(String referringProviderFax) {
        this.referringProviderFax = referringProviderFax;
    }

    public String getOrderingProviderType() {
        return orderingProviderType;
    }

    public void setOrderingProviderType(String orderingProviderType) {
        this.orderingProviderType = orderingProviderType;
    }

    public Integer getOrderingProviderFacilityId() {
        return orderingProviderFacilityId;
    }

    public void setOrderingProviderFacilityId(Integer orderingProviderFacilityId) {
        this.orderingProviderFacilityId = orderingProviderFacilityId;
    }

    public String getOrderingProviderFacilityName() {
        return orderingProviderFacilityName;
    }

    public void setOrderingProviderFacilityName(String orderingProviderFacilityName) {
        this.orderingProviderFacilityName = orderingProviderFacilityName;
    }

    public Integer getOrderingProviderId() {
        return orderingProviderId;
    }

    public void setOrderingProviderId(Integer orderingProviderId) {
        this.orderingProviderId = orderingProviderId;
    }

    public String getOrderingProviderFirstName() {
        return orderingProviderFirstName;
    }

    public void setOrderingProviderFirstName(String orderingProviderFirstName) {
        this.orderingProviderFirstName = orderingProviderFirstName;
    }

    public String getOrderingProviderMiddleName() {
        return orderingProviderMiddleName;
    }

    public void setOrderingProviderMiddleName(String orderingProviderMiddleName) {
        this.orderingProviderMiddleName = orderingProviderMiddleName;
    }

    public String getOrderingProviderLastName() {
        return orderingProviderLastName;
    }

    public void setOrderingProviderLastName(String orderingProviderLastName) {
        this.orderingProviderLastName = orderingProviderLastName;
    }

    public String getOrderingProviderNpi() {
        return orderingProviderNpi;
    }

    public void setOrderingProviderNpi(String orderingProviderNpi) {
        this.orderingProviderNpi = orderingProviderNpi;
    }

    public String getOrderingProviderDea() {
        return orderingProviderDea;
    }

    public void setOrderingProviderDea(String orderingProviderDea) {
        this.orderingProviderDea = orderingProviderDea;
    }

    public Integer getOrderingProviderAddressId() {
        return orderingProviderAddressId;
    }

    public void setOrderingProviderAddressId(Integer orderingProviderAddressId) {
        this.orderingProviderAddressId = orderingProviderAddressId;
    }

    public String getOrderingProviderAddressLine1() {
        return orderingProviderAddressLine1;
    }

    public void setOrderingProviderAddressLine1(String orderingProviderAddressLine1) {
        this.orderingProviderAddressLine1 = orderingProviderAddressLine1;
    }

    public String getOrderingProviderAddressLine2() {
        return orderingProviderAddressLine2;
    }

    public void setOrderingProviderAddressLine2(String orderingProviderAddressLine2) {
        this.orderingProviderAddressLine2 = orderingProviderAddressLine2;
    }

    public String getOrderingProviderCityName() {
        return orderingProviderCityName;
    }

    public void setOrderingProviderCityName(String orderingProviderCityName) {
        this.orderingProviderCityName = orderingProviderCityName;
    }

    public String getOrderingProviderStateName() {
        return orderingProviderStateName;
    }

    public void setOrderingProviderStateName(String orderingProviderStateName) {
        this.orderingProviderStateName = orderingProviderStateName;
    }

    public String getOrderingProviderZip() {
        return orderingProviderZip;
    }

    public void setOrderingProviderZip(String orderingProviderZip) {
        this.orderingProviderZip = orderingProviderZip;
    }

    public Integer getOrderingProviderContactId() {
        return orderingProviderContactId;
    }

    public void setOrderingProviderContactId(Integer orderingProviderContactId) {
        this.orderingProviderContactId = orderingProviderContactId;
    }

    public String getOrderingProviderPhone1() {
        return orderingProviderPhone1;
    }

    public void setOrderingProviderPhone1(String orderingProviderPhone1) {
        this.orderingProviderPhone1 = orderingProviderPhone1;
    }

    public String getOrderingProviderPhone2() {
        return orderingProviderPhone2;
    }

    public void setOrderingProviderPhone2(String orderingProviderPhone2) {
        this.orderingProviderPhone2 = orderingProviderPhone2;
    }

    public String getOrderingProviderEmail() {
        return orderingProviderEmail;
    }

    public void setOrderingProviderEmail(String orderingProviderEmail) {
        this.orderingProviderEmail = orderingProviderEmail;
    }

    public String getOrderingProviderFax() {
        return orderingProviderFax;
    }

    public void setOrderingProviderFax(String orderingProviderFax) {
        this.orderingProviderFax = orderingProviderFax;
    }

    public Integer getMarketingReferalTypeId() {
        return marketingReferalTypeId;
    }

    public void setMarketingReferalTypeId(Integer marketingReferalTypeId) {
        this.marketingReferalTypeId = marketingReferalTypeId;
    }

    public String getMarketingReferalTypeDescription() {
        return marketingReferalTypeDescription;
    }

    public void setMarketingReferalTypeDescription(String marketingReferalTypeDescription) {
        this.marketingReferalTypeDescription = marketingReferalTypeDescription;
    }

    public Integer getMarketingReferalId() {
        return marketingReferalId;
    }

    public void setMarketingReferalId(Integer marketingReferalId) {
        this.marketingReferalId = marketingReferalId;
    }

    public String getMarketingReferalName() {
        return marketingReferalName;
    }

    public void setMarketingReferalName(String marketingReferalName) {
        this.marketingReferalName = marketingReferalName;
    }

    public String getIcd10DiagnosisCode1() {
        return icd10DiagnosisCode1;
    }

    public void setIcd10DiagnosisCode1(String icd10DiagnosisCode1) {
        this.icd10DiagnosisCode1 = icd10DiagnosisCode1;
    }

    public String getIcd10DiagnosisCode2() {
        return icd10DiagnosisCode2;
    }

    public void setIcd10DiagnosisCode2(String icd10DiagnosisCode2) {
        this.icd10DiagnosisCode2 = icd10DiagnosisCode2;
    }

    public String getIcd10DiagnosisCode3() {
        return icd10DiagnosisCode3;
    }

    public void setIcd10DiagnosisCode3(String icd10DiagnosisCode3) {
        this.icd10DiagnosisCode3 = icd10DiagnosisCode3;
    }

    public String getIcd10DiagnosisCode4() {
        return icd10DiagnosisCode4;
    }

    public void setIcd10DiagnosisCode4(String icd10DiagnosisCode4) {
        this.icd10DiagnosisCode4 = icd10DiagnosisCode4;
    }

    public String getIcd10DiagnosisCode5() {
        return icd10DiagnosisCode5;
    }

    public void setIcd10DiagnosisCode5(String icd10DiagnosisCode5) {
        this.icd10DiagnosisCode5 = icd10DiagnosisCode5;
    }

    public String getIcd10DiagnosisCode6() {
        return icd10DiagnosisCode6;
    }

    public void setIcd10DiagnosisCode6(String icd10DiagnosisCode6) {
        this.icd10DiagnosisCode6 = icd10DiagnosisCode6;
    }

    public String getIcd10DiagnosisCode7() {
        return icd10DiagnosisCode7;
    }

    public void setIcd10DiagnosisCode7(String icd10DiagnosisCode7) {
        this.icd10DiagnosisCode7 = icd10DiagnosisCode7;
    }

    public String getIcd10DiagnosisCode8() {
        return icd10DiagnosisCode8;
    }

    public void setIcd10DiagnosisCode8(String icd10DiagnosisCode8) {
        this.icd10DiagnosisCode8 = icd10DiagnosisCode8;
    }

    public String getIcd10DiagnosisCode9() {
        return icd10DiagnosisCode9;
    }

    public void setIcd10DiagnosisCode9(String icd10DiagnosisCode9) {
        this.icd10DiagnosisCode9 = icd10DiagnosisCode9;
    }

    public String getIcd10DiagnosisCode10() {
        return icd10DiagnosisCode10;
    }

    public void setIcd10DiagnosisCode10(String icd10DiagnosisCode10) {
        this.icd10DiagnosisCode10 = icd10DiagnosisCode10;
    }

    public String getIcd10DiagnosisCode11() {
        return icd10DiagnosisCode11;
    }

    public void setIcd10DiagnosisCode11(String icd10DiagnosisCode11) {
        this.icd10DiagnosisCode11 = icd10DiagnosisCode11;
    }

    public String getIcd10DiagnosisCode12() {
        return icd10DiagnosisCode12;
    }

    public void setIcd10DiagnosisCode12(String icd10DiagnosisCode12) {
        this.icd10DiagnosisCode12 = icd10DiagnosisCode12;
    }

    public String getEpsdtCertificationConditionIndicator() {
        return epsdtCertificationConditionIndicator;
    }

    public void setEpsdtCertificationConditionIndicator(String epsdtCertificationConditionIndicator) {
        this.epsdtCertificationConditionIndicator = epsdtCertificationConditionIndicator;
    }

    public String getEpsdtCertificationCode() {
        return epsdtCertificationCode;
    }

    public void setEpsdtCertificationCode(String epsdtCertificationCode) {
        this.epsdtCertificationCode = epsdtCertificationCode;
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
        if (!(o instanceof SalesOrderClinicalDetailsDTO)) {
            return false;
        }

        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO = (SalesOrderClinicalDetailsDTO) o;
        if (this.salesOderClinicalDetailsId == null) {
            return false;
        }
        return Objects.equals(this.salesOderClinicalDetailsId, salesOrderClinicalDetailsDTO.salesOderClinicalDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.salesOderClinicalDetailsId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderClinicalDetailsDTO{" +
            "salesOderClinicalDetailsId=" + getSalesOderClinicalDetailsId() +
            ", salesOrderId=" + getSalesOrderId() +
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
            ", salesOrderMaster=" + getSalesOrderMaster() +
            "}";
    }
}
