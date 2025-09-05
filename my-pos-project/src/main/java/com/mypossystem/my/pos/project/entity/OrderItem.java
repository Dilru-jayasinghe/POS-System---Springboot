package com.mypossystem.my.pos.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "quantity",length = 20,nullable = false)
    private Integer quantity;

    @Column(name = "price",length = 20,nullable = false)
    private Double price; // price per unit at the time of order

    @Column(name = "sub_total",length = 20,nullable = false)
    private Double subTotal; // price * quantity


}