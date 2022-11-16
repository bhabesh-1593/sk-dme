package com.sunknowledge.dme.rcm.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.repository.SalesOrderMasterRepository;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderOutputDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;

import reactor.core.publisher.Flux;

@Service
public class SalesOrderMasterServiceImpl implements SalesOrderMasterService{

	@Autowired
	SalesOrderMasterRepository salesOrderMasterRepository;

	@Override
	public Flux<SalesOrderMaster> getsalesOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	// SO Search By CreatedById Function Doc SerialNo:-1
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByCreatedById(Integer createdById) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findByCreatedById(createdById);
	}

	// SO Search By status Function Doc SerialNo:-2
	@Override
	public Flux<SalesOrderSearchDetailsDTO> getSODetailsByStatus(String status,
                                                                 LocalDate fromDate,
                                                                 LocalDate toDate) {
        System.out.println("status="+status);
        System.out.println("fromDate="+fromDate);
        System.out.println("toDate="+toDate);
        Flux<SalesOrderSearchDetailsDTO> list = salesOrderMasterRepository.findSODetailsByStatus(status, fromDate, toDate);
        System.out.println("list="+list);
        return list;
    }

	// SO Search By BranchName Function Doc SerialNo:-3
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByBranchandCreatedDate(String branchName, LocalDate createdFromDate,
			LocalDate createdToDate) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findByBranchandCreatedDate(branchName, createdFromDate, createdToDate);
	}

	// SO Search By FacilityName Function Doc SerialNo:-5
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByFacilityName(String facilityName) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findByFacilityName(facilityName);
	}

	// SO Search By SalesOrderNumber Function Doc SerialNo:-6
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsBySalesOrderNumber(String salesOrderNumber) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.getSODetailsBySalesOrderNumber(salesOrderNumber);
	}

	// SO Search By Branch Name Function Doc SerialNo:-7
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByPatientBranchName(String patientName) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.getSODetailsByPatientBranchName(patientName);
	}

	// SO Search By Patient Name Function Doc SerialNo:-8
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByPatientName(String patientName) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.getSODetailsByPatientName(patientName);
	}

	// SO Search By Patient Id Function Doc SerialNo:-9
	@Override
	public Flux<SalesOrderMaster> getSODetailsByPatientId(Long patientId) {
        return salesOrderMasterRepository.findByPatientId(patientId);
	}

	// SO Search By Confirmed Id Function Doc SerialNo:-11
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByConfirmedById(Integer confirmationbyid) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findByConfirmedById(confirmationbyid);
	}

	// SO Search By Confirmation Details Function Doc SerialNo:-12
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByConfirmationDetails(String confirmationByName, String status,
			LocalDate confirmationFromDate, LocalDate confirmationToDate) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findByByConfirmationDetails(confirmationByName, status, confirmationFromDate, confirmationToDate);
	}

	// SO Search By Creation Details Function Doc SerialNo:-13
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsByCreationDetails(String createdByName, String status, LocalDate createdFromDate,
			LocalDate createdToDate) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findByCreationDetails(createdByName, status, createdFromDate, createdToDate);
	}

	// SO Search By Sales Order Info Function Doc SerialNo:-14
	@Override
	public Flux<SalesOrderOutputDTO> getSODetailsBySOInfo(String salesOderNo, LocalDate deliveryScheduleDatetime,
			LocalDate deliveryActualDatetime, LocalDate createdDate) {
		// TODO Auto-generated method stub
		return salesOrderMasterRepository.findBySOInfo(salesOderNo, deliveryScheduleDatetime, deliveryActualDatetime, createdDate);
	}

    @Override
    public Flux<SalesOrderSearchDetailsDTO> getSODetailsWithCombinedInformation(String patientName, String salesOderNo,
                                                                                LocalDate patientDOBDt, LocalDate startDateDt,
                                                                                LocalDate endDateDt, String status, String branchName,
                                                                                String primaryInsurerName, String patientAddress1, String facilityName) {
        System.out.println("salesOderNo="+salesOderNo);
        Flux<SalesOrderSearchDetailsDTO> list = salesOrderMasterRepository.findSODetailsWithCombinedInformation(patientName, salesOderNo, patientDOBDt, startDateDt, endDateDt, status, branchName, primaryInsurerName, patientAddress1, facilityName);
        System.out.println("list="+list);
        return list;
    }
}
