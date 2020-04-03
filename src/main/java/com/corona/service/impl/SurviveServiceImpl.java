package com.corona.service.impl;

import com.corona.dto.SurviveDto;
import com.corona.repository.SurviveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SurviveServiceImpl {

    private final SurviveRepository surviveRepository;

    public SurviveServiceImpl(SurviveRepository surviveRepository) {
        this.surviveRepository = surviveRepository;
    }

    public void create(SurviveDto survivors) {
        surviveRepository.save(survivors);
    }

    public Flux<SurviveDto> findAll() {
        return surviveRepository.findAll();
    }

    public Mono<SurviveDto> findById() {
        return surviveRepository.findById();
    }


}
