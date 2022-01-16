package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.RequestRoleDto;
import com.alfimenkov.finalproject.dto.SortTypeDto;
import com.alfimenkov.finalproject.dto.TourDto;
import com.alfimenkov.finalproject.dto.UserPriceTourDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITourService {

    TourDto getTourById(Long id);
    Set<? extends TourDto> getAllTours(RequestRoleDto requestRoleDto);
    TourDto createTour(TourDto tourDto);
    TourDto updateTour(TourDto tourDto, Long id);
    void deleteTour(Long id);
    Set<TourDto> findToursByPrice(int price);
    void decrementTourQuantity(Long id);
    public List<TourDto> findToursOrderedByPrice(Optional<String> sortBy);
}
