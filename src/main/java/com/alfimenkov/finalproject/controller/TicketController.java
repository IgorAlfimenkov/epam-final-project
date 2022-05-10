package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.service.api.ISecurityExpressions;
import com.alfimenkov.finalproject.service.api.ITicketService;
import com.alfimenkov.finalproject.service.api.ITourService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
@Secured("ROLE_USER")
public class TicketController {

    private final ITicketService ticketService;
    private final ITourService tourService;
    private final ISecurityExpressions securityExpressions;

    @GetMapping("/get/{id}")
    @PreAuthorize("@securityExpressions.isTicketOwnedByUser(#id, authentication)")
    public ResponseEntity<TicketDto> findById(@PathVariable long id) {

        return ResponseEntity.ok(ticketService.findTicketById(id));
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{login}")
    public ResponseEntity<Set<TicketDto>> findByUsername(@PathVariable String login){

        return ResponseEntity.ok(ticketService.findAllByUserUsername(login));

    }


    @Secured("ROLE_ADMIN")
    @GetMapping("/all")
    public ResponseEntity<Set<TicketDto>> findAll() {

        return ResponseEntity.ok(ticketService.findAllTickets());

    }



    @PostMapping("/add")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) throws IOException {

        tourService.decrementTourQuantity(ticketDto.getTour().getId());

        return ResponseEntity.ok( ticketService.createTicket(ticketDto));
    }

    @GetMapping("/order")
    public ResponseEntity<List<TicketDto>> orderTickets(@RequestParam Optional<String> sortBy) {

        return  ResponseEntity.ok(ticketService.orderTickets(sortBy));
    }


    @PutMapping("/edit/{id}")
    @PreAuthorize("@securityExpressions.isTicketOwnedByUser(#id, authentication)")
    public ResponseEntity<TicketDto> updateTicket(@RequestBody TicketDto ticketDto, @PathVariable Long id) {

        return ResponseEntity.ok(ticketService.updateTicket(ticketDto, id));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("@securityExpressions.isTicketOwnedByUser(#id, authentication)")
    public void deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicketById(id);
    }
}
