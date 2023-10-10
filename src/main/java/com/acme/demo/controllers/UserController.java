package com.acme.demo.controllers;

import com.acme.demo.entities.User;
import com.acme.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping()
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

}
