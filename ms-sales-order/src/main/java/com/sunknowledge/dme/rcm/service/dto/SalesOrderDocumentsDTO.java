package com.sunknowledge.dme.rcm.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.sunknowledge.dme.rcm.domain.SalesOrderDocuments} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SalesOrderDocumentsDTO implements Serializable {

    private Long salesOrderDocumentId;

    @NotNull(message = "must not be null")
    private Long salesOrderId;

    @NotNull(message = "must not be null")
    private Integer patientId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    private String patientName;

    @NotNull(message = "must not be null")
    private LocalDate patientDob;

    private LocalDate patientDod;

    @NotNull(message = "must not be null")
    private String patientSsn;

    private String qmbStatus;

    @NotNull(message = "must not be null")
    private String patientGender;

    @NotNull(message = "must not be null")
    private Integer patientHeight;

    @NotNull(message = "must not be null")
    private Integer patientWeight;

    @NotNull(message = "must not be null")
    private String patientContact1;

    private String patientContact2;

    private String email;

    private String fax;

    @NotNull(message = "must not be null")
    private String hipaaOnFileStatus;

    @NotNull(message = "must not be null")
    private Integer branchId;

    @NotNull(message = "must not be null")
    private String branchName;

    private Integer documentTypeId;

    private String documentTypeName;

    private LocalDate documentDate;

    private String documentNote;

    private String documentTitle;

    private String documentName;

    private Integer scanBy;

    private String fileUploadPath;

    private LocalDate uploadDate;

    private Integer uploadBy;

    private LocalDate scanDate;

    private String reviewStatus;

    private String reviewReason;

    private LocalDate reviewDate;

    private Integer reviewBy;

    private String status;

    private Integer createdById;

    private String createdByName;

    private ZonedDateTime createdDate;

    private Integer updatedById;

    private String updatedByName;

    private ZonedDateTime updatedDate;

    public Long getSalesOrderDocumentId() {
        return salesOrderDocumentId;
    }

    public void setSalesOrderDocumentId(Long salesOrderDocumentId) {
        this.salesOrderDocumentId = salesOrderDocumentId;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public LocalDate getPatientDod() {
        return patientDod;
    }

    public void setPatientDod(LocalDate patientDod) {
        this.patientDod = patientDod;
    }

    public String getPatientSsn() {
        return patientSsn;
    }

    public void setPatientSsn(String patientSsn) {
        this.patientSsn = patientSsn;
    }

    public String getQmbStatus() {
        return qmbStatus;
    }

    public void setQmbStatus(String qmbStatus) {
        this.qmbStatus = qmbStatus;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(Integer patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Integer getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(Integer patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientContact1() {
        return patientContact1;
    }

    public void setPatientContact1(String patientContact1) {
        this.patientContact1 = patientContact1;
    }

    public String getPatientContact2() {
        return patientContact2;
    }

    public void setPatientContact2(String patientContact2) {
        this.patientContact2 = patientContact2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHipaaOnFileStatus() {
        return hipaaOnFileStatus;
    }

    public void setHipaaOnFileStatus(String hipaaOnFileStatus) {
        this.hipaaOnFileStatus = hipaaOnFileStatus;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentNote() {
        return documentNote;
    }

    public void setDocumentNote(String documentNote) {
        this.documentNote = documentNote;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getScanBy() {
        return scanBy;
    }

    public void setScanBy(Integer scanBy) {
        this.scanBy = scanBy;
    }

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(Integer uploadBy) {
        this.uploadBy = uploadBy;
    }

    public LocalDate getScanDate() {
        return scanDate;
    }

    public void setScanDate(LocalDate scanDate) {
        this.scanDate = scanDate;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(Integer reviewBy) {
        this.reviewBy = reviewBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesOrderDocumentsDTO)) {
            return false;
        }

        SalesOrderDocumentsDTO salesOrderDocumentsDTO = (SalesOrderDocumentsDTO) o;
        if (this.salesOrderDocumentId == null) {
            return false;
        }
        return Objects.equals(this.salesOrderDocumentId, salesOrderDocumentsDTO.salesOrderDocumentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.salesOrderDocumentId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderDocumentsDTO{" +
            "salesOrderDocumentId=" + getSalesOrderDocumentId() +
            ", salesOrderId=" + getSalesOrderId() +
            ", patientId=" + getPatientId() +
            ", patientName='" + getPatientName() + "'" +
            ", patientDob='" + getPatientDob() + "'" +
            ", patientDod='" + getPatientDod() + "'" +
            ", patientSsn='" + getPatientSsn() + "'" +
            ", qmbStatus='" + getQmbStatus() + "'" +
            ", patientGender='" + getPatientGender() + "'" +
            ", patientHeight=" + getPatientHeight() +
            ", patientWeight=" + getPatientWeight() +
            ", patientContact1='" + getPatientContact1() + "'" +
            ", patientContact2='" + getPatientContact2() + "'" +
            ", email='" + getEmail() + "'" +
            ", fax='" + getFax() + "'" +
            ", hipaaOnFileStatus='" + getHipaaOnFileStatus() + "'" +
            ", branchId=" + getBranchId() +
            ", branchName='" + getBranchName() + "'" +
            ", documentTypeId=" + getDocumentTypeId() +
            ", documentTypeName='" + getDocumentTypeName() + "'" +
            ", documentDate='" + getDocumentDate() + "'" +
            ", documentNote='" + getDocumentNote() + "'" +
            ", documentTitle='" + getDocumentTitle() + "'" +
            ", documentName='" + getDocumentName() + "'" +
            ", scanBy=" + getScanBy() +
            ", fileUploadPath='" + getFileUploadPath() + "'" +
            ", uploadDate='" + getUploadDate() + "'" +
            ", uploadBy=" + getUploadBy() +
            ", scanDate='" + getScanDate() + "'" +
            ", reviewStatus='" + getReviewStatus() + "'" +
            ", reviewReason='" + getReviewReason() + "'" +
            ", reviewDate='" + getReviewDate() + "'" +
            ", reviewBy=" + getReviewBy() +
            ", status='" + getStatus() + "'" +
            ", createdById=" + getCreatedById() +
            ", createdByName='" + getCreatedByName() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", updatedById=" + getUpdatedById() +
            ", updatedByName='" + getUpdatedByName() + "'" +
            ", updatedDate='" + getUpdatedDate() + "'" +
            "}";
    }
}
