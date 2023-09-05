package com.example.storageserver.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Position {

    @Id
    private Integer id;
    private String position;

}