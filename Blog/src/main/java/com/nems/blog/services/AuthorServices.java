package com.nems.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.blog.models.Author;
import com.nems.blog.repository.AuthorRepository;



@Service
public class AuthorServices {
	
	@Autowired
	AuthorRepository authorRepository;
	
	
	
	public List<Author> getAllAuthors() {
		
		return (List<Author>) authorRepository.findAll();
		
	}
	
	public Optional<Author> getById(int id) {
		
		return authorRepository.findById(id);
		
	}
	
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
	}

}
