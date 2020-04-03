package com.corona.handler;

import com.corona.dto.SurviveDto;
import com.corona.model.SurviveEntity;
import com.corona.repository.SurviveRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        Mono<SurviveDto> survivors = request.body(SurviveDto.class);
        return ServerResponse.ok().build(surviveRepository.savePerson(person));
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        int id = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<SurviveDto> personMono = this.surviveRepository.findById(id);
        return personMono
                .then(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .otherwiseIfEmpty(notFound);
    }
}
