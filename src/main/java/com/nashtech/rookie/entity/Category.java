package com.nashtech.rookie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "categories",
    indexes = {@Index(name = "categories_slug_uindex", columnList = "slug", unique = true)})
@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "slug", nullable = false)
  private String slug;

  @Column(name = "content")
  private String content;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Category categoryParent;

  @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Product> products;
}
