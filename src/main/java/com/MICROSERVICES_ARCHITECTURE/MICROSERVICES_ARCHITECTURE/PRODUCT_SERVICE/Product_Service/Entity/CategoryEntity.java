package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PRODUCT_SERVICE.Product_Service.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

