package com.nems.socialmedia.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5500318433869358774L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postid;
	@Column
	private String content;
	@Column
	private Date created = new Date(System.currentTimeMillis());
	@ManyToOne(optional = false)
	@JoinColumn(name="profileid", referencedColumnName = "profileid", nullable = false, insertable=false, updatable=false)
	private Profile profile;
	@OneToMany(mappedBy="postid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comment;
	@OneToMany(mappedBy="postid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Likes> likes;
	@OneToMany(mappedBy="postid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Share> share;
	
	private Integer profileid;
	
	public Post() {
		
	}

	public Post(Integer postid, String content, Date created, Profile profile, Set<Comment> comment, Set<Likes> likes,
			Set<Share> share, Integer profileid) {
		super();
		this.postid = postid;
		this.content = content;
		this.created = created;
		this.profile = profile;
		this.comment = comment;
		this.likes = likes;
		this.share = share;
		this.profileid = profileid;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	@JsonBackReference
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@JsonManagedReference
	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	@JsonManagedReference
	public Set<Likes> getLike() {
		return likes;
	}

	public void setLike(Set<Likes> likes) {
		this.likes = likes;
	}
	@JsonManagedReference
	public Set<Share> getShare() {
		return share;
	}

	public void setShare(Set<Share> share) {
		this.share = share;
	}

	public Integer getProfileid() {
		return profileid;
	}

	public void setProfileid(Integer profileid) {
		this.profileid = profileid;
	}
	

	
	
	
	
	
}
