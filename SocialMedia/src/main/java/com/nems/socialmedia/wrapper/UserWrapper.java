package com.nems.socialmedia.wrapper;


public class UserWrapper {
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String status;
	
	public UserWrapper() {
		
	}

	public UserWrapper(Integer id, String name, String email, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
