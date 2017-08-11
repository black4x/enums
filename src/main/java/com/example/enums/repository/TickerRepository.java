package com.example.enums.repository;


import com.example.enums.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TickerRepository extends JpaRepository<Ticker, Long> {
}
