package com.demo.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "login-service")
public interface LoginServiceClient {
    @GetMapping("/login")
    String login();
}
