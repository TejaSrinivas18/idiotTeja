package com.temple.service;

import java.util.List;

import com.temple.model.TicketDetails;

public interface TicketDetailsService {

	TicketDetails addTicketDetails(TicketDetails ticketDetails);

	List<TicketDetails> getAllTicketDetails();

	void deleteTicket(Integer ticketId);

	TicketDetails updateTicketType(Integer ticketId, TicketDetails ticketDetails);

	TicketDetails updateTicketPrice(Integer ticketId, TicketDetails ticketDetails);

	TicketDetails getTicketDetailsById(Integer ticketId);

}

