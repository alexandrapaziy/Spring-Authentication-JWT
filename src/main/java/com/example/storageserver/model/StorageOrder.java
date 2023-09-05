package com.example.storageserver.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class StorageOrder {

    @Id
    private Long id;

    @NotBlank(message = "Cannot be empty")
    private Date storageOrderDate;

    @NotBlank(message = "Cannot be empty")
    private String status;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToOne(mappedBy = "storageOrder", cascade = CascadeType.ALL)
    @JsonIgnore
    private Arrival arrival;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<StorageOrderItem> storageOrderItems;

}