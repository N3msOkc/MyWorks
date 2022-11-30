package com.nems.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.blog.models.Blog;
import com.nems.blog.repository.BlogRepository;

@Service
public class BlogServices {
	
	@Autowired
	BlogRepository blogRepository;
	
	public List<Blog> getAllBlogs(){
		
		return (List<Blog>) blogRepository.findAll();
		
	}
	
	public Optional<Blog> getById(int id) {
		
		return blogRepository.findById(id);
	}
	
	public void addBlog(Blog blog) {
		blogRepository.save(blog);
	}
	
	public void updateBlog(Blog blog) {
		blogRepository.save(blog);
	}
	
	public void deleteBlog(int id) {
		blogRepository.deleteById(id);
	}
	

}
