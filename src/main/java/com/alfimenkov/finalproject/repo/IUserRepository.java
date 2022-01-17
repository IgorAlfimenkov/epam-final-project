package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {


    @EntityGraph(value = "user-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    User findUserById(long id);

    @EntityGraph(value = "user-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select u from User u where u.credential.username = ?1")
    User findByUsername(String login);

    void deleteById(Long id);


}
