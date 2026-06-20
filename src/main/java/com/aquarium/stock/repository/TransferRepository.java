package com.aquarium.stock.repository;

import com.aquarium.stock.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    /**
     * 魚種IDと店舗IDをもとにその店舗からの移動（出荷量）の合計数量を返す
     * @param fishSpeciesId 魚種ID
     * @param storeId 店舗ID
     * @return 出荷量の合計数量
     */
    @Query("SELECT COALESCE(SUM(t.quantity), 0) FROM Transfer t WHERE t.fishSpecies.id = :fishSpeciesId AND t.fromStore.id = :storeId")
    Integer sumOutQuantityByFishSpeciesIdAndStoreId(@Param("fishSpeciesId") Long fishSpeciesId, @Param("storeId") Long storeId);

    /**
     * 魚種IDと店舗IDをもとにその店舗への移動（入荷量）の合計数量を返す
     * @param fishSpeciesId 魚種ID
     * @param storeId 店舗ID
     * @return 入荷量の合計数量
     */
    @Query("SELECT COALESCE(SUM(t.quantity), 0) FROM Transfer t WHERE t.fishSpecies.id = :fishSpeciesId AND t.toStore.id = :storeId")
    Integer sumInQuantityByFishSpeciesIdAndStoreId(@Param("fishSpeciesId") Long fishSpeciesId, @Param("storeId") Long storeId);
}
