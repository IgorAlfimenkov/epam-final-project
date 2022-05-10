package com.alfimenkov.finalproject.service.api;

import com.alfimenkov.finalproject.dto.TicketDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITicketService {

    TicketDto findTicketById(long id);
    Set<TicketDto> findAllByUserUsername(String login);
    Set<TicketDto> findAllTickets();
    TicketDto createTicket(TicketDto ticketDto) throws IOException;
    TicketDto updateTicket(TicketDto ticketDto, Long id);
    List<TicketDto> orderTickets(Optional<String> sortBy);
    void deleteTicketById(Long id);
}
