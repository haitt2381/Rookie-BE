package com.nashtech.rookie.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "note")
  private String note;

  @Column(name = "total", nullable = false)
  private BigDecimal total;

  @Column(name = "create_date", nullable = false)
  private Date createDate;

  @Column(name = "recipient_name", nullable = false)
  private String recipientName;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "address", nullable = false)
  private String address;

  @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<OrderDetail> orderDetails;

  @ManyToOne(optional = false)
  @JoinColumn(name = "customer_id", nullable = false)
  private User customer;

  public void addOrderDetail(OrderDetail orderDetail){
    if(orderDetails == null) orderDetails = new ArrayList<>();
    orderDetails.add(orderDetail);
  }

}
