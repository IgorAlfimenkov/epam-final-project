package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {

    @EntityGraph(value = "ticket-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    Ticket findById(long id);

}
