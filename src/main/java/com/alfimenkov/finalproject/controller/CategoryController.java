package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.repo.ICategoryRepository;
import com.alfimenkov.finalproject.service.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {

        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category.html";
    }
}
