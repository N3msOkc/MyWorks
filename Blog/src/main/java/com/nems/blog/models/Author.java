package com.nems.blog.models;

import java.io.Serializable;
import java.util.List;

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
public class Author implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5177503696966534255L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column(unique = true, nullable = false)
	private Integer authorid;
	@OneToMany(mappedBy="authorid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Blog> blogs;
	
	public Author() {
		
	}

	
	
	
	public Author(Integer id, String name, Integer authorid) {
		super();
		this.id = id;
		this.name = name;
		this.authorid = authorid;
	}

	public Author(Integer id, String name, Integer authorid, List<Blog> blogs) {
		super();
		this.id = id;
		this.name = name;
		this.authorid = authorid;
		this.blogs = blogs;
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

	public Integer getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
		
	}

	@JsonManagedReference
	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	
	

	
	
	
	
	
	

}
