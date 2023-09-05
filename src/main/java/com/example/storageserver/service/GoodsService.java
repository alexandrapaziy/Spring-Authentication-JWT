package com.example.storageserver.service;

import com.example.storageserver.model.Goods;

import java.util.List;

public interface GoodsService {
    Goods create(Goods goods);

    Goods read(long id);

    Goods update(Goods goods);

    void delete(long id);

    List<Goods> getAll();

    List<String> getAllBrandNames();

    List<String> getAllTypesOfPacking();

    List<String> getAllTypes();

    List<String> getAllOrigins();

}