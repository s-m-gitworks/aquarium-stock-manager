package com.aquarium.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Loss;
import com.aquarium.stock.entity.LossReason;
import com.aquarium.stock.entity.Store;
import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.LossService;
import com.aquarium.stock.service.StoreService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class LossesViewController {
    private final StoreService storeService;
    private final FishSpeciesService fishSpeciesService;
    private final LossService lossService;

    /**
     * ロス登録画面を表示する
     */
    @GetMapping("/losses/new")
    public String newLosses(Model model) {
        Loss loss = new Loss();
        loss.setStore(new Store());
        loss.setFishSpecies(new FishSpecies());

        // 初期値
        loss.setLossDate(LocalDate.now());

        model.addAttribute("loss", loss);
        model.addAttribute("lossReasons", LossReason.values());
        model.addAttribute("stores", storeService.findAll());
        model.addAttribute("fishSpeciesList", fishSpeciesService.findAll());

        return "losses/new";
    }

    /**
     * ロスデータを登録する
     */
    @PostMapping("/losses")
    public String saveLoss(@ModelAttribute Loss loss){
        lossService.save(loss);
        return "redirect:/stocks";
    }
}
