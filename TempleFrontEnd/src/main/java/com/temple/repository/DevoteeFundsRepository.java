package com.temple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temple.model.DevoteeFunds;

@Repository
public interface DevoteeFundsRepository extends JpaRepository<DevoteeFunds, Integer>{

}
