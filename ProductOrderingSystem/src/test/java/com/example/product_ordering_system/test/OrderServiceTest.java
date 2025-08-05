package com.example.product_ordering_system.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.product_ordering_system.entity.Order;
import com.example.product_ordering_system.entity.Product;
import com.example.product_ordering_system.repository.OrderRepository;
import com.example.product_ordering_system.repository.ProductRepository;
import com.example.product_ordering_system.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private ProductRepository productRepo;
    @Mock
    private OrderRepository orderRepo;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testPlaceOrderSuccess() {
        Product p = new Product(1L, "Phone", 20000, 10);
        when(productRepo.findById(1L)).thenReturn(Optional.of(p));
        when(orderRepo.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        Order order = orderService.placeOrder(1L, 3);
        assertEquals(7, p.getAvailableQuantity()); // stock reduced
    }

    @Test
    void testPlaceOrderInsufficientStock() {
        Product p = new Product(1L, "Phone", 20000, 2);
        when(productRepo.findById(1L)).thenReturn(Optional.of(p));

        assertThrows(RuntimeException.class, () -> orderService.placeOrder(1L, 5));
    }
}
