package com.example.storageserver.service.impl;

import com.example.storageserver.model.Goods;
import com.example.storageserver.repository.GoodsRepository;
import com.example.storageserver.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods create(Goods goods) {
        if (goods != null) {
            return goodsRepository.save(goods);
        }
        return null;
    }

    @Override
    public Goods read(long id) {
        return goodsRepository.findById(id).orElseThrow(
                () -> null);
    }

    @Override
    public Goods update(Goods goods) {
        if (goods != null) {
            read(goods.getId());
            return goodsRepository.save(goods);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        goodsRepository.delete(read(id));
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> goods = goodsRepository.findAll();
        return goods.isEmpty() ? new ArrayList<>() : goods;
    }

    @Override
    public List<String> getAllBrandNames() {
        return goodsRepository.findAllBrandName();
    }

    @Override
    public List<String> getAllTypesOfPacking() {
        return goodsRepository.findAllTypeOfPacking();
    }

    @Override
    public List<String> getAllTypes() {
        return goodsRepository.findAllType();
    }

    @Override
    public List<String> getAllOrigins() {
        return goodsRepository.findAllOrigin();
    }

}