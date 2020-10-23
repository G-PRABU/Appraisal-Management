package com.mycompany.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.app.model.HR;
import com.mycompany.app.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    public Optional<Manager> findByEmail(String username); 
    
    public List<Manager> findByHr(HR hr);
	
    @Query("select m from Manager m where " + "lower(m.name) like lower(concat('%',:name,'%')) or lower(m.email) like lower(concat('%',:name,'%'))" )
	public List<Manager> searchManager(@Param("name") String name);

}
