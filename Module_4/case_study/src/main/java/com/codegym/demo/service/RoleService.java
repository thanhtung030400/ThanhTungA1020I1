package com.codegym.demo.service;

import com.codegym.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
    Role findByRoleName(String name);
}
