package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.HR;

public interface HRRepository extends JpaRepository<HR,Long>{

}
