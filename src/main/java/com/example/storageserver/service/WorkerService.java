package com.example.storageserver.service;

import com.example.storageserver.exeption.WorkerFoundException;
import com.example.storageserver.exeption.WorkerNotFoundException;
import com.example.storageserver.model.Worker;

import java.util.List;

public interface WorkerService {

    Worker create(Worker worker) throws WorkerNotFoundException, WorkerFoundException;

    Worker read(long id);

    Worker update(Worker worker);

    Worker getByEmail(String email);

    void delete(long id);

    List<Worker> getAll();
}
