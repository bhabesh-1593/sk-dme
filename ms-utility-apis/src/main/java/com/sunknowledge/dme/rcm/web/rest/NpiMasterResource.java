package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.domain.nppes.NpiMaster;
import com.sunknowledge.dme.rcm.repository.nppes.NpiMasterRepository;
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
 * REST controller for managing {@link NpiMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class NpiMasterResource {

    private final Logger log = LoggerFactory.getLogger(NpiMasterResource.class);

    private static final String ENTITY_NAME = "utilityapisNpiMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NpiMasterRepository npiMasterRepository;

    public NpiMasterResource(NpiMasterRepository npiMasterRepository) {
        this.npiMasterRepository = npiMasterRepository;
    }

    /**
     * {@code POST  /npi-masters} : Create a new npiMaster.
     *
     * @param npiMaster the npiMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new npiMaster, or with status {@code 400 (Bad Request)} if the npiMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/npi-masters")
    public Mono<ResponseEntity<NpiMaster>> createNpiMaster(@RequestBody NpiMaster npiMaster) throws URISyntaxException {
        log.debug("REST request to save NpiMaster : {}", npiMaster);
        if (npiMaster.getNpiId() != null) {
            throw new BadRequestAlertException("A new npiMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return npiMasterRepository
            .save(npiMaster)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/npi-masters/" + result.getNpiId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getNpiId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /npi-masters/:npiId} : Updates an existing npiMaster.
     *
     * @param npiId the id of the npiMaster to save.
     * @param npiMaster the npiMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated npiMaster,
     * or with status {@code 400 (Bad Request)} if the npiMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the npiMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/npi-masters/{npiId}")
    public Mono<ResponseEntity<NpiMaster>> updateNpiMaster(
        @PathVariable(value = "npiId", required = false) final Long npiId,
        @RequestBody NpiMaster npiMaster
    ) throws URISyntaxException {
        log.debug("REST request to update NpiMaster : {}, {}", npiId, npiMaster);
        if (npiMaster.getNpiId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(npiId, npiMaster.getNpiId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return npiMasterRepository
            .existsById(npiId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return npiMasterRepository
                    .save(npiMaster)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getNpiId().toString()))
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /npi-masters/:npiId} : Partial updates given fields of an existing npiMaster, field will ignore if it is null
     *
     * @param npiId the id of the npiMaster to save.
     * @param npiMaster the npiMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated npiMaster,
     * or with status {@code 400 (Bad Request)} if the npiMaster is not valid,
     * or with status {@code 404 (Not Found)} if the npiMaster is not found,
     * or with status {@code 500 (Internal Server Error)} if the npiMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/npi-masters/{npiId}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<NpiMaster>> partialUpdateNpiMaster(
        @PathVariable(value = "npiId", required = false) final Long npiId,
        @RequestBody NpiMaster npiMaster
    ) throws URISyntaxException {
        log.debug("REST request to partial update NpiMaster partially : {}, {}", npiId, npiMaster);
        if (npiMaster.getNpiId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(npiId, npiMaster.getNpiId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return npiMasterRepository
            .existsById(npiId)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<NpiMaster> result = npiMasterRepository
                    .findById(npiMaster.getNpiId())
                    .map(existingNpiMaster -> {
                        if (npiMaster.getNpiNumber() != null) {
                            existingNpiMaster.setNpiNumber(npiMaster.getNpiNumber());
                        }
                        if (npiMaster.getEnumerationType() != null) {
                            existingNpiMaster.setEnumerationType(npiMaster.getEnumerationType());
                        }
                        if (npiMaster.getNpiName() != null) {
                            existingNpiMaster.setNpiName(npiMaster.getNpiName());
                        }
                        if (npiMaster.getAddress() != null) {
                            existingNpiMaster.setAddress(npiMaster.getAddress());
                        }
                        if (npiMaster.getPhone() != null) {
                            existingNpiMaster.setPhone(npiMaster.getPhone());
                        }

                        return existingNpiMaster;
                    })
                    .flatMap(npiMasterRepository::save);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getNpiId().toString()))
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /npi-masters} : get all the npiMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of npiMasters in body.
     */
    @GetMapping("/npi-masters")
    public Mono<List<NpiMaster>> getAllNpiMasters() {
        log.debug("REST request to get all NpiMasters");
        return npiMasterRepository.findAll().collectList();
    }

    /**
     * {@code GET  /npi-masters} : get all the npiMasters as a stream.
     * @return the {@link Flux} of npiMasters.
     */
    @GetMapping(value = "/npi-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<NpiMaster> getAllNpiMastersAsStream() {
        log.debug("REST request to get all NpiMasters as a stream");
        return npiMasterRepository.findAll();
    }

    /**
     * {@code GET  /npi-masters/:id} : get the "id" npiMaster.
     *
     * @param id the id of the npiMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the npiMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/npi-masters/{id}")
    public Mono<ResponseEntity<NpiMaster>> getNpiMaster(@PathVariable Long id) {
        log.debug("REST request to get NpiMaster : {}", id);
        Mono<NpiMaster> npiMaster = npiMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(npiMaster);
    }

    /**
     * {@code DELETE  /npi-masters/:id} : delete the "id" npiMaster.
     *
     * @param id the id of the npiMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/npi-masters/{id}")
    public Mono<ResponseEntity<Void>> deleteNpiMaster(@PathVariable Long id) {
        log.debug("REST request to delete NpiMaster : {}", id);
        return npiMasterRepository
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
