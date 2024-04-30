package com.example.demo;

import java.util.List;

public interface EmployeeService {
	
	public Employee addNew(Employee emp);
	
	public Employee getEmployee(Long id) throws Exception;
	
	public Employee updateEmployee(Long id,Employee emp);
	
	public boolean deleteEmployee(Long id);
	
	public List<Employee> getAll();

}
