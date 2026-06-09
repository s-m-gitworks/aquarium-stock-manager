package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 仕入先テーブル
 * 仕入先情報を管理する
 */
@Data
@Entity
@Table(name ="supplier")
public class Supplier {
    
    /** 仕入先ID・自動採番 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 仕入先名 */
    @Column(nullable = false)
    private String name;
}
