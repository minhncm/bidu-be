package com.vn.bidu.entity;


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

    @Column(name = "sold_quantity")
    private int soldQuantity;

    @Column(name = "description_product")
    private String descriptionProduct;

    @ManyToOne
    @JoinColumn(name = "id_shop" , insertable = false, updatable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "id_category" , insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<SizeColor> listSizeColor;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> listOrderDetail;

}
