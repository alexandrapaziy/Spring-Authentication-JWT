package com.example.storageserver.service.impl;

import com.example.storageserver.model.StorageOrder;
import com.example.storageserver.model.StorageOrderItem;
import com.example.storageserver.repository.StorageOrderItemRepository;
import com.example.storageserver.repository.StorageOrderRepository;
import com.example.storageserver.service.StorageOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageOrderServiceImpl implements StorageOrderService {
    private final StorageOrderRepository storageOrderRepository;
    private final StorageOrderItemRepository storageOrderItemRepository;

    public StorageOrderServiceImpl(StorageOrderRepository storageOrderRepository,
                                   StorageOrderItemRepository storageOrderItemRepository) {
        this.storageOrderRepository = storageOrderRepository;
        this.storageOrderItemRepository = storageOrderItemRepository;
    }

    @Override
    public StorageOrder create(StorageOrder storageOrder) {
        List<StorageOrderItem> orderItems = storageOrder.getStorageOrderItems();

        for (StorageOrderItem orderItem : orderItems) {
            orderItem.setOrder(storageOrder);
        }

        return storageOrderRepository.save(storageOrder);
    }

    @Override
    public StorageOrder read(long id) {
        return storageOrderRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public StorageOrder update(StorageOrder storageOrder) {
        if (storageOrder != null) {
            read(storageOrder.getId());
            return storageOrderRepository.save(storageOrder);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        StorageOrder storageOrder = read(id);
        List<StorageOrderItem> orderItems = storageOrder.getStorageOrderItems();

        for (StorageOrderItem orderItem : orderItems) {
            storageOrderItemRepository.delete(orderItem);
        }

        storageOrderRepository.delete(storageOrder);
    }

    @Override
    public List<StorageOrder> getAll() {
        List<StorageOrder> storageOrders = storageOrderRepository.findAll();
        return storageOrders.isEmpty() ? new ArrayList<>() : storageOrders;
    }

    @Override
    public List<StorageOrder> getAllNotArrival() {
        List<StorageOrder> storageOrders = storageOrderRepository.findAllNotArrival();
        return storageOrders.isEmpty() ? new ArrayList<>() : storageOrders;
    }

}