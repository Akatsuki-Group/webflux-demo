package com.bole.webflux.annotated;

import com.bole.webflux.domain.Product;
import com.bole.webflux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 20:43
 */
@RestController
@RequestMapping("/ant/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Mono<Product> save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/update")
    public Mono<Product> update(@RequestBody Product product) {
        return productService.update(product);
    }

    @PostMapping("/find")
    public Mono<Product> find(Integer id) {
        return productService.findById(id);
    }

    @PostMapping("/delete")
    public Mono<Void> delete(Integer id) {
        return productService.delete(id);
    }

    @PostMapping("/deleteProduct")
    public Mono<Void> deleteProduct(Integer id) {
        return productService.delete(id);
    }


}
