package com.bole.webflux.reactor;

import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/3 22:12
 */
public class ReactorDemo2 {

    private static Product[] products = new Product[]{
            new Product(1, new BigDecimal("9.92"), 100, "E"),
            new Product(2, new BigDecimal("19.92"), 200, "E"),
            new Product(3, new BigDecimal("29.92"), 500, "E"),

            new Product(4, new BigDecimal("19.92"), 200, "C"),
            new Product(5, new BigDecimal("9.32"), 300, "C"),
            new Product(6, new BigDecimal("18.92"), 100, "C"),

            new Product(7, new BigDecimal("23.76"), 300, "M"),
            new Product(8, new BigDecimal("11.92"), 150, "M"),
            new Product(9, new BigDecimal("78.08"), 100, "M"),
    };

    /**
     * 获取每个类别价格最高的商品
     *
     * @return
     */
    public List<Product> getHighestProducts() {
        var map = new HashMap<String, Product>();
        for (var product : products) {
            var p = map.get(product.getCategory());
            if (p != null) {
                if (p.getPrice().compareTo(product.getPrice()) < 0) {
                    map.put(product.getCategory(), product);
                }
            } else {
                map.put(product.getCategory(), product);
            }
        }
        return new ArrayList<>(map.values());
    }

    public Flux<Product> getHighestProductsByReactor() {

        return Flux.just(products).collectMultimap(Product::getCategory)
                .flatMapMany(i -> Flux.fromIterable(i.entrySet()))
                .flatMap(i -> Flux.fromIterable(i.getValue())
                .sort(
                        Comparator.comparing(Product::getPrice).reversed())
                .next());
    }


    public static void main(String[] args) {
        var reactorDemo2 = new ReactorDemo2();
        reactorDemo2.getHighestProducts().stream().forEach(i -> System.out.println(i));
        System.out.println("=========================");
        reactorDemo2.getHighestProductsByReactor().subscribe(i -> System.out.println(i));
    }
}
