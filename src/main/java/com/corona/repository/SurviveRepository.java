package com.corona.repository;

import com.corona.dto.SurviveDto;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

@Repository
public interface SurviveRepository extends ReactiveCrudRepository<SurviveDto, Long> {

    @Query("SELECT * FROM survive")
    @NonNull
    Flux<SurviveDto> findAll();

    @Query("INSERT INTO survive (id, country, survivors) VALUES (:id, :country, :survivors)")
    @NonNull
    Mono<SurviveDto> create(SurviveDto survivors);
}
