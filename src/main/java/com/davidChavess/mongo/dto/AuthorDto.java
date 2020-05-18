package com.davidChavess.mongo.dto;

import java.io.Serializable;

import com.davidChavess.mongo.domain.User;

public class AuthorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDto() {
	}
	
	public AuthorDto(User obj) {
		this.id = obj.getId();
		this.name = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}