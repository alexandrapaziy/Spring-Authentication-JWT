package com.example.storageserver.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cannot be empty")
    private Date arrivalDate;

    @OneToOne
    @JoinColumn(name = "order_id")
    private StorageOrder storageOrder;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

}