package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.domain.nppes.NpiMaster;
import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class NpiMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NpiMaster.class);
        NpiMaster npiMaster1 = new NpiMaster();
        npiMaster1.setNpiId(1L);
        NpiMaster npiMaster2 = new NpiMaster();
        npiMaster2.setNpiId(npiMaster1.getNpiId());
        assertThat(npiMaster1).isEqualTo(npiMaster2);
        npiMaster2.setNpiId(2L);
        assertThat(npiMaster1).isNotEqualTo(npiMaster2);
        npiMaster1.setNpiId(null);
        assertThat(npiMaster1).isNotEqualTo(npiMaster2);
    }
}
