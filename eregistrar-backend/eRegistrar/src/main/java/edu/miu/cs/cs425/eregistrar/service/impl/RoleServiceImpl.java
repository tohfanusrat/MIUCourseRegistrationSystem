package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.Role;
import edu.miu.cs.cs425.eregistrar.repository.RoleRepository;
import edu.miu.cs.cs425.eregistrar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
