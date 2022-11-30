package com.nems.blog.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Blog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4166310407986526346L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String title;
	@Column
	private String content;
	@ManyToOne(optional = false)
	@JoinColumn(name="authorid", referencedColumnName = "authorid", nullable = false, insertable=false, updatable=false)
	private Author author;
	
	private Integer authorid;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "BLOG_CATEGORY_TABLE",
	joinColumns = {
			@JoinColumn(name = "blog_id", referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "category_id", referencedColumnName = "id")
	}
	)
	private Set<Category> categories;
	
	
	
	public Blog() {
		
	}
	
	

	public Blog(Integer id, String title, String content, Author author, Integer authorid, Set<Category> categories) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.authorid = authorid;
		this.categories = categories;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonBackReference
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Integer getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}



	public Set<Category> getCategories() {
		return categories;
	}



	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
	
	
	
	
	
	

}
