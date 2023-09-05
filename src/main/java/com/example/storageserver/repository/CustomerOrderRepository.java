package com.example.storageserver.repository;

import com.example.storageserver.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Query(value = "SELECT * FROM customer_order so LEFT JOIN issuance a ON so.id = a.order_id WHERE a.id IS NULL", nativeQuery = true)
    List<CustomerOrder> findAllNotIssuance();

}