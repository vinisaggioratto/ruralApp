package com.vgs.rural.dto;

import com.vgs.rural.enums.TypeRegister;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private Long id;
    private String name;
    private String cpf_cnpj;
    private Timestamp date_birth;
    private String email;
    private String cell_phone;
    private Boolean is_whatsapp;
    private String road;
    private String district;
    private String state;
    private String country;
    private String notes;
    private Boolean is_active;
    private TypeRegister type_register;
}
