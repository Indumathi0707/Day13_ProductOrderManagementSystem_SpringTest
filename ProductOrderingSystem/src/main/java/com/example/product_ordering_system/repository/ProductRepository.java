package com.example.product_ordering_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_ordering_system.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
