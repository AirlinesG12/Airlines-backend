package com.lti.repository;

import java.util.List;

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
		String jpql = "select u from User u where u.userEmail=:umail and u.userPassword=:upass";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("umail", userEmail);
		query.setParameter("upass", userPassword);
		User user = query.getSingleResult();
		if (user != null) {
			return true;
		}
		return false;
	}

}
