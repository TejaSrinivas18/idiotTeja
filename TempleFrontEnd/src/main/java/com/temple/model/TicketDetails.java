package com.temple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class TicketDetails extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle7")
	@SequenceGenerator(name = "oracle7",sequenceName = "ticket_seq4",allocationSize = 1)//501
	private Integer ticketId;
	
	@NotBlank(message = "TicketType should not be null")
	private String ticketType;

	@DecimalMin(value = "1.0", message = "Please Enter a valid  Amount")
	@NotNull(message = "TicketPrice should not be null")
	private Integer ticketPrice;
	

//	public TicketDetails(int ticketId, int freeEntry, int specialEntry, int vipEntry) {
//		super();
//		this.ticketId = ticketId;
//		this.freeEntry = freeEntry;
//		this.specialEntry = specialEntry;
//		this.vipEntry = vipEntry;
//	}
//
//	public TicketDetails() {
//		super();
//	}
//
//	public int getTicketId() {
//		return ticketId;
//	}
//
//	public void setTicketId(int ticketId) {
//		this.ticketId = ticketId;
//	}
//
//	public int getFreeEntry() {
//		return freeEntry;
//	}
//
//	public void setFreeEntry(int freeEntry) {
//		this.freeEntry = freeEntry;
//	}
//
//	public int getSpecialEntry() {
//		return specialEntry;
//	}
//
//	public void setSpecialEntry(int specialEntry) {
//		this.specialEntry = specialEntry;
//	}
//
//	public int getVipEntry() {
//		return vipEntry;
//	}
//
//	public void setVipEntry(int vipEntry) {
//		this.vipEntry = vipEntry;
//	}
//
//	@Override
//	public String toString() {
//		return "TicketDetails [ticketId=" + ticketId + ", freeEntry=" + freeEntry + ", specialEntry=" + specialEntry + ", vipEntry="
//				+ vipEntry + "]";
//	}	
	
}
