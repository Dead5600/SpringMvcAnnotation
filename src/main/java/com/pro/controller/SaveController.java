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
public class SaveController {

	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeEntity emp;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@RequestParam("name") String name, @RequestParam("salary") String salary) {

		System.out.println(name);
		System.out.println(salary);
		emp.setName(name);
		emp.setSalary(Integer.parseInt(salary));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");

		String res = null;

		if (service.saveEmployee(emp)) {
			res = "employee details saved in database Successfully!!!";
			mv.addObject("res", res);
		} else {
			res = "unable to save employee details in database!!!";
			mv.addObject("res", res);
		}
		return mv;
	}
}
