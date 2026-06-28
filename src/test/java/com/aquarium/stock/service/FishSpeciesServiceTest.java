package com.aquarium.stock.service;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.repository.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
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

    @Test
    void save_魚種の登録ができる(){

        //モックが返すデータを用意
        FishSpecies fishSpecie = new FishSpecies();
        fishSpecie.setName("ネオンテトラ");
        fishSpecie.setCategory("熱帯魚");

        when(fishSpeciesRepository.save(fishSpecie)).thenReturn(fishSpecie);

        // 実行
        FishSpecies result = fishSpeciesService.save(fishSpecie);

        //検証
        assertThat(result.getName()).isEqualTo("ネオンテトラ");
        assertThat(result.getCategory()).isEqualTo("熱帯魚");
    }

    @Test
    void delete_魚種の削除ができる(){

        //モックが返すデータを用意
        FishSpecies fishSpecie = new FishSpecies();
        fishSpecie.setId(1L);

        //実行
        fishSpeciesService.delete(1L);

        //検証
        verify(fishSpeciesRepository).deleteById(1L);
    }
}
