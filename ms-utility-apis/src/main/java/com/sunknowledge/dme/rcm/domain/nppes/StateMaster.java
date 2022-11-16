package com.sunknowledge.dme.rcm.domain.nppes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "t_npi_state_master")
@Data
public class StateMaster implements Serializable {
	public static final long serialVersionUID = -4968523739920970276L;
	@ApiModelProperty(value = "State")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	private Long stateId;

	@ApiModelProperty(hidden = true)
	@Column(name = "state_code")
	private String stateCode;

	@ApiModelProperty(hidden = true)
	@Column(name = "state_name")
	private String stateName;
}
