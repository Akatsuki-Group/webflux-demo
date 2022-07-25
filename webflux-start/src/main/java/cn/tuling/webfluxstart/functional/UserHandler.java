package cn.tuling.webfluxstart.functional;

import cn.tuling.webfluxstart.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Component
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest request) {
        return processGetUser(request);
    }


    public Mono<ServerResponse> processGetUser(ServerRequest request) {
        Optional<String> userId = request.queryParam("userId");
        boolean present = userId.isPresent();
        Integer id = 0;
        if (!present) {
            id = new Random().nextInt(100);
        }else{
            id=Integer.parseInt(userId.get());
        }
        Mono<User> just = Mono.just(User.builder().id(id).username(UUID.randomUUID().toString()).build())
                .map(user -> {
                    if (user.getId().equals(100)) {
                        throw new RuntimeException(" userId limited! ");
                    }
                    return user;
                });

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(just, User.class);
    }


}
