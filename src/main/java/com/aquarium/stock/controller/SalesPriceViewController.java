package com.aquarium.stock.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.entity.SalesUnit;
import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.SalesPriceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SalesPriceViewController {
    private final FishSpeciesService fishSpeciesService;
    private final SalesPriceService salesPriceService;
    
    /**
     * 販売価格登録画面を表示する
     */
    @GetMapping("/sales-prices/new")
    public String newSalesPrice(Model model) {
        SalesPrice salesPrice = new SalesPrice();
        salesPrice.setFishSpecies(new FishSpecies());

        // 初期値
        salesPrice.setQuantity(1);
        salesPrice.setUnit(SalesUnit.INDIVIDUAL);

        // モデルに追加
        model.addAttribute("salesPrice", salesPrice);
        model.addAttribute("fishSpeciesList", fishSpeciesService.findAll());
        model.addAttribute("salesUnits", SalesUnit.values());

        return "sales-prices/new";
    }

    @PostMapping("/sales-prices")
    public String saveSalesPrice(@ModelAttribute SalesPrice salesPrice){
        salesPriceService.save(salesPrice);
        return "redirect:/stocks";
    }

    /**
     * 仕入・販売価格一覧画面を表示する
     */
    @GetMapping("/sales-prices")
    public String showSalesPrices(Model model){
        model.addAttribute("priceComparisons", salesPriceService.findPriceComparisons());
        return "sales-prices/index";
    }

}
