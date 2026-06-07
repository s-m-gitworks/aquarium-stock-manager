package com.aquarium.stock.controller;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.service.FishSpeciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fish-species")
public class FishSpeciesController {
    
    private final FishSpeciesService fishSpeciesService;

    @GetMapping
    public List<FishSpecies> findAll(){
        return fishSpeciesService.findAll();
    }

    @PostMapping
    public FishSpecies save(@RequestBody FishSpecies fishSpecies){
        return fishSpeciesService.save(fishSpecies);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        fishSpeciesService.delete(id);
    }
}
