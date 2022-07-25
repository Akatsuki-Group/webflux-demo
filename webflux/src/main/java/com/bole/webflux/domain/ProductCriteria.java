package com.bole.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/11/27 14:49
 */
@Data
public class ProductCriteria {
  /*  private Integer id;
    private BigDecimal price;
    private String name;
    private Integer stock;*/
    private String category;

    private int page = 1;
    private int pageSize = 10;
}
