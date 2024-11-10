package com.example.demo.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class LoginResDto {

    private final String token;

    @Builder
    public LoginResDto(String token) {
        this.token = token;
    }
}
