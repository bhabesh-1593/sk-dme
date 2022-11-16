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
 * A SalesOrderMaster.
 */

@Table("t_sales_order_master")
public class SalesOrderMaster implements Serializable {
    private static final long serialVersionUID = 1L;

//    @Column("id")
//    private Long id;

    @Id
    @NotNull(message = "must not be null")
    @Column("sales_order_id")
    private Integer salesOderId;

    @NotNull(message = "must not be null")
    @Column("sales_order_no")
    private String salesOderNo;

    @NotNull(message = "must not be null")
    @Column("patient_id")
    private Integer patientId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("patient_first_name")
    private String patientFirstName;

    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("patient_middle_name")
    private String patientMiddleName;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("patient_last_name")
    private String patientLastName;

    @NotNull(message = "must not be null")
    @Column("patient_billing_address_id")
    private Integer patientBillingAddressId;

    @Column("patient_address_line_1")
    private String patientAddressLine1;

    @Column("patient_address_line_2")
    private String patientAddressLine2;

    @Column("city_name")
    private String cityName;

    @Column("state_name")
    private String stateName;

    @Column("zip_code")
    private String zipCode;

    @NotNull(message = "must not be null")
    @Column("patient_contact_id")
    private Integer patientContactId;

    @Column("patient_contact_no_1")
    private String phone1;

    @Column("patient_contact_no_2")
    private String phone2;

    @NotNull(message = "must not be null")
    @Column("patient_dob")
    private LocalDate patientDob;

    @Column("patient_height")
    private Double patientHeight;

    @Column("patient_weight")
    private Double patientWeight;

    @NotNull(message = "must not be null")
    @Column("patient_ssn")
    private String patientSsn;

    @NotNull(message = "must not be null")
    @Column("patient_gender")
    private String patientGender;

    @Column("patient_branch_id")
    private Integer patientBranchId;

    @Column("branch_name")
    private String branchName;

    @Column("patient_dod")
    private LocalDate patientDod;

    @Column("hipaa_on_file_status")
    private String hipaaOnFileStatus;

    @NotNull(message = "must not be null")
    @Column("facility_id")
    private Integer facilityId;

    @NotNull(message = "must not be null")
    @Column("facility_name")
    private String facilityName;

    @NotNull(message = "must not be null")
    @Column("facility_npi")
    private String facilityNPI;

    @Column("delivery_schedule_datetime")
    private ZonedDateTime deliveryScheduleDatetime;

    @Column("delivery_actual_datetime")
    private ZonedDateTime deliveryActualDatetime;

    @Column("delivery_address_line_1")
    private String deliveryAddressLine1;

    @Column("delivery_address_line_2")
    private String deliveryAddressLine2;

    @Column("delivery_city_name")
    private String deliveryCityName;

    @Column("delivery_state_name")
    private String deliveryStateName;

    @Column("delivery_zip_code")
    private String deliveryZipCode;

    @Column("delivery_phone_no_1")
    private String deliveryPhoneNo1;

    @Column("delivery_phone_no_2")
    private String deliveryPhoneNo2;

    @Column("delivery_branch_id")
    private Integer deliveryBranchId;

    @Column("delivery_branch_name")
    private String deliveryBranchName;

    @Column("tax_zone_id")
    private Integer taxZoneId;

    @Column("tax_rate")
    private Double taxRate;

    @Column("sales_order_note")
    private String salesOrderNote;

    @Column("delivery_note")
    private String deliveryNote;

    @Column("delivery_technician")
    private String deliveryTechnician;

    @Column("signature_required_status")
    private String signatureRequiredStatus;

    @Column("pod_status")
    private String podStatus;

    @Column("pod_status_datetime")
    private ZonedDateTime podStatusDateTime;

    @Column("pod_last_message")
    private String podLastMessage;

    @Column("pod_message_datetime")
    private ZonedDateTime podMessageDateTime;

    @Column("mutual_hold_status")
    private String mutualHoldStatus;

    @Column("hold_reason_id")
    private Integer holdReasonId;

    @Column("hold_status")
    private String holdStatus;

    @Column("hold_reason_description")
    private String holdReasonDescription;

    @Column("stop_date")
    private LocalDate stopDate;

    @Column("stop_reason_id")
    private Integer stopReasonId;

    @Column("stop_reason_description")
    private String stopReasonDescription;

    @Column("inventory_location_id")
    private Integer inventoryLocationId;

    @Column("order_status")
    private String orderStatus;

    @Column("order_classification_id")
    private Integer orderClassificationId;

    @Column("pos_id")
    private Integer posId;

    @Column("pos_name")
    private String posName;

    @Column("admission_date")
    private LocalDate admissionDate;

    @Column("discharge_date")
    private LocalDate dischargeDate;

    @Column("discount_percentage")
    private Integer discountPercentage;

    @Column("po_number")
    private String poNumber;

    @Column("user_field_1")
    private String userField1;

    @Column("user_field_2")
    private String userField2;

    @Column("user_field_3")
    private String userField3;

    @Column("user_field_4")
    private String userField4;

    @Column("reference")
    private String reference;

    @Column("wip_status")
    private String wipStatus;

    @Column("wip_days_in_state")
    private Integer wipDaysInState;

    @Column("wip_assigned_to_id")
    private Integer wipAssignedToId;

    @Column("wip_date_needed")
    private LocalDate wipDateNeeded;

    @Column("completed_status")
    private String completedStatus;

    @Column("status")
    private String status;

    @Column("created_by_id")
    private Integer createdById;

    @Column("created_by_name")
    private String createdByName;

    @Column("created_date")
    private ZonedDateTime createdDate;

    @Column("confirmation_by_id")
    private Integer confirmationById;

    @Column("confirmation_by_name")
    private String confirmationByName;

    @Column("confirmation_date")
    private ZonedDateTime confirmationDate;

    @Column("updated_by_id")
    private Integer updatedById;

    @Column("updated_by_name")
    private String updatedByName;

    @Column("updated_date")
    private ZonedDateTime updatedDate;

    @Column("sales_order_master_uuid")
    private UUID salesOrderMasterUuid;

    @Column("sales_order_master_uuid")
    private UUID salesOrderMasterUuid;

    @Column("so_control_number")
    private Long soControlNumber;

    @Column("branch_contact_person_name")
    private String branchContactPersonName;

    @Column("branch_npi")
    private String branchNpi;

    @Column("branch_ein")
    private String branchEin;

    @Column("branch_contact_no_1")
    private String branchContactNo1;

    @Column("branch_contact_no_2")
    private String branchContactNo2;

    @Column("additional_patient_identifier")
    private String additionalPatientIdentifier;

    @Column("pos_code")
    private String posCode;

    @Column("eclaim_carrier_name")
    private String eclaimCarrierName;

    @Column("plan_participation_code")
    private String planParticipationCode;

    @Column("patient_member_id")
    private String patientMemberId;

    @Column("patient_delivery_address_id")
    private String patientDeliveryAddressId;

    public Integer getSalesOderId() {
        return this.salesOderId;
    }

    public SalesOrderMaster salesOderId(Integer salesOderId) {
        this.setSalesOderId(salesOderId);
        return this;
    }

    public void setSalesOderId(Integer salesOderId) {
        this.salesOderId = salesOderId;
    }

    public String getSalesOderNo() {
        return this.salesOderNo;
    }

    public SalesOrderMaster salesOderNo(String salesOderNo) {
        this.setSalesOderNo(salesOderNo);
        return this;
    }

    public void setSalesOderNo(String salesOderNo) {
        this.salesOderNo = salesOderNo;
    }

    public Integer getPatientId() {
        return this.patientId;
    }

    public SalesOrderMaster patientId(Integer patientId) {
        this.setPatientId(patientId);
        return this;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return this.patientFirstName;
    }

    public SalesOrderMaster patientFirstName(String patientFirstName) {
        this.setPatientFirstName(patientFirstName);
        return this;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMiddleName() {
        return this.patientMiddleName;
    }

    public SalesOrderMaster patientMiddleName(String patientMiddleName) {
        this.setPatientMiddleName(patientMiddleName);
        return this;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public String getPatientLastName() {
        return this.patientLastName;
    }

    public SalesOrderMaster patientLastName(String patientLastName) {
        this.setPatientLastName(patientLastName);
        return this;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Integer getPatientAddressId() {
        return this.patientAddressId;
    }

    public SalesOrderMaster patientAddressId(Integer patientAddressId) {
        this.setPatientAddressId(patientAddressId);
        return this;
    }

    public void setPatientAddressId(Integer patientAddressId) {
        this.patientAddressId = patientAddressId;
    }

    public String getPatientAddressLine1() {
        return this.patientAddressLine1;
    }

    public SalesOrderMaster patientAddressLine1(String patientAddressLine1) {
        this.setPatientAddressLine1(patientAddressLine1);
        return this;
    }

    public void setPatientAddressLine1(String patientAddressLine1) {
        this.patientAddressLine1 = patientAddressLine1;
    }

    public String getPatientAddressLine2() {
        return this.patientAddressLine2;
    }

    public SalesOrderMaster patientAddressLine2(String patientAddressLine2) {
        this.setPatientAddressLine2(patientAddressLine2);
        return this;
    }

    public void setPatientAddressLine2(String patientAddressLine2) {
        this.patientAddressLine2 = patientAddressLine2;
    }

    public String getCityName() {
        return this.cityName;
    }

    public SalesOrderMaster cityName(String cityName) {
        this.setCityName(cityName);
        return this;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public SalesOrderMaster stateName(String stateName) {
        this.setStateName(stateName);
        return this;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public SalesOrderMaster zipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getPatientContactId() {
        return this.patientContactId;
    }

    public SalesOrderMaster patientContactId(Integer patientContactId) {
        this.setPatientContactId(patientContactId);
        return this;
    }

    public void setPatientContactId(Integer patientContactId) {
        this.patientContactId = patientContactId;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public SalesOrderMaster phone1(String phone1) {
        this.setPhone1(phone1);
        return this;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public SalesOrderMaster phone2(String phone2) {
        this.setPhone2(phone2);
        return this;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public LocalDate getPatientDob() {
        return this.patientDob;
    }

    public SalesOrderMaster patientDob(LocalDate patientDob) {
        this.setPatientDob(patientDob);
        return this;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public Double getPatientHeight() {
        return this.patientHeight;
    }

    public SalesOrderMaster patientHeight(Double patientHeight) {
        this.setPatientHeight(patientHeight);
        return this;
    }

    public void setPatientHeight(Double patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Double getPatientWeight() {
        return this.patientWeight;
    }

    public SalesOrderMaster patientWeight(Double patientWeight) {
        this.setPatientWeight(patientWeight);
        return this;
    }

    public void setPatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientSsn() {
        return this.patientSsn;
    }

    public SalesOrderMaster patientSsn(String patientSsn) {
        this.setPatientSsn(patientSsn);
        return this;
    }

    public void setPatientSsn(String patientSsn) {
        this.patientSsn = patientSsn;
    }

    public String getPatientGender() {
        return this.patientGender;
    }

    public SalesOrderMaster patientGender(String patientGender) {
        this.setPatientGender(patientGender);
        return this;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getPatientBranchId() {
        return this.patientBranchId;
    }

    public SalesOrderMaster patientBranchId(Integer patientBranchId) {
        this.setPatientBranchId(patientBranchId);
        return this;
    }

    public void setPatientBranchId(Integer patientBranchId) {
        this.patientBranchId = patientBranchId;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public SalesOrderMaster branchName(String branchName) {
        this.setBranchName(branchName);
        return this;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public LocalDate getPatientDod() {
        return this.patientDod;
    }

    public SalesOrderMaster patientDod(LocalDate patientDod) {
        this.setPatientDod(patientDod);
        return this;
    }

    public void setPatientDod(LocalDate patientDod) {
        this.patientDod = patientDod;
    }

    public String getHipaaOnFileStatus() {
        return this.hipaaOnFileStatus;
    }

    public SalesOrderMaster hipaaOnFileStatus(String hipaaOnFileStatus) {
        this.setHipaaOnFileStatus(hipaaOnFileStatus);
        return this;
    }

    public void setHipaaOnFileStatus(String hipaaOnFileStatus) {
        this.hipaaOnFileStatus = hipaaOnFileStatus;
    }

    public Integer getFacilityId() {
        return this.facilityId;
    }

    public SalesOrderMaster facilityId(Integer facilityId) {
        this.setFacilityId(facilityId);
        return this;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return this.facilityName;
    }

    public SalesOrderMaster facilityName(String facilityName) {
        this.setFacilityName(facilityName);
        return this;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityNPI() {
        return this.facilityNPI;
    }

    public SalesOrderMaster facilityNPI(String facilityNPI) {
        this.setFacilityNPI(facilityNPI);
        return this;
    }

    public void setFacilityNPI(String facilityNPI) {
        this.facilityNPI = facilityNPI;
    }

    public ZonedDateTime getDeliveryScheduleDatetime() {
        return this.deliveryScheduleDatetime;
    }

    public SalesOrderMaster deliveryScheduleDatetime(ZonedDateTime deliveryScheduleDatetime) {
        this.setDeliveryScheduleDatetime(deliveryScheduleDatetime);
        return this;
    }

    public void setDeliveryScheduleDatetime(ZonedDateTime deliveryScheduleDatetime) {
        this.deliveryScheduleDatetime = deliveryScheduleDatetime;
    }

    public ZonedDateTime getDeliveryActualDatetime() {
        return this.deliveryActualDatetime;
    }

    public SalesOrderMaster deliveryActualDatetime(ZonedDateTime deliveryActualDatetime) {
        this.setDeliveryActualDatetime(deliveryActualDatetime);
        return this;
    }

    public void setDeliveryActualDatetime(ZonedDateTime deliveryActualDatetime) {
        this.deliveryActualDatetime = deliveryActualDatetime;
    }

    public String getDeliveryAddressLine1() {
        return this.deliveryAddressLine1;
    }

    public SalesOrderMaster deliveryAddressLine1(String deliveryAddressLine1) {
        this.setDeliveryAddressLine1(deliveryAddressLine1);
        return this;
    }

    public void setDeliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
    }

    public String getDeliveryAddressLine2() {
        return this.deliveryAddressLine2;
    }

    public SalesOrderMaster deliveryAddressLine2(String deliveryAddressLine2) {
        this.setDeliveryAddressLine2(deliveryAddressLine2);
        return this;
    }

    public void setDeliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
    }

    public String getDeliveryCityName() {
        return this.deliveryCityName;
    }

    public SalesOrderMaster deliveryCityName(String deliveryCityName) {
        this.setDeliveryCityName(deliveryCityName);
        return this;
    }

    public void setDeliveryCityName(String deliveryCityName) {
        this.deliveryCityName = deliveryCityName;
    }

    public String getDeliveryStateName() {
        return this.deliveryStateName;
    }

    public SalesOrderMaster deliveryStateName(String deliveryStateName) {
        this.setDeliveryStateName(deliveryStateName);
        return this;
    }

    public void setDeliveryStateName(String deliveryStateName) {
        this.deliveryStateName = deliveryStateName;
    }

    public String getDeliveryZipCode() {
        return this.deliveryZipCode;
    }

    public SalesOrderMaster deliveryZipCode(String deliveryZipCode) {
        this.setDeliveryZipCode(deliveryZipCode);
        return this;
    }

    public void setDeliveryZipCode(String deliveryZipCode) {
        this.deliveryZipCode = deliveryZipCode;
    }

    public String getDeliveryPhoneNo1() {
        return this.deliveryPhoneNo1;
    }

    public SalesOrderMaster deliveryPhoneNo1(String deliveryPhoneNo1) {
        this.setDeliveryPhoneNo1(deliveryPhoneNo1);
        return this;
    }

    public void setDeliveryPhoneNo1(String deliveryPhoneNo1) {
        this.deliveryPhoneNo1 = deliveryPhoneNo1;
    }

    public String getDeliveryPhoneNo2() {
        return this.deliveryPhoneNo2;
    }

    public SalesOrderMaster deliveryPhoneNo2(String deliveryPhoneNo2) {
        this.setDeliveryPhoneNo2(deliveryPhoneNo2);
        return this;
    }

    public void setDeliveryPhoneNo2(String deliveryPhoneNo2) {
        this.deliveryPhoneNo2 = deliveryPhoneNo2;
    }

    public Integer getDeliveryBranchId() {
        return this.deliveryBranchId;
    }

    public SalesOrderMaster deliveryBranchId(Integer deliveryBranchId) {
        this.setDeliveryBranchId(deliveryBranchId);
        return this;
    }

    public void setDeliveryBranchId(Integer deliveryBranchId) {
        this.deliveryBranchId = deliveryBranchId;
    }

    public String getDeliveryBranchName() {
        return this.deliveryBranchName;
    }

    public SalesOrderMaster deliveryBranchName(String deliveryBranchName) {
        this.setDeliveryBranchName(deliveryBranchName);
        return this;
    }

    public void setDeliveryBranchName(String deliveryBranchName) {
        this.deliveryBranchName = deliveryBranchName;
    }

    public Integer getTaxZoneId() {
        return this.taxZoneId;
    }

    public SalesOrderMaster taxZoneId(Integer taxZoneId) {
        this.setTaxZoneId(taxZoneId);
        return this;
    }

    public void setTaxZoneId(Integer taxZoneId) {
        this.taxZoneId = taxZoneId;
    }

    public Double getTaxRate() {
        return this.taxRate;
    }

    public SalesOrderMaster taxRate(Double taxRate) {
        this.setTaxRate(taxRate);
        return this;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getSalesOrderNote() {
        return this.salesOrderNote;
    }

    public SalesOrderMaster salesOrderNote(String salesOrderNote) {
        this.setSalesOrderNote(salesOrderNote);
        return this;
    }

    public void setSalesOrderNote(String salesOrderNote) {
        this.salesOrderNote = salesOrderNote;
    }

    public String getDeliveryNote() {
        return this.deliveryNote;
    }

    public SalesOrderMaster deliveryNote(String deliveryNote) {
        this.setDeliveryNote(deliveryNote);
        return this;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public String getDeliveryTechnician() {
        return this.deliveryTechnician;
    }

    public SalesOrderMaster deliveryTechnician(String deliveryTechnician) {
        this.setDeliveryTechnician(deliveryTechnician);
        return this;
    }

    public void setDeliveryTechnician(String deliveryTechnician) {
        this.deliveryTechnician = deliveryTechnician;
    }

    public String getSignatureRequiredStatus() {
        return this.signatureRequiredStatus;
    }

    public SalesOrderMaster signatureRequiredStatus(String signatureRequiredStatus) {
        this.setSignatureRequiredStatus(signatureRequiredStatus);
        return this;
    }

    public void setSignatureRequiredStatus(String signatureRequiredStatus) {
        this.signatureRequiredStatus = signatureRequiredStatus;
    }

    public String getPodStatus() {
        return this.podStatus;
    }

    public SalesOrderMaster podStatus(String podStatus) {
        this.setPodStatus(podStatus);
        return this;
    }

    public void setPodStatus(String podStatus) {
        this.podStatus = podStatus;
    }

    public ZonedDateTime getPodStatusDateTime() {
        return this.podStatusDateTime;
    }

    public SalesOrderMaster podStatusDateTime(ZonedDateTime podStatusDateTime) {
        this.setPodStatusDateTime(podStatusDateTime);
        return this;
    }

    public void setPodStatusDateTime(ZonedDateTime podStatusDateTime) {
        this.podStatusDateTime = podStatusDateTime;
    }

    public String getPodLastMessage() {
        return this.podLastMessage;
    }

    public SalesOrderMaster podLastMessage(String podLastMessage) {
        this.setPodLastMessage(podLastMessage);
        return this;
    }

    public void setPodLastMessage(String podLastMessage) {
        this.podLastMessage = podLastMessage;
    }

    public ZonedDateTime getPodMessageDateTime() {
        return this.podMessageDateTime;
    }

    public SalesOrderMaster podMessageDateTime(ZonedDateTime podMessageDateTime) {
        this.setPodMessageDateTime(podMessageDateTime);
        return this;
    }

    public void setPodMessageDateTime(ZonedDateTime podMessageDateTime) {
        this.podMessageDateTime = podMessageDateTime;
    }

    public String getMutualHoldStatus() {
        return this.mutualHoldStatus;
    }

    public SalesOrderMaster mutualHoldStatus(String mutualHoldStatus) {
        this.setMutualHoldStatus(mutualHoldStatus);
        return this;
    }

    public void setMutualHoldStatus(String mutualHoldStatus) {
        this.mutualHoldStatus = mutualHoldStatus;
    }

    public Integer getHoldReasonId() {
        return this.holdReasonId;
    }

    public SalesOrderMaster holdReasonId(Integer holdReasonId) {
        this.setHoldReasonId(holdReasonId);
        return this;
    }

    public void setHoldReasonId(Integer holdReasonId) {
        this.holdReasonId = holdReasonId;
    }

    public String getHoldStatus() {
        return this.holdStatus;
    }

    public SalesOrderMaster holdStatus(String holdStatus) {
        this.setHoldStatus(holdStatus);
        return this;
    }

    public void setHoldStatus(String holdStatus) {
        this.holdStatus = holdStatus;
    }

    public String getHoldReasonDescription() {
        return this.holdReasonDescription;
    }

    public SalesOrderMaster holdReasonDescription(String holdReasonDescription) {
        this.setHoldReasonDescription(holdReasonDescription);
        return this;
    }

    public void setHoldReasonDescription(String holdReasonDescription) {
        this.holdReasonDescription = holdReasonDescription;
    }

    public LocalDate getStopDate() {
        return this.stopDate;
    }

    public SalesOrderMaster stopDate(LocalDate stopDate) {
        this.setStopDate(stopDate);
        return this;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }

    public Integer getStopReasonId() {
        return this.stopReasonId;
    }

    public SalesOrderMaster stopReasonId(Integer stopReasonId) {
        this.setStopReasonId(stopReasonId);
        return this;
    }

    public void setStopReasonId(Integer stopReasonId) {
        this.stopReasonId = stopReasonId;
    }

    public String getStopReasonDescription() {
        return this.stopReasonDescription;
    }

    public SalesOrderMaster stopReasonDescription(String stopReasonDescription) {
        this.setStopReasonDescription(stopReasonDescription);
        return this;
    }

    public void setStopReasonDescription(String stopReasonDescription) {
        this.stopReasonDescription = stopReasonDescription;
    }

    public Integer getInventoryLocationId() {
        return this.inventoryLocationId;
    }

    public SalesOrderMaster inventoryLocationId(Integer inventoryLocationId) {
        this.setInventoryLocationId(inventoryLocationId);
        return this;
    }

    public void setInventoryLocationId(Integer inventoryLocationId) {
        this.inventoryLocationId = inventoryLocationId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public SalesOrderMaster orderStatus(String orderStatus) {
        this.setOrderStatus(orderStatus);
        return this;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderClassificationId() {
        return this.orderClassificationId;
    }

    public SalesOrderMaster orderClassificationId(Integer orderClassificationId) {
        this.setOrderClassificationId(orderClassificationId);
        return this;
    }

    public void setOrderClassificationId(Integer orderClassificationId) {
        this.orderClassificationId = orderClassificationId;
    }

    public Integer getPosId() {
        return this.posId;
    }

    public SalesOrderMaster posId(Integer posId) {
        this.setPosId(posId);
        return this;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return this.posName;
    }

    public SalesOrderMaster posName(String posName) {
        this.setPosName(posName);
        return this;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public LocalDate getAdmissionDate() {
        return this.admissionDate;
    }

    public SalesOrderMaster admissionDate(LocalDate admissionDate) {
        this.setAdmissionDate(admissionDate);
        return this;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return this.dischargeDate;
    }

    public SalesOrderMaster dischargeDate(LocalDate dischargeDate) {
        this.setDischargeDate(dischargeDate);
        return this;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Integer getDiscountPercentage() {
        return this.discountPercentage;
    }

    public SalesOrderMaster discountPercentage(Integer discountPercentage) {
        this.setDiscountPercentage(discountPercentage);
        return this;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getPoNumber() {
        return this.poNumber;
    }

    public SalesOrderMaster poNumber(String poNumber) {
        this.setPoNumber(poNumber);
        return this;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getUserField1() {
        return this.userField1;
    }

    public SalesOrderMaster userField1(String userField1) {
        this.setUserField1(userField1);
        return this;
    }

    public void setUserField1(String userField1) {
        this.userField1 = userField1;
    }

    public String getUserField2() {
        return this.userField2;
    }

    public SalesOrderMaster userField2(String userField2) {
        this.setUserField2(userField2);
        return this;
    }

    public void setUserField2(String userField2) {
        this.userField2 = userField2;
    }

    public String getUserField3() {
        return this.userField3;
    }

    public SalesOrderMaster userField3(String userField3) {
        this.setUserField3(userField3);
        return this;
    }

    public void setUserField3(String userField3) {
        this.userField3 = userField3;
    }

    public String getUserField4() {
        return this.userField4;
    }

    public SalesOrderMaster userField4(String userField4) {
        this.setUserField4(userField4);
        return this;
    }

    public void setUserField4(String userField4) {
        this.userField4 = userField4;
    }

    public String getReference() {
        return this.reference;
    }

    public SalesOrderMaster reference(String reference) {
        this.setReference(reference);
        return this;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getWipStatus() {
        return this.wipStatus;
    }

    public SalesOrderMaster wipStatus(String wipStatus) {
        this.setWipStatus(wipStatus);
        return this;
    }

    public void setWipStatus(String wipStatus) {
        this.wipStatus = wipStatus;
    }

    public Integer getWipDaysInState() {
        return this.wipDaysInState;
    }

    public SalesOrderMaster wipDaysInState(Integer wipDaysInState) {
        this.setWipDaysInState(wipDaysInState);
        return this;
    }

    public void setWipDaysInState(Integer wipDaysInState) {
        this.wipDaysInState = wipDaysInState;
    }

    public Integer getWipAssignedToId() {
        return this.wipAssignedToId;
    }

    public SalesOrderMaster wipAssignedToId(Integer wipAssignedToId) {
        this.setWipAssignedToId(wipAssignedToId);
        return this;
    }

    public void setWipAssignedToId(Integer wipAssignedToId) {
        this.wipAssignedToId = wipAssignedToId;
    }

    public LocalDate getWipDateNeeded() {
        return this.wipDateNeeded;
    }

    public SalesOrderMaster wipDateNeeded(LocalDate wipDateNeeded) {
        this.setWipDateNeeded(wipDateNeeded);
        return this;
    }

    public void setWipDateNeeded(LocalDate wipDateNeeded) {
        this.wipDateNeeded = wipDateNeeded;
    }

    public String getCompletedStatus() {
        return this.completedStatus;
    }

    public SalesOrderMaster completedStatus(String completedStatus) {
        this.setCompletedStatus(completedStatus);
        return this;
    }

    public void setCompletedStatus(String completedStatus) {
        this.completedStatus = completedStatus;
    }

    public String getStatus() {
        return this.status;
    }

    public SalesOrderMaster status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return this.createdById;
    }

    public SalesOrderMaster createdById(Integer createdById) {
        this.setCreatedById(createdById);
        return this;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return this.createdByName;
    }

    public SalesOrderMaster createdByName(String createdByName) {
        this.setCreatedByName(createdByName);
        return this;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public SalesOrderMaster createdDate(ZonedDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getConfirmationById() {
        return this.confirmationById;
    }

    public SalesOrderMaster confirmationById(Integer confirmationById) {
        this.setConfirmationById(confirmationById);
        return this;
    }

    public void setConfirmationById(Integer confirmationById) {
        this.confirmationById = confirmationById;
    }

    public String getConfirmationByName() {
        return this.confirmationByName;
    }

    public SalesOrderMaster confirmationByName(String confirmationByName) {
        this.setConfirmationByName(confirmationByName);
        return this;
    }

    public void setConfirmationByName(String confirmationByName) {
        this.confirmationByName = confirmationByName;
    }

    public ZonedDateTime getConfirmationDate() {
        return this.confirmationDate;
    }

    public SalesOrderMaster confirmationDate(ZonedDateTime confirmationDate) {
        this.setConfirmationDate(confirmationDate);
        return this;
    }

    public void setConfirmationDate(ZonedDateTime confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Integer getUpdatedById() {
        return this.updatedById;
    }

    public SalesOrderMaster updatedById(Integer updatedById) {
        this.setUpdatedById(updatedById);
        return this;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return this.updatedByName;
    }

    public SalesOrderMaster updatedByName(String updatedByName) {
        this.setUpdatedByName(updatedByName);
        return this;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public SalesOrderMaster updatedDate(ZonedDateTime updatedDate) {
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
        return "SalesOrderMaster{" +
            ", salesOderId=" + getSalesOderId() +
            ", salesOderNo='" + getSalesOderNo() + "'" +
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
