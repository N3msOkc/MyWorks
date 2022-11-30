package com.nems.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.socialmedia.models.Post;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{

}
