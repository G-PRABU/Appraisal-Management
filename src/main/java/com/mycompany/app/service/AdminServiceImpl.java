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

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired 
	AuthorizationRepository authorizationRepository;
	
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
		Authorization auth = adminRepository.findById(1L).get().getAuthorization();
		auth.setAuthorizationPass(bCryptPasswordEncoder.encode("admin1"));
		authorizationRepository.save(auth);
	}
}
