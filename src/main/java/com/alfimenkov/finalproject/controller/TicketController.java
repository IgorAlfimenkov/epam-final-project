package com.alfimenkov.finalproject.controller;

import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.service.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketServiceImpl ticketService;

    @GetMapping("/get/{id}")
    public String findById(@PathVariable long id, Model model) {

        TicketDto ticket = ticketService.findById(id);
        model.addAttribute("ticket", ticket);

        return "ticket.html";
    }

    @GetMapping("/{login}")
    public String findByUserLogin(@PathVariable String login, Model model){

        TicketDto ticket = ticketService.findByUserLogin(login);
        model.addAttribute("ticket", ticket);

        return "ticket.html";
    }
}
