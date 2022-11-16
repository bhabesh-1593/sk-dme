package com.sunknowledge.dme.rcm.dto.nppes;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"first_name",
	"last_name",
	"middle_name",
	"credential",
	"sole_proprietor",
	"gender",
	"enumeration_date",
	"last_updated",
	"status",
	"name",
	"certification_date",

	"organization_name",
	"organizational_subpart",
	"authorized_official_first_name",
	"authorized_official_last_name",
	"authorized_official_middle_name",
	"authorized_official_telephone_number",
	"authorized_official_title_or_position",
	"authorized_official_name_suffix"
})
@Generated("jsonschema2pojo")
public class Basic {
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("middle_name")
	private String middleName;
	@JsonProperty("credential")
	private String credential;
	@JsonProperty("sole_proprietor")
	private String soleProprietor;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("enumeration_date")
	private String enumerationDate;
	@JsonProperty("last_updated")
	private String lastUpdated;
	@JsonProperty("status")
	private String status;
	@JsonProperty("name")
	private String name;
	@JsonProperty("certification_date")
	private String certificationDate;
	@JsonProperty("organization_name")
	private String organizationName;
	@JsonProperty("organizational_subpart")
	private String organizationalSubpart;
	@JsonProperty("authorized_official_first_name")
	private String authorizedOfficialFirstName;
	@JsonProperty("authorized_official_last_name")
	private String authorizedOfficialLastName;
	@JsonProperty("authorized_official_middle_name")
	private String authorizedOfficialMiddleName;
	@JsonProperty("authorized_official_telephone_number")
	private String authorizedOfficialTelephoneNumber;
	@JsonProperty("authorized_official_title_or_position")
	private String authorizedOfficialTitleOrPosition;
	@JsonProperty("authorized_official_name_suffix")
	private String authorizedOfficialNameSuffix;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("middle_name")
	public String getMiddleName() {
		return middleName;
	}

	@JsonProperty("middle_name")
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@JsonProperty("credential")
	public String getCredential() {
		return credential;
	}

	@JsonProperty("credential")
	public void setCredential(String credential) {
		this.credential = credential;
	}

	@JsonProperty("sole_proprietor")
	public String getSoleProprietor() {
		return soleProprietor;
	}

	@JsonProperty("sole_proprietor")
	public void setSoleProprietor(String soleProprietor) {
		this.soleProprietor = soleProprietor;
	}

	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty("enumeration_date")
	public String getEnumerationDate() {
		return enumerationDate;
	}

	@JsonProperty("enumeration_date")
	public void setEnumerationDate(String enumerationDate) {
		this.enumerationDate = enumerationDate;
	}

	@JsonProperty("last_updated")
	public String getLastUpdated() {
		return lastUpdated;
	}

	@JsonProperty("last_updated")
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("certification_date")
	public String getCertificationDate() {
		return certificationDate;
	}

	@JsonProperty("certification_date")
	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonProperty("organization_name")
	public String getOrganizationName() {
		return organizationName;
	}

	@JsonProperty("organization_name")
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@JsonProperty("organizational_subpart")
	public String getOrganizationalSubpart() {
		return organizationalSubpart;
	}

	@JsonProperty("organizational_subpart")
	public void setOrganizationalSubpart(String organizationalSubpart) {
		this.organizationalSubpart = organizationalSubpart;
	}

	@JsonProperty("authorized_official_first_name")
	public String getAuthorizedOfficialFirstName() {
		return authorizedOfficialFirstName;
	}

	@JsonProperty("authorized_official_first_name")
	public void setAuthorizedOfficialFirstName(String authorizedOfficialFirstName) {
		this.authorizedOfficialFirstName = authorizedOfficialFirstName;
	}

	@JsonProperty("authorized_official_last_name")
	public String getAuthorizedOfficialLastName() {
		return authorizedOfficialLastName;
	}

	@JsonProperty("authorized_official_last_name")
	public void setAuthorizedOfficialLastName(String authorizedOfficialLastName) {
		this.authorizedOfficialLastName = authorizedOfficialLastName;
	}

	@JsonProperty("authorized_official_middle_name")
	public String getAuthorizedOfficialMiddleName() {
		return authorizedOfficialMiddleName;
	}

	@JsonProperty("authorized_official_middle_name")
	public void setAuthorizedOfficialMiddleName(String authorizedOfficialMiddleName) {
		this.authorizedOfficialMiddleName = authorizedOfficialMiddleName;
	}

	@JsonProperty("authorized_official_telephone_number")
	public String getAuthorizedOfficialTelephoneNumber() {
		return authorizedOfficialTelephoneNumber;
	}

	@JsonProperty("authorized_official_telephone_number")
	public void setAuthorizedOfficialTelephoneNumber(String authorizedOfficialTelephoneNumber) {
		this.authorizedOfficialTelephoneNumber = authorizedOfficialTelephoneNumber;
	}

	@JsonProperty("authorized_official_title_or_position")
	public String getAuthorizedOfficialTitleOrPosition() {
		return authorizedOfficialTitleOrPosition;
	}

	@JsonProperty("authorized_official_title_or_position")
	public void setAuthorizedOfficialTitleOrPosition(String authorizedOfficialTitleOrPosition) {
		this.authorizedOfficialTitleOrPosition = authorizedOfficialTitleOrPosition;
	}

	@JsonProperty("authorized_official_name_suffix")
	public String getAuthorizedOfficialNameSuffix() {
		return authorizedOfficialNameSuffix;
	}

	@JsonProperty("authorized_official_name_suffix")
	public void setAuthorizedOfficialNameSuffix(String authorizedOfficialNameSuffix) {
		this.authorizedOfficialNameSuffix = authorizedOfficialNameSuffix;
	}
}
