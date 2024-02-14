package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Employee;
import com.gl.ems.serviceImpl.EmployeeServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empService;
	
	@PostMapping
	ResponseEntity<EmployeeDTO> createEmployee (@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO e = empService.createEmployee(employeeDTO);
		return new ResponseEntity(e,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable ("id") int id){
		EmployeeDTO e = empService.getEmployeeById(id);
		return new ResponseEntity(e,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity <Employee> updateEmployeeById(@PathVariable ("id") int id,@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO e = empService.updateEmployeeById(employeeDTO, id);
		return new ResponseEntity(e,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	ResponseEntity <EmployeeDTO> deleteEmployeeById(@PathVariable ("id") int id) {
		empService.deleteEmployeeById(id);
		return new ResponseEntity("Employee deleted successfully",HttpStatus.OK);
		
	}
	
	@GetMapping
	ResponseEntity <List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> e = empService.getAllEmployees();
		return new ResponseEntity(e,HttpStatus.OK);
		
	}
	
	
}
