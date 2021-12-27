package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {


    @EntityGraph(value = "category-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    Category findById(long id);

    Category findByName(String name);
}
