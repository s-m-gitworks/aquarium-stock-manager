package com.aquarium.stock.service;

import com.aquarium.stock.entity.Supplier;
import com.aquarium.stock.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void delete(Long id){
        supplierRepository.deleteById(id);
    }
}
