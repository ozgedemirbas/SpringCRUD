package com.ozge.dao;

import com.ozge.domain.User;

public interface UserDAO {

	public User validateUserLogin(String email, String password);

}
