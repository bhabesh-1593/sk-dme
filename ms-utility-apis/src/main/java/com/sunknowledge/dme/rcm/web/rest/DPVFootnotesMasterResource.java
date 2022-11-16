package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.usps.DPVFootnotesMaster;
import com.sunknowledge.dme.rcm.repository.usps.DPVFootnotesMasterRepository;
import com.sunknowledge.dme.rcm.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

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
 * REST controller for managing {@link DPVFootnotesMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class DPVFootnotesMasterResource {

    private final Logger log = LoggerFactory.getLogger(DPVFootnotesMasterResource.class);

    private static final String ENTITY_NAME = "utilityapisDpvFootnotesMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DPVFootnotesMasterRepository dPVFootnotesMasterRepository;

    public DPVFootnotesMasterResource(DPVFootnotesMasterRepository dPVFootnotesMasterRepository) {
        this.dPVFootnotesMasterRepository = dPVFootnotesMasterRepository;
    }

    /**
     * {@code POST  /dpv-footnotes-masters} : Create a new dPVFootnotesMaster.
     *
     * @param dPVFootnotesMaster the dPVFootnotesMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dPVFootnotesMaster, or with status {@code 400 (Bad Request)} if the dPVFootnotesMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dpv-footnotes-masters")
    public Mono<ResponseEntity<DPVFootnotesMaster>> createDPVFootnotesMaster(@RequestBody DPVFootnotesMaster dPVFootnotesMaster)
        throws URISyntaxException {
        log.debug("REST request to save DPVFootnotesMaster : {}", dPVFootnotesMaster);
        if (dPVFootnotesMaster.getDpvFootnotesId() != null) {
            throw new BadRequestAlertException("A new dPVFootnotesMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return dPVFootnotesMasterRepository
            .save(dPVFootnotesMaster)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/dpv-footnotes-masters/" + result.getDpvFootnotesId()))
                        .headers(
                            HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getDpvFootnotesId().toString())
                        )
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /dpv-footnotes-masters/:dpvFootnotesId} : Updates an existing dPVFootnotesMaster.
     *
     * @param dpvFootnotesId the id of the dPVFootnotesMaster to save.
     * @param dPVFootnotesMaster the dPVFootnotesMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dPVFootnotesMaster,
     * or with status {@code 400 (Bad Request)} if the dPVFootnotesMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dPVFootnotesMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dpv-footnotes-masters/{dpvFootnotesId}")
    public Mono<ResponseEntity<DPVFootnotesMaster>> updateDPVFootnotesMaster(
        @PathVariable(value = "dpvFootnotesId", required = false) final Long dpvFootnotesId,
        @RequestBody DPVFootnotesMaster dPVFootnotesMaster
    ) throws URISyntaxException {
        log.debug("REST request to update DPVFootnotesMaster : {}, {}", dpvFootnotesId, dPVFootnotesMaster);
        if (dPVFootnotesMaster.getDpvFootnotesId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(dpvFootnotesId, dPVFootnotesMaster.getDpvFootnotesId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return dPVFootnotesMasterRepository
            .existsById(dpvFootnotesId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return dPVFootnotesMasterRepository
                    .save(dPVFootnotesMaster)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(
                                    applicationName,
                                    false,
                                    ENTITY_NAME,
                                    result.getDpvFootnotesId().toString()
                                )
                            )
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /dpv-footnotes-masters/:dpvFootnotesId} : Partial updates given fields of an existing dPVFootnotesMaster, field will ignore if it is null
     *
     * @param dpvFootnotesId the id of the dPVFootnotesMaster to save.
     * @param dPVFootnotesMaster the dPVFootnotesMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dPVFootnotesMaster,
     * or with status {@code 400 (Bad Request)} if the dPVFootnotesMaster is not valid,
     * or with status {@code 404 (Not Found)} if the dPVFootnotesMaster is not found,
     * or with status {@code 500 (Internal Server Error)} if the dPVFootnotesMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/dpv-footnotes-masters/{dpvFootnotesId}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<DPVFootnotesMaster>> partialUpdateDPVFootnotesMaster(
        @PathVariable(value = "dpvFootnotesId", required = false) final Long dpvFootnotesId,
        @RequestBody DPVFootnotesMaster dPVFootnotesMaster
    ) throws URISyntaxException {
        log.debug("REST request to partial update DPVFootnotesMaster partially : {}, {}", dpvFootnotesId, dPVFootnotesMaster);
        if (dPVFootnotesMaster.getDpvFootnotesId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(dpvFootnotesId, dPVFootnotesMaster.getDpvFootnotesId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return dPVFootnotesMasterRepository
            .existsById(dpvFootnotesId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<DPVFootnotesMaster> result = dPVFootnotesMasterRepository
                    .findById(dPVFootnotesMaster.getDpvFootnotesId())
                    .map(existingDPVFootnotesMaster -> {
                        if (dPVFootnotesMaster.getEnumerations() != null) {
                            existingDPVFootnotesMaster.setEnumerations(dPVFootnotesMaster.getEnumerations());
                        }
                        if (dPVFootnotesMaster.getDefinition() != null) {
                            existingDPVFootnotesMaster.setDefinition(dPVFootnotesMaster.getDefinition());
                        }

                        return existingDPVFootnotesMaster;
                    })
                    .flatMap(dPVFootnotesMasterRepository::save);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getDpvFootnotesId().toString())
                            )
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /dpv-footnotes-masters} : get all the dPVFootnotesMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dPVFootnotesMasters in body.
     */
    @GetMapping("/dpv-footnotes-masters")
    public Mono<List<DPVFootnotesMaster>> getAllDPVFootnotesMasters() {
        log.debug("REST request to get all DPVFootnotesMasters");
        return dPVFootnotesMasterRepository.findAll().collectList();
    }

    /**
     * {@code GET  /dpv-footnotes-masters} : get all the dPVFootnotesMasters as a stream.
     * @return the {@link Flux} of dPVFootnotesMasters.
     */
    @GetMapping(value = "/dpv-footnotes-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<DPVFootnotesMaster> getAllDPVFootnotesMastersAsStream() {
        log.debug("REST request to get all DPVFootnotesMasters as a stream");
        return dPVFootnotesMasterRepository.findAll();
    }

    /**
     * {@code GET  /dpv-footnotes-masters/:id} : get the "id" dPVFootnotesMaster.
     *
     * @param id the id of the dPVFootnotesMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dPVFootnotesMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dpv-footnotes-masters/{id}")
    public Mono<ResponseEntity<DPVFootnotesMaster>> getDPVFootnotesMaster(@PathVariable Long id) {
        log.debug("REST request to get DPVFootnotesMaster : {}", id);
        Mono<DPVFootnotesMaster> dPVFootnotesMaster = dPVFootnotesMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(dPVFootnotesMaster);
    }

    /**
     * {@code DELETE  /dpv-footnotes-masters/:id} : delete the "id" dPVFootnotesMaster.
     *
     * @param id the id of the dPVFootnotesMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dpv-footnotes-masters/{id}")
    public Mono<ResponseEntity<Void>> deleteDPVFootnotesMaster(@PathVariable Long id) {
        log.debug("REST request to delete DPVFootnotesMaster : {}", id);
        return dPVFootnotesMasterRepository
            .deleteById(id)
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
