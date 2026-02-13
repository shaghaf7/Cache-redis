package com.example.cache.Service;

import com.example.cache.jpa.User;
import com.example.cache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private  UserRepository userRepository;

    @Cacheable(value = "users", key = "#username")
    public User getByUsername(String username) {
        System.out.println("Fetching from DB...");
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
