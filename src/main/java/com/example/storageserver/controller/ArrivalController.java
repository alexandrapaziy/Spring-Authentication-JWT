package com.example.storageserver.controller;

import com.example.storageserver.model.Arrival;
import com.example.storageserver.service.ArrivalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arrival")
@CrossOrigin("*")
public class ArrivalController {
    private final ArrivalService arrivalService;

    public ArrivalController(ArrivalService arrivalService) {
        this.arrivalService = arrivalService;
    }

    @PostMapping
    public ResponseEntity<Arrival> createArrival(@RequestBody Arrival arrival) {
        Arrival createdArrival = arrivalService.create(arrival);
        return new ResponseEntity<>(createdArrival, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arrival> getArrival(@PathVariable Long id) {
        Arrival arrival = arrivalService.read(id);
        return new ResponseEntity<>(arrival, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Arrival>> getAllArrival() {
        List<Arrival> allArrival = arrivalService.getAll();
        return new ResponseEntity<>(allArrival, HttpStatus.OK);
    }

}