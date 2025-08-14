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
@Table(name = "variant")
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "color")
    private String color;

    @Column(name="size")
    private String size;

    @Column(name= "inventory")
    private int inventory;


    @ManyToOne
    @JoinColumn(name = "id_product" , insertable = false, updatable = false)
    private Product product;
}
