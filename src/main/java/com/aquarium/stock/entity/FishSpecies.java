package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 魚種マスタ
 * アクアリウムショップで扱う生体の種類を管理する
 */
@Data
@Entity
@Table(name = "fish_species")
public class FishSpecies {

    /** 魚種ID・自動採番 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 魚種名 */
    @Column(nullable = false)
    private String name;

    /** 分類 */
    @Column(nullable = false)
    private String category;
}