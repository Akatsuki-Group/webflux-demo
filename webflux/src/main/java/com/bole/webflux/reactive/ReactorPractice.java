package com.bole.webflux.reactor;

import reactor.core.publisher.Flux;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/6 19:32
 */
public class ReactorPractice {
    public static void main(String[] args) {
        String wordStr="hello guys i am bole welcome to luban school jdk quick fox prizev ";
        Flux.fromArray(wordStr.split(" "))
                .flatMap(word -> Flux.fromArray(word.split("")))//1->5
                .distinct()
                .sort()
                .subscribe(System.out::print);
    }
}
