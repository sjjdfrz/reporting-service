package com.neshan.reportservice.runner;
import com.neshan.reportservice.model.entity.User;
import com.neshan.reportservice.model.enums.Role;
import com.neshan.reportservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserRunner implements CommandLineRunner {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        User user1 = User
                .builder()
                .firstName("Sajjad")
                .lastName("Farzane")
                .email("sajjadfarzane@gmail.com")
                .password(passwordEncoder.encode("sajjad12345"))
                .role(Role.ADMIN)
                .build();

        User user2 = User
                .builder()
                .firstName("Saleh")
                .lastName("Shakour")
                .email("salehshakour@gmail.com")
                .password(passwordEncoder.encode("saleh12345"))
                .build();

        User user3 = User
                .builder()
                .firstName("Soroosh")
                .lastName("Faal")
                .email("sorooshfaal@gmail.com")
                .password(passwordEncoder.encode("soroosh12345"))
                .build();

        User user4 = User
                .builder()
                .firstName("Abolfazl")
                .lastName("Mohajer")
                .email("abolfazlmohajer@gmail.com")
                .role(Role.OPERATOR)
                .password(passwordEncoder.encode("abolfazl12345"))
                .build();

        userRepository.saveAll(List.of(user1, user2, user3, user4));
    }
}
