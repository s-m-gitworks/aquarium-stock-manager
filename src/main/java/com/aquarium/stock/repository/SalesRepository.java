package com.aquarium.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquarium.stock.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    /**
     * 魚種IDと店舗IDをもとにその店舗からの販売数の合計数量を返す
     * @param fishSpeciesId 魚種ID
     * @param storeId 店舗ID
     * @return 販売数の合計数量
     */
    @Query("SELECT COALESCE(SUM(s.quantity), 0) FROM Sales s WHERE s.fishSpecies.id = :fishSpeciesId AND s.store.id = :storeId")
    Integer sumQuantityByFishSpeciesIdAndStoreId(@Param("fishSpeciesId") Long fishSpeciesId, @Param("storeId") Long storeId);
}
