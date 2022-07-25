package com.bole.webflux.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/3 21:49
 */
public class ReactorDemo {
    public static void main(String[] args) {

        /*Mono<String> mono=Mono.just("mono");
        mono.subscribe(i-> System.out.println("1个元素（mono）"+i));
        Mono mono1=Mono.empty();
        mono1.subscribe(i-> System.out.println("空元素（mono）"+i));*/

        //简单方式
        /*Flux<String> flux= Flux.just("flux1","flux2","flux3","flux4");
        flux.subscribe(i-> System.out.println("多个元素（Flux）"+i));
        Flux<String> flux0=Flux.fromIterable(Arrays.asList("flux1","flux2","flux3","flux4"));
        Flux<String> flux1=Flux.fromStream(Stream.of("flux1","flux2","flux3","flux4"));
        Flux<Integer> flux2=Flux.range(1,100);
        Flux<String> flux3=Flux.fromArray(new String[]{"flux1","flux2","flux3","flux4"});*/

       //程序创建
        Flux<String> fluxGenerate1 = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3*state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        fluxGenerate1.subscribe(System.out::println);

    }
}
