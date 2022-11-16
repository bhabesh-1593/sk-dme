package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.domain.usps.USPSStateMaster;
import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class USPSStateMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(USPSStateMaster.class);
        USPSStateMaster uSPSStateMaster1 = new USPSStateMaster();
        uSPSStateMaster1.setStateId(1L);
        USPSStateMaster uSPSStateMaster2 = new USPSStateMaster();
        uSPSStateMaster2.setStateId(uSPSStateMaster1.getStateId());
        assertThat(uSPSStateMaster1).isEqualTo(uSPSStateMaster2);
        uSPSStateMaster2.setStateId(2L);
        assertThat(uSPSStateMaster1).isNotEqualTo(uSPSStateMaster2);
        uSPSStateMaster1.setStateId(null);
        assertThat(uSPSStateMaster1).isNotEqualTo(uSPSStateMaster2);
    }
}
