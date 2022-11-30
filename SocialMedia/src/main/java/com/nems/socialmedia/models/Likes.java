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
public class Likes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3283091280202547827L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeid;
	@Column
	private String content = "Liked";
	@ManyToOne(optional = false)
	@JoinColumn(name="postid", referencedColumnName = "postid", nullable = false, insertable=false, updatable=false)
	private Post post;
	
	private Integer postid;
	
	public Likes() {
		
	}

	public Likes(Integer likeid, String content, Post post, Integer postid) {
		super();
		this.likeid = likeid;
		this.content = content;
		this.post = post;
		this.postid = postid;
	}

	public Integer getLikeid() {
		return likeid;
	}

	public void setLikeid(Integer likeid) {
		this.likeid = likeid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonBackReference
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	
	
	
}
