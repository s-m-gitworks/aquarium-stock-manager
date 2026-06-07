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

    @GetMapping
    public List<Store>findAll(){
        return storeService.findAll();
    }

    @PostMapping
    public Store save(@RequestBody Store store){
        return storeService.save(store);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        storeService.delete(id);
    }
}
