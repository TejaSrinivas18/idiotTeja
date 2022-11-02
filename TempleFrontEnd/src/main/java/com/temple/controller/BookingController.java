package com.temple.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.barcodes.qrcode.WriterException;
import com.temple.model.Booking;
import com.temple.service.BookingService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api/user")
@RestController
public class BookingController{
	
	@Autowired
	private BookingService bookingService;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addBooking(@Validated @RequestBody Booking booking)
	 - Input Parameters	:	Booking booking
	 - Return Type		:	ResponseEntity<Booking>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding booking to database calls service method addBooking(booking)
	 * @throws com.google.zxing.WriterException 
	 * @throws IOException 
	 ********************************************************************************************************/
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@Validated @RequestBody Booking booking) throws com.google.zxing.WriterException, IOException  {

		Booking booking1 = bookingService.addBooking(booking);
		
		log.info("Booking record added successfully");
		return new ResponseEntity<>(booking1, HttpStatus.CREATED);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getAllBookings()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<Booking>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllBookings()
	 ********************************************************************************************************/
	@GetMapping("/retrieveBookings")
	public ResponseEntity<List<Booking>> getAllBookings() {
		
		List<Booking> booking =bookingService.getAllBookings();
		
		log.info("retrieved all Booking records successfully");
		return new ResponseEntity<>(booking,HttpStatus.OK );
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	getBookingById(@PathVariable Integer bookingId)
	 - Input Parameters	:	Integer bookingId
	 - Return Type		:	ResponseEntity<Booking>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getBookingById(bookingId)
	 ********************************************************************************************************/
	@GetMapping("/retrieveBookingById/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Integer bookingId) {
		
		Booking booking =bookingService.getBookingById(bookingId);
		
		log.info("retrieved Booking record successfully");
		return new ResponseEntity<>(booking,HttpStatus.OK );
	}
}
