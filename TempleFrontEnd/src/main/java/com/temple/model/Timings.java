package com.temple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

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
public class Timings extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle8")
	@SequenceGenerator(name = "oracle8",sequenceName = "timings_seq4",allocationSize = 1)//601
	private Integer timingId;
	@NotBlank(message = "openingTime should not be null")
	private String openingTime;
	@NotBlank(message = "closingTime should not be null")
	private String closingTime;
	
//	public Timings(int timingId, String openingTime, String closingTime) {
//		super();
//		this.timingId = timingId;
//		this.openingTime = openingTime;
//		this.closingTime = closingTime;
//	}
//
//	public Timings() {
//		super();
//	}
//
//	public int getTimingId() {
//		return timingId;
//	}
//
//	public void setTimingId(int timingId) {
//		this.timingId = timingId;
//	}
//
//	public String getOpeningTime() {
//		return openingTime;
//	}
//
//	public void setOpeningTime(String openingTime) {
//		this.openingTime = openingTime;
//	}
//
//	public String getClosingTime() {
//		return closingTime;
//	}
//
//	public void setClosingTime(String closingTime) {
//		this.closingTime = closingTime;
//	}
//
//	@Override
//	public String toString() {
//		return "Timings [timingId=" + timingId + ", openingTime=" + openingTime + ", closingTime=" + closingTime + "]";
//	}
	
}