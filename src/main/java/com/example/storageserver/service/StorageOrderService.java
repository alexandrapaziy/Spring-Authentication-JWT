package com.example.storageserver.service;

import com.example.storageserver.model.StorageOrder;

import java.util.List;

public interface StorageOrderService {

    StorageOrder create(StorageOrder storageOrder);

    StorageOrder read(long id);

    StorageOrder update(StorageOrder storageOrder);

    void delete(long id);

    List<StorageOrder> getAll();

    List<StorageOrder> getAllNotArrival();

}