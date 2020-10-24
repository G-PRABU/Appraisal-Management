package com.mycompany.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.model.Admin;
import com.mycompany.app.model.Authorization;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;
import com.mycompany.app.pojo.AdminPOJO;
import com.mycompany.app.pojo.EmployeePOJO;
import com.mycompany.app.pojo.HRPOJO;
import com.mycompany.app.pojo.ManagerPOJO;
import com.mycompany.app.service.AdminServiceImpl;

@Controller
public class AdminController {

	@Autowired
	AdminServiceImpl adminService;
	
	private static final String ADMIN = "admin";
	
	/* Admin */
	
	@GetMapping("/admin")
	public ModelAndView admin(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ADMIN);
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		return mv;
	}
	
	@GetMapping("admin/profile/{id}")
	public ModelAndView getAdminProfile(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminProfile");
		mv.addObject(ADMIN, adminService.getAdmin(id));
		return mv;
	}
	
	@GetMapping("admin/add")
	public ModelAndView addAdmin(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addAdmin");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		return mv;
	}
	
	@PostMapping("admin/create")
	public String createAdmin(@ModelAttribute("a") AdminPOJO admin) {
		Admin a = new Admin();
		BeanUtils.copyProperties(admin,a);
		adminService.saveAdmin(a);
		return "redirect:/admin";
	}
	
	@ModelAttribute("a")
	public AdminPOJO getAdminObject() {
		AdminPOJO admin = new AdminPOJO();
		Authorization authorization = new Authorization();
		authorization.setAuthorizedRole(adminService.getRole("ADMIN"));
		admin.setAuthorization(authorization);
		return admin;
	}
	
	
	
	
	/*  Employees  */

	@GetMapping("admin/employee")
	public ModelAndView getEmployees(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminEmployees");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("employees", adminService.getAllEmployees());
		return mv;
	}
	
	@GetMapping("admin/employee/get/{id}")
	public ModelAndView getEmployee(@PathVariable("id") Long id,Authentication authentication) {
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("adminEmployee");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("employee", adminService.getEmployee(id));
		return mv;
	}
	
	@GetMapping("admin/employee/add")
	public ModelAndView addEmployee(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployee");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("managers", adminService.getAllManager());
		mv.addObject("roles", adminService.getAllRoles());
		return mv;
	}
	
	@PostMapping("admin/employee/create")
	public String createEmployee(@ModelAttribute("employee") EmployeePOJO employee) {
		Employee e = new Employee();
		BeanUtils.copyProperties(employee,e);
		adminService.saveEmployee(e);
		return "redirect:/admin/employee";
	}
	
	@GetMapping("admin/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		adminService.deleteEmployee(id);
		return "redirect:/admin/employee";
	}
	
	@ModelAttribute("employee")
	public EmployeePOJO getEmployeeObject() {
		EmployeePOJO employee = new EmployeePOJO();
		Authorization authorization = new Authorization();
		authorization.setAuthorizedRole(adminService.getRole("EMPLOYEE"));
		employee.setAuthorization(authorization);
		employee.setManager(new Manager());
		return employee;
	}
	
	
	
	
	/* Manager */
	
	@GetMapping("admin/manager")
	public ModelAndView getManagers(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminManagers");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("managers", adminService.getAllManager());
		return mv;
	}
	
	@GetMapping("admin/manager/get/{id}")
	public ModelAndView getManager(@PathVariable("id") Long id,Authentication authentication) {
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("adminManager");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("manager", adminService.getManager(id));
		return mv;
	}
	
	@GetMapping("admin/manager/add")
	public ModelAndView addManager(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addManager");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("hrs", adminService.getAllHR());
		return mv;
	}
	
	@PostMapping("admin/manager/create")
	public String createManager(@ModelAttribute("manager") ManagerPOJO manager) {
		Manager m = new Manager();
		BeanUtils.copyProperties(manager,m);
		adminService.saveManager(m);
		return "redirect:/admin/manager";
	}
	
	@GetMapping("admin/manager/delete/{id}")
	public String deleteManager(@PathVariable("id") Long id) {
		adminService.deleteManager(id);
		return "redirect:/admin/manager";
	}
	
	@ModelAttribute("manager")
	public ManagerPOJO getManagerObject() {
		ManagerPOJO manager = new ManagerPOJO();
		Authorization authorization = new Authorization();
		authorization.setAuthorizedRole(adminService.getRole("MANAGER"));
		manager.setAuthorization(authorization);
		manager.setHr(new HR());
		return manager;
	}
	
	
	
	
	/* HR */
	
	@GetMapping("admin/hr")
	public ModelAndView getHRs(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminHRs");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("hrs", adminService.getAllHR());
		return mv;
	}
	
	@GetMapping("admin/hr/get/{id}")
	public ModelAndView getHR(@PathVariable("id") Long id,Authentication authentication) {
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("adminHR");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		mv.addObject("hr", adminService.getHR(id));
		return mv;
	}
	
	@GetMapping("admin/hr/add")
	public ModelAndView addHR(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addHR");
		mv.addObject(ADMIN,adminService.getAdmin(authentication.getName()));
		return mv;
	}
	
	@PostMapping("admin/hr/create")
	public String createHR(@ModelAttribute("hr") HRPOJO hr) {
		HR h = new HR();
		BeanUtils.copyProperties(hr,h);
		adminService.saveHR(h);
		return "redirect:/admin/hr";
	}
	
	@GetMapping("admin/hr/delete/{id}")
	public String deleteHR(@PathVariable("id") Long id) {
		adminService.deleteHR(id);
		return "redirect:/admin/hr";
	}
	
	@ModelAttribute("hr")
	public HRPOJO getHRObject() {
		HRPOJO hr = new HRPOJO();
		Authorization authorization = new Authorization();
		authorization.setAuthorizedRole(adminService.getRole("HR"));
		hr.setAuthorization(authorization);
		return hr;
	}
}
