package com.lti.repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public long addAUser(User user) {
		User userNew=em.merge(user);
		return userNew.getUserId();
	}
	
	public User findUserById(long userId) {
		return em.find(User.class, userId);
	}
	public List<User> viewAllUsers() {
		String jpql = "select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> users = query.getResultList();
		return users;
	}
	public boolean isValidUser(String userEmail, String userPassword) {
		try {
			String jpql = "select u from User u where u.userEmail=:umail and u.userPassword=:upass";
			TypedQuery<User> query = em.createQuery(jpql, User.class);     
			query.setParameter("umail", userEmail);
			query.setParameter("upass", userPassword);
			User user = query.getSingleResult();
			if (user != null) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  return false;
		}
	  return false;
	}
//	public User isValidUser(String userEmail, String userPassword) {
//		
//			String jpql = "select u from User u where u.userEmail=:umail and u.userPassword=:upass";
//			TypedQuery<User> query = em.createQuery(jpql, User.class);     
//			query.setParameter("umail", userEmail);
//			query.setParameter("upass", userPassword);
//			User user = query.getSingleResult();
//			return user;
//}
	
	public String findUserNameByEmailId(String userEmail) {
		String jpql = "select u from User u where u.userEmail=:umail";
		TypedQuery<User> query = em.createQuery(jpql, User.class);     
		query.setParameter("umail", userEmail);
		User user = query.getSingleResult();
		return user.getFirstName();

		
	}
	
	public String resetPassword(String userEmail,String userPassword) {
		String jpql = "Update User u set  u.userPassword=:newpass where userEmail=:umail";
		TypedQuery<User> query = em.createQuery(jpql, User.class);     
		query.setParameter("umail", userEmail);
		query.setParameter("newpass", userPassword);
		User user = query.getSingleResult();
		return user.getUserPassword();

		
	}
}
