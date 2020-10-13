package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
