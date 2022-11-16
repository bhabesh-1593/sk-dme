package com.sunknowledge.changehealthcare.pojo.elligibility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "statusCode", "status", "serviceTypeCodes" })
@Generated("jsonschema2pojo")
public class Planstatus {

	@JsonProperty("statusCode")
	private String statusCode;
	@JsonProperty("status")
	private String status;
	@JsonProperty("serviceTypeCodes")
	private List<String> serviceTypeCodes = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("statusCode")
	public String getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("serviceTypeCodes")
	public List<String> getServiceTypeCodes() {
		return serviceTypeCodes;
	}

	@JsonProperty("serviceTypeCodes")
	public void setServiceTypeCodes(List<String> serviceTypeCodes) {
		this.serviceTypeCodes = serviceTypeCodes;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}