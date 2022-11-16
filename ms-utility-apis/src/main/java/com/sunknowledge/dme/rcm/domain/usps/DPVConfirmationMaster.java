package com.sunknowledge.dme.rcm.domain.usps;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A DPVConfirmationMaster.
 */
@Table("t_usps_dpv_confirmation_master")
public class DPVConfirmationMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("dpv_confirmation_id")
    private Long dpvConfirmationId;

    @Column("enumerations")
    private String enumerations;

    @Column("definition")
    private String definition;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getDpvConfirmationId() {
        return this.dpvConfirmationId;
    }

    public DPVConfirmationMaster dpvConfirmationId(Long dpvConfirmationId) {
        this.setDpvConfirmationId(dpvConfirmationId);
        return this;
    }

    public void setDpvConfirmationId(Long dpvConfirmationId) {
        this.dpvConfirmationId = dpvConfirmationId;
    }

    public String getEnumerations() {
        return this.enumerations;
    }

    public DPVConfirmationMaster enumerations(String enumerations) {
        this.setEnumerations(enumerations);
        return this;
    }

    public void setEnumerations(String enumerations) {
        this.enumerations = enumerations;
    }

    public String getDefinition() {
        return this.definition;
    }

    public DPVConfirmationMaster definition(String definition) {
        this.setDefinition(definition);
        return this;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DPVConfirmationMaster)) {
            return false;
        }
        return dpvConfirmationId != null && dpvConfirmationId.equals(((DPVConfirmationMaster) o).dpvConfirmationId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DPVConfirmationMaster{" +
            "dpvConfirmationId=" + getDpvConfirmationId() +
            ", enumerations='" + getEnumerations() + "'" +
            ", definition='" + getDefinition() + "'" +
            "}";
    }
}
