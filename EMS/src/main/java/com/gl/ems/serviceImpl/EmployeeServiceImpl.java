package com.gl.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.dto.EmployeeDTO;
import com.gl.ems.entity.Employee;
import com.gl.ems.exception.ResourceNotFoundException;
import com.gl.ems.mapper.EmployeeMapper;
import com.gl.ems.repository.EmployeeRepository;
import com.gl.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		
		Employee emp = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee e = empRepository.save(emp);
		return EmployeeMapper.mapToEmployeeDTO(emp);
		
	}

	@Override
	public EmployeeDTO getEmployeeById(int id) {
		Employee e = null;
		e = empRepository.findById(id)
				.orElseThrow(  () -> new ResourceNotFoundException("Employee with "+ id + " does not exist"));
		
		return EmployeeMapper.mapToEmployeeDTO(e);
	}

	@Override
	public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, int id) {
		
		Employee e = empRepository.findById(id)
				.orElseThrow(  () -> new ResourceNotFoundException("Employee with "+ id + " does not exist"));
		e.setFirstName(employeeDTO.getFirstName());
		e.setLastName(employeeDTO.getLastName());
		e.setEmail(employeeDTO.getEmail());
		empRepository.save(e);
		return EmployeeMapper.mapToEmployeeDTO(e);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> list = empRepository.findAll();
		//return list;
		return list.stream().map((emp) -> EmployeeMapper.mapToEmployeeDTO(emp)).collect(Collectors.toList());
	}

	@Override
	public void deleteEmployeeById(int id) {
		Employee e = null;
		e = empRepository.findById(id)
				.orElseThrow(  () -> new ResourceNotFoundException("Employee with "+ id + " does not exist"));
		empRepository.deleteById(id);
		
	}
	
	
}
