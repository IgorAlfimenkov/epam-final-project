package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.SendTicketMessageDto;
import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.mapper.IMapper;
import com.alfimenkov.finalproject.repo.ITicketRepository;
import com.alfimenkov.finalproject.repo.ITourRepository;
import com.alfimenkov.finalproject.repo.IUserRepository;
import com.alfimenkov.finalproject.service.api.ITicketService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements ITicketService {

    private final MessageProducerService messageProducerService;
    private final ITourRepository tourRepository;
    private final ITicketRepository ticketRepository;
    private final IUserRepository userRepository;
    private final IMapper<TicketDto, Ticket> ticketMapper;

    public TicketDto findTicketById(long id){

        Ticket ticket = ticketRepository.findTicketById(id);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

    public Set<TicketDto> findAllByUserUsername(String username) {

        Set<Ticket> userTickets = ticketRepository.findAllByUserUsername(username);

        return ticketMapper.setToDto(userTickets, TicketDto.class);
    }

    public Set<TicketDto> findAllTickets() {

        Set<Ticket> tickets = new HashSet<>(ticketRepository.findAll());

        return ticketMapper.setToDto(tickets, TicketDto.class);
    }

    public TicketDto createTicket(TicketDto ticketDto) {


        User user = userRepository.findUserById(ticketDto.getUser().getId());
        Ticket ticket = ticketMapper.toEntity(ticketDto, Ticket.class);
        ticket.setId(null);
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        ticket.setOrderDate(currentDate);
        user.getTickets().add(ticket);
        ticket.setUser(user);
        userRepository.save(user);
        ticketRepository.save(ticket);
        String tourName = tourRepository.getById(ticketDto.getTour().getId()).getName();
        TicketDto savedTicket = ticketMapper.toDto(ticket, TicketDto.class);
        messageProducerService.sendUserTicketPdf(new SendTicketMessageDto().setCustomerName(ticket.getCustomerName())
                .setCustomerSurname(ticket.getCustomerSurname())
                .setDate(ticket.getDate())
                .setOrderDate(currentDate)
                .setTourName(tourName)
                .setUserName(user.getName()));
        return savedTicket;
    }

    public TicketDto updateTicket(TicketDto ticketDto, Long id) {

        Ticket ticket = ticketMapper.toEntity(ticketDto, Ticket.class);
        ticket.setId(id);
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        ticket.setDate(currentDate);
        ticketRepository.save(ticket);

        return ticketMapper.toDto(ticket, TicketDto.class);
    }

    @Override
    public List<TicketDto> orderTickets(Optional<String> sortBy) {
        List<Ticket> tickets = ticketRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy.orElse("id")));

        return ticketMapper.listToDto(tickets, TicketDto.class);
    }

    public void deleteTicketById(Long id) {

        ticketRepository.deleteTicketById(id);
    }

}
