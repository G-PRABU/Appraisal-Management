package com.mycompany.app.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.app.service.AdminServiceImpl;

@Controller
public class WebController {
    
	@Autowired
	AdminServiceImpl adminService;
	
	
	@GetMapping("/emp")
	public String showSample() {
		return "Sample";
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
