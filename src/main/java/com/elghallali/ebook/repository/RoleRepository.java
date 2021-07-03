package com.elghallali.ebook.repository;

import com.elghallali.ebook.model.security.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
