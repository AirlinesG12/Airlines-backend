package com.lti.entity;

import java.time.LocalDate;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@SequenceGenerator(name = "seq_user", initialValue = 10001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	long userId;

	String firstName;
	String lastName;
	String userPassword;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	LocalDate userDateOfBirth;
	String userEmail;
	String userMobile;

	/*
	 * @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	 * List<Bookings>booking;
	 */

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Bookings> bookings;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDate getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(LocalDate userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserModile(String userMobile) {
		this.userMobile = userMobile;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userPassword="
				+ userPassword + ", userDateOfBirth=" + userDateOfBirth + ", userEmail=" + userEmail + ", userModile="
				+ userMobile + "]";
	}

}
