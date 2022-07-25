package cn.tuling.webfluxstart.router;

import cn.tuling.webfluxstart.functional.UserHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.handler.WebFluxResponseStatusExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
public class UserRouterCfg {

    @Bean
    public RouterFunction<ServerResponse>  userRouterFunctions(UserHandler handler){
        return RouterFunctions.route().filter(((request, next) -> {

            ServerRequest.Headers headers = request.headers();
            List<String> token = headers.header("token");
            if (token==null || token.isEmpty()){
                return ServerResponse.status(HttpStatus.FORBIDDEN).build();
            }
            return next.handle(request);

        })).GET("/functional/user/get", handler::getUser).build();
    }





}
