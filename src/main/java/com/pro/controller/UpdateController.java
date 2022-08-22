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
public class UpdateController {
	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeEntity emp;

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@RequestParam("name") String name, @RequestParam("salary") String salary,@RequestParam("id") String id) 
	{

		emp.setName(name);
		emp.setSalary(Integer.parseInt(salary));
	//	emp.setEmpId(Integer.parseInt(id));
		int Id= Integer.parseInt(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");

		String res = null;

		if (service.updateEmployee(emp,Id)) {
			res = "employee details saved in database Successfully!!!";
			mv.addObject("res", res);
		} else {
			res = "unable to save employee details in database!!!";
			mv.addObject("res", res);
		}
		return mv;
}
	
}