package com.example.storageserver.controller;

import com.example.storageserver.model.StorageOrder;
import com.example.storageserver.service.StorageOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage-order")
@CrossOrigin("*")
public class StorageOrderController {
    private final StorageOrderService storageOrderService;

    public StorageOrderController(StorageOrderService storageOrderService) {
        this.storageOrderService = storageOrderService;
    }

    @PostMapping
    public ResponseEntity<StorageOrder> createStorageOrder(@RequestBody StorageOrder storageOrder) {
        storageOrder.setStatus("pending");
        StorageOrder createdOrder = storageOrderService.create(storageOrder);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageOrder> getStorageOrder(@PathVariable Long id) {
        StorageOrder storageOrder = storageOrderService.read(id);
        return new ResponseEntity<>(storageOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorageOrder(@PathVariable Long id) {
        storageOrderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<StorageOrder>> getAllStorageOrder() {
        List<StorageOrder> allStorageOrder = storageOrderService.getAll();
        return new ResponseEntity<>(allStorageOrder, HttpStatus.OK);
    }

    @GetMapping("not-arrival")
    public ResponseEntity<List<StorageOrder>> getAllNotArrivalStorageOrder() {
        List<StorageOrder> allStorageOrder = storageOrderService.getAllNotArrival();
        return new ResponseEntity<>(allStorageOrder, HttpStatus.OK);
    }

}