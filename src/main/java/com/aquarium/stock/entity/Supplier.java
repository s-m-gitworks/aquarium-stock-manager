package com.aquarium.stock.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="supplier")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
