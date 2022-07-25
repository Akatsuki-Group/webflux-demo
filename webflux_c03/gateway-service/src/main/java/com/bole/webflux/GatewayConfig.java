/*
package com.bole.webflux;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/8 19:36
 *//*

@Configuration
public class GatewayConfig {

      @Bean
      public RouteLocator routeLocator(RouteLocatorBuilder builder) {
          return builder.routes()
                */
/*.route("path_route", r -> r.path("/get")
                        .uri("http://httpbin.org"))
                .route("host_route", r -> r.host("*.myhost.org")
                        .uri("http://httpbin.org"))
                .route("rewrite_route", r -> r.host("*.rewrite.org")
                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
                        .uri("http://httpbin.org"))*//*


                .route("reative-product-service", r -> r.path("/route/product/**")
                        .uri("http://localhost:9998"))
                .route("reative-product-service", p ->
                        p.path("/route/product/**")
                                .filters(f -> f.rewritePath("/route/product/(?<path>.*)", "/$\\{path}"))
                                .uri("lb://reative-product-service")
                )
                */
/* .route("hystrix_route", r -> r.host("*.hystrix.org")
                         .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
                         .uri("http://httpbin.org"))
                 .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
                         .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
                         .uri("http://httpbin.org"))
                 .route("limit_route", r -> r
                         .host("*.limited.org").and().path("/anything/**")
                         .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
                         .uri("http://httpbin.org"))*//*

                .build();
    }
}
*/
