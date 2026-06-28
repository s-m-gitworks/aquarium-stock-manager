package com.aquarium.stock.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * ロステーブル
 * 損失した生体情報を管理する 
 */
@Data
@Entity
@Table(name = "loss")
public class Loss {
    
    /** 損失ID・自動採番 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 店舗ID */
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    /** 魚種ID */
    @ManyToOne
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

    /** 損失日 */
    @NotNull
    @Column(nullable = false)
    private LocalDate lossDate;

    /** 数量 */
    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer quantity;

    /** 損失額 */
    @Column(nullable = false)
    private Double amount;

    /** 損失理由 */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LossReason lossReason;

    /** 備考 */
    private String note;
}
