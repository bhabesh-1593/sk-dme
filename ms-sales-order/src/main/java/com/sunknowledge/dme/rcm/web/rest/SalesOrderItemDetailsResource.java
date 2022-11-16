package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails;
import com.sunknowledge.dme.rcm.repository.SalesOrderItemDetailsRepository;
import com.sunknowledge.dme.rcm.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SalesOrderItemDetailsResource {

    private final Logger log = LoggerFactory.getLogger(SalesOrderItemDetailsResource.class);

    private static final String ENTITY_NAME = "salesorderSalesOrderItemDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SalesOrderItemDetailsRepository salesOrderItemDetailsRepository;

    public SalesOrderItemDetailsResource(SalesOrderItemDetailsRepository salesOrderItemDetailsRepository) {
        this.salesOrderItemDetailsRepository = salesOrderItemDetailsRepository;
    }

    /**
     * {@code POST  /sales-order-item-details} : Create a new salesOrderItemDetails.
     *
     * @param salesOrderItemDetails the salesOrderItemDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salesOrderItemDetails, or with status {@code 400 (Bad Request)} if the salesOrderItemDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/sales-order-item-details")
//    public Mono<ResponseEntity<SalesOrderItemDetails>> createSalesOrderItemDetails(
//        @Valid @RequestBody SalesOrderItemDetails salesOrderItemDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to save SalesOrderItemDetails : {}", salesOrderItemDetails);
//        if (salesOrderItemDetails.getId() != null) {
//            throw new BadRequestAlertException("A new salesOrderItemDetails cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        return salesOrderItemDetailsRepository
//            .save(salesOrderItemDetails)
//            .map(result -> {
//                try {
//                    return ResponseEntity
//                        .created(new URI("/api/sales-order-item-details/" + result.getId()))
//                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//                        .body(result);
//                } catch (URISyntaxException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//    }
//
//    /**
//     * {@code PUT  /sales-order-item-details/:id} : Updates an existing salesOrderItemDetails.
//     *
//     * @param id the id of the salesOrderItemDetails to save.
//     * @param salesOrderItemDetails the salesOrderItemDetails to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderItemDetails,
//     * or with status {@code 400 (Bad Request)} if the salesOrderItemDetails is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderItemDetails couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/sales-order-item-details/{id}")
//    public Mono<ResponseEntity<SalesOrderItemDetails>> updateSalesOrderItemDetails(
//        @PathVariable(value = "id", required = false) final Long id,
//        @Valid @RequestBody SalesOrderItemDetails salesOrderItemDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to update SalesOrderItemDetails : {}, {}", id, salesOrderItemDetails);
//        if (salesOrderItemDetails.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderItemDetails.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderItemDetailsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                return salesOrderItemDetailsRepository
//                    .save(salesOrderItemDetails)
//                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
//                    .map(result ->
//                        ResponseEntity
//                            .ok()
//                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//                            .body(result)
//                    );
//            });
//    }
//
//    /**
//     * {@code PATCH  /sales-order-item-details/:id} : Partial updates given fields of an existing salesOrderItemDetails, field will ignore if it is null
//     *
//     * @param id the id of the salesOrderItemDetails to save.
//     * @param salesOrderItemDetails the salesOrderItemDetails to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderItemDetails,
//     * or with status {@code 400 (Bad Request)} if the salesOrderItemDetails is not valid,
//     * or with status {@code 404 (Not Found)} if the salesOrderItemDetails is not found,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderItemDetails couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PatchMapping(value = "/sales-order-item-details/{id}", consumes = { "application/json", "application/merge-patch+json" })
//    public Mono<ResponseEntity<SalesOrderItemDetails>> partialUpdateSalesOrderItemDetails(
//        @PathVariable(value = "id", required = false) final Long id,
//        @NotNull @RequestBody SalesOrderItemDetails salesOrderItemDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to partial update SalesOrderItemDetails partially : {}, {}", id, salesOrderItemDetails);
//        if (salesOrderItemDetails.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderItemDetails.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderItemDetailsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                Mono<SalesOrderItemDetails> result = salesOrderItemDetailsRepository
//                    .findById(salesOrderItemDetails.getId())
//                    .map(existingSalesOrderItemDetails -> {
//                        if (salesOrderItemDetails.getSalesOrderItemDetailsId() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderItemDetailsId(salesOrderItemDetails.getSalesOrderItemDetailsId());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderId() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderId(salesOrderItemDetails.getSalesOrderId());
//                        }
//                        if (salesOrderItemDetails.getPatientId() != null) {
//                            existingSalesOrderItemDetails.setPatientId(salesOrderItemDetails.getPatientId());
//                        }
//                        if (salesOrderItemDetails.getItemLocationId() != null) {
//                            existingSalesOrderItemDetails.setItemLocationId(salesOrderItemDetails.getItemLocationId());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemId() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemId(salesOrderItemDetails.getSalesOrderDetailItemId());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemName() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemName(salesOrderItemDetails.getSalesOrderDetailItemName());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailStockingUom() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailStockingUom(
//                                salesOrderItemDetails.getSalesOrderDetailStockingUom()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailStockingUomName() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailStockingUomName(
//                                salesOrderItemDetails.getSalesOrderDetailStockingUomName()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemDescription() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemDescription(
//                                salesOrderItemDetails.getSalesOrderDetailItemDescription()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailDefaultVendor() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailDefaultVendor(
//                                salesOrderItemDetails.getSalesOrderDetailDefaultVendor()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailOriginalDos() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailOriginalDos(
//                                salesOrderItemDetails.getSalesOrderDetailOriginalDos()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailPreviousBillingDate() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailPreviousBillingDate(
//                                salesOrderItemDetails.getSalesOrderDetailPreviousBillingDate()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailNextBillingDate() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailNextBillingDate(
//                                salesOrderItemDetails.getSalesOrderDetailNextBillingDate()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailDosTo() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailDosTo(salesOrderItemDetails.getSalesOrderDetailDosTo());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailNextPeriod() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailNextPeriod(
//                                salesOrderItemDetails.getSalesOrderDetailNextPeriod()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSpecialPricing() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSpecialPricing(
//                                salesOrderItemDetails.getSalesOrderDetailSpecialPricing()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailPriceOverride() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailPriceOverride(
//                                salesOrderItemDetails.getSalesOrderDetailPriceOverride()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSpecialTaxRate() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSpecialTaxRate(
//                                salesOrderItemDetails.getSalesOrderDetailSpecialTaxRate()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailQty() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailQty(salesOrderItemDetails.getSalesOrderDetailQty());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailBqty() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailBqty(salesOrderItemDetails.getSalesOrderDetailBqty());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailLineQty() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailLineQty(salesOrderItemDetails.getSalesOrderDetailLineQty());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailProcCode() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailProcCode(salesOrderItemDetails.getSalesOrderDetailProcCode());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailPriceOption() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailPriceOption(
//                                salesOrderItemDetails.getSalesOrderDetailPriceOption()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailModifier1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailModifier1(
//                                salesOrderItemDetails.getSalesOrderDetailModifier1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailModifier2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailModifier2(
//                                salesOrderItemDetails.getSalesOrderDetailModifier2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailModifier3() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailModifier3(
//                                salesOrderItemDetails.getSalesOrderDetailModifier3()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailModifier4() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailModifier4(
//                                salesOrderItemDetails.getSalesOrderDetailModifier4()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailChargeAmt() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailChargeAmt(
//                                salesOrderItemDetails.getSalesOrderDetailChargeAmt()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAllowedAmt() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAllowedAmt(
//                                salesOrderItemDetails.getSalesOrderDetailAllowedAmt()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailTaxable() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailTaxable(salesOrderItemDetails.getSalesOrderDetailTaxable());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbn() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbn(salesOrderItemDetails.getSalesOrderDetailAbn());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnUpgrade() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnUpgrade(
//                                salesOrderItemDetails.getSalesOrderDetailAbnUpgrade()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnPrintDate() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnPrintDate(
//                                salesOrderItemDetails.getSalesOrderDetailAbnPrintDate()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnItem() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnItem(salesOrderItemDetails.getSalesOrderDetailAbnItem());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnProcCode() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnProcCode(
//                                salesOrderItemDetails.getSalesOrderDetailAbnProcCode()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnAllow() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnAllow(salesOrderItemDetails.getSalesOrderDetailAbnAllow());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnCharge() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnCharge(
//                                salesOrderItemDetails.getSalesOrderDetailAbnCharge()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnModifier1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnModifier1(
//                                salesOrderItemDetails.getSalesOrderDetailAbnModifier1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAbnModifier2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAbnModifier2(
//                                salesOrderItemDetails.getSalesOrderDetailAbnModifier2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailTaxRate() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailTaxRate(salesOrderItemDetails.getSalesOrderDetailTaxRate());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailTaxZone() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailTaxZone(salesOrderItemDetails.getSalesOrderDetailTaxZone());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailNonTaxReason() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailNonTaxReason(
//                                salesOrderItemDetails.getSalesOrderDetailNonTaxReason()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailNote() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailNote(salesOrderItemDetails.getSalesOrderDetailNote());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSaleType() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSaleType(salesOrderItemDetails.getSalesOrderDetailSaleType());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemGroup() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemGroup(
//                                salesOrderItemDetails.getSalesOrderDetailItemGroup()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemUser1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemUser1(
//                                salesOrderItemDetails.getSalesOrderDetailItemUser1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemUser2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemUser2(
//                                salesOrderItemDetails.getSalesOrderDetailItemUser2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemUser3() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemUser3(
//                                salesOrderItemDetails.getSalesOrderDetailItemUser3()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemUser4() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemUser4(
//                                salesOrderItemDetails.getSalesOrderDetailItemUser4()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailConvertedToPurchase() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailConvertedToPurchase(
//                                salesOrderItemDetails.getSalesOrderDetailConvertedToPurchase()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailManualConvertToPurchaseMctp(
//                                salesOrderItemDetails.getSalesOrderDetailManualConvertToPurchaseMctp()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpChargeAmt() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpChargeAmt(
//                                salesOrderItemDetails.getSalesOrderDetailMctpChargeAmt()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpAllowedAmt(
//                                salesOrderItemDetails.getSalesOrderDetailMctpAllowedAmt()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpModifier1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpModifier1(
//                                salesOrderItemDetails.getSalesOrderDetailMctpModifier1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpModifier2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpModifier2(
//                                salesOrderItemDetails.getSalesOrderDetailMctpModifier2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpModifier3() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpModifier3(
//                                salesOrderItemDetails.getSalesOrderDetailMctpModifier3()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpModifier4() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpModifier4(
//                                salesOrderItemDetails.getSalesOrderDetailMctpModifier4()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMctpPeriod() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMctpPeriod(
//                                salesOrderItemDetails.getSalesOrderDetailMctpPeriod()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAddtlModifier1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAddtlModifier1(
//                                salesOrderItemDetails.getSalesOrderDetailAddtlModifier1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAddtlModifier2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAddtlModifier2(
//                                salesOrderItemDetails.getSalesOrderDetailAddtlModifier2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAddtlModifier3() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAddtlModifier3(
//                                salesOrderItemDetails.getSalesOrderDetailAddtlModifier3()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailAddtlModifier4() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailAddtlModifier4(
//                                salesOrderItemDetails.getSalesOrderDetailAddtlModifier4()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailNextDateOfService() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailNextDateOfService(
//                                salesOrderItemDetails.getSalesOrderDetailNextDateOfService()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailPriceTable() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailPriceTable(
//                                salesOrderItemDetails.getSalesOrderDetailPriceTable()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailPriceOptionName() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailPriceOptionName(
//                                salesOrderItemDetails.getSalesOrderDetailPriceOptionName()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailExtendedChargeAmount(
//                                salesOrderItemDetails.getSalesOrderDetailExtendedChargeAmount()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailExtendedAllowanceAmount(
//                                salesOrderItemDetails.getSalesOrderDetailExtendedAllowanceAmount()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailItemNdcCode() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailItemNdcCode(
//                                salesOrderItemDetails.getSalesOrderDetailItemNdcCode()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailManufacturer() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailManufacturer(
//                                salesOrderItemDetails.getSalesOrderDetailManufacturer()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailCbPricing() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailCbPricing(
//                                salesOrderItemDetails.getSalesOrderDetailCbPricing()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailCbPriceTableOverride(
//                                salesOrderItemDetails.getSalesOrderDetailCbPriceTableOverride()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailCbOverride() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailCbOverride(
//                                salesOrderItemDetails.getSalesOrderDetailCbOverride()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailMessages() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailMessages(salesOrderItemDetails.getSalesOrderDetailMessages());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailLocation() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailLocation(salesOrderItemDetails.getSalesOrderDetailLocation());
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailCaloriesPerDay() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailCaloriesPerDay(
//                                salesOrderItemDetails.getSalesOrderDetailCaloriesPerDay()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingProcudureCode(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingProcudureCode()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingPriceOption(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOption()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingPriceOptionName(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingPriceOptionName()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingModifier1(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingModifier2(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingModifier3(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier3()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingModifier4(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingModifier4()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingAdditionalModifier1(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingAdditionalModifier1()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingadditionalModifier2(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier2()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingadditionalModifier3(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier3()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingadditionalModifier4(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingadditionalModifier4()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondaryBillingIgnore(
//                                salesOrderItemDetails.getSalesOrderDetailSecondaryBillingIgnore()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSecondarySpecialBilling(
//                                salesOrderItemDetails.getSalesOrderDetailSecondarySpecialBilling()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailSpanDateSplitBilling(
//                                salesOrderItemDetails.getSalesOrderDetailSpanDateSplitBilling()
//                            );
//                        }
//                        if (salesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber() != null) {
//                            existingSalesOrderItemDetails.setSalesOrderDetailManufacturerItemIdNumber(
//                                salesOrderItemDetails.getSalesOrderDetailManufacturerItemIdNumber()
//                            );
//                        }
//                        if (salesOrderItemDetails.getCmnId() != null) {
//                            existingSalesOrderItemDetails.setCmnId(salesOrderItemDetails.getCmnId());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnFormId() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnFormId(salesOrderItemDetails.getCmnparCmnFormId());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnKey() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnKey(salesOrderItemDetails.getCmnparCmnKey());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnCreateDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnCreateDate(salesOrderItemDetails.getCmnparCmnCreateDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnExpirationDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnExpirationDate(salesOrderItemDetails.getCmnparCmnExpirationDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnInitialDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnInitialDate(salesOrderItemDetails.getCmnparCmnInitialDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnRenewalDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnRenewalDate(salesOrderItemDetails.getCmnparCmnRenewalDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnRecertificationDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnRecertificationDate(
//                                salesOrderItemDetails.getCmnparCmnRecertificationDate()
//                            );
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnPhysicianDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnPhysicianDate(salesOrderItemDetails.getCmnparCmnPhysicianDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnStatus() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnStatus(salesOrderItemDetails.getCmnparCmnStatus());
//                        }
//                        if (salesOrderItemDetails.getCmnparParId() != null) {
//                            existingSalesOrderItemDetails.setCmnparParId(salesOrderItemDetails.getCmnparParId());
//                        }
//                        if (salesOrderItemDetails.getCmnparParDescr() != null) {
//                            existingSalesOrderItemDetails.setCmnparParDescr(salesOrderItemDetails.getCmnparParDescr());
//                        }
//                        if (salesOrderItemDetails.getCmnparParInitialDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparParInitialDate(salesOrderItemDetails.getCmnparParInitialDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparParExpirationDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparParExpirationDate(salesOrderItemDetails.getCmnparParExpirationDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnLogDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnLogDate(salesOrderItemDetails.getCmnparCmnLogDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnLengthOfNeed() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnLengthOfNeed(salesOrderItemDetails.getCmnparCmnLengthOfNeed());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnPrintedDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnPrintedDate(salesOrderItemDetails.getCmnparCmnPrintedDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnPrintedBy() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnPrintedBy(salesOrderItemDetails.getCmnparCmnPrintedBy());
//                        }
//                        if (salesOrderItemDetails.getCmnparFaxedDate() != null) {
//                            existingSalesOrderItemDetails.setCmnparFaxedDate(salesOrderItemDetails.getCmnparFaxedDate());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnPlaceholder() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnPlaceholder(salesOrderItemDetails.getCmnparCmnPlaceholder());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnFaxedBy() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnFaxedBy(salesOrderItemDetails.getCmnparCmnFaxedBy());
//                        }
//                        if (salesOrderItemDetails.getCmnparCmnLoggedBy() != null) {
//                            existingSalesOrderItemDetails.setCmnparCmnLoggedBy(salesOrderItemDetails.getCmnparCmnLoggedBy());
//                        }
//                        if (salesOrderItemDetails.getCmnparNumberOfRefills() != null) {
//                            existingSalesOrderItemDetails.setCmnparNumberOfRefills(salesOrderItemDetails.getCmnparNumberOfRefills());
//                        }
//                        if (salesOrderItemDetails.getStatus() != null) {
//                            existingSalesOrderItemDetails.setStatus(salesOrderItemDetails.getStatus());
//                        }
//                        if (salesOrderItemDetails.getCreatedById() != null) {
//                            existingSalesOrderItemDetails.setCreatedById(salesOrderItemDetails.getCreatedById());
//                        }
//                        if (salesOrderItemDetails.getCreatedByName() != null) {
//                            existingSalesOrderItemDetails.setCreatedByName(salesOrderItemDetails.getCreatedByName());
//                        }
//                        if (salesOrderItemDetails.getCreatedDate() != null) {
//                            existingSalesOrderItemDetails.setCreatedDate(salesOrderItemDetails.getCreatedDate());
//                        }
//                        if (salesOrderItemDetails.getUpdatedById() != null) {
//                            existingSalesOrderItemDetails.setUpdatedById(salesOrderItemDetails.getUpdatedById());
//                        }
//                        if (salesOrderItemDetails.getUpdatedByName() != null) {
//                            existingSalesOrderItemDetails.setUpdatedByName(salesOrderItemDetails.getUpdatedByName());
//                        }
//                        if (salesOrderItemDetails.getUpdatedDate() != null) {
//                            existingSalesOrderItemDetails.setUpdatedDate(salesOrderItemDetails.getUpdatedDate());
//                        }
//
//                        return existingSalesOrderItemDetails;
//                    })
//                    .flatMap(salesOrderItemDetailsRepository::save);
//
//                return result
//                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
//                    .map(res ->
//                        ResponseEntity
//                            .ok()
//                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getId().toString()))
//                            .body(res)
//                    );
//            });
//    }
//
//    /**
//     * {@code GET  /sales-order-item-details} : get all the salesOrderItemDetails.
//     *
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salesOrderItemDetails in body.
//     */
//    @GetMapping("/sales-order-item-details")
//    public Mono<List<SalesOrderItemDetails>> getAllSalesOrderItemDetails() {
//        log.debug("REST request to get all SalesOrderItemDetails");
//        return salesOrderItemDetailsRepository.findAll().collectList();
//    }
//
//    /**
//     * {@code GET  /sales-order-item-details} : get all the salesOrderItemDetails as a stream.
//     * @return the {@link Flux} of salesOrderItemDetails.
//     */
//    @GetMapping(value = "/sales-order-item-details", produces = MediaType.APPLICATION_NDJSON_VALUE)
//    public Flux<SalesOrderItemDetails> getAllSalesOrderItemDetailsAsStream() {
//        log.debug("REST request to get all SalesOrderItemDetails as a stream");
//        return salesOrderItemDetailsRepository.findAll();
//    }
//
//    /**
//     * {@code GET  /sales-order-item-details/:id} : get the "id" salesOrderItemDetails.
//     *
//     * @param id the id of the salesOrderItemDetails to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salesOrderItemDetails, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/sales-order-item-details/{id}")
//    public Mono<ResponseEntity<SalesOrderItemDetails>> getSalesOrderItemDetails(@PathVariable Long id) {
//        log.debug("REST request to get SalesOrderItemDetails : {}", id);
//        Mono<SalesOrderItemDetails> salesOrderItemDetails = salesOrderItemDetailsRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(salesOrderItemDetails);
//    }
//
//    /**
//     * {@code DELETE  /sales-order-item-details/:id} : delete the "id" salesOrderItemDetails.
//     *
//     * @param id the id of the salesOrderItemDetails to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/sales-order-item-details/{id}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public Mono<ResponseEntity<Void>> deleteSalesOrderItemDetails(@PathVariable Long id) {
//        log.debug("REST request to delete SalesOrderItemDetails : {}", id);
//        return salesOrderItemDetailsRepository
//            .deleteById(id)
//            .map(result ->
//                ResponseEntity
//                    .noContent()
//                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
//                    .build()
//            );
//    }
}
