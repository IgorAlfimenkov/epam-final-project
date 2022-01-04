package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.mapper.IMapper;
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
    private final IMapper<TicketDto, Ticket> ticketMapper;

    public TicketDto findById(long id){

        Ticket ticket = ticketRepository.findById(id);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

    public TicketDto findByUserLogin(String login) {

        Ticket ticket = ticketRepository.findByUserLogin(login);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

}
