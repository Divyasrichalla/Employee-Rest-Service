package com.example.employeeservice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;

	public EmployeeDto saveEmpDetails(EmployeeDto dto){
		EmployeeEntity entity = new EmployeeEntity(dto.getId(), dto.getName(), dto.getPhnNum(), dto.getCity());
		EmployeeDto dto1 = getEmployeeDto(repo.save(entity));
		return dto1;
	}

	public EmployeeDto getEmployeeDto(EmployeeEntity entity) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPhnNum(entity.getPhnNum());
		dto.setCity(entity.getCity());
		return dto;
	}

	public void deleteById(int id){
		repo.deleteById(id);
	}

	public List<EmployeeDto> getEmployeeDetails(){
		List<EmployeeEntity> list = repo.findAll();
		List<EmployeeDto> ldto = new ArrayList<>();
		for(EmployeeEntity ee : list){
			EmployeeDto employeeDto = getEmployeeDto(ee);
			ldto.add(employeeDto);
		}
		return ldto;
	}

	public EmployeeDto getEmpByID(int id){
		Optional<EmployeeEntity> byId = repo.findById(id);
		EmployeeDto dto = null;
		if(byId.isPresent()){
			EmployeeEntity employeeEntity = byId.get();
			dto = getEmployeeDto(employeeEntity);
			return dto;
		}
		return dto;
	}
}
