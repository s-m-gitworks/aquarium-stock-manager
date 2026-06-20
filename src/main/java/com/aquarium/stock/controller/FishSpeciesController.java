package com.aquarium.stock.controller;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.dto.FishSpeciesStockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fish-species")
public class FishSpeciesController {
    
    private final FishSpeciesService fishSpeciesService;

    /**
     * 全件取得API
     * @return 魚種データのリスト
     */
    @GetMapping
    public List<FishSpecies> findAll(){
        return fishSpeciesService.findAll();
    }

    /**
     * 登録・更新API
     * @param fishSpecies 魚種データ
     * @return 登録・更新した魚種データ
     */
    @PostMapping
    public FishSpecies save(@RequestBody FishSpecies fishSpecies){
        return fishSpeciesService.save(fishSpecies);
    }

    /**
     * 削除API
     * @param id 魚種ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        fishSpeciesService.delete(id);
    }

    /**
     * 在庫数取得API
     * @param id 魚種ID
     * @param storeId 店舗ID
     * @return 在庫数
     */
    @GetMapping("/{id}/stock")
    public Integer getStock(@PathVariable Long id, @RequestParam Long storeId){
        return fishSpeciesService.calculateStock(id, storeId);
    }

    /**
     * すべての魚種の在庫数を取得するAPI
     * @param storeId 店舗ID
     * @return 魚種名と在庫数のリスト
     */
    @GetMapping("/stocks")
    public List<FishSpeciesStockDto> getStockForAll(@RequestParam Long storeId){
        return fishSpeciesService.calculateStockforAll(storeId);
    }
}
