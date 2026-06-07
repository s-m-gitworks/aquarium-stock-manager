package com.aquarium.stock.repository;

import com.aquarium.stock.entity.FishSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishSpeciesRepository extends JpaRepository<FishSpecies, Long>{}