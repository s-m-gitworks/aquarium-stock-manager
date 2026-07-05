package com.aquarium.stock.service;

import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.entity.SalesUnit;
import com.aquarium.stock.repository.SalesPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * 特定の魚種の販売価格を取得
     * @param fishSpeciesId 魚種ID
     * @param quantity 数量
     * @param unit 単位
     * @return 販売価格
     */
    public Optional<SalesPrice> findByFishSpeciesId(Long fishSpeciesId, Integer quantity, SalesUnit unit) {
        return salesPriceRepository.findByFishSpeciesIdAndQuantityAndUnit(fishSpeciesId, quantity, unit);
    }

    /**
     * 登録・更新
     * @param salesPrice 販売価格
     * @return 登録・更新した販売価格
     */
    public SalesPrice save(SalesPrice salesPrice) {
        int priceIncludingTax = (int) Math.floor(salesPrice.getPriceExcludingTax() * 1.1);
        salesPrice.setPriceIncludingTax(priceIncludingTax);
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
