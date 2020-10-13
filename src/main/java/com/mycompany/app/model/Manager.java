package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Manager {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long managerId;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Employee manager;
	
	public void setManagerId(Long id) {
		managerId = id;
	}
	
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	public Long getManagerId() {
		return managerId;
	}
	
	public Employee getManager() {
		return manager;
	}
	
}
