package com.aquarium.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aquarium.stock.entity.Arrival;

public interface ArrivalRepository extends JpaRepository<Arrival, Long> {}
