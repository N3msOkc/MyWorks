package com.nems.blog.repository;

import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nems.blog.models.User;
import com.nems.blog.wrapper.UserWrapper;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);
	
	User findByEmail(@Param("email") String email);
	
	List<UserWrapper> getAllUser();
	
	List<String> getUserByEmail();
	
	@Transactional
	@Modifying
	Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
}
