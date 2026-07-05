package com.aquarium.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.aquarium.stock.entity.SalesUnit;
import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Store;
import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.service.FishSpeciesService;
import com.aquarium.stock.service.StoreService;
import com.aquarium.stock.service.TransferService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class TransferViewController {
    
    private final TransferService transferService;
    private final StoreService storeService;
    private final FishSpeciesService fishSpeciesService;

    /**
     * 店舗間移動登録画面を表示する
     */
    @GetMapping("/transfer/new")
    public String newTransfer(Model model){
        Transfer transfer = new Transfer();
        transfer.setFromStore(new Store());
        transfer.setToStore(new Store());
        transfer.setFishSpecies(new FishSpecies());

        // 初期値
        transfer.setUnit(SalesUnit.INDIVIDUAL);
        transfer.setTransferDate(LocalDate.now());

        // モデルに追加
        model.addAttribute("transfer", transfer);
        model.addAttribute("stores", storeService.findAll());
        model.addAttribute("fishSpeciesList", fishSpeciesService.findAll());
        model.addAttribute("salesUnits", SalesUnit.values());
        
        return "transfer/new";
    }

    /**
     * 店舗間移動データを保存する
     */
    @PostMapping("/transfer")
    public String saveTransfer(@ModelAttribute Transfer transfer){
        transferService.save(transfer);
        return "redirect:/stocks";
    }
}
