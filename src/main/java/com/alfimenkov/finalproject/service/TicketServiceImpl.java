package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ITicketRepository;
import com.alfimenkov.finalproject.service.api.ITicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements ITicketService {

    private final ITicketRepository ticketRepository;
    private final IMapper<TicketDto, Ticket> ticketMapper;

    public TicketDto findTicketById(long id){

        Ticket ticket = ticketRepository.findById(id);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

    public Set<TicketDto> findAllByUserLogin(String login) {

        Set<Ticket> userTickets = ticketRepository.findAllByUserLogin(login);

        return ticketMapper.setToDto(userTickets, TicketDto.class);
    }

    public Set<TicketDto> findAllTickets() {

        Set<Ticket> tickets = new HashSet<>(ticketRepository.findAll());

        return ticketMapper.setToDto(tickets, TicketDto.class);
    }

    public TicketDto createTicket(TicketDto ticketDto) {

        Ticket ticket = ticketMapper.toEntity(ticketDto, Ticket.class);
        ticket.setId(null);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ticket.setDate(timestamp);
        ticketRepository.save(ticket);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

    public TicketDto updateTicket(TicketDto ticketDto, Long id) {

        Ticket ticket = ticketMapper.toEntity(ticketDto, Ticket.class);
        ticket.setId(id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ticket.setDate(timestamp);
        ticketRepository.save(ticket);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

    public void deleteTicketById(Long id) {

        ticketRepository.deleteTicketById(id);
    }

}
