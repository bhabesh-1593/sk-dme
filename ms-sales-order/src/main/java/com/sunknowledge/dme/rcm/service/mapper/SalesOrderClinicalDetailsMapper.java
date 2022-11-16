package com.sunknowledge.dme.rcm.service.mapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderClinicalDetails;
import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderClinicalDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SalesOrderClinicalDetails} and its DTO {@link SalesOrderClinicalDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface SalesOrderClinicalDetailsMapper extends EntityMapper<SalesOrderClinicalDetailsDTO, SalesOrderClinicalDetails> {
    @Mapping(target = "salesOrderMaster", source = "salesOrderMaster", qualifiedByName = "salesOrderMasterSalesOrderId")
    SalesOrderClinicalDetailsDTO toDto(SalesOrderClinicalDetails s);

    @Named("salesOrderMasterSalesOrderId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "salesOrderId", source = "salesOrderId")
    SalesOrderMasterDTO toDtoSalesOrderMasterSalesOrderId(SalesOrderMaster salesOrderMaster);
}
