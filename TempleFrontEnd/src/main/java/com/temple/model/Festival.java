package com.temple.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
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
public class Festival extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle3")
	@SequenceGenerator(name = "oracle3",sequenceName = "fest_seq1",allocationSize = 1)//201
	private Integer festivalId;
	
	@NotBlank(message = "FestivalName should not be null")
	@Pattern(regexp = "^[A-Za-z\\s]{5,25}$", 
			message = "festivalName Should Be In Alphabets and minimum 5 characters and maximum 15 characters")
	private String festivalName;
	
	@Temporal(TemporalType.DATE)
	private Date festivalDate;
	@NotBlank(message = "festivalStartTime should not be null")
	private String festivalStartTime;
	@NotBlank(message = "festivalEndTime should not be null")
	private String festivalEndTime;
	
//	public Festival(int festivalId, String festivalName, Date festivalDate, String festivalStartTime,
//			String festivalEndTime) {
//		super();
//		this.festivalId = festivalId;
//		this.festivalName = festivalName;
//		this.festivalDate = festivalDate;
//		this.festivalStartTime = festivalStartTime;
//		this.festivalEndTime = festivalEndTime;
//	}
//
//	public Festival() {
//		super();
//	}
//
//	public int getFestivalId() {
//		return festivalId;
//	}
//
//	public void setFestivalId(int festivalId) {
//		this.festivalId = festivalId;
//	}
//
//	public String getFestivalName() {
//		return festivalName;
//	}
//
//	public void setFestivalName(String festivalName) {
//		this.festivalName = festivalName;
//	}
//
//	public Date getFestivalDate() {
//		return festivalDate;
//	}
//
//	public void setFestivalDate(Date festivalDate) {
//		this.festivalDate = festivalDate;
//	}
//
//	public String getFestivalStartTime() {
//		return festivalStartTime;
//	}
//
//	public void setFestivalStartTime(String festivalStartTime) {
//		this.festivalStartTime = festivalStartTime;
//	}
//
//	public String getFestivalEndTime() {
//		return festivalEndTime;
//	}
//
//	public void setFestivalEndTime(String festivalEndTime) {
//		this.festivalEndTime = festivalEndTime;
//	}
//
//	@Override
//	public String toString() {
//		return "Festival [festivalId=" + festivalId + ", festivalName=" + festivalName + ", festivalDate="
//				+ festivalDate + ", festivalStartTime=" + festivalStartTime + ", festivalEndTime=" + festivalEndTime
//				+ "]";
//	}	
	
}