package com.example.demo.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupReqDto {

    @NotBlank(message = "username은 필수 입력 값 입니다.")
    private String username;
    @NotBlank(message = "password는 필수 입력 값 입니다.")
    private String password;
    @NotBlank(message = "nickname은 필수 입력 값 입니다.")
    private String nickname;
}
