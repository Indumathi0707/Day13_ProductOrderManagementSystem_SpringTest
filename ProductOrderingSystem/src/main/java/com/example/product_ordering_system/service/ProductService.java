package com.example.product_ordering_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_ordering_system.entity.Product;
import com.example.product_ordering_system.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public Product addProduct(Product p) {
		return productRepo.save(p);
	}
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	public Product updateStock(Long productId, int qty) {
		Product p = productRepo.findById(productId)
				.orElseThrow(()-> new RuntimeException("Product not found"));
		p.setAvailableQuantity(qty);
		return productRepo.save(p);
	}
}
