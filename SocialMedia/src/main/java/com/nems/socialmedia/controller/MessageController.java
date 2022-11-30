package com.nems.socialmedia.controller;

import java.util.List;
import java.util.Optional;

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
import com.nems.socialmedia.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/get")
	public List<Message> getAllMessages(){
		return messageService.getAllMessage();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Message> message(@PathVariable int id) {
		return messageService.getById(id);
	}
	
	@PostMapping("/post")
	public void addMessage(@RequestBody Message message) {
		messageService.addMessage(message);
	}
	
	@PutMapping("/update")
	public void updateMessage(@RequestBody Message message) {
		messageService.updateMessage(message);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMessage(@PathVariable int id) {
		messageService.deleteMessageById(id);
	}
}
