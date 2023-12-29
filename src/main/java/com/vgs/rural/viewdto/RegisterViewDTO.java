package com.vgs.rural.viewdto;

import com.vgs.rural.enums.TypeRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterViewDTO {

    private Long id;
    private String name;
    private String cpf_cnpj;
    private String email;
    private Boolean is_active;
    private TypeRegister type_register;

}
