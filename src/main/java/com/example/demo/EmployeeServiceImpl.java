package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addNew(Employee emp) {
	      Employee savedEmp = repository.save(emp);
	      return savedEmp;
	}

	@Override
	public Employee getEmployee(Long id) throws Exception {
		Employee employee = repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found with id : "+id));
		
		return employee;
		
	}

	@Override
	public Employee updateEmployee(Long id, Employee emp) {
		Optional<Employee> findById = repository.findById(id);
		if(findById.isPresent()) {
			Employee employee = findById.get();
			BeanUtils.copyProperties(emp, employee);
			return repository.save(employee);
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		try {
			repository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> list = repository.findAll();
		return list;
	}
	
	

}
