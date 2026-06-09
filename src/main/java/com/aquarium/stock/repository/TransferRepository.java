package com.aquarium.stock.repository;

import com.aquarium.stock.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    /**
     * 魚種IDをもとに店舗間移動の合計数量を返す
     * @param fishSpeciesId 魚種ID
     * @return 店舗間移動の合計数量
     */
    @Query("SELECT COALESCE(SUM(t.quantity), 0) FROM Transfer t WHERE t.fishSpecies.id = :fishSpeciesId")
    Integer sumQuantityByFishSpeciesId(@Param("fishSpeciesId") Long fishSpeciesId);

}
