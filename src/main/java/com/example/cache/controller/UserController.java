package com.example.cache.controller;

import com.example.cache.Service.UserService;
import com.example.cache.jpa.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }
}
