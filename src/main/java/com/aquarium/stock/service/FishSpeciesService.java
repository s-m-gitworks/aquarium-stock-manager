package com.aquarium.stock.service;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.repository.FishSpeciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FishSpeciesService {
    
    private final FishSpeciesRepository fishSpeciesRepository;

    public List<FishSpecies> findAll(){
        return fishSpeciesRepository.findAll();
    }

    public FishSpecies save(FishSpecies fishSpecies){
        return fishSpeciesRepository.save(fishSpecies);
    }

    public void delete(Long id){
        fishSpeciesRepository.deleteById(id);
    }
}