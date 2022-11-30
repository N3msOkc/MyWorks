package com.nems.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.blog.models.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer>{

}
