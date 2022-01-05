package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.TicketDto;

import java.util.Set;

public interface ITicketService {

    TicketDto findTicketById(long id);
    Set<TicketDto> findAllByUserLogin(String login);
    Set<TicketDto> findAllTickets();
    TicketDto createTicket(TicketDto ticketDto);
    TicketDto updateTicket(TicketDto ticketDto, Long id);
    void deleteTicketById(Long id);
}
