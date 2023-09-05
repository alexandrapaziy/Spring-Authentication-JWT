package com.example.storageserver.service.impl;

import com.example.storageserver.model.*;
import com.example.storageserver.repository.ArrivalRepository;
import com.example.storageserver.service.ArrivalService;
import com.example.storageserver.service.StorageOrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArrivalServiceImpl implements ArrivalService {
    private final ArrivalRepository arrivalRepository;
    private final StorageOrderService storageOrderService;

    public ArrivalServiceImpl(ArrivalRepository arrivalRepository, StorageOrderService storageOrderService) {
        this.arrivalRepository = arrivalRepository;
        this.storageOrderService = storageOrderService;
    }

    @Override
    @Transactional
    public Arrival create(Arrival arrival) {
        if (arrival != null) {
            StorageOrder storageOrder = arrival.getStorageOrder();

            StorageOrder existingStorageOrder = storageOrderService.read(storageOrder.getId());

            Date originalDate = existingStorageOrder.getStorageOrderDate();
            Supplier originalSupplier = existingStorageOrder.getSupplier();

            existingStorageOrder.setStatus("received");

            existingStorageOrder.setStorageOrderDate(originalDate);
            existingStorageOrder.setSupplier(originalSupplier);

            storageOrderService.update(existingStorageOrder);

            return arrivalRepository.save(arrival);
        }
        return null;
    }

    @Override
    public Arrival read(long id) {
        return arrivalRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Arrival update(Arrival arrival) {
        if (arrival != null) {
            read(arrival.getId());
            return arrivalRepository.save(arrival);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        arrivalRepository.delete(read(id));
    }

    @Override
    public List<Arrival> getAll() {
        List<Arrival> arrivals = arrivalRepository.findAll();
        return arrivals.isEmpty() ? new ArrayList<>() : arrivals;
    }

}