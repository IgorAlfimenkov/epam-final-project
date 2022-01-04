package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.entity.Tour;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITourRepository extends JpaRepository<Tour, Long> {


    @EntityGraph(value = "tour-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    Tour findTourById(Long id);

    @EntityGraph(value = "tour-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    Tour findTourByName(String name);

    /*@EntityGraph(value = "tour-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    List<Tour> findByOrOrderByPriceAsc();*/

    @EntityGraph(value = "tour-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    List<Tour> findToursByPrice(double price);

}
