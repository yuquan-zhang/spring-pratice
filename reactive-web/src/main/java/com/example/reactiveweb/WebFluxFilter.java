package com.example.reactiveweb;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author zhangyong created on 2023-01-03
 **/
@Component
public class WebFluxFilter implements org.springframework.web.server.WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        return Mono
                .delay(Duration.ofMillis(200))
                .then(
                        webFilterChain.filter(serverWebExchange)
                );
    }
}
