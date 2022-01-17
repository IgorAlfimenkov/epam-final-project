package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.UpdateUserDto;
import com.alfimenkov.finalproject.dto.UserDto;
import com.alfimenkov.finalproject.service.api.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService userServiceImpl;

    @GetMapping("/get/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<UserDto> getUser(@PathVariable long id){

       return ResponseEntity.ok(userServiceImpl.findUser(id));

    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(userServiceImpl.createUser(userDto));
    }


    @Secured("ROLE_ADMIN")
    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto userDto) {

        return ResponseEntity.ok(userServiceImpl.updateUser(userDto, id));

    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {

        userServiceImpl.deleteUser(id);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/all")
    public ResponseEntity<Set<UserDto>> findAllUsers() {

        return ResponseEntity.ok(userServiceImpl.findAllUsers());
    }
}
