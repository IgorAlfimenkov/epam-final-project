package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.TourDto;
import com.alfimenkov.finalproject.entity.Tour;
import com.alfimenkov.finalproject.service.TourServiceImpl;
import com.alfimenkov.finalproject.service.api.ITourService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/tour")
public class TourController {

    private final ITourService tourService;

    @GetMapping("/all")
    public ResponseEntity<Set<TourDto>> findAll(Model model) {

       return ResponseEntity.ok(tourService.getAllTours());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TourDto> findTour(@PathVariable Long id, Model model) {

        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TourDto> createTour(@RequestBody TourDto tourDto) {

        return ResponseEntity.ok(tourService.createTour(tourDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<TourDto> updateTour(@RequestBody TourDto tourDto, @PathVariable Long id) {

        return ResponseEntity.ok(tourService.updateTour(tourDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTour(@PathVariable Long id) {

        tourService.deleteTour(id);
    }

    @GetMapping("/")
    public ResponseEntity<Set<TourDto>> findToursByPrice(@RequestParam int price) {

        return ResponseEntity.ok(tourService.findToursByPrice(price));
    }
}
