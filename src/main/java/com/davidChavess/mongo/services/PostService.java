package com.davidChavess.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidChavess.mongo.domain.Post;
import com.davidChavess.mongo.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
}
