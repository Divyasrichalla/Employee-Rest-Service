package com.example.employeeservice.employee;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmpRepo extends JpaRepository<EmployeeEntity, Integer> {

}
