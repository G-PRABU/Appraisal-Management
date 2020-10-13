package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Employee extends Person{

	@ManyToOne
	@JoinColumn(name = "branchId")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;
	
	@OneToOne
	@JoinColumn(name = "authorizationId")
	private Authorization authorization;
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}
	
}
