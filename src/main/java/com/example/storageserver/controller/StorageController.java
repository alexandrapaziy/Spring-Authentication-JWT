package com.example.storageserver.controller;

import com.example.storageserver.model.Storage;
import com.example.storageserver.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
@CrossOrigin("*")
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<Storage> createStorage(@RequestBody Storage storage) {
        Storage createdStorage = storageService.create(storage);
        return new ResponseEntity<>(createdStorage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storage> getStorage(@PathVariable Long id) {
        Storage storage = storageService.read(id);
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Storage> getStorage() {
        Storage storage = storageService.read();
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorage(@PathVariable Long id) {
        storageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}