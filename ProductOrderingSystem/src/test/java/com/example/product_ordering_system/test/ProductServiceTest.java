package com.example.product_ordering_system.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.product_ordering_system.entity.Product;
import com.example.product_ordering_system.repository.ProductRepository;
import com.example.product_ordering_system.service.ProductService;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private ProductService productService;

    @Test
    void testAddProduct() {
        Product p = new Product(null, "Laptop", 50000, 10);
        when(productRepo.save(p)).thenReturn(new Product(1L, "Laptop", 50000, 10));
        Product saved = productService.addProduct(p);
        assertEquals(1L, saved.getProductId());
    }

    @Test
    void testUpdateStock() {
        Product p = new Product(1L, "Laptop", 50000, 10);
        when(productRepo.findById(1L)).thenReturn(Optional.of(p));
        when(productRepo.save(any(Product.class))).thenReturn(p);

        Product updated = productService.updateStock(1L, 5);
        assertEquals(5, updated.getAvailableQuantity());
    }
}

