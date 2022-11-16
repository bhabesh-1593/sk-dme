package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import com.sunknowledge.dme.rcm.repository.usps.DPVConfirmationMasterRepository;
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
 * REST controller for managing {@link DPVConfirmationMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class DPVConfirmationMasterResource {

    private final Logger log = LoggerFactory.getLogger(DPVConfirmationMasterResource.class);

    private static final String ENTITY_NAME = "utilityapisDpvConfirmationMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DPVConfirmationMasterRepository dPVConfirmationMasterRepository;

    public DPVConfirmationMasterResource(DPVConfirmationMasterRepository dPVConfirmationMasterRepository) {
        this.dPVConfirmationMasterRepository = dPVConfirmationMasterRepository;
    }

    /**
     * {@code POST  /dpv-confirmation-masters} : Create a new dPVConfirmationMaster.
     *
     * @param dPVConfirmationMaster the dPVConfirmationMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dPVConfirmationMaster, or with status {@code 400 (Bad Request)} if the dPVConfirmationMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dpv-confirmation-masters")
    public Mono<ResponseEntity<DPVConfirmationMaster>> createDPVConfirmationMaster(
        @RequestBody DPVConfirmationMaster dPVConfirmationMaster
    ) throws URISyntaxException {
        log.debug("REST request to save DPVConfirmationMaster : {}", dPVConfirmationMaster);
        if (dPVConfirmationMaster.getDpvConfirmationId() != null) {
            throw new BadRequestAlertException("A new dPVConfirmationMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return dPVConfirmationMasterRepository
            .save(dPVConfirmationMaster)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/dpv-confirmation-masters/" + result.getDpvConfirmationId()))
                        .headers(
                            HeaderUtil.createEntityCreationAlert(
                                applicationName,
                                false,
                                ENTITY_NAME,
                                result.getDpvConfirmationId().toString()
                            )
                        )
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /dpv-confirmation-masters/:dpvConfirmationId} : Updates an existing dPVConfirmationMaster.
     *
     * @param dpvConfirmationId the id of the dPVConfirmationMaster to save.
     * @param dPVConfirmationMaster the dPVConfirmationMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dPVConfirmationMaster,
     * or with status {@code 400 (Bad Request)} if the dPVConfirmationMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dPVConfirmationMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dpv-confirmation-masters/{dpvConfirmationId}")
    public Mono<ResponseEntity<DPVConfirmationMaster>> updateDPVConfirmationMaster(
        @PathVariable(value = "dpvConfirmationId", required = false) final Long dpvConfirmationId,
        @RequestBody DPVConfirmationMaster dPVConfirmationMaster
    ) throws URISyntaxException {
        log.debug("REST request to update DPVConfirmationMaster : {}, {}", dpvConfirmationId, dPVConfirmationMaster);
        if (dPVConfirmationMaster.getDpvConfirmationId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(dpvConfirmationId, dPVConfirmationMaster.getDpvConfirmationId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return dPVConfirmationMasterRepository
            .existsById(dpvConfirmationId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return dPVConfirmationMasterRepository
                    .save(dPVConfirmationMaster)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(
                                    applicationName,
                                    false,
                                    ENTITY_NAME,
                                    result.getDpvConfirmationId().toString()
                                )
                            )
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /dpv-confirmation-masters/:dpvConfirmationId} : Partial updates given fields of an existing dPVConfirmationMaster, field will ignore if it is null
     *
     * @param dpvConfirmationId the id of the dPVConfirmationMaster to save.
     * @param dPVConfirmationMaster the dPVConfirmationMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dPVConfirmationMaster,
     * or with status {@code 400 (Bad Request)} if the dPVConfirmationMaster is not valid,
     * or with status {@code 404 (Not Found)} if the dPVConfirmationMaster is not found,
     * or with status {@code 500 (Internal Server Error)} if the dPVConfirmationMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(
        value = "/dpv-confirmation-masters/{dpvConfirmationId}",
        consumes = { "application/json", "application/merge-patch+json" }
    )
    public Mono<ResponseEntity<DPVConfirmationMaster>> partialUpdateDPVConfirmationMaster(
        @PathVariable(value = "dpvConfirmationId", required = false) final Long dpvConfirmationId,
        @RequestBody DPVConfirmationMaster dPVConfirmationMaster
    ) throws URISyntaxException {
        log.debug("REST request to partial update DPVConfirmationMaster partially : {}, {}", dpvConfirmationId, dPVConfirmationMaster);
        if (dPVConfirmationMaster.getDpvConfirmationId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(dpvConfirmationId, dPVConfirmationMaster.getDpvConfirmationId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return dPVConfirmationMasterRepository
            .existsById(dpvConfirmationId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<DPVConfirmationMaster> result = dPVConfirmationMasterRepository
                    .findById(dPVConfirmationMaster.getDpvConfirmationId())
                    .map(existingDPVConfirmationMaster -> {
                        if (dPVConfirmationMaster.getEnumerations() != null) {
                            existingDPVConfirmationMaster.setEnumerations(dPVConfirmationMaster.getEnumerations());
                        }
                        if (dPVConfirmationMaster.getDefinition() != null) {
                            existingDPVConfirmationMaster.setDefinition(dPVConfirmationMaster.getDefinition());
                        }

                        return existingDPVConfirmationMaster;
                    })
                    .flatMap(dPVConfirmationMasterRepository::save);

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
                                    res.getDpvConfirmationId().toString()
                                )
                            )
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /dpv-confirmation-masters} : get all the dPVConfirmationMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dPVConfirmationMasters in body.
     */
    @GetMapping("/dpv-confirmation-masters")
    public Mono<List<DPVConfirmationMaster>> getAllDPVConfirmationMasters() {
        log.debug("REST request to get all DPVConfirmationMasters");
        return dPVConfirmationMasterRepository.findAll().collectList();
    }

    /**
     * {@code GET  /dpv-confirmation-masters} : get all the dPVConfirmationMasters as a stream.
     * @return the {@link Flux} of dPVConfirmationMasters.
     */
    @GetMapping(value = "/dpv-confirmation-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<DPVConfirmationMaster> getAllDPVConfirmationMastersAsStream() {
        log.debug("REST request to get all DPVConfirmationMasters as a stream");
        return dPVConfirmationMasterRepository.findAll();
    }

    /**
     * {@code GET  /dpv-confirmation-masters/:id} : get the "id" dPVConfirmationMaster.
     *
     * @param id the id of the dPVConfirmationMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dPVConfirmationMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dpv-confirmation-masters/{id}")
    public Mono<ResponseEntity<DPVConfirmationMaster>> getDPVConfirmationMaster(@PathVariable Long id) {
        log.debug("REST request to get DPVConfirmationMaster : {}", id);
        Mono<DPVConfirmationMaster> dPVConfirmationMaster = dPVConfirmationMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(dPVConfirmationMaster);
    }

    /**
     * {@code DELETE  /dpv-confirmation-masters/:id} : delete the "id" dPVConfirmationMaster.
     *
     * @param id the id of the dPVConfirmationMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dpv-confirmation-masters/{id}")
    public Mono<ResponseEntity<Void>> deleteDPVConfirmationMaster(@PathVariable Long id) {
        log.debug("REST request to delete DPVConfirmationMaster : {}", id);
        return dPVConfirmationMasterRepository
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
