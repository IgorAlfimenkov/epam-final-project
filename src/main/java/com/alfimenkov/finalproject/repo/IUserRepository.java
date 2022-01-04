package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {


    @EntityGraph(value = "user-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    User findUserById(long id);

    @EntityGraph(value = "user-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    User findByLogin(String login);

    void deleteById(Long id);


}
