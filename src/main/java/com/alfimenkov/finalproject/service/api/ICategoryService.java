package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.CategoryDto;

import java.util.Set;

public interface ICategoryService {

    CategoryDto findCategoryById(Long id);
    CategoryDto findByName(String name);
    Set<CategoryDto> findAllCategories();
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
