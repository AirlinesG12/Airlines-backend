package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.repository.UserRepository;

@Service
public class UserSeviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public long addAUser(User user) {

		return userRepository.addAUser(user);
	}

	public User findUserById(long userId) {
		return userRepository.findUserById(userId);
	}

	public List<User> viewAllUsers() {
		return userRepository.viewAllUsers();
	}
	public boolean isValidUser(String userEmail, String userPassword) {
		return userRepository.isValidUser(userEmail, userPassword);
	}
//	public User isValidUser(String userEmail, String userPassword) {
//		return userRepository.isValidUser(userEmail, userPassword);
//	}
	public String findUserNameByEmailId(String userEmail) {
		return userRepository.findUserNameByEmailId(userEmail);
	}
	public String resetPassword(String userEmail,String userPassword) {
		return userRepository.resetPassword(userEmail, userPassword);
	}


}
