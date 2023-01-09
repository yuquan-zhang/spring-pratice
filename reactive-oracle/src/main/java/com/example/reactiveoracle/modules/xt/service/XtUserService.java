package com.example.reactiveoracle.modules.xt.service;

import com.example.reactiveoracle.modules.xt.entity.XtUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2023-01-06
 **/
public interface XtUserService {

    Flux<XtUser> findAll();

    Mono<XtUser> findByName(String name);
}
