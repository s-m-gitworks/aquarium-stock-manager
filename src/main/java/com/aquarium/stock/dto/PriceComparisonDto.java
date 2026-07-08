package com.aquarium.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceComparisonDto {
    
    private String fishSpeciesName;
    private Integer quantity;
    private String unitDisplayName;

    private Double latestCostPrice;

    private Integer priceExcludingTax;
    private Integer priceIncludingTax;

    private Double grossProfit;
}
