package com.example.storageserver.exeption;

import org.springframework.http.ResponseEntity;

public class WorkerNotFoundException extends Exception {

    public WorkerNotFoundException() {
        super("Worker with this email not found in data base, try with another one");
    }

    public WorkerNotFoundException(String message) {
        super(message);
    }

    public WorkerNotFoundException(ResponseEntity<?> exceptionHandler) {
    }
}

