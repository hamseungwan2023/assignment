package com.example.demo.user.controller;

import com.example.demo.user.dto.LoginReqDto;
import com.example.demo.user.dto.LoginResDto;
import com.example.demo.user.dto.SignupReqDto;
import com.example.demo.user.dto.SignupResDto;
import com.example.demo.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/users/signup")
    @Operation(summary = "회원가입", description = "회원가입 할 때 사용하는 API")
    public ResponseEntity<SignupResDto> signup(@Valid @RequestBody SignupReqDto reqDto) {
        return new ResponseEntity<>(userService.signupUser(reqDto), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/v1/users/login")
    @Operation(summary = "로그인", description = "로그인 할 때 사용하는 API")
    public ResponseEntity<LoginResDto> login(@Valid @RequestBody LoginReqDto reqDto) throws BadRequestException {
        return new ResponseEntity<>(userService.login(reqDto), HttpStatusCode.valueOf(200));
    }
}
