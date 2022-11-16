package com.sunknowledge.dme.rcm.service.mapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderInsuranceDetails;
import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderInsuranceDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SalesOrderInsuranceDetails} and its DTO {@link SalesOrderInsuranceDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface SalesOrderInsuranceDetailsMapper extends EntityMapper<SalesOrderInsuranceDetailsDTO, SalesOrderInsuranceDetails> {
    @Mapping(target = "salesOrderMaster", source = "salesOrderMaster", qualifiedByName = "salesOrderMasterSalesOrderId")
    SalesOrderInsuranceDetailsDTO toDto(SalesOrderInsuranceDetails s);

    @Named("salesOrderMasterSalesOrderId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "salesOrderId", source = "salesOrderId")
    SalesOrderMasterDTO toDtoSalesOrderMasterSalesOrderId(SalesOrderMaster salesOrderMaster);
}
