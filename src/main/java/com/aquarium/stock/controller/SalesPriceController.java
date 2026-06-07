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

    @GetMapping
    public List<SalesPrice> findAll(){
        return salesPriceService.findAll();
    }

    @PostMapping
    public SalesPrice save(@RequestBody SalesPrice salesPrice){
        return salesPriceService.save(salesPrice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        salesPriceService.delete(id);
    }
}
