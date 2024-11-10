package com.example.demo.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "authorities")
@Getter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String authorityName;
}
