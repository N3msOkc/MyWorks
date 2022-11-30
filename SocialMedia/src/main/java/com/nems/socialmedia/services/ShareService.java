package com.nems.socialmedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.models.Share;
import com.nems.socialmedia.repository.ShareRepository;

@Service
public class ShareService {
	
	@Autowired
	ShareRepository repo;
	
	public void addShare(Share share) {
		repo.save(share);
	}
	
	public void deleteShareById(int id) {
		repo.deleteById(id);
	}

}
