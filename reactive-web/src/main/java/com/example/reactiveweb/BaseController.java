package com.example.reactiveweb;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

/**
 * @author zhangyong created on 2023-01-03
 **/
@Controller
public class BaseController {

    @GetMapping("index")
    public Mono<String> index(ServerHttpRequest request, Model model) {
        model.addAttribute("name", request.getQueryParams().get("name"));
        return Mono.just("index.html");
    }
}
