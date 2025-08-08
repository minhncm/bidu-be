package com.vn.bidu.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_product" , insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order" , insertable = false, updatable = false)
    private Order order;
}
