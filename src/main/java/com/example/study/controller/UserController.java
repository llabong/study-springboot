package com.example.study.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/user")
public class UserController {

    private Map<Integer, User> userStore = new HashMap<> ();
    private AtomicInteger idGenerator = new AtomicInteger ();

    @PostMapping
    public User createUser(@RequestBody User user) {
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        userStore.put(id, user);

        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userStore.get(id);
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return userStore.values();
    }
}

class User {
    private int id;
    private String name;
    private int age;

    public User() {}

    public int getId() { return id;}
    public void setId(int id) {this.id = id;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}
