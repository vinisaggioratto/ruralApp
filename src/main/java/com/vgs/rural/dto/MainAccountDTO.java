package com.vgs.rural.dto;

import com.vgs.rural.entity.Register;
import com.vgs.rural.enums.TypePayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainAccountDTO {

    private Long id;
    private String name;
    private String cpf_cnpj;
    private TypePayment typePayment;
    private Integer num_user_auth;
    private Integer activity_auth;
    private Boolean is_active;
    private Register register;
}
