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
@Table(name = "size_color")
public class SizeColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "color")
    private String color;

    @Column(name= "inventory")
    private int inventory;

    @ManyToOne
    @JoinColumn(name = "id_size" , insertable = false, updatable = false)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_product" , insertable = false, updatable = false)
    private Product product;
}
