package com.sunknowledge.dme.rcm.domain.usps;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A UrbanizationMaster.
 */
@Table("t_usps_urbanization_master")
public class UrbanizationMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("urbanization_id")
    private Long urbanizationId;

    @Column("urbanization")
    private String urbanization;

    @Column("abbreviation")
    private String abbreviation;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getUrbanizationId() {
        return this.urbanizationId;
    }

    public UrbanizationMaster urbanizationId(Long urbanizationId) {
        this.setUrbanizationId(urbanizationId);
        return this;
    }

    public void setUrbanizationId(Long urbanizationId) {
        this.urbanizationId = urbanizationId;
    }

    public String getUrbanization() {
        return this.urbanization;
    }

    public UrbanizationMaster urbanization(String urbanization) {
        this.setUrbanization(urbanization);
        return this;
    }

    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public UrbanizationMaster abbreviation(String abbreviation) {
        this.setAbbreviation(abbreviation);
        return this;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UrbanizationMaster)) {
            return false;
        }
        return urbanizationId != null && urbanizationId.equals(((UrbanizationMaster) o).urbanizationId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UrbanizationMaster{" +
            "urbanizationId=" + getUrbanizationId() +
            ", urbanization='" + getUrbanization() + "'" +
            ", abbreviation='" + getAbbreviation() + "'" +
            "}";
    }
}
