package com.nems.socialmedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.models.Comment;
import com.nems.socialmedia.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository repo;
	
	public List<Comment> getAllComment(){
		return (List<Comment>) repo.findAll();
	}
	
	public Optional<Comment> getById(int id) {
		return repo.findById(id);
	}
	
	public void addComment(Comment comment) {
		repo.save(comment);
	}
	
	public void updateComment(Comment comment) {
		repo.save(comment);
	}
	
	public void deleteComment(Comment comment) {
		repo.delete(comment);
	}
	
	public void deleteCommentById(int id) {
		repo.deleteById(id);
	}

}
