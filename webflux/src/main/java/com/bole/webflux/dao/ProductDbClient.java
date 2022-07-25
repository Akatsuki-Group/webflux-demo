/*
package com.bole.webflux.dao;

import com.bole.webflux.domain.Product;
import com.bole.webflux.domain.ProductCriteria;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


*/
/*    * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/6 16:49
 *//*


@RequiredArgsConstructor
@Repository
public class ProductDbClient {

    public final DatabaseClient dbClient;

    public Flux<Product> findByAllPage(ProductCriteria productCriteria) {
        return dbClient.execute("select * from t_product limit 1,5")
                .as(Product.class)
                .fetch().all();
    }


}
*/
