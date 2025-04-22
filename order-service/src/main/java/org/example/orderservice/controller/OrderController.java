package org.example.orderservice.controller;

import org.example.orderservice.entity.Order;
import org.example.orderservice.service.OrderEventPublisher;
import org.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    private final OrderEventPublisher orderEventPublisher;

    @PostMapping
    public Order create(@RequestBody Order order) {
        Order savedOrder = service.save(order);
        orderEventPublisher.sendOrderCreatedEvent(savedOrder);

        return savedOrder;
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
