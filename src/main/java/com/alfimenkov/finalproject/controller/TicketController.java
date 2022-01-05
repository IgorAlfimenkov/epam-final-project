package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.service.api.ITicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final ITicketService ticketService;

    @GetMapping("/get/{id}")
    public ResponseEntity<TicketDto> findById(@PathVariable long id) {

        return ResponseEntity.ok(ticketService.findTicketById(id));
    }

    @GetMapping("/{login}")
    public ResponseEntity<Set<TicketDto>> findByUserLogin(@PathVariable String login){

        return ResponseEntity.ok(ticketService.findAllByUserLogin(login));

    }

    @GetMapping("/all")
    public ResponseEntity<Set<TicketDto>> findAll() {

        return ResponseEntity.ok(ticketService.findAllTickets());

    }

    @PostMapping("/add")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto)  {

        return ResponseEntity.ok( ticketService.createTicket(ticketDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<TicketDto> updateTicket(@RequestBody TicketDto ticketDto, @PathVariable Long id) {

        return ResponseEntity.ok(ticketService.updateTicket(ticketDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicketById(id);
    }
}
