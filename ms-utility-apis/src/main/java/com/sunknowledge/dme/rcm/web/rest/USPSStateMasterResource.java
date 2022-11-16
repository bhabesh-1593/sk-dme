package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.usps.USPSStateMaster;
import com.sunknowledge.dme.rcm.repository.usps.USPSStateMasterRepository;
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
 * REST controller for managing {@link USPSStateMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class USPSStateMasterResource {

    private final Logger log = LoggerFactory.getLogger(USPSStateMasterResource.class);

    private static final String ENTITY_NAME = "utilityapisUspsStateMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final USPSStateMasterRepository uSPSStateMasterRepository;

    public USPSStateMasterResource(USPSStateMasterRepository uSPSStateMasterRepository) {
        this.uSPSStateMasterRepository = uSPSStateMasterRepository;
    }

    /**
     * {@code POST  /usps-state-masters} : Create a new uSPSStateMaster.
     *
     * @param uSPSStateMaster the uSPSStateMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new uSPSStateMaster, or with status {@code 400 (Bad Request)} if the uSPSStateMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/usps-state-masters")
    public Mono<ResponseEntity<USPSStateMaster>> createUSPSStateMaster(@RequestBody USPSStateMaster uSPSStateMaster)
        throws URISyntaxException {
        log.debug("REST request to save USPSStateMaster : {}", uSPSStateMaster);
        if (uSPSStateMaster.getStateId() != null) {
            throw new BadRequestAlertException("A new uSPSStateMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return uSPSStateMasterRepository
            .save(uSPSStateMaster)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/usps-state-masters/" + result.getStateId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getStateId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /usps-state-masters/:stateId} : Updates an existing uSPSStateMaster.
     *
     * @param stateId the id of the uSPSStateMaster to save.
     * @param uSPSStateMaster the uSPSStateMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated uSPSStateMaster,
     * or with status {@code 400 (Bad Request)} if the uSPSStateMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the uSPSStateMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/usps-state-masters/{stateId}")
    public Mono<ResponseEntity<USPSStateMaster>> updateUSPSStateMaster(
        @PathVariable(value = "stateId", required = false) final Long stateId,
        @RequestBody USPSStateMaster uSPSStateMaster
    ) throws URISyntaxException {
        log.debug("REST request to update USPSStateMaster : {}, {}", stateId, uSPSStateMaster);
        if (uSPSStateMaster.getStateId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(stateId, uSPSStateMaster.getStateId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return uSPSStateMasterRepository
            .existsById(stateId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return uSPSStateMasterRepository
                    .save(uSPSStateMaster)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getStateId().toString())
                            )
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /usps-state-masters/:stateId} : Partial updates given fields of an existing uSPSStateMaster, field will ignore if it is null
     *
     * @param stateId the id of the uSPSStateMaster to save.
     * @param uSPSStateMaster the uSPSStateMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated uSPSStateMaster,
     * or with status {@code 400 (Bad Request)} if the uSPSStateMaster is not valid,
     * or with status {@code 404 (Not Found)} if the uSPSStateMaster is not found,
     * or with status {@code 500 (Internal Server Error)} if the uSPSStateMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/usps-state-masters/{stateId}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<USPSStateMaster>> partialUpdateUSPSStateMaster(
        @PathVariable(value = "stateId", required = false) final Long stateId,
        @RequestBody USPSStateMaster uSPSStateMaster
    ) throws URISyntaxException {
        log.debug("REST request to partial update USPSStateMaster partially : {}, {}", stateId, uSPSStateMaster);
        if (uSPSStateMaster.getStateId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(stateId, uSPSStateMaster.getStateId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return uSPSStateMasterRepository
            .existsById(stateId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<USPSStateMaster> result = uSPSStateMasterRepository
                    .findById(uSPSStateMaster.getStateId())
                    .map(existingUSPSStateMaster -> {
                        if (uSPSStateMaster.getStateName() != null) {
                            existingUSPSStateMaster.setStateName(uSPSStateMaster.getStateName());
                        }
                        if (uSPSStateMaster.getPostalAbbriviation() != null) {
                            existingUSPSStateMaster.setPostalAbbriviation(uSPSStateMaster.getPostalAbbriviation());
                        }
                        if (uSPSStateMaster.getFipsCode() != null) {
                            existingUSPSStateMaster.setFipsCode(uSPSStateMaster.getFipsCode());
                        }

                        return existingUSPSStateMaster;
                    })
                    .flatMap(uSPSStateMasterRepository::save);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getStateId().toString()))
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /usps-state-masters} : get all the uSPSStateMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of uSPSStateMasters in body.
     */
    @GetMapping("/usps-state-masters")
    public Mono<List<USPSStateMaster>> getAllUSPSStateMasters() {
        log.debug("REST request to get all USPSStateMasters");
        return uSPSStateMasterRepository.findAll().collectList();
    }

    /**
     * {@code GET  /usps-state-masters} : get all the uSPSStateMasters as a stream.
     * @return the {@link Flux} of uSPSStateMasters.
     */
    @GetMapping(value = "/usps-state-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<USPSStateMaster> getAllUSPSStateMastersAsStream() {
        log.debug("REST request to get all USPSStateMasters as a stream");
        return uSPSStateMasterRepository.findAll();
    }

    /**
     * {@code GET  /usps-state-masters/:id} : get the "id" uSPSStateMaster.
     *
     * @param id the id of the uSPSStateMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the uSPSStateMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/usps-state-masters/{id}")
    public Mono<ResponseEntity<USPSStateMaster>> getUSPSStateMaster(@PathVariable Long id) {
        log.debug("REST request to get USPSStateMaster : {}", id);
        Mono<USPSStateMaster> uSPSStateMaster = uSPSStateMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(uSPSStateMaster);
    }

    /**
     * {@code DELETE  /usps-state-masters/:id} : delete the "id" uSPSStateMaster.
     *
     * @param id the id of the uSPSStateMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/usps-state-masters/{id}")
    public Mono<ResponseEntity<Void>> deleteUSPSStateMaster(@PathVariable Long id) {
        log.debug("REST request to delete USPSStateMaster : {}", id);
        return uSPSStateMasterRepository
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
