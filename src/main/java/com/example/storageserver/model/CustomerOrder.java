package com.example.storageserver.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class CustomerOrder {

    @Id
    private Long id;

    @NotBlank(message = "Cannot be empty")
    private Date customerOrderDate;

    @NotBlank(message = "Cannot be empty")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    @JsonIgnore
    private Issuance issuance;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CustomerOrderItem> customerOrderItems;

}