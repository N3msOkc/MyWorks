package com.nems.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.blog.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
