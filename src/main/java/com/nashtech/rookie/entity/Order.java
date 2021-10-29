package com.nashtech.rookie.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private LocalDate createDate;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;
}