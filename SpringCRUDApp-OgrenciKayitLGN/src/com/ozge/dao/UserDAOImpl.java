package com.ozge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ozge.domain.User;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User validateUserLogin(String email, String password) {
		System.out.println("user 2 " + email + " " + password);
		Session session = sessionFactory.getCurrentSession();

		Query<User> query = session
				.createQuery("from User u where u.email= :email and u.password= :password", User.class)
				.setParameter("password", password).setParameter("email", email);
		List<User> resultList = query.getResultList();
		/*
		 * Query<User> us = session
		 * .createQuery("from User u where u.email= :email and u.password= :password",
		 * User.class) .setParameter("password", password).setParameter("email", email);
		 */
		System.out.println(resultList.toString());
		if (resultList != null && resultList.size() > 0)
			return resultList.get(0);
		else
			return null;

	}

}
