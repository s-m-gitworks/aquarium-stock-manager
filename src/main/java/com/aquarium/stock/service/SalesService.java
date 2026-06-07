package com.aquarium.stock.service;

import com.aquarium.stock.entity.Sales;
import com.aquarium.stock.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;
    
    public List<Sales> findAll(){
        return salesRepository.findAll();
    }
    
    public Sales save(Sales sales){
        return salesRepository.save(sales);
    }
    
    public void delete(Long id){
        salesRepository.deleteById(id);
    }
}
