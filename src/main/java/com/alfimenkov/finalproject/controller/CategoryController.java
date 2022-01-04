package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.CategoryDto;
import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.service.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;


    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        CategoryDto category = categoryService.findById(id);
        model.addAttribute("category", category);

        return "category.html";
    }

    @GetMapping("/")
    public String findByName(@RequestParam String name, Model model) {

        CategoryDto category = categoryService.findByName(name);
        model.addAttribute("category", category);

        return "category.html";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        Set<CategoryDto> allCategories = categoryService.findAll();
        model.addAttribute("allCategories", allCategories);

        return "allCategories.html";
    }




}
