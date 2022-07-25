package com.bole.webflux.funcDemo;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 14:58
 */
public class WebFluxClient {
    private WebClient client = WebClient.create("http://localhost:8080");
    private Mono<ClientResponse> responseMono = client.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public String getResult() {
        return  responseMono.flatMap(res -> res.bodyToMono(String.class)).block();
    }

}
