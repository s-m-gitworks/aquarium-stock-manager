package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.service.ArrivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/arrivals")
public class ArrivalController {
    
    private final ArrivalService arrivalService;

    @GetMapping
    public List<Arrival> findAll() {
        return arrivalService.findAll();
    }

    @PostMapping
    public Arrival create(@RequestBody Arrival arrival) {
        return arrivalService.save(arrival);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        arrivalService.delete(id);
    }
}
