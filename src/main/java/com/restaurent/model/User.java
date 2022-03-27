package com.restaurent.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonProperty("name")
	private String userName;
	
	@JsonProperty("mobile")
	private long userMobile;
	
	@JsonProperty("email")
	private String userEmail;
	
	@JsonProperty("password")
	private String userPassword;
	
}
