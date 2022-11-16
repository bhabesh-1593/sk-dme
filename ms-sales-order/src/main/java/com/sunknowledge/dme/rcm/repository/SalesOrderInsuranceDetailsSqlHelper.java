package com.sunknowledge.dme.rcm.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class SalesOrderInsuranceDetailsSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("sales_order_insurance_details_id", table, columnPrefix + "_sales_order_insurance_details_id"));
        columns.add(Column.aliased("sales_order_id", table, columnPrefix + "_sales_order_id"));
        columns.add(Column.aliased("patient_id", table, columnPrefix + "_patient_id"));
        columns.add(Column.aliased("primary_insurer_id", table, columnPrefix + "_primary_insurer_id"));
        columns.add(Column.aliased("primary_insurer_name", table, columnPrefix + "_primary_insurer_name"));
        columns.add(Column.aliased("primary_insurance_group_id", table, columnPrefix + "_primary_insurance_group_id"));
        columns.add(Column.aliased("primary_insurance_group_name", table, columnPrefix + "_primary_insurance_group_name"));
        columns.add(Column.aliased("primary_insurance_plan_id", table, columnPrefix + "_primary_insurance_plan_id"));
        columns.add(Column.aliased("primary_insurance_plan_type", table, columnPrefix + "_primary_insurance_plan_type"));
        columns.add(Column.aliased("primary_insurance_state_id", table, columnPrefix + "_primary_insurance_state_id"));
        columns.add(Column.aliased("primary_insurance_state_name", table, columnPrefix + "_primary_insurance_state_name"));
        columns.add(Column.aliased("primary_insurer_policy_no", table, columnPrefix + "_primary_insurer_policy_no"));
        columns.add(Column.aliased("primary_insurer_patient_id_number", table, columnPrefix + "_primary_insurer_patient_id_number"));
        columns.add(Column.aliased("primary_insurer_effective_date", table, columnPrefix + "_primary_insurer_effective_date"));
        columns.add(Column.aliased("primary_insurer_verification_status", table, columnPrefix + "_primary_insurer_verification_status"));
        columns.add(Column.aliased("primary_insurer_verification_date", table, columnPrefix + "_primary_insurer_verification_date"));
        columns.add(Column.aliased("primary_insurer_pay_percentage", table, columnPrefix + "_primary_insurer_pay_percentage"));
        columns.add(Column.aliased("primary_box_10_d", table, columnPrefix + "_primary_box_10_d"));
        columns.add(Column.aliased("primary_box_19", table, columnPrefix + "_primary_box_19"));
        columns.add(Column.aliased("primary_box_24_ia", table, columnPrefix + "_primary_box_24_ia"));
        columns.add(Column.aliased("primary_box_24_ja", table, columnPrefix + "_primary_box_24_ja"));
        columns.add(Column.aliased("primary_box_24_jb", table, columnPrefix + "_primary_box_24_jb"));
        columns.add(Column.aliased("primary_include_box_24_jbstatus", table, columnPrefix + "_primary_include_box_24_jbstatus"));
        columns.add(
            Column.aliased("primary_include_payer_sales_order_status", table, columnPrefix + "_primary_include_payer_sales_order_status")
        );
        columns.add(
            Column.aliased(
                "primary_wait_for_previous_payer_before_billing_status",
                table,
                columnPrefix + "_primary_wait_for_previous_payer_before_billing_status"
            )
        );
        columns.add(Column.aliased("primary_pay_percentage_status", table, columnPrefix + "_primary_pay_percentage_status"));
        columns.add(Column.aliased("secondary_insurer_id", table, columnPrefix + "_secondary_insurer_id"));
        columns.add(Column.aliased("secondary_insurer_name", table, columnPrefix + "_secondary_insurer_name"));
        columns.add(Column.aliased("secondary_insurance_group_id", table, columnPrefix + "_secondary_insurance_group_id"));
        columns.add(Column.aliased("secondary_insurance_group_name", table, columnPrefix + "_secondary_insurance_group_name"));
        columns.add(Column.aliased("secondary_insurance_plan_id", table, columnPrefix + "_secondary_insurance_plan_id"));
        columns.add(Column.aliased("secondary_insurance_plan_type", table, columnPrefix + "_secondary_insurance_plan_type"));
        columns.add(Column.aliased("secondary_insurance_state_id", table, columnPrefix + "_secondary_insurance_state_id"));
        columns.add(Column.aliased("secondary_insurance_state_name", table, columnPrefix + "_secondary_insurance_state_name"));
        columns.add(Column.aliased("secondary_insurer_policy_no", table, columnPrefix + "_secondary_insurer_policy_no"));
        columns.add(Column.aliased("secondary_insurer_patient_id_number", table, columnPrefix + "_secondary_insurer_patient_id_number"));
        columns.add(Column.aliased("secondary_insurer_effective_date", table, columnPrefix + "_secondary_insurer_effective_date"));
        columns.add(
            Column.aliased("secondary_insurer_verification_status", table, columnPrefix + "_secondary_insurer_verification_status")
        );
        columns.add(Column.aliased("secondary_insurer_verification_date", table, columnPrefix + "_secondary_insurer_verification_date"));
        columns.add(Column.aliased("secondary_insurer_pay_percentage", table, columnPrefix + "_secondary_insurer_pay_percentage"));
        columns.add(Column.aliased("secondary_box_10_d", table, columnPrefix + "_secondary_box_10_d"));
        columns.add(Column.aliased("secondary_box_19", table, columnPrefix + "_secondary_box_19"));
        columns.add(Column.aliased("secondary_box_24_ia", table, columnPrefix + "_secondary_box_24_ia"));
        columns.add(Column.aliased("secondary_box_24_ja", table, columnPrefix + "_secondary_box_24_ja"));
        columns.add(Column.aliased("secondary_box_24_jb", table, columnPrefix + "_secondary_box_24_jb"));
        columns.add(Column.aliased("secondary_include_box_24_jb_status", table, columnPrefix + "_secondary_include_box_24_jb_status"));
        columns.add(
            Column.aliased(
                "secondary_include_payer_sales_order_status",
                table,
                columnPrefix + "_secondary_include_payer_sales_order_status"
            )
        );
        columns.add(
            Column.aliased(
                "secondary_wait_previous_payer_befr_billing_status",
                table,
                columnPrefix + "_secondary_wait_previous_payer_befr_billing_status"
            )
        );
        columns.add(Column.aliased("secondary_pay_percentage_status", table, columnPrefix + "_secondary_pay_percentage_status"));
        columns.add(Column.aliased("tertiary_insurer_id", table, columnPrefix + "_tertiary_insurer_id"));
        columns.add(Column.aliased("tertiary_insurer_name", table, columnPrefix + "_tertiary_insurer_name"));
        columns.add(Column.aliased("tertiary_insurance_group_id", table, columnPrefix + "_tertiary_insurance_group_id"));
        columns.add(Column.aliased("tertiary_insurance_group_name", table, columnPrefix + "_tertiary_insurance_group_name"));
        columns.add(Column.aliased("tertiary_insurance_plan_id", table, columnPrefix + "_tertiary_insurance_plan_id"));
        columns.add(Column.aliased("tertiary_insurance_plan_type", table, columnPrefix + "_tertiary_insurance_plan_type"));
        columns.add(Column.aliased("tertiary_insurance_state_id", table, columnPrefix + "_tertiary_insurance_state_id"));
        columns.add(Column.aliased("tertiary_insurance_state_name", table, columnPrefix + "_tertiary_insurance_state_name"));
        columns.add(Column.aliased("tertiary_insurer_policyno", table, columnPrefix + "_tertiary_insurer_policyno"));
        columns.add(Column.aliased("tertiary_insurer_patient_id_number", table, columnPrefix + "_tertiary_insurer_patient_id_number"));
        columns.add(Column.aliased("tertiary_insurer_effective_date", table, columnPrefix + "_tertiary_insurer_effective_date"));
        columns.add(Column.aliased("tertiary_insurer_verification_status", table, columnPrefix + "_tertiary_insurer_verification_status"));
        columns.add(Column.aliased("tertiary_insurer_verification_date", table, columnPrefix + "_tertiary_insurer_verification_date"));
        columns.add(Column.aliased("tertiary_insurer_pay_percentage", table, columnPrefix + "_tertiary_insurer_pay_percentage"));
        columns.add(Column.aliased("tertiary_box_10_d", table, columnPrefix + "_tertiary_box_10_d"));
        columns.add(Column.aliased("tertiary_box_19", table, columnPrefix + "_tertiary_box_19"));
        columns.add(Column.aliased("tertiary_box_24_ia", table, columnPrefix + "_tertiary_box_24_ia"));
        columns.add(Column.aliased("tertiary_box_24_ja", table, columnPrefix + "_tertiary_box_24_ja"));
        columns.add(Column.aliased("tertiary_box_24_jb", table, columnPrefix + "_tertiary_box_24_jb"));
        columns.add(Column.aliased("tertiary_include_box_24_jb_status", table, columnPrefix + "_tertiary_include_box_24_jb_status"));
        columns.add(
            Column.aliased(
                "tertiary_include_payer_in_sales_order_status",
                table,
                columnPrefix + "_tertiary_include_payer_in_sales_order_status"
            )
        );
        columns.add(
            Column.aliased(
                "tertiary_wait_previous_payer_before_billing_status",
                table,
                columnPrefix + "_tertiary_wait_previous_payer_before_billing_status"
            )
        );
        columns.add(Column.aliased("tertiary_pay_percentage_0_status", table, columnPrefix + "_tertiary_pay_percentage_0_status"));
        columns.add(Column.aliased("insurance_verification_status", table, columnPrefix + "_insurance_verification_status"));
        columns.add(Column.aliased("coverage_verification_status", table, columnPrefix + "_coverage_verification_status"));
        columns.add(
            Column.aliased("exclude_from_eligibility_check_status", table, columnPrefix + "_exclude_from_eligibility_check_status")
        );
        columns.add(Column.aliased("patient_pay_percentage", table, columnPrefix + "_patient_pay_percentage"));
        columns.add(
            Column.aliased(
                "patient_include_this_payor_in_sales_order_status",
                table,
                columnPrefix + "_patient_include_this_payor_in_sales_order_status"
            )
        );
        columns.add(
            Column.aliased(
                "patient_wait_for_previous_payer_before_billing_status",
                table,
                columnPrefix + "_patient_wait_for_previous_payer_before_billing_status"
            )
        );
        columns.add(Column.aliased("workers_comp_date_of_onset", table, columnPrefix + "_workers_comp_date_of_onset"));
        columns.add(
            Column.aliased(
                "workers_comp_injury_related_employment_status",
                table,
                columnPrefix + "_workers_comp_injury_related_employment_status"
            )
        );
        columns.add(
            Column.aliased(
                "workers_comp_injury_related_auto_accident_status",
                table,
                columnPrefix + "_workers_comp_injury_related_auto_accident_status"
            )
        );
        columns.add(Column.aliased("workers_comp_auto_accident_state_id", table, columnPrefix + "_workers_comp_auto_accident_state_id"));
        columns.add(
            Column.aliased(
                "workers_comp_injury_related_to_other_accident_status",
                table,
                columnPrefix + "_workers_comp_injury_related_to_other_accident_status"
            )
        );
        columns.add(Column.aliased("eclaims_attachment_status", table, columnPrefix + "_eclaims_attachment_status"));
        columns.add(Column.aliased("attachment_number", table, columnPrefix + "_attachment_number"));
        columns.add(Column.aliased("type_code", table, columnPrefix + "_type_code"));
        columns.add(Column.aliased("transaction_code", table, columnPrefix + "_transaction_code"));
        columns.add(Column.aliased("claims_note_type", table, columnPrefix + "_claims_note_type"));
        columns.add(Column.aliased("claims_note", table, columnPrefix + "_claims_note"));
        columns.add(Column.aliased("sales_order_no", table, columnPrefix + "_sales_order_no"));
        columns.add(Column.aliased("status", table, columnPrefix + "_status"));
        columns.add(Column.aliased("created_by_id", table, columnPrefix + "_created_by_id"));
        columns.add(Column.aliased("created_by_name", table, columnPrefix + "_created_by_name"));
        columns.add(Column.aliased("created_date", table, columnPrefix + "_created_date"));
        columns.add(Column.aliased("updated_by_id", table, columnPrefix + "_updated_by_id"));
        columns.add(Column.aliased("updated_by_name", table, columnPrefix + "_updated_by_name"));
        columns.add(Column.aliased("updated_date", table, columnPrefix + "_updated_date"));
        columns.add(Column.aliased("sales_order_insurance_details_uuid", table, columnPrefix + "_sales_order_insurance_details_uuid"));
        columns.add(Column.aliased("primary_insurer_payer_id", table, columnPrefix + "_primary_insurer_payer_id"));
        columns.add(Column.aliased("tertiary_insurer_payer_id", table, columnPrefix + "_tertiary_insurer_payer_id"));
        columns.add(Column.aliased("secondary_insurer_payer_id", table, columnPrefix + "_secondary_insurer_payer_id"));

        columns.add(Column.aliased("sales_order_master_sales_order_id", table, columnPrefix + "_sales_order_master_sales_order_id"));
        return columns;
    }
}
