package com.corona.config;

import com.corona.handler.SurviveHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class SurviveRouterConfig {

    @Autowired
    public SurviveHandler surviveHandler;

    @Bean
    public RouterFunction<ServerResponse> route(SurviveHandler surviveHandler) {
        return RouterFunctions
                .route(GET("/survivors").and(accept(MediaType.APPLICATION_JSON)), surviveHandler::findAll)
                .andRoute(POST("/survivors").and(accept(MediaType.APPLICATION_JSON)), surviveHandler::create);
    }

}
