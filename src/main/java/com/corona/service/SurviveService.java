package com.corona.service;

import com.corona.dto.SurviveDto;
import reactor.core.publisher.Flux;

public interface SurviveService {

    void create(SurviveDto survivors);

    Flux<SurviveDto> findAll();

}
