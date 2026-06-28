package com.aquarium.stock.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.repository.ArrivalRepository;
import com.aquarium.stock.repository.TransferRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {
    
    @Mock
    private TransferRepository transferRepository;
    @Mock
    private ArrivalRepository arrivalRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    void save_移動登録時にtransferAmountが自動計算される(){

        // モックが返すデータを用意
        FishSpecies fishSpecie = new FishSpecies();
        fishSpecie.setId(1L);
        
        Transfer transfer = new Transfer();
        transfer.setFishSpecies(fishSpecie);
        transfer.setQuantity(10);

        Arrival arrival = new Arrival();
        arrival.setCostPrice(40.0);

        when(arrivalRepository.findTopByFishSpecies_IdOrderByArrivalDateDesc(1L)).thenReturn(Optional.of(arrival));
        when(transferRepository.save(transfer)).thenReturn(transfer);

        //実行
        Transfer result = transferService.save(transfer);

        //検証
        assertThat(result.getTransferAmount()).isEqualTo(400.0);
    }

}
