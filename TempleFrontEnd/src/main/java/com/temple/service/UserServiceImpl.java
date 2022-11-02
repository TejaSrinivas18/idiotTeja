package com.temple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.User;
import com.temple.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	/*******************************************************************************************************
	 - Function Name	:	addUser(User user)
	 - Input Parameters	:	User user
	 - Return Type		:	User
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	Adding User Record to the Database
	 ********************************************************************************************************/
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteUser(Integer userId)
	 - Input Parameters	:	Integer userId
	 - Return Type		:	void
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	deleting User Record from the Database based on userId
	 ********************************************************************************************************/
	@Override
	public void deleteUser(Integer userId) {
		
		if (!userRepository.existsById(userId)) {
			log.error("No user found with id" + userId);
			throw new ResourceNotFoundException("No user found with id" + userId);			
		}
		
		userRepository.deleteById(userId);		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllUsers()
	 - Input Parameters	:	
	 - Return Type		:	List<User>
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving All User Records from the Database based on userId
	 ********************************************************************************************************/
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateUserPassword(Integer userId, User user)
	 - Input Parameters	:	Integer userId, User user
	 - Return Type		:	User
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating UserPassword  to the Database based on userId
	 ********************************************************************************************************/
	@Override
	public User updateUserPassword(Integer userId, User user) {
		if (!userRepository.existsById(userId)) {
			log.error("No user found with id" + userId);
			throw new ResourceNotFoundException("No user found with id" + userId);			
		}
		
		User user1 = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not found user with id " + userId));
		user1.setUserPassword(user.getUserPassword());
		
		return userRepository.save(user1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getUserById(Integer userId)
	 - Input Parameters	:	Integer userId
	 - Return Type		:	User
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	retrieving User record from the Database based on userId
	 ********************************************************************************************************/
	@Override
	public User getUserById(Integer userId) {
		
		if (!userRepository.existsById(userId)) {
			log.error("No user found with id" + userId);
			throw new ResourceNotFoundException("No user found with id" + userId);			
		}
		
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not found user with id " + userId));
		return user;
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateUserRole(Integer userId, User user)
	 - Input Parameters	:	Integer userId, User user
	 - Return Type		:	User
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating UserRole to the Database based on userId
	 ********************************************************************************************************/
	@Override
	public User updateUserRole(Integer userId, User user) {
		if (!userRepository.existsById(userId)) {
			log.error("No user found with id" + userId);
			throw new ResourceNotFoundException("No user found with id" + userId);			
		}
		
		User user1 = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not found user with id " + userId));
		user1.setUserRole(user.getUserRole());
		return userRepository.save(user1);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateUserEnabled(Integer userId, User user)
	 - Input Parameters	:	Integer userId, User user
	 - Return Type		:	User
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating Enabled to the Database based on userId
	 ********************************************************************************************************/
	@Override
	public User updateUserEnabled(Integer userId, User user) {
		if (!userRepository.existsById(userId)) {
			log.error("No user found with id" + userId);
			throw new ResourceNotFoundException("No user found with id" + userId);			
		}
		
		User user1 = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not found user with id " + userId));
		user1.setEnabled(user.getEnabled());
		return userRepository.save(user1);
		
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateUserName(Integer userId, User user)
	 - Input Parameters	:	Integer userId, User user
	 - Return Type		:	User
	 - Throws			:   ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	updating UserName to the Database based on userId
	 ********************************************************************************************************/
	@Override
	public User updateUserName(Integer userId, User user) {
		if (!userRepository.existsById(userId)) {
			log.error("No user found with id" + userId);
			throw new ResourceNotFoundException("No user found with id" + userId);			
		}
		
		User user1 = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not found user with id " + userId));
		user1.setUserName(user.getUserName());
		return userRepository.save(user1);
		
	}

	//.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

}
