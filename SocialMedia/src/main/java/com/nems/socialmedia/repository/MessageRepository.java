package com.nems.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.socialmedia.models.Message;
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>{

}
