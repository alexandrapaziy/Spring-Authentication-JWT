package com.example.storageserver.service.impl;

import com.example.storageserver.model.Customer;
import com.example.storageserver.repository.CustomerRepository;
import com.example.storageserver.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        if (customer != null) {
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer read(long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Customer update(Customer customer) {
        if (customer != null) {
            read(customer.getId());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        customerRepository.delete(read(id));
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customer = customerRepository.findAll();
        return customer.isEmpty() ? new ArrayList<>() : customer;
    }

}