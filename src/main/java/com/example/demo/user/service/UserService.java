package com.example.demo.user.service;

import com.example.demo.jwt.JwtProvider;
import com.example.demo.user.dto.LoginReqDto;
import com.example.demo.user.dto.LoginResDto;
import com.example.demo.user.dto.SignupReqDto;
import com.example.demo.user.dto.SignupResDto;
import com.example.demo.user.entity.Authority;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.AuthorityRepository;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignupResDto signupUser(SignupReqDto reqDto) {

        final Authority role = authorityRepository.findByAuthorityName("ROLE_USER")
                .orElseThrow(() -> new IllegalArgumentException("권한이 존재하지 않습니다."));

        final Set<Authority> authorities = new HashSet<>();
        authorities.add(role);

        final Set<String> authorityNames = authorities.stream()
                .map(Authority::getAuthorityName)
                .collect(Collectors.toSet());

        final String password = passwordEncoder.encode(reqDto.getPassword());
        final User user = User.builder()
                .username(reqDto.getUsername())
                .password(password)
                .nickname(reqDto.getNickname())
                .authorities(authorities)
                .build();

        userRepository.save(user);

        return SignupResDto.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .authorityNames(authorityNames)
                .build();
    }

    public LoginResDto login(LoginReqDto reqDto) throws BadRequestException {

        final User user = userRepository.findByUsername(reqDto.getUsername())
                .orElseThrow(()-> new IllegalArgumentException("해돵 유저 없음"));

        if (!passwordEncoder.matches(reqDto.getPassword(), user.getPassword())) {
            throw new BadRequestException("패스워드가 일치하지 않습니다.");
        }

        final Authority role = authorityRepository.findByAuthorityName("ROLE_USER")
                .orElseThrow(() -> new IllegalArgumentException("권한이 존재하지 않습니다."));

        final String token = jwtProvider.createAccessToken(user.getUsername(), role.getAuthorityName());
        return LoginResDto.builder()
                .token(token)
                .build();
    }
}
