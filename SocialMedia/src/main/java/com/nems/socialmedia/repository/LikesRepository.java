package com.nems.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.socialmedia.models.Likes;
@Repository
public interface LikesRepository extends CrudRepository<Likes, Integer>{

}
