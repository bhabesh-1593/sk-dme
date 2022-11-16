package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails;
import io.r2dbc.spi.Row;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link SalesOrderItemDetails}, with proper type conversions.
 */
@Service
public class SalesOrderItemDetailsRowMapper implements BiFunction<Row, String, SalesOrderItemDetails> {

    private final ColumnConverter converter;

    public SalesOrderItemDetailsRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link SalesOrderItemDetails} stored in the database.
     */
    @Override
    public SalesOrderItemDetails apply(Row row, String prefix) {
        SalesOrderItemDetails entity = new SalesOrderItemDetails();
        entity.setSalesOrderItemDetailsId(converter.fromRow(row, prefix + "_sales_order_item_details_id", Long.class));
        entity.setSalesOrderId(converter.fromRow(row, prefix + "_sales_order_id", Long.class));
        entity.setPatientId(converter.fromRow(row, prefix + "_patient_id", Integer.class));
        entity.setItemLocationId(converter.fromRow(row, prefix + "_item_location_id", Integer.class));
        entity.setSalesOrderDetailItemId(converter.fromRow(row, prefix + "_sales_order_detail_item_id", Long.class));
        entity.setSalesOrderDetailItemName(converter.fromRow(row, prefix + "_sales_order_detail_item_name", String.class));
        entity.setSalesOrderDetailStockingUom(converter.fromRow(row, prefix + "_sales_order_detail_stocking_uom", String.class));
        entity.setSalesOrderDetailStockingUomName(converter.fromRow(row, prefix + "_sales_order_detail_stocking_uom_name", String.class));
        entity.setSalesOrderDetailItemDescription(converter.fromRow(row, prefix + "_sales_order_detail_item_description", String.class));
        entity.setSalesOrderDetailDefaultVendor(converter.fromRow(row, prefix + "_sales_order_detail_default_vendor", String.class));
        entity.setSalesOrderDetailOriginalDos(converter.fromRow(row, prefix + "_sales_order_detail_original_dos", LocalDate.class));
        entity.setSalesOrderDetailPreviousBillingDate(
            converter.fromRow(row, prefix + "_sales_order_detail_previous_billing_date", LocalDate.class)
        );
        entity.setSalesOrderDetailNextBillingDate(
            converter.fromRow(row, prefix + "_sales_order_detail_next_billing_date", LocalDate.class)
        );
        entity.setSalesOrderDetailDosTo(converter.fromRow(row, prefix + "_sales_order_detail_dos_to", LocalDate.class));
        entity.setSalesOrderDetailNextPeriod(converter.fromRow(row, prefix + "_sales_order_detail_next_period", String.class));
        entity.setSalesOrderDetailSpecialPricing(converter.fromRow(row, prefix + "_sales_order_detail_special_pricing", String.class));
        entity.setSalesOrderDetailPriceOverride(converter.fromRow(row, prefix + "_sales_order_detail_price_override", String.class));
        entity.setSalesOrderDetailSpecialTaxRate(converter.fromRow(row, prefix + "_sales_order_detail_special_tax_rate", Integer.class));
        entity.setSalesOrderDetailQty(converter.fromRow(row, prefix + "_sales_order_detail_qty", Integer.class));
        entity.setSalesOrderDetailBqty(converter.fromRow(row, prefix + "_sales_order_detail_bqty", Integer.class));
        entity.setSalesOrderDetailLineQty(converter.fromRow(row, prefix + "_sales_order_detail_line_qty", Integer.class));
        entity.setSalesOrderDetailProcCode(converter.fromRow(row, prefix + "_sales_order_detail_proc_code", String.class));
        entity.setSalesOrderDetailPriceOption(converter.fromRow(row, prefix + "_sales_order_detail_price_option", String.class));
        entity.setSalesOrderDetailModifier1(converter.fromRow(row, prefix + "_sales_order_detail_modifier_1", String.class));
        entity.setSalesOrderDetailModifier2(converter.fromRow(row, prefix + "_sales_order_detail_modifier_2", String.class));
        entity.setSalesOrderDetailModifier3(converter.fromRow(row, prefix + "_sales_order_detail_modifier_3", String.class));
        entity.setSalesOrderDetailModifier4(converter.fromRow(row, prefix + "_sales_order_detail_modifier_4", String.class));
        entity.setSalesOrderDetailChargeAmt(converter.fromRow(row, prefix + "_sales_order_detail_charge_amt", Double.class));
        entity.setSalesOrderDetailAllowedAmt(converter.fromRow(row, prefix + "_sales_order_detail_allowed_amt", Double.class));
        entity.setSalesOrderDetailTaxable(converter.fromRow(row, prefix + "_sales_order_detail_taxable", String.class));
        entity.setSalesOrderDetailAbn(converter.fromRow(row, prefix + "_sales_order_detail_abn", String.class));
        entity.setSalesOrderDetailAbnUpgrade(converter.fromRow(row, prefix + "_sales_order_detail_abn_upgrade", String.class));
        entity.setSalesOrderDetailAbnPrintDate(converter.fromRow(row, prefix + "_sales_order_detail_abn_print_date", LocalDate.class));
        entity.setSalesOrderDetailAbnItem(converter.fromRow(row, prefix + "_sales_order_detail_abn_item", String.class));
        entity.setSalesOrderDetailAbnProcCode(converter.fromRow(row, prefix + "_sales_order_detail_abn_proc_code", String.class));
        entity.setSalesOrderDetailAbnAllow(converter.fromRow(row, prefix + "_sales_order_detail_abn_allow", String.class));
        entity.setSalesOrderDetailAbnCharge(converter.fromRow(row, prefix + "_sales_order_detail_abn_charge", Integer.class));
        entity.setSalesOrderDetailAbnModifier1(converter.fromRow(row, prefix + "_sales_order_detail_abn_modifier_1", String.class));
        entity.setSalesOrderDetailAbnModifier2(converter.fromRow(row, prefix + "_sales_order_detail_abn_modifier_2", String.class));
        entity.setSalesOrderDetailTaxRate(converter.fromRow(row, prefix + "_sales_order_detail_tax_rate", Integer.class));
        entity.setSalesOrderDetailTaxZone(converter.fromRow(row, prefix + "_sales_order_detail_tax_zone", String.class));
        entity.setSalesOrderDetailNonTaxReason(converter.fromRow(row, prefix + "_sales_order_detail_non_tax_reason", String.class));
        entity.setSalesOrderDetailNote(converter.fromRow(row, prefix + "_sales_order_detail_note", String.class));
        entity.setSalesOrderDetailSaleType(converter.fromRow(row, prefix + "_sales_order_detail_sale_type", String.class));
        entity.setSalesOrderDetailItemGroup(converter.fromRow(row, prefix + "_sales_order_detail_item_group", String.class));
        entity.setSalesOrderDetailItemUser1(converter.fromRow(row, prefix + "_sales_order_detail_item_user_1", String.class));
        entity.setSalesOrderDetailItemUser2(converter.fromRow(row, prefix + "_sales_order_detail_item_user_2", String.class));
        entity.setSalesOrderDetailItemUser3(converter.fromRow(row, prefix + "_sales_order_detail_item_user_3", String.class));
        entity.setSalesOrderDetailItemUser4(converter.fromRow(row, prefix + "_sales_order_detail_item_user_4", String.class));
        entity.setSalesOrderDetailConvertedToPurchase(
            converter.fromRow(row, prefix + "_sales_order_detail_converted_to_purchase", String.class)
        );
        entity.setSalesOrderDetailManualConvertToPurchaseMctp(
            converter.fromRow(row, prefix + "_sales_order_detail_manual_convert_to_purchase_mctp", String.class)
        );
        entity.setSalesOrderDetailMctpChargeAmt(converter.fromRow(row, prefix + "_sales_order_detail_mctp_charge_amt", Double.class));
        entity.setSalesOrderDetailMctpAllowedAmt(converter.fromRow(row, prefix + "_sales_order_detail_mctp_allowed_amt", Double.class));
        entity.setSalesOrderDetailMctpModifier1(converter.fromRow(row, prefix + "_sales_order_detail_mctp_modifier_1", String.class));
        entity.setSalesOrderDetailMctpModifier2(converter.fromRow(row, prefix + "_sales_order_detail_mctp_modifier_2", String.class));
        entity.setSalesOrderDetailMctpModifier3(converter.fromRow(row, prefix + "_sales_order_detail_mctp_modifier_3", String.class));
        entity.setSalesOrderDetailMctpModifier4(converter.fromRow(row, prefix + "_sales_order_detail_mctp_modifier_4", String.class));
        entity.setSalesOrderDetailMctpPeriod(converter.fromRow(row, prefix + "_sales_order_detail_mctp_period", Integer.class));
        entity.setSalesOrderDetailAddtlModifier1(converter.fromRow(row, prefix + "_sales_order_detail_addtl_modifier_1", String.class));
        entity.setSalesOrderDetailAddtlModifier2(converter.fromRow(row, prefix + "_sales_order_detail_addtl_modifier_2", String.class));
        entity.setSalesOrderDetailAddtlModifier3(converter.fromRow(row, prefix + "_sales_order_detail_addtl_modifier_3", String.class));
        entity.setSalesOrderDetailAddtlModifier4(converter.fromRow(row, prefix + "_sales_order_detail_addtl_modifier_4", String.class));
        entity.setSalesOrderDetailNextDateOfService(
            converter.fromRow(row, prefix + "_sales_order_detail_next_date_of_service", LocalDate.class)
        );
        entity.setSalesOrderDetailPriceTable(converter.fromRow(row, prefix + "_sales_order_detail_price_table", String.class));
        entity.setSalesOrderDetailPriceOptionName(converter.fromRow(row, prefix + "_sales_order_detail_price_option_name", String.class));
        entity.setSalesOrderDetailExtendedChargeAmount(
            converter.fromRow(row, prefix + "_sales_order_detail_extended_charge_amount", Double.class)
        );
        entity.setSalesOrderDetailExtendedAllowanceAmount(
            converter.fromRow(row, prefix + "_sales_order_detail_extended_allowance_amount", Double.class)
        );
        entity.setSalesOrderDetailItemNdcCode(converter.fromRow(row, prefix + "_sales_order_detail_item_ndc_code", String.class));
        entity.setSalesOrderDetailManufacturer(converter.fromRow(row, prefix + "_sales_order_detail_manufacturer", String.class));
        entity.setSalesOrderDetailCbPricing(converter.fromRow(row, prefix + "_sales_order_detail_cb_pricing", String.class));
        entity.setSalesOrderDetailCbPriceTableOverride(
            converter.fromRow(row, prefix + "_sales_order_detail_cb_price_table_override", String.class)
        );
        entity.setSalesOrderDetailCbOverride(converter.fromRow(row, prefix + "_sales_order_detail_cb_override", String.class));
        entity.setSalesOrderDetailMessages(converter.fromRow(row, prefix + "_sales_order_detail_messages", String.class));
        entity.setSalesOrderDetailLocation(converter.fromRow(row, prefix + "_sales_order_detail_location", Integer.class));
        entity.setSalesOrderDetailCaloriesPerDay(converter.fromRow(row, prefix + "_sales_order_detail_calories_per_day", Integer.class));
        entity.setSalesOrderDetailSecondaryBillingProcudureCode(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_procudure_code", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingPriceOption(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_price_option", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingPriceOptionName(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_price_option_name", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingModifier1(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_modifier_1", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingModifier2(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_modifier_2", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingModifier3(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_modifier_3", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingModifier4(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_modifier_4", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingAdditionalModifier1(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_additional_modifier_1", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingadditionalModifier2(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billingadditional_modifier_2", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingadditionalModifier3(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billingadditional_modifier_3", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingadditionalModifier4(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billingadditional_modifier_4", String.class)
        );
        entity.setSalesOrderDetailSecondaryBillingIgnore(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_billing_ignore", String.class)
        );
        entity.setSalesOrderDetailSecondarySpecialBilling(
            converter.fromRow(row, prefix + "_sales_order_detail_secondary_special_billing", String.class)
        );
        entity.setSalesOrderDetailSpanDateSplitBilling(
            converter.fromRow(row, prefix + "_sales_order_detail_span_date_split_billing", String.class)
        );
        entity.setSalesOrderDetailManufacturerItemIdNumber(
            converter.fromRow(row, prefix + "_sales_order_detail_manufacturer_item_id_number", String.class)
        );
        entity.setCmnId(converter.fromRow(row, prefix + "_cmn_id", Integer.class));
        entity.setCmnparCmnFormId(converter.fromRow(row, prefix + "_cmnpar_cmn_form_id", Integer.class));
        entity.setCmnparCmnKey(converter.fromRow(row, prefix + "_cmnpar_cmn_key", String.class));
        entity.setCmnparCmnCreateDate(converter.fromRow(row, prefix + "_cmnpar_cmn_create_date", LocalDate.class));
        entity.setCmnparCmnExpirationDate(converter.fromRow(row, prefix + "_cmnpar_cmn_expiration_date", LocalDate.class));
        entity.setCmnparCmnInitialDate(converter.fromRow(row, prefix + "_cmnpar_cmn_initial_date", LocalDate.class));
        entity.setCmnparCmnRenewalDate(converter.fromRow(row, prefix + "_cmnpar_cmn_renewal_date", LocalDate.class));
        entity.setCmnparCmnRecertificationDate(converter.fromRow(row, prefix + "_cmnpar_cmn_recertification_date", LocalDate.class));
        entity.setCmnparCmnPhysicianDate(converter.fromRow(row, prefix + "_cmnpar_cmn_physician_date", LocalDate.class));
        entity.setCmnparCmnStatus(converter.fromRow(row, prefix + "_cmnpar_cmn_status", String.class));
        entity.setCmnparParId(converter.fromRow(row, prefix + "_cmnpar_par_id", Integer.class));
        entity.setCmnparParDescr(converter.fromRow(row, prefix + "_cmnpar_par_descr", String.class));
        entity.setCmnparParInitialDate(converter.fromRow(row, prefix + "_cmnpar_par_initial_date", LocalDate.class));
        entity.setCmnparParExpirationDate(converter.fromRow(row, prefix + "_cmnpar_par_expiration_date", LocalDate.class));
        entity.setCmnparCmnLogDate(converter.fromRow(row, prefix + "_cmnpar_cmn_log_date", LocalDate.class));
        entity.setCmnparCmnLengthOfNeed(converter.fromRow(row, prefix + "_cmnpar_cmn_length_of_need", Integer.class));
        entity.setCmnparCmnPrintedDate(converter.fromRow(row, prefix + "_cmnpar_cmn_printed_date", LocalDate.class));
        entity.setCmnparCmnPrintedBy(converter.fromRow(row, prefix + "_cmnpar_cmn_printed_by", String.class));
        entity.setCmnparFaxedDate(converter.fromRow(row, prefix + "_cmnpar_faxed_date", LocalDate.class));
        entity.setCmnparCmnPlaceholder(converter.fromRow(row, prefix + "_cmnpar_cmn_placeholder", String.class));
        entity.setCmnparCmnFaxedBy(converter.fromRow(row, prefix + "_cmnpar_cmn_faxed_by", String.class));
        entity.setCmnparCmnLoggedBy(converter.fromRow(row, prefix + "_cmnpar_cmn_logged_by", String.class));
        entity.setCmnparNumberOfRefills(converter.fromRow(row, prefix + "_cmnpar_number_of_refills", Integer.class));
        entity.setStatus(converter.fromRow(row, prefix + "_status", String.class));
        entity.setCreatedById(converter.fromRow(row, prefix + "_created_by_id", Integer.class));
        entity.setCreatedByName(converter.fromRow(row, prefix + "_created_by_name", String.class));
        entity.setCreatedDate(converter.fromRow(row, prefix + "_created_date", ZonedDateTime.class));
        entity.setUpdatedById(converter.fromRow(row, prefix + "_updated_by_id", Integer.class));
        entity.setUpdatedByName(converter.fromRow(row, prefix + "_updated_by_name", String.class));
        entity.setUpdatedDate(converter.fromRow(row, prefix + "_updated_date", ZonedDateTime.class));
        entity.setItemDetailsId(converter.fromRow(row, prefix + "_item_details_sales_order_id", Long.class));
        return entity;
    }
}
