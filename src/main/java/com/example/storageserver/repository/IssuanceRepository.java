package com.example.storageserver.repository;

import com.example.storageserver.model.Issuance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuanceRepository extends JpaRepository<Issuance, Long> {
}