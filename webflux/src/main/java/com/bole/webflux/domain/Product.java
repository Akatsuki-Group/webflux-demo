package com.bole.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/11/27 14:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table("t_product")
public class Product  {
    @Id
    private Integer id;
    private BigDecimal price;
    private String name;
    private Integer stock;
    private String category;
}
