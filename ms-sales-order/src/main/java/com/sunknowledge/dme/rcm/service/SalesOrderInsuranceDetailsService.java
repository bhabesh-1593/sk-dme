package com.sunknowledge.dme.rcm.service;

import com.sunknowledge.dme.rcm.service.dto.SalesOrderInsuranceSearchDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface SalesOrderInsuranceDetailsService {

    Flux<SalesOrderInsuranceSearchDetailsDTO> getSOInsuranceDetailsByInsuranceName(String insuranceName);

    Flux<SalesOrderSearchDetailsDTO> getSODetailsByInsuranceId(Long insuranceId);
}
