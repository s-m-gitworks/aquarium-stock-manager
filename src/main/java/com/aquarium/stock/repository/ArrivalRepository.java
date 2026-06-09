package com.aquarium.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.aquarium.stock.entity.Arrival;

public interface ArrivalRepository extends JpaRepository<Arrival, Long> {
    /**
     * 魚種IDをもとに入荷数量の合計を返す
     * @param fishSpeciesId 魚種ID
     * @return 入荷数量の合計
     */
    @Query("SELECT COALESCE(SUM(a.quantity),0) FROM Arrival aWHERE a.fishSpecies.id = :fishSpeciesId")
    Integer sumQuantityByFishSpeciesId(@Param("fishSpeciesId") Long fishSpeciesId);
}
