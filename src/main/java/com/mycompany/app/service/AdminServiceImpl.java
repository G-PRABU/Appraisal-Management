package com.mycompany.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.Admin;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;
import com.mycompany.app.model.Role;
import com.mycompany.app.repository.AdminRepository;
import com.mycompany.app.repository.AuthorizationRepository;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.HRRepository;
import com.mycompany.app.repository.ManagerRepository;
import com.mycompany.app.repository.RoleRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired 
	private AuthorizationRepository authorizationRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private ManagerRepository managerRepository;
	
	@Autowired
	HRRepository hrRepository;
	
    @Autowired 
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
	@Override
	public boolean saveEmployee(Employee e) {
		try {
			String encodedPass = bCryptPasswordEncoder.encode(e.getAuthorization().getAuthorizationPass());
			e.getAuthorization().setAuthorizationPass(encodedPass);
			authorizationRepository.save(e.getAuthorization());
			employeeRepository.save(e);
			return true;
		} catch(Exception ex) {
		    return false;
		}
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean deleteEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
			authorizationRepository.delete(employee.get().getAuthorization());
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> searchEmployee(String name) {		
		return employeeRepository.searchEmployee(name);
	}

	@Override
	public boolean saveHR(HR h) {
		try {
			String encodedPass = bCryptPasswordEncoder.encode(h.getAuthorization().getAuthorizationPass());
			h.getAuthorization().setAuthorizationPass(encodedPass);
			authorizationRepository.save(h.getAuthorization());
			hrRepository.save(h);
			return true;
		} catch(Exception e) { 
		    return false;
		}
	}

	@Override
	public boolean deleteHR(Long id) {
		Optional<HR> hr = hrRepository.findById(id);
		if(hr.isPresent()) {
			hrRepository.deleteById(id);
			authorizationRepository.delete(hr.get().getAuthorization());
			return true;
		}
		return false;
	}

	@Override
	public HR getHR(Long id) {
	    Optional<HR> hr = hrRepository.findById(id);
	    if(hr.isPresent()) {
	    	return hr.get();
	    }
	    return null;
	}

	@Override
	public List<HR> getAllHR() {
		return hrRepository.findAll();
	}

	@Override
	public List<HR> serachHR(String name) {
		return hrRepository.findByName(name);
	}

	@Override
	public boolean saveManager(Manager m) {
		try {
			String encodedPass = bCryptPasswordEncoder.encode(m.getAuthorization().getAuthorizationPass());
			m.getAuthorization().setAuthorizationPass(encodedPass);
			authorizationRepository.save(m.getAuthorization());
			managerRepository.save(m);
		    return true;	
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteManager(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		if(manager.isPresent()) {
			managerRepository.deleteById(id);
			authorizationRepository.delete(manager.get().getAuthorization());
			return true;
		}
		return false;
	}

	@Override
	public Manager getManager(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		if(manager.isPresent()) {
		    return manager.get();
		}
		return null;
	}

	@Override
	public List<Manager> getAllManager() {
		return managerRepository.findAll();
	}

	@Override
	public List<Manager> searchManager(String name) {
		return managerRepository.searchManager(name);
	}

	@Override
	public Admin getAdmin(Long id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		return null;
	}

	@Override
	public Admin getAdmin(String email) {
		Optional<Admin> admin = adminRepository.findByEmail(email);
		if(admin.isPresent()) {
			return admin.get();
		}
		return null;
	}

	@Override
	public boolean saveAdmin(Admin a) {
		try {
			String encodedPass = bCryptPasswordEncoder.encode(a.getAuthorization().getAuthorizationPass());
			a.getAuthorization().setAuthorizationPass(encodedPass);
			authorizationRepository.save(a.getAuthorization());
			adminRepository.save(a);
		    return true;	
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAdmin(Long id) {
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin.isPresent()) {
			adminRepository.deleteById(id);
			authorizationRepository.delete(admin.get().getAuthorization());
			return true;
		}
		return false;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public List<Admin> searchAdmin(String name) {
		return adminRepository.findByName(name);
	}
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRole(String name) {
		return roleRepository.findByRoleName(name);
	}
}
