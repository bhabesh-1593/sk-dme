package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import io.r2dbc.spi.Row;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link SalesOrderMaster}, with proper type conversions.
 */
@Service
public class SalesOrderMasterRowMapper implements BiFunction<Row, String, SalesOrderMaster> {

    private final ColumnConverter converter;

    public SalesOrderMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link SalesOrderMaster} stored in the database.
     */
    @Override
    public SalesOrderMaster apply(Row row, String prefix) {
        SalesOrderMaster entity = new SalesOrderMaster();
        entity.setSalesOrderId(converter.fromRow(row, prefix + "_sales_order_id", Long.class));
        entity.setSalesOrderNo(converter.fromRow(row, prefix + "_sales_order_no", String.class));
        entity.setPatientId(converter.fromRow(row, prefix + "_patient_id", Integer.class));
        entity.setPatientFirstName(converter.fromRow(row, prefix + "_patient_first_name", String.class));
        entity.setPatientMiddleName(converter.fromRow(row, prefix + "_patient_middle_name", String.class));
        entity.setPatientLastName(converter.fromRow(row, prefix + "_patient_last_name", String.class));
        entity.setPatientAddressId(converter.fromRow(row, prefix + "_patient_address_id", Integer.class));
        entity.setPatientAddressLine1(converter.fromRow(row, prefix + "_patient_address_line_1", String.class));
        entity.setPatientAddressLine2(converter.fromRow(row, prefix + "_patient_address_line_2", String.class));
        entity.setCityName(converter.fromRow(row, prefix + "_city_name", String.class));
        entity.setStateName(converter.fromRow(row, prefix + "_state_name", String.class));
        entity.setZipCode(converter.fromRow(row, prefix + "_zip_code", String.class));
        entity.setPatientContactId(converter.fromRow(row, prefix + "_patient_contact_id", Integer.class));
        entity.setPhone1(converter.fromRow(row, prefix + "_phone_1", String.class));
        entity.setPhone2(converter.fromRow(row, prefix + "_phone_2", String.class));
        entity.setPatientDob(converter.fromRow(row, prefix + "_patient_dob", LocalDate.class));
        entity.setPatientHeight(converter.fromRow(row, prefix + "_patient_height", Double.class));
        entity.setPatientWeight(converter.fromRow(row, prefix + "_patient_weight", Double.class));
        entity.setPatientSsn(converter.fromRow(row, prefix + "_patient_ssn", String.class));
        entity.setPatientGender(converter.fromRow(row, prefix + "_patient_gender", String.class));
        entity.setPatientBranchId(converter.fromRow(row, prefix + "_patient_branch_id", Integer.class));
        entity.setBranchName(converter.fromRow(row, prefix + "_branch_name", String.class));
        entity.setPatientDod(converter.fromRow(row, prefix + "_patient_dod", LocalDate.class));
        entity.setHipaaOnFileStatus(converter.fromRow(row, prefix + "_hipaa_on_file_status", String.class));
        entity.setFacilityId(converter.fromRow(row, prefix + "_facility_id", Integer.class));
        entity.setFacilityName(converter.fromRow(row, prefix + "_facility_name", String.class));
        entity.setFacilityNPI(converter.fromRow(row, prefix + "_facility_npi", String.class));
        entity.setDeliveryScheduleDatetime(converter.fromRow(row, prefix + "_delivery_schedule_datetime", ZonedDateTime.class));
        entity.setDeliveryActualDatetime(converter.fromRow(row, prefix + "_delivery_actual_datetime", ZonedDateTime.class));
        entity.setDeliveryAddressLine1(converter.fromRow(row, prefix + "_delivery_address_line_1", String.class));
        entity.setDeliveryAddressLine2(converter.fromRow(row, prefix + "_delivery_address_line_2", String.class));
        entity.setDeliveryCityName(converter.fromRow(row, prefix + "_delivery_city_name", String.class));
        entity.setDeliveryStateName(converter.fromRow(row, prefix + "_delivery_state_name", String.class));
        entity.setDeliveryZipCode(converter.fromRow(row, prefix + "_delivery_zip_code", String.class));
        entity.setDeliveryPhoneNo1(converter.fromRow(row, prefix + "_delivery_phone_no_1", String.class));
        entity.setDeliveryPhoneNo2(converter.fromRow(row, prefix + "_delivery_phone_no_2", String.class));
        entity.setDeliveryBranchId(converter.fromRow(row, prefix + "_delivery_branch_id", Integer.class));
        entity.setDeliveryBranchName(converter.fromRow(row, prefix + "_delivery_branch_name", String.class));
        entity.setTaxZoneId(converter.fromRow(row, prefix + "_tax_zone_id", Integer.class));
        entity.setTaxRate(converter.fromRow(row, prefix + "_tax_rate", Double.class));
        entity.setSalesOrderNote(converter.fromRow(row, prefix + "_sales_order_note", String.class));
        entity.setDeliveryNote(converter.fromRow(row, prefix + "_delivery_note", String.class));
        entity.setDeliveryTechnician(converter.fromRow(row, prefix + "_delivery_technician", String.class));
        entity.setSignatureRequiredStatus(converter.fromRow(row, prefix + "_signature_required_status", String.class));
        entity.setPodStatus(converter.fromRow(row, prefix + "_pod_status", String.class));
        entity.setPodStatusDateTime(converter.fromRow(row, prefix + "_pod_status_date_time", ZonedDateTime.class));
        entity.setPodLastMessage(converter.fromRow(row, prefix + "_pod_last_message", String.class));
        entity.setPodMessageDateTime(converter.fromRow(row, prefix + "_pod_message_date_time", ZonedDateTime.class));
        entity.setMutualHoldStatus(converter.fromRow(row, prefix + "_mutual_hold_status", String.class));
        entity.setHoldReasonId(converter.fromRow(row, prefix + "_hold_reason_id", Integer.class));
        entity.setHoldStatus(converter.fromRow(row, prefix + "_hold_status", String.class));
        entity.setHoldReasonDescription(converter.fromRow(row, prefix + "_hold_reason_description", String.class));
        entity.setStopDate(converter.fromRow(row, prefix + "_stop_date", LocalDate.class));
        entity.setStopReasonId(converter.fromRow(row, prefix + "_stop_reason_id", Integer.class));
        entity.setStopReasonDescription(converter.fromRow(row, prefix + "_stop_reason_description", String.class));
        entity.setInventoryLocationId(converter.fromRow(row, prefix + "_inventory_location_id", Integer.class));
        entity.setOrderStatus(converter.fromRow(row, prefix + "_order_status", String.class));
        entity.setOrderClassificationId(converter.fromRow(row, prefix + "_order_classification_id", Integer.class));
        entity.setPosId(converter.fromRow(row, prefix + "_pos_id", Integer.class));
        entity.setPosName(converter.fromRow(row, prefix + "_pos_name", String.class));
        entity.setAdmissionDate(converter.fromRow(row, prefix + "_admission_date", LocalDate.class));
        entity.setDischargeDate(converter.fromRow(row, prefix + "_discharge_date", LocalDate.class));
        entity.setDiscountPercentage(converter.fromRow(row, prefix + "_discount_percentage", Integer.class));
        entity.setPoNumber(converter.fromRow(row, prefix + "_po_number", String.class));
        entity.setUserField1(converter.fromRow(row, prefix + "_user_field_1", String.class));
        entity.setUserField2(converter.fromRow(row, prefix + "_user_field_2", String.class));
        entity.setUserField3(converter.fromRow(row, prefix + "_user_field_3", String.class));
        entity.setUserField4(converter.fromRow(row, prefix + "_user_field_4", String.class));
        entity.setReference(converter.fromRow(row, prefix + "_reference", String.class));
        entity.setWipStatus(converter.fromRow(row, prefix + "_wip_status", String.class));
        entity.setWipDaysInState(converter.fromRow(row, prefix + "_wip_days_in_state", Integer.class));
        entity.setWipAssignedToId(converter.fromRow(row, prefix + "_wip_assigned_to_id", Integer.class));
        entity.setWipDateNeeded(converter.fromRow(row, prefix + "_wip_date_needed", LocalDate.class));
        entity.setCompletedStatus(converter.fromRow(row, prefix + "_completed_status", String.class));
        entity.setStatus(converter.fromRow(row, prefix + "_status", String.class));
        entity.setCreatedById(converter.fromRow(row, prefix + "_created_by_id", Integer.class));
        entity.setCreatedByName(converter.fromRow(row, prefix + "_created_by_name", String.class));
        entity.setCreatedDate(converter.fromRow(row, prefix + "_created_date", ZonedDateTime.class));
        entity.setConfirmationById(converter.fromRow(row, prefix + "_confirmation_by_id", Integer.class));
        entity.setConfirmationByName(converter.fromRow(row, prefix + "_confirmation_by_name", String.class));
        entity.setConfirmationDate(converter.fromRow(row, prefix + "_confirmation_date", ZonedDateTime.class));
        entity.setUpdatedById(converter.fromRow(row, prefix + "_updated_by_id", Integer.class));
        entity.setUpdatedByName(converter.fromRow(row, prefix + "_updated_by_name", String.class));
        entity.setUpdatedDate(converter.fromRow(row, prefix + "_updated_date", ZonedDateTime.class));
        return entity;
    }
}
