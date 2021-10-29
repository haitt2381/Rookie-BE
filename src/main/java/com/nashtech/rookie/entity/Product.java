package com.nashtech.rookie.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "products",
    indexes = {@Index(name = "product_slug_uindex", columnList = "slug", unique = true)})
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "summary")
    private String summary;

    @Column(name = "discount", nullable = false)
    private BigDecimal discount;

    @Column(name = "public_shop", nullable = false)
    private boolean publicShop = false;

    @Column(name = "create_at", nullable = false)
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt ;

    @Column(name = "public_at")
    private Date publicAt;

    @Column(name = "content")
    private String content;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @OneToMany(mappedBy = "product",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> productDetails;

    public void addCategory(Category category){
        if(categories == null) categories = new HashSet<>();
        categories.add(category);
    }

    public void addProductDetail(ProductDetail productDetail){
        if(productDetails == null) productDetails = new HashSet<>();
        productDetails.add(productDetail);
    }

}