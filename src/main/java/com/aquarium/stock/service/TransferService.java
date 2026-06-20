package com.aquarium.stock.service;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.repository.ArrivalRepository;
import com.aquarium.stock.repository.TransferRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferService {
    
    private final TransferRepository transferRepository;
    private final ArrivalRepository arrivalRepository;

    /**
     * 全件取得
     * @return 移動リスト
     */
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    /**
     * 登録・更新
     * @param transfer 移動
     * @return 登録・更新した移動
     */
    public Transfer save(Transfer transfer) { 
        Optional<Arrival> recentArrival = arrivalRepository.findTopByFishSpecies_IdOrderByArrivalDateDesc(transfer.getFishSpecies().getId());
        Double costPrice = recentArrival
        .orElseThrow(() -> new IllegalStateException("入荷履歴が見つかりません: fishSpeciesId=" + transfer.getFishSpecies().getId()))
        .getCostPrice() * transfer.getQuantity();
        transfer.setTransferAmount(costPrice);
        return transferRepository.save(transfer);
    }

    /**
     * 削除
     * @param id 移動ID
     */
    public void delete(Long id) {
        transferRepository.deleteById(id);
    }
}
