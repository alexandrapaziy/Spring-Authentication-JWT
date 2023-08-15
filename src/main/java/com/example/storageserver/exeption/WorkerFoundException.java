package com.example.storageserver.exeption;

import org.springframework.http.ResponseEntity;

public class WorkerFoundException extends Exception {

    public WorkerFoundException() {
        super("Worker with this email is already in data base, try with another one");
    }

    public WorkerFoundException(String message) {
        super(message);
    }

    public WorkerFoundException(ResponseEntity<?> exceptionHandler) {
    }
}

