package com.bole.webflux.funcDemo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 14:46
 */
@Component
public class WebfluxHandle {

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("hello guys!!"));
    }
}
