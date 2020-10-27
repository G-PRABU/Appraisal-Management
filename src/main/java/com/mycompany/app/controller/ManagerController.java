package com.mycompany.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.GoalRating;
import com.mycompany.app.model.Manager;
import com.mycompany.app.pojo.GoalRatingPOJO;
import com.mycompany.app.service.EmployeeServiceImpl;
import com.mycompany.app.service.ManagerServiceImpl;

@Controller
public class ManagerController {
	@Autowired
	ManagerServiceImpl managerService;
	
	@Autowired
	EmployeeServiceImpl employeeService;
	
	private static final String EMPLOYEE = "employee";
	private static final int OUTSTANDING=5;
	private static final int GOOD=4;
	private static final int FAIR=3;
	private static final int IMPROVEMENT=2;
	private static final int UNSATISFACTORY=1;
	private static final Logger LOGGER = Logger.getLogger(ManagerController.class);
	
	@GetMapping("/manager")
	public ModelAndView showManager(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		Manager manager=managerService.getManager(authentication.getName());
		mv.setViewName("manager");
		mv.addObject("listEmployee",managerService.getAllEmployees(manager));
		return mv;
	}
	
	@GetMapping("/manager/manager_profile")
	public ModelAndView showProfile(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerProfile");
		String email=authentication.getName();
		Manager manager= managerService.getManager(email);
		mv.addObject("manager", manager);
		return mv;
	}
	
	@RequestMapping("/manager/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Employee> result = managerService.searchEmployees(keyword);
		ModelAndView mav = new ModelAndView("managerSearch");
		mav.addObject("result", result);
		return mav;		
	}	

	
	@RequestMapping("/manager/viewprofile")
	public ModelAndView profile(@RequestParam long id)
	{
		ModelAndView mav= new ModelAndView();
		mav.setViewName("managerEmployeeProfile");
		List<AssignedGoal> assignedGoal=employeeService.getAllAssignedGoal(managerService.getEmployee(id));
		mav.addObject("a",assignedGoal);
		mav.addObject(EMPLOYEE, managerService.getEmployee(id));
		return mav;
	}
	
	@GetMapping("/manager/review/{empId}/{id}")
	public ModelAndView goals(@PathVariable long id,@PathVariable long empId)
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("outstanding",OUTSTANDING);
		mv.addObject("good",GOOD);
		mv.addObject("fair",FAIR);
		mv.addObject("improvement",IMPROVEMENT);
		mv.addObject("unsatisfactory",UNSATISFACTORY);
		mv.addObject("assignedGoal",id);
		mv.setViewName("managerEmployeeGoal");
		mv.addObject(EMPLOYEE, managerService.getEmployee(empId));
		return mv;
	}

	@PostMapping("manager/reviewgoal/{empId}/{id}")
	public ModelAndView reviewGoal(@PathVariable long empId,@PathVariable long id,@ModelAttribute("goalRating") GoalRatingPOJO goalRating,BindingResult result,ModelAndView mv)
	{		
		GoalRating gr=new GoalRating();
		BeanUtils.copyProperties(goalRating,gr);
		boolean isInserted=managerService.saveRating(gr,id);
		if(isInserted) {
			LOGGER.info("Rating has been added successfully");
		} else {
			LOGGER.info("Rating has not added in database");
		}
		List<AssignedGoal> assignedGoal=employeeService.getAllAssignedGoal(managerService.getEmployee(empId));
		mv.addObject("a",assignedGoal);
		mv.addObject(EMPLOYEE, managerService.getEmployee(empId));
		mv.setViewName("managerEmployeeProfile");
		return mv;
	}
	
	@ModelAttribute("goalRating")
	public GoalRatingPOJO rateGoal()
	{
		return new GoalRatingPOJO();
	}
	

}
