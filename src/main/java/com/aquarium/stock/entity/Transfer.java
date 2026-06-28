package com.aquarium.stock.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * 店舗間移動テーブル
 * 生体の店舗間移動情報を管理する
 */
@Data
@Entity
@Table(name = "transfer")
public class Transfer {
    
    /** 移動ID・自動採番 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 移動元店舗ID */
    @ManyToOne
    @JoinColumn(name = "from_store_id", nullable = false)
    private Store fromStore;

    /** 移動先店舗ID */
    @ManyToOne
    @JoinColumn(name = "to_store_id", nullable = false)
    private Store toStore;

    /** 魚種ID */
    @ManyToOne
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

    /** 移動日 */
    @NotNull
    @Column(nullable = false)
    private LocalDate transferDate;

    /** 移動数量 */
    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer quantity;

    /** 単位 */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalesUnit unit;

    /** 移動時の仕入値ベースの金額 */
    @Column(nullable = false)
    private Double transferAmount;
}
