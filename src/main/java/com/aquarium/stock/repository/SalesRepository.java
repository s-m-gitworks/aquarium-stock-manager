package com.aquarium.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquarium.stock.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    /**
     * 魚種IDをもとに販売数量の合計を返す
     * @param fishSpeciesId 魚種ID
     * @return 販売数量の合計
     */
    @Query("SELECT COALESCE(SUM(s.quantity), 0) FROM Sales s WHERE s.fishSpecies.id = :fishSpeciesId")
    Integer sumQuantityByFishSpeciesId(@Param("fishSpeciesId") Long fishSpeciesId);

}
