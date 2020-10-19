package com.mycompany.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.HR;

public interface HRRepository extends JpaRepository<HR,Long>{
    public Optional<HR> findByEmail(String username); 
}
