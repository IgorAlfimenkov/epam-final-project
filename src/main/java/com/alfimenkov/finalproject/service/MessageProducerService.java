package com.alfimenkov.finalproject.service;

import com.alfimenkov.finalproject.dto.SendTicketMessageDto;
import com.alfimenkov.finalproject.dto.TicketDto;
import com.alfimenkov.finalproject.dto.UserRegistrationMessageDto;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.mapper.IMapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Value("${spring.rabbitmq.exchange}")
    private String mailExchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String mailRoutingKey;
    @Value("${spring.rabbitmq.ticket.exchange}")
    private String ticketExchange;
    @Value("${spring.rabbitmq.ticket.routingkey}")
    private String ticketRoutingKey;

    private final IMapper<UserRegistrationMessageDto, User> userRegistrationMapper;
    private RabbitTemplate rabbitTemplate;

    public MessageProducerService(IMapper<UserRegistrationMessageDto, User> userRegistrationMapper, RabbitTemplate rabbitTemplate) {
        this.userRegistrationMapper = userRegistrationMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendUserRegistrationMessage(UserRegistrationMessageDto userDto) {
        rabbitTemplate.convertAndSend(mailExchange, mailRoutingKey, userDto);
        System.out.println("User registration message was sent to mail sender service.");
    }

    public void sendUserTicketPdf(SendTicketMessageDto ticketDto) {
        rabbitTemplate.convertSendAndReceive(ticketExchange, ticketRoutingKey, ticketDto);
        System.out.println("User ticket was sent.");
    }

}
