package com.aquarium.stock.repository;

import com.aquarium.stock.entity.Loss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LossRepository extends JpaRepository<Loss, Long> {
    /**
     * 魚種IDと店舗IDをもとにその店舗でのロスの合計数量を返す
     * @param fishSpeciesId 魚種ID
     * @param storeId 店舗ID
     * @return ロスの合計数量
     */
    @Query("SELECT COALESCE(SUM(l.quantity), 0) FROM Loss l WHERE l.fishSpecies.id = :fishSpeciesId AND l.store.id = :storeId")
    Integer sumQuantityByFishSpeciesIdAndStoreId(@Param("fishSpeciesId") Long fishSpeciesId, @Param("storeId") Long storeId);
}
