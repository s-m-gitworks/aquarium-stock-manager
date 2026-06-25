package com.aquarium.stock.service;

import com.aquarium.stock.repository.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FishSpeciesServiceTest{
    
    @Mock
    private FishSpeciesRepository fishSpeciesRepository;
    @Mock
    private ArrivalRepository arrivalRepository;
    @Mock
    private SalesRepository salesRepository;
    @Mock
    private LossRepository lossRepository;
    @Mock
    private TransferRepository transferRepository;
    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private FishSpeciesService fishSpeciesService;

    @Test
    void calculateStock_在庫数を正しく計算できる(){

        // モックの設定
        when(arrivalRepository.sumQuantityByFishSpeciesIdAndStoreId(1L, 1L)).thenReturn(100);
        when(salesRepository.sumQuantityByFishSpeciesIdAndStoreId(1L, 1L)).thenReturn(20);
        when(lossRepository.sumQuantityByFishSpeciesIdAndStoreId(1L, 1L)).thenReturn(5);
        when(transferRepository.sumInQuantityByFishSpeciesIdAndStoreId(1L, 1L)).thenReturn(10);
        when(transferRepository.sumOutQuantityByFishSpeciesIdAndStoreId(1L, 1L)).thenReturn(15);
        
        // 実行
        Integer result = fishSpeciesService.calculateStock(1L, 1L);
        
        // 検証
        assertThat(result).isEqualTo(70);
    }
}
