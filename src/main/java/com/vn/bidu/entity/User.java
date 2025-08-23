package com.vn.bidu.entity;


import com.vn.bidu.enums.Gender;
import com.vn.bidu.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
            private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password_user")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_user")
    private Role role;

    @Column(name = "phone_number")
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> listOrder;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<DeliveryLocation> listDeliveryLocation;
}
