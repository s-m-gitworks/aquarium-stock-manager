package com.aquarium.stock.service;

import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.repository.SalesPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesPriceService {
    
    private final SalesPriceRepository salesPriceRepository;

    /**
     * 全件取得
     * @return 販売価格リスト
     */
    public List<SalesPrice> findAll() {
        return salesPriceRepository.findAll();
    }

    /**
     * 登録・更新
     * @param salesPrice 販売価格
     * @return 登録・更新した販売価格
     */
    public SalesPrice save(SalesPrice salesPrice) {
        return salesPriceRepository.save(salesPrice);
    }

    /**
     * 削除
     * @param id 販売価格ID
     */
    public void delete(Long id) {
        salesPriceRepository.deleteById(id);
    }
}
