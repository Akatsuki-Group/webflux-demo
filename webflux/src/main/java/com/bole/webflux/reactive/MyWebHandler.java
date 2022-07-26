package com.bole.webflux.reactive;

import com.bole.webflux.domain.Product;
import com.bole.webflux.domain.ProductCriteria;
import com.bole.webflux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 19:14
 */
@Component
public class MyWebHandler {

    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionalOperator transactionalOperator;

    @Autowired
    private WebClient.Builder  builder;


    public Mono<ServerResponse> findStock(ServerRequest serverRequest){
        var productId = Integer.parseInt(serverRequest.pathVariable("productId"));
        System.out.println("productId:"+productId);
       return builder.build()
               .get().uri("/stock/get/{productId}",productId)
               .retrieve().bodyToMono(String.class)
               .flatMap(p -> ServerResponse.ok().bodyValue(p));
    }

    /**
     * 保存商品
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Product.class)
                .flatMap(i -> productService.save(i))
                .flatMap(p -> ServerResponse.ok().bodyValue(p));
    }

    /**
     * 保存多个商品
     * @param serverRequest
     * @return
     */
    @Transactional
    public Mono<ServerResponse> saveMany(ServerRequest serverRequest) {
        return serverRequest.bodyToFlux(Product.class)
                .flatMap(i -> productService.save(i))
                .then(ServerResponse.ok().build())
                   .as(transactionalOperator::transactional);//手动使用事务
    }

    /**
     * 查询商品
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> find(ServerRequest serverRequest) {
        var productId = Integer.parseInt(serverRequest.pathVariable("productId"));
        return productService
                .findById(productId)
                .flatMap(product -> ServerResponse.ok().bodyValue(product))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * 查询所有
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(productService.findByAll(), Product.class);
    }

    public Mono<ServerResponse> findByCategoryPage(ServerRequest serverRequest) {
        return
                serverRequest.bodyToMono(ProductCriteria.class)
                        .flatMap(p -> {
                            System.out.println("p:" + p);
                            return ServerResponse.ok()
                                    .body(productService.findByCategoryPage(p), Product.class);
                        })
                ;
    }

    public Mono<ServerResponse> findAllByPage(ServerRequest serverRequest) {
      /*  return
                serverRequest.bodyToMono(ProductCriteria.class)
                        .flatMap(p -> ServerResponse.ok()
                                .body(productService.findAllByPage(), Product.class))

                ;
*/
        return ServerResponse.ok().body(productService.findAllByPage(), Product.class);
    }

    /**
     * 更新商品
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        var productId = Integer.parseInt(serverRequest.pathVariable("productId"));
        return productService
                .findById(productId)
                .flatMap(p -> serverRequest.bodyToMono(Product.class)
                        .flatMap(i -> productService.save(i)))
                .flatMap(p -> ServerResponse.ok().bodyValue(p))
                .switchIfEmpty(ServerResponse.notFound().build())
                ;
    }


    /**
     * 删除商品
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        var productId = Integer.parseInt(serverRequest.pathVariable("productId"));
        return productService
                .findById(productId)
                .flatMap(p -> productService.delete(p.getId()).then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }


}
