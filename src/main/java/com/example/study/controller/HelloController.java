package com.example.study.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

//    private Map<Integer, User> userStore = new HashMap<>();
//    private AtomicInteger idGenerator = new AtomicInteger();

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return String.format("안녕하세요, %s님!", name);
    }

//    @PostMapping("/user")
//    public String createUser(@RequestBody User user) {
//        return String.format("사용자 이름은 %s, 나이는 %d입니다.", user.getName(), user.getAge());
//    }

//    @PostMapping("/user")
//    public User createUser(@RequestBody User user) {
//        int id = idGenerator.incrementAndGet();
//        user.setId(id);
//        userStore.put(id, user);
//        return user;
//    }
//
//    @GetMapping("/id")
//    public User getUser(@RequestParam int id) {
//        return userStore.get(id);
//    }
}

//class User {
//    private int id;
//    private String name;
//    private int age;
//
//    // 기본 생성자
//    public User() {}
//
//    // getter & setter
//    public int getId() { return id; }
//    public void setId(int id) { this.id = id; }
//    public String getName() { return name;}
//    public void setName(String name) { this.name = name; }
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }
//}
