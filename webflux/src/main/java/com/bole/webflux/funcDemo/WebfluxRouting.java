package com.bole.webflux.funcDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 14:51
 */
@Configuration
public class WebfluxRouting {

    @Bean
    public RouterFunction<ServerResponse> route(WebfluxHandle webfluxHandle) {
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), webfluxHandle::hello)
                ;
    }


}
