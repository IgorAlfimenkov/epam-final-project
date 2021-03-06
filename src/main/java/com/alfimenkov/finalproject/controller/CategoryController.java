package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.CategoryDto;
import com.alfimenkov.finalproject.service.api.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final ICategoryService categoryService;


    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(categoryService.findCategoryById(id));

    }

    @Secured("ROLE_USER")
    @GetMapping("/")
    public ResponseEntity<CategoryDto> findByName(@RequestParam String name) {

        return ResponseEntity.ok(categoryService.findByName(name));

    }

    @GetMapping("/all")
    public ResponseEntity<Set<CategoryDto>> findAll(Model model) {

        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category) {

        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/edit/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {

        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDto));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {

        categoryService.deleteCategory(id);
    }

}
