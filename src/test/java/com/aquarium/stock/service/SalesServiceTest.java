package com.aquarium.stock.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aquarium.stock.entity.FishSpecies;
import com.aquarium.stock.entity.Sales;
import com.aquarium.stock.entity.SalesPrice;
import com.aquarium.stock.entity.SalesUnit;
import com.aquarium.stock.repository.SalesPriceRepository;
import com.aquarium.stock.repository.SalesRepository;

@ExtendWith(MockitoExtension.class)
class SalesServiceTest {

    @Mock
    private SalesRepository salesRepository;
    @Mock
    private SalesPriceRepository salesPriceRepository;
    
    @InjectMocks
    private SalesService salesService;

    @Test
    void save_価格指定ありのとき指定価格で登録される(){

        // モックが返すデータを用意
        FishSpecies fishSpecie = new FishSpecies();
        fishSpecie.setId(1L);

        Sales sale = new Sales();
        sale.setPriceExcludingTax(480);
        sale.setPriceIncludingTax(548);

        SalesPrice salesPrice = new SalesPrice();
        salesPrice.setFishSpecies(fishSpecie);

        when(salesRepository.save(sale)).thenReturn(sale);
        
        //実行
        Sales result = salesService.save(sale);

        //検証
        assertThat(result.getPriceIncludingTax()).isEqualTo(548);
    }

    @Test
    void save_価格指定なしのとき定価が自動取得される(){

        // モックが返すデータを用意
        FishSpecies fishSpecie = new FishSpecies();
        fishSpecie.setId(1L);

        Sales sale = new Sales();
        sale.setFishSpecies(fishSpecie);

        SalesPrice salesPrice = new SalesPrice();
        salesPrice.setFishSpecies(fishSpecie);
        salesPrice.setPriceExcludingTax(480);
        salesPrice.setPriceIncludingTax(548);

        when(salesPriceRepository.findByFishSpeciesIdAndQuantityAndUnit(1L, 1, SalesUnit.INDIVIDUAL)).thenReturn(Optional.of(salesPrice));
        when(salesRepository.save(sale)).thenReturn(sale);
        
        //実行
        Sales result = salesService.save(sale);

        //検証
        assertThat(result.getPriceIncludingTax()).isEqualTo(548);
    }
}