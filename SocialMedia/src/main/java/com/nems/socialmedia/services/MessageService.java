package com.nems.socialmedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.models.Message;
import com.nems.socialmedia.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository repo;
	
	public List<Message> getAllMessage(){
		return (List<Message>) repo.findAll();
	}
	
	public Optional<Message> getById(int id) {
		return repo.findById(id);
	}
	
	public void addMessage(Message message) {
		repo.save(message);
	}
	
	public void updateMessage(Message message) {
		repo.save(message);
	}
	
	public void deleteMessageById(int id) {
		repo.deleteById(id);
	}

}
