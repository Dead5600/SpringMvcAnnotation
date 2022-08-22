package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pro.entity.EmployeeEntity;
import com.pro.service.EmployeeService;

@Controller
public class GetAllController {

	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeEntity emp;
	
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public ModelAndView getAllEmployee() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		String res = service.getAllEmployee().toString();
		
		mv.addObject("res",res);
		return mv;
	}
	
}
