package com.vn.bidu.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "price")
    private int price;

    @Column(name="percent")
    private int percent;

    @Column(name = "sold_quantity")
    private int soldQuantity;

    @Column(name = "description_product")
    private String descriptionProduct;

    @Column(name="material")
    private String material;

    @Column(name="origin")
    private String origin;

    @Column(name="style")
    private String style;

    @Column(name="vignette")
    private String vignette;

    @Column(name="collar")
    private String collar;

    @Column(name="season")
    private String season;

    @Column(name="body_shape")
    private String bodyShape;

    @Column(name="gender")
    private String gender;

    @Column(name="brand")
    private String brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<DiscountBidu> listDiscount;

    @ManyToOne
    @JoinColumn(name = "id_shop" , insertable = false, updatable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "id_category" , insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Variant> listVariant;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> listOrderDetail;

}
