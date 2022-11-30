package com.nems.socialmedia.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nems.socialmedia.models.Comment;
import com.nems.socialmedia.models.Post;
import com.nems.socialmedia.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/get")
	public List<Post> getAllPost(){
		return postService.getAllPost();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Post> getById(@PathVariable int id) {
		return postService.getById(id);
	}
	
	@GetMapping("/getcomment/{id}")
	public Set<Comment> getCommentFromPost(@PathVariable int id){
		return postService.getCommentFromPost(id);
	}
	
	@PostMapping("/post")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@PutMapping("/update")
	public void updatePost(@RequestBody Post post) {
		postService.updatePost(post);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePost(@PathVariable int id) {
		postService.deletePost(id);
	}
	

}
