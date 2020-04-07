package com.corona.config;

import com.corona.handler.SurviveHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
public class SurviveRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> surviveRoutes(SurviveHandler surviveHandler) {

        return RouterFunctions.route()
                .path("/survivor", builder -> builder
                        .POST("", accept(MediaType.APPLICATION_JSON), surviveHandler::create)
                        .GET("", accept(MediaType.APPLICATION_JSON), surviveHandler::findAll))
                .build();
    }

   /* @Bean
    public RouterFunction<ServerResponse> surviveRoutes(SurviveHandler handler) {
        return RouterFunctions
                .route(POST("/survive").and(accept(MediaType.APPLICATION_JSON)), handler::create)
                .andRoute(GET("/survive").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/"), request -> ServerResponse.ok()
                        .body(fromValue("This Is Corona Case Web Application HOME PAGE!!!! We will be here soon !!!")));
    }*/

}
