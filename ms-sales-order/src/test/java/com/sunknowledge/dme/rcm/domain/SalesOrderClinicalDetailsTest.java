package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SalesOrderClinicalDetailsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SalesOrderClinicalDetails.class);
        SalesOrderClinicalDetails salesOrderClinicalDetails1 = new SalesOrderClinicalDetails();
        salesOrderClinicalDetails1.setSalesOderClinicalDetailsId(1L);
        SalesOrderClinicalDetails salesOrderClinicalDetails2 = new SalesOrderClinicalDetails();
        salesOrderClinicalDetails2.setSalesOderClinicalDetailsId(salesOrderClinicalDetails1.getSalesOderClinicalDetailsId());
        assertThat(salesOrderClinicalDetails1).isEqualTo(salesOrderClinicalDetails2);
        salesOrderClinicalDetails2.setSalesOderClinicalDetailsId(2L);
        assertThat(salesOrderClinicalDetails1).isNotEqualTo(salesOrderClinicalDetails2);
        salesOrderClinicalDetails1.setSalesOderClinicalDetailsId(null);
        assertThat(salesOrderClinicalDetails1).isNotEqualTo(salesOrderClinicalDetails2);
    }
}
