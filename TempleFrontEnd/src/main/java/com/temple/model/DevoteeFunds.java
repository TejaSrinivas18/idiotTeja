package com.temple.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DevoteeFunds extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle2")
	@SequenceGenerator(name = "oracle2",sequenceName = "devo_seq1",allocationSize = 1)//101
	@Column(name = "devoteeId")
	private Integer devoteeId;
	
	@NotBlank(message = "DevoteeName should not be null")
	@Pattern(regexp = "^[A-Za-z\\s]{5,25}$", 
			message = "devoteeName Should Be In Alphabets and minimum 5 characters and maximum 15 characters")
	private String devoteeName;
	
	@DecimalMin(value = "1.0", message = "Please Enter a valid  Amount")
	@NotNull(message ="devoteeAmount should not be null")
	private Integer devoteeAmount;
	
	@NotBlank(message = "DevoteeMobileNumber should not be null")
	@Pattern(regexp = "^[+]91[6789]\\d{9}$", 
			message = "Phone Number Should be in 10 digit and it supports indian numbers only")
	private String devoteeMobileNumber;
	
	@NotBlank(message = "devoteeEmail should not be null")
	@Email(message = "Invalid email")
	private String devoteeEmail;

	
//	CREATE SEQUENCE customers_seq
//	 START WITH     1000
//	 INCREMENT BY   1
//	 NOCACHE
//	 NOCYCLE;

//	public DevoteeFunds(int devoteeId, String devoteeName, int devoteeAmount, String devoteeMobileNumber) {
//		super();
//		this.devoteeId = devoteeId;
//		this.devoteeName = devoteeName;
//		this.devoteeAmount = devoteeAmount;
//		this.devoteeMobileNumber = devoteeMobileNumber;
//	}
//	
//	public DevoteeFunds() {
//		super();
//	}
//
//	public int getDevoteeId() {
//		return devoteeId;
//	}
//
//	public void setDevoteeId(int devoteeId) {
//		this.devoteeId = devoteeId;
//	}
//
//	public String getDevoteeName() {
//		return devoteeName;
//	}
//
//	public void setDevoteeName(String devoteeName) {
//		this.devoteeName = devoteeName;
//	}
//
//	public int getDevoteeAmount() {
//		return devoteeAmount;
//	}
//
//	public void setDevoteeAmount(int devoteeAmount) {
//		this.devoteeAmount = devoteeAmount;
//	}
//
//	public String getDevoteeMobileNumber() {
//		return devoteeMobileNumber;
//	}
//
//	public void setDevoteeMobileNumber(String devoteeMobileNumber) {
//		this.devoteeMobileNumber = devoteeMobileNumber;
//	}
//
//	@Override
//	public String toString() {
//		return "DevoteeFunds [devoteeId=" + devoteeId + ", devoteeName=" + devoteeName + ", devoteeAmount="
//				+ devoteeAmount + ", devoteeMobileNumber=" + devoteeMobileNumber + "]";
//	}
	
}