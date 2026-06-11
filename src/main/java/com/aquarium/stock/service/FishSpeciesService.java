package com.aquarium.stock.service;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.repository.ArrivalRepository;
import com.aquarium.stock.repository.FishSpeciesRepository;
import com.aquarium.stock.repository.LossRepository;
import com.aquarium.stock.repository.SalesRepository;
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

    /**
     * 魚種IDをもとに在庫数を計算する関数
     * @param fishSpeciesId 魚種ID
     * @return 現在の在庫数
     */
    public Integer calculateStock(Long fishSpeciesId){
        Integer arrived = arrivalRepository.sumQuantityByFishSpeciesId(fishSpeciesId);
        Integer sold = salesRepository.sumQuantityByFishSpeciesId(fishSpeciesId);
        Integer lost = lossRepository.sumQuantityByFishSpeciesId(fishSpeciesId);
        Integer transferred = transferRepository.sumQuantityByFishSpeciesId(fishSpeciesId);
        return arrived - sold - lost - transferred;
    }

    /**
     * すべての魚種の在庫数を計算する関数
     * @return 魚種名と在庫数のリスト
     */
    public List<FishSpeciesStockDto> calculateStockforAll(){
        List<FishSpecies> allSpecies = fishSpeciesRepository.findAll();
        List<FishSpeciesStockDto> result = new ArrayList<>();

        for(FishSpecies species : allSpecies){
            Integer stock = calculateStock(species.getId());
            result.add(new FishSpeciesStockDto(species.getName(), stock));
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