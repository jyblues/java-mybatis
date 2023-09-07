package com.jyblues.javamybatis2.users.controller;

import com.jyblues.javamybatis2.domain.service.UserService;
import com.jyblues.javamybatis2.repository.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/v1/users")
    public List<User> user() {
        return userService.getUsers();
    }

    @GetMapping("/api/v1/user/{id}")
    public User findUserById(@PathVariable("id") String id)
    {
        return userService.findUserById(id);
    }

    @PostMapping("/api/v1/create.user")
    public createUser(@RequestBody Map<String, String> params, Http
}
