package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
