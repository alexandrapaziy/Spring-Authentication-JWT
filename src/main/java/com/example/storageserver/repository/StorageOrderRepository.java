package com.example.storageserver.repository;

import com.example.storageserver.model.StorageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageOrderRepository extends JpaRepository<StorageOrder, Long> {

    @Query(value = "SELECT * FROM storage_order so LEFT JOIN arrival a ON so.id = a.order_id WHERE a.id IS NULL", nativeQuery = true)
    List<StorageOrder> findAllNotArrival();

}