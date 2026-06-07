package com.aquarium.stock.repository;

import com.aquarium.stock.entity.SalesPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPriceRepository extends JpaRepository<SalesPrice, Long>{}
