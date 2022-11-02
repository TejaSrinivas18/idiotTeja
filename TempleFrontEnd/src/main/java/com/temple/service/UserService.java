package com.temple.service;

import java.util.List;

import com.temple.model.User;

public interface UserService {

	User addUser(User user);

	void deleteUser(Integer userId);

	List<User> getAllUsers();

	User updateUserPassword(Integer userId, User user);

	User getUserById(Integer userId);

	User updateUserRole(Integer userId, User user);

	User updateUserEnabled(Integer userId, User user);

	User updateUserName(Integer userId, User user);

	

}