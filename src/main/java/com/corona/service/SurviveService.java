package com.corona.service;

import com.corona.dao.SurviveDao;
import com.corona.model.Survive;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SurviveService {
    SurviveDao surviveDao;

    public void create(Survive survive) {
        surviveDao.save(survive).subscribe();
    }

    public Mono<Survive> findById(Integer id) {
        return surviveDao.findById(id);
    }

    public Flux<Survive> findAll() {
        return surviveDao.findAll();
    }
}
