package com.nems.socialmedia.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nems.socialmedia.models.Message;
import com.nems.socialmedia.models.Post;
import com.nems.socialmedia.models.Profile;
import com.nems.socialmedia.services.ProfileService;


@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	@GetMapping("/getall")
	public List<Profile> getAllProfiles(){
			return profileService.getAllProfiles();
	}
	
	@GetMapping("/getall/{id}")
	public Optional<Profile> getById(@PathVariable int id) {
		return profileService.getById(id);
	}
	
	@GetMapping("/getpost/{id}")
	public Set<Post> getPostFromProfile(@PathVariable int id){
		return profileService.getPostFromProfile(id);
	}
	
	@GetMapping("getmessage/{id}")
	public Set<Message> getMessagesFromProfile(@PathVariable int id){
		return profileService.getMessagesFromProfile(id);
	}
	
	@PostMapping("/post")
	public void addProfile(@RequestBody Profile profile){
		profileService.addProfile(profile);
	}
	
	@PutMapping("/update")
	public void updateProfile(@RequestBody Profile profile) {
		profileService.updateProfile(profile);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProfile(@PathVariable int id) {
		profileService.deleteById(id);
	}
	
	

}
