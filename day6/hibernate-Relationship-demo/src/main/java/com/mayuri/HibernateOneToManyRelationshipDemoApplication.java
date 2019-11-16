package com.mayuri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mayuri.entity.Comment;
import com.mayuri.entity.Post;
import com.mayuri.repository.CommentRepository;
import com.mayuri.repository.PostRepository;
import com.mayuri.repository.UserRepository;

@SpringBootApplication
public class HibernateOneToManyRelationshipDemoApplication implements CommandLineRunner {

	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepositroy;
	
	
	
	public static void main1(String[] args) {
		SpringApplication.run(HibernateOneToManyRelationshipDemoApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		/*
		 * postRepository.deleteAllInBatch(); commentRepositroy.deleteAllInBatch(); Post
		 * post = new Post("post title", "post description", "post content");
		 * 
		 * // Create Comments Comment comment1 = new Comment("Great Post!");
		 * comment1.setPost(post); Comment comment2 = new
		 * Comment("Really helpful Post. Thanks a lot!"); comment2.setPost(post);
		 * 
		 * // Add comments in the Post post.getComments().add(comment1);
		 * post.getComments().add(comment2);
		 * 
		 * // Save Post and Comments via the Post entity postRepository.save(post);
		 */
    }

}
