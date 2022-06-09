package com.corona.repository;

import com.corona.dto.DeathDto;
import com.corona.model.DeathEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DeathRepository extends ReactiveCrudRepository<DeathEntity, Long> {

    @Query("SELECT * FROM death WHERE id = {id}")
    Mono<DeathDto> findById(Integer id);

    @Query("SELECT * FROM cases")
    Flux<DeathEntity> findAll();
}
