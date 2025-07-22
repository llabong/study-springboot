package com.example.study.controller;

import com.example.study.entity.User;
import com.example.study.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {
    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return String.format("안녕하세요, %s님!", name);
    }
}
