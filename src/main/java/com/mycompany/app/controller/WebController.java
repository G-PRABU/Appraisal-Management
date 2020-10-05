package com.mycompany.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.model.*;

@Controller
public class WebController {

	@PostMapping("/employee")
    public ModelAndView createEmployee(@RequestParam("empName") String name,@RequestParam("empDept") String dept,
    		@RequestParam("empPhone") String phone) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		Employee emp = new Employee(name,dept,phone);
		mv.addObject("employee",emp);
    	return mv;
    }
}
