package com.temple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "temple_user")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle1")
	@SequenceGenerator(name = "oracle1",sequenceName = "user_seq4",allocationSize = 1)//1
	private Integer userId;
	
	@NotBlank(message = "userName should not be null")
	@Pattern(regexp = "^[A-Za-z\\s]{5,25}$", 
			message = "userName Should Be In Alphabets and minimum 5 characters and maximum 15 characters")
	private String userName;
	
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$",
//			message = "Password Should Be Greater Than 7 Characters and Atmost 15 Characters and Atleast One Upper Case "
//					+ "and Atleast One Lower Case and Atleast One Digit and Atleast One Special Character" )
	@NotBlank(message = "userPassword should not be null")
	private String userPassword;
	
	@NotBlank(message = "userRole should not be null")
	@Pattern(regexp = "^[A-Za-z]{4,5}$",message = "Role Should be either admin or normal ")
	private String userRole;
	private boolean enabled;
	
	public boolean getEnabled() {
		return enabled;
	}
	
//	@Pattern(regexp = "^[9876]\\d{9}$", message = "Phone Number Should be in 10 digit and it supports indian numbers only")
//	private String userMobileNumber;
//	
//	@Email
//	private String userEmail;	
	

//	public User(int userId, String userName, String userPassword, String userRole, String userMobileNumber,
//			String userEmail) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.userRole = userRole;
//		this.userMobileNumber = userMobileNumber;
//		this.userEmail = userEmail;
//	}
//
//	public User() {
//		super();
//	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getUserPassword() {
//		return userPassword;
//	}
//
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//
//	public String getUserRole() {
//		return userRole;
//	}
//
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}
//
//	public String getUserMobileNumber() {
//		return userMobileNumber;
//	}
//
//	public void setUserMobileNumber(String userMobileNumber) {
//		this.userMobileNumber = userMobileNumber;
//	}
//
//	public String getUserEmail() {
//		return userEmail;
//	}
//
//	public void setUserEmail(String userEmail) {
//		this.userEmail = userEmail;
//	}
//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userRole="
//				+ userRole + ", userMobileNumber=" + userMobileNumber + ", userEmail=" + userEmail + "]";
//	}	
	
}
