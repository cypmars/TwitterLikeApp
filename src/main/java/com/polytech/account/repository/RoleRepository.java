package com.polytech.account.repository;

import com.polytech.account.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}