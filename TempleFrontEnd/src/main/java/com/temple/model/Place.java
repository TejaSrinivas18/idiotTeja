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
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Place extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle4")
	@SequenceGenerator(name = "oracle4",sequenceName = "place_seq5",allocationSize = 1)//301
	private Integer placeId;	
	@NotBlank(message = "street should not be null")
	private String street;
	@NotBlank(message = "area should not be null")
	private String area;
	@NotBlank(message = "city should not be null")
	private String city;
	@NotBlank(message = "state should not be null")
	private String state;
	@NotBlank(message = "pincode should not be null")
	private String pincode;
	
	//@JsonBackReference
	//@OneToOne(mappedBy = "place")
	//private Temple temple;

//	public Place() {
//		super();
//	}
//
//	public Place(int placeId, String street, String city, String pincode) {
//		super();
//		this.placeId = placeId;
//		this.street = street;
//		this.city = city;
//		this.pincode = pincode;
//	}
//
//	public int getPlaceId() {
//		return placeId;
//	}
//
//	public void setPlaceId(int placeId) {
//		this.placeId = placeId;
//	}
//
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//
//	@Override
//	public String toString() {
//		return "Place [placeId=" + placeId + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
//	}	  
//	
}
