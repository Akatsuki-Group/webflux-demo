package com.bole.webflux.client;

import com.bole.webflux.domain.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/7 22:18
 */
public class MyWebClient {

    public static void main(String[] args) {
        var product = Product.builder()
                .category("E")
                .name("水壶").stock(100)
                .price(BigDecimal.valueOf(59.99))
                .build();

        var webClient = WebClient.create("http://localhost:8080/route/product");
        webClient.post().uri("/save")
                .body(Mono.just(product), Product.class)
                .exchange()
                .doOnNext(
                        clientResponse -> System.out.println("############: " + clientResponse.statusCode())
                ).block();

                 /* webClient.get().uri("/find/{productId}", 25)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(p -> System.out.println("############: " + p))
                .block();*/
        //var webClient0 = WebClient.create("http://localhost:9994/stock");
       /* var webClient0 = WebClient.create("http://reative-stock-service/stock");

        webClient0.get().uri("/get/{productId}", 25)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(p -> System.out.println("############: " + p))
                .block();
*/


    }
}
