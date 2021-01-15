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
	@Autowired
	EmailService emailService;
	

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
	public boolean resetPassword(String userEmail,String userPassword) {
		return userRepository.resetPassword(userEmail, userPassword);
	}
	public long findUserIdByEmailId(String userEmail) {
		return userRepository.findUserIdByEmailId(userEmail);
	}
	public boolean checkEmail(String userEmail) {
		boolean exist= userRepository.checkEmail(userEmail);
		if(exist) {
			
			String subject="password reset request";
			String email=userEmail;
			String text ="Password change link: http://localhost:4200/passwordReset\"";
			emailService.sendEmailForNewRegistration(email, text, subject);
	        System.out.println("Email sent");	
		
		}
		 return userRepository.checkEmail(userEmail);
			
	}

}
