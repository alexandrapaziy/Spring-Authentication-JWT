package com.example.storageserver.repository;

import com.example.storageserver.model.Position;
import com.example.storageserver.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByPosition(String position);
}
