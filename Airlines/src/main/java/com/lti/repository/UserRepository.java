package com.lti.repository;

import java.util.List;

import com.lti.entity.User;

public interface UserRepository {

	long addAUser(User user);
	User findUserById(long userId);
	List<User> viewAllUsers();
	boolean isValidUser(String userEmail,String userPassword);
//	User isValidUser(String userEmail,String userPassword);
	String findUserNameByEmailId(String userEmail);
	boolean resetPassword(String userEmail,String userPassword);
	public long findUserIdByEmailId(String userEmail);
	public boolean checkEmail(String userEmail);
}
