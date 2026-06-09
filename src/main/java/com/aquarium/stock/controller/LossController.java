package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Loss;
import com.aquarium.stock.service.LossService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/losses")
public class LossController {
    
    private final LossService lossService;

    /**
     * 全件取得API
     * @return ロスデータのリスト
     */
    @GetMapping
    public List<Loss> findAll(){
        return lossService.findAll();
    }

    /**
     * 登録・更新API
     * @param loss ロスデータ
     * @return 登録・更新したロスデータ
     */
    @PostMapping
    public Loss save(@RequestBody Loss loss){
        return lossService.save(loss);
    }

    /**
     * 削除API
     * @param id ロスID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        lossService.delete(id);
    }
}
