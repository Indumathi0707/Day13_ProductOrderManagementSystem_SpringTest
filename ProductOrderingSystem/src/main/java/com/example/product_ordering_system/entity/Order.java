package com.example.product_ordering_system.entity;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "products")
	private Product product;
	
	private LocalDate orderDate;
	private int quantityOrdered;
	public Order(Long orderId, Product product, LocalDate orderDate, int quantityOrdered) {
		
		this.orderId = orderId;
		this.product = product;
		this.orderDate = orderDate;
		this.quantityOrdered = quantityOrdered;
	}
	public Order() {
		
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
}
