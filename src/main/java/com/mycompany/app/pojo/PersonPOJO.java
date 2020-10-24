package com.mycompany.app.pojo;

import java.util.Date;

public class PersonPOJO {
    
	private Long id;
	
	private String name;
	
	private String email;
	
	private long phone;
	
	private Date dob;
    
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public Date getDob() {
		return dob;
	}
}
