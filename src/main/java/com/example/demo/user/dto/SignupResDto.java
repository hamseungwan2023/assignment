package com.example.demo.user.dto;

import com.example.demo.user.entity.Authority;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
public class SignupResDto {

    private final String username;
    private final String nickname;
    private final Set<String> authorityNames;

    @Builder
    public SignupResDto(String username, String nickname, Set<String> authorityNames) {  // 생성자 수정
        this.username = username;
        this.nickname = nickname;
        this.authorityNames = authorityNames;
    }
}
