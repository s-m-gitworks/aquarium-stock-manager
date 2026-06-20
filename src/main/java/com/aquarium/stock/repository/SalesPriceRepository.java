package com.aquarium.stock.repository;

import com.aquarium.stock.entity.SalesPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesPriceRepository extends JpaRepository<SalesPrice, Long>{
    Optional<SalesPrice> findByFishSpecies_Id(Long fishSpeciesId);
}