package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable long id, Model model){

        User user =  userServiceImpl.findUser(id);
        model.addAttribute("user", user);
        return "test.html";
    }
}
