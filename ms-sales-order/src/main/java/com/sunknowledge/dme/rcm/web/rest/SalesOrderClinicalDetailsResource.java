package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.SalesOrderClinicalDetails;
import com.sunknowledge.dme.rcm.repository.SalesOrderClinicalDetailsRepository;
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
 * REST controller for managing {@link com.sunknowledge.dme.rcm.domain.SalesOrderClinicalDetails}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SalesOrderClinicalDetailsResource {

    private final Logger log = LoggerFactory.getLogger(SalesOrderClinicalDetailsResource.class);

    private static final String ENTITY_NAME = "salesorderSalesOrderClinicalDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SalesOrderClinicalDetailsRepository salesOrderClinicalDetailsRepository;

    public SalesOrderClinicalDetailsResource(SalesOrderClinicalDetailsRepository salesOrderClinicalDetailsRepository) {
        this.salesOrderClinicalDetailsRepository = salesOrderClinicalDetailsRepository;
    }

    /**
     * {@code POST  /sales-order-clinical-details} : Create a new salesOrderClinicalDetails.
     *
     * @param salesOrderClinicalDetails the salesOrderClinicalDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salesOrderClinicalDetails, or with status {@code 400 (Bad Request)} if the salesOrderClinicalDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/sales-order-clinical-details")
//    public Mono<ResponseEntity<SalesOrderClinicalDetails>> createSalesOrderClinicalDetails(
//        @Valid @RequestBody SalesOrderClinicalDetails salesOrderClinicalDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to save SalesOrderClinicalDetails : {}", salesOrderClinicalDetails);
//        if (salesOrderClinicalDetails.getId() != null) {
//            throw new BadRequestAlertException("A new salesOrderClinicalDetails cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        return salesOrderClinicalDetailsRepository
//            .save(salesOrderClinicalDetails)
//            .map(result -> {
//                try {
//                    return ResponseEntity
//                        .created(new URI("/api/sales-order-clinical-details/" + result.getId()))
//                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//                        .body(result);
//                } catch (URISyntaxException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//    }
//
//    /**
//     * {@code PUT  /sales-order-clinical-details/:id} : Updates an existing salesOrderClinicalDetails.
//     *
//     * @param id the id of the salesOrderClinicalDetails to save.
//     * @param salesOrderClinicalDetails the salesOrderClinicalDetails to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderClinicalDetails,
//     * or with status {@code 400 (Bad Request)} if the salesOrderClinicalDetails is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderClinicalDetails couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/sales-order-clinical-details/{id}")
//    public Mono<ResponseEntity<SalesOrderClinicalDetails>> updateSalesOrderClinicalDetails(
//        @PathVariable(value = "id", required = false) final Long id,
//        @Valid @RequestBody SalesOrderClinicalDetails salesOrderClinicalDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to update SalesOrderClinicalDetails : {}, {}", id, salesOrderClinicalDetails);
//        if (salesOrderClinicalDetails.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderClinicalDetails.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderClinicalDetailsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                return salesOrderClinicalDetailsRepository
//                    .save(salesOrderClinicalDetails)
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
//     * {@code PATCH  /sales-order-clinical-details/:id} : Partial updates given fields of an existing salesOrderClinicalDetails, field will ignore if it is null
//     *
//     * @param id the id of the salesOrderClinicalDetails to save.
//     * @param salesOrderClinicalDetails the salesOrderClinicalDetails to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderClinicalDetails,
//     * or with status {@code 400 (Bad Request)} if the salesOrderClinicalDetails is not valid,
//     * or with status {@code 404 (Not Found)} if the salesOrderClinicalDetails is not found,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderClinicalDetails couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PatchMapping(value = "/sales-order-clinical-details/{id}", consumes = { "application/json", "application/merge-patch+json" })
//    public Mono<ResponseEntity<SalesOrderClinicalDetails>> partialUpdateSalesOrderClinicalDetails(
//        @PathVariable(value = "id", required = false) final Long id,
//        @NotNull @RequestBody SalesOrderClinicalDetails salesOrderClinicalDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to partial update SalesOrderClinicalDetails partially : {}, {}", id, salesOrderClinicalDetails);
//        if (salesOrderClinicalDetails.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderClinicalDetails.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderClinicalDetailsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                Mono<SalesOrderClinicalDetails> result = salesOrderClinicalDetailsRepository
//                    .findById(salesOrderClinicalDetails.getId())
//                    .map(existingSalesOrderClinicalDetails -> {
//                        if (salesOrderClinicalDetails.getSalesOderClinicalDetailsId() != null) {
//                            existingSalesOrderClinicalDetails.setSalesOderClinicalDetailsId(
//                                salesOrderClinicalDetails.getSalesOderClinicalDetailsId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getSalesOderId() != null) {
//                            existingSalesOrderClinicalDetails.setSalesOderId(salesOrderClinicalDetails.getSalesOderId());
//                        }
//                        if (salesOrderClinicalDetails.getPatientId() != null) {
//                            existingSalesOrderClinicalDetails.setPatientId(salesOrderClinicalDetails.getPatientId());
//                        }
//                        if (salesOrderClinicalDetails.getPatientWeightInKg() != null) {
//                            existingSalesOrderClinicalDetails.setPatientWeightInKg(salesOrderClinicalDetails.getPatientWeightInKg());
//                        }
//                        if (salesOrderClinicalDetails.getPatientWeightInLbs() != null) {
//                            existingSalesOrderClinicalDetails.setPatientWeightInLbs(salesOrderClinicalDetails.getPatientWeightInLbs());
//                        }
//                        if (salesOrderClinicalDetails.getHeightInInches() != null) {
//                            existingSalesOrderClinicalDetails.setHeightInInches(salesOrderClinicalDetails.getHeightInInches());
//                        }
//                        if (salesOrderClinicalDetails.getHeightInCm() != null) {
//                            existingSalesOrderClinicalDetails.setHeightInCm(salesOrderClinicalDetails.getHeightInCm());
//                        }
//                        if (salesOrderClinicalDetails.getSalesRepId() != null) {
//                            existingSalesOrderClinicalDetails.setSalesRepId(salesOrderClinicalDetails.getSalesRepId());
//                        }
//                        if (salesOrderClinicalDetails.getSalesepName() != null) {
//                            existingSalesOrderClinicalDetails.setSalesepName(salesOrderClinicalDetails.getSalesepName());
//                        }
//                        if (salesOrderClinicalDetails.getPractitionerId() != null) {
//                            existingSalesOrderClinicalDetails.setPractitionerId(salesOrderClinicalDetails.getPractitionerId());
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderType() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderType(
//                                salesOrderClinicalDetails.getRenderingProviderType()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderFacilityId() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderFacilityId(
//                                salesOrderClinicalDetails.getRenderingProviderFacilityId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderFacilityName() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderFacilityName(
//                                salesOrderClinicalDetails.getRenderingProviderFacilityName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderId() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderId(salesOrderClinicalDetails.getRenderingProviderId());
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderFirstName() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderFirstName(
//                                salesOrderClinicalDetails.getRenderingProviderFirstName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderMiddleName() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderMiddleName(
//                                salesOrderClinicalDetails.getRenderingProviderMiddleName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderLastName() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderLastName(
//                                salesOrderClinicalDetails.getRenderingProviderLastName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderNpi() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderNpi(salesOrderClinicalDetails.getRenderingProviderNpi());
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderDea() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderDea(salesOrderClinicalDetails.getRenderingProviderDea());
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderAddressId() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderAddressId(
//                                salesOrderClinicalDetails.getRenderingProviderAddressId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderAddressLine1() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderAddressLine1(
//                                salesOrderClinicalDetails.getRenderingProviderAddressLine1()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderAddressLine2() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderAddressLine2(
//                                salesOrderClinicalDetails.getRenderingProviderAddressLine2()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderCityName() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderCityName(
//                                salesOrderClinicalDetails.getRenderingProviderCityName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderStateName() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderStateName(
//                                salesOrderClinicalDetails.getRenderingProviderStateName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderZip() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderZip(salesOrderClinicalDetails.getRenderingProviderZip());
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderContactId() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderContactId(
//                                salesOrderClinicalDetails.getRenderingProviderContactId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderPhone1() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderPhone1(
//                                salesOrderClinicalDetails.getRenderingProviderPhone1()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderPhone2() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderPhone2(
//                                salesOrderClinicalDetails.getRenderingProviderPhone2()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderEmail() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderEmail(
//                                salesOrderClinicalDetails.getRenderingProviderEmail()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getRenderingProviderFax() != null) {
//                            existingSalesOrderClinicalDetails.setRenderingProviderFax(salesOrderClinicalDetails.getRenderingProviderFax());
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderType() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderType(
//                                salesOrderClinicalDetails.getReferringProviderType()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderFacilityId() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderFacilityId(
//                                salesOrderClinicalDetails.getReferringProviderFacilityId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderFacilityName() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderFacilityName(
//                                salesOrderClinicalDetails.getReferringProviderFacilityName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderId() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderId(salesOrderClinicalDetails.getReferringProviderId());
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderFirstName() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderFirstName(
//                                salesOrderClinicalDetails.getReferringProviderFirstName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderMiddleName() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderMiddleName(
//                                salesOrderClinicalDetails.getReferringProviderMiddleName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderLastName() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderLastName(
//                                salesOrderClinicalDetails.getReferringProviderLastName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderNpi() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderNpi(salesOrderClinicalDetails.getReferringProviderNpi());
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderDea() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderDea(salesOrderClinicalDetails.getReferringProviderDea());
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderAddressId() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderAddressId(
//                                salesOrderClinicalDetails.getReferringProviderAddressId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderAddressLine1() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderAddressLine1(
//                                salesOrderClinicalDetails.getReferringProviderAddressLine1()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderAddressLine2() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderAddressLine2(
//                                salesOrderClinicalDetails.getReferringProviderAddressLine2()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderCityName() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderCityName(
//                                salesOrderClinicalDetails.getReferringProviderCityName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderStateName() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderStateName(
//                                salesOrderClinicalDetails.getReferringProviderStateName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderZip() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderZip(salesOrderClinicalDetails.getReferringProviderZip());
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderContactId() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderContactId(
//                                salesOrderClinicalDetails.getReferringProviderContactId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderPhone1() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderPhone1(
//                                salesOrderClinicalDetails.getReferringProviderPhone1()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderPhone2() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderPhone2(
//                                salesOrderClinicalDetails.getReferringProviderPhone2()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderEmail() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderEmail(
//                                salesOrderClinicalDetails.getReferringProviderEmail()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getReferringProviderFax() != null) {
//                            existingSalesOrderClinicalDetails.setReferringProviderFax(salesOrderClinicalDetails.getReferringProviderFax());
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderType() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderType(salesOrderClinicalDetails.getOrderingProviderType());
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderFacilityId() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderFacilityId(
//                                salesOrderClinicalDetails.getOrderingProviderFacilityId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderFacilityName() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderFacilityName(
//                                salesOrderClinicalDetails.getOrderingProviderFacilityName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderId() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderId(salesOrderClinicalDetails.getOrderingProviderId());
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderFirstName() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderFirstName(
//                                salesOrderClinicalDetails.getOrderingProviderFirstName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderMiddleName() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderMiddleName(
//                                salesOrderClinicalDetails.getOrderingProviderMiddleName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderLastName() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderLastName(
//                                salesOrderClinicalDetails.getOrderingProviderLastName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderNpi() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderNpi(salesOrderClinicalDetails.getOrderingProviderNpi());
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderDea() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderDea(salesOrderClinicalDetails.getOrderingProviderDea());
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderAddressId() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderAddressId(
//                                salesOrderClinicalDetails.getOrderingProviderAddressId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderAddressLine1() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderAddressLine1(
//                                salesOrderClinicalDetails.getOrderingProviderAddressLine1()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderAddressLine2() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderAddressLine2(
//                                salesOrderClinicalDetails.getOrderingProviderAddressLine2()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderCityName() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderCityName(
//                                salesOrderClinicalDetails.getOrderingProviderCityName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderStateName() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderStateName(
//                                salesOrderClinicalDetails.getOrderingProviderStateName()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderZip() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderZip(salesOrderClinicalDetails.getOrderingProviderZip());
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderContactId() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderContactId(
//                                salesOrderClinicalDetails.getOrderingProviderContactId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderPhone1() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderPhone1(
//                                salesOrderClinicalDetails.getOrderingProviderPhone1()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderPhone2() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderPhone2(
//                                salesOrderClinicalDetails.getOrderingProviderPhone2()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderEmail() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderEmail(
//                                salesOrderClinicalDetails.getOrderingProviderEmail()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getOrderingProviderFax() != null) {
//                            existingSalesOrderClinicalDetails.setOrderingProviderFax(salesOrderClinicalDetails.getOrderingProviderFax());
//                        }
//                        if (salesOrderClinicalDetails.getMarketingReferalTypeId() != null) {
//                            existingSalesOrderClinicalDetails.setMarketingReferalTypeId(
//                                salesOrderClinicalDetails.getMarketingReferalTypeId()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getMarketingReferalTypeDescription() != null) {
//                            existingSalesOrderClinicalDetails.setMarketingReferalTypeDescription(
//                                salesOrderClinicalDetails.getMarketingReferalTypeDescription()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getMarketingReferalId() != null) {
//                            existingSalesOrderClinicalDetails.setMarketingReferalId(salesOrderClinicalDetails.getMarketingReferalId());
//                        }
//                        if (salesOrderClinicalDetails.getMarketingReferalName() != null) {
//                            existingSalesOrderClinicalDetails.setMarketingReferalName(salesOrderClinicalDetails.getMarketingReferalName());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode1() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode1(salesOrderClinicalDetails.getIcd10DiagnosisCode1());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode2() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode2(salesOrderClinicalDetails.getIcd10DiagnosisCode2());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode3() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode3(salesOrderClinicalDetails.getIcd10DiagnosisCode3());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode4() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode4(salesOrderClinicalDetails.getIcd10DiagnosisCode4());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode5() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode5(salesOrderClinicalDetails.getIcd10DiagnosisCode5());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode6() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode6(salesOrderClinicalDetails.getIcd10DiagnosisCode6());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode7() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode7(salesOrderClinicalDetails.getIcd10DiagnosisCode7());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode8() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode8(salesOrderClinicalDetails.getIcd10DiagnosisCode8());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode9() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode9(salesOrderClinicalDetails.getIcd10DiagnosisCode9());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode10() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode10(salesOrderClinicalDetails.getIcd10DiagnosisCode10());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode11() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode11(salesOrderClinicalDetails.getIcd10DiagnosisCode11());
//                        }
//                        if (salesOrderClinicalDetails.getIcd10DiagnosisCode12() != null) {
//                            existingSalesOrderClinicalDetails.setIcd10DiagnosisCode12(salesOrderClinicalDetails.getIcd10DiagnosisCode12());
//                        }
//                        if (salesOrderClinicalDetails.getEpsdtCertificationConditionIndicator() != null) {
//                            existingSalesOrderClinicalDetails.setEpsdtCertificationConditionIndicator(
//                                salesOrderClinicalDetails.getEpsdtCertificationConditionIndicator()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getEpsdtCertificationCode() != null) {
//                            existingSalesOrderClinicalDetails.setEpsdtCertificationCode(
//                                salesOrderClinicalDetails.getEpsdtCertificationCode()
//                            );
//                        }
//                        if (salesOrderClinicalDetails.getStatus() != null) {
//                            existingSalesOrderClinicalDetails.setStatus(salesOrderClinicalDetails.getStatus());
//                        }
//                        if (salesOrderClinicalDetails.getCreatedById() != null) {
//                            existingSalesOrderClinicalDetails.setCreatedById(salesOrderClinicalDetails.getCreatedById());
//                        }
//                        if (salesOrderClinicalDetails.getCreatedByName() != null) {
//                            existingSalesOrderClinicalDetails.setCreatedByName(salesOrderClinicalDetails.getCreatedByName());
//                        }
//                        if (salesOrderClinicalDetails.getCreatedDate() != null) {
//                            existingSalesOrderClinicalDetails.setCreatedDate(salesOrderClinicalDetails.getCreatedDate());
//                        }
//                        if (salesOrderClinicalDetails.getUpdatedById() != null) {
//                            existingSalesOrderClinicalDetails.setUpdatedById(salesOrderClinicalDetails.getUpdatedById());
//                        }
//                        if (salesOrderClinicalDetails.getUpdatedByName() != null) {
//                            existingSalesOrderClinicalDetails.setUpdatedByName(salesOrderClinicalDetails.getUpdatedByName());
//                        }
//                        if (salesOrderClinicalDetails.getUpdatedDate() != null) {
//                            existingSalesOrderClinicalDetails.setUpdatedDate(salesOrderClinicalDetails.getUpdatedDate());
//                        }
//
//                        return existingSalesOrderClinicalDetails;
//                    })
//                    .flatMap(salesOrderClinicalDetailsRepository::save);
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
//     * {@code GET  /sales-order-clinical-details} : get all the salesOrderClinicalDetails.
//     *
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salesOrderClinicalDetails in body.
//     */
//    @GetMapping("/sales-order-clinical-details")
//    public Mono<List<SalesOrderClinicalDetails>> getAllSalesOrderClinicalDetails() {
//        log.debug("REST request to get all SalesOrderClinicalDetails");
//        return salesOrderClinicalDetailsRepository.findAll().collectList();
//    }
//
//    /**
//     * {@code GET  /sales-order-clinical-details} : get all the salesOrderClinicalDetails as a stream.
//     * @return the {@link Flux} of salesOrderClinicalDetails.
//     */
//    @GetMapping(value = "/sales-order-clinical-details", produces = MediaType.APPLICATION_NDJSON_VALUE)
//    public Flux<SalesOrderClinicalDetails> getAllSalesOrderClinicalDetailsAsStream() {
//        log.debug("REST request to get all SalesOrderClinicalDetails as a stream");
//        return salesOrderClinicalDetailsRepository.findAll();
//    }
//
//    /**
//     * {@code GET  /sales-order-clinical-details/:id} : get the "id" salesOrderClinicalDetails.
//     *
//     * @param id the id of the salesOrderClinicalDetails to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salesOrderClinicalDetails, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/sales-order-clinical-details/{id}")
//    public Mono<ResponseEntity<SalesOrderClinicalDetails>> getSalesOrderClinicalDetails(@PathVariable Long id) {
//        log.debug("REST request to get SalesOrderClinicalDetails : {}", id);
//        Mono<SalesOrderClinicalDetails> salesOrderClinicalDetails = salesOrderClinicalDetailsRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(salesOrderClinicalDetails);
//    }
//
//    /**
//     * {@code DELETE  /sales-order-clinical-details/:id} : delete the "id" salesOrderClinicalDetails.
//     *
//     * @param id the id of the salesOrderClinicalDetails to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/sales-order-clinical-details/{id}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public Mono<ResponseEntity<Void>> deleteSalesOrderClinicalDetails(@PathVariable Long id) {
//        log.debug("REST request to delete SalesOrderClinicalDetails : {}", id);
//        return salesOrderClinicalDetailsRepository
//            .deleteById(id)
//            .map(result ->
//                ResponseEntity
//                    .noContent()
//                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
//                    .build()
//            );
//    }
}
