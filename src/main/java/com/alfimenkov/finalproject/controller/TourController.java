package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.RequestRoleDto;
import com.alfimenkov.finalproject.dto.TourDto;
import com.alfimenkov.finalproject.service.SecurityExpressions;
import com.alfimenkov.finalproject.service.api.ISecurityExpressions;
import com.alfimenkov.finalproject.service.api.ITourService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/tour")
public class TourController {

    private final ITourService tourService;
    private final ISecurityExpressions securityExpressions;



    @GetMapping("/all")
    @PreAuthorize("@securityExpressions.isVip(#requestRoleDto, authentication)")
    public ResponseEntity<Set<? extends TourDto>> findAll(@RequestBody RequestRoleDto requestRoleDto) {

       return ResponseEntity.ok(tourService.getAllTours(requestRoleDto));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<TourDto> findTour(@PathVariable Long id) {

        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public ResponseEntity<TourDto> createTour(@RequestBody TourDto tourDto) {

        return ResponseEntity.ok(tourService.createTour(tourDto));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/edit/{id}")
    public ResponseEntity<TourDto> updateTour(@RequestBody TourDto tourDto, @PathVariable Long id) {

        return ResponseEntity.ok(tourService.updateTour(tourDto, id));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    public void deleteTour(@PathVariable Long id) {

        tourService.deleteTour(id);
    }


    @GetMapping("/")
    public ResponseEntity<Set<TourDto>> findToursByPrice(@RequestParam int price) {

        return ResponseEntity.ok(tourService.findToursByPrice(price));
    }

    @GetMapping("/order")
    public ResponseEntity<List<TourDto>> findTourOrderedByPrice(@RequestParam Optional<String> sortBy) {

        return ResponseEntity.ok(tourService.findToursOrderedByPrice(sortBy));
    }
}
