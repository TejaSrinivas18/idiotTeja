package com.temple.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "TempleBooking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle9")
	@SequenceGenerator(name = "oracle9",sequenceName = "booking_seq",allocationSize = 1)
	private Integer bookingId;
	@NotBlank(message = "modeOfPayment should not be null")
	private String modeOfPayment;
	
//	@FutureOrPresent(message = "You are entering a past Date")
//	@Temporal(TemporalType.DATE)
	private LocalDate bookingDate;
	
	private LocalDate fromDate;
	
	@DecimalMin(value = "1.0", message = "Please Enter a valid  Amount")
	@NotNull(message = "amount should not be null")
	private Integer amount;
	
	private String email;
	
	@NotNull(message = "TempleId should not be null")
	private Integer templeId;
	
	@NotBlank(message = "TicketType should not be null")
	private String ticketType;
	
	@ManyToOne
	private User user;
	
}









//@NotNull(message = "value should  not be null")
//@Min(value=1, message=" value should be greater than 0")