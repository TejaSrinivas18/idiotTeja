package com.temple.service;

import java.io.IOException;
import java.util.List;

//import com.itextpdf.barcodes.qrcode.WriterException;
import com.temple.model.Booking;

public interface BookingService {

	Booking addBooking(Booking booking) throws com.google.zxing.WriterException, IOException ;

	List<Booking> getAllBookings();

	Booking getBookingById(Integer bookingId);

}
