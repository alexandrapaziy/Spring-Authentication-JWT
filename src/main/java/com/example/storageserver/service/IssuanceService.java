package com.example.storageserver.service;

import com.example.storageserver.model.Issuance;

import java.util.List;

public interface IssuanceService {

    Issuance create(Issuance issuance);

    Issuance read(long id);

    Issuance update(Issuance issuance);

    void delete(long id);

    List<Issuance> getAll();

}