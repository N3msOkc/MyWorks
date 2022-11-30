package com.nems.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nems.socialmedia.models.Likes;
import com.nems.socialmedia.services.LikesService;

@RestController
@RequestMapping("/like")
public class LikesController {
	
	@Autowired
	LikesService likeService;
	
	
	@PostMapping("/post")
	public void addLikes(@RequestBody Likes like) {
		likeService.addLike(like);
	}
	
	@DeleteMapping("/delete")
	public void deleteLikeById(@PathVariable int id) {
		likeService.deleteLike(id);
	}
}
