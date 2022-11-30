package com.nems.blog.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nems.blog.models.Blog;
import com.nems.blog.services.BlogServices;

@RestController
public class BlogController {
	
	@Autowired
	BlogServices blogServices;
	
	@GetMapping("/blog")
	public List<Blog> getAllBlogs(){
		return blogServices.getAllBlogs();
	}
	
	@GetMapping("/blog/{id}")
	public Optional<Blog> getById(@PathVariable int id) {
		return blogServices.getById(id);
	}
	
	@PostMapping("/blog/post")
	public void addBlog(@RequestBody Blog blog) {
		blogServices.addBlog(blog);
	}
	
	@PutMapping("/blog/{id}/update")
	public void updateBlog(@RequestBody Blog blog) {
		blogServices.updateBlog(blog);
	}
	
	@DeleteMapping("/blog/{id}/delete")
	public void deleteBlog(@PathVariable int id) {
		blogServices.deleteBlog(id);
	}

}
