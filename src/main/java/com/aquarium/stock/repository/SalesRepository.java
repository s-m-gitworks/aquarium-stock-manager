package com.aquarium.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aquarium.stock.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    
}
