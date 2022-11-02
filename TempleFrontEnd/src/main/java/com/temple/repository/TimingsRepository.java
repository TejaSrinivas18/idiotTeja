package com.temple.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temple.model.Timings;

@Repository
public interface TimingsRepository extends JpaRepository<Timings, Integer>{

}