package com.nems.socialmedia.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer messageid;
	@Column
	private String content;
	@ManyToOne(optional = false)
	@JoinColumn(name="profileid", referencedColumnName = "profileid", nullable = false, insertable=false, updatable=false)
	private Profile profile;
	
	private Integer profileid;
	
	public Message() {
		
	}

	public Message(Integer messageid, String content, Profile profile, Integer profileid) {
		super();
		this.messageid = messageid;
		this.content = content;
		this.profile = profile;
		this.profileid = profileid;
	}

	public Integer getMessageid() {
		return messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonBackReference
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Integer getProfileid() {
		return profileid;
	}

	public void setProfileid(Integer profileid) {
		this.profileid = profileid;
	}
	
	
}
