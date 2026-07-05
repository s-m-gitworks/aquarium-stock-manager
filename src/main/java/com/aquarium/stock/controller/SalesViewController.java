package com.aquarium.stock.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Sales;
import com.aquarium.stock.entity.SalesUnit;
import com.aquarium.stock.entity.Store;
import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.SalesService;
import com.aquarium.stock.service.StoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SalesViewController {
    
    private final StoreService storeService;
    private final FishSpeciesService fishSpeciesService;
    private final SalesService salesService;
    
    /**
     * 販売登録画面を表示する
     */
    @GetMapping("/sales/new")
    public String newSales(Model model){
        Sales sales = new Sales();
        sales.setStore(new Store());
        sales.setFishSpecies(new FishSpecies());

        // 初期値
        sales.setSalesDate(LocalDate.now());
        sales.setQuantity(1);
        sales.setUnit(SalesUnit.INDIVIDUAL);

        // モデルに追加
        model.addAttribute("sales", sales);
        model.addAttribute("stores", storeService.findAll());
        model.addAttribute("fishSpeciesList", fishSpeciesService.findAll());
        model.addAttribute("salesUnits", SalesUnit.values());

        return "sales/new";
    }

    /**
     * 販売データを登録する
     */
    @PostMapping("/sales")
    public String saveSales(@ModelAttribute Sales sales){
        salesService.save(sales);
        return "redirect:/stocks";
    }
}
