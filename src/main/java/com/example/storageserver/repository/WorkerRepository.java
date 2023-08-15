package com.example.storageserver.repository;

import com.example.storageserver.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Worker findByEmail(String email);
}
