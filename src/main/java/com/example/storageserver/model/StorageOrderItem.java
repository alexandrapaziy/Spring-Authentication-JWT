package com.example.storageserver.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
public class StorageOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private StorageOrder order;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private Integer quantityOfGoods;

}