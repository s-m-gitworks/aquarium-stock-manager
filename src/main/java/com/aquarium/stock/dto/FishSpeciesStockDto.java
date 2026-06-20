package com.aquarium.stock.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class FishSpeciesStockDto {
    private String name;
    private Integer stock;
    private String storeName;
}
