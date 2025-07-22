package com.example.study.controller;

import com.example.study.Service.UserService;
import com.example.study.dto.UserRequestDto;
import com.example.study.dto.UserResponseDto;
import com.example.study.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private Map<Integer, User> userStore = new HashMap<> ();
    private AtomicInteger idGenerator = new AtomicInteger ();

//    @PostMapping
//    public String createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService. deleteUser(id);
    }

}
