package com.example.storageserver.controller;

import com.example.storageserver.model.Goods;
import com.example.storageserver.service.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@CrossOrigin("*")
public class GoodsController {
    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping
    public ResponseEntity<Goods> createGoods(@RequestBody Goods goods) {
        Goods createdGoods = goodsService.create(goods);
        return new ResponseEntity<>(createdGoods, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoods(@PathVariable Long id) {
        Goods goods = goodsService.read(id);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Goods>> getAllGoods() {
        List<Goods> allGoods = goodsService.getAll();
        return new ResponseEntity<>(allGoods, HttpStatus.OK);
    }

    @GetMapping("/brand-names")
    public List<String> getAllBrandNames() {
        List<String> brandNames = goodsService.getAllBrandNames();
        return brandNames;
    }

    @GetMapping("/types-of-packing")
    public List<String> getAllTypesOfPacking() {
        List<String> typesOfPacking = goodsService.getAllTypesOfPacking();
        return typesOfPacking;
    }

    @GetMapping("/types")
    public List<String> getAllTypes() {
        List<String> types = goodsService.getAllTypes();
        return types;
    }

    @GetMapping("/origins")
    public List<String> getAllOrigins() {
        List<String> origins = goodsService.getAllOrigins();
        return origins;
    }

}