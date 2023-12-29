package com.vgs.rural.entity;

import com.vgs.rural.enums.TypePayment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "main_account")
public class MainAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 18, nullable = false)
    private String cpf_cnpj;

    private TypePayment typePayment;

    @Column(length = 4)
    private Integer num_user_auth;

    @Column(length = 4)
    private Integer activity_auth;

    private Boolean is_active;

    @ManyToOne
    @JoinColumn
    private Register register;

    public MainAccount(Long id) {
        this.id = id;
    }
}
