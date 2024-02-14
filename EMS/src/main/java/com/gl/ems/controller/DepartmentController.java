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

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;
import com.gl.ems.service.DepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@PostMapping
	ResponseEntity<DepartmentDTO> createDepartment (@RequestBody DepartmentDTO departmentDTO){
		DepartmentDTO dept = deptService.createDepartment(departmentDTO);
		return new ResponseEntity(dept, HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable ("id") int id){
		DepartmentDTO dept = deptService.getDepartmentById(id);
		return new ResponseEntity(dept,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity <DepartmentDTO> updateDepartmentById(@PathVariable ("id") int id,@RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO dept = deptService.updateDepartmentById(departmentDTO, id);
		return new ResponseEntity(dept,HttpStatus.OK);
		
	}
	

	@DeleteMapping("{id}")
	ResponseEntity <Department> deleteDepartmentById(@PathVariable ("id") int id) {
		deptService.deleteDepartmentById(id);
		return new ResponseEntity("Department deleted successfully",HttpStatus.OK);
		
	}
	
	@GetMapping
	ResponseEntity <List<DepartmentDTO>> getAllDepartments() {
		List<DepartmentDTO> list = deptService.getAllDepartments();
		return new ResponseEntity(list,HttpStatus.OK);
		
	}
}
