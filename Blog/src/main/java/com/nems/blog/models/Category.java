package com.nems.blog.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Category implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2682022071065250986L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Blog> blogs;
	
	public Category() {
		
	}


	public Category(int id, String name, Set<Blog> blogs) {
		super();
		this.id = id;
		this.name = name;
		this.blogs = blogs;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	
	
	
	
	
	
	
	

}
