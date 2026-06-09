package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Transfer;
import com.aquarium.stock.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfers")
public class TransferController {
    
    private final TransferService transferService;
    
    /**
     * 全件取得API
     * @return 店舗間移動データのリスト
     */
    @GetMapping
    public List<Transfer> findAll(){
        return transferService.findAll();
    }
    
    /**
     * 登録・更新API
     * @param transfer 店舗間移動データ
     * @return 登録・更新した店舗間移動データ
     */
    @PostMapping
    public Transfer save(@RequestBody Transfer transfer){
        return transferService.save(transfer);
    }
    
    /**
     * 削除API
     * @param id 店舗間移動ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        transferService.delete(id);
    }
}
