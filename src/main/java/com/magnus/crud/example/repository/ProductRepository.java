package com.magnus.crud.example.repository;

import com.magnus.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    Product findByName(String name);

    @Query(value = "SELECT * FROM PRODUCT_TBL WHERE id = ?1", nativeQuery = true)
    Product findByProdId(int id);
}

