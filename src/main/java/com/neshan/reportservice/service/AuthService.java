package com.neshan.reportservice.service;

import com.neshan.reportservice.exception.NoSuchElementFoundException;
import com.neshan.reportservice.exception.PasswordMismatchException;
import com.neshan.reportservice.model.ApiResponse;
import com.neshan.reportservice.model.dto.LoginRequest;
import com.neshan.reportservice.model.dto.RegisterRequest;
import com.neshan.reportservice.model.entity.User;
import com.neshan.reportservice.repository.UserRepository;
import com.neshan.reportservice.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public ApiResponse<Object> register(RegisterRequest request) {

        if (!request.password().equals(request.confirmPassword())) {
            throw new PasswordMismatchException("Passwords do not match");
        }

        User user = User
                .builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return ApiResponse
                .builder()
                .status("success")
                .token(jwtToken)
                .build();
    }

    public ApiResponse<Object> login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()));

        User user = userRepository
                .findByEmail(request.email())
                .orElseThrow(() -> new NoSuchElementFoundException("Invalid user credentials!"));

        String jwtToken = jwtService.generateToken(user);
        return ApiResponse
                .builder()
                .status("success")
                .token(jwtToken)
                .build();
    }
}
