package com.example.storageserver.service;

import com.example.storageserver.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer create(Customer customer);

    Customer read(long id);

    Customer update(Customer customer);

    void delete(long id);

    List<Customer> getAll();

}