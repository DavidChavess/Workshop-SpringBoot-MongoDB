package com.davidChavess.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidChavess.mongo.domain.User;
import com.davidChavess.mongo.dto.UserDto;
import com.davidChavess.mongo.repositories.UserRepository;
import com.davidChavess.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDto(UserDto obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	public void delete(String id) {
		repository.deleteById(id);
	}
}
