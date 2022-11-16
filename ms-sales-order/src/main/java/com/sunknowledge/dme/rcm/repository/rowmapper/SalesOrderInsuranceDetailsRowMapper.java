package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails;
import io.r2dbc.spi.Row;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link SalesOrderInsuranceDetails}, with proper type conversions.
 */
@Service
public class SalesOrderInsuranceDetailsRowMapper implements BiFunction<Row, String, SalesOrderInsuranceDetails> {

    private final ColumnConverter converter;

    public SalesOrderInsuranceDetailsRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link SalesOrderInsuranceDetails} stored in the database.
     */
    @Override
    public SalesOrderInsuranceDetails apply(Row row, String prefix) {
        SalesOrderInsuranceDetails entity = new SalesOrderInsuranceDetails();
        entity.setSalesOrderInsuranceDetailsId(converter.fromRow(row, prefix + "_sales_order_insurance_details_id", Long.class));
        entity.setSalesOrderId(converter.fromRow(row, prefix + "_sales_order_id", Long.class));
        entity.setPatientId(converter.fromRow(row, prefix + "_patient_id", Integer.class));
        entity.setPrimaryInsurerId(converter.fromRow(row, prefix + "_primary_insurer_id", Integer.class));
        entity.setPrimaryInsurerName(converter.fromRow(row, prefix + "_primary_insurer_name", String.class));
        entity.setPrimaryInsuranceGroupId(converter.fromRow(row, prefix + "_primary_insurance_group_id", Integer.class));
        entity.setPrimaryInsuranceGroupName(converter.fromRow(row, prefix + "_primary_insurance_group_name", String.class));
        entity.setPrimaryInsurancePlanId(converter.fromRow(row, prefix + "_primary_insurance_plan_id", Integer.class));
        entity.setPrimaryInsurancePlanType(converter.fromRow(row, prefix + "_primary_insurance_plan_type", String.class));
        entity.setPrimaryInsuranceStateId(converter.fromRow(row, prefix + "_primary_insurance_state_id", Integer.class));
        entity.setPrimaryInsuranceStateName(converter.fromRow(row, prefix + "_primary_insurance_state_name", String.class));
        entity.setPrimaryInsurerPolicyNo(converter.fromRow(row, prefix + "_primary_insurer_policy_no", String.class));
        entity.setPrimaryInsurerPatientIdNumber(converter.fromRow(row, prefix + "_primary_insurer_patient_id_number", String.class));
        entity.setPrimaryInsurerEffectiveDate(converter.fromRow(row, prefix + "_primary_insurer_effective_date", LocalDate.class));
        entity.setPrimaryInsurerVerificationStatus(converter.fromRow(row, prefix + "_primary_insurer_verification_status", String.class));
        entity.setPrimaryInsurerVerificationDate(converter.fromRow(row, prefix + "_primary_insurer_verification_date", LocalDate.class));
        entity.setPrimaryInsurerPayPercentage(converter.fromRow(row, prefix + "_primary_insurer_pay_percentage", Integer.class));
        entity.setPrimaryBox10d(converter.fromRow(row, prefix + "_primary_box_10_d", String.class));
        entity.setPrimaryBox19(converter.fromRow(row, prefix + "_primary_box_19", String.class));
        entity.setPrimaryBox24ia(converter.fromRow(row, prefix + "_primary_box_24_ia", String.class));
        entity.setPrimaryBox24ja(converter.fromRow(row, prefix + "_primary_box_24_ja", String.class));
        entity.setPrimaryBox24jb(converter.fromRow(row, prefix + "_primary_box_24_jb", String.class));
        entity.setPrimaryIncludeBox24Jbstatus(converter.fromRow(row, prefix + "_primary_include_box_24_jbstatus", String.class));
        entity.setPrimaryIncludePayerSalesOrderStatus(
            converter.fromRow(row, prefix + "_primary_include_payer_sales_order_status", String.class)
        );
        entity.setPrimaryWaitForPreviousPayerBeforeBillingStatus(
            converter.fromRow(row, prefix + "_primary_wait_for_previous_payer_before_billing_status", String.class)
        );
        entity.setPrimaryPayPercentageStatus(converter.fromRow(row, prefix + "_primary_pay_percentage_status", String.class));
        entity.setSecondaryInsurerId(converter.fromRow(row, prefix + "_secondary_insurer_id", Integer.class));
        entity.setSecondaryInsurerName(converter.fromRow(row, prefix + "_secondary_insurer_name", String.class));
        entity.setSecondaryInsuranceGroupId(converter.fromRow(row, prefix + "_secondary_insurance_group_id", Integer.class));
        entity.setSecondaryInsuranceGroupName(converter.fromRow(row, prefix + "_secondary_insurance_group_name", String.class));
        entity.setSecondaryInsurancePlanId(converter.fromRow(row, prefix + "_secondary_insurance_plan_id", Integer.class));
        entity.setSecondaryInsurancePlanType(converter.fromRow(row, prefix + "_secondary_insurance_plan_type", String.class));
        entity.setSecondaryInsuranceStateId(converter.fromRow(row, prefix + "_secondary_insurance_state_id", Integer.class));
        entity.setSecondaryInsuranceStateName(converter.fromRow(row, prefix + "_secondary_insurance_state_name", String.class));
        entity.setSecondaryInsurerPolicyNo(converter.fromRow(row, prefix + "_secondary_insurer_policy_no", String.class));
        entity.setSecondaryInsurerPatientIdNumber(converter.fromRow(row, prefix + "_secondary_insurer_patient_id_number", String.class));
        entity.setSecondaryInsurerEffectiveDate(converter.fromRow(row, prefix + "_secondary_insurer_effective_date", LocalDate.class));
        entity.setSecondaryInsurerVerificationStatus(
            converter.fromRow(row, prefix + "_secondary_insurer_verification_status", String.class)
        );
        entity.setSecondaryInsurerVerificationDate(
            converter.fromRow(row, prefix + "_secondary_insurer_verification_date", LocalDate.class)
        );
        entity.setSecondaryInsurerPayPercentage(converter.fromRow(row, prefix + "_secondary_insurer_pay_percentage", Integer.class));
        entity.setSecondaryBox10d(converter.fromRow(row, prefix + "_secondary_box_10_d", String.class));
        entity.setSecondaryBox19(converter.fromRow(row, prefix + "_secondary_box_19", String.class));
        entity.setSecondaryBox24ia(converter.fromRow(row, prefix + "_secondary_box_24_ia", String.class));
        entity.setSecondaryBox24ja(converter.fromRow(row, prefix + "_secondary_box_24_ja", String.class));
        entity.setSecondaryBox24jb(converter.fromRow(row, prefix + "_secondary_box_24_jb", String.class));
        entity.setSecondaryIncludeBox24jbStatus(converter.fromRow(row, prefix + "_secondary_include_box_24_jb_status", String.class));
        entity.setSecondaryIncludePayerSalesOrderStatus(
            converter.fromRow(row, prefix + "_secondary_include_payer_sales_order_status", String.class)
        );
        entity.setSecondaryWaitPreviousPayerBefrBillingStatus(
            converter.fromRow(row, prefix + "_secondary_wait_previous_payer_befr_billing_status", String.class)
        );
        entity.setSecondaryPayPercentageStatus(converter.fromRow(row, prefix + "_secondary_pay_percentage_status", String.class));
        entity.setTertiaryInsurerId(converter.fromRow(row, prefix + "_tertiary_insurer_id", Integer.class));
        entity.setTertiaryInsurerName(converter.fromRow(row, prefix + "_tertiary_insurer_name", String.class));
        entity.setTertiaryInsuranceGroupId(converter.fromRow(row, prefix + "_tertiary_insurance_group_id", Integer.class));
        entity.setTertiaryInsuranceGroupName(converter.fromRow(row, prefix + "_tertiary_insurance_group_name", String.class));
        entity.setTertiaryInsurancePlanId(converter.fromRow(row, prefix + "_tertiary_insurance_plan_id", Integer.class));
        entity.setTertiaryInsurancePlanType(converter.fromRow(row, prefix + "_tertiary_insurance_plan_type", String.class));
        entity.setTertiaryInsuranceStateId(converter.fromRow(row, prefix + "_tertiary_insurance_state_id", Integer.class));
        entity.setTertiaryInsuranceStateName(converter.fromRow(row, prefix + "_tertiary_insurance_state_name", String.class));
        entity.setTertiaryInsurerPolicyno(converter.fromRow(row, prefix + "_tertiary_insurer_policyno", String.class));
        entity.setTertiaryInsurerPatientIdNumber(converter.fromRow(row, prefix + "_tertiary_insurer_patient_id_number", String.class));
        entity.setTertiaryInsurerEffectiveDate(converter.fromRow(row, prefix + "_tertiary_insurer_effective_date", LocalDate.class));
        entity.setTertiaryInsurerVerificationStatus(converter.fromRow(row, prefix + "_tertiary_insurer_verification_status", String.class));
        entity.setTertiaryInsurerVerificationDate(converter.fromRow(row, prefix + "_tertiary_insurer_verification_date", LocalDate.class));
        entity.setTertiaryInsurerPayPercentage(converter.fromRow(row, prefix + "_tertiary_insurer_pay_percentage", Integer.class));
        entity.setTertiaryBox10d(converter.fromRow(row, prefix + "_tertiary_box_10_d", String.class));
        entity.setTertiaryBox19(converter.fromRow(row, prefix + "_tertiary_box_19", String.class));
        entity.setTertiaryBox24ia(converter.fromRow(row, prefix + "_tertiary_box_24_ia", String.class));
        entity.setTertiaryBox24ja(converter.fromRow(row, prefix + "_tertiary_box_24_ja", String.class));
        entity.setTertiaryBox24jb(converter.fromRow(row, prefix + "_tertiary_box_24_jb", String.class));
        entity.setTertiaryIncludeBox24jbStatus(converter.fromRow(row, prefix + "_tertiary_include_box_24_jb_status", String.class));
        entity.setTertiaryIncludePayerInSalesOrderStatus(
            converter.fromRow(row, prefix + "_tertiary_include_payer_in_sales_order_status", String.class)
        );
        entity.setTertiaryWaitPreviousPayerBeforeBillingStatus(
            converter.fromRow(row, prefix + "_tertiary_wait_previous_payer_before_billing_status", String.class)
        );
        entity.setTertiaryPayPercentage0Status(converter.fromRow(row, prefix + "_tertiary_pay_percentage_0_status", String.class));
        entity.setInsuranceVerificationStatus(converter.fromRow(row, prefix + "_insurance_verification_status", String.class));
        entity.setCoverageVerificationStatus(converter.fromRow(row, prefix + "_coverage_verification_status", String.class));
        entity.setExcludeFromEligibilityCheckStatus(
            converter.fromRow(row, prefix + "_exclude_from_eligibility_check_status", String.class)
        );
        entity.setPatientPayPercentage(converter.fromRow(row, prefix + "_patient_pay_percentage", String.class));
        entity.setPatientIncludeThisPayorInSalesOrderStatus(
            converter.fromRow(row, prefix + "_patient_include_this_payor_in_sales_order_status", String.class)
        );
        entity.setPatientWaitForPreviousPayerBeforeBillingStatus(
            converter.fromRow(row, prefix + "_patient_wait_for_previous_payer_before_billing_status", String.class)
        );
        entity.setWorkersCompDateOfOnset(converter.fromRow(row, prefix + "_workers_comp_date_of_onset", LocalDate.class));
        entity.setWorkersCompInjuryRelatedEmploymentStatus(
            converter.fromRow(row, prefix + "_workers_comp_injury_related_employment_status", String.class)
        );
        entity.setWorkersCompInjuryRelatedAutoAccidentStatus(
            converter.fromRow(row, prefix + "_workers_comp_injury_related_auto_accident_status", String.class)
        );
        entity.setWorkersCompAutoAccidentStateId(converter.fromRow(row, prefix + "_workers_comp_auto_accident_state_id", Integer.class));
        entity.setWorkersCompInjuryRelatedToOtherAccidentStatus(
            converter.fromRow(row, prefix + "_workers_comp_injury_related_to_other_accident_status", String.class)
        );
        entity.setEclaimsAttachmentStatus(converter.fromRow(row, prefix + "_eclaims_attachment_status", String.class));
        entity.setAttachmentNumber(converter.fromRow(row, prefix + "_attachment_number", Integer.class));
        entity.setTypeCode(converter.fromRow(row, prefix + "_type_code", String.class));
        entity.setTransactionCode(converter.fromRow(row, prefix + "_transaction_code", String.class));
        entity.setClaimsNoteType(converter.fromRow(row, prefix + "_claims_note_type", String.class));
        entity.setClaimsNote(converter.fromRow(row, prefix + "_claims_note", String.class));
        entity.setSalesOrderNo(converter.fromRow(row, prefix + "_sales_order_no", String.class));
        entity.setStatus(converter.fromRow(row, prefix + "_status", String.class));
        entity.setCreatedById(converter.fromRow(row, prefix + "_created_by_id", Integer.class));
        entity.setCreatedByName(converter.fromRow(row, prefix + "_created_by_name", String.class));
        entity.setCreatedDate(converter.fromRow(row, prefix + "_created_date", ZonedDateTime.class));
        entity.setUpdatedById(converter.fromRow(row, prefix + "_updated_by_id", Integer.class));
        entity.setUpdatedByName(converter.fromRow(row, prefix + "_updated_by_name", String.class));
        entity.setUpdatedDate(converter.fromRow(row, prefix + "_updated_date", ZonedDateTime.class));
        entity.setSalesOrderMasterId(converter.fromRow(row, prefix + "_sales_order_master_sales_order_id", Long.class));
        return entity;
    }
}
