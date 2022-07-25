package com.bole.webflux.reactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/3 22:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private BigDecimal price;
    private Integer stock;
    private String category;
}
