package com.aquarium.stock.repository;

import com.aquarium.stock.entity.Loss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LossRepository extends JpaRepository<Loss, Long> {
    /**
     * 魚種IDをもとにロスの合計を返す
     * @param fishSpeciesId 魚種ID
     * @return ロスの合計
     */
    @Query("SELECT COALESCE(SUM(l.quantity), 0) FROM Loss l WHERE l.fishSpecies.id = :fishSpeciesId")
    Integer sumQuantityByFishSpeciesId(@Param("fishSpeciesId") Long fishSpeciesId);
}
