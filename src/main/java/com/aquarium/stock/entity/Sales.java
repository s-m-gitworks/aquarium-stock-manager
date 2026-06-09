package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * 販売テーブル
 * 生体の販売情報を管理する
 */
@Data
@Entity
@Table(name = "sales")
public class Sales {
    
    /** 販売情報ID・自動採番 */
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

    /** 販売日 */
    @Column(nullable = false)
    private LocalDate salesDate;

    /** 数量 */
    @Column(nullable = false)
    private Integer quantity;

    /** 販売単位 */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalesUnit unit;

    /** 税抜価格 */
    @Column(nullable = false)
    private Integer priceExcludingTax;

    /** 税込価格 */
    @Column(nullable = false)
    private Integer priceIncludingTax;
}
