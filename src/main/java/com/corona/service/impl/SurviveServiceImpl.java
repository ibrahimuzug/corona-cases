package com.corona.service.impl;

import com.corona.model.Survive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SurviveServiceImpl {

    void create(Survive survive);

    Mono<Survive> findById(Integer id);

    Flux<Survive> findAll();


}
