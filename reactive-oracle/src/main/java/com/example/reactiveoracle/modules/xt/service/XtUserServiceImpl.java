package com.example.reactiveoracle.modules.xt.service;

import com.example.reactiveoracle.modules.xt.entity.XtUser;
import com.example.reactiveoracle.modules.xt.repo.XtUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author zhangyong created on 2023-01-06
 **/
@Service
public class XtUserServiceImpl implements XtUserService{

    private final XtUserRepo xtUserRepo;

    @Autowired
    public XtUserServiceImpl(XtUserRepo xtUserRepo) {
        this.xtUserRepo = xtUserRepo;
    }

    @Override
    public Flux<XtUser> findAll() {
        return xtUserRepo.findAll();
    }

    @Override
    public Mono<XtUser> findByName(String name) {
        return Mono.defer(() -> xtUserRepo.findByName(name)).delaySubscription(Duration.ofMillis(700));
    }
}
