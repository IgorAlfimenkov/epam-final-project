package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.RoleDto;

import java.util.Set;

public interface IRoleService {

    RoleDto findRoleById(Long id);
    Set<RoleDto> findAllRoles();
    RoleDto createRole(RoleDto roleDto);
    RoleDto updateRole(RoleDto roleDto, Long id);
    void deleteRoleById(Long id);
}
