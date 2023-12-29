package com.vgs.rural.dto;

import com.vgs.rural.entity.Register;
import com.vgs.rural.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String password;
    private Boolean is_active;
    private Register register;
    private Role role;
}
