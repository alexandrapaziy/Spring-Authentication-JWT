package com.example.storageserver.service;

import com.example.storageserver.model.Storage;

public interface StorageService {

    Storage create(Storage storage);

    Storage read(long id);
    Storage read();

    Storage update(Storage storage);

    void delete(long id);

}

