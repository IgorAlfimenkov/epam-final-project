package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Credential;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICredentialRepository extends JpaRepository<Credential, Long> {

    @EntityGraph(value = "credential-graph", type = EntityGraph.EntityGraphType.LOAD)
    Credential findCredentialByUsername(String username);
}
