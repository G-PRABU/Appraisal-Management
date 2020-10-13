package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long departmentId;
	
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name = "branchId")
	private Branch branch;
	
	@OneToOne
	@JoinColumn(name = "managerId")
	private Manager manager;
	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public Manager getManager() {
		return manager;
	}
}
