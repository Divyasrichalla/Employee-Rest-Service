package com.example.employeeservice.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
	private int id;
	private String name;
	private String phnNum;
	private String city;
}
