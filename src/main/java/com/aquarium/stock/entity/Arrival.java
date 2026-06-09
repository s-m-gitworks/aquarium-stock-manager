package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * 入荷テーブル
 * アクアリウムショップへの入荷情報を管理する
 */
@Data
@Entity
@Table(name = "arrival")
public class Arrival {
    
    /** 入荷ID・自動採番 */
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

    /** 仕入先ID */
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    /** 入荷日 */
    @Column(nullable = false)
    private LocalDate arrivalDate;

    /** 数量 */
    @Column(nullable = false)
    private Integer quantity;

    /** 仕入れ単価 */
    @Column(nullable = false)
    private Double costPrice;

    /** 販売単位 */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalesUnit unit;

    /** 生体の状態 */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArrivalStatus status;
}
