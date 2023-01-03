package com.example.reactiveweb;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyong created on 2023-01-03
 **/
@Component
public class GreetingBatchHandler {

    public Mono<ServerResponse> greets(ServerRequest request) {
        MultiValueMap<String, String> req = request.queryParams();
        List<Greeting> greetings = new ArrayList<>();
        req.forEach((k, v) -> {greetings.add(new Greeting(k + " " + v));});
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(greetings));
    }
}
