package com.aquarium.stock.service;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Store;
import com.aquarium.stock.repository.ArrivalRepository;
import com.aquarium.stock.repository.FishSpeciesRepository;
import com.aquarium.stock.repository.LossRepository;
import com.aquarium.stock.repository.SalesRepository;
import com.aquarium.stock.repository.StoreRepository;
import com.aquarium.stock.repository.TransferRepository;
import com.aquarium.stock.dto.FishSpeciesStockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FishSpeciesService {
    
    private final FishSpeciesRepository fishSpeciesRepository;

    private final ArrivalRepository arrivalRepository;
    private final SalesRepository salesRepository;
    private final LossRepository lossRepository;
    private final TransferRepository transferRepository;
    private final StoreRepository storeRepository;

    /**
     * 魚種IDをもとに在庫数を計算する関数
     * @param fishSpeciesId 魚種ID
     * @param storeId 店舗ID
     * @return 現在の在庫数
     */
    public Integer calculateStock(Long fishSpeciesId, Long storeId){
        Integer arrived = arrivalRepository.sumQuantityByFishSpeciesIdAndStoreId(fishSpeciesId, storeId);
        Integer sold = salesRepository.sumQuantityByFishSpeciesIdAndStoreId(fishSpeciesId, storeId);
        Integer lost = lossRepository.sumQuantityByFishSpeciesIdAndStoreId(fishSpeciesId, storeId);
        Integer transferredIn = transferRepository.sumInQuantityByFishSpeciesIdAndStoreId(fishSpeciesId, storeId);
        Integer transferredOut = transferRepository.sumOutQuantityByFishSpeciesIdAndStoreId(fishSpeciesId, storeId);
        return arrived - sold - lost + transferredIn - transferredOut;
    }

    /**
     * すべての魚種の在庫数を計算する関数
     * @param storeId 店舗ID
     * @return 魚種名と在庫数のリスト
     */
    public List<FishSpeciesStockDto> calculateStockforAll(Long storeId){
        List<FishSpecies> allSpecies = fishSpeciesRepository.findAll();
        Store store = storeRepository.findById(storeId).orElseThrow();
        List<FishSpeciesStockDto> result = new ArrayList<>();

        for(FishSpecies species : allSpecies){
            Integer stock = calculateStock(species.getId(), storeId);
            result.add(new FishSpeciesStockDto(species.getName(), stock, store.getName()));
        }
        return result;
    }

    /**
     * 全件取得
     * @return 魚種リスト
     */
    public List<FishSpecies> findAll(){
        return fishSpeciesRepository.findAll();
    }

    /**
     * 登録・更新
     * @param fishSpecies 魚種
     * @return 登録・更新した魚種
     */
    public FishSpecies save(FishSpecies fishSpecies){
        return fishSpeciesRepository.save(fishSpecies);
    }

    /**
     * 削除
     * @param id 魚種ID
     */
    public void delete(Long id){
        fishSpeciesRepository.deleteById(id);
    }
}