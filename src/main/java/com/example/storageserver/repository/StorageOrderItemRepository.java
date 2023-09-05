package com.example.storageserver.repository;

import com.example.storageserver.model.StorageOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageOrderItemRepository extends JpaRepository<StorageOrderItem, Long> {
}