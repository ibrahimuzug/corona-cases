package com.corona.repository;

import com.corona.dto.CaseDto;
import com.corona.model.CaseEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CaseRepository extends ReactiveCrudRepository<CaseEntity, Long> {

    @Query("SELECT * FROM case WHERE id = {id}")
    Mono<CaseDto> findById(Integer id);

    @Query("SELECT * FROM case")
    Flux<CaseEntity> findAll();
}
