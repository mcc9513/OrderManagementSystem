package org.example.ordermangementsystem;

import org.example.ordermangementsystem.model.Order;
import org.example.ordermangementsystem.repo.OrderRepo;
import org.example.ordermangementsystem.service.OrderService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.Optional;

public class OrderServiceTest {

    @Mock
    private OrderRepo orderRepo;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setOrderId(1L);
        when(orderRepo.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.createOrder(order);
        assertNotNull(savedOrder);
        assertEquals(1, savedOrder.getOrderId());
    }

    @Test
    public void testGetOrderById() {
        Order order = new Order();
        order.setOrderId(1L);
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(1L);
        assertNotNull(foundOrder);
        assertEquals(1, foundOrder.getOrderId());
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        order.setOrderId(1L);
        order.setCustomerName("Original Customer Name");

        Order updatedOrderDetails = new Order();
        updatedOrderDetails.setCustomerName("Updated Customer Name");

        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepo.save(any(Order.class))).thenReturn(updatedOrderDetails);

        Order updatedOrder = orderService.updateOrder(1L, updatedOrderDetails);
        assertEquals("Updated Customer Name", updatedOrder.getCustomerName());
    }

    @Test
    public void testDeleteOrder() {
        doNothing().when(orderRepo).deleteById(1L);
        orderService.deleteOrder(1L);
        verify(orderRepo, times(1)).deleteById(1L);
    }
}
