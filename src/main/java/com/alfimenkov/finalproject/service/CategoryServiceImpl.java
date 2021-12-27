package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.repo.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl {

    private final ICategoryRepository categoryRepository;

    public Category findById(Long id) {

        Category category = categoryRepository.findById(id).get();
        Hibernate.initialize(category.getTours());

        return category;
    }
}
