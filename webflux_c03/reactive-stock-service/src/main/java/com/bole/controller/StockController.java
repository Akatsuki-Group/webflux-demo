package com.bole.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


/**
 * @Description:
 * @Author: 伯乐
 */

@RestController
@RequestMapping("/stock")
public class StockController {

    @GetMapping("/get/{productId}")
    public Mono<Integer> get(@PathVariable("productId") Long productId) {
        System.out.println("productId:" + productId);
        return Mono.just(100);
    }

}

