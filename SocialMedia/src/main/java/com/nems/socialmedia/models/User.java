package com.nems.socialmedia.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email=:email")

@NamedQuery(name = "User.getAllUser", query = "select new com.nems.socialmedia.wrapper.UserWrapper(u.id,u.name,u.email,u.status) from User u")

@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:Status where u.id=:id")

@NamedQuery(name = "User.getUserByEmail", query = "select u.email from User u")

@Entity
@DynamicUpdate
@DynamicInsert
@Table
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6596568898546887296L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	@Column(nullable = false)
	private String password;
	@Column
	private String status;
	
	
	public User() {
		
	}
	
	public User(Integer id, String name, String email, String password, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	

	public User(Integer id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
