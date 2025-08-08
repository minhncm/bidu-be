package com.vn.bidu.entity;

import com.vn.bidu.custom.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "status")
    private Status status;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> listOrderDetail;

    @ManyToOne
    @JoinColumn(name = "id_user" , insertable = false, updatable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentMethod_id", referencedColumnName = "id")
    private PaymentMethod paymentMethod;
}
