package com.aquarium.stock.service;

import com.aquarium.stock.entity.Supplier;
import com.aquarium.stock.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    /**
     * 全件取得
     * @return 仕入先リスト
     */
    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    /**
     * 登録・更新
     * @param supplier 仕入先
     * @return 登録・更新した仕入先
     */
    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    /**
     * 削除
     * @param id 仕入先ID
     */
    public void delete(Long id){
        supplierRepository.deleteById(id);
    }
}
