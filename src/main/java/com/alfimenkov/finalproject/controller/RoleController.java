package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.RoleDto;
import com.alfimenkov.finalproject.service.api.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
@Secured("ROLE_ADMIN")
public class RoleController {

    private final IRoleService roleService;

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findRoleById(@PathVariable Long id) {

        return ResponseEntity.ok(roleService.findRoleById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Set<RoleDto>> findAllRoles() {

        return ResponseEntity.ok(roleService.findAllRoles());
    }

    @PostMapping("/add")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {

        return ResponseEntity.ok(roleService.createRole(roleDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleDto, @PathVariable Long id) {

        return ResponseEntity.ok(roleService.updateRole(roleDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoleById(@PathVariable Long id) {

        roleService.deleteRoleById(id);
    }
}
