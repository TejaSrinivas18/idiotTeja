package com.temple.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
public class Temple extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle6")
	@SequenceGenerator(name = "oracle6",sequenceName = "temple_seq4",allocationSize = 1)//701
	@Column(name = "templeId")
	private Integer templeId;
	
	@NotBlank(message = "TempleName should not be null")
	@Pattern(regexp = "^[A-Za-z\\s]{5,25}$", 
			message = "templeName Should Be In Alphabets and minimum 5 characters and maximum 25 characters")
	@Column(name = "templeName")
	private String templeName;
	
	@Lob
	@NotBlank(message = "TempleHistory should not be null")
	@Column(name = "templeHistory")
	private String templeHistory;
	
	//@JsonManagedReference
	@OneToOne//(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "placeId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Place place;
	
	@OneToOne
	@JoinColumn(name = "timingId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Timings timing;
	
	@ManyToMany
	//@JoinColumn(name = "ticketId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private List<TicketDetails> ticketDetails;
	
	@OneToMany
	//@JoinColumn(name = "devoteeId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private List<DevoteeFunds> devoteeFunds;
	
	@OneToOne
	@JoinColumn(name = "festivalId")
    //@OnDelete(action = OnDeleteAction.CASCADE)
	private Festival festival;
	
	@ManyToMany
	//@JoinColumn(name = "poojaId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
    private List<PoojaDetails> poojaDetails;

//	public Temple(int templeId, String templeName, String templeHistory, Place place, Timings timing,
//			com.temple.model.TicketDetails ticketDetails, DevoteeFunds devoteeFunds, Festival festival,
//			PoojaDetails poojaDetails) {
//		super();
//		this.templeId = templeId;
//		this.templeName = templeName;
//		this.templeHistory = templeHistory;
//		this.place = place;
//		this.timing = timing;
//		TicketDetails = ticketDetails;
//		this.devoteeFunds = devoteeFunds;
//		this.festival = festival;
//		this.poojaDetails = poojaDetails;
//	}
//
//	public Temple() {
//		super();
//	}
//
//	public int getTempleId() {
//		return templeId;
//	}
//
//	public void setTempleId(int templeId) {
//		this.templeId = templeId;
//	}
//
//	public String getTempleName() {
//		return templeName;
//	}
//
//	public void setTempleName(String templeName) {
//		this.templeName = templeName;
//	}
//
//	public String getTempleHistory() {
//		return templeHistory;
//	}
//
//	public void setTempleHistory(String templeHistory) {
//		this.templeHistory = templeHistory;
//	}
//
//	public Place getPlace() {
//		return place;
//	}
//
//	public void setPlace(Place place) {
//		this.place = place;
//	}
//
//	public Timings getTiming() {
//		return timing;
//	}
//
//	public void setTiming(Timings timing) {
//		this.timing = timing;
//	}
//
//	public TicketDetails getTicketDetails() {
//		return TicketDetails;
//	}
//
//	public void setTicketDetails(TicketDetails ticketDetails) {
//		TicketDetails = ticketDetails;
//	}
//
//	public DevoteeFunds getDevoteeFunds() {
//		return devoteeFunds;
//	}
//
//	public void setDevoteeFunds(DevoteeFunds devoteeFunds) {
//		this.devoteeFunds = devoteeFunds;
//	}
//
//	public Festival getFestival() {
//		return festival;
//	}
//
//	public void setFestival(Festival festival) {
//		this.festival = festival;
//	}
//
//	public PoojaDetails getPoojaDetails() {
//		return poojaDetails;
//	}
//
//	public void setPoojaDetails(PoojaDetails poojaDetails) {
//		this.poojaDetails = poojaDetails;
//	}
//
//	@Override
//	public String toString() {
//		return "Temple [templeId=" + templeId + ", templeName=" + templeName + ", templeHistory=" + templeHistory
//				+ ", place=" + place + ", timing=" + timing + ", TicketDetails=" + TicketDetails + ", devoteeFunds="
//				+ devoteeFunds + ", festival=" + festival + ", poojaDetails=" + poojaDetails + "]";
//	}	
	
}
