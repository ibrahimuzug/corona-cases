package com.corona.handler;

import com.corona.dto.SurviveDto;
import com.corona.service.SurviveService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class SurviveHandler {

    private final SurviveService surviveService;

    public SurviveHandler(SurviveService surviveService) {
        this.surviveService = surviveService;
    }

    public @NotNull Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(surviveService.findAll(), SurviveDto.class);
    }

    public @NotNull Mono<ServerResponse> create(ServerRequest request) {
        final Mono<SurviveDto> survivors = request.bodyToMono(SurviveDto.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(survivors.flatMap(surviveService::create), SurviveDto.class));
    }
}
