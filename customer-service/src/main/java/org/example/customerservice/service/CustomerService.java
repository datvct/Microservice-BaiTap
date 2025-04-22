package org.example.customerservice.service;

import org.example.customerservice.entity.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer save(Customer c) {
        return repo.save(c);
    }

    public Customer get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer update(Long id, Customer updated) {
        Optional<Customer> optional = repo.findById(id);
        if (optional.isEmpty()) return null;
        Customer c = optional.get();
        c.setName(updated.getName());
        c.setEmail(updated.getEmail());
        c.setPhone(updated.getPhone());
        c.setAddress(updated.getAddress());
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
