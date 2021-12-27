package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.entity.Tour;
import com.alfimenkov.finalproject.service.TourServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/tour")
public class TourController {

    private final TourServiceImpl tourService;

    @GetMapping("/all")
    public String getAll(Model model) {

        List<Tour> tours = tourService.getAllTours();
        model.addAttribute("tours", tours);
        return "allTours.html";

    }

    @GetMapping("/get/{id}")
    public String getTour(@PathVariable Long id, Model model) {

        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);
        return "tourPage.html";
    }
}
