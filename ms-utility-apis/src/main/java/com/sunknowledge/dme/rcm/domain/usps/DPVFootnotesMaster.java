package com.sunknowledge.dme.rcm.domain.usps;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A DPVFootnotesMaster.
 */
@Table("t_usps_dpv_footnotes_master")
public class DPVFootnotesMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("dpv_footnotes_id")
    private Long dpvFootnotesId;

    @Column("enumerations")
    private String enumerations;

    @Column("definition")
    private String definition;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getDpvFootnotesId() {
        return this.dpvFootnotesId;
    }

    public DPVFootnotesMaster dpvFootnotesId(Long dpvFootnotesId) {
        this.setDpvFootnotesId(dpvFootnotesId);
        return this;
    }

    public void setDpvFootnotesId(Long dpvFootnotesId) {
        this.dpvFootnotesId = dpvFootnotesId;
    }

    public String getEnumerations() {
        return this.enumerations;
    }

    public DPVFootnotesMaster enumerations(String enumerations) {
        this.setEnumerations(enumerations);
        return this;
    }

    public void setEnumerations(String enumerations) {
        this.enumerations = enumerations;
    }

    public String getDefinition() {
        return this.definition;
    }

    public DPVFootnotesMaster definition(String definition) {
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
        if (!(o instanceof DPVFootnotesMaster)) {
            return false;
        }
        return dpvFootnotesId != null && dpvFootnotesId.equals(((DPVFootnotesMaster) o).dpvFootnotesId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DPVFootnotesMaster{" +
            "dpvFootnotesId=" + getDpvFootnotesId() +
            ", enumerations='" + getEnumerations() + "'" +
            ", definition='" + getDefinition() + "'" +
            "}";
    }
}
