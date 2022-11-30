package com.nems.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.blog.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
