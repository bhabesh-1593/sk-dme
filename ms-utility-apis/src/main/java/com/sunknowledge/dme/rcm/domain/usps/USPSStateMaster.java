package com.sunknowledge.dme.rcm.domain.usps;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A USPSStateMaster.
 */
@Table("t_usps_usps_state_master")
public class USPSStateMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("state_id")
    private Long stateId;

    @Column("state_name")
    private String stateName;

    @Column("postal_abbriviation")
    private String postalAbbriviation;

    @Column("fips_code")
    private String fipsCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getStateId() {
        return this.stateId;
    }

    public USPSStateMaster stateId(Long stateId) {
        this.setStateId(stateId);
        return this;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return this.stateName;
    }

    public USPSStateMaster stateName(String stateName) {
        this.setStateName(stateName);
        return this;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPostalAbbriviation() {
        return this.postalAbbriviation;
    }

    public USPSStateMaster postalAbbriviation(String postalAbbriviation) {
        this.setPostalAbbriviation(postalAbbriviation);
        return this;
    }

    public void setPostalAbbriviation(String postalAbbriviation) {
        this.postalAbbriviation = postalAbbriviation;
    }

    public String getFipsCode() {
        return this.fipsCode;
    }

    public USPSStateMaster fipsCode(String fipsCode) {
        this.setFipsCode(fipsCode);
        return this;
    }

    public void setFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof USPSStateMaster)) {
            return false;
        }
        return stateId != null && stateId.equals(((USPSStateMaster) o).stateId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "USPSStateMaster{" +
            "stateId=" + getStateId() +
            ", stateName='" + getStateName() + "'" +
            ", postalAbbriviation='" + getPostalAbbriviation() + "'" +
            ", fipsCode='" + getFipsCode() + "'" +
            "}";
    }
}
