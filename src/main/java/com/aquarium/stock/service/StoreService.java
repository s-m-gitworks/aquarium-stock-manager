package com.aquarium.stock.service;

import com.aquarium.stock.entity.Store;
import com.aquarium.stock.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    
    private final StoreRepository storeRepository;

    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public void delete(Long id){
        storeRepository.deleteById(id);
    }
}
