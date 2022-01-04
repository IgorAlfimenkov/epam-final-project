package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.CategoryDto;
import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl {

    private final ICategoryRepository categoryRepository;
    private final IMapper<CategoryDto, Category> categoryMapper;

    public CategoryDto findById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        return categoryMapper.toDto(category, CategoryDto.class);
    }

    public CategoryDto findByName(String name) {

        Category category = categoryRepository.findByName(name);

        return categoryMapper.toDto(category,CategoryDto.class);
    }

    public Set<CategoryDto> findAll() {

        Set<Category> categories = new HashSet<>(categoryRepository.findAll());

        return categoryMapper.setToDto(categories, CategoryDto.class);
    }
}
