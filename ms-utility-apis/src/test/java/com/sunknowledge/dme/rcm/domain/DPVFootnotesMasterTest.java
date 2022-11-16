package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.domain.usps.DPVFootnotesMaster;
import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DPVFootnotesMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DPVFootnotesMaster.class);
        DPVFootnotesMaster dPVFootnotesMaster1 = new DPVFootnotesMaster();
        dPVFootnotesMaster1.setDpvFootnotesId(1L);
        DPVFootnotesMaster dPVFootnotesMaster2 = new DPVFootnotesMaster();
        dPVFootnotesMaster2.setDpvFootnotesId(dPVFootnotesMaster1.getDpvFootnotesId());
        assertThat(dPVFootnotesMaster1).isEqualTo(dPVFootnotesMaster2);
        dPVFootnotesMaster2.setDpvFootnotesId(2L);
        assertThat(dPVFootnotesMaster1).isNotEqualTo(dPVFootnotesMaster2);
        dPVFootnotesMaster1.setDpvFootnotesId(null);
        assertThat(dPVFootnotesMaster1).isNotEqualTo(dPVFootnotesMaster2);
    }
}
