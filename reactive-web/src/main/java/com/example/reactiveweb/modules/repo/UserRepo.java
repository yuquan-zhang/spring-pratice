package com.example.reactiveweb.modules.repo;

import com.example.reactiveweb.modules.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2023-01-04
 **/
public interface UserRepo extends ReactiveCrudRepository<User, Long> {

    /**
     * 根据手机号查找用户
     * @param phone 手机号，不能为空
     * @return 用户对象 {@link User}
     */
    Mono<User> findByPhone(String phone);
}
