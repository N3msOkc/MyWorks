package com.nems.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nems.socialmedia.models.Share;
import com.nems.socialmedia.services.ShareService;

@RestController
@RequestMapping("/share")
public class ShareController {

	@Autowired
	ShareService shareService;
	
	@PostMapping("/post")
	public void addShare(@RequestBody Share share) {
		shareService.addShare(share);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteShare(@PathVariable int id) {
		shareService.deleteShareById(id);
	}
}
