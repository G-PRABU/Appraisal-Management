package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
