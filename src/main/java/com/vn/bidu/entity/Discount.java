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
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_discount")
    private String nameDiscount;

    @Column(name = "percent")
    private double percent;

    @Column(name = "description_discount")
    private String descriptionDiscount;

    @ManyToOne
    @JoinColumn(name= "id_shop", insertable = false, updatable = false)
    private Shop shop;
}
