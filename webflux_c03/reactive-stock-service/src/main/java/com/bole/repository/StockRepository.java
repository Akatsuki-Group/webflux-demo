
package com.bole.repository;

import com.bole.domain.Stock;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
@Component
public interface StockRepository extends ReactiveCrudRepository<Stock, String> {
	@Query("select id,product_id,stock from t_stock where product_id= :product_id")
	Flux<Stock> findByProductId(Integer product_id);
}


