package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PRODUCT_SERVICE.Product_Service.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

