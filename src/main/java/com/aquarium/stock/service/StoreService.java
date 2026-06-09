package com.aquarium.stock.service;

import com.aquarium.stock.entity.Store;
import com.aquarium.stock.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    
    private final StoreRepository storeRepository;

    /**
     * 全件取得
     * @return 店舗リスト
     */
    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    /**
     * 登録・更新
     * @param store 店舗
     * @return 登録・更新した店舗
     */
    public Store save(Store store){
        return storeRepository.save(store);
    }

    /**
     * 削除
     * @param id 店舗ID
     */
    public void delete(Long id){
        storeRepository.deleteById(id);
    }
}
