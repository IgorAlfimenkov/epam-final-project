package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.*;
import com.alfimenkov.finalproject.entity.Tour;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ITourRepository;
import com.alfimenkov.finalproject.service.api.ITourService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class TourServiceImpl implements ITourService {


    private final ITourRepository tourRepository;
    private final IMapper<TourDto, Tour> basicTourMapper;
    private final IMapper<? extends VipPriceTourDto, Tour> tourIMapper;


    public AbstractTourDto getTourById(Long id, RequestRoleDto requestRoleDto) {

        AbstractTourDto tourDto;
        Tour tour  = tourRepository.findTourById(id);
        if(requestRoleDto.isVip()){
            tourDto = tourIMapper.toDto(tour, VipPriceTourDto.class);
        } else
            tourDto = tourIMapper.toDto(tour, UserPriceTourDto.class);

        return tourDto;
    }

    public Set<? extends AbstractTourDto> getAllTours(RequestRoleDto requestRoleDto) {

        Set<Tour> tours = new HashSet<>(tourRepository.findAll());
        Set<? extends AbstractTourDto> toursDto;
        if(requestRoleDto.isVip()){
            toursDto  = tourIMapper.setToDto(tours, VipPriceTourDto.class);
        } else
         toursDto = tourIMapper.setToDto(tours, UserPriceTourDto.class);
        return toursDto;
    }

    public TourDto createTour(TourDto tourDto) {

        Tour tour = basicTourMapper.toEntity(tourDto, Tour.class);
        tour.setId(null);
        tourRepository.save(tour);

        return basicTourMapper.toDto(tour, TourDto.class);
    }

    public TourDto updateTour(TourDto tourDto, Long id) {

        Tour tour = basicTourMapper.toEntity(tourDto, Tour.class);
        tour.setId(id);
        tourRepository.save(tour);

        return basicTourMapper.toDto(tour, TourDto.class);
    }

    public void deleteTour(Long id) {

        tourRepository.deleteById(id);
    }

    public Set<? extends AbstractTourDto> findToursByPrice(int price, RequestRoleDto requestRoleDto) {

        Set<Tour> tours = new HashSet<>(tourRepository.findToursByPrice(price));
        Set<? extends AbstractTourDto> toursDto;
        if(requestRoleDto.isVip()){
            toursDto  = tourIMapper.setToDto(tours, VipPriceTourDto.class);
        } else
            toursDto = tourIMapper.setToDto(tours, UserPriceTourDto.class);
        return toursDto;

    }

    public void decrementTourQuantity(Long id) {

        Tour tour = tourRepository.findTourById(id);
        tour.setQuantity(tour.getQuantity()-1);

        tourRepository.save(tour);
    }



    public List<? extends AbstractTourDto> findToursOrderedByPrice(Optional<String> sortBy,  RequestRoleDto requestRoleDto) {

        List<Tour> tours = tourRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy.orElse("price")));
        List<? extends AbstractTourDto> toursDto;

        if(requestRoleDto.isVip()){
            toursDto  = tourIMapper.listToDto(tours, VipPriceTourDto.class);
        } else
            toursDto = tourIMapper.listToDto(tours, UserPriceTourDto.class);
        return toursDto;
    }

    public List<? extends AbstractTourDto> orderToursByPrice(RequestRoleDto requestRoleDto) {

        List<Tour> tours = tourRepository.orderToursByPrice();

        List<? extends AbstractTourDto> toursDto;

        if(requestRoleDto.isVip()){
            toursDto  = tourIMapper.listToDto(tours, VipPriceTourDto.class);
        } else
            toursDto = tourIMapper.listToDto(tours, UserPriceTourDto.class);
        return toursDto;
    }
}
