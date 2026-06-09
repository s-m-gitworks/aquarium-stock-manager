package com.aquarium.stock.controller;

import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.service.SalesPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales-prices")
public class SalesPriceController {
    
    private final SalesPriceService salesPriceService;

    /**
     * 全件取得API
     * @return 販売価格データのリスト
     */
    @GetMapping
    public List<SalesPrice> findAll(){
        return salesPriceService.findAll();
    }

    /**
     * 登録・更新API
     * @param salesPrice 販売価格データ
     * @return 登録・更新した販売価格データ
     */
    @PostMapping
    public SalesPrice save(@RequestBody SalesPrice salesPrice){
        return salesPriceService.save(salesPrice);
    }

    /**
     * 削除API
     * @param id 販売価格ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        salesPriceService.delete(id);
    }
}
