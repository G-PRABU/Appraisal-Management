package com.mycompany.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mycompany.app.exception.GoalAssignedException;
import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Goal;
import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;
import com.mycompany.app.pojo.GoalPOJO;
import com.mycompany.app.service.EmployeeServiceImpl;
import com.mycompany.app.service.HRServiceImpl;



@Controller
public class HRController {

	@Autowired
	HRServiceImpl hrService;
	
	@Autowired
	EmployeeServiceImpl employeeService;
	
	private static final String HRGOAL="HrGoal";
	private static final String EMPLOYEE="employee";
	private static final Logger LOGGER = Logger.getLogger(HRController.class);
	private static final String MESSAGE = "message";
	private static final String GOAL_ASSIGNED_EXCEPTION = "Goal has been assigned to the Employee.";
	
	@GetMapping("/hr")
	public ModelAndView showHr(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		String username=authentication.getName();
		HR hr=hrService.getHr(username);
		
		List<Manager> manager=hrService.getAllManagers(hr);
		mv.addObject("manager",manager);
		mv.setViewName("hr");
		return mv;
	}
	
	@RequestMapping("/hr/searchManager")
	public ModelAndView searchManager(@RequestParam String keyword)
	{
		ModelAndView mv=new ModelAndView();
		List<Manager> manager=hrService.searchManager(keyword);
		mv.addObject("manager",manager);
		mv.setViewName("hr");
		return mv;
	}
	
	@GetMapping("/hr/viewManager/{id}")
	public ModelAndView viewManager(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		
		Manager manager = hrService.getManager(id);
		List<Employee> employee=hrService.getAllEmployees(manager);
		mv.addObject(EMPLOYEE,employee);
		mv.setViewName("hrViewManager");
		return mv;
	}
	
	@RequestMapping("/hr/searchEmployee")
	public ModelAndView searchEmployee(@RequestParam String keyword)
	{
		ModelAndView mv=new ModelAndView();
		List<Employee> employee=hrService.searchEmployee(keyword);
		mv.addObject(EMPLOYEE,employee);
		mv.setViewName("hrViewManager");
		return mv;
	}

	@GetMapping("/hr/view/{id}")
	public ModelAndView viewEmployee(@PathVariable long id)
	{
		ModelAndView mv=new ModelAndView();
		
		Employee employee=hrService.getEmployee(id);
		List<AssignedGoal> assignedGoal=employeeService.getAllAssignedGoal(employee);
		
		mv.addObject("a",assignedGoal);
		
		mv.addObject(EMPLOYEE,employee);
		
		mv.setViewName("hrViewEmp");
		return mv;
	}
	
	
	@GetMapping("/hr/goals")
	public ModelAndView showGoals() {
		ModelAndView mv = new ModelAndView();
		List<Goal> goals=hrService.getAllGoals();
		mv.addObject("goal",goals);
		mv.setViewName(HRGOAL);
		return mv;
	}
	
	
	
	@GetMapping(value="hr/delete/{id}")
	public String deleteGoal(@PathVariable long id) throws GoalAssignedException 
	{
		boolean isDeleted = hrService.deleteGoal(id);
		if(!isDeleted) {
			throw new GoalAssignedException(id);
		}
		return "redirect:/hr/goals";
	}
	
	
	@GetMapping(value="hr/edit/{id}")
	public ModelAndView editGoal(@PathVariable long id,ModelAndView mv)
	{
		Goal g=hrService.getGoal(id);
		mv.addObject("goalId",id);
		mv.addObject("goalName",g.getGoalName());
		mv.addObject("goalDescription",g.getGoalDescription());
		mv.addObject("goalDuration",g.getGoalDuration());
		mv.setViewName("editGoal");
		return mv;
	}
	
	
	
	
	@GetMapping("hr/profile")
	public ModelAndView viewProfile(Authentication authentication)
	{
		ModelAndView mv= new ModelAndView();
		String username=authentication.getName();
		HR hr=hrService.getHr(username);
		mv.addObject("hr",hr);
		mv.setViewName("hrProfile");
		return mv;
	}
	
	
	
	
	
	@GetMapping("/hr/add")
	public ModelAndView addGoals(ModelAndView mv)
	{
		int[] months= {1,2,3,4,5,6};
		
		mv.addObject("months",months);
		mv.setViewName("HrAddGoal");
		return mv;
	}
	
	
	@ModelAttribute("goal")
	public GoalPOJO setGoal()
	{
		return new GoalPOJO();
	}
	
	
	@PostMapping("/hr/addgoal")
	public ModelAndView addGoal(@ModelAttribute("goal") GoalPOJO goal,BindingResult result,ModelAndView mv)

	{	
		Goal g = new Goal();
		BeanUtils.copyProperties(goal,g);
		boolean isInserted = hrService.saveGoal(g);
		if(isInserted) {
			LOGGER.info("Goal has been added successfully");
		} else {
			LOGGER.info("Goal has not added in database");
		}
		List<Goal> goals=hrService.getAllGoals();
		mv.addObject("goal",goals);
		mv.setViewName(HRGOAL);
		return mv;
	}
	
	@PostMapping("/hr/addgoal/{goalId}")
	public ModelAndView updateGoal(@ModelAttribute("goal") GoalPOJO goal,BindingResult result,ModelAndView mv)

	{	
		Goal g = new Goal();
		BeanUtils.copyProperties(goal,g);
		boolean isUpdated=hrService.updateGoal(g);
		if(isUpdated) {
			LOGGER.info("Goal Updation has been added successfully");
		} else {
			LOGGER.info("Goal Updation has not added in database");
		}
		List<Goal> goals=hrService.getAllGoals();
		mv.addObject("goal",goals);
		mv.setViewName(HRGOAL);
		return mv;
	}
	
	@ExceptionHandler(GoalAssignedException.class)
	public ModelAndView hrMappedExceptionHandler() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hrExceptionHandler");
		mv.addObject(MESSAGE, GOAL_ASSIGNED_EXCEPTION);
		return mv;
	}
		
}
