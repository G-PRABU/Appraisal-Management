package com.mycompany.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@PostMapping("/add")
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
	
	@GetMapping("/employee")
	public ModelAndView showEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee");
		return mv;
	}
	
	@GetMapping("/manager")
	public ModelAndView showManager() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager");
		return mv;
	}
	
	@GetMapping("/hr")
	public ModelAndView showHr() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hr");
		return mv;
	}
	
	@GetMapping("/admin/show")
	public ModelAndView showAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request,HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/";
	}
}
