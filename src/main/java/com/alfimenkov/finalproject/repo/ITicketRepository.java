package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {

    @EntityGraph(value = "ticket-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    Ticket findTicketById(long id);

    @EntityGraph(value = "ticket-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select t from Ticket t where t.user.credential.username = ?1")
    Set<Ticket> findAllByUserUsername(String login);

    void deleteTicketById(Long id);
}
