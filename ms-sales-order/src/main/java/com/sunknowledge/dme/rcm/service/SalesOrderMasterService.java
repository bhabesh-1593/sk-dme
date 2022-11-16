package com.sunknowledge.dme.rcm.service;

import java.time.LocalDate;

import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderOutputDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;

import reactor.core.publisher.Flux;

public interface SalesOrderMasterService {

	Flux<SalesOrderMaster> getsalesOrderDetails();

	// SO Search By CreatedById Function Doc SerialNo:-1
	Flux<SalesOrderOutputDTO> getSODetailsByCreatedById(Integer createdById);

	// SO Search By CreatedById Function Doc SerialNo:-2
	Flux<SalesOrderSearchDetailsDTO> getSODetailsByStatus(String status, LocalDate fromDate, LocalDate toDate);

	// SO Search By Branch details Function Doc SerialNo:-3
	Flux<SalesOrderOutputDTO> getSODetailsByBranchandCreatedDate(String branchName, LocalDate createdFromDate,
			LocalDate createdToDate);

	// SO Search By Facility details Function Doc SerialNo:-5
	Flux<SalesOrderOutputDTO> getSODetailsByFacilityName(String facilityName);

	// SO Search By Sales Order Number Function Doc SerialNo:-6
	Flux<SalesOrderOutputDTO> getSODetailsBySalesOrderNumber(String salesOrderNumber);

	// SO Search By Patient Branch Name Function Doc SerialNo:-7
	Flux<SalesOrderOutputDTO> getSODetailsByPatientBranchName(String branchname);

	// SO Search By Patient Name Function Doc SerialNo:-8
	Flux<SalesOrderOutputDTO> getSODetailsByPatientName(String patientName);

	// SO Search By Patient Id Function Doc SerialNo:-9
	Flux<SalesOrderMaster> getSODetailsByPatientId(Long patientId);

	// SO Search By Confirmation Id Function Doc SerialNo:-11
	Flux<SalesOrderOutputDTO> getSODetailsByConfirmedById(Integer confirmationbyid);

	// SO Search By Confirmation Id Function Doc SerialNo:-12
	Flux<SalesOrderOutputDTO> getSODetailsByConfirmationDetails(String confirmationByName, String status,
			LocalDate confirmationFromDate, LocalDate confirmationToDate);

	// SO Search By Confirmation Id Function Doc SerialNo:-13
	Flux<SalesOrderOutputDTO> getSODetailsByCreationDetails(String confirmationByName, String status,
			LocalDate confirmationFromDate, LocalDate confirmationToDate);

	// SO Search By Confirmation Id Function Doc SerialNo:-13
	Flux<SalesOrderOutputDTO> getSODetailsBySOInfo(String salesOderNo, LocalDate deliveryScheduleDatetime,
			LocalDate deliveryActualDatetime, LocalDate createdDate);

	Flux<SalesOrderSearchDetailsDTO> getSODetailsWithCombinedInformation(String patientName, String salesOderNo,
			LocalDate patientDOBDt, LocalDate startDateDt, LocalDate endDateDt, String status, String branchName,
			String primaryInsurerName, String patientAddress1, String facilityName);
}
