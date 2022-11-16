package com.sunknowledge.dme.rcm.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.sunknowledge.dme.rcm.domain.usps.FootnoteMaster;
import com.sunknowledge.dme.rcm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FootnoteMasterTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FootnoteMaster.class);
        FootnoteMaster footnoteMaster1 = new FootnoteMaster();
        footnoteMaster1.setFootnotesId(1L);
        FootnoteMaster footnoteMaster2 = new FootnoteMaster();
        footnoteMaster2.setFootnotesId(footnoteMaster1.getFootnotesId());
        assertThat(footnoteMaster1).isEqualTo(footnoteMaster2);
        footnoteMaster2.setFootnotesId(2L);
        assertThat(footnoteMaster1).isNotEqualTo(footnoteMaster2);
        footnoteMaster1.setFootnotesId(null);
        assertThat(footnoteMaster1).isNotEqualTo(footnoteMaster2);
    }
}
