package com.mycompany.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.Admin;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;
import com.mycompany.app.repository.AdminRepository;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.HRRepository;
import com.mycompany.app.repository.ManagerRepository;

@Service
public class EmployeeDetailsService implements UserDetailsService {
    
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	HRRepository hrRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		Optional<Employee> employee = employeeRepository.findByEmail(username);
		Optional<Manager> manager = managerRepository.findByEmail(username);
		Optional<HR> hr = hrRepository.findByEmail(username);		
		Optional<Admin> admin = adminRepository.findByEmail(username);
		UserBuilder builder = null;
		
		if(employee.isPresent()) {
			
			builder = User.withUsername(username)
					.password(employee.get().getAuthorization().getAuthorizationPass());
		    String[] authorities = new String[1];
		    authorities[0] = employee.get().getAuthorization().getAuthorizedRole().getRoleName();
		    builder.authorities(authorities);
		    
		
		} else if(manager.isPresent()) {

			builder = User.withUsername(username)
					.password(manager.get().getAuthorization().getAuthorizationPass());
			String[] authorities = new String[1];
		    authorities[0] = manager.get().getAuthorization().getAuthorizedRole().getRoleName();
		    builder.authorities(authorities);
		
		} else if(hr.isPresent()) {
		
			builder = User.withUsername(username)
					.password(hr.get().getAuthorization().getAuthorizationPass());
		    String[] authorities = new String[1];
		    authorities[0] = hr.get().getAuthorization().getAuthorizedRole().getRoleName();
		    builder.authorities(authorities);
		
		} else if(admin.isPresent()) {
			
			builder = User.withUsername(username)
					.password(admin.get().getAuthorization().getAuthorizationPass());
		    String[] authorities = new String[1];
		    authorities[0] = admin.get().getAuthorization().getAuthorizedRole().getRoleName();
		    builder.authorities(authorities);
		
		} else {
			
			throw new UsernameNotFoundException("User Not Found.");
		
		}
		
		return builder.build();
	}

}
