package com.example.storageserver.service;

import com.example.storageserver.model.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier create(Supplier supplier);

    Supplier read(long id);

    Supplier update(Supplier supplier);

    void delete(long id);

    List<Supplier> getAll();

}