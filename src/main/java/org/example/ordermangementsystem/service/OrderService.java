package org.example.ordermangementsystem.service;

import org.example.ordermangementsystem.model.Order;
import org.example.ordermangementsystem.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setCustomerName(orderDetails.getCustomerName());
        return orderRepo.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}
