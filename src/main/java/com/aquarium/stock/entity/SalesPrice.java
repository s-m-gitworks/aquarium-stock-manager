package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

/** 
 * 販売価格テーブル(税込・税抜の両方)
 * 生体の販売価格を管理する
 */
@Data
@Entity
@Table(name = "sales_price")
public class SalesPrice {
    
    /** 販売価格ID・自動採番 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 魚種ID */
    @ManyToOne
    @JoinColumn(name = "fish_species_id", nullable = false)
    private FishSpecies fishSpecies;

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
