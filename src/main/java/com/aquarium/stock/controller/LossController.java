package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Loss;
import com.aquarium.stock.service.LossService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/losses")
public class LossController {
    
    private final LossService lossService;

    @GetMapping
    public List<Loss> findAll(){
        return lossService.findAll();
    }

    @PostMapping
    public Loss save(@RequestBody Loss loss){
        return lossService.save(loss);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        lossService.delete(id);
    }
}
