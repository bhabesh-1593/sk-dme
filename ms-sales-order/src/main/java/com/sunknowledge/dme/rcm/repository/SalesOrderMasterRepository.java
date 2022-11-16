package com.sunknowledge.dme.rcm.repository;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderOutputDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data SQL reactive repository for the SalesOrderMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalesOrderMasterRepository extends ReactiveCrudRepository<SalesOrderMaster, Long>, SalesOrderMasterRepositoryInternal {
    @Override
    <S extends SalesOrderMaster> Mono<S> save(S entity);

//    @Override
//    Flux<SalesOrderMaster> findAll();
//
//    @Override
//    Mono<SalesOrderMaster> findById(Long id);
//
//    @Override
//    Mono<Void> deleteById(Long id);

	// SO Search By CreatedById Function Doc Sl:-1
	@Query(value="select * from so.so_by_created_userid (:createdById) as \r\n"
			+ "(sid bigint,sno character varying,p_first_name character varying, p_middle_name character varying,p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, p_address_line2 character varying, Status character varying, o_status character varying,c_date timestamp without time zone,c_by_id bigint,c_by_name character varying)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> findByCreatedById(@Param("createdById") Integer createdById);

    @Query(value = "select * from so.so_by_status (:status, :fromDate, :toDate) as " +
        "(sid bigint,sno character varying,p_first_name character varying, p_middle_name character varying," +
        "p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, " +
        "p_address_line2 character varying, Status character varying, o_status character varying," +
        "c_date timestamp without time zone,c_by_id bigint,c_by_name character varying)\n")
    Flux<SalesOrderSearchDetailsDTO> findSODetailsByStatus(@Param("status") String status, @Param("fromDate") LocalDate fromDate,
                                                           @Param("toDate") LocalDate toDate);

	// SO Search By Branch and CreatedDate Function Doc SerialNo:-3
	@Query(value = "select * from so.so_by_branch_name (:branchName, :fromDate, :toDate) as \r\n"
			+ "(sid bigint,sno character varying,p_first_name character varying, p_middle_name character varying,p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, p_address_line2 character varying, Status character varying, o_status character varying,c_date timestamp without time zone,c_by_id bigint,c_by_name character varying, p_branch_name character varying)\r\n")
	Flux<SalesOrderOutputDTO> findByBranchandCreatedDate(@Param("branchName") String branchName,
			@Param("fromDate") LocalDate createdFromDate, @Param("toDate") LocalDate createdToDate);

	// SO Search By facilityName Function Doc SerialNo:-5
	@Query(value = "select * from so.so_patient_Facility_lookup(:facilityName) as "
			+ "(fid bigint,fname character varying, f_npi character varying)\n")
	Flux<SalesOrderOutputDTO> findByFacilityName(@Param("facilityName") String facilityName);

	// SO Search By salesOrderNumber Function Doc SerialNo:-6
	@Query(value = "select * from so.so_patient_SOID_lookup(:salesOrderNumber) as\r\n"
			+ "(sid bigint,sno character varying, p_first_name character varying, p_middle_name character varying,p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, p_address_line2 character varying, Status character varying, o_status character varying,c_date timestamp without time zone, c_by_name character varying\r\n"
			+ ")\n")
	Flux<SalesOrderOutputDTO> getSODetailsBySalesOrderNumber(@Param("salesOrderNumber") String salesOrderNumber);

	// SO Search By branchname Function Doc Sl:-7
	@Query(value = "select * from so.so_patientbranch_lookup(:branchname) as\r\n"
			+ "(so_id bigint,so_no character varying, b_name character varying)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> getSODetailsByPatientBranchName(@Param("branchname") String branchname);

	// SO Search By Patient Name Function Doc Sl:-8
	@Query(value = "select * from so.so_patientname_lookup(:patientName) as\r\n"
			+ "(p_id bigint,p_first_name character varying, p_middle_name character varying,p_last_name character varying,p_ssn character varying,  p_gender character varying, p_dob date, p_addres_line1 character varying, p_address_line2 character varying, p_city character varying, p_state character varying,p_phone1 character varying,  p_phone2 character varying)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> getSODetailsByPatientName(@Param("patientName") String patientName);

    // Get details by patient Id - @Abhijit Chowdhury
    @Override
    Flux<SalesOrderMaster> findByPatientId(Long patientId);

	// SO Search By Confirmation Id Function Doc Sl:-11
	@Query(value = "select * from so.SObyUserIDapproved(:confirmationbyid) as\r\n"
			+ "(sid bigint,sno character varying,p_first_name character varying, p_middle_name character varying,p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, p_address_line2 character varying, Status character varying, o_status character varying,c_date timestamp without time zone,c_by_id bigint, c_by_name character varying, confirmation_by_id bigint,confirmation_by_name character varying)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> findByConfirmedById(@Param("confirmationbyid") Integer confirmationbyid);

	// SO Search By Confirmation Details Function Doc Sl:-12
	@Query(value="select * from so.UserIDapprovedLookup(:confirmationByName,:status,:confirmationFromDate,:confirmationToDate) as\r\n"
			+ "(c_by_id bigint, c_by_name character varying)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> findByByConfirmationDetails(String confirmationByName, String status, LocalDate confirmationFromDate,
			LocalDate confirmationToDate);

	// SO Search By Creation Details Function Doc Sl:-13
	@Query(value="select * from so.UserIDcreatedLookup(:createdByName,:status,:createdFromDate,:createdToDate) as\r\n"
			+ "(c_by_id bigint, c_by_name character varying)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> findByCreationDetails(String createdByName, String status, LocalDate createdFromDate,
			LocalDate createdToDate);

	// SO Search By Sales Order Details Function Doc Sl:-14
	@Query(value="select * from so.SObySalesOrderDetails(:salesOderNo,:deliveryScheduleDatetime,:deliveryActualDatetime,:createdDate) as\r\n"
			+ "(sid bigint,sno character varying,p_first_name character varying, p_middle_name character varying,p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, p_address_line2 character varying, Status character varying, o_status character varying,c_date timestamp without time zone,c_by_id bigint, c_by_name character varying, confirmation_date timestamp without time zone, delivery_schedule_datetime timestamp without time zone, delivery_actual_datetime timestamp without time zone)\r\n"
			+ "")
	Flux<SalesOrderOutputDTO> findBySOInfo(String salesOderNo, LocalDate deliveryScheduleDatetime,
			LocalDate deliveryActualDatetime, LocalDate createdDate);

    @Query(value = "select * from so.so_patient_lookup_Combined (:patientName, :salesOderNo, :patientDOBDt, :startDateDt, :endDateDt, :status, " +
        ":branchName, :primaryInsurerName, :patientAddress1, :facilityName) as " +
        "(sid bigint,sno character varying,b_name character varying,f_name character varying, p_first_name character varying, " +
        "p_middle_name character varying,p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, " +
        "p_address_line2 character varying, Status character varying, o_status character varying," +
        "c_date timestamp without time zone,c_by_id bigint, c_by_name character varying)")
    Flux<SalesOrderSearchDetailsDTO> findSODetailsWithCombinedInformation(@Param("patientName") String patientName, @Param("salesOderNo") String salesOderNo,
                                                                          @Param("patientDOBDt") LocalDate patientDOBDt, @Param("startDateDt") LocalDate startDateDt, @Param("endDateDt") LocalDate endDateDt,
                                                                          @Param("status") String status, @Param("branchName") String branchName, @Param("primaryInsurerName") String primaryInsurerName,
                                                                          @Param("patientAddress1") String patientAddress1, @Param("facilityName") String facilityName);
}

interface SalesOrderMasterRepositoryInternal {
    <S extends SalesOrderMaster> Mono<S> save(S entity);

//    Flux<SalesOrderMaster> findAllBy(Pageable pageable);
//
//    Flux<SalesOrderMaster> findAll();
//
//    Mono<SalesOrderMaster> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<SalesOrderMaster> findAllBy(Pageable pageable, Criteria criteria);

    // Get details by patient Id - @Abhijit Chowdhury
    Flux<SalesOrderMaster> findByPatientId(Long patientId);

}
