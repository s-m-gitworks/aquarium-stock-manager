package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "transfer")
public class Transfer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_store_id", nullable = false)
    private Store fromStore;

    @ManyToOne
    @JoinColumn(name = "to_store_id", nullable = false)
    private Store toStore;

    @ManyToOne
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

    @Column(nullable = false)
    private LocalDate transferDate;

    @Column(nullable = false)
    private Integer quantity;

}
