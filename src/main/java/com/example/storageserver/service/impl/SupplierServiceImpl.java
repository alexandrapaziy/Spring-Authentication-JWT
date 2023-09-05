package com.example.storageserver.service.impl;

import com.example.storageserver.model.Supplier;
import com.example.storageserver.repository.SupplierRepository;
import com.example.storageserver.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        if (supplier != null) {
            return supplierRepository.save(supplier);
        }
        return null;
    }

    @Override
    public Supplier read(long id) {
        return supplierRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Supplier update(Supplier supplier) {
        if (supplier != null) {
            read(supplier.getId());
            return supplierRepository.save(supplier);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        supplierRepository.delete(read(id));
    }

    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.isEmpty() ? new ArrayList<>() : suppliers;
    }

}