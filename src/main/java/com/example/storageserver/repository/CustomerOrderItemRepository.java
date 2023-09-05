package com.example.storageserver.repository;

import com.example.storageserver.model.CustomerOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderItemRepository extends JpaRepository<CustomerOrderItem, Long> {
}