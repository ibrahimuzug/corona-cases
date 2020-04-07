package com.corona.handler;

import com.corona.dto.SurviveDto;
import com.corona.repository.SurviveRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class SurviveHandler {

    private final SurviveRepository surviveRepository;

    public SurviveHandler(SurviveRepository surviveRepository) {
        this.surviveRepository = surviveRepository;
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<SurviveDto> survivors = surviveRepository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(survivors, SurviveDto.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<SurviveDto> survivors = request.bodyToMono(SurviveDto.class);
        return ServerResponse.ok().build((BiFunction<ServerWebExchange, ServerResponse.Context, Mono<Void>>) surviveRepository.create(survivors));
    }
}
