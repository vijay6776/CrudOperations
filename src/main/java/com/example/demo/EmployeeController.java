package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		Employee addNew = service.addNew(emp);
		return new ResponseEntity<>(addNew,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) throws Exception{
		Employee employee = service.getEmployee(id);
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee emp){
	Employee updatedEmployee = service.updateEmployee(id, emp);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.ACCEPTED);
	}
	
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
    	boolean deletedEmployee = service.deleteEmployee(id);
    	return new ResponseEntity<>(deletedEmployee,HttpStatus.OK);
    }
    
    @GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployee(){
		 List<Employee> list = service.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	
	
	

}
