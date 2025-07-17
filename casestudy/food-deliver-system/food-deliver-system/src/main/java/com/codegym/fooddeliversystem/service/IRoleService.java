package com.codegym.fooddeliversystem.service;

import com.codegym.fooddeliversystem.model.Role;

import java.util.Optional;

public interface IRoleService extends IGeneralService<Role> {
    Optional<Role> findByName(String roleName);
}
