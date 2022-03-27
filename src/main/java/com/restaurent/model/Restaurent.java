package com.restaurent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Restaurent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@JsonProperty("name")
	private String restaurentName;
	
	@JsonProperty("email")
	private String restaurentEmail;
	
	@JsonProperty("mobile")
	private long restaurentMobile;
	
	@JsonProperty("address")
	private String restaurentAddress;
	
	@JsonProperty("services")
	private String restaurentServices;
}
