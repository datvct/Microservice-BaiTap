package org.example.productservice.service;

import org.example.productservice.entity.Product;
import org.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public Product save(Product p) {
        return repo.save(p);
    }

    public Product get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Product update(Long id, Product updated) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isEmpty()) return null;
        Product p = optional.get();
        p.setName(updated.getName());
        p.setPrice(updated.getPrice());
        p.setDescription(updated.getDescription());
        p.setStock(updated.getStock());
        return repo.save(p);
    }
}
