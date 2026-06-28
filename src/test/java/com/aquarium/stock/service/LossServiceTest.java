package com.aquarium.stock.service;

import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Loss;
import com.aquarium.stock.repository.ArrivalRepository;
import com.aquarium.stock.repository.LossRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LossServiceTest{
    
    @Mock
    private LossRepository lossRepository;
    @Mock
    private ArrivalRepository arrivalRepository;

    @InjectMocks
    private LossService lossService;

    @Test
    void save_ロスによる損失額を自動計算できる(){

        //モックが返すデータを用意
        FishSpecies fishSpecie = new FishSpecies();
        fishSpecie.setId(1l);

        Arrival arrival = new Arrival();
        arrival.setFishSpecies(fishSpecie);
        arrival.setCostPrice(40.0);

        Loss loss = new Loss();
        loss.setFishSpecies(fishSpecie);
        loss.setQuantity(10);

        when(arrivalRepository.findTopByFishSpecies_IdOrderByArrivalDateDesc(1L)).thenReturn(Optional.of(arrival));
        when(lossRepository.save(loss)).thenReturn(loss);
        
        //実行
        Loss result = lossService.save(loss);

        //検証
        assertThat(result.getAmount()).isEqualTo(400.0);
    }
}
