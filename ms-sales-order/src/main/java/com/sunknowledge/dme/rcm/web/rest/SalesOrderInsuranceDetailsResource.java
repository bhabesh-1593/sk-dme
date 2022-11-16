package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails;
import com.sunknowledge.dme.rcm.repository.SalesOrderInsuranceDetailsRepository;
import com.sunknowledge.dme.rcm.service.SalesOrderInsuranceDetailsService;
import com.sunknowledge.dme.rcm.service.SalesOrderMasterService;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderInsuranceSearchDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;
import com.sunknowledge.dme.rcm.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.sunknowledge.dme.rcm.service.SalesOrderInsuranceDetailsService;


/**
 * REST controller for managing {@link com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SalesOrderInsuranceDetailsResource {

    private final Logger log = LoggerFactory.getLogger(SalesOrderInsuranceDetailsResource.class);

    private static final String ENTITY_NAME = "salesorderSalesOrderInsuranceDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    SalesOrderInsuranceDetailsService salesOrderInsuranceDetailsService;

//    private final SalesOrderInsuranceDetailsRepository salesOrderInsuranceDetailsRepository;
//
//    public SalesOrderInsuranceDetailsResource(SalesOrderInsuranceDetailsRepository salesOrderInsuranceDetailsRepository) {
//        this.salesOrderInsuranceDetailsRepository = salesOrderInsuranceDetailsRepository;
//    }

    /**
     * {@code POST  /sales-order-insurance-details} : Create a new salesOrderInsuranceDetails.
     *
     * @param salesOrderInsuranceDetails the salesOrderInsuranceDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salesOrderInsuranceDetails, or with status {@code 400 (Bad Request)} if the salesOrderInsuranceDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/sales-order-insurance-details")
//    public Mono<ResponseEntity<SalesOrderInsuranceDetails>> createSalesOrderInsuranceDetails(
//        @Valid @RequestBody SalesOrderInsuranceDetails salesOrderInsuranceDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to save SalesOrderInsuranceDetails : {}", salesOrderInsuranceDetails);
//        if (salesOrderInsuranceDetails.getId() != null) {
//            throw new BadRequestAlertException("A new salesOrderInsuranceDetails cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        return salesOrderInsuranceDetailsRepository
//            .save(salesOrderInsuranceDetails)
//            .map(result -> {
//                try {
//                    return ResponseEntity
//                        .created(new URI("/api/sales-order-insurance-details/" + result.getId()))
//                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//                        .body(result);
//                } catch (URISyntaxException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//    }
//
//    /**
//     * {@code PUT  /sales-order-insurance-details/:id} : Updates an existing salesOrderInsuranceDetails.
//     *
//     * @param id the id of the salesOrderInsuranceDetails to save.
//     * @param salesOrderInsuranceDetails the salesOrderInsuranceDetails to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderInsuranceDetails,
//     * or with status {@code 400 (Bad Request)} if the salesOrderInsuranceDetails is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderInsuranceDetails couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/sales-order-insurance-details/{id}")
//    public Mono<ResponseEntity<SalesOrderInsuranceDetails>> updateSalesOrderInsuranceDetails(
//        @PathVariable(value = "id", required = false) final Long id,
//        @Valid @RequestBody SalesOrderInsuranceDetails salesOrderInsuranceDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to update SalesOrderInsuranceDetails : {}, {}", id, salesOrderInsuranceDetails);
//        if (salesOrderInsuranceDetails.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderInsuranceDetails.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderInsuranceDetailsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                return salesOrderInsuranceDetailsRepository
//                    .save(salesOrderInsuranceDetails)
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
//     * {@code PATCH  /sales-order-insurance-details/:id} : Partial updates given fields of an existing salesOrderInsuranceDetails, field will ignore if it is null
//     *
//     * @param id the id of the salesOrderInsuranceDetails to save.
//     * @param salesOrderInsuranceDetails the salesOrderInsuranceDetails to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderInsuranceDetails,
//     * or with status {@code 400 (Bad Request)} if the salesOrderInsuranceDetails is not valid,
//     * or with status {@code 404 (Not Found)} if the salesOrderInsuranceDetails is not found,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderInsuranceDetails couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PatchMapping(value = "/sales-order-insurance-details/{id}", consumes = { "application/json", "application/merge-patch+json" })
//    public Mono<ResponseEntity<SalesOrderInsuranceDetails>> partialUpdateSalesOrderInsuranceDetails(
//        @PathVariable(value = "id", required = false) final Long id,
//        @NotNull @RequestBody SalesOrderInsuranceDetails salesOrderInsuranceDetails
//    ) throws URISyntaxException {
//        log.debug("REST request to partial update SalesOrderInsuranceDetails partially : {}, {}", id, salesOrderInsuranceDetails);
//        if (salesOrderInsuranceDetails.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderInsuranceDetails.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderInsuranceDetailsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                Mono<SalesOrderInsuranceDetails> result = salesOrderInsuranceDetailsRepository
//                    .findById(salesOrderInsuranceDetails.getId())
//                    .map(existingSalesOrderInsuranceDetails -> {
//                        if (salesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId() != null) {
//                            existingSalesOrderInsuranceDetails.setSalesOrderInsuranceDetailsId(
//                                salesOrderInsuranceDetails.getSalesOrderInsuranceDetailsId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSalesOrderId() != null) {
//                            existingSalesOrderInsuranceDetails.setSalesOrderId(salesOrderInsuranceDetails.getSalesOrderId());
//                        }
//                        if (salesOrderInsuranceDetails.getPatientId() != null) {
//                            existingSalesOrderInsuranceDetails.setPatientId(salesOrderInsuranceDetails.getPatientId());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerId() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerId(salesOrderInsuranceDetails.getPrimaryInsurerId());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerName() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerName(salesOrderInsuranceDetails.getPrimaryInsurerName());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsuranceGroupId() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsuranceGroupId(
//                                salesOrderInsuranceDetails.getPrimaryInsuranceGroupId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsuranceGroupName() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsuranceGroupName(
//                                salesOrderInsuranceDetails.getPrimaryInsuranceGroupName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurancePlanId() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurancePlanId(
//                                salesOrderInsuranceDetails.getPrimaryInsurancePlanId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurancePlanType() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurancePlanType(
//                                salesOrderInsuranceDetails.getPrimaryInsurancePlanType()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsuranceStateId() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsuranceStateId(
//                                salesOrderInsuranceDetails.getPrimaryInsuranceStateId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsuranceStateName() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsuranceStateName(
//                                salesOrderInsuranceDetails.getPrimaryInsuranceStateName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerPolicyNo() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerPolicyNo(
//                                salesOrderInsuranceDetails.getPrimaryInsurerPolicyNo()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerPatientIdNumber(
//                                salesOrderInsuranceDetails.getPrimaryInsurerPatientIdNumber()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerEffectiveDate(
//                                salesOrderInsuranceDetails.getPrimaryInsurerEffectiveDate()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerVerificationStatus(
//                                salesOrderInsuranceDetails.getPrimaryInsurerVerificationStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerVerificationDate() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerVerificationDate(
//                                salesOrderInsuranceDetails.getPrimaryInsurerVerificationDate()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryInsurerPayPercentage() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryInsurerPayPercentage(
//                                salesOrderInsuranceDetails.getPrimaryInsurerPayPercentage()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryBox10d() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryBox10d(salesOrderInsuranceDetails.getPrimaryBox10d());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryBox19() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryBox19(salesOrderInsuranceDetails.getPrimaryBox19());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryBox24ia() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryBox24ia(salesOrderInsuranceDetails.getPrimaryBox24ia());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryBox24ja() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryBox24ja(salesOrderInsuranceDetails.getPrimaryBox24ja());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryBox24jb() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryBox24jb(salesOrderInsuranceDetails.getPrimaryBox24jb());
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryIncludeBox24Jbstatus(
//                                salesOrderInsuranceDetails.getPrimaryIncludeBox24Jbstatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryIncludePayerSalesOrderStatus(
//                                salesOrderInsuranceDetails.getPrimaryIncludePayerSalesOrderStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryWaitForPreviousPayerBeforeBillingStatus(
//                                salesOrderInsuranceDetails.getPrimaryWaitForPreviousPayerBeforeBillingStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPrimaryPayPercentageStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPrimaryPayPercentageStatus(
//                                salesOrderInsuranceDetails.getPrimaryPayPercentageStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerId() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerId(salesOrderInsuranceDetails.getSecondaryInsurerId());
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerName() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerName(
//                                salesOrderInsuranceDetails.getSecondaryInsurerName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsuranceGroupId() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsuranceGroupId(
//                                salesOrderInsuranceDetails.getSecondaryInsuranceGroupId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsuranceGroupName() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsuranceGroupName(
//                                salesOrderInsuranceDetails.getSecondaryInsuranceGroupName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurancePlanId() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurancePlanId(
//                                salesOrderInsuranceDetails.getSecondaryInsurancePlanId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurancePlanType() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurancePlanType(
//                                salesOrderInsuranceDetails.getSecondaryInsurancePlanType()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsuranceStateId() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsuranceStateId(
//                                salesOrderInsuranceDetails.getSecondaryInsuranceStateId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsuranceStateName() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsuranceStateName(
//                                salesOrderInsuranceDetails.getSecondaryInsuranceStateName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerPolicyNo() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerPolicyNo(
//                                salesOrderInsuranceDetails.getSecondaryInsurerPolicyNo()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerPatientIdNumber(
//                                salesOrderInsuranceDetails.getSecondaryInsurerPatientIdNumber()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerEffectiveDate(
//                                salesOrderInsuranceDetails.getSecondaryInsurerEffectiveDate()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerVerificationStatus(
//                                salesOrderInsuranceDetails.getSecondaryInsurerVerificationStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerVerificationDate() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerVerificationDate(
//                                salesOrderInsuranceDetails.getSecondaryInsurerVerificationDate()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryInsurerPayPercentage() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryInsurerPayPercentage(
//                                salesOrderInsuranceDetails.getSecondaryInsurerPayPercentage()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryBox10d() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryBox10d(salesOrderInsuranceDetails.getSecondaryBox10d());
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryBox19() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryBox19(salesOrderInsuranceDetails.getSecondaryBox19());
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryBox24ia() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryBox24ia(salesOrderInsuranceDetails.getSecondaryBox24ia());
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryBox24ja() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryBox24ja(salesOrderInsuranceDetails.getSecondaryBox24ja());
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryBox24jb() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryBox24jb(salesOrderInsuranceDetails.getSecondaryBox24jb());
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryIncludeBox24jbStatus(
//                                salesOrderInsuranceDetails.getSecondaryIncludeBox24jbStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryIncludePayerSalesOrderStatus(
//                                salesOrderInsuranceDetails.getSecondaryIncludePayerSalesOrderStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryWaitPreviousPayerBefrBillingStatus(
//                                salesOrderInsuranceDetails.getSecondaryWaitPreviousPayerBefrBillingStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getSecondaryPayPercentageStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setSecondaryPayPercentageStatus(
//                                salesOrderInsuranceDetails.getSecondaryPayPercentageStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerId() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerId(salesOrderInsuranceDetails.getTertiaryInsurerId());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerName() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerName(salesOrderInsuranceDetails.getTertiaryInsurerName());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsuranceGroupId() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsuranceGroupId(
//                                salesOrderInsuranceDetails.getTertiaryInsuranceGroupId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsuranceGroupName() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsuranceGroupName(
//                                salesOrderInsuranceDetails.getTertiaryInsuranceGroupName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurancePlanId() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurancePlanId(
//                                salesOrderInsuranceDetails.getTertiaryInsurancePlanId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurancePlanType() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurancePlanType(
//                                salesOrderInsuranceDetails.getTertiaryInsurancePlanType()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsuranceStateId() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsuranceStateId(
//                                salesOrderInsuranceDetails.getTertiaryInsuranceStateId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsuranceStateName() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsuranceStateName(
//                                salesOrderInsuranceDetails.getTertiaryInsuranceStateName()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerPolicyno() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerPolicyno(
//                                salesOrderInsuranceDetails.getTertiaryInsurerPolicyno()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerPatientIdNumber(
//                                salesOrderInsuranceDetails.getTertiaryInsurerPatientIdNumber()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerEffectiveDate(
//                                salesOrderInsuranceDetails.getTertiaryInsurerEffectiveDate()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerVerificationStatus(
//                                salesOrderInsuranceDetails.getTertiaryInsurerVerificationStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerVerificationDate() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerVerificationDate(
//                                salesOrderInsuranceDetails.getTertiaryInsurerVerificationDate()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryInsurerPayPercentage() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryInsurerPayPercentage(
//                                salesOrderInsuranceDetails.getTertiaryInsurerPayPercentage()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryBox10d() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryBox10d(salesOrderInsuranceDetails.getTertiaryBox10d());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryBox19() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryBox19(salesOrderInsuranceDetails.getTertiaryBox19());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryBox24ia() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryBox24ia(salesOrderInsuranceDetails.getTertiaryBox24ia());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryBox24ja() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryBox24ja(salesOrderInsuranceDetails.getTertiaryBox24ja());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryBox24jb() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryBox24jb(salesOrderInsuranceDetails.getTertiaryBox24jb());
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryIncludeBox24jbStatus(
//                                salesOrderInsuranceDetails.getTertiaryIncludeBox24jbStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryIncludePayerInSalesOrderStatus(
//                                salesOrderInsuranceDetails.getTertiaryIncludePayerInSalesOrderStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryWaitPreviousPayerBeforeBillingStatus(
//                                salesOrderInsuranceDetails.getTertiaryWaitPreviousPayerBeforeBillingStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getTertiaryPayPercentage0Status() != null) {
//                            existingSalesOrderInsuranceDetails.setTertiaryPayPercentage0Status(
//                                salesOrderInsuranceDetails.getTertiaryPayPercentage0Status()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getInsuranceVerificationStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setInsuranceVerificationStatus(
//                                salesOrderInsuranceDetails.getInsuranceVerificationStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getCoverageVerificationStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setCoverageVerificationStatus(
//                                salesOrderInsuranceDetails.getCoverageVerificationStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setExcludeFromEligibilityCheckStatus(
//                                salesOrderInsuranceDetails.getExcludeFromEligibilityCheckStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPatientPayPercentage() != null) {
//                            existingSalesOrderInsuranceDetails.setPatientPayPercentage(
//                                salesOrderInsuranceDetails.getPatientPayPercentage()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPatientIncludeThisPayorInSalesOrderStatus(
//                                salesOrderInsuranceDetails.getPatientIncludeThisPayorInSalesOrderStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setPatientWaitForPreviousPayerBeforeBillingStatus(
//                                salesOrderInsuranceDetails.getPatientWaitForPreviousPayerBeforeBillingStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getWorkersCompDateOfOnset() != null) {
//                            existingSalesOrderInsuranceDetails.setWorkersCompDateOfOnset(
//                                salesOrderInsuranceDetails.getWorkersCompDateOfOnset()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setWorkersCompInjuryRelatedEmploymentStatus(
//                                salesOrderInsuranceDetails.getWorkersCompInjuryRelatedEmploymentStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setWorkersCompInjuryRelatedAutoAccidentStatus(
//                                salesOrderInsuranceDetails.getWorkersCompInjuryRelatedAutoAccidentStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId() != null) {
//                            existingSalesOrderInsuranceDetails.setWorkersCompAutoAccidentStateId(
//                                salesOrderInsuranceDetails.getWorkersCompAutoAccidentStateId()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setWorkersCompInjuryRelatedToOtherAccidentStatus(
//                                salesOrderInsuranceDetails.getWorkersCompInjuryRelatedToOtherAccidentStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getEclaimsAttachmentStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setEclaimsAttachmentStatus(
//                                salesOrderInsuranceDetails.getEclaimsAttachmentStatus()
//                            );
//                        }
//                        if (salesOrderInsuranceDetails.getAttachmentNumber() != null) {
//                            existingSalesOrderInsuranceDetails.setAttachmentNumber(salesOrderInsuranceDetails.getAttachmentNumber());
//                        }
//                        if (salesOrderInsuranceDetails.getTypeCode() != null) {
//                            existingSalesOrderInsuranceDetails.setTypeCode(salesOrderInsuranceDetails.getTypeCode());
//                        }
//                        if (salesOrderInsuranceDetails.getTransactionCode() != null) {
//                            existingSalesOrderInsuranceDetails.setTransactionCode(salesOrderInsuranceDetails.getTransactionCode());
//                        }
//                        if (salesOrderInsuranceDetails.getClaimsNoteType() != null) {
//                            existingSalesOrderInsuranceDetails.setClaimsNoteType(salesOrderInsuranceDetails.getClaimsNoteType());
//                        }
//                        if (salesOrderInsuranceDetails.getClaimsNote() != null) {
//                            existingSalesOrderInsuranceDetails.setClaimsNote(salesOrderInsuranceDetails.getClaimsNote());
//                        }
//                        if (salesOrderInsuranceDetails.getSalesOrderNo() != null) {
//                            existingSalesOrderInsuranceDetails.setSalesOrderNo(salesOrderInsuranceDetails.getSalesOrderNo());
//                        }
//                        if (salesOrderInsuranceDetails.getStatus() != null) {
//                            existingSalesOrderInsuranceDetails.setStatus(salesOrderInsuranceDetails.getStatus());
//                        }
//                        if (salesOrderInsuranceDetails.getCreatedById() != null) {
//                            existingSalesOrderInsuranceDetails.setCreatedById(salesOrderInsuranceDetails.getCreatedById());
//                        }
//                        if (salesOrderInsuranceDetails.getCreatedByName() != null) {
//                            existingSalesOrderInsuranceDetails.setCreatedByName(salesOrderInsuranceDetails.getCreatedByName());
//                        }
//                        if (salesOrderInsuranceDetails.getCreatedDate() != null) {
//                            existingSalesOrderInsuranceDetails.setCreatedDate(salesOrderInsuranceDetails.getCreatedDate());
//                        }
//                        if (salesOrderInsuranceDetails.getUpdatedById() != null) {
//                            existingSalesOrderInsuranceDetails.setUpdatedById(salesOrderInsuranceDetails.getUpdatedById());
//                        }
//                        if (salesOrderInsuranceDetails.getUpdatedByName() != null) {
//                            existingSalesOrderInsuranceDetails.setUpdatedByName(salesOrderInsuranceDetails.getUpdatedByName());
//                        }
//                        if (salesOrderInsuranceDetails.getUpdatedDate() != null) {
//                            existingSalesOrderInsuranceDetails.setUpdatedDate(salesOrderInsuranceDetails.getUpdatedDate());
//                        }
//
//                        return existingSalesOrderInsuranceDetails;
//                    })
//                    .flatMap(salesOrderInsuranceDetailsRepository::save);
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
//     * {@code GET  /sales-order-insurance-details} : get all the salesOrderInsuranceDetails.
//     *
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salesOrderInsuranceDetails in body.
//     */
//    @GetMapping("/sales-order-insurance-details")
//    public Mono<List<SalesOrderInsuranceDetails>> getAllSalesOrderInsuranceDetails() {
//        log.debug("REST request to get all SalesOrderInsuranceDetails");
//        return salesOrderInsuranceDetailsRepository.findAll().collectList();
//    }
//
//    /**
//     * {@code GET  /sales-order-insurance-details} : get all the salesOrderInsuranceDetails as a stream.
//     * @return the {@link Flux} of salesOrderInsuranceDetails.
//     */
//    @GetMapping(value = "/sales-order-insurance-details", produces = MediaType.APPLICATION_NDJSON_VALUE)
//    public Flux<SalesOrderInsuranceDetails> getAllSalesOrderInsuranceDetailsAsStream() {
//        log.debug("REST request to get all SalesOrderInsuranceDetails as a stream");
//        return salesOrderInsuranceDetailsRepository.findAll();
//    }
//
//    /**
//     * {@code GET  /sales-order-insurance-details/:id} : get the "id" salesOrderInsuranceDetails.
//     *
//     * @param id the id of the salesOrderInsuranceDetails to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salesOrderInsuranceDetails, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/sales-order-insurance-details/{id}")
//    public Mono<ResponseEntity<SalesOrderInsuranceDetails>> getSalesOrderInsuranceDetails(@PathVariable Long id) {
//        log.debug("REST request to get SalesOrderInsuranceDetails : {}", id);
//        Mono<SalesOrderInsuranceDetails> salesOrderInsuranceDetails = salesOrderInsuranceDetailsRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(salesOrderInsuranceDetails);
//    }
//
//    /**
//     * {@code DELETE  /sales-order-insurance-details/:id} : delete the "id" salesOrderInsuranceDetails.
//     *
//     * @param id the id of the salesOrderInsuranceDetails to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/sales-order-insurance-details/{id}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public Mono<ResponseEntity<Void>> deleteSalesOrderInsuranceDetails(@PathVariable Long id) {
//        log.debug("REST request to delete SalesOrderInsuranceDetails : {}", id);
//        return salesOrderInsuranceDetailsRepository
//            .deleteById(id)
//            .map(result ->
//                ResponseEntity
//                    .noContent()
//                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
//                    .build()
//            );
//    }

    /**
     * {@code POST  /getSODetailsByInsuranceName} : Get SO Details By Insurance Name
     */
    @PostMapping("/getSOInsuranceDetailsByInsuranceName")
    public Flux<SalesOrderInsuranceSearchDetailsDTO> getSOInsuranceDetailsByInsuranceName(@RequestParam("insuranceName") String insuranceName) {
        log.debug("REST request to get all Sales Order Insurance Details By insuranceName : {}", insuranceName);

        return salesOrderInsuranceDetailsService.getSOInsuranceDetailsByInsuranceName(insuranceName);
    }

    /**
     * {@code POST  /getSODetailsByInsuranceId} : Get SO Details By Insurance Id
     */
    @PostMapping("/getSODetailsByInsuranceId")
    public Flux<SalesOrderSearchDetailsDTO> getSODetailsByInsuranceId(@RequestParam("insuranceId") Long insuranceId) {
        log.debug("REST request to get all Sales Order Insurance Details By insuranceId : {}", insuranceId);

        return salesOrderInsuranceDetailsService.getSODetailsByInsuranceId(insuranceId);
    }
}
