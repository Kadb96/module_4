package com.codegym.fooddeliversystem.service.impl;

import com.codegym.fooddeliversystem.model.Role;
import com.codegym.fooddeliversystem.repository.IRoleRepository;
import com.codegym.fooddeliversystem.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
