package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sales_price")
public class SalesPrice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalesUnit unit;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer priceExcludingTax;

    @Column(nullable = false)
    private Integer price;
}
