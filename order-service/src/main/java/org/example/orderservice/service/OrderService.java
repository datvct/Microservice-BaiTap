package org.example.orderservice.service;

import org.example.orderservice.entity.Order;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order save(Order o) {
        return repo.save(o);
    }

    public Order get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order update(Long id, Order updated) {
        Optional<Order> optional = repo.findById(id);
        if (optional.isEmpty()) return null;
        Order o = optional.get();
        o.setCustomerId(updated.getCustomerId());
        o.setProductId(updated.getProductId());
        o.setQuantity(updated.getQuantity());
        o.setTotalPrice(updated.getTotalPrice());
        o.setStatus(updated.getStatus());
        return repo.save(o);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
