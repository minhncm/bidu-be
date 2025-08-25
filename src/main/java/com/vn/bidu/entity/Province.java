package com.vn.bidu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "provinces")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Province {
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

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<Ward> wards;

    @ManyToOne
    @JoinColumn(name = "administrative_unit_id")
    private AdministrativeUnit administrativeUnit;
}
