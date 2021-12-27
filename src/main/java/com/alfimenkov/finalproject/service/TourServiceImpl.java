package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.entity.Tour;
import com.alfimenkov.finalproject.repo.ITourRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TourServiceImpl {


    private final ITourRepository tourRepository;

    public Tour getTourById(Long id) {

        Tour tour  = tourRepository.findTourById(id);
        //Hibernate.initialize(tour.getCategories());
        return tour;
    }

    public List<Tour> getAllTours() {


        List<Tour> tours =  tourRepository.findAll();
        tours.forEach(tour -> Hibernate.initialize(tour.getCategories()));
        return tours;
    }
}
