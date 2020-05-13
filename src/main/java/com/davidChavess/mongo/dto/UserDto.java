package com.davidChavess.mongo.dto;

import java.io.Serializable;

import com.davidChavess.mongo.domain.User;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDto() {
		
	}
	
	public UserDto(User obj) {
		this.id = obj.getId();
		this.name = obj.getNome();
		this.email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}