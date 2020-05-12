package com.davidChavess.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidChavess.mongo.domain.User;
import com.davidChavess.mongo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	/*
	public User findById(String id) {
		return null;
	}
	*/
	public List<User> findAll(){
		return repository.findAll();
	}
}
