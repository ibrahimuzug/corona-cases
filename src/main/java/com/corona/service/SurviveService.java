package com.corona.service;

import com.corona.dto.SurviveDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SurviveService {
    Flux<SurviveDto> findAll();

    Mono<SurviveDto> create(SurviveDto survivors);

}
