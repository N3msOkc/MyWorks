package com.nems.socialmedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.models.Likes;
import com.nems.socialmedia.repository.LikesRepository;

@Service
public class LikesService {

	@Autowired
	LikesRepository repo;
	
	public void addLike(Likes like) {
		repo.save(like);
	}
	
	public void deleteLike(int id) {
		repo.deleteById(id);
	}
}
