package com.mycompany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);
}
