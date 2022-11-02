package com.temple.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.itextpdf.barcodes.qrcode.WriterException;
import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Booking;
import com.temple.repository.BookingRepository;
import com.temple.util.GenerateQRCode;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired 
	private EmailService email;
	
	/*******************************************************************************************************
	 - Function Name	:	addBooking(Booking booking) 
	 - Input Parameters	:	Booking booking
	 - Return Type		:	Booking
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding Booking Record to the Database
	 * @throws IOException 
	 * @throws com.google.zxing.WriterException 
	 ********************************************************************************************************/
	@Override
	public Booking addBooking(Booking booking) throws com.google.zxing.WriterException, IOException 
	{
		
		Booking booking1=new Booking();
		booking1.setAmount(booking.getAmount());
		booking1.setBookingId(booking.getBookingId());
		booking1.setTempleId(booking.getTempleId());
		booking1.setModeOfPayment(booking.getModeOfPayment());
		booking1.setTicketType(booking.getTicketType());
		booking1.setUser(booking.getUser());
		booking1.setBookingDate(LocalDate.now());
		booking1.setFromDate(booking.getFromDate());
		//booking1.setToDate(booking.getToDate());
		booking1.setEmail(booking.getEmail());
		
		LocalDate presentDate=LocalDate.now();
		LocalDate pastDate=presentDate.minusDays(1);
		LocalDate fromDate=booking.getFromDate();
		//LocalDate bookingDate=booking.getBookingDate();
		
		if(fromDate.isAfter(pastDate))
		{
			
			Booking b = bookingRepository.save(booking1);
			
			String qrCodeText = "Booked Ticket Type "+b.getTicketType()+" and amount paid= "+b.getAmount();
			
			String filePath = "./src/main/resources/qrcodes/"+b.getBookingId()+".png";
			int size = 125;
			String fileType = "png";
			File qrFile = new File(filePath);
			File file= GenerateQRCode.createQRImage(qrFile, qrCodeText, size, fileType);
			System.out.println("DONE");
			
			String s="Booked TicketType at "+b.getTempleId()+" and your Ticket Type is "+b.getTicketType() ;
			
			email.sendSimpleMessage(b.getEmail(), "Booking",s);

			log.info("Booking Successfull");
			return b;
		}
		else
		{
			log.error("Date should be present or future");
			throw new ResourceNotFoundException("Date should be present or future");
		}
	
	}
    
	
	/*******************************************************************************************************
	 - Function Name	:	getAllBookings() 
	 - Input Parameters	:	
	 - Return Type		:	List<Booking>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving all Booking Records from the Database
	 ********************************************************************************************************/
	@Override
	public List<Booking> getAllBookings() {	
		
		return bookingRepository.findAll();
	}
    
	
	/*******************************************************************************************************
	 - Function Name	:	getBookingById(Integer bookingId) 
	 - Input Parameters	:	Integer bookingId
	 - Return Type		:	Booking
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving Booking Record from the Database based on bookingId
	 ********************************************************************************************************/
	@Override
	public Booking getBookingById(Integer bookingId) {
		
		return bookingRepository.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Not found booking with bookingId " + bookingId));
	}

}
