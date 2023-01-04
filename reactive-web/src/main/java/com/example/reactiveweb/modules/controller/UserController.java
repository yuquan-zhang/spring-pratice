package com.example.reactiveweb.modules.controller;

import com.example.reactiveweb.modules.entity.User;
import com.example.reactiveweb.modules.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2023-01-04
 **/
@RestController
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user/{id}")
    public Mono<User> findUser(@PathVariable("id") Long id) {
        return userRepo.findById(id);
    }

    @GetMapping("/user2/{phone}")
    public Mono<User> findUser(@PathVariable("phone") String phone) {
        return userRepo.findByPhone(phone);
    }
}
