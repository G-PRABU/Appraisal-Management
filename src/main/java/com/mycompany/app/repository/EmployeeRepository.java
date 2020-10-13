package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
