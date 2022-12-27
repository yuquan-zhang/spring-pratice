package com.example.bookreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2022/12/27
 **/
@Service
public class BookService {

    private final static Logger LOG = LoggerFactory.getLogger(BookService.class);

    private final WebClient webClient;
    private final ReactiveCircuitBreaker reactiveCircuitBreaker;

    public BookService(ReactiveCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
        reactiveCircuitBreaker = circuitBreakerFactory.create("recommended");
    }

    public Mono<String> readingList() {
        return reactiveCircuitBreaker.run(webClient.get().uri("/recommended").retrieve().bodyToMono(String.class), throwable -> {
            LOG.warn("Error making request to book service", throwable);
            return Mono.just("Cloud Native Java (O'Reilly)");
        });
    }
}
