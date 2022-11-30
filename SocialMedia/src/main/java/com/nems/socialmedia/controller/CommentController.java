package com.nems.socialmedia.controller;

import java.util.List;
import java.util.Optional;

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
import com.nems.socialmedia.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@GetMapping("/get")
	public List<Comment> getAllComment(){
		return commentService.getAllComment();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Comment> getCommentById(@PathVariable int id) {
		return commentService.getById(id);
	}
	
	@PostMapping("/post")
	public void addComment(@RequestBody Comment comment) {
		commentService.addComment(comment);
	}
	
	@PutMapping("/update")
	public void updateComment(@RequestBody Comment comment) {
		commentService.updateComment(comment);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteComment(@PathVariable int id) {
		commentService.deleteCommentById(id);
	}
	
	
}
