package com.vgs.rural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String login;

    @Column(length = 150, nullable = false)
    private String password;

    private Boolean is_active;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(Long id) {
        this.id = id;
    }
}
