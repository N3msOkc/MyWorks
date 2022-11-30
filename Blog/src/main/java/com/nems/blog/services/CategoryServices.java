package com.nems.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.blog.models.Category;
import com.nems.blog.repository.CategoryRepository;

@Service
public class CategoryServices {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Optional<Category> getById(int id) {
		return categoryRepository.findById(id);
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
	

}
