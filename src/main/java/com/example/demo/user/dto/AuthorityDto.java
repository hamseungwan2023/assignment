package com.example.demo.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthorityDto {
    private final String authorityName;

    @Builder
    public AuthorityDto(String authorityName) {
        this.authorityName = authorityName;
    }
}
