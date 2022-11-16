package com.sunknowledge.dme.rcm.domain.nppes;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A NpiMaster.
 */
@Table("t_nppes_npi_master")
public class NpiMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("npi_id")
    private Long npiId;

    @Column("npi_number")
    private String npiNumber;

    @Column("enumeration_type")
    private String enumerationType;

    @Column("npi_name")
    private String npiName;

    @Column("address")
    private String address;

    @Column("phone")
    private String phone;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getNpiId() {
        return this.npiId;
    }

    public NpiMaster npiId(Long npiId) {
        this.setNpiId(npiId);
        return this;
    }

    public void setNpiId(Long npiId) {
        this.npiId = npiId;
    }

    public String getNpiNumber() {
        return this.npiNumber;
    }

    public NpiMaster npiNumber(String npiNumber) {
        this.setNpiNumber(npiNumber);
        return this;
    }

    public void setNpiNumber(String npiNumber) {
        this.npiNumber = npiNumber;
    }

    public String getEnumerationType() {
        return this.enumerationType;
    }

    public NpiMaster enumerationType(String enumerationType) {
        this.setEnumerationType(enumerationType);
        return this;
    }

    public void setEnumerationType(String enumerationType) {
        this.enumerationType = enumerationType;
    }

    public String getNpiName() {
        return this.npiName;
    }

    public NpiMaster npiName(String npiName) {
        this.setNpiName(npiName);
        return this;
    }

    public void setNpiName(String npiName) {
        this.npiName = npiName;
    }

    public String getAddress() {
        return this.address;
    }

    public NpiMaster address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public NpiMaster phone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NpiMaster)) {
            return false;
        }
        return npiId != null && npiId.equals(((NpiMaster) o).npiId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NpiMaster{" +
            "npiId=" + getNpiId() +
            ", npiNumber='" + getNpiNumber() + "'" +
            ", enumerationType='" + getEnumerationType() + "'" +
            ", npiName='" + getNpiName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }
}
