package com.sunknowledge.dme.rcm.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SalesOrderClinicalDetailsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SalesOrderClinicalDetailsDTO.class);
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO1 = new SalesOrderClinicalDetailsDTO();
        salesOrderClinicalDetailsDTO1.setSalesOderClinicalDetailsId(1L);
        SalesOrderClinicalDetailsDTO salesOrderClinicalDetailsDTO2 = new SalesOrderClinicalDetailsDTO();
        assertThat(salesOrderClinicalDetailsDTO1).isNotEqualTo(salesOrderClinicalDetailsDTO2);
        salesOrderClinicalDetailsDTO2.setSalesOderClinicalDetailsId(salesOrderClinicalDetailsDTO1.getSalesOderClinicalDetailsId());
        assertThat(salesOrderClinicalDetailsDTO1).isEqualTo(salesOrderClinicalDetailsDTO2);
        salesOrderClinicalDetailsDTO2.setSalesOderClinicalDetailsId(2L);
        assertThat(salesOrderClinicalDetailsDTO1).isNotEqualTo(salesOrderClinicalDetailsDTO2);
        salesOrderClinicalDetailsDTO1.setSalesOderClinicalDetailsId(null);
        assertThat(salesOrderClinicalDetailsDTO1).isNotEqualTo(salesOrderClinicalDetailsDTO2);
    }
}
