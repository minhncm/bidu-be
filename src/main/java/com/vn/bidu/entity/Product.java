package com.vn.bidu.entity;


import com.vn.bidu.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Column(name="brand")
    private String brand;

    @ManyToMany
    @JoinTable(name = "product_discount_bidu",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_discount_bidu"))
    private Set<DiscountBidu> discounts =new HashSet<>() ;

    @ManyToOne
    @JoinColumn(name = "id_shop" , insertable = false, updatable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "id_category" , insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL ,orphanRemoval = true)
    private Set<Variant> variants = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    public Product(String nameProduct, int price, int percent, int soldQuantity) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.percent = percent;
        this.soldQuantity = soldQuantity;
    }
}
