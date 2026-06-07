package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfers")
public class TransferController {
    
    private final TransferService transferService;
    
    @GetMapping
    public List<Transfer> findAll(){
        return transferService.findAll();
    }
    
    @PostMapping
    public Transfer save(@RequestBody Transfer transfer){
        return transferService.save(transfer);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        transferService.delete(id);
    }
}
