package com.vn.bidu.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount_bidu")
public class DiscountBidu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_discount")
    private String nameDiscount;

    @Column(name = "price")
    private int price;

    @Column(name="image")
    private String image;

    @Column(name = "description_discount")
    private String descriptionDiscount;

    @ManyToMany(mappedBy = "discounts")
    private List<Product> products;
}
