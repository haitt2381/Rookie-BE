package com.nashtech.rookie.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "brands")
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

//    @OneToMany(mappedBy = )
//    private List<Product> products;
}