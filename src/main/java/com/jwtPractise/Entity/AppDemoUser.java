package com.jwtPractise.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_demo_user")
public class AppDemoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false,length=200)
    private String name;

    @Column(name = "username", nullable = false, unique = true, length = 300)
    private String username;

    @Column(name = "email", nullable = false, unique = true,length = 300)
    private String email;

    @Column(name = "password", nullable = false, unique = true, length = 1000)
    private String password;
    @Column(name = "role", nullable = false,length=200)
    private String role;

}