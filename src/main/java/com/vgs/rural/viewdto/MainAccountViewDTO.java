package com.vgs.rural.viewdto;

import com.vgs.rural.entity.Register;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainAccountViewDTO {

    private Long id;
    private String name;
    private String cpf_cnpj;
    private Integer num_user_auth;
    private Integer activity_auth;
    private Boolean is_active;
    private String registerName;

    public MainAccountViewDTO(Long id, String name, String cpf_cnpj, Integer num_user_auth,
                              Integer activity_auth, Boolean is_active, Register register) {
        this.id = id;
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.num_user_auth = num_user_auth;
        this.activity_auth = activity_auth;
        this.is_active = is_active;
        this.registerName = register.getName();
    }
}
