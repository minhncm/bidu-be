package com.vn.bidu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "wards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ward {
    @Id
    @Column(length = 20, nullable = false)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "full_name_en")
    private String fullNameEn;

    @Column(name = "code_name")
    private String codeName;

    @ManyToOne
    @JoinColumn(name = "province_code")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "administrative_unit_id")
    private AdministrativeUnit administrativeUnit;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    private Set<Shop> shops;

    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    private Set<DeliveryLocation> deliveryLocations;
}
