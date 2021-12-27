package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Tour;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITourRepository extends JpaRepository<Tour, Long> {


    @EntityGraph(value = "tour-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    Tour findTourById(Long id);

    Tour findTourByName(String name);
    List<Tour> findToursByCategories(String categoryName);
    List<Tour> findToursByPrice(double price);
    List<Tour> findByPriceBetween(double price1, double price2 );
    //save
    //delete
    //findAll

}
