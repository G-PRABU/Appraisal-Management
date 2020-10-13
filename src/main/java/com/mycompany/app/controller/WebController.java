package com.mycompany.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.model.*;
import com.mycompany.app.service.AdminServiceImpl;

@Controller
public class WebController {
    
	@Autowired
	AdminServiceImpl adminService;
	
	@PostMapping("/employee")
    public ModelAndView createEmployee(@RequestParam("empName") String name,@RequestParam("empEmail") String email,
    		@RequestParam("empPhone") String phone) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		Employee e = new Employee();
		e.setName(name);
        e.setEmail(email);
        adminService.saveEmployee(e);
		mv.addObject("employee",e);
    	return mv;
    }
	
	@GetMapping("/emp")
	public ModelAndView showSample() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sample");
		return mv;
	}
}
