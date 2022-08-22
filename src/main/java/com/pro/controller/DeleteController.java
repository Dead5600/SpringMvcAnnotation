package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.entity.EmployeeEntity;
import com.pro.service.EmployeeService;

@Controller
public class DeleteController {

	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeEntity emp;

	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("empId") String id) {
		 int Id = Integer.parseInt(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		String res = null;
		if (service.deleteEmployee(Id))
			res="employee details deleted successfully ";
		else
			res= "Unable to delete Employee details";
		
		mv.addObject("res",res);
		return mv;
	}
	
}
