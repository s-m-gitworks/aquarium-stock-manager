package com.aquarium.stock.service;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.repository.ArrivalRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArrivalService {
    
    private final ArrivalRepository arrivalRepository;
    
    public List<Arrival> findAll() {
        return arrivalRepository.findAll();
    }
    
    public Arrival save(Arrival arrival) {
        return arrivalRepository.save(arrival);
    }
    
    public void delete(Long id) {
        arrivalRepository.deleteById(id);
    }
}
