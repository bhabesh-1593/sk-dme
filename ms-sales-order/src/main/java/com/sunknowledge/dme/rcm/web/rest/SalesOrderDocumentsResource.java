package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.SalesOrderDocuments;
import com.sunknowledge.dme.rcm.repository.SalesOrderDocumentsRepository;
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
 * REST controller for managing {@link com.sunknowledge.dme.rcm.domain.SalesOrderDocuments}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SalesOrderDocumentsResource {

    private final Logger log = LoggerFactory.getLogger(SalesOrderDocumentsResource.class);

    private static final String ENTITY_NAME = "salesorderSalesOrderDocuments";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SalesOrderDocumentsRepository salesOrderDocumentsRepository;

    public SalesOrderDocumentsResource(SalesOrderDocumentsRepository salesOrderDocumentsRepository) {
        this.salesOrderDocumentsRepository = salesOrderDocumentsRepository;
    }

    /**
     * {@code POST  /sales-order-documents} : Create a new salesOrderDocuments.
     *
     * @param salesOrderDocuments the salesOrderDocuments to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salesOrderDocuments, or with status {@code 400 (Bad Request)} if the salesOrderDocuments has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/sales-order-documents")
//    public Mono<ResponseEntity<SalesOrderDocuments>> createSalesOrderDocuments(@Valid @RequestBody SalesOrderDocuments salesOrderDocuments)
//        throws URISyntaxException {
//        log.debug("REST request to save SalesOrderDocuments : {}", salesOrderDocuments);
//        if (salesOrderDocuments.getId() != null) {
//            throw new BadRequestAlertException("A new salesOrderDocuments cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        return salesOrderDocumentsRepository
//            .save(salesOrderDocuments)
//            .map(result -> {
//                try {
//                    return ResponseEntity
//                        .created(new URI("/api/sales-order-documents/" + result.getId()))
//                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//                        .body(result);
//                } catch (URISyntaxException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//    }
//
//    /**
//     * {@code PUT  /sales-order-documents/:id} : Updates an existing salesOrderDocuments.
//     *
//     * @param id the id of the salesOrderDocuments to save.
//     * @param salesOrderDocuments the salesOrderDocuments to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderDocuments,
//     * or with status {@code 400 (Bad Request)} if the salesOrderDocuments is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderDocuments couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/sales-order-documents/{id}")
//    public Mono<ResponseEntity<SalesOrderDocuments>> updateSalesOrderDocuments(
//        @PathVariable(value = "id", required = false) final Long id,
//        @Valid @RequestBody SalesOrderDocuments salesOrderDocuments
//    ) throws URISyntaxException {
//        log.debug("REST request to update SalesOrderDocuments : {}, {}", id, salesOrderDocuments);
//        if (salesOrderDocuments.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderDocuments.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderDocumentsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                return salesOrderDocumentsRepository
//                    .save(salesOrderDocuments)
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
//     * {@code PATCH  /sales-order-documents/:id} : Partial updates given fields of an existing salesOrderDocuments, field will ignore if it is null
//     *
//     * @param id the id of the salesOrderDocuments to save.
//     * @param salesOrderDocuments the salesOrderDocuments to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salesOrderDocuments,
//     * or with status {@code 400 (Bad Request)} if the salesOrderDocuments is not valid,
//     * or with status {@code 404 (Not Found)} if the salesOrderDocuments is not found,
//     * or with status {@code 500 (Internal Server Error)} if the salesOrderDocuments couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PatchMapping(value = "/sales-order-documents/{id}", consumes = { "application/json", "application/merge-patch+json" })
//    public Mono<ResponseEntity<SalesOrderDocuments>> partialUpdateSalesOrderDocuments(
//        @PathVariable(value = "id", required = false) final Long id,
//        @NotNull @RequestBody SalesOrderDocuments salesOrderDocuments
//    ) throws URISyntaxException {
//        log.debug("REST request to partial update SalesOrderDocuments partially : {}, {}", id, salesOrderDocuments);
//        if (salesOrderDocuments.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, salesOrderDocuments.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        return salesOrderDocumentsRepository
//            .existsById(id)
//            .flatMap(exists -> {
//                if (!exists) {
//                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//                }
//
//                Mono<SalesOrderDocuments> result = salesOrderDocumentsRepository
//                    .findById(salesOrderDocuments.getId())
//                    .map(existingSalesOrderDocuments -> {
//                        if (salesOrderDocuments.getPatientId() != null) {
//                            existingSalesOrderDocuments.setPatientId(salesOrderDocuments.getPatientId());
//                        }
//                        if (salesOrderDocuments.getPatientName() != null) {
//                            existingSalesOrderDocuments.setPatientName(salesOrderDocuments.getPatientName());
//                        }
//                        if (salesOrderDocuments.getPatientDob() != null) {
//                            existingSalesOrderDocuments.setPatientDob(salesOrderDocuments.getPatientDob());
//                        }
//                        if (salesOrderDocuments.getPatientDod() != null) {
//                            existingSalesOrderDocuments.setPatientDod(salesOrderDocuments.getPatientDod());
//                        }
//                        if (salesOrderDocuments.getPatientSsn() != null) {
//                            existingSalesOrderDocuments.setPatientSsn(salesOrderDocuments.getPatientSsn());
//                        }
//                        if (salesOrderDocuments.getQmbStatus() != null) {
//                            existingSalesOrderDocuments.setQmbStatus(salesOrderDocuments.getQmbStatus());
//                        }
//                        if (salesOrderDocuments.getPatientGender() != null) {
//                            existingSalesOrderDocuments.setPatientGender(salesOrderDocuments.getPatientGender());
//                        }
//                        if (salesOrderDocuments.getPatientHeight() != null) {
//                            existingSalesOrderDocuments.setPatientHeight(salesOrderDocuments.getPatientHeight());
//                        }
//                        if (salesOrderDocuments.getPatientWeight() != null) {
//                            existingSalesOrderDocuments.setPatientWeight(salesOrderDocuments.getPatientWeight());
//                        }
//                        if (salesOrderDocuments.getPatientContact1() != null) {
//                            existingSalesOrderDocuments.setPatientContact1(salesOrderDocuments.getPatientContact1());
//                        }
//                        if (salesOrderDocuments.getPatientContact2() != null) {
//                            existingSalesOrderDocuments.setPatientContact2(salesOrderDocuments.getPatientContact2());
//                        }
//                        if (salesOrderDocuments.getEmail() != null) {
//                            existingSalesOrderDocuments.setEmail(salesOrderDocuments.getEmail());
//                        }
//                        if (salesOrderDocuments.getFax() != null) {
//                            existingSalesOrderDocuments.setFax(salesOrderDocuments.getFax());
//                        }
//                        if (salesOrderDocuments.getHipaaOnFileStatus() != null) {
//                            existingSalesOrderDocuments.setHipaaOnFileStatus(salesOrderDocuments.getHipaaOnFileStatus());
//                        }
//                        if (salesOrderDocuments.getBranchId() != null) {
//                            existingSalesOrderDocuments.setBranchId(salesOrderDocuments.getBranchId());
//                        }
//                        if (salesOrderDocuments.getBranchName() != null) {
//                            existingSalesOrderDocuments.setBranchName(salesOrderDocuments.getBranchName());
//                        }
//                        if (salesOrderDocuments.getDocumentTypeId() != null) {
//                            existingSalesOrderDocuments.setDocumentTypeId(salesOrderDocuments.getDocumentTypeId());
//                        }
//                        if (salesOrderDocuments.getDocumentTypeName() != null) {
//                            existingSalesOrderDocuments.setDocumentTypeName(salesOrderDocuments.getDocumentTypeName());
//                        }
//                        if (salesOrderDocuments.getDocumentDate() != null) {
//                            existingSalesOrderDocuments.setDocumentDate(salesOrderDocuments.getDocumentDate());
//                        }
//                        if (salesOrderDocuments.getDocumentNote() != null) {
//                            existingSalesOrderDocuments.setDocumentNote(salesOrderDocuments.getDocumentNote());
//                        }
//                        if (salesOrderDocuments.getSalesOrderDocumentId() != null) {
//                            existingSalesOrderDocuments.setSalesOrderDocumentId(salesOrderDocuments.getSalesOrderDocumentId());
//                        }
//                        if (salesOrderDocuments.getDocumentTitle() != null) {
//                            existingSalesOrderDocuments.setDocumentTitle(salesOrderDocuments.getDocumentTitle());
//                        }
//                        if (salesOrderDocuments.getDocumentName() != null) {
//                            existingSalesOrderDocuments.setDocumentName(salesOrderDocuments.getDocumentName());
//                        }
//                        if (salesOrderDocuments.getScanBy() != null) {
//                            existingSalesOrderDocuments.setScanBy(salesOrderDocuments.getScanBy());
//                        }
//                        if (salesOrderDocuments.getFileUploadPath() != null) {
//                            existingSalesOrderDocuments.setFileUploadPath(salesOrderDocuments.getFileUploadPath());
//                        }
//                        if (salesOrderDocuments.getUploadDate() != null) {
//                            existingSalesOrderDocuments.setUploadDate(salesOrderDocuments.getUploadDate());
//                        }
//                        if (salesOrderDocuments.getUploadBy() != null) {
//                            existingSalesOrderDocuments.setUploadBy(salesOrderDocuments.getUploadBy());
//                        }
//                        if (salesOrderDocuments.getScanDate() != null) {
//                            existingSalesOrderDocuments.setScanDate(salesOrderDocuments.getScanDate());
//                        }
//                        if (salesOrderDocuments.getReviewStatus() != null) {
//                            existingSalesOrderDocuments.setReviewStatus(salesOrderDocuments.getReviewStatus());
//                        }
//                        if (salesOrderDocuments.getReviewReason() != null) {
//                            existingSalesOrderDocuments.setReviewReason(salesOrderDocuments.getReviewReason());
//                        }
//                        if (salesOrderDocuments.getReviewDate() != null) {
//                            existingSalesOrderDocuments.setReviewDate(salesOrderDocuments.getReviewDate());
//                        }
//                        if (salesOrderDocuments.getReviewBy() != null) {
//                            existingSalesOrderDocuments.setReviewBy(salesOrderDocuments.getReviewBy());
//                        }
//                        if (salesOrderDocuments.getStatus() != null) {
//                            existingSalesOrderDocuments.setStatus(salesOrderDocuments.getStatus());
//                        }
//                        if (salesOrderDocuments.getCreatedById() != null) {
//                            existingSalesOrderDocuments.setCreatedById(salesOrderDocuments.getCreatedById());
//                        }
//                        if (salesOrderDocuments.getCreatedByName() != null) {
//                            existingSalesOrderDocuments.setCreatedByName(salesOrderDocuments.getCreatedByName());
//                        }
//                        if (salesOrderDocuments.getCreatedDate() != null) {
//                            existingSalesOrderDocuments.setCreatedDate(salesOrderDocuments.getCreatedDate());
//                        }
//                        if (salesOrderDocuments.getUpdatedById() != null) {
//                            existingSalesOrderDocuments.setUpdatedById(salesOrderDocuments.getUpdatedById());
//                        }
//                        if (salesOrderDocuments.getUpdatedByName() != null) {
//                            existingSalesOrderDocuments.setUpdatedByName(salesOrderDocuments.getUpdatedByName());
//                        }
//                        if (salesOrderDocuments.getUpdatedDate() != null) {
//                            existingSalesOrderDocuments.setUpdatedDate(salesOrderDocuments.getUpdatedDate());
//                        }
//
//                        return existingSalesOrderDocuments;
//                    })
//                    .flatMap(salesOrderDocumentsRepository::save);
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
//     * {@code GET  /sales-order-documents} : get all the salesOrderDocuments.
//     *
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salesOrderDocuments in body.
//     */
//    @GetMapping("/sales-order-documents")
//    public Mono<List<SalesOrderDocuments>> getAllSalesOrderDocuments() {
//        log.debug("REST request to get all SalesOrderDocuments");
//        return salesOrderDocumentsRepository.findAll().collectList();
//    }
//
//    /**
//     * {@code GET  /sales-order-documents} : get all the salesOrderDocuments as a stream.
//     * @return the {@link Flux} of salesOrderDocuments.
//     */
//    @GetMapping(value = "/sales-order-documents", produces = MediaType.APPLICATION_NDJSON_VALUE)
//    public Flux<SalesOrderDocuments> getAllSalesOrderDocumentsAsStream() {
//        log.debug("REST request to get all SalesOrderDocuments as a stream");
//        return salesOrderDocumentsRepository.findAll();
//    }
//
//    /**
//     * {@code GET  /sales-order-documents/:id} : get the "id" salesOrderDocuments.
//     *
//     * @param id the id of the salesOrderDocuments to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salesOrderDocuments, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/sales-order-documents/{id}")
//    public Mono<ResponseEntity<SalesOrderDocuments>> getSalesOrderDocuments(@PathVariable Long id) {
//        log.debug("REST request to get SalesOrderDocuments : {}", id);
//        Mono<SalesOrderDocuments> salesOrderDocuments = salesOrderDocumentsRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(salesOrderDocuments);
//    }
//
//    /**
//     * {@code DELETE  /sales-order-documents/:id} : delete the "id" salesOrderDocuments.
//     *
//     * @param id the id of the salesOrderDocuments to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/sales-order-documents/{id}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public Mono<ResponseEntity<Void>> deleteSalesOrderDocuments(@PathVariable Long id) {
//        log.debug("REST request to delete SalesOrderDocuments : {}", id);
//        return salesOrderDocumentsRepository
//            .deleteById(id)
//            .map(result ->
//                ResponseEntity
//                    .noContent()
//                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
//                    .build()
//            );
//    }
}
