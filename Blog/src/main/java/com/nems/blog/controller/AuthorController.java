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

import com.nems.blog.models.Author;
import com.nems.blog.services.AuthorServices;



@RestController
public class AuthorController {

	@Autowired
	AuthorServices authorServices;
	
	
	@GetMapping("/author")
	public List<Author> getAllauthors() {
		return authorServices.getAllAuthors();
	}
	
	@GetMapping("/author/{id}")
	public Optional<Author> getById(@PathVariable int id) {
		return authorServices.getById(id);
	}
	
	@PostMapping("/author/post")
	public void addAuthor(@RequestBody Author author) {
		authorServices.addAuthor(author);
	}
	
	@PutMapping("/author/{id}/update")
	public void updateAuthor(@RequestBody Author author) {
		authorServices.updateAuthor(author);
	}
	
	@DeleteMapping("/author/{id}/delete")
			public void deleteAuthor(@PathVariable int id) {
				authorServices.deleteAuthor(id);
			}

}
