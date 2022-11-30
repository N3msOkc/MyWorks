package com.nems.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.socialmedia.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
