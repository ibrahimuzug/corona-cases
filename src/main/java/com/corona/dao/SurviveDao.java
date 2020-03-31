package com.corona.dao;

import com.corona.model.Survive;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SurviveDao extends ReactiveCrudRepository<Survive, Long> {
    @Query("SELECT * FROM survive WHERE id like {id}")
    Mono<Survive> findById(Integer id);
}
