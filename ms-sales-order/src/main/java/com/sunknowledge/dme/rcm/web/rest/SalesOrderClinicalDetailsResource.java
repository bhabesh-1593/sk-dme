package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.repository.SalesOrderClinicalDetailsRepository;
import com.sunknowledge.dme.rcm.service.SalesOrderClinicalDetailsService;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderClinicalDetailsDTO;
import com.sunknowledge.dme.rcm.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link com.sunknowledge.dme.rcm.domain.SalesOrderClinicalDetails}.
 */
@RestController
@RequestMapping("/api")
public class SalesOrderClinicalDetailsResource {

    private final Logger log = LoggerFactory.getLogger(SalesOrderClinicalDetailsResource.class);

    private static final String ENTITY_NAME = "salesorderSalesOrderClinicalDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SalesOrderClinicalDetailsService salesOrderClinicalDetailsService;

    private final SalesOrderClinicalDetailsRepository salesOrderClinicalDetailsRepository;

    public SalesOrderClinicalDetailsResource(
        SalesOrderClinicalDetailsService salesOrderClinicalDetailsService,
        SalesOrderClinicalDetailsRepository salesOrderClinicalDetailsRepository
    ) {
        this.salesOrderClinicalDetailsService = salesOrderClinicalDetailsService;
        this.salesOrderClinicalDetailsRepository = salesOrderClinicalDetailsRepository;
    }

    /**
     * {@code POST  /sales-order-clinical-details} : Create a new salesOrderClinicalDetails.
     *
     * @param salesOrderClinicalDetailsDTO the salesOrderClinicalDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salesOrderClinicalDetailsDTO, or with status {@code 400 (Bad Request)} if the salesOrderClinicalDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sales-order-clinical-details")
    public Mono<ResponseEntity<SalesOrderClinicalDetailsDTO>> createSalesOrderClinicalDetails(
        @Valid @RequestBody SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to save SalesOrderClinicalDetails : {}", salesOrderClinicalDetailsDTO);
        if (salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId() != null) {
            throw new BadRequestAlertException("A new salesOrderClinicalDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return salesOrderClinicalDetailsService
            .save(salesOrderClinicalDetailsDTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/sales-order-clinical-details/" + result.getSalesOderClinicalDetailsId()))
                        .headers(
                            HeaderUtil.createEntityCreationAlert(
                                applicationName,
                                false,
                                ENTITY_NAME,
                                result.getSalesOderClinicalDetailsId().toString()
                            )
                        )
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /sales-order-clinical-details/:salesOderClinicalDetailsId} : Updates an existing salesOrderClinicalDetails.
     *
     * @param salesOderClinicalDetailsId the id of the salesOrderClinicalDetailsDTO to save.
     * @param salesOrderClinicalDetailsDTO the salesOrderClinicalDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderClinicalDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the salesOrderClinicalDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the salesOrderClinicalDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sales-order-clinical-details/{salesOderClinicalDetailsId}")
    public Mono<ResponseEntity<SalesOrderClinicalDetailsDTO>> updateSalesOrderClinicalDetails(
        @PathVariable(value = "salesOderClinicalDetailsId", required = false) final Long salesOderClinicalDetailsId,
        @Valid @RequestBody SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update SalesOrderClinicalDetails : {}, {}", salesOderClinicalDetailsId, salesOrderClinicalDetailsDTO);
        if (salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(salesOderClinicalDetailsId, salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return salesOrderClinicalDetailsRepository
            .existsById(salesOderClinicalDetailsId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return salesOrderClinicalDetailsService
                    .update(salesOrderClinicalDetailsDTO)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(
                                    applicationName,
                                    false,
                                    ENTITY_NAME,
                                    result.getSalesOderClinicalDetailsId().toString()
                                )
                            )
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /sales-order-clinical-details/:salesOderClinicalDetailsId} : Partial updates given fields of an existing salesOrderClinicalDetails, field will ignore if it is null
     *
     * @param salesOderClinicalDetailsId the id of the salesOrderClinicalDetailsDTO to save.
     * @param salesOrderClinicalDetailsDTO the salesOrderClinicalDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderClinicalDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the salesOrderClinicalDetailsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the salesOrderClinicalDetailsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the salesOrderClinicalDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(
        value = "/sales-order-clinical-details/{salesOderClinicalDetailsId}",
        consumes = { "application/json", "application/merge-patch+json" }
    )
    public Mono<ResponseEntity<SalesOrderClinicalDetailsDTO>> partialUpdateSalesOrderClinicalDetails(
        @PathVariable(value = "salesOderClinicalDetailsId", required = false) final Long salesOderClinicalDetailsId,
        @NotNull @RequestBody SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO
    ) throws URISyntaxException {
        log.debug(
            "REST request to partial update SalesOrderClinicalDetails partially : {}, {}",
            salesOderClinicalDetailsId,
            salesOrderClinicalDetailsDTO
        );
        if (salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(salesOderClinicalDetailsId, salesOrderClinicalDetailsDTO.getSalesOderClinicalDetailsId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return salesOrderClinicalDetailsRepository
            .existsById(salesOderClinicalDetailsId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<SalesOrderClinicalDetailsDTO> result = salesOrderClinicalDetailsService.partialUpdate(salesOrderClinicalDetailsDTO);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(
                                    applicationName,
                                    false,
                                    ENTITY_NAME,
                                    res.getSalesOderClinicalDetailsId().toString()
                                )
                            )
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /sales-order-clinical-details} : get all the salesOrderClinicalDetails.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salesOrderClinicalDetails in body.
     */
    @GetMapping("/sales-order-clinical-details")
    public Mono<ResponseEntity<List<SalesOrderClinicalDetailsDTO>>> getAllSalesOrderClinicalDetails(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of SalesOrderClinicalDetails");
        return salesOrderClinicalDetailsService
            .countAll()
            .zipWith(salesOrderClinicalDetailsService.findAll(pageable).collectList())
            .map(countWithEntities ->
                ResponseEntity
                    .ok()
                    .headers(
                        PaginationUtil.generatePaginationHttpHeaders(
                            UriComponentsBuilder.fromHttpRequest(request),
                            new PageImpl<>(countWithEntities.getT2(), pageable, countWithEntities.getT1())
                        )
                    )
                    .body(countWithEntities.getT2())
            );
    }

    /**
     * {@code GET  /sales-order-clinical-details/:id} : get the "id" salesOrderClinicalDetails.
     *
     * @param id the id of the salesOrderClinicalDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salesOrderClinicalDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sales-order-clinical-details/{id}")
    public Mono<ResponseEntity<SalesOrderClinicalDetailsDTO>> getSalesOrderClinicalDetails(@PathVariable Long id) {
        log.debug("REST request to get SalesOrderClinicalDetails : {}", id);
        Mono<SalesOrderClinicalDetailsDTO> salesOrderClinicalDetailsDTO = salesOrderClinicalDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(salesOrderClinicalDetailsDTO);
    }

    /**
     * {@code DELETE  /sales-order-clinical-details/:id} : delete the "id" salesOrderClinicalDetails.
     *
     * @param id the id of the salesOrderClinicalDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sales-order-clinical-details/{id}")
    public Mono<ResponseEntity<Void>> deleteSalesOrderClinicalDetails(@PathVariable Long id) {
        log.debug("REST request to delete SalesOrderClinicalDetails : {}", id);
        return salesOrderClinicalDetailsService
            .delete(id)
            .then(
                Mono.just(
                    ResponseEntity
                        .noContent()
                        .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
                        .build()
                )
            );
    }
}
