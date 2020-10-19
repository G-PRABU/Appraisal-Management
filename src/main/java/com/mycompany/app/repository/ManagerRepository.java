package com.mycompany.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    public Optional<Manager> findByEmail(String username); 
}
