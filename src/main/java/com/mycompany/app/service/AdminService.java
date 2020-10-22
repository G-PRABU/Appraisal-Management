package com.mycompany.app.service;

import java.util.List;

import com.mycompany.app.model.Admin;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;
import com.mycompany.app.model.Role;

public interface AdminService {
    //Employee
	public boolean saveEmployee(Employee e);
	public boolean deleteEmployee(Long id);
	public Employee getEmployee(Long id);
	public List<Employee> getAllEmployees();
	public List<Employee> searchEmployee(String name);

	//HR
	public boolean saveHR(HR h);
	public boolean deleteHR(Long id);
	public HR getHR(Long id);
	public List<HR> getAllHR();
	public List<HR> serachHR(String name);
	
	//Manager
	public boolean saveManager(Manager m);
	public boolean deleteManager(Long id);
	public Manager getManager(Long id);
	public List<Manager> getAllManager();
	public List<Manager> searchManager(String name);
	
	//Admin
	public Admin getAdmin(Long id);
	public Admin getAdmin(String email);
	public boolean saveAdmin(Admin a);
	public boolean deleteAdmin(Long id);
	public List<Admin> getAllAdmin();
	public List<Admin> searchAdmin(String name);

	//Role
	public List<Role> getAllRoles();
	public Role getRole(String name);
}
