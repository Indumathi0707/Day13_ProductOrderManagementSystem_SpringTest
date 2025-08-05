package com.example.product_ordering_system.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_ordering_system.entity.Order;
import com.example.product_ordering_system.entity.Product;
import com.example.product_ordering_system.repository.OrderRepository;
import com.example.product_ordering_system.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public Order placeOrder(Long productId, int qty) {
		Product prod = productRepo.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));
		
		if(prod.getAvailableQuantity() < qty) {
			throw new RuntimeException("Insufficient stock");
		}
		
		prod.setAvailableQuantity(prod.getAvailableQuantity() - qty);
		productRepo.save(prod);
		
		Order order = new Order();
        order.setProduct(prod);
        order.setOrderDate(LocalDate.now());
        order.setQuantityOrdered(qty);
        return orderRepo.save(order);
	}
	public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
