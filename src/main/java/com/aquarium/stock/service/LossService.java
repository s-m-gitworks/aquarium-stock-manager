package com.aquarium.stock.service;

import com.aquarium.stock.entity.Loss;
import com.aquarium.stock.repository.LossRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LossService {
    
    private final LossRepository lossRepository;
    
    public List<Loss> findAll(){
        return lossRepository.findAll();
    }

    public Loss save(Loss loss){
        return lossRepository.save(loss);
    }

    public void delete(Long id){
        lossRepository.deleteById(id);
    }
}
