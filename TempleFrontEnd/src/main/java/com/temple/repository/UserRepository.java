package com.temple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temple.model.User;
@Repository
public interface UserRepository extends JpaRepository<User , Integer>{

}