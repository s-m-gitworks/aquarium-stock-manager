package com.aquarium.stock.service;


import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.repository.SalesPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesPriceService {
    
    private final SalesPriceRepository salesPriceRepository;

    public List<SalesPrice> findAll() {
        return salesPriceRepository.findAll();
    }

    public SalesPrice save(SalesPrice salesPrice) {
        return salesPriceRepository.save(salesPrice);
    }

    public void delete(Long id) {
        salesPriceRepository.deleteById(id);
    }
}
