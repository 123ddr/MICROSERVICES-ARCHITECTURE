package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PRODUCT_SERVICE.Product_Service.Repository;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PRODUCT_SERVICE.Product_Service.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategoryId(Long categoryId);
}
