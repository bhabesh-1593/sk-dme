package com.sunknowledge.dme.rcm.repository;

import com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderInsuranceSearchDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

/**
 * Spring Data SQL reactive repository for the SalesOrderInsuranceDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalesOrderInsuranceDetailsRepository
    extends ReactiveCrudRepository<SalesOrderInsuranceDetails, Long>, SalesOrderInsuranceDetailsRepositoryInternal {
    @Override
    <S extends SalesOrderInsuranceDetails> Mono<S> save(S entity);

    @Override
    Flux<SalesOrderInsuranceDetails> findAll();

    @Override
    Mono<SalesOrderInsuranceDetails> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);

    @Query(value = "select * from so.InsuranceIDLookup(:insuranceName) as\n" +
        "(primary_insurer_id bigint, primary_insurer_name character varying, primary_insurance_group_name character varying,  " +
        "primary_insurance_state_name character varying)\n")
    Flux<SalesOrderInsuranceSearchDetailsDTO> findSOInsuranceDetailsByInsuranceName(@Param("insuranceName") String insuranceName);

    @Query(value = "select * from so.so_by_insurance_id (:insuranceId) as \n" +
        "(sid bigint,sno character varying,p_first_name character varying, p_middle_name character varying," +
        "p_last_name character varying,p_dob date,p_Insurer_name character varying, p_addres_line1 character varying, " +
        "p_address_line2 character varying, Status character varying, o_status character varying," +
        "c_date timestamp without time zone,c_by_id bigint,c_by_name character varying, " +
        "primary_insurer_id bigint)\n")
    Flux<SalesOrderSearchDetailsDTO> findSODetailsByInsuranceId(Long insuranceId);
}

interface SalesOrderInsuranceDetailsRepositoryInternal {
    <S extends SalesOrderInsuranceDetails> Mono<S> save(S entity);

    Flux<SalesOrderInsuranceDetails> findAllBy(Pageable pageable);

    Flux<SalesOrderInsuranceDetails> findAll();

    Mono<SalesOrderInsuranceDetails> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<SalesOrderInsuranceDetails> findAllBy(Pageable pageable, Criteria criteria);

}
