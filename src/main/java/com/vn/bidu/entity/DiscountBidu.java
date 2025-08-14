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

    @ManyToOne
    @JoinColumn(name= "id_product", insertable = false, updatable = false)
    private Product product;
}
