package com.nashtech.rookie.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "product_reviews",
    indexes = {
      @Index(name = "product_review_user_id_uindex", columnList = "user_id", unique = true),
      @Index(name = "product_review_product_id_uindex", columnList = "product_id", unique = true)
    })
@Entity
public class ProductReview {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "rating", nullable = false)
  private int rating;

  @Column(name = "content")
  private String content;

  @Column(name = "created_at", nullable = false)
  private Date createdAt;
}
