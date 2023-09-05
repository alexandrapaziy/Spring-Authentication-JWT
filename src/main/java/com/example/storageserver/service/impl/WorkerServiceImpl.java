package com.example.storageserver.service.impl;

import com.example.storageserver.exeption.WorkerFoundException;
import com.example.storageserver.model.Worker;
import com.example.storageserver.repository.WorkerRepository;
import com.example.storageserver.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker create(Worker worker) throws WorkerFoundException {

        Worker local = this.workerRepository.findByEmail(worker.getEmail());
        if (local != null) {
            throw new WorkerFoundException();
        } else {
            return workerRepository.save(worker);
        }
    }

    @Override
    public Worker read(long id) {
        return workerRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Worker update(Worker worker) {
        if (worker != null) {
            read(worker.getId());
            return workerRepository.save(worker);
        }
        return null;
    }

    @Override
    public Worker getByEmail(String email) {
        return workerRepository.findByEmail(email);
    }

    @Override
    public void delete(long id) {
        workerRepository.delete(read(id));
    }

    @Override
    public List<Worker> getAll() {
        List<Worker> workers = workerRepository.findAll();
        return workers.isEmpty() ? new ArrayList<>() : workers;
    }

}