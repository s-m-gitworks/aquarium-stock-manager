package com.aquarium.stock.controller;

import com.aquarium.stock.entity.Supplier;
import com.aquarium.stock.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    private final SupplierService supplierService;

    /**
     * 全件取得API
     * @return 仕入先データのリスト
     */
    @GetMapping
    public List<Supplier> findAll(){
        return supplierService.findAll();
    }

    /**
     * 登録・更新API
     * @param supplier 仕入先データ
     * @return 登録・更新した仕入先データ
     */
    @PostMapping
    public Supplier save(@RequestBody Supplier supplier){
        return supplierService.save(supplier);
    }

    /**
     * 削除API
     * @param id 仕入先ID
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        supplierService.delete(id);
    }
}
