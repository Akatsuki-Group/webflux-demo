package cn.tuling.webfluxstart.service;

import cn.tuling.webfluxstart.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {

  public Mono<User> findUser(Integer userId){
      if (userId.equals(100)){
          throw new RuntimeException("100 limited exception");
      }
      return Mono.just(User.builder().id(userId).username(UUID.randomUUID().toString()).build());
  }
}
