package com.example.storageserver.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    private Long id;

    @NotBlank(message = "Cannot be empty")
    private String name;

    @NotBlank(message = "Cannot be empty")
    private String contactPerson;

    @NotBlank(message = "Cannot be empty")
    @Size(min = 13, max = 13)
    private String phone;

    @NotBlank(message = "Cannot be empty")
    @Size(max = 300)
    private String address;

    @NotBlank(message = "Cannot be empty")
    @Email
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;

}