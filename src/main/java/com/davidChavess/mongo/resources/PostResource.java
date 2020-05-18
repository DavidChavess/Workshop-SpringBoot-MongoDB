package com.davidChavess.mongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidChavess.mongo.domain.Post;
import com.davidChavess.mongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
