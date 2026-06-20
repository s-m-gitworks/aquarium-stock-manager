package com.aquarium.stock.repository;

import com.aquarium.stock.entity.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArrivalRepository extends JpaRepository<Arrival, Long> {
    /**
     * 魚種IDと店舗IDをもとにその店舗への入荷量の合計数量を返す
     * @param fishSpeciesId 魚種ID
     * @param storeId 店舗ID
     * @return 入荷量の合計数量
     */
    @Query("SELECT COALESCE(SUM(a.quantity),0) FROM Arrival a WHERE a.fishSpecies.id = :fishSpeciesId AND a.store.id = :storeId")
    Integer sumQuantityByFishSpeciesIdAndStoreId(@Param("fishSpeciesId") Long fishSpeciesId, @Param("storeId") Long storeId);

    /**
     * 魚種IDをもとに直近の入荷を1件取得する
     * @param fishSpeciesId 魚種ID
     * @return 直近の入荷
     */
    Optional<Arrival> findTopByFishSpecies_IdOrderByArrivalDateDesc(Long fishSpeciesId);

}
