package com.aquarium.stock.service;

import com.aquarium.stock.entity.Sales;
import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.repository.SalesPriceRepository;
import com.aquarium.stock.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;
    private final SalesPriceRepository salesPriceRepository;

    /**
     * 全件取得
     * @return 販売リスト
     */
    public List<Sales> findAll(){
        return salesRepository.findAll();
    }
    
    /**
     * 登録・更新
     * @param sales 販売
     * @return 登録・更新した販売
     */
    public Sales save(Sales sales){
        if (sales.getPriceExcludingTax() == null){
            SalesPrice price = salesPriceRepository.findByFishSpeciesIdAndQuantityAndUnit(sales.getFishSpecies().getId(), sales.getQuantity(), sales.getUnit())
                 .orElseThrow(() -> new IllegalStateException("価格が登録されていません"));

            sales.setPriceExcludingTax(price.getPriceExcludingTax());
            sales.setPriceIncludingTax(price.getPriceIncludingTax());
        } else {
            int priceIncludingTax = (int) Math.floor(sales.getPriceExcludingTax() * 1.1);
            sales.setPriceIncludingTax(priceIncludingTax);
        }
        
        return salesRepository.save(sales);
    }


    
    /**
     * 削除
     * @param id 販売ID
     */
    public void delete(Long id){
        salesRepository.deleteById(id);
    }
}
