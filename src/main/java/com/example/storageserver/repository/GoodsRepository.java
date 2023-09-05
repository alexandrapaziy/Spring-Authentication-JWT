package com.example.storageserver.repository;

import com.example.storageserver.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    @Query(value = "SELECT DISTINCT brand_name FROM Goods", nativeQuery = true)
    List<String> findAllBrandName();

    @Query(value = "SELECT DISTINCT type_of_packing FROM Goods", nativeQuery = true)
    List<String> findAllTypeOfPacking();

    @Query(value = "SELECT DISTINCT type FROM Goods", nativeQuery = true)
    List<String> findAllType();

    @Query(value = "SELECT DISTINCT origin FROM Goods", nativeQuery = true)
    List<String> findAllOrigin();

}