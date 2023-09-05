package com.example.storageserver.service;

import com.example.storageserver.model.Arrival;

import java.util.List;

public interface ArrivalService {

    Arrival create(Arrival arrival);

    Arrival read(long id);

    Arrival update(Arrival arrival);

    void delete(long id);

    List<Arrival> getAll();

}