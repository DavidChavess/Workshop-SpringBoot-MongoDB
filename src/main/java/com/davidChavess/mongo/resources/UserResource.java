package com.davidChavess.mongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidChavess.mongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "maria@gmail.com");
		User marinho = new User("1", "Marinho", "marinho@gmail.com");
		User david = new User("1", "david", "david@gmail.com");
		User gisele = new User("1", "gi", "gisele@gmail.com");

		return ResponseEntity.ok().body( Arrays.asList(maria, marinho, david, gisele) );

	} 

}
