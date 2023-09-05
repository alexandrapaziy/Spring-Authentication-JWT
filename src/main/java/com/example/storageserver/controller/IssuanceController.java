package com.example.storageserver.controller;

import com.example.storageserver.model.Issuance;
import com.example.storageserver.service.IssuanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issuance")
@CrossOrigin("*")
public class IssuanceController {
    private final IssuanceService issuanceService;

    public IssuanceController(IssuanceService issuanceService) {
        this.issuanceService = issuanceService;
    }

    @PostMapping
    public ResponseEntity<Issuance> createIssuance(@RequestBody Issuance issuance) {
        Issuance createdIssuance = issuanceService.create(issuance);
        return new ResponseEntity<>(createdIssuance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issuance> getIssuance(@PathVariable Long id) {
        Issuance issuance = issuanceService.read(id);
        return new ResponseEntity<>(issuance, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Issuance>> getAllIssuance() {
        List<Issuance> allIssuance = issuanceService.getAll();
        return new ResponseEntity<>(allIssuance, HttpStatus.OK);
    }

}