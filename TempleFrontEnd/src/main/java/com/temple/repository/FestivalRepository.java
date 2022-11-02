package com.temple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temple.model.Festival;
@Repository
public interface FestivalRepository extends JpaRepository<Festival, Integer>{

}
