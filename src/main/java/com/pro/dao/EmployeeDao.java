package com.pro.dao;

import java.util.List;

import com.pro.entity.EmployeeEntity;

public interface EmployeeDao {

	public boolean saveEmployee(EmployeeEntity entity);
	
	public EmployeeEntity getEmployeeById(int Id);
	
	public List<EmployeeEntity> getAllEmployee();
	
	public boolean updateEmployee(EmployeeEntity entity, int Id);
	
	public boolean deleteEmployee(int Id);
}
