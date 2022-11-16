package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.usps.UrbanizationMaster;
import com.sunknowledge.dme.rcm.repository.usps.UrbanizationMasterRepository;
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
 * REST controller for managing {@link UrbanizationMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class UrbanizationMasterResource {

    private final Logger log = LoggerFactory.getLogger(UrbanizationMasterResource.class);

    private static final String ENTITY_NAME = "utilityapisUrbanizationMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UrbanizationMasterRepository urbanizationMasterRepository;

    public UrbanizationMasterResource(UrbanizationMasterRepository urbanizationMasterRepository) {
        this.urbanizationMasterRepository = urbanizationMasterRepository;
    }

    /**
     * {@code POST  /urbanization-masters} : Create a new urbanizationMaster.
     *
     * @param urbanizationMaster the urbanizationMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new urbanizationMaster, or with status {@code 400 (Bad Request)} if the urbanizationMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/urbanization-masters")
    public Mono<ResponseEntity<UrbanizationMaster>> createUrbanizationMaster(@RequestBody UrbanizationMaster urbanizationMaster)
        throws URISyntaxException {
        log.debug("REST request to save UrbanizationMaster : {}", urbanizationMaster);
        if (urbanizationMaster.getUrbanizationId() != null) {
            throw new BadRequestAlertException("A new urbanizationMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return urbanizationMasterRepository
            .save(urbanizationMaster)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/urbanization-masters/" + result.getUrbanizationId()))
                        .headers(
                            HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getUrbanizationId().toString())
                        )
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /urbanization-masters/:urbanizationId} : Updates an existing urbanizationMaster.
     *
     * @param urbanizationId the id of the urbanizationMaster to save.
     * @param urbanizationMaster the urbanizationMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated urbanizationMaster,
     * or with status {@code 400 (Bad Request)} if the urbanizationMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the urbanizationMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/urbanization-masters/{urbanizationId}")
    public Mono<ResponseEntity<UrbanizationMaster>> updateUrbanizationMaster(
        @PathVariable(value = "urbanizationId", required = false) final Long urbanizationId,
        @RequestBody UrbanizationMaster urbanizationMaster
    ) throws URISyntaxException {
        log.debug("REST request to update UrbanizationMaster : {}, {}", urbanizationId, urbanizationMaster);
        if (urbanizationMaster.getUrbanizationId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(urbanizationId, urbanizationMaster.getUrbanizationId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return urbanizationMasterRepository
            .existsById(urbanizationId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return urbanizationMasterRepository
                    .save(urbanizationMaster)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(
                                    applicationName,
                                    false,
                                    ENTITY_NAME,
                                    result.getUrbanizationId().toString()
                                )
                            )
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /urbanization-masters/:urbanizationId} : Partial updates given fields of an existing urbanizationMaster, field will ignore if it is null
     *
     * @param urbanizationId the id of the urbanizationMaster to save.
     * @param urbanizationMaster the urbanizationMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated urbanizationMaster,
     * or with status {@code 400 (Bad Request)} if the urbanizationMaster is not valid,
     * or with status {@code 404 (Not Found)} if the urbanizationMaster is not found,
     * or with status {@code 500 (Internal Server Error)} if the urbanizationMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/urbanization-masters/{urbanizationId}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<UrbanizationMaster>> partialUpdateUrbanizationMaster(
        @PathVariable(value = "urbanizationId", required = false) final Long urbanizationId,
        @RequestBody UrbanizationMaster urbanizationMaster
    ) throws URISyntaxException {
        log.debug("REST request to partial update UrbanizationMaster partially : {}, {}", urbanizationId, urbanizationMaster);
        if (urbanizationMaster.getUrbanizationId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(urbanizationId, urbanizationMaster.getUrbanizationId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return urbanizationMasterRepository
            .existsById(urbanizationId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<UrbanizationMaster> result = urbanizationMasterRepository
                    .findById(urbanizationMaster.getUrbanizationId())
                    .map(existingUrbanizationMaster -> {
                        if (urbanizationMaster.getUrbanization() != null) {
                            existingUrbanizationMaster.setUrbanization(urbanizationMaster.getUrbanization());
                        }
                        if (urbanizationMaster.getAbbreviation() != null) {
                            existingUrbanizationMaster.setAbbreviation(urbanizationMaster.getAbbreviation());
                        }

                        return existingUrbanizationMaster;
                    })
                    .flatMap(urbanizationMasterRepository::save);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getUrbanizationId().toString())
                            )
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /urbanization-masters} : get all the urbanizationMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of urbanizationMasters in body.
     */
    @GetMapping("/urbanization-masters")
    public Mono<List<UrbanizationMaster>> getAllUrbanizationMasters() {
        log.debug("REST request to get all UrbanizationMasters");
        return urbanizationMasterRepository.findAll().collectList();
    }

    /**
     * {@code GET  /urbanization-masters} : get all the urbanizationMasters as a stream.
     * @return the {@link Flux} of urbanizationMasters.
     */
    @GetMapping(value = "/urbanization-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<UrbanizationMaster> getAllUrbanizationMastersAsStream() {
        log.debug("REST request to get all UrbanizationMasters as a stream");
        return urbanizationMasterRepository.findAll();
    }

    /**
     * {@code GET  /urbanization-masters/:id} : get the "id" urbanizationMaster.
     *
     * @param id the id of the urbanizationMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the urbanizationMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/urbanization-masters/{id}")
    public Mono<ResponseEntity<UrbanizationMaster>> getUrbanizationMaster(@PathVariable Long id) {
        log.debug("REST request to get UrbanizationMaster : {}", id);
        Mono<UrbanizationMaster> urbanizationMaster = urbanizationMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(urbanizationMaster);
    }

    /**
     * {@code DELETE  /urbanization-masters/:id} : delete the "id" urbanizationMaster.
     *
     * @param id the id of the urbanizationMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/urbanization-masters/{id}")
    public Mono<ResponseEntity<Void>> deleteUrbanizationMaster(@PathVariable Long id) {
        log.debug("REST request to delete UrbanizationMaster : {}", id);
        return urbanizationMasterRepository
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
