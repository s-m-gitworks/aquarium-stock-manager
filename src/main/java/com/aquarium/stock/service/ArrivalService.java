package com.aquarium.stock.service;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.repository.ArrivalRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArrivalService {
    
    private final ArrivalRepository arrivalRepository;
    
    /**
     * 全件取得
     * @return 入荷リスト
     */
    public List<Arrival> findAll() {
        return arrivalRepository.findAll();
    }
    
    /**
     * 登録・更新
     * @param arrival 入荷
     * @return 登録・更新した入荷
     */
    public Arrival save(Arrival arrival) {
        return arrivalRepository.save(arrival);
    }
    
    /**
     * 削除
     * @param id 入荷ID
     */
    public void delete(Long id) {
        arrivalRepository.deleteById(id);
    }
}
