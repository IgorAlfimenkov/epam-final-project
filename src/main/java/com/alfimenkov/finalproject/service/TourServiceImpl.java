package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.*;
import com.alfimenkov.finalproject.entity.Tour;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ITourRepository;
import com.alfimenkov.finalproject.service.api.ITourService;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TourServiceImpl implements ITourService {


    private final ITourRepository tourRepository;
    private final IMapper<TourDto, Tour> tourMapper;
    private final IMapper<UserPriceTourDto, Tour> tourMapper2;
    private final IMapper<VipPriceTourDto, Tour> tourMapper3;


    public TourDto getTourById(Long id) {

        Tour tour  = tourRepository.findTourById(id);
        TourDto tourDto = tourMapper.toDto(tour, TourDto.class);

        return tourDto;
    }

    public Set<? extends TourDto> getAllTours(RequestRoleDto requestRoleDto) {

        Set<Tour> tours = new HashSet<>(tourRepository.findAll());
        Set<? extends TourDto> toursDto;
        if(requestRoleDto.isVip()){
            toursDto  = tourMapper3.setToDto(tours, VipPriceTourDto.class);
        } else
         toursDto = tourMapper2.setToDto(tours, UserPriceTourDto.class);
        return toursDto;
    }

    public TourDto createTour(TourDto tourDto) {

        Tour tour = tourMapper.toEntity(tourDto, Tour.class);
        tour.setId(null);
        tourRepository.save(tour);

        return tourMapper.toDto(tour, TourDto.class);
    }

    public TourDto updateTour(TourDto tourDto, Long id) {

        Tour tour = tourMapper.toEntity(tourDto, Tour.class);
        tour.setId(id);
        tourRepository.save(tour);

        return tourMapper.toDto(tour, TourDto.class);
    }

    public void deleteTour(Long id) {

        tourRepository.deleteById(id);
    }

    public Set<TourDto> findToursByPrice(int price) {

        Set<Tour> tours = new HashSet<>(tourRepository.findToursByPrice(price));
        return new HashSet<>(tourMapper.setToDto(tours, TourDto.class));
    }

    public void decrementTourQuantity(Long id) {

        Tour tour = tourRepository.findTourById(id);
        tour.setQuantity(tour.getQuantity()-1);

        tourRepository.save(tour);
    }



    public List<TourDto> findToursOrderedByPrice(Optional<String> sortBy) {

        List<Tour> tours = tourRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy.orElse("price")));

        return  tourMapper.listToDto(tours, TourDto.class);
    }
}
