package com.example.storageserver.repository;

import com.example.storageserver.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Query(value = "SELECT * FROM Storage LIMIT 1", nativeQuery = true)
    Storage findStorage();

}