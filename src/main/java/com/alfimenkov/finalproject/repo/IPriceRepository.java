package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Credential;
import com.alfimenkov.finalproject.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends JpaRepository<Price, Long> {

}
