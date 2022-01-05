package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.UserDto;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.service.UserServiceImpl;
import com.alfimenkov.finalproject.service.api.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService userServiceImpl;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id){

       return ResponseEntity.ok(userServiceImpl.findUser(id));

    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(userServiceImpl.createUser(userDto));
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {

        return ResponseEntity.ok(userServiceImpl.updateUser(userDto, id));

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {

        userServiceImpl.deleteUser(id);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<UserDto>> findAllUsers(Model model) {

        return ResponseEntity.ok(userServiceImpl.findAllUsers());
    }
}
