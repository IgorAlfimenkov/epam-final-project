package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.RoleDto;
import com.alfimenkov.finalproject.entity.Role;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.IRoleRepository;
import com.alfimenkov.finalproject.repo.IUserRepository;
import com.alfimenkov.finalproject.service.api.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;
    private final IMapper<RoleDto, Role> roleMapper;

    public RoleDto findRoleById(Long id) {

        Role role = roleRepository.findRoleById(id);

        return roleMapper.toDto(role, RoleDto.class);
    }

    public Set<RoleDto> findAllRoles() {

        Set<Role> roles = new HashSet<>(roleRepository.findAll());

        return roleMapper.setToDto(roles,RoleDto.class);
    }

    public RoleDto createRole(RoleDto roleDto) {

        Role role = roleMapper.toEntity(roleDto, Role.class);
        role.setId(null);
        roleRepository.save(role);

        return roleMapper.toDto(role, RoleDto.class);
    }

    public RoleDto updateRole(RoleDto roleDto, Long id) {

        Role role = roleMapper.toEntity(roleDto, Role.class);
        role.setId(id);
        roleRepository.save(role);

        return roleMapper.toDto(role, RoleDto.class);
    }

    public void deleteRoleById(Long id) {

        roleRepository.deleteRoleById(id);
    }
}
