package com.temple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temple.model.PoojaDetails;
@Repository
public interface PoojaDetailsRepository extends JpaRepository<PoojaDetails, Integer>{

}
