package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class DPVConfirmationMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DPVConfirmationMaster.class);
        DPVConfirmationMaster dPVConfirmationMaster1 = new DPVConfirmationMaster();
        dPVConfirmationMaster1.setDpvConfirmationId(1L);
        DPVConfirmationMaster dPVConfirmationMaster2 = new DPVConfirmationMaster();
        dPVConfirmationMaster2.setDpvConfirmationId(dPVConfirmationMaster1.getDpvConfirmationId());
        assertThat(dPVConfirmationMaster1).isEqualTo(dPVConfirmationMaster2);
        dPVConfirmationMaster2.setDpvConfirmationId(2L);
        assertThat(dPVConfirmationMaster1).isNotEqualTo(dPVConfirmationMaster2);
        dPVConfirmationMaster1.setDpvConfirmationId(null);
        assertThat(dPVConfirmationMaster1).isNotEqualTo(dPVConfirmationMaster2);
    }
}
