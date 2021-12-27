package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.repo.ITicketRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl {

    private final ITicketRepository ticketRepository;

    public Ticket findById(long id){

        Ticket ticket = ticketRepository.findById(id);

        return ticket;
    }
}
