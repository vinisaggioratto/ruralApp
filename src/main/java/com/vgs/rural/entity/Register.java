package com.vgs.rural.entity;

import com.vgs.rural.enums.TypeRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 18, nullable = false)
    private String cpf_cnpj;

    private Timestamp date_birth;

    @Email
    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String cell_phone;

    private Boolean is_whatsapp;

    @Column(length = 100, nullable = false)
    private String road;

    @Column(length = 100, nullable = false)
    private String district;

    @Column(length = 100, nullable = false)
    private String state;

    @Column(length = 100, nullable = false)
    private String country;

    @Column(length = 800, nullable = true)
    private String notes;

    private Boolean is_active;

    @Enumerated
    private TypeRegister type_register;

    public Register(Long id) {
        this.id = id;
    }
}
