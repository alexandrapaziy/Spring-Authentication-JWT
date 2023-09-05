package com.example.storageserver.service.impl;

import com.example.storageserver.model.CustomerOrder;
import com.example.storageserver.model.CustomerOrderItem;
import com.example.storageserver.repository.CustomerOrderItemRepository;
import com.example.storageserver.repository.CustomerOrderRepository;
import com.example.storageserver.service.CustomerOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderItemRepository customerOrderItemRepository;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository,
                                    CustomerOrderItemRepository customerOrderItemRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerOrderItemRepository = customerOrderItemRepository;
    }

    @Override
    public CustomerOrder create(CustomerOrder customerOrder) {
        List<CustomerOrderItem> orderItems = customerOrder.getCustomerOrderItems();

        for (CustomerOrderItem orderItem : orderItems) {
            orderItem.setOrder(customerOrder);
        }

        return customerOrderRepository.save(customerOrder);
    }


    @Override
    public CustomerOrder read(long id) {
        return customerOrderRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public CustomerOrder update(CustomerOrder customerOrder) {
        if (customerOrder != null) {
            read(customerOrder.getId());
            return customerOrderRepository.save(customerOrder);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        CustomerOrder customerOrder = read(id);
        List<CustomerOrderItem> orderItems = customerOrder.getCustomerOrderItems();

        for (CustomerOrderItem orderItem : orderItems) {
            customerOrderItemRepository.delete(orderItem);
        }

        customerOrderRepository.delete(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAll() {
        List<CustomerOrder> customerOrders = customerOrderRepository.findAll();
        return customerOrders.isEmpty() ? new ArrayList<>() : customerOrders;
    }

    @Override
    public List<CustomerOrder> getAllNotIssuance() {
        List<CustomerOrder> customerOrders = customerOrderRepository.findAllNotIssuance();
        return customerOrders.isEmpty() ? new ArrayList<>() : customerOrders;
    }
}