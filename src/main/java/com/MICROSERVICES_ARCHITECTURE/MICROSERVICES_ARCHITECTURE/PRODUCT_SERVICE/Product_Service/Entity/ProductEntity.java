package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PRODUCT_SERVICE.Product_Service.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer stock;

    private Long categoryId;
}

