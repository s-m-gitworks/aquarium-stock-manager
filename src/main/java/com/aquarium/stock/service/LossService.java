package com.aquarium.stock.service;

import com.aquarium.stock.entity.Loss;
import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.repository.LossRepository;
import com.aquarium.stock.repository.ArrivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LossService {
    
    private final LossRepository lossRepository;
    private final ArrivalRepository arrivalRepository;
    
    /**
     * 全件取得
     * @return ロスデータのリスト
     */
    public List<Loss> findAll(){
        return lossRepository.findAll();
    }

    /**
     * 登録・更新
     * @param loss ロスデータ
     * @return 登録・更新したロスデータ
     */
    public Loss save(Loss loss){
        Optional<Arrival> recentArrival = arrivalRepository.findTopByFishSpecies_IdOrderByArrivalDateDesc(loss.getFishSpecies().getId());
        Double costPrice = recentArrival
        .orElseThrow(() -> new IllegalStateException("入荷履歴が見つかりません: fishSpeciesId=" + loss.getFishSpecies().getId()))
        .getCostPrice() * loss.getQuantity();
        loss.setAmount(costPrice);
        return lossRepository.save(loss);
    }

    /**
     * 削除
     * @param id ロスID
     */
    public void delete(Long id){
        lossRepository.deleteById(id);
    }
}
