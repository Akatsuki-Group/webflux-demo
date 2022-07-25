package com.bole.webflux.annDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 16:42
 */
@SpringBootApplication
@RestController
@RequestMapping("/annt")
public class AnnoControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnoControllerApplication.class, args);
    }

    @GetMapping("/get")
    public Mono<String> get() {
        return Mono.just("webflux annotation ");
    }
}
