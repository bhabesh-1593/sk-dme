package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.usps.FootnoteMaster;
import com.sunknowledge.dme.rcm.repository.usps.FootnoteMasterRepository;
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
 * REST controller for managing {@link FootnoteMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class FootnoteMasterResource {

    private final Logger log = LoggerFactory.getLogger(FootnoteMasterResource.class);

    private static final String ENTITY_NAME = "utilityapisFootnoteMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FootnoteMasterRepository footnoteMasterRepository;

    public FootnoteMasterResource(FootnoteMasterRepository footnoteMasterRepository) {
        this.footnoteMasterRepository = footnoteMasterRepository;
    }

    /**
     * {@code POST  /footnote-masters} : Create a new footnoteMaster.
     *
     * @param footnoteMaster the footnoteMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new footnoteMaster, or with status {@code 400 (Bad Request)} if the footnoteMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/footnote-masters")
    public Mono<ResponseEntity<FootnoteMaster>> createFootnoteMaster(@RequestBody FootnoteMaster footnoteMaster) throws URISyntaxException {
        log.debug("REST request to save FootnoteMaster : {}", footnoteMaster);
        if (footnoteMaster.getFootnotesId() != null) {
            throw new BadRequestAlertException("A new footnoteMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return footnoteMasterRepository
            .save(footnoteMaster)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/footnote-masters/" + result.getFootnotesId()))
                        .headers(
                            HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getFootnotesId().toString())
                        )
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /footnote-masters/:footnotesId} : Updates an existing footnoteMaster.
     *
     * @param footnotesId the id of the footnoteMaster to save.
     * @param footnoteMaster the footnoteMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated footnoteMaster,
     * or with status {@code 400 (Bad Request)} if the footnoteMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the footnoteMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/footnote-masters/{footnotesId}")
    public Mono<ResponseEntity<FootnoteMaster>> updateFootnoteMaster(
        @PathVariable(value = "footnotesId", required = false) final Long footnotesId,
        @RequestBody FootnoteMaster footnoteMaster
    ) throws URISyntaxException {
        log.debug("REST request to update FootnoteMaster : {}, {}", footnotesId, footnoteMaster);
        if (footnoteMaster.getFootnotesId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(footnotesId, footnoteMaster.getFootnotesId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return footnoteMasterRepository
            .existsById(footnotesId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return footnoteMasterRepository
                    .save(footnoteMaster)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getFootnotesId().toString())
                            )
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /footnote-masters/:footnotesId} : Partial updates given fields of an existing footnoteMaster, field will ignore if it is null
     *
     * @param footnotesId the id of the footnoteMaster to save.
     * @param footnoteMaster the footnoteMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated footnoteMaster,
     * or with status {@code 400 (Bad Request)} if the footnoteMaster is not valid,
     * or with status {@code 404 (Not Found)} if the footnoteMaster is not found,
     * or with status {@code 500 (Internal Server Error)} if the footnoteMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/footnote-masters/{footnotesId}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<FootnoteMaster>> partialUpdateFootnoteMaster(
        @PathVariable(value = "footnotesId", required = false) final Long footnotesId,
        @RequestBody FootnoteMaster footnoteMaster
    ) throws URISyntaxException {
        log.debug("REST request to partial update FootnoteMaster partially : {}, {}", footnotesId, footnoteMaster);
        if (footnoteMaster.getFootnotesId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(footnotesId, footnoteMaster.getFootnotesId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return footnoteMasterRepository
            .existsById(footnotesId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<FootnoteMaster> result = footnoteMasterRepository
                    .findById(footnoteMaster.getFootnotesId())
                    .map(existingFootnoteMaster -> {
                        if (footnoteMaster.getEnumerations() != null) {
                            existingFootnoteMaster.setEnumerations(footnoteMaster.getEnumerations());
                        }
                        if (footnoteMaster.getDefinition() != null) {
                            existingFootnoteMaster.setDefinition(footnoteMaster.getDefinition());
                        }

                        return existingFootnoteMaster;
                    })
                    .flatMap(footnoteMasterRepository::save);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(
                                HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getFootnotesId().toString())
                            )
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /footnote-masters} : get all the footnoteMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of footnoteMasters in body.
     */
    @GetMapping("/footnote-masters")
    public Mono<List<FootnoteMaster>> getAllFootnoteMasters() {
        log.debug("REST request to get all FootnoteMasters");
        return footnoteMasterRepository.findAll().collectList();
    }

    /**
     * {@code GET  /footnote-masters} : get all the footnoteMasters as a stream.
     * @return the {@link Flux} of footnoteMasters.
     */
    @GetMapping(value = "/footnote-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<FootnoteMaster> getAllFootnoteMastersAsStream() {
        log.debug("REST request to get all FootnoteMasters as a stream");
        return footnoteMasterRepository.findAll();
    }

    /**
     * {@code GET  /footnote-masters/:id} : get the "id" footnoteMaster.
     *
     * @param id the id of the footnoteMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the footnoteMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/footnote-masters/{id}")
    public Mono<ResponseEntity<FootnoteMaster>> getFootnoteMaster(@PathVariable Long id) {
        log.debug("REST request to get FootnoteMaster : {}", id);
        Mono<FootnoteMaster> footnoteMaster = footnoteMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(footnoteMaster);
    }

    /**
     * {@code DELETE  /footnote-masters/:id} : delete the "id" footnoteMaster.
     *
     * @param id the id of the footnoteMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/footnote-masters/{id}")
    public Mono<ResponseEntity<Void>> deleteFootnoteMaster(@PathVariable Long id) {
        log.debug("REST request to delete FootnoteMaster : {}", id);
        return footnoteMasterRepository
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
