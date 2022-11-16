package com.sunknowledge.changehealthcare.pojo.professionalclaims;

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
	"error",
	"error_description",
	"traceId"
})
@Generated("jsonschema2pojo")
public class AccessTokenError {
	@JsonProperty("error")
	private String error;
	@JsonProperty("error_description")
	private String errorDescription;
	@JsonProperty("traceId")
	private String traceId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("error")
	public String getError() {
		return error;
	}

	@JsonProperty("error")
	public void setError(String error) {
		this.error = error;
	}

	@JsonProperty("error_description")
	public String getErrorDescription() {
		return errorDescription;
	}

	@JsonProperty("error_description")
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@JsonProperty("traceId")
	public String getTraceId() {
		return traceId;
	}

	@JsonProperty("traceId")
	public void setTraceId(String traceId) {
		this.traceId = traceId;
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
