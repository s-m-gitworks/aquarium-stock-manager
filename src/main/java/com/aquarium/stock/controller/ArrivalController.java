package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Arrival;
import com.aquarium.stock.service.ArrivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/arrivals")
public class ArrivalController {
    
    private final ArrivalService arrivalService;

    /**
     * 全件取得API
     * @return 入荷データのリスト
     */
    @GetMapping
    public List<Arrival> findAll() {
        return arrivalService.findAll();
    }

    /**
     * 登録・更新API
     * @param arrival 入荷データ
     * @return 登録・更新した入荷データ
     */
    @PostMapping
    public Arrival save(@RequestBody Arrival arrival) {
        return arrivalService.save(arrival);
    }

    /**
     * 削除API
     * @param id 入荷ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        arrivalService.delete(id);
    }
}
