package com.lti.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserResource {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public User addAUser(@RequestBody User user) {
		long userId = userService.addAUser(user);
		User user1 = userService.findUserById(userId);
		return user1;

	}
	@GetMapping(value="/findUserById/{uid}")
	public User findUserById(@PathVariable("uid") long userId) {
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value="/viewAllUsers",method=RequestMethod.GET)
	public List<User> viewAllUsers() {
		return userService.viewAllUsers();
	}
	
	@RequestMapping(value = "/validUser/{userEmail}/{userPassword}" )
	public boolean validUser(@PathVariable("userEmail") String userEmail,@PathVariable("userPassword") String userPassword) {
		return userService.isValidUser(userEmail,userPassword);
	}
//	@RequestMapping(value = "/validUser/{userEmail}/{userPassword}" )
//	public User validUser(@PathVariable("userEmail") String userEmail,@PathVariable("userPassword") String userPassword) {
//		return userService.isValidUser(userEmail,userPassword);
//	}
	
	@RequestMapping(value = "/findUserNameByEmailId/{userEmail}" )
	public String findUserNameByEmailId(@PathVariable("userEmail") String userEmail) {
		return userService.findUserNameByEmailId(userEmail);
	}
	@RequestMapping(value = "/findUserIdByEmailId/{userEmail}" )
	public long findUserIdByEmailId(@PathVariable("userEmail") String userEmail) {
		return userService.findUserIdByEmailId(userEmail);
	}
	@RequestMapping(value = "/resetPassword/{userEmail}/{userPassword}" )
	public boolean resetPassword(@PathVariable("userEmail") String userEmail,@PathVariable("userPassword") String userPassword) {
		return userService.resetPassword(userEmail,userPassword);
	}
	
	@RequestMapping(value = "/findEmail/{userEmail}" )
	public boolean checkEmail(@PathVariable("userEmail") String userEmail) {
		return userService.checkEmail(userEmail);
	}
	
}
