package com.nems.socialmedia.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.models.Message;
import com.nems.socialmedia.models.Post;
import com.nems.socialmedia.models.Profile;
import com.nems.socialmedia.repository.ProfileRepository;


@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository repo;

	public List<Profile> getAllProfiles() {
		return (List<Profile>) repo.findAll();
	}

	public Optional<Profile> getById(int id) {
		return repo.findById(id);
	}
	
	public Set<Post> getPostFromProfile(int id){
		Optional<Profile> personId = repo.findById(id);
		if(personId.isPresent()) {
			Profile profile = personId.get();
			return profile.getPost();
		}
		return null;
	}
	
	public Set<Message> getMessagesFromProfile(int id){
		Optional<Profile> personId = repo.findById(id);
		if(personId.isPresent()) {
			Profile profile = personId.get();
			return profile.getMessage();
		}
		return null;
	}

	public void addProfile(Profile profile) {
		repo.save(profile);
	}

	public void updateProfile(Profile profile) {
		repo.save(profile);
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}
	

}
