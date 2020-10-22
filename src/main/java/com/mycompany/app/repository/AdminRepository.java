package com.mycompany.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.app.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Optional<Admin> findByEmail(String username);
    
	@Query("select a from Admin a where " + "lower(a.name) like lower(concat('%',:name,'%')) or lower(a.email) like lower(concat('%',:name,'%'))" )
	public List<Admin> findByName(@Param("name") String name);
}
