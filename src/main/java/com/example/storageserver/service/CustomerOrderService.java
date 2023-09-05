package com.example.storageserver.service;

import com.example.storageserver.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    CustomerOrder create(CustomerOrder storageOrder);

    CustomerOrder read(long id);

    CustomerOrder update(CustomerOrder storageOrder);

    void delete(long id);

    List<CustomerOrder> getAll();

    List<CustomerOrder> getAllNotIssuance();

}