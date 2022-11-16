package com.sunknowledge.dme.rcm.service.mapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderFinancialDetails;
import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderFinancialDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SalesOrderFinancialDetails} and its DTO {@link SalesOrderFinancialDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface SalesOrderFinancialDetailsMapper extends EntityMapper<SalesOrderFinancialDetailsDTO, SalesOrderFinancialDetails> {
    @Mapping(target = "salesOrderMaster", source = "salesOrderMaster", qualifiedByName = "salesOrderMasterSalesOrderId")
    SalesOrderFinancialDetailsDTO toDto(SalesOrderFinancialDetails s);

    @Named("salesOrderMasterSalesOrderId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "salesOrderId", source = "salesOrderId")
    SalesOrderMasterDTO toDtoSalesOrderMasterSalesOrderId(SalesOrderMaster salesOrderMaster);
}
