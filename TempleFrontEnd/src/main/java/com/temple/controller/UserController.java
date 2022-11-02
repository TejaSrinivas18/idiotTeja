package com.temple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.User;
import com.temple.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*******************************************************************************************************
	 - Function Name	:	addUser(@Validated @RequestBody User user)
	 - Input Parameters	:	User user
	 - Return Type		:	ResponseEntity<User>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding User to database calls service method addUser(user)
	 ********************************************************************************************************/
	//adding user
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Validated @RequestBody User user) {
		User user1 = userService.addUser(user);
		
		log.info("User record added successfully");
		return new ResponseEntity<>(user1,HttpStatus.CREATED);
	}
	
	/*******************************************************************************************************
	 - Function Name	:	getAllUsers()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<User>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllUsers()
	 ********************************************************************************************************/
	//retrieve users
	@GetMapping("/retrieveUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> user = userService.getAllUsers();
		
		log.info("retrieved all User records successfully");
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	/*******************************************************************************************************
	 - Function Name	:	getUserById(@PathVariable("userId") Integer userId)
	 - Input Parameters	:	Integer userId
	 - Return Type		:	ResponseEntity<User>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getUserById(userId)
	 ********************************************************************************************************/
	//retrieve user by id
	@GetMapping("/retrieveUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		User user = userService.getUserById(userId);
		
		log.info("retrieved  User record successfully");
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	/*******************************************************************************************************
	 - Function Name	:	updateUser(@PathVariable("userId") Integer userId,@PathVariable("update") String update, @RequestBody User user)
	 - Input Parameters	:	Integer userId,String update,User user
	 - Return Type		:	ResponseEntity<User>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method updateUserPassword(userId,user),updateUserRole(userId,user),updateUserEnabled(userId,user),updateUserName(userId,user)
	 ********************************************************************************************************/
	// update user
	@PutMapping("/updateUser/{userId}/{update}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId,@PathVariable("update") String update, @RequestBody User user){
		
		if(update.equalsIgnoreCase("UserPassword")) {
		    User user1 = userService.updateUserPassword(userId,user);
		
		    log.info("UserPassword updated successfully");
		    return new ResponseEntity<>(user1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("UserRole")) {
			User user1 = userService.updateUserRole(userId,user);
			
		    log.info("UserRole updated successfully");
		    return new ResponseEntity<>(user1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("UserEnabled")) {
			User user1 = userService.updateUserEnabled(userId,user);
			
		    log.info("UserEnabled updated successfully");
		    return new ResponseEntity<>(user1, HttpStatus.OK);
		}
		else if (update.equalsIgnoreCase("UserName")) {
			User user1 = userService.updateUserName(userId,user);
			
		    log.info("UserName updated successfully");
		    return new ResponseEntity<>(user1, HttpStatus.OK);
		}
		else {
			log.error("BAD CREDENTIALS");

			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	/*******************************************************************************************************
	 - Function Name	:	deleteUser(@PathVariable("userId") Integer userId)
	 - Input Parameters	:	Integer userId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method deleteUser(userId)
	 ********************************************************************************************************/
	// deleteById
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
		
		log.info("User record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
