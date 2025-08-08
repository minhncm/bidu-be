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
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_shop")
    private String nameShop;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "thumbnail")
   private String thumbnail;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "following_shop")
    private int following;

    @Column(name = "follower_shop")
    private int  follower;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "shop")
    private Set<Discount> listDiscount;

    @OneToMany(mappedBy = "shop")
    private Set<Product> listProduct;
}
