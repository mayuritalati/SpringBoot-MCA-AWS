package com.mayuri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mayuri.entity.Post;
import com.mayuri.entity.Tag;
import com.mayuri.repository.PostRepository;
import com.mayuri.repository.TagRepository;

@SpringBootApplication
public class HibernateManyToManyRelationshipDemoApplication implements CommandLineRunner {

	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TagRepository tagRepositroy;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateManyToManyRelationshipDemoApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		System.out.println("HibernateManyToManyRelationshipDemoApplication run::::::::");
		  postRepository.deleteAllInBatch();
		  tagRepositroy.deleteAllInBatch();

	        // =======================================

	        // Create a Post
	        Post post = new Post("Hibernate Many to Many Example with Spring Boot",
	                "Learn how to map a many to many relationship using hibernate",
	                "Entire Post content with Sample code");

	        // Create two tags
	        Tag tag1 = new Tag("Spring Boot");
	        Tag tag2 = new Tag("Hibernate");


	        // Add tag references in the post
	        post.getTags().add(tag1);
	        post.getTags().add(tag2);

	        // Add post reference in the tags
	        tag1.getPosts().add(post);
	        tag2.getPosts().add(post);

	        postRepository.save(post);

	        // =======================================
    }

}
