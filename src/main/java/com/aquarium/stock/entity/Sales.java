package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sales")
public class Sales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

    @Column(nullable = false)
    private LocalDate salesDate;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer priceExcludingTax;

    @Column(nullable = false)
    private Integer priceIncludingTax;
}
