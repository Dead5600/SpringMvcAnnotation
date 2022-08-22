package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.EmployeeDao;
import com.pro.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao empDao;

	@Override
	public boolean saveEmployee(EmployeeEntity entity) {
		return empDao.saveEmployee(entity);
	}

	@Override
	public EmployeeEntity getEmployeeById(int Id) {
		return empDao.getEmployeeById(Id);
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return empDao.getAllEmployee();
	}

	@Override
	public boolean updateEmployee(EmployeeEntity entity, int Id) {
		return empDao.updateEmployee(entity, Id);
	}

	@Override
	public boolean deleteEmployee(int Id) {
		//System.out.println("Object is deleted...");
		return empDao.deleteEmployee(Id);
	}

}
