package com.davidChavess.mongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.davidChavess.mongo.domain.User;
import com.davidChavess.mongo.dto.UserDto;
import com.davidChavess.mongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> list = service.findAll();
		List<UserDto> dto = list.stream().map( x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);

	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User user = service.findById(id);
		UserDto dto = new UserDto(user);
		return ResponseEntity.ok().body(dto);
	} 
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDto u){
		User user = service.fromDto(u);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build(); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update( @PathVariable String id, @RequestBody UserDto u){
		User obj = service.fromDto(u);
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}	


}
