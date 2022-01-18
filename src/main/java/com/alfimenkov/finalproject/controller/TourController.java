package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.RequestRoleDto;
import com.alfimenkov.finalproject.dto.AbstractTourDto;
import com.alfimenkov.finalproject.dto.TourDto;
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
    public ResponseEntity<Set<? extends AbstractTourDto>> findAll(@RequestBody RequestRoleDto requestRoleDto) {

       return ResponseEntity.ok(tourService.getAllTours(requestRoleDto));
    }


    @GetMapping("/get/{id}")
    @PreAuthorize("@securityExpressions.isVip(#requestRoleDto, authentication)")
    public ResponseEntity<AbstractTourDto> findTour(@PathVariable Long id, @RequestBody RequestRoleDto requestRoleDto) {

        return ResponseEntity.ok(tourService.getTourById(id,requestRoleDto));
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
    @PreAuthorize("@securityExpressions.isVip(#requestRoleDto, authentication)")
    public ResponseEntity<Set<? extends AbstractTourDto>> findToursByPrice(@RequestParam int price,
                                                                           @RequestBody RequestRoleDto requestRoleDto) {

        return ResponseEntity.ok(tourService.findToursByPrice(price, requestRoleDto));
    }

    @GetMapping("/order")
    @PreAuthorize("@securityExpressions.isVip(#requestRoleDto, authentication)")
    public ResponseEntity<List<? extends AbstractTourDto>> findTourOrderedByPrice(@RequestParam Optional<String> sortBy,
                                                                                  @RequestBody RequestRoleDto
                                                                                          requestRoleDto) {

        return ResponseEntity.ok(tourService.findToursOrderParam(sortBy, requestRoleDto));
    }

    @GetMapping("/order-price")
    @PreAuthorize("@securityExpressions.isVip(#requestRoleDto, authentication)")
    public ResponseEntity<List<? extends AbstractTourDto>> orderToursByPrice(@RequestBody RequestRoleDto
                                                                                          requestRoleDto) {

        return ResponseEntity.ok(tourService.orderToursByPrice(requestRoleDto));
    }

}
