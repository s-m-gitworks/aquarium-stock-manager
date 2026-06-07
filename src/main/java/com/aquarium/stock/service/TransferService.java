package com.aquarium.stock.service;

import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {
    
    private final TransferRepository transferRepository;

    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public void delete(Long id) {
        transferRepository.deleteById(id);
    }
}
