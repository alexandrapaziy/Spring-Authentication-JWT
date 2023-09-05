package com.example.storageserver.service.impl;

import com.example.storageserver.model.*;
import com.example.storageserver.repository.IssuanceRepository;
import com.example.storageserver.service.CustomerOrderService;
import com.example.storageserver.service.IssuanceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IssuanceServiceImpl implements IssuanceService {
    private final IssuanceRepository issuanceRepository;
    private final CustomerOrderService customerOrderService;

    public IssuanceServiceImpl(IssuanceRepository issuanceRepository, CustomerOrderService customerOrderService) {
        this.issuanceRepository = issuanceRepository;
        this.customerOrderService = customerOrderService;
    }

    @Override
    @Transactional
    public Issuance create(Issuance issuance) {
        if (issuance != null) {
            CustomerOrder customerOrder = issuance.getCustomerOrder();

            CustomerOrder existingCustomerOrder = customerOrderService.read(customerOrder.getId());

            Date originalDate = existingCustomerOrder.getCustomerOrderDate();
            Customer originalCustomer = existingCustomerOrder.getCustomer();

            existingCustomerOrder.setStatus("received");

            existingCustomerOrder.setCustomerOrderDate(originalDate);
            existingCustomerOrder.setCustomer(originalCustomer);

            customerOrderService.update(existingCustomerOrder);

            return issuanceRepository.save(issuance);
        }
        return null;
    }

    @Override
    public Issuance read(long id) {
        return issuanceRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Issuance update(Issuance issuance) {
        if (issuance != null) {
            read(issuance.getId());
            return issuanceRepository.save(issuance);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        issuanceRepository.delete(read(id));
    }

    @Override
    public List<Issuance> getAll() {
        List<Issuance> issuances = issuanceRepository.findAll();
        return issuances.isEmpty() ? new ArrayList<>() : issuances;
    }

}