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

import com.nems.blog.models.Category;
import com.nems.blog.services.CategoryServices;

@RestController
public class CategoryController {
	
		@Autowired
		CategoryServices categoryServices;
	
		@GetMapping("/category")
		public List<Category> getAllCategories(){
			return categoryServices.getAllCategories();
		}
		@GetMapping("/category/{id}")
		public Optional<Category> getById(@PathVariable int id) {
			return categoryServices.getById(id);
		}
		@PostMapping("/category/post")
		public void addCategory(@RequestBody Category category) {
			categoryServices.addCategory(category);
		}
		@PutMapping("/category/{id}/update")
		public void updateCategory(@RequestBody Category category) {
			categoryServices.addCategory(category);
		}
		@DeleteMapping("/category/{id}/delete")
		public void deleteCategory(@PathVariable int id) {
			categoryServices.deleteCategory(id);
		}
}
