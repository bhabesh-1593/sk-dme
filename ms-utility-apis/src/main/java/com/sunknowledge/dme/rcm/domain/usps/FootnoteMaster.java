package com.sunknowledge.dme.rcm.domain.usps;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A FootnoteMaster.
 */
@Table("t_usps_footnote_master")
public class FootnoteMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("footnotes_id")
    private Long footnotesId;

    @Column("enumerations")
    private String enumerations;

    @Column("definition")
    private String definition;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getFootnotesId() {
        return this.footnotesId;
    }

    public FootnoteMaster footnotesId(Long footnotesId) {
        this.setFootnotesId(footnotesId);
        return this;
    }

    public void setFootnotesId(Long footnotesId) {
        this.footnotesId = footnotesId;
    }

    public String getEnumerations() {
        return this.enumerations;
    }

    public FootnoteMaster enumerations(String enumerations) {
        this.setEnumerations(enumerations);
        return this;
    }

    public void setEnumerations(String enumerations) {
        this.enumerations = enumerations;
    }

    public String getDefinition() {
        return this.definition;
    }

    public FootnoteMaster definition(String definition) {
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
        if (!(o instanceof FootnoteMaster)) {
            return false;
        }
        return footnotesId != null && footnotesId.equals(((FootnoteMaster) o).footnotesId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FootnoteMaster{" +
            "footnotesId=" + getFootnotesId() +
            ", enumerations='" + getEnumerations() + "'" +
            ", definition='" + getDefinition() + "'" +
            "}";
    }
}
