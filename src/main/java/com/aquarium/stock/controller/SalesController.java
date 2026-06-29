package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Sales;
import com.aquarium.stock.service.SalesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    
    private final SalesService salesService;
    
    /**
     * 全件取得API
     * @return 売上データのリスト
     */
    @GetMapping
    public List<Sales> findAll(){
        return salesService.findAll();
    }

    /**
     * 登録・更新API
     * @param sales 売上データ
     * @return 登録・更新した売上データ
     */
    @PostMapping
    public Sales save(@Valid @RequestBody Sales sales){
        return salesService.save(sales);
    }

    /**
     * 削除API
     * @param id 売上ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        salesService.delete(id);
    }
}
