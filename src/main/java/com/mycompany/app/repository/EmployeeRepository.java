package com.mycompany.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Optional<Employee> findByEmail(String username); 

	@Query("select e from Employee e where " + "lower(e.name) like lower(concat('%',:name,'%')) or lower(e.email) like lower(concat('%',:name,'%'))" )
	public List<Employee> findByName(@Param("name") String name);

}
