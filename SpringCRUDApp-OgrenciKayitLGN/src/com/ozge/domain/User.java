package com.ozge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "USERSSS")
public class User {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "users_seq", sequenceName = "SEQ_USERS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	private Integer id;
	
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;
	
	@NotEmpty
	@Column(name = "gender")
	private String gender;
	
	@NotNull
	@Column(name = "phone")
	private String phone;
	
	
	
	public User() {
		super();
	}

	
	


	public User(@NotEmpty String name, @NotEmpty String password, @NotEmpty @Email String email,
			@NotEmpty String gender, @NotNull String phone) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
	}





	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
}
