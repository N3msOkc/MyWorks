package com.nems.socialmedia.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5335658292175238203L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@OneToMany(mappedBy="profileid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Post> post;
	@OneToMany(mappedBy="profileid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Message> message;
	
	public Profile() {
		
	}

	public Profile(Integer profileid, String firstname, String lastname, String email, Set<Post> post, Set<Message> message) {
		super();
		this.profileid = profileid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.post = post;
		this.message = message;
	}

	public Integer getProfileId() {
		return profileid;
	}

	public void setProfileId(Integer profileid) {
		this.profileid = profileid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@JsonManagedReference
	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}
	@JsonManagedReference
	public Set<Message> getMessage() {
		return message;
	}

	public void setMessage(Set<Message> message) {
		this.message = message;
	}
	

}
