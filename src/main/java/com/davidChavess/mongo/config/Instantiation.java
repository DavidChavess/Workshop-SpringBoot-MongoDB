package com.davidChavess.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.davidChavess.mongo.domain.Post;
import com.davidChavess.mongo.domain.User;
import com.davidChavess.mongo.dto.AuthorDto;
import com.davidChavess.mongo.repositories.PostRepository;
import com.davidChavess.mongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
			
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Let´s go Holiday", "Go to São Paulo! bye bye", new AuthorDto(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good Morning", "I lifted happy today", new AuthorDto(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
