package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.domain.usps.UrbanizationMaster;
import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UrbanizationMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UrbanizationMaster.class);
        UrbanizationMaster urbanizationMaster1 = new UrbanizationMaster();
        urbanizationMaster1.setUrbanizationId(1L);
        UrbanizationMaster urbanizationMaster2 = new UrbanizationMaster();
        urbanizationMaster2.setUrbanizationId(urbanizationMaster1.getUrbanizationId());
        assertThat(urbanizationMaster1).isEqualTo(urbanizationMaster2);
        urbanizationMaster2.setUrbanizationId(2L);
        assertThat(urbanizationMaster1).isNotEqualTo(urbanizationMaster2);
        urbanizationMaster1.setUrbanizationId(null);
        assertThat(urbanizationMaster1).isNotEqualTo(urbanizationMaster2);
    }
}
