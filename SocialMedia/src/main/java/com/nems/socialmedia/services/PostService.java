package com.nems.socialmedia.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.models.Comment;
import com.nems.socialmedia.models.Post;
import com.nems.socialmedia.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository repo;

	public List<Post> getAllPost() {
		return (List<Post>) repo.findAll();
	}
	
	public Optional<Post> getById(int id) {
		return repo.findById(id);
	}
	
	public Set<Comment> getCommentFromPost(int id){
		Optional<Post> postId = repo.findById(id);
		if(postId.isPresent()) {
			Post post = postId.get();
			return post.getComment();
		}else {
			return null;
		}
	}
	
	public void addPost(Post post) {
		repo.save(post);
	}
	
	public void updatePost(Post post) {
		repo.save(post);
	}

	public void deletePost(int id) {
		repo.deleteById(id);
	}

}
