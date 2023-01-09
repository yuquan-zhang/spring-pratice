package com.example.reactiveoracle.modules.xt.repo;

import com.example.reactiveoracle.modules.xt.entity.XtUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2023-01-06
 **/
public interface XtUserRepo extends ReactiveCrudRepository<XtUser, Long> {

    Mono<XtUser> findByName(String name);
}
