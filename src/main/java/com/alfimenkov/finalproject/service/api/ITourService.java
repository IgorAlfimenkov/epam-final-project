package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.RequestRoleDto;
import com.alfimenkov.finalproject.dto.AbstractTourDto;
import com.alfimenkov.finalproject.dto.TourDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITourService {

    AbstractTourDto getTourById(Long id, RequestRoleDto requestRoleDto);
    Set<? extends AbstractTourDto> getAllTours(RequestRoleDto requestRoleDto);
    TourDto createTour(TourDto tourDto);
    TourDto updateTour(TourDto tourDto, Long id);
    void deleteTour(Long id);
    Set<? extends AbstractTourDto> findToursByPrice(int price,RequestRoleDto requestRoleDto);
    void decrementTourQuantity(Long id);
    List<? extends AbstractTourDto> findToursOrderedByPrice(Optional<String> sortBy, RequestRoleDto requestRoleDto);
    List<? extends AbstractTourDto> orderToursByPrice(RequestRoleDto requestRoleDto);
}
