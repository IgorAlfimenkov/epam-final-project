package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.CategoryDto;
import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ICategoryRepository;
import com.alfimenkov.finalproject.service.api.ICategoryService;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    private final IMapper<CategoryDto, Category> categoryMapper;

    public CategoryDto findCategoryById(Long id) {

        Category category = categoryRepository.findCategoryById(id);
        return categoryMapper.toDto(category, CategoryDto.class);
    }

    public CategoryDto findByName(String name) {

        Category category = categoryRepository.findByName(name);

        return categoryMapper.toDto(category,CategoryDto.class);
    }

    public Set<CategoryDto> findAllCategories() {

        Set<Category> categories = new HashSet<>(categoryRepository.findAll());

        return categoryMapper.setToDto(categories, CategoryDto.class);
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {

        Category category = categoryMapper.toEntity(categoryDto, Category.class);
        category.setId(null);
        categoryRepository.save(category);

        return categoryMapper.toDto(category,CategoryDto.class);
    }

    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {

        Category category = categoryMapper.toEntity(categoryDto, Category.class);
        category.setId(id);
        categoryRepository.save(category);

        return categoryMapper.toDto(category, CategoryDto.class);
    }

    public void deleteCategory(Long id) {

        categoryRepository.deleteCategoryById(id);
    }
}
