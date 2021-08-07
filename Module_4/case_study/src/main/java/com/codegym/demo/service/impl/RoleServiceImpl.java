package com.codegym.demo.service.impl;

import com.codegym.demo.model.Role;
import com.codegym.demo.repository.RoleRepository;
import com.codegym.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
