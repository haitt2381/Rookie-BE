package com.nashtech.rookie.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product_details", indexes = {
        @Index(name = "product_details_product_id_uindex", columnList = "product_id", unique = true),
        @Index(name = "product_details_color_uindex", columnList = "color", unique = true),
        @Index(name = "product_details_memory_uindex", columnList = "memory", unique = true)
})
@Entity
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "memory")
    private String memory;

    @Column(name = "ram")
    private String ram;
}