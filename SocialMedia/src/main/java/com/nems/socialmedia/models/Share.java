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
public class Share implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4627735583314589615L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shareid;
	@Column
	private String content = "Shared";
	@ManyToOne(optional = false)
	@JoinColumn(name="postid", referencedColumnName = "postid", nullable = false, insertable=false, updatable=false)
	private Post post;
	
	private Integer postid;
	
	public Share() {
		
	}

	public Share(Integer shareid, String content, Post post, Integer postid) {
		super();
		this.shareid = shareid;
		this.content = content;
		this.post = post;
		this.postid = postid;
	}

	public Integer getShareid() {
		return shareid;
	}

	public void setShareid(Integer shareid) {
		this.shareid = shareid;
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

