package com.example.reactiveoracle.modules.xt.controller;

import com.example.reactiveoracle.modules.xt.entity.XtUser;
import com.example.reactiveoracle.modules.xt.service.XtUserService;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2023-01-06
 **/
@RestController
public class XtUserController {

    private final XtUserService xtUserService;

    public XtUserController(XtUserService xtUserService) {
        this.xtUserService = xtUserService;
    }

    @GetMapping("/user")
    public Flux<XtUser> findAllUser(ServerHttpRequest request) {
        return xtUserService.findAll();
    }

    @GetMapping("/user/{name}")
    public Mono<XtUser> findUserByName(@PathVariable("name") String name) {
        return xtUserService.findByName(name);
    }
}
