package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Sales;
import com.aquarium.stock.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    
    private final SalesService salesService;
    
    @GetMapping
    public List<Sales> findAll(){
        return salesService.findAll();
    }

    @PostMapping
    public Sales save(@RequestBody Sales sales){
        return salesService.save(sales);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        salesService.delete(id);
    }
}
