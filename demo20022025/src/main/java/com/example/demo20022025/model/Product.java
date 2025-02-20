package com.example.demo20022025.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private Long price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
