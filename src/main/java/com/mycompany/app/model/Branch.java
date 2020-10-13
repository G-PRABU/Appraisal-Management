package com.mycompany.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long branchId;
	
	private String branchName;
	
	@ManyToOne
	@JoinColumn(name = "hrId")
	private HR hr;
	
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public void setHr(HR hr) {
		this.hr = hr;
	}
	
	public Long getBranchId() {
		return branchId;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public HR getHr() {
		return hr;
	}
}
