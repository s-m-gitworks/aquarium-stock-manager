package com.aquarium.stock.repository;

import com.aquarium.stock.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>{}
