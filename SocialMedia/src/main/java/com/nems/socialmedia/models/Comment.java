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
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -284567587366220331L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentid;
	@Column
	private String contents;
	@ManyToOne(optional = false)
	@JoinColumn(name="postid", referencedColumnName = "postid", nullable = false, insertable=false, updatable=false)
	private Post post;
	
	private Integer postid;
	
	public Comment() {
		
	}

	public Comment(Integer commentid, String contents, Post post, Integer postid) {
		super();
		this.commentid = commentid;
		this.contents = contents;
		this.post = post;
		this.postid = postid;
	}

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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
