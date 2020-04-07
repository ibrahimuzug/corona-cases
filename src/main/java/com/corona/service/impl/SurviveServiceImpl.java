package com.corona.service.impl;

import com.corona.dto.SurviveDto;
import com.corona.repository.SurviveRepository;
import com.corona.service.SurviveService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SurviveServiceImpl implements SurviveService {

    private final SurviveRepository surviveRepository;

    public SurviveServiceImpl(SurviveRepository surviveRepository) {
        this.surviveRepository = surviveRepository;
    }

    public Mono<SurviveDto> create(Mono<SurviveDto> survivors) {
        return surviveRepository.create(survivors);
    }

    public Flux<SurviveDto> findAll() {
        return surviveRepository.findAll();
    }


}
