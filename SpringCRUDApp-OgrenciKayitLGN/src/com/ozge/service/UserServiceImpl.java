package com.ozge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ozge.dao.UserDAO;
import com.ozge.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	@Override
	public User validateUserLogin(String email, String password) {
		//System.out.println("user 2 " + email +" " + password);
		User user = getUserDAO().validateUserLogin(email, password);
		return user;
	}

}
