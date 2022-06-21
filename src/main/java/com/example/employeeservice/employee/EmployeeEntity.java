package com.example.employeeservice.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class EmployeeEntity {
	@Id
	private int id;
	private String name;
	private String phnNum;
	private String city;

	public EmployeeEntity(int id, String name, String phnNum, String city) {
		this.id = id;
		this.name = name;
		this.phnNum = phnNum;
		this.city = city;
	}
}
