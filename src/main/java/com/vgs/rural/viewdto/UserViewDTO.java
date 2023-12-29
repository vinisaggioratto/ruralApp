package com.vgs.rural.viewdto;

import com.vgs.rural.entity.Register;
import com.vgs.rural.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

    private Long id;
    private String name;
    private String login;
    private Boolean is_active;
    private String register;
    private String roleName;

    public UserViewDTO(Long id, String name, String login, Boolean is_active,Register register, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.is_active = is_active;
        this.register = register.getName();
        this.roleName = role.getRole();
    }
}
