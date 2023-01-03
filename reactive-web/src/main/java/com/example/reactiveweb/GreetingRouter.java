package com.example.reactiveweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * @author zhangyong created on 2023-01-03
 **/

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                .and(RouterFunctions.route(GET("/hi").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hi));
    }

    @Bean
    public RouterFunction<ServerResponse> route2(GreetingBatchHandler greetingBatchHandler) {
        return RouterFunctions
                .route(GET("/greets").and(accept(MediaType.APPLICATION_JSON)), greetingBatchHandler::greets);
    }
}
