package com.example.storageserver.controller;

import com.example.storageserver.exeption.WorkerNotFoundException;
import com.example.storageserver.model.Position;
import com.example.storageserver.model.Worker;
import com.example.storageserver.repository.PositionRepository;
import com.example.storageserver.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/worker")
@CrossOrigin("*")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Worker create(@RequestBody Worker worker) throws Exception {
        Position position = positionRepository.findByPosition("WORKER");

        Set<Position> positions = new HashSet<>();
        positions.add(position);

        worker.setPassword(this.bCryptPasswordEncoder.encode(worker.getPassword()));

        worker.setPositions(positions);

        return this.workerService.create(worker);
    }

    @GetMapping("/{email}")
    public Worker get(@PathVariable("email") String email) {
        return this.workerService.getByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.workerService.delete(id);
    }

    @ExceptionHandler(WorkerNotFoundException.class)
    public ResponseEntity<?> exceptionHandler(WorkerNotFoundException exception) {
        return ResponseEntity.ok(exceptionHandler(exception));
    }
}
