package com.corona.service.impl;

import com.corona.dto.SurviveDto;
import com.corona.repository.SurviveRepository;
import com.corona.service.SurviveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SurviveServiceImpl implements SurviveService {

    private final SurviveRepository surviveRepository;

    public SurviveServiceImpl(SurviveRepository surviveRepository) {
        this.surviveRepository = surviveRepository;
    }

    @Override
    public Mono<SurviveDto> create(SurviveDto survivors) {
        return surviveRepository.create(survivors);
    }

    @Override
    public Flux<SurviveDto> findAll() {
        return surviveRepository.findAll();
    }


}
