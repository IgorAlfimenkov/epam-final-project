package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.UserDto;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.service.UserServiceImpl;
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

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable long id, Model model){

        UserDto user =  userServiceImpl.findUser(id);
        model.addAttribute("user", user);
        return "test.html";
    }

    @PostMapping("/register")
    public String createUser(@RequestBody UserDto userDto) {

        userServiceImpl.createUser(userDto);

        return "test.html";
    }


    @PutMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {

        userServiceImpl.updateUser(userDto, id);

        return "test.html";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userServiceImpl.deleteUser(id);

        return "test.html";
    }

    @GetMapping("/all")
    public String deleteUser(Model model) {

        Set<UserDto> users = userServiceImpl.findAllUsers();
        model.addAttribute("users", users);

        return "allUsers.html";

    }
}
