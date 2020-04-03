package com.corona.repository;

import com.corona.dto.SurviveDto;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SurviveRepository extends ReactiveCrudRepository<SurviveDto, Long> {
    @Query("SELECT * FROM survive WHERE id = {id}")
    Mono<SurviveDto> findById();

    @Query("SELECT * FROM case")
    Flux<SurviveDto> findAll();
}
