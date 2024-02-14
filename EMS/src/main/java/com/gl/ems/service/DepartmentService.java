package com.gl.ems.service;

import java.util.List;

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;

public interface DepartmentService {

	DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
	DepartmentDTO getDepartmentById(int id);
	DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO,int id);
	List<DepartmentDTO> getAllDepartments();
	void deleteDepartmentById(int id);
}
