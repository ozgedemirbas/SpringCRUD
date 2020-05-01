package com.ozge.service;

import com.ozge.domain.User;

public interface UserService {

	public abstract User validateUserLogin(String email, String password);

}
