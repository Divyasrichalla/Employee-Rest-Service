package com.example.employeeservice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.annotation.HttpConstraint;
import java.util.List;

@RestController
public class EmployeeController {
	@Autowired
	private EmpService service;
	@GetMapping("/getDetails")
	public String getEmpDetails(){
		return "Employee Details";
	}

	@Value("${studenturl}")
	private String studenturl;
	@Value("${savestudent}")
	private String savestudent;
	@Value("${studentdeleteurl}")
	private String deleteurl;

	@PostMapping("/saveDetails")
	public EmployeeDto saveEmpDetails(@RequestBody EmployeeDto dto){
		EmployeeDto employeeDto = service.saveEmpDetails(dto);
		return employeeDto;
	}

	@PostMapping("/save")
	public Object saveDetails(@RequestBody EmployeeDto dto){
		EmployeeDto employeeDto = service.saveEmpDetails(dto);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(savestudent, employeeDto, String.class);

		return stringResponseEntity;
	}

	@GetMapping("/getAll")
	public Object getAll(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> restTemplateForEntity = restTemplate.getForEntity(studenturl, List.class);
		List list = restTemplateForEntity.getBody();
		return list;
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id){
		service.deleteById(id);
		return "Deleted Successfully";
	}

	@GetMapping("/getAllDetails")
	public List<EmployeeDto> getAllDetails(){
		List<EmployeeDto> employeeDetails = service.getEmployeeDetails();
		return employeeDetails;
	}

	@GetMapping("/getEmpDetailsbyId/{id}")
	public EmployeeDto getById(@PathVariable int id){
		EmployeeDto empByID = service.getEmpByID(id);
		return empByID;
	}

	@DeleteMapping("/delete/{id}")
	public String deletebyid(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(deleteurl);
		return "Student Records deleted";
	}
}
