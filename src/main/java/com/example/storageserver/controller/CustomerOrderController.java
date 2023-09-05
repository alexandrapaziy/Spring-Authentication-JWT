package com.example.storageserver.controller;

import com.example.storageserver.model.CustomerOrder;
import com.example.storageserver.service.CustomerOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-order")
@CrossOrigin("*")
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping
    public ResponseEntity<CustomerOrder> createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        customerOrder.setStatus("accepted");
        CustomerOrder createdOrder = customerOrderService.create(customerOrder);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable Long id) {
        CustomerOrder customerOrder = customerOrderService.read(id);
        return new ResponseEntity<>(customerOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerOrder(@PathVariable Long id) {
        customerOrderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrder() {
        List<CustomerOrder> allCustomerOrder = customerOrderService.getAll();
        return new ResponseEntity<>(allCustomerOrder, HttpStatus.OK);
    }

    @GetMapping("not-issuance")
    public ResponseEntity<List<CustomerOrder>> getAllNotIssuanceCustomerOrder() {
        List<CustomerOrder> allCustomerOrder = customerOrderService.getAllNotIssuance();
        return new ResponseEntity<>(allCustomerOrder, HttpStatus.OK);
    }

}