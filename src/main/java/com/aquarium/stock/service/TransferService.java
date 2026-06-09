package com.aquarium.stock.service;

import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
    
    private final TransferRepository transferRepository;

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
