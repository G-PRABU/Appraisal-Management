package com.mycompany.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.Authorization;
import com.mycompany.app.model.Employee;
import com.mycompany.app.repository.AdminRepository;
import com.mycompany.app.repository.AuthorizationRepository;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.ManagerRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired 
	AuthorizationRepository authorizationRepository;
	
	@Autowired 
	ManagerRepository managerRepository;
	
    @Autowired 
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public boolean saveEmployee(Employee e) {
		try {
			employeeRepository.save(e);
			return true;
		} catch(Exception ex) {
		    return false;
		}
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.getOne(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void createPass() {
		Authorization auth = employeeRepository.findById(1L).get().getAuthorization();
		auth.setAuthorizationPass(bCryptPasswordEncoder.encode("employee1"));
		authorizationRepository.save(auth);
		
		Authorization auth1 = managerRepository.findById(1L).get().getAuthorization();
		auth1.setAuthorizationPass(bCryptPasswordEncoder.encode("manager1"));
		authorizationRepository.save(auth1);
	}
}
