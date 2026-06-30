package com.aquarium.stock.controller;

import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.StoreService;
import com.aquarium.stock.dto.FishSpeciesStockDto;
import com.aquarium.stock.entity.Store;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StockViewController {
    private final FishSpeciesService fishSpeciesService;
    private final StoreService storeService;
    
    @GetMapping("/stocks")
    public String stockList(Model model){
        List<Store> stores = storeService.findAll();

        Map<String, Map<String, Integer>> stockTable = new LinkedHashMap<>();

        // 店舗を1つずつ処理
        for (Store store : stores){
            List<FishSpeciesStockDto> stocks = fishSpeciesService.calculateStockforAll(store.getId());
            // その店舗の中で魚種を1つずつ処理
            for (FishSpeciesStockDto dto : stocks){
                stockTable
                // 魚種名がまだ存在しなければ新しい空のMapを作って入れ、すでにあればそのまま使用する
                    .computeIfAbsent(dto.getName(), k -> new LinkedHashMap<>())
                    .put(dto.getStoreName(), dto.getStock());
            }
        }

        model.addAttribute("stores", stores);
        model.addAttribute("stockTable", stockTable);
        return "stocks";
    }
}
