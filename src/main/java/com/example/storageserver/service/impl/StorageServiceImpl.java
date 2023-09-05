package com.example.storageserver.service.impl;

import com.example.storageserver.model.Storage;
import com.example.storageserver.repository.StorageRepository;
import com.example.storageserver.service.StorageService;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public Storage create(Storage storage) {
        if (storage != null) {
            return storageRepository.save(storage);
        }
        return null;
    }

    @Override
    public Storage read(long id) {
        return storageRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Storage read() {
        return storageRepository.findStorage();
    }

    @Override
    public Storage update(Storage storage) {
        if (storage != null) {
            read(storage.getId());
            return storageRepository.save(storage);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        storageRepository.delete(read(id));
    }

}