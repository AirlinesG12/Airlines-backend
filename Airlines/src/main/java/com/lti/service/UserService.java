package com.lti.service;

import java.util.List;

import com.lti.entity.User;

public interface UserService {

	long addAUser(User user);
	User findUserById(long userId);
	List<User> viewAllUsers();
	boolean isValidUser(String userEmail,String userPassword);
//	User isValidUser(String userEmail,String userPassword);
	String findUserNameByEmailId(String userEmail);
    String resetPassword(String userEmail,String userPassword);
}
