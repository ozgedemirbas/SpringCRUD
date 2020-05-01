package com.ozge.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UserLogin {

	@NotEmpty(message = "Boş Olamaz !")
	@Email(message = "Email standartlarına göre yaz !")
	private String email;

	@NotEmpty(message = "Boş Olamaz !")
	private String password;
	
	
	
	public UserLogin() {
		super();
	}

	public UserLogin(@NotEmpty @Email String email, @NotEmpty String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [email=" + email + ", password=" + password + "]";
	}

}
