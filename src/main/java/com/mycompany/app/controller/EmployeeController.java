package com.mycompany.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;
import com.mycompany.app.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;
	
	String page="EmployeeGoal";
	String pageEmp="employee";

		@GetMapping("/employee")
		public ModelAndView showEmployee(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);	
		mv.addObject("a",employeeService.getAllAssignedGoal(employee));
		mv.setViewName(pageEmp);
		return mv;
	}
	
	@GetMapping("/employee/complete/{id}")
	public ModelAndView completeGoal(@PathVariable long id,Authentication authentication)
	{
		ModelAndView mv=new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);
		employeeService.completeGoal(id);
		mv.addObject("a",employeeService.getAllAssignedGoal(employee));
		mv.setViewName(pageEmp);
		return mv;
	}
	

	@GetMapping("employee/profile")
	public ModelAndView viewProfile(Authentication authentication)
	{
		ModelAndView mv= new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);
		mv.addObject("employee",employee);
		mv.setViewName("employeeProfile");
		return mv;
	}
	
	
	@GetMapping("/employee/goals")
	public ModelAndView showGoals()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("goal",employeeService.getAllGoals());
		mv.setViewName(page);
		return mv;
	}
	
	@RequestMapping("/employee/search")
	public ModelAndView searchGoal(@RequestParam String keyword)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("goal",employeeService.search(keyword));
		mv.setViewName(page);
		
		return mv;
	}
	
	
	
	
	@GetMapping("/employee/manager")
	public ModelAndView showManager(Authentication authentication)
	{
		ModelAndView mv = new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);
		mv.addObject("manager",employeeService.getManager(employee));
		mv.setViewName("EmployeeManager");
		return mv;
	}
	
	
	@GetMapping("employee/add/{goalId}")
	public ModelAndView addGoal(ModelAndView mv,Authentication authentication,@PathVariable long goalId)
	{
		
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);
		Goal g=employeeService.getGoal(goalId);
		employeeService.assignGoal(employee,g);
		mv.addObject("goal",employeeService.getAllGoals());
		mv.setViewName(page);
		return mv;
	}
	
}
