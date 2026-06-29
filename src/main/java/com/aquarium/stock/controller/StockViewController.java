package com.aquarium.stock.controller;

import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StockViewController {
    private final FishSpeciesService fishSpeciesService;
    private final StoreService storeService;
    
    @GetMapping("/stocks")
    public String stockList(@RequestParam(required = false) Long storeId, Model model){
        model.addAttribute("stores", storeService.findAll());
        if (storeId != null){
            model.addAttribute("stocks", fishSpeciesService.calculateStockforAll(storeId));
            model.addAttribute("selectedStoreId", storeId);
        }
        return "stocks";
    }
}
