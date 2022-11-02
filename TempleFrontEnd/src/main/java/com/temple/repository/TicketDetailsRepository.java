package com.temple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temple.model.TicketDetails;

@Repository
public interface TicketDetailsRepository extends JpaRepository<TicketDetails, Integer>{

}

