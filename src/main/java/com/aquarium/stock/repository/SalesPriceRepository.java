package com.aquarium.stock.repository;

import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.entity.SalesUnit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesPriceRepository extends JpaRepository<SalesPrice, Long>{
    Optional<SalesPrice> findByFishSpeciesIdAndQuantityAndUnit(Long fishSpeciesId, Integer quantity, SalesUnit unit);
}