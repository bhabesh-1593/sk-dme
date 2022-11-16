package com.sunknowledge.dme.rcm.service.mapper;

import com.sunknowledge.dme.rcm.domain.SalesOrderItemDetails;
import com.sunknowledge.dme.rcm.domain.SalesOrderMaster;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderItemDetailsDTO;
import com.sunknowledge.dme.rcm.service.dto.SalesOrderMasterDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SalesOrderItemDetails} and its DTO {@link SalesOrderItemDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface SalesOrderItemDetailsMapper extends EntityMapper<SalesOrderItemDetailsDTO, SalesOrderItemDetails> {
    @Mapping(target = "itemDetails", source = "itemDetails", qualifiedByName = "salesOrderMasterSalesOrderId")
    SalesOrderItemDetailsDTO toDto(SalesOrderItemDetails s);

    @Named("salesOrderMasterSalesOrderId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "salesOrderId", source = "salesOrderId")
    SalesOrderMasterDTO toDtoSalesOrderMasterSalesOrderId(SalesOrderMaster salesOrderMaster);
}
