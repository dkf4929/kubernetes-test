package com.demo.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://login-service")
            .build();

    @GetMapping
    public ResponseEntity<String> getUser() {
        String responseBody = webClient.get()
                .uri("http://login-service/login")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return ResponseEntity.ok(responseBody);
    }
}
