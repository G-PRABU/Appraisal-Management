package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
