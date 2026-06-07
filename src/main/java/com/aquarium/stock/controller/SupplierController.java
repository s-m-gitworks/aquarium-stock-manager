package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Supplier;
import com.aquarium.stock.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    private final SupplierService supplierService;

    @GetMapping
    public List<Supplier> findAll(){
        return supplierService.findAll();
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier){
        return supplierService.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        supplierService.delete(id);
    }
}
