package com.example.reactiveweb;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyong created on 2023-01-03
 **/
@RestController
public class GreetingController {

    private static final AtomicInteger count = new AtomicInteger();

    @GetMapping("/flux_result")
    public Mono<String> getResult(ServerHttpRequest request) {
        System.out.println("next " + count.incrementAndGet());
        return Mono.defer(() -> Mono.just("Result is ready!"))
                .delaySubscription(Duration.ofMillis(500));
    }
}
