package com.corona.config;

import com.corona.handler.SurviveHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class SurviveRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> surviveRoutes(SurviveHandler handler) {
        return RouterFunctions.route(POST("/survive/create").and(accept(APPLICATION_JSON)), handler::create)
                .andRoute(GET("survive/findAll").and(accept(APPLICATION_JSON)), handler::findAll);
    }

}
