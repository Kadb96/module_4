package com.codegym.fooddeliversystem.repository;

import com.codegym.fooddeliversystem.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
