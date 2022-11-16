package com.sunknowledge.dme.rcm.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A SalesOrderDocuments.
 */
@Table("t_sales_order_documents")
public class SalesOrderDocuments implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Column("id")
//    private Long id;

    @Id
    @NotNull(message = "must not be null")
    @Column("sales_order_document_id")
    private Integer salesOrderDocumentId;

    @NotNull(message = "must not be null")
    @Column("patient_id")
    private Integer patientId;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[A-Z][a-z]+\\d$")
    @Column("patient_name")
    private String patientName;

    @NotNull(message = "must not be null")
    @Column("patient_dob")
    private LocalDate patientDob;

    @Column("patient_dod")
    private LocalDate patientDod;

    @NotNull(message = "must not be null")
    @Column("patient_ssn")
    private String patientSsn;

    @Column("qmb_status")
    private String qmbStatus;

    @NotNull(message = "must not be null")
    @Column("patient_gender")
    private String patientGender;

    @Column("patient_height")
    private Integer patientHeight;

    @Column("patient_weight")
    private Integer patientWeight;

    @Column("patient_contact1")
    private String patientContact1;

    @Column("patient_contact2")
    private String patientContact2;

    @Column("email")
    private String email;

    @Column("fax")
    private String fax;

    @Column("hipaa_on_file_status")
    private String hipaaOnFileStatus;

    @NotNull(message = "must not be null")
    @Column("branch_id")
    private Integer branchId;

    @NotNull(message = "must not be null")
    @Column("branch_name")
    private String branchName;

    @Column("document_type_id")
    private Integer documentTypeId;

    @Column("document_type_name")
    private String documentTypeName;

    @Column("document_date")
    private LocalDate documentDate;

    @Column("document_note")
    private String documentNote;

    @Column("document_title")
    private String documentTitle;

    @Column("document_name")
    private String documentName;

    @Column("scan_by")
    private Integer scanBy;

    @Column("file_upload_path")
    private String fileUploadPath;

    @Column("upload_date")
    private LocalDate uploadDate;

    @Column("upload_by")
    private Integer uploadBy;

    @Column("scan_date")
    private LocalDate scanDate;

    @Column("review_status")
    private String reviewStatus;

    @Column("review_reason")
    private String reviewReason;

    @Column("review_date")
    private LocalDate reviewDate;

    @Column("review_by")
    private Integer reviewBy;

    @Column("status")
    private String status;

    @Column("created_by_id")
    private Integer createdById;

    @Column("created_by_name")
    private String createdByName;

    @Column("created_date")
    private ZonedDateTime createdDate;

    @Column("updated_by_id")
    private Integer updatedById;

    @Column("updated_by_name")
    private String updatedByName;

    @Column("updated_date")
    private ZonedDateTime updatedDate;
    
    @Column("sales_order_id")
    private Integer salesOrderId;

    @Column("sales_order_no")
    private String salesOrderNo;

    @Column("sales_order_creation_date")
    private ZonedDateTime salesOrderCreationDate;

    @Column("sales_order_documents_uuid")
    private UUID salesOrderDocumentsUuid;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getPatientId() {
        return this.patientId;
    }

    public SalesOrderDocuments patientId(Integer patientId) {
        this.setPatientId(patientId);
        return this;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public SalesOrderDocuments patientName(String patientName) {
        this.setPatientName(patientName);
        return this;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getPatientDob() {
        return this.patientDob;
    }

    public SalesOrderDocuments patientDob(LocalDate patientDob) {
        this.setPatientDob(patientDob);
        return this;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public LocalDate getPatientDod() {
        return this.patientDod;
    }

    public SalesOrderDocuments patientDod(LocalDate patientDod) {
        this.setPatientDod(patientDod);
        return this;
    }

    public void setPatientDod(LocalDate patientDod) {
        this.patientDod = patientDod;
    }

    public String getPatientSsn() {
        return this.patientSsn;
    }

    public SalesOrderDocuments patientSsn(String patientSsn) {
        this.setPatientSsn(patientSsn);
        return this;
    }

    public void setPatientSsn(String patientSsn) {
        this.patientSsn = patientSsn;
    }

    public String getQmbStatus() {
        return this.qmbStatus;
    }

    public SalesOrderDocuments qmbStatus(String qmbStatus) {
        this.setQmbStatus(qmbStatus);
        return this;
    }

    public void setQmbStatus(String qmbStatus) {
        this.qmbStatus = qmbStatus;
    }

    public String getPatientGender() {
        return this.patientGender;
    }

    public SalesOrderDocuments patientGender(String patientGender) {
        this.setPatientGender(patientGender);
        return this;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Integer getPatientHeight() {
        return this.patientHeight;
    }

    public SalesOrderDocuments patientHeight(Integer patientHeight) {
        this.setPatientHeight(patientHeight);
        return this;
    }

    public void setPatientHeight(Integer patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Integer getPatientWeight() {
        return this.patientWeight;
    }

    public SalesOrderDocuments patientWeight(Integer patientWeight) {
        this.setPatientWeight(patientWeight);
        return this;
    }

    public void setPatientWeight(Integer patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientContact1() {
        return this.patientContact1;
    }

    public SalesOrderDocuments patientContact1(String patientContact1) {
        this.setPatientContact1(patientContact1);
        return this;
    }

    public void setPatientContact1(String patientContact1) {
        this.patientContact1 = patientContact1;
    }

    public String getPatientContact2() {
        return this.patientContact2;
    }

    public SalesOrderDocuments patientContact2(String patientContact2) {
        this.setPatientContact2(patientContact2);
        return this;
    }

    public void setPatientContact2(String patientContact2) {
        this.patientContact2 = patientContact2;
    }

    public String getEmail() {
        return this.email;
    }

    public SalesOrderDocuments email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return this.fax;
    }

    public SalesOrderDocuments fax(String fax) {
        this.setFax(fax);
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHipaaOnFileStatus() {
        return this.hipaaOnFileStatus;
    }

    public SalesOrderDocuments hipaaOnFileStatus(String hipaaOnFileStatus) {
        this.setHipaaOnFileStatus(hipaaOnFileStatus);
        return this;
    }

    public void setHipaaOnFileStatus(String hipaaOnFileStatus) {
        this.hipaaOnFileStatus = hipaaOnFileStatus;
    }

    public Integer getBranchId() {
        return this.branchId;
    }

    public SalesOrderDocuments branchId(Integer branchId) {
        this.setBranchId(branchId);
        return this;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public SalesOrderDocuments branchName(String branchName) {
        this.setBranchName(branchName);
        return this;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getDocumentTypeId() {
        return this.documentTypeId;
    }

    public SalesOrderDocuments documentTypeId(Integer documentTypeId) {
        this.setDocumentTypeId(documentTypeId);
        return this;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return this.documentTypeName;
    }

    public SalesOrderDocuments documentTypeName(String documentTypeName) {
        this.setDocumentTypeName(documentTypeName);
        return this;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public LocalDate getDocumentDate() {
        return this.documentDate;
    }

    public SalesOrderDocuments documentDate(LocalDate documentDate) {
        this.setDocumentDate(documentDate);
        return this;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocumentNote() {
        return this.documentNote;
    }

    public SalesOrderDocuments documentNote(String documentNote) {
        this.setDocumentNote(documentNote);
        return this;
    }

    public void setDocumentNote(String documentNote) {
        this.documentNote = documentNote;
    }

    public Integer getSalesOrderDocumentId() {
        return this.salesOrderDocumentId;
    }

    public SalesOrderDocuments salesOrderDocumentId(Integer salesOrderDocumentId) {
        this.setSalesOrderDocumentId(salesOrderDocumentId);
        return this;
    }

    public void setSalesOrderDocumentId(Integer salesOrderDocumentId) {
        this.salesOrderDocumentId = salesOrderDocumentId;
    }

    public String getDocumentTitle() {
        return this.documentTitle;
    }

    public SalesOrderDocuments documentTitle(String documentTitle) {
        this.setDocumentTitle(documentTitle);
        return this;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public SalesOrderDocuments documentName(String documentName) {
        this.setDocumentName(documentName);
        return this;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getScanBy() {
        return this.scanBy;
    }

    public SalesOrderDocuments scanBy(Integer scanBy) {
        this.setScanBy(scanBy);
        return this;
    }

    public void setScanBy(Integer scanBy) {
        this.scanBy = scanBy;
    }

    public String getFileUploadPath() {
        return this.fileUploadPath;
    }

    public SalesOrderDocuments fileUploadPath(String fileUploadPath) {
        this.setFileUploadPath(fileUploadPath);
        return this;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public LocalDate getUploadDate() {
        return this.uploadDate;
    }

    public SalesOrderDocuments uploadDate(LocalDate uploadDate) {
        this.setUploadDate(uploadDate);
        return this;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getUploadBy() {
        return this.uploadBy;
    }

    public SalesOrderDocuments uploadBy(Integer uploadBy) {
        this.setUploadBy(uploadBy);
        return this;
    }

    public void setUploadBy(Integer uploadBy) {
        this.uploadBy = uploadBy;
    }

    public LocalDate getScanDate() {
        return this.scanDate;
    }

    public SalesOrderDocuments scanDate(LocalDate scanDate) {
        this.setScanDate(scanDate);
        return this;
    }

    public void setScanDate(LocalDate scanDate) {
        this.scanDate = scanDate;
    }

    public String getReviewStatus() {
        return this.reviewStatus;
    }

    public SalesOrderDocuments reviewStatus(String reviewStatus) {
        this.setReviewStatus(reviewStatus);
        return this;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewReason() {
        return this.reviewReason;
    }

    public SalesOrderDocuments reviewReason(String reviewReason) {
        this.setReviewReason(reviewReason);
        return this;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public LocalDate getReviewDate() {
        return this.reviewDate;
    }

    public SalesOrderDocuments reviewDate(LocalDate reviewDate) {
        this.setReviewDate(reviewDate);
        return this;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getReviewBy() {
        return this.reviewBy;
    }

    public SalesOrderDocuments reviewBy(Integer reviewBy) {
        this.setReviewBy(reviewBy);
        return this;
    }

    public void setReviewBy(Integer reviewBy) {
        this.reviewBy = reviewBy;
    }

    public String getStatus() {
        return this.status;
    }

    public SalesOrderDocuments status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedById() {
        return this.createdById;
    }

    public SalesOrderDocuments createdById(Integer createdById) {
        this.setCreatedById(createdById);
        return this;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return this.createdByName;
    }

    public SalesOrderDocuments createdByName(String createdByName) {
        this.setCreatedByName(createdByName);
        return this;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public SalesOrderDocuments createdDate(ZonedDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedById() {
        return this.updatedById;
    }

    public SalesOrderDocuments updatedById(Integer updatedById) {
        this.setUpdatedById(updatedById);
        return this;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return this.updatedByName;
    }

    public SalesOrderDocuments updatedByName(String updatedByName) {
        this.setUpdatedByName(updatedByName);
        return this;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public ZonedDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public SalesOrderDocuments updatedDate(ZonedDateTime updatedDate) {
        this.setUpdatedDate(updatedDate);
        return this;
    }

    public void setUpdatedDate(ZonedDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getSalesOrderId() {
		return salesOrderId;
	}

    public SalesOrderDocuments salesOrderId(Integer salesOrrderId) {
        this.setSalesOrderId(salesOrderId);
        return this;
    }

	public void setSalesOrderId(Integer salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getSalesOrderNo() {
		return salesOrderNo;
	}

    public SalesOrderDocuments salesOderNo(String salesOrderNo) {
        this.setSalesOrderNo(salesOrderNo);
        return this;
    }

	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}

	public ZonedDateTime getSalesOrderCreationDate() {
		return salesOrderCreationDate;
	}

    public SalesOrderDocuments salesOrderCreationDate(ZonedDateTime salesOrderCreationDate) {
        this.setSalesOrderCreationDate(salesOrderCreationDate);
        return this;
    }

	public void setSalesOrderCreationDate(ZonedDateTime salesOrderCreationDate) {
		this.salesOrderCreationDate = salesOrderCreationDate;
	}

	public UUID getSalesOrderDocumentsUuid() {
		return salesOrderDocumentsUuid;
	}

    public SalesOrderDocuments salesOrderDocumentsUuid(UUID salesOrderDocumentsUuid) {
        this.setSalesOrderDocumentsUuid(salesOrderDocumentsUuid);
        return this;
    }

	public void setSalesOrderDocumentsUuid(UUID salesOrderDocumentsUuid) {
		this.salesOrderDocumentsUuid = salesOrderDocumentsUuid;
	}

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

	@Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

	@Override
	public String toString() {
		return "SalesOrderDocuments [salesOrderDocumentId=" + salesOrderDocumentId + ", patientId=" + patientId
				+ ", patientName=" + patientName + ", patientDob=" + patientDob + ", patientDod=" + patientDod
				+ ", patientSsn=" + patientSsn + ", qmbStatus=" + qmbStatus + ", patientGender=" + patientGender
				+ ", patientHeight=" + patientHeight + ", patientWeight=" + patientWeight + ", patientContact1="
				+ patientContact1 + ", patientContact2=" + patientContact2 + ", email=" + email + ", fax=" + fax
				+ ", hipaaOnFileStatus=" + hipaaOnFileStatus + ", branchId=" + branchId + ", branchName=" + branchName
				+ ", documentTypeId=" + documentTypeId + ", documentTypeName=" + documentTypeName + ", documentDate="
				+ documentDate + ", documentNote=" + documentNote + ", documentTitle=" + documentTitle
				+ ", documentName=" + documentName + ", scanBy=" + scanBy + ", fileUploadPath=" + fileUploadPath
				+ ", uploadDate=" + uploadDate + ", uploadBy=" + uploadBy + ", scanDate=" + scanDate + ", reviewStatus="
				+ reviewStatus + ", reviewReason=" + reviewReason + ", reviewDate=" + reviewDate + ", reviewBy="
				+ reviewBy + ", status=" + status + ", createdById=" + createdById + ", createdByName=" + createdByName
				+ ", createdDate=" + createdDate + ", updatedById=" + updatedById + ", updatedByName=" + updatedByName
				+ ", updatedDate=" + updatedDate + ", salesOderId=" + salesOrderId + ", salesOderNo=" + salesOrderNo
				+ ", salesOrderCreationDate=" + salesOrderCreationDate + ", salesOrderDocumentsUuid="
				+ salesOrderDocumentsUuid + "]";
	}

    // prettier-ignore
    
}
