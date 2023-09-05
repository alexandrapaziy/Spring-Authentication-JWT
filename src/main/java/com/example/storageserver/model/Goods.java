package com.example.storageserver.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Goods {

    @Id
    private Long id;

    @NotBlank(message = "Cannot be empty")
    private String name;

    @NotBlank(message = "Cannot be empty")
    private String brandName;

    @NotBlank(message = "Cannot be empty")
    @Size(max = 500)
    private String description;

    @NotBlank(message = "Cannot be empty")
    private String typeOfPacking;

    @NotBlank(message = "Cannot be empty")
    private int quantityInPack;

    @NotBlank(message = "Cannot be empty")
    private String type;

    @NotBlank(message = "Cannot be empty")
    private String origin;

    @NotBlank(message = "Cannot be empty")
    private double netWeight;

    @NotBlank(message = "Cannot be empty")
    private double cost;

    @NotBlank(message = "Cannot be empty")
    private double price;

    @OneToMany(mappedBy = "goods")
    @JsonIgnore
    private List<StorageOrderItem> storageOrderItems;

    @OneToMany(mappedBy = "goods")
    @JsonIgnore
    private List<CustomerOrderItem> customerOrderItems;

}