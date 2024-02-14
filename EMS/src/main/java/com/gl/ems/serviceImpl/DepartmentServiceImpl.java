package com.gl.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.dto.DepartmentDTO;
import com.gl.ems.entity.Department;
import com.gl.ems.exception.ResourceNotFoundException;
import com.gl.ems.mapper.DepartmentMapper;
import com.gl.ems.repository.DepartmentRepository;
import com.gl.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired 
	DepartmentRepository deptRepository;

	@Override
	public DepartmentDTO createDepartment(DepartmentDTO dto) {
		Department department = DepartmentMapper.mapToDepartment(dto);
		return DepartmentMapper.mapToDepartmentDTO(deptRepository.save(department)); 
		
	}

	@Override
	public DepartmentDTO getDepartmentById(int id){
		
		Department d = null;
		d = deptRepository.findById(id).
				orElseThrow(  () -> new ResourceNotFoundException("Department is not exists with a given id: "+ id));
		return DepartmentMapper.mapToDepartmentDTO(d);
	}

	@Override
	public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, int id) {
		
		Department d = null;
		d = deptRepository.findById(id).
				orElseThrow(  () -> new ResourceNotFoundException("Department does not exists with a given id: "+ id));
		d.setDepartmentName(departmentDTO.getDepartmentName());
		d.setDepartmentDescription(departmentDTO.getDepartmentDescription());
		return DepartmentMapper.mapToDepartmentDTO(deptRepository.save(d));
		
	}

	@Override
	public List<DepartmentDTO> getAllDepartments() {
		
		List<Department> list = deptRepository.findAll();
		return list.stream().map((dept) -> DepartmentMapper.mapToDepartmentDTO(dept)).collect(Collectors.toList());
	}

	@Override
	public void deleteDepartmentById(int id) {

		Department d = null;
		d = deptRepository.findById(id).
				orElseThrow(  () -> new ResourceNotFoundException("Department does not exists with a given id: "+ id));
		deptRepository.deleteById(id);
	}
}
