package cn.tuling.webfluxr2dbcmysql.dao;

import cn.tuling.webfluxr2dbcmysql.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserDao extends ReactiveCrudRepository<User, Integer> {
}
