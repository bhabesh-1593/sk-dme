package com.sunknowledge.dme.rcm.service;

import com.sunknowledge.dme.rcm.repository.SalesOrderInsuranceDetailsRepository;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderInsuranceSearchDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderSearchDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Service
public class SalesOrderInsuranceDetailsServiceImpl implements SalesOrderInsuranceDetailsService{

    @Autowired
    SalesOrderInsuranceDetailsRepository salesOrderInsuranceDetailsRepository;

    @Override
    public Flux<SalesOrderInsuranceSearchDetailsDTO> getSOInsuranceDetailsByInsuranceName(String insuranceName) {
        System.out.println("insuranceName="+insuranceName);
        Flux<SalesOrderInsuranceSearchDetailsDTO> list = salesOrderInsuranceDetailsRepository.findSOInsuranceDetailsByInsuranceName(insuranceName);
        System.out.println("list="+list);
        return list;
    }

    @Override
    public Flux<SalesOrderSearchDetailsDTO> getSODetailsByInsuranceId(Long insuranceId) {
        System.out.println("insuranceId="+insuranceId);
        Flux<SalesOrderSearchDetailsDTO> list = salesOrderInsuranceDetailsRepository.findSODetailsByInsuranceId(insuranceId);
        System.out.println("list="+list);
        return list;
    }
}
