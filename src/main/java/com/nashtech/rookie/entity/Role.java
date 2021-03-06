package com.nashtech.rookie.entity;

import com.nashtech.rookie.constant.URole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private int id;

  @Enumerated(EnumType.STRING)
  @Column(name = "name")
  private URole name;
}
