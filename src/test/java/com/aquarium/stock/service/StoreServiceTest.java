package com.aquarium.stock.service;

import com.aquarium.stock.entity.Store;
import com.aquarium.stock.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {
 
    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;

    @Test
    void findALL_店舗の全件取得ができる(){
        //モックが返すデータを用意
        Store store1 = new Store();
        store1.setId(1L);
        store1.setName("店舗1");

        Store store2 = new Store();
        store2.setId(2L);
        store2.setName("店舗2");

        when(storeRepository.findAll()).thenReturn(List.of(store1, store2));

        //実行
        List<Store> result = storeService.findAll();

        //検証
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("店舗1");
    }

    @Test
    void save_店舗の登録ができる(){
        // モックが返すデータを用意
        Store store = new Store();
        store.setName("店舗1");
        
        when(storeRepository.save(store)).thenReturn(store);

        // 実行
        Store result = storeService.save(store);

        // 検証
        assertThat(result.getName()).isEqualTo("店舗1");
    }

    @Test
    void delete_店舗の削除ができる(){
        // モックが返すデータを用意
        Store store = new Store();
        store.setId(1L);

        // 実行
        storeService.delete(1L);

        // 検証
        verify(storeRepository).deleteById(1L);
    }
}