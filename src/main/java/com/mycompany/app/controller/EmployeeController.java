package com.mycompany.app.controller;

import org.apache.log4j.Logger;
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
	
	private static final String EMPLOYEEGOAL="EmployeeGoal";
	private static final String EMPLOYEE="employee";
	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

		@GetMapping("/employee")
		public ModelAndView showEmployee(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);	
		mv.addObject("a",employeeService.getAllAssignedGoal(employee));
		mv.setViewName(EMPLOYEE);
		return mv;
	}
	
	@GetMapping("/employee/complete/{id}")
	public ModelAndView completeGoal(@PathVariable long id,Authentication authentication)
	{
		ModelAndView mv=new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);
		boolean isCompleted=employeeService.completeGoal(id);
		if(isCompleted) {
			LOGGER.info("Goal Completion has been done successfully");
		} else {
			LOGGER.info("Goal Completion has not been done");
		}
		mv.addObject("a",employeeService.getAllAssignedGoal(employee));
		mv.setViewName(EMPLOYEE);
		return mv;
	}
	

	@GetMapping("employee/profile")
	public ModelAndView viewProfile(Authentication authentication)
	{
		ModelAndView mv= new ModelAndView();
		String username=authentication.getName();
		Employee employee=employeeService.getEmployee(username);
		mv.addObject(EMPLOYEE,employee);
		mv.setViewName("employeeProfile");
		return mv;
	}
	
	
	@GetMapping("/employee/goals")
	public ModelAndView showGoals()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("goal",employeeService.getAllGoals());
		mv.setViewName(EMPLOYEEGOAL);
		return mv;
	}
	
	@RequestMapping("/employee/search")
	public ModelAndView searchGoal(@RequestParam String keyword)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("goal",employeeService.search(keyword));
		mv.setViewName(EMPLOYEEGOAL);
		
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
		boolean isInserted = employeeService.assignGoal(employee,g);
		if(isInserted) {
			LOGGER.info("Goal Assigned has been added successfully");
		} else {
			LOGGER.info("Goal has not been Assigned");
		}
		mv.addObject("goal",employeeService.getAllGoals());
		mv.setViewName(EMPLOYEEGOAL);
		return mv;
	}
	
}
