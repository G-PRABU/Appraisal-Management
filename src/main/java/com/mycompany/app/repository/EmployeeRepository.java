package com.mycompany.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Manager;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Optional<Employee> findByEmail(String username); 

    public List<Employee> findByManager(Manager manager);
    
    @Query(value="SELECT e from Employee e where e.name LIKE '%' || :keyword || '%' " + "OR e.email LIKE '%' || :keyword  || '%'")
	public List<Employee> searchEmployee(@Param("keyword") String keyword);
    

}
