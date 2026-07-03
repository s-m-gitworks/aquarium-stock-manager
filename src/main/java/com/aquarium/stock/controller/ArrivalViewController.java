package com.aquarium.stock.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.entity.ArrivalStatus;
import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.SalesUnit;
import com.aquarium.stock.entity.Store;
import com.aquarium.stock.entity.Supplier;
import com.aquarium.stock.service.ArrivalService;
import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.StoreService;
import com.aquarium.stock.service.SupplierService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ArrivalViewController {
    
    private final ArrivalService arrivalService;
    private final StoreService storeService;
    private final FishSpeciesService fishSpeciesService;
    private final SupplierService supplierService;

    /**
     * 入荷登録画面を表示する
     */
    @GetMapping("/arrivals/new")
    public String newArrival(Model model){
        Arrival arrival = new Arrival();

        arrival.setStore(new Store());
        arrival.setFishSpecies(new FishSpecies());
        arrival.setSupplier(new Supplier());

        // 初期値
        arrival.setArrivalDate(LocalDate.now());
        arrival.setUnit(SalesUnit.INDIVIDUAL);
        arrival.setStatus(ArrivalStatus.QUARANTINE);

        // モデルに追加
        model.addAttribute("arrival", arrival);
        model.addAttribute("stores", storeService.findAll());
        model.addAttribute("fishSpeciesList", fishSpeciesService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("salesUnits", SalesUnit.values());
        model.addAttribute("arrivalStatuses", ArrivalStatus.values());

        return "arrivals/new";
    }

    /**
     * 入荷データを登録する
     */
    @PostMapping("/arrivals")
    public String saveArrival(@ModelAttribute Arrival arrival){
        arrivalService.save(arrival);
        return "redirect:/stocks";
    }

}