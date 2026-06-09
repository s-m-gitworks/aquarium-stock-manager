package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 店舗テーブル
 * 店舗情報を管理する
 */
@Data
@Entity
@Table(name = "store")
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
