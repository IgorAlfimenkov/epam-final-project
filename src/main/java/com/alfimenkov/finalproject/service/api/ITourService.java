package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.TourDto;

import java.util.Set;

public interface ITourService {

    TourDto getTourById(Long id);
    Set<TourDto> getAllTours();
    TourDto createTour(TourDto tourDto);
    TourDto updateTour(TourDto tourDto, Long id);
    void deleteTour(Long id);
    Set<TourDto> findToursByPrice(int price);
    void decrementTourQuantity(Long id);
}
