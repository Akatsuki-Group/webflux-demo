package com.bole.webflux.reactive;

import com.bole.webflux.RoutePath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Description:
 * @Author: 伯乐
 * @Date: 2020/12/2 17:09
 */
@Configuration
public class BaseRouter {

    private static final String ROUTE_PATH = "/product/route/";

    @Bean
    public RouterFunction<ServerResponse> routes(MyWebHandler myWebHandler) {
        return  RouterFunctions.route()
                .POST(RoutePath.save,myWebHandler::save)
                .GET(RoutePath.find,myWebHandler::find)
                .DELETE(RoutePath.delete,myWebHandler::delete)
                .PUT(RoutePath.update,myWebHandler::update)
                .GET(RoutePath.findAll,myWebHandler::findAll)
                .GET(RoutePath.findAllPage,myWebHandler::findAllByPage)
                .POST(RoutePath.findByCategory,myWebHandler::findByCategoryPage)
                .POST(RoutePath.saveMany,myWebHandler::saveMany)

                .GET(RoutePath.findStock,myWebHandler::findStock)
                .build();
    }

}
