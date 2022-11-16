package com.sunknowledge.dme.rcm.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.sunknowledge.dme.rcm.domain.SalesOrderMaster} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesOrderMasterDTO implements Serializable {

    private Long salesOrderId;

    @NotNull(message = "must not be null")
    private String salesOrderNo;

    @NotNull(message = "must not be null")
    private Integer patientId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String patientFirstName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String patientMiddleName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String patientLastName;

    @NotNull(message = "must not be null")
    private Integer patientAddressId;

    private String patientAddressLine1;

    private String patientAddressLine2;

    private String cityName;

    private String stateName;

    private String zipCode;

    @NotNull(message = "must not be null")
    private Integer patientContactId;

    private String phone1;

    private String phone2;

    @NotNull(message = "must not be null")
    private LocalDate patientDob;

    private Double patientHeight;

    private Double patientWeight;

    @NotNull(message = "must not be null")
    private String patientSsn;

    @NotNull(message = "must not be null")
    private String patientGender;

    private Integer patientBranchId;

    private String branchName;

    @NotNull(message = "must not be null")
    private LocalDate patientDod;

    private String hipaaOnFileStatus;

    @NotNull(message = "must not be null")
    private Integer facilityId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String facilityName;

    @NotNull(message = "must not be null")
    private String facilityNPI;

    private ZonedDateTime deliveryScheduleDatetime;

    private ZonedDateTime deliveryActualDatetime;

    private String deliveryAddressLine1;

    private String deliveryAddressLine2;

    private String deliveryCityName;

    private String deliveryStateName;

    private String deliveryZipCode;

    private String deliveryPhoneNo1;

    private String deliveryPhoneNo2;

    private Integer deliveryBranchId;

    private String deliveryBranchName;

    private Integer taxZoneId;

    private Double taxRate;

    private String salesOrderNote;

    private String deliveryNote;

    private String deliveryTechnician;

    private String signatureRequiredStatus;

    private String podStatus;

    private ZonedDateTime podStatusDateTime;

    private String podLastMessage;

    private ZonedDateTime podMessageDateTime;

    private String mutualHoldStatus;

    private Integer holdReasonId;

    private String holdStatus;

    private String holdReasonDescription;

    private LocalDate stopDate;

    private Integer stopReasonId;

    private String stopReasonDescription;

    private Integer inventoryLocationId;

    private String orderStatus;

    private Integer orderClassificationId;

    private Integer posId;

    private String posName;

    private LocalDate admissionDate;

    private LocalDate dischargeDate;

    private Integer discountPercentage;

    private String poNumber;

    private String userField1;

    private String userField2;

    private String userField3;

    private String userField4;

    private String reference;

    private String wipStatus;

    private Integer wipDaysInState;

    private Integer wipAssignedToId;

    private LocalDate wipDateNeeded;

    private String completedStatus;

    private String status;

    private Integer createdById;

    private String createdByName;

    private ZonedDateTime createdDate;

    private Integer confirmationById;

    private String confirmationByName;

    private ZonedDateTime confirmationDate;

    private Integer updatedById;

    private String updatedByName;

    private ZonedDateTime updatedDate;

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMiddleName() {
        return patientMiddleName;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Integer getPatientAddressId() {
        return patientAddressId;
    }

    public void setPatientAddressId(Integer patientAddressId) {
        this.patientAddressId = patientAddressId;
    }

    public String getPatientAddressLine1() {
        return patientAddressLine1;
    }

    public void setPatientAddressLine1(String patientAddressLine1) {
        this.patientAddressLine1 = patientAddressLine1;
    }

    public String getPatientAddressLine2() {
        return patientAddressLine2;
    }

    public void setPatientAddressLine2(String patientAddressLine2) {
        this.patientAddressLine2 = patientAddressLine2;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getPatientContactId() {
        return patientContactId;
    }

    public void setPatientContactId(Integer patientContactId) {
        this.patientContactId = patientContactId;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public LocalDate getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public Double getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(Double patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientSsn() {
        return patientSsn;
    }

    public void setPatientSsn(String patientSsn) {
        this.patientSsn = patientSsn;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getPatientBranchId() {
        return patientBranchId;
    }

    public void setPatientBranchId(Integer patientBranchId) {
        this.patientBranchId = patientBranchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public LocalDate getPatientDod() {
        return patientDod;
    }

    public void setPatientDod(LocalDate patientDod) {
        this.patientDod = patientDod;
    }

    public String getHipaaOnFileStatus() {
        return hipaaOnFileStatus;
    }

    public void setHipaaOnFileStatus(String hipaaOnFileStatus) {
        this.hipaaOnFileStatus = hipaaOnFileStatus;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityNPI() {
        return facilityNPI;
    }

    public void setFacilityNPI(String facilityNPI) {
        this.facilityNPI = facilityNPI;
    }

    public ZonedDateTime getDeliveryScheduleDatetime() {
        return deliveryScheduleDatetime;
    }

    public void setDeliveryScheduleDatetime(ZonedDateTime deliveryScheduleDatetime) {
        this.deliveryScheduleDatetime = deliveryScheduleDatetime;
    }

    public ZonedDateTime getDeliveryActualDatetime() {
        return deliveryActualDatetime;
    }

    public void setDeliveryActualDatetime(ZonedDateTime deliveryActualDatetime) {
        this.deliveryActualDatetime = deliveryActualDatetime;
    }

    public String getDeliveryAddressLine1() {
        return deliveryAddressLine1;
    }

    public void setDeliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
    }

    public String getDeliveryAddressLine2() {
        return deliveryAddressLine2;
    }

    public void setDeliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
    }

    public String getDeliveryCityName() {
        return deliveryCityName;
    }

    public void setDeliveryCityName(String deliveryCityName) {
        this.deliveryCityName = deliveryCityName;
    }

    public String getDeliveryStateName() {
        return deliveryStateName;
    }

    public void setDeliveryStateName(String deliveryStateName) {
        this.deliveryStateName = deliveryStateName;
    }

    public String getDeliveryZipCode() {
        return deliveryZipCode;
    }

    public void setDeliveryZipCode(String deliveryZipCode) {
        this.deliveryZipCode = deliveryZipCode;
    }

    public String getDeliveryPhoneNo1() {
        return deliveryPhoneNo1;
    }

    public void setDeliveryPhoneNo1(String deliveryPhoneNo1) {
        this.deliveryPhoneNo1 = deliveryPhoneNo1;
    }

    public String getDeliveryPhoneNo2() {
        return deliveryPhoneNo2;
    }

    public void setDeliveryPhoneNo2(String deliveryPhoneNo2) {
        this.deliveryPhoneNo2 = deliveryPhoneNo2;
    }

    public Integer getDeliveryBranchId() {
        return deliveryBranchId;
    }

    public void setDeliveryBranchId(Integer deliveryBranchId) {
        this.deliveryBranchId = deliveryBranchId;
    }

    public String getDeliveryBranchName() {
        return deliveryBranchName;
    }

    public void setDeliveryBranchName(String deliveryBranchName) {
        this.deliveryBranchName = deliveryBranchName;
    }

    public Integer getTaxZoneId() {
        return taxZoneId;
    }

    public void setTaxZoneId(Integer taxZoneId) {
        this.taxZoneId = taxZoneId;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getSalesOrderNote() {
        return salesOrderNote;
    }

    public void setSalesOrderNote(String salesOrderNote) {
        this.salesOrderNote = salesOrderNote;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public String getDeliveryTechnician() {
        return deliveryTechnician;
    }

    public void setDeliveryTechnician(String deliveryTechnician) {
        this.deliveryTechnician = deliveryTechnician;
    }

    public String getSignatureRequiredStatus() {
        return signatureRequiredStatus;
    }

    public void setSignatureRequiredStatus(String signatureRequiredStatus) {
        this.signatureRequiredStatus = signatureRequiredStatus;
    }

    public String getPodStatus() {
        return podStatus;
    }

    public void setPodStatus(String podStatus) {
        this.podStatus = podStatus;
    }

    public ZonedDateTime getPodStatusDateTime() {
        return podStatusDateTime;
    }

    public void setPodStatusDateTime(ZonedDateTime podStatusDateTime) {
        this.podStatusDateTime = podStatusDateTime;
    }

    public String getPodLastMessage() {
        return podLastMessage;
    }

    public void setPodLastMessage(String podLastMessage) {
        this.podLastMessage = podLastMessage;
    }

    public ZonedDateTime getPodMessageDateTime() {
        return podMessageDateTime;
    }

    public void setPodMessageDateTime(ZonedDateTime podMessageDateTime) {
        this.podMessageDateTime = podMessageDateTime;
    }

    public String getMutualHoldStatus() {
        return mutualHoldStatus;
    }

    public void setMutualHoldStatus(String mutualHoldStatus) {
        this.mutualHoldStatus = mutualHoldStatus;
    }

    public Integer getHoldReasonId() {
        return holdReasonId;
    }

    public void setHoldReasonId(Integer holdReasonId) {
        this.holdReasonId = holdReasonId;
    }

    public String getHoldStatus() {
        return holdStatus;
    }

    public void setHoldStatus(String holdStatus) {
        this.holdStatus = holdStatus;
    }

    public String getHoldReasonDescription() {
        return holdReasonDescription;
    }

    public void setHoldReasonDescription(String holdReasonDescription) {
        this.holdReasonDescription = holdReasonDescription;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }

    public Integer getStopReasonId() {
        return stopReasonId;
    }

    public void setStopReasonId(Integer stopReasonId) {
        this.stopReasonId = stopReasonId;
    }

    public String getStopReasonDescription() {
        return stopReasonDescription;
    }

    public void setStopReasonDescription(String stopReasonDescription) {
        this.stopReasonDescription = stopReasonDescription;
    }

    public Integer getInventoryLocationId() {
        return inventoryLocationId;
    }

    public void setInventoryLocationId(Integer inventoryLocationId) {
        this.inventoryLocationId = inventoryLocationId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderClassificationId() {
        return orderClassificationId;
    }

    public void setOrderClassificationId(Integer orderClassificationId) {
        this.orderClassificationId = orderClassificationId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getUserField1() {
        return userField1;
    }

    public void setUserField1(String userField1) {
        this.userField1 = userField1;
    }

    public String getUserField2() {
        return userField2;
    }

    public void setUserField2(String userField2) {
        this.userField2 = userField2;
    }

    public String getUserField3() {
        return userField3;
    }

    public void setUserField3(String userField3) {
        this.userField3 = userField3;
    }

    public String getUserField4() {
        return userField4;
    }

    public void setUserField4(String userField4) {
        this.userField4 = userField4;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getWipStatus() {
        return wipStatus;
    }

    public void setWipStatus(String wipStatus) {
        this.wipStatus = wipStatus;
    }

    public Integer getWipDaysInState() {
        return wipDaysInState;
    }

    public void setWipDaysInState(Integer wipDaysInState) {
        this.wipDaysInState = wipDaysInState;
    }

    public Integer getWipAssignedToId() {
        return wipAssignedToId;
    }

    public void setWipAssignedToId(Integer wipAssignedToId) {
        this.wipAssignedToId = wipAssignedToId;
    }

    public LocalDate getWipDateNeeded() {
        return wipDateNeeded;
    }

    public void setWipDateNeeded(LocalDate wipDateNeeded) {
        this.wipDateNeeded = wipDateNeeded;
    }

    public String getCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(String completedStatus) {
        this.completedStatus = completedStatus;
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

    public Integer getConfirmationById() {
        return confirmationById;
    }

    public void setConfirmationById(Integer confirmationById) {
        this.confirmationById = confirmationById;
    }

    public String getConfirmationByName() {
        return confirmationByName;
    }

    public void setConfirmationByName(String confirmationByName) {
        this.confirmationByName = confirmationByName;
    }

    public ZonedDateTime getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(ZonedDateTime confirmationDate) {
        this.confirmationDate = confirmationDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesOrderMasterDTO)) {
            return false;
        }

        SalesOrderMasterDTO salesOrderMasterDTO = (SalesOrderMasterDTO) o;
        if (this.salesOrderId == null) {
            return false;
        }
        return Objects.equals(this.salesOrderId, salesOrderMasterDTO.salesOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.salesOrderId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderMasterDTO{" +
            "salesOrderId=" + getSalesOrderId() +
            ", salesOrderNo='" + getSalesOrderNo() + "'" +
            ", patientId=" + getPatientId() +
            ", patientFirstName='" + getPatientFirstName() + "'" +
            ", patientMiddleName='" + getPatientMiddleName() + "'" +
            ", patientLastName='" + getPatientLastName() + "'" +
            ", patientAddressId=" + getPatientAddressId() +
            ", patientAddressLine1='" + getPatientAddressLine1() + "'" +
            ", patientAddressLine2='" + getPatientAddressLine2() + "'" +
            ", cityName='" + getCityName() + "'" +
            ", stateName='" + getStateName() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", patientContactId=" + getPatientContactId() +
            ", phone1='" + getPhone1() + "'" +
            ", phone2='" + getPhone2() + "'" +
            ", patientDob='" + getPatientDob() + "'" +
            ", patientHeight=" + getPatientHeight() +
            ", patientWeight=" + getPatientWeight() +
            ", patientSsn='" + getPatientSsn() + "'" +
            ", patientGender='" + getPatientGender() + "'" +
            ", patientBranchId=" + getPatientBranchId() +
            ", branchName='" + getBranchName() + "'" +
            ", patientDod='" + getPatientDod() + "'" +
            ", hipaaOnFileStatus='" + getHipaaOnFileStatus() + "'" +
            ", facilityId=" + getFacilityId() +
            ", facilityName='" + getFacilityName() + "'" +
            ", facilityNPI='" + getFacilityNPI() + "'" +
            ", deliveryScheduleDatetime='" + getDeliveryScheduleDatetime() + "'" +
            ", deliveryActualDatetime='" + getDeliveryActualDatetime() + "'" +
            ", deliveryAddressLine1='" + getDeliveryAddressLine1() + "'" +
            ", deliveryAddressLine2='" + getDeliveryAddressLine2() + "'" +
            ", deliveryCityName='" + getDeliveryCityName() + "'" +
            ", deliveryStateName='" + getDeliveryStateName() + "'" +
            ", deliveryZipCode='" + getDeliveryZipCode() + "'" +
            ", deliveryPhoneNo1='" + getDeliveryPhoneNo1() + "'" +
            ", deliveryPhoneNo2='" + getDeliveryPhoneNo2() + "'" +
            ", deliveryBranchId=" + getDeliveryBranchId() +
            ", deliveryBranchName='" + getDeliveryBranchName() + "'" +
            ", taxZoneId=" + getTaxZoneId() +
            ", taxRate=" + getTaxRate() +
            ", salesOrderNote='" + getSalesOrderNote() + "'" +
            ", deliveryNote='" + getDeliveryNote() + "'" +
            ", deliveryTechnician='" + getDeliveryTechnician() + "'" +
            ", signatureRequiredStatus='" + getSignatureRequiredStatus() + "'" +
            ", podStatus='" + getPodStatus() + "'" +
            ", podStatusDateTime='" + getPodStatusDateTime() + "'" +
            ", podLastMessage='" + getPodLastMessage() + "'" +
            ", podMessageDateTime='" + getPodMessageDateTime() + "'" +
            ", mutualHoldStatus='" + getMutualHoldStatus() + "'" +
            ", holdReasonId=" + getHoldReasonId() +
            ", holdStatus='" + getHoldStatus() + "'" +
            ", holdReasonDescription='" + getHoldReasonDescription() + "'" +
            ", stopDate='" + getStopDate() + "'" +
            ", stopReasonId=" + getStopReasonId() +
            ", stopReasonDescription='" + getStopReasonDescription() + "'" +
            ", inventoryLocationId=" + getInventoryLocationId() +
            ", orderStatus='" + getOrderStatus() + "'" +
            ", orderClassificationId=" + getOrderClassificationId() +
            ", posId=" + getPosId() +
            ", posName='" + getPosName() + "'" +
            ", admissionDate='" + getAdmissionDate() + "'" +
            ", dischargeDate='" + getDischargeDate() + "'" +
            ", discountPercentage=" + getDiscountPercentage() +
            ", poNumber='" + getPoNumber() + "'" +
            ", userField1='" + getUserField1() + "'" +
            ", userField2='" + getUserField2() + "'" +
            ", userField3='" + getUserField3() + "'" +
            ", userField4='" + getUserField4() + "'" +
            ", reference='" + getReference() + "'" +
            ", wipStatus='" + getWipStatus() + "'" +
            ", wipDaysInState=" + getWipDaysInState() +
            ", wipAssignedToId=" + getWipAssignedToId() +
            ", wipDateNeeded='" + getWipDateNeeded() + "'" +
            ", completedStatus='" + getCompletedStatus() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdById=" + getCreatedById() +
            ", createdByName='" + getCreatedByName() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", confirmationById=" + getConfirmationById() +
            ", confirmationByName='" + getConfirmationByName() + "'" +
            ", confirmationDate='" + getConfirmationDate() + "'" +
            ", updatedById=" + getUpdatedById() +
            ", updatedByName='" + getUpdatedByName() + "'" +
            ", updatedDate='" + getUpdatedDate() + "'" +
            "}";
    }
}
