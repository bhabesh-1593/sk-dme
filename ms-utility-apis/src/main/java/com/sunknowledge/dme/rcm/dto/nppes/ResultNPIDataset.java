package com.sunknowledge.dme.rcm.dto.nppes;

import java.util.List;

import lombok.Data;

@Data
public class ResultNPIDataset {
	private Integer resultCount;
	private String npiNumber;
	private String enumerationType;
	private String npiName;
	private String address;
	private String phone;
	private Taxonomy primaryTaxonomy;
	private Boolean status;
	private List<ErrorMessage> error;

	private List<Address> addressList;
	private Basic basicDetails;
	private List<OtherName> otherNamesList;
	private List<Endpoint> endpoints;
	private List<PracticeLocation> practiceLocations;
}
