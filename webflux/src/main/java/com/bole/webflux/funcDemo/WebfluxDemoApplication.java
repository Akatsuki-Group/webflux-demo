package com.bole.webflux.funcDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxDemoApplication.class, args);
        WebFluxClient client = new WebFluxClient();
        System.out.println("getResults = " + client.getResult());
    }

}
