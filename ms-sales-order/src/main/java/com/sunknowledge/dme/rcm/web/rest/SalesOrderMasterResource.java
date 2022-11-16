package com.sunknowledge.dme.rcm.web.rest;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.SalesOrderMasterService;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderOutputDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing
 * {@link com.sunknowledge.dme.rcm.domain.SalesOrderMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SalesOrderMasterResource {

	private final Logger log = LoggerFactory.getLogger(SalesOrderMasterResource.class);

	private static final String ENTITY_NAME = "salesorderSalesOrderMaster";

	@Value("${jhipster.clientApp.name}")
	private String applicationName;

	@Autowired
	SalesOrderMasterService salesOrderMasterService;

//	private final SalesOrderMasterRepository salesOrderMasterRepository;

//	public SalesOrderMasterResource(SalesOrderMasterRepository salesOrderMasterRepository) {
//		this.salesOrderMasterRepository = salesOrderMasterRepository;
//	}

	/**
	 * {@code POST  /sales-order-masters} : Create a new salesOrderMaster.
	 *
	 * @param salesOrderMaster the salesOrderMaster to create.
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
	 *         body the new salesOrderMaster, or with status
	 *         {@code 400 (Bad Request)} if the salesOrderMaster has already an ID.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
//	@PostMapping("/sales-order-masters")
//	public Mono<ResponseEntity<SalesOrderMaster>> createSalesOrderMaster(
//			@Valid @RequestBody SalesOrderMaster salesOrderMaster) throws URISyntaxException {
//		log.debug("REST request to save SalesOrderMaster : {}", salesOrderMaster);
//		if (salesOrderMaster.getId() != null) {
//			throw new BadRequestAlertException("A new salesOrderMaster cannot already have an ID", ENTITY_NAME,
//					"idexists");
//		}
//		return salesOrderMasterRepository.save(salesOrderMaster).map(result -> {
//			try {
//				return ResponseEntity.created(new URI("/api/sales-order-masters/" + result.getId())).headers(HeaderUtil
//						.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//						.body(result);
//			} catch (URISyntaxException e) {
//				throw new RuntimeException(e);
//			}
//		});
//	}
//
//	/**
//	 * {@code PUT  /sales-order-masters/:id} : Updates an existing salesOrderMaster.
//	 *
//	 * @param id               the id of the salesOrderMaster to save.
//	 * @param salesOrderMaster the salesOrderMaster to update.
//	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
//	 *         the updated salesOrderMaster, or with status
//	 *         {@code 400 (Bad Request)} if the salesOrderMaster is not valid, or
//	 *         with status {@code 500 (Internal Server Error)} if the
//	 *         salesOrderMaster couldn't be updated.
//	 * @throws URISyntaxException if the Location URI syntax is incorrect.
//	 */
//	@PutMapping("/sales-order-masters/{id}")
//	public Mono<ResponseEntity<SalesOrderMaster>> updateSalesOrderMaster(
//			@PathVariable(value = "id", required = false) final Long id,
//			@Valid @RequestBody SalesOrderMaster salesOrderMaster) throws URISyntaxException {
//		log.debug("REST request to update SalesOrderMaster : {}, {}", id, salesOrderMaster);
//		if (salesOrderMaster.getId() == null) {
//			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//		}
//		if (!Objects.equals(id, salesOrderMaster.getId())) {
//			throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//		}
//
//		return salesOrderMasterRepository.existsById(id).flatMap(exists -> {
//			if (!exists) {
//				return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//			}
//
//			return salesOrderMasterRepository.save(salesOrderMaster)
//					.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
//					.map(result -> ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName,
//							false, ENTITY_NAME, result.getId().toString())).body(result));
//		});
//	}
//
//	/**
//	 * {@code PATCH  /sales-order-masters/:id} : Partial updates given fields of an
//	 * existing salesOrderMaster, field will ignore if it is null
//	 *
//	 * @param id               the id of the salesOrderMaster to save.
//	 * @param salesOrderMaster the salesOrderMaster to update.
//	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
//	 *         the updated salesOrderMaster, or with status
//	 *         {@code 400 (Bad Request)} if the salesOrderMaster is not valid, or
//	 *         with status {@code 404 (Not Found)} if the salesOrderMaster is not
//	 *         found, or with status {@code 500 (Internal Server Error)} if the
//	 *         salesOrderMaster couldn't be updated.
//	 * @throws URISyntaxException if the Location URI syntax is incorrect.
//	 */
//	@PatchMapping(value = "/sales-order-masters/{id}", consumes = { "application/json",
//			"application/merge-patch+json" })
//	public Mono<ResponseEntity<SalesOrderMaster>> partialUpdateSalesOrderMaster(
//			@PathVariable(value = "id", required = false) final Long id,
//			@NotNull @RequestBody SalesOrderMaster salesOrderMaster) throws URISyntaxException {
//		log.debug("REST request to partial update SalesOrderMaster partially : {}, {}", id, salesOrderMaster);
//		if (salesOrderMaster.getId() == null) {
//			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//		}
//		if (!Objects.equals(id, salesOrderMaster.getId())) {
//			throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//		}
//
//		return salesOrderMasterRepository.existsById(id).flatMap(exists -> {
//			if (!exists) {
//				return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
//			}
//
//			Mono<SalesOrderMaster> result = salesOrderMasterRepository.findById(salesOrderMaster.getId())
//					.map(existingSalesOrderMaster -> {
//						if (salesOrderMaster.getSalesOderId() != null) {
//							existingSalesOrderMaster.setSalesOderId(salesOrderMaster.getSalesOderId());
//						}
//						if (salesOrderMaster.getSalesOderNo() != null) {
//							existingSalesOrderMaster.setSalesOderNo(salesOrderMaster.getSalesOderNo());
//						}
//						if (salesOrderMaster.getPatientId() != null) {
//							existingSalesOrderMaster.setPatientId(salesOrderMaster.getPatientId());
//						}
//						if (salesOrderMaster.getPatientFirstName() != null) {
//							existingSalesOrderMaster.setPatientFirstName(salesOrderMaster.getPatientFirstName());
//						}
//						if (salesOrderMaster.getPatientMiddleName() != null) {
//							existingSalesOrderMaster.setPatientMiddleName(salesOrderMaster.getPatientMiddleName());
//						}
//						if (salesOrderMaster.getPatientLastName() != null) {
//							existingSalesOrderMaster.setPatientLastName(salesOrderMaster.getPatientLastName());
//						}
//						if (salesOrderMaster.getPatientAddressId() != null) {
//							existingSalesOrderMaster.setPatientAddressId(salesOrderMaster.getPatientAddressId());
//						}
//						if (salesOrderMaster.getPatientAddressLine1() != null) {
//							existingSalesOrderMaster.setPatientAddressLine1(salesOrderMaster.getPatientAddressLine1());
//						}
//						if (salesOrderMaster.getPatientAddressLine2() != null) {
//							existingSalesOrderMaster.setPatientAddressLine2(salesOrderMaster.getPatientAddressLine2());
//						}
//						if (salesOrderMaster.getCityName() != null) {
//							existingSalesOrderMaster.setCityName(salesOrderMaster.getCityName());
//						}
//						if (salesOrderMaster.getStateName() != null) {
//							existingSalesOrderMaster.setStateName(salesOrderMaster.getStateName());
//						}
//						if (salesOrderMaster.getZipCode() != null) {
//							existingSalesOrderMaster.setZipCode(salesOrderMaster.getZipCode());
//						}
//						if (salesOrderMaster.getPatientContactId() != null) {
//							existingSalesOrderMaster.setPatientContactId(salesOrderMaster.getPatientContactId());
//						}
//						if (salesOrderMaster.getPhone1() != null) {
//							existingSalesOrderMaster.setPhone1(salesOrderMaster.getPhone1());
//						}
//						if (salesOrderMaster.getPhone2() != null) {
//							existingSalesOrderMaster.setPhone2(salesOrderMaster.getPhone2());
//						}
//						if (salesOrderMaster.getPatientDob() != null) {
//							existingSalesOrderMaster.setPatientDob(salesOrderMaster.getPatientDob());
//						}
//						if (salesOrderMaster.getPatientHeight() != null) {
//							existingSalesOrderMaster.setPatientHeight(salesOrderMaster.getPatientHeight());
//						}
//						if (salesOrderMaster.getPatientWeight() != null) {
//							existingSalesOrderMaster.setPatientWeight(salesOrderMaster.getPatientWeight());
//						}
//						if (salesOrderMaster.getPatientSsn() != null) {
//							existingSalesOrderMaster.setPatientSsn(salesOrderMaster.getPatientSsn());
//						}
//						if (salesOrderMaster.getPatientGender() != null) {
//							existingSalesOrderMaster.setPatientGender(salesOrderMaster.getPatientGender());
//						}
//						if (salesOrderMaster.getPatientBranchId() != null) {
//							existingSalesOrderMaster.setPatientBranchId(salesOrderMaster.getPatientBranchId());
//						}
//						if (salesOrderMaster.getBranchName() != null) {
//							existingSalesOrderMaster.setBranchName(salesOrderMaster.getBranchName());
//						}
//						if (salesOrderMaster.getPatientDod() != null) {
//							existingSalesOrderMaster.setPatientDod(salesOrderMaster.getPatientDod());
//						}
//						if (salesOrderMaster.getHipaaOnFileStatus() != null) {
//							existingSalesOrderMaster.setHipaaOnFileStatus(salesOrderMaster.getHipaaOnFileStatus());
//						}
//						if (salesOrderMaster.getFacilityId() != null) {
//							existingSalesOrderMaster.setFacilityId(salesOrderMaster.getFacilityId());
//						}
//						if (salesOrderMaster.getFacilityName() != null) {
//							existingSalesOrderMaster.setFacilityName(salesOrderMaster.getFacilityName());
//						}
//						if (salesOrderMaster.getFacilityNPI() != null) {
//							existingSalesOrderMaster.setFacilityNPI(salesOrderMaster.getFacilityNPI());
//						}
//						if (salesOrderMaster.getDeliveryScheduleDatetime() != null) {
//							existingSalesOrderMaster
//									.setDeliveryScheduleDatetime(salesOrderMaster.getDeliveryScheduleDatetime());
//						}
//						if (salesOrderMaster.getDeliveryActualDatetime() != null) {
//							existingSalesOrderMaster
//									.setDeliveryActualDatetime(salesOrderMaster.getDeliveryActualDatetime());
//						}
//						if (salesOrderMaster.getDeliveryAddressLine1() != null) {
//							existingSalesOrderMaster
//									.setDeliveryAddressLine1(salesOrderMaster.getDeliveryAddressLine1());
//						}
//						if (salesOrderMaster.getDeliveryAddressLine2() != null) {
//							existingSalesOrderMaster
//									.setDeliveryAddressLine2(salesOrderMaster.getDeliveryAddressLine2());
//						}
//						if (salesOrderMaster.getDeliveryCityName() != null) {
//							existingSalesOrderMaster.setDeliveryCityName(salesOrderMaster.getDeliveryCityName());
//						}
//						if (salesOrderMaster.getDeliveryStateName() != null) {
//							existingSalesOrderMaster.setDeliveryStateName(salesOrderMaster.getDeliveryStateName());
//						}
//						if (salesOrderMaster.getDeliveryZipCode() != null) {
//							existingSalesOrderMaster.setDeliveryZipCode(salesOrderMaster.getDeliveryZipCode());
//						}
//						if (salesOrderMaster.getDeliveryPhoneNo1() != null) {
//							existingSalesOrderMaster.setDeliveryPhoneNo1(salesOrderMaster.getDeliveryPhoneNo1());
//						}
//						if (salesOrderMaster.getDeliveryPhoneNo2() != null) {
//							existingSalesOrderMaster.setDeliveryPhoneNo2(salesOrderMaster.getDeliveryPhoneNo2());
//						}
//						if (salesOrderMaster.getDeliveryBranchId() != null) {
//							existingSalesOrderMaster.setDeliveryBranchId(salesOrderMaster.getDeliveryBranchId());
//						}
//						if (salesOrderMaster.getDeliveryBranchName() != null) {
//							existingSalesOrderMaster.setDeliveryBranchName(salesOrderMaster.getDeliveryBranchName());
//						}
//						if (salesOrderMaster.getTaxZoneId() != null) {
//							existingSalesOrderMaster.setTaxZoneId(salesOrderMaster.getTaxZoneId());
//						}
//						if (salesOrderMaster.getTaxRate() != null) {
//							existingSalesOrderMaster.setTaxRate(salesOrderMaster.getTaxRate());
//						}
//						if (salesOrderMaster.getSalesOrderNote() != null) {
//							existingSalesOrderMaster.setSalesOrderNote(salesOrderMaster.getSalesOrderNote());
//						}
//						if (salesOrderMaster.getDeliveryNote() != null) {
//							existingSalesOrderMaster.setDeliveryNote(salesOrderMaster.getDeliveryNote());
//						}
//						if (salesOrderMaster.getDeliveryTechnician() != null) {
//							existingSalesOrderMaster.setDeliveryTechnician(salesOrderMaster.getDeliveryTechnician());
//						}
//						if (salesOrderMaster.getSignatureRequiredStatus() != null) {
//							existingSalesOrderMaster
//									.setSignatureRequiredStatus(salesOrderMaster.getSignatureRequiredStatus());
//						}
//						if (salesOrderMaster.getPodStatus() != null) {
//							existingSalesOrderMaster.setPodStatus(salesOrderMaster.getPodStatus());
//						}
//						if (salesOrderMaster.getPodStatusDateTime() != null) {
//							existingSalesOrderMaster.setPodStatusDateTime(salesOrderMaster.getPodStatusDateTime());
//						}
//						if (salesOrderMaster.getPodLastMessage() != null) {
//							existingSalesOrderMaster.setPodLastMessage(salesOrderMaster.getPodLastMessage());
//						}
//						if (salesOrderMaster.getPodMessageDateTime() != null) {
//							existingSalesOrderMaster.setPodMessageDateTime(salesOrderMaster.getPodMessageDateTime());
//						}
//						if (salesOrderMaster.getMutualHoldStatus() != null) {
//							existingSalesOrderMaster.setMutualHoldStatus(salesOrderMaster.getMutualHoldStatus());
//						}
//						if (salesOrderMaster.getHoldReasonId() != null) {
//							existingSalesOrderMaster.setHoldReasonId(salesOrderMaster.getHoldReasonId());
//						}
//						if (salesOrderMaster.getHoldStatus() != null) {
//							existingSalesOrderMaster.setHoldStatus(salesOrderMaster.getHoldStatus());
//						}
//						if (salesOrderMaster.getHoldReasonDescription() != null) {
//							existingSalesOrderMaster
//									.setHoldReasonDescription(salesOrderMaster.getHoldReasonDescription());
//						}
//						if (salesOrderMaster.getStopDate() != null) {
//							existingSalesOrderMaster.setStopDate(salesOrderMaster.getStopDate());
//						}
//						if (salesOrderMaster.getStopReasonId() != null) {
//							existingSalesOrderMaster.setStopReasonId(salesOrderMaster.getStopReasonId());
//						}
//						if (salesOrderMaster.getStopReasonDescription() != null) {
//							existingSalesOrderMaster
//									.setStopReasonDescription(salesOrderMaster.getStopReasonDescription());
//						}
//						if (salesOrderMaster.getInventoryLocationId() != null) {
//							existingSalesOrderMaster.setInventoryLocationId(salesOrderMaster.getInventoryLocationId());
//						}
//						if (salesOrderMaster.getOrderStatus() != null) {
//							existingSalesOrderMaster.setOrderStatus(salesOrderMaster.getOrderStatus());
//						}
//						if (salesOrderMaster.getOrderClassificationId() != null) {
//							existingSalesOrderMaster
//									.setOrderClassificationId(salesOrderMaster.getOrderClassificationId());
//						}
//						if (salesOrderMaster.getPosId() != null) {
//							existingSalesOrderMaster.setPosId(salesOrderMaster.getPosId());
//						}
//						if (salesOrderMaster.getPosName() != null) {
//							existingSalesOrderMaster.setPosName(salesOrderMaster.getPosName());
//						}
//						if (salesOrderMaster.getAdmissionDate() != null) {
//							existingSalesOrderMaster.setAdmissionDate(salesOrderMaster.getAdmissionDate());
//						}
//						if (salesOrderMaster.getDischargeDate() != null) {
//							existingSalesOrderMaster.setDischargeDate(salesOrderMaster.getDischargeDate());
//						}
//						if (salesOrderMaster.getDiscountPercentage() != null) {
//							existingSalesOrderMaster.setDiscountPercentage(salesOrderMaster.getDiscountPercentage());
//						}
//						if (salesOrderMaster.getPoNumber() != null) {
//							existingSalesOrderMaster.setPoNumber(salesOrderMaster.getPoNumber());
//						}
//						if (salesOrderMaster.getUserField1() != null) {
//							existingSalesOrderMaster.setUserField1(salesOrderMaster.getUserField1());
//						}
//						if (salesOrderMaster.getUserField2() != null) {
//							existingSalesOrderMaster.setUserField2(salesOrderMaster.getUserField2());
//						}
//						if (salesOrderMaster.getUserField3() != null) {
//							existingSalesOrderMaster.setUserField3(salesOrderMaster.getUserField3());
//						}
//						if (salesOrderMaster.getUserField4() != null) {
//							existingSalesOrderMaster.setUserField4(salesOrderMaster.getUserField4());
//						}
//						if (salesOrderMaster.getReference() != null) {
//							existingSalesOrderMaster.setReference(salesOrderMaster.getReference());
//						}
//						if (salesOrderMaster.getWipStatus() != null) {
//							existingSalesOrderMaster.setWipStatus(salesOrderMaster.getWipStatus());
//						}
//						if (salesOrderMaster.getWipDaysInState() != null) {
//							existingSalesOrderMaster.setWipDaysInState(salesOrderMaster.getWipDaysInState());
//						}
//						if (salesOrderMaster.getWipAssignedToId() != null) {
//							existingSalesOrderMaster.setWipAssignedToId(salesOrderMaster.getWipAssignedToId());
//						}
//						if (salesOrderMaster.getWipDateNeeded() != null) {
//							existingSalesOrderMaster.setWipDateNeeded(salesOrderMaster.getWipDateNeeded());
//						}
//						if (salesOrderMaster.getCompletedStatus() != null) {
//							existingSalesOrderMaster.setCompletedStatus(salesOrderMaster.getCompletedStatus());
//						}
//						if (salesOrderMaster.getStatus() != null) {
//							existingSalesOrderMaster.setStatus(salesOrderMaster.getStatus());
//						}
//						if (salesOrderMaster.getCreatedById() != null) {
//							existingSalesOrderMaster.setCreatedById(salesOrderMaster.getCreatedById());
//						}
//						if (salesOrderMaster.getCreatedByName() != null) {
//							existingSalesOrderMaster.setCreatedByName(salesOrderMaster.getCreatedByName());
//						}
//						if (salesOrderMaster.getCreatedDate() != null) {
//							existingSalesOrderMaster.setCreatedDate(salesOrderMaster.getCreatedDate());
//						}
//						if (salesOrderMaster.getConfirmationById() != null) {
//							existingSalesOrderMaster.setConfirmationById(salesOrderMaster.getConfirmationById());
//						}
//						if (salesOrderMaster.getConfirmationByName() != null) {
//							existingSalesOrderMaster.setConfirmationByName(salesOrderMaster.getConfirmationByName());
//						}
//						if (salesOrderMaster.getConfirmationDate() != null) {
//							existingSalesOrderMaster.setConfirmationDate(salesOrderMaster.getConfirmationDate());
//						}
//						if (salesOrderMaster.getUpdatedById() != null) {
//							existingSalesOrderMaster.setUpdatedById(salesOrderMaster.getUpdatedById());
//						}
//						if (salesOrderMaster.getUpdatedByName() != null) {
//							existingSalesOrderMaster.setUpdatedByName(salesOrderMaster.getUpdatedByName());
//						}
//						if (salesOrderMaster.getUpdatedDate() != null) {
//							existingSalesOrderMaster.setUpdatedDate(salesOrderMaster.getUpdatedDate());
//						}
//
//						return existingSalesOrderMaster;
//					}).flatMap(salesOrderMasterRepository::save);
//
//			return result.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
//					.map(res -> ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(applicationName, false,
//							ENTITY_NAME, res.getId().toString())).body(res));
//		});
//	}
//
//	/**
//	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters.
//	 *
//	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
//	 *         of salesOrderMasters in body.
//	 */
//	/*
//	 * @GetMapping("/sales-order-masters") public Mono<List<SalesOrderMaster>>
//	 * getAllSalesOrderMasters() {
//	 * log.debug("REST request to get all SalesOrderMasters"); return
//	 * salesOrderMasterRepository.findAll().collectList(); }
//	 */
//
//	/**
//	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters as a
//	 * stream.
//	 *
//	 * @return the {@link Flux} of salesOrderMasters.
//	 */
//	@GetMapping(value = "/sales-order-masters", produces = MediaType.APPLICATION_NDJSON_VALUE)
//	public Flux<SalesOrderMaster> getAllSalesOrderMastersAsStream() {
//		log.debug("REST request to get all SalesOrderMasters as a stream");
//		return salesOrderMasterRepository.findAll();
//	}
//
//	/**
//	 * {@code GET  /sales-order-masters/:id} : get the "id" salesOrderMaster.
//	 *
//	 * @param id the id of the salesOrderMaster to retrieve.
//	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
//	 *         the salesOrderMaster, or with status {@code 404 (Not Found)}.
//	 */
//	/*
//	 * @GetMapping("/sales-order-masters/{id}") public
//	 * Mono<ResponseEntity<SalesOrderMaster>> getSalesOrderMaster(@PathVariable Long
//	 * id) { log.debug("REST request to get SalesOrderMaster : {}", id);
//	 * Mono<SalesOrderMaster> salesOrderMaster =
//	 * salesOrderMasterRepository.findById(id); return
//	 * ResponseUtil.wrapOrNotFound(salesOrderMaster); }
//	 */
//
//	/**
//	 * {@code DELETE  /sales-order-masters/:id} : delete the "id" salesOrderMaster.
//	 *
//	 * @param id the id of the salesOrderMaster to delete.
//	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//	 */
//	@DeleteMapping("/sales-order-masters/{id}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public Mono<ResponseEntity<Void>> deleteSalesOrderMaster(@PathVariable Long id) {
//		log.debug("REST request to delete SalesOrderMaster : {}", id);
//		return salesOrderMasterRepository.deleteById(id)
//				.map(result -> ResponseEntity.noContent().headers(
//						HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
//						.build());
//	}
//
//	/**
//	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters.
//	 */
//	@GetMapping("/sales-order-masters")
//	public Flux<SalesOrderMaster> getAllSalesOrderMasters() {
//		log.debug("REST request to get all SalesOrderMasters");
//		return salesOrderMasterService.getsalesOrderDetails();
//	}


	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by
	 * branchName. SO Search By CreatedById Function Doc SerialNo:-1
	 */
	@PostMapping("/getSODetailswithCreatedById")
	public Flux<SalesOrderOutputDTO> getSODetailsByCreatedById(@RequestParam("createdById") Integer createdById) {
		log.debug("REST request to get all SalesOrderMasters By createdById : {}", createdById);
		return salesOrderMasterService.getSODetailsByCreatedById(createdById);
	}

	/**
	 * {@code POST  /getSODetailsByStatus} : Get SO Details By Status
	 */
//	@GetMapping("/getSODetailsByStatus/{status}/{fromDate}/{toDate}")
    @PostMapping("/getSODetailsByStatus")
	public Flux<SalesOrderSearchDetailsDTO> getSODetailsByStatus(@RequestParam("status") String status,
                                                                 @RequestParam("fromDate") String fromDate,
                                                                 @RequestParam("toDate") String toDate) {
		log.debug("REST request to get all SalesOrderMasters By status, fromDate, toDate : {}, {}, {}", status, fromDate, toDate);

        final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localFrmDate = LocalDate.parse(fromDate, formatter);
        LocalDate localToDate = LocalDate.parse(toDate, formatter);
//        ZonedDateTime zdtFromDate = localFrmDate.atStartOfDay(ZoneId.systemDefault());
//        ZonedDateTime zdtToDate = localToDate.atStartOfDay(ZoneId.systemDefault());
//        ZonedDateTime zdtFromDate = ZonedDateTime
//            .parse(fromDate, formatter);
//        ZonedDateTime zdtToDate = ZonedDateTime
//            .parse(toDate, formatter);
        return salesOrderMasterService.getSODetailsByStatus(status, localFrmDate, localToDate);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by
	 * branchName. SO Search By BranchName Function Doc SerialNo:-3
	 */
	@PostMapping("/getSODetailsByBranchandCreatedDate")
	public Flux<SalesOrderOutputDTO> getSODetailsByBranchandCreatedDate(@RequestParam("branchName") String branchName,
			@RequestParam("createdFromDate") String createdFromDate, @RequestParam("createdToDate") String createdToDate) {
		log.debug("REST request to get all SalesOrderMasters By BranchName : {}", branchName, createdFromDate,
				createdToDate);
		return salesOrderMasterService.getSODetailsByBranchandCreatedDate(branchName, dateconverter(createdFromDate), dateconverter(createdToDate));
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by
	 * facilityName. SO Search By FacilityName Function Doc SerialNo:-5
	 */
	@PostMapping("/getSODetailsByFacilityName")
	public Flux<SalesOrderOutputDTO> getSODetailsByFacilityName(@RequestParam("facilityName") String facilityName) {
		log.debug("REST request to get all SalesOrderMasters By facilityName : {}", facilityName);
		return salesOrderMasterService.getSODetailsByFacilityName(facilityName);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by Sales
	 * Order Number. SO Search Function Doc SerialNo:-6
	 */
	@PostMapping("/getSODetailsBySalesOrderNumber")
	public Flux<SalesOrderOutputDTO> getSODetailsBySalesOrderNumber(@RequestParam("salesOrderNumber") String salesOrderNumber) {
		log.debug("REST request to get all SalesOrderMasters By salesOrderNumber : {}", salesOrderNumber);
		return salesOrderMasterService.getSODetailsBySalesOrderNumber(salesOrderNumber);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by Patient
	 * Branch Name. SO Search Function Doc SerialNo:-7
	 */
	@PostMapping("/getSODetailsByBranchName")
	public Flux<SalesOrderOutputDTO> getSODetailsByPatientBranchName(@RequestParam("branchname") String branchname) {
		log.debug("REST request to get all SalesOrderMasters By branchname : {}", branchname);
		return salesOrderMasterService.getSODetailsByPatientBranchName(branchname);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by Patient
	 * Branch Name. SO Search Function Doc SerialNo:-8
	 */
	@PostMapping("/getSODetailsByPatientName")
	public Flux<SalesOrderOutputDTO> getSODetailsByPatientName(@RequestParam("patientName") String patientName) {
		log.debug("REST request to get all SalesOrderMasters By branchname : {}", patientName);
		return salesOrderMasterService.getSODetailsByPatientName(patientName);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by
	 * patientId.
	 */
	@PostMapping("/getSODetailsByPatientId")
	public Flux<SalesOrderMaster> getSODetailsByPatientId(@RequestParam("patientId") Long patientId) {
		log.debug("REST request to get all SalesOrderMasters By patientId : {}", patientId);
		return salesOrderMasterService.getSODetailsByPatientId(patientId);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by
	 * confirmation By Id. SO Search Function Doc SerialNo:-11
	 */
	@PostMapping("/getSODetailsByConfirmationId")
	public Flux<SalesOrderOutputDTO> getSODetailsByConfirmedById(@RequestParam("confirmationbyid") Integer confirmationbyid) {
		log.debug("REST request to get all SalesOrderMasters By patientId : {}", confirmationbyid);
		return salesOrderMasterService.getSODetailsByConfirmedById(confirmationbyid);
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by
	 * confirmation Details. SO Search Function Doc SerialNo:-12
	 */
	@PostMapping("/getSODetailsByConfirmationDetails")
	public Flux<SalesOrderOutputDTO> getSODetailsByConfirmationDetails(@RequestParam("confirmationbyName") String confirmationbyName,
			@RequestParam("status") String status, @RequestParam("createdFromDate") String createdFromDate,
			@RequestParam("createdToDate") String createdToDate) {
		log.debug("REST request to get all SalesOrderMasters By Confirmation Details : {}", confirmationbyName, status,
				createdFromDate, createdToDate);
		return salesOrderMasterService.getSODetailsByConfirmationDetails(confirmationbyName, status, dateconverter(createdFromDate),
				dateconverter(createdToDate));
	}

	/**
	 * {@code GET  /sales-order-masters} : get all the salesOrderMasters by creation
	 * Details. SO Search Function Doc SerialNo:-13
	 */
	@PostMapping("/getSODetailsByCreationDetails")
	public Flux<SalesOrderOutputDTO> getSODetailsByCreationDetails(@RequestParam("createdbyName") String createdbyName,
			@RequestParam("status") String status, @RequestParam("createdFromDate") String createdFromDate,
			@RequestParam("createdToDate") String createdToDate) {
		log.debug("REST request to get all SalesOrderMasters By createdId : {}", createdbyName, status, createdFromDate,
				createdToDate);
		return salesOrderMasterService.getSODetailsByCreationDetails(createdbyName, status, dateconverter(createdFromDate),
				dateconverter(createdToDate));
	}

	/**
	 * {@code GET  /sales-order-masters/:salesOderNo} : get the "SOInfo"
	 * salesOrderMaster.
	 */
	@PostMapping("/getSODetailsBySOInfo")
	public Flux<SalesOrderOutputDTO> getSODetailsBySOInfo(@RequestParam("salesOderNo") String salesOderNo,
			@RequestParam("deliveryScheduleDatetime") String deliveryScheduleDatetime, @RequestParam("deliveryActualDatetime") String deliveryActualDatetime,
			@RequestParam("createdDate") String createdDate) {
		log.debug("REST request to get SalesOrderMaster By SOInfo : {}", salesOderNo, deliveryScheduleDatetime,
				deliveryActualDatetime, createdDate);
		Flux<SalesOrderOutputDTO> salesOrderMaster = salesOrderMasterService.getSODetailsBySOInfo(salesOderNo,
				dateconverter(deliveryScheduleDatetime), dateconverter(deliveryActualDatetime), dateconverter(createdDate));
		return salesOrderMaster;
	}

    /**
     * {@code POST  /getSODetailsWithCombinedInformation} : Get SO Details With Combined Information
     */
    @PostMapping("/getSODetailsWithCombinedInformation")
    public Flux<SalesOrderSearchDetailsDTO> getSODetailsWithCombinedInformation(@RequestParam("patientName") String patientName,
                                                                 @RequestParam("salesOderNo") String salesOderNo,
                                                                 @RequestParam("patientDOB") String patientDOB,
                                                                 @RequestParam("startDate") String startDate,
                                                                 @RequestParam("endDate") String endDate,
                                                                 @RequestParam("status") String status,
                                                                 @RequestParam("branchName") String branchName,
                                                                 @RequestParam("primaryInsurerName") String primaryInsurerName,
                                                                 @RequestParam("patientAddress1") String patientAddress1,
                                                                 @RequestParam("facilityName") String facilityName) {
        log.debug("REST request to Get SO Details With Combined Information");

        final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate patientDOBDt = LocalDate.parse(patientDOB, formatter);
        LocalDate startDateDt = LocalDate.parse(startDate, formatter);
        LocalDate endDateDt = LocalDate.parse(endDate, formatter);

        return salesOrderMasterService.getSODetailsWithCombinedInformation(patientName, salesOderNo, patientDOBDt,
            startDateDt, endDateDt, status, branchName, primaryInsurerName, patientAddress1, facilityName);
    }

	public LocalDate dateconverter(String inputDate) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate outputDate = LocalDate.parse(inputDate, formatter);
		return outputDate;
	}

}
