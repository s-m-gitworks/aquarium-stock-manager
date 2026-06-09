package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Store;
import com.aquarium.stock.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {
    
    private final StoreService storeService;

    /**
     * 全件取得API
     * @return 店舗データのリスト
     */
    @GetMapping
    public List<Store>findAll(){
        return storeService.findAll();
    }

    /**
     * 登録・更新API
     * @param store 店舗データ
     * @return 登録・更新した店舗データ
     */
    @PostMapping
    public Store save(@RequestBody Store store){
        return storeService.save(store);
    }

    /**
     * 削除API
     * @param id 店舗ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        storeService.delete(id);
    }
}
