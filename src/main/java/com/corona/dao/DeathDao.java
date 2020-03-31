package com.corona.dao;

import com.corona.model.Death;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DeathDao extends ReactiveCrudRepository<Death, Long> {

    @Query("SELECT * FROM death WHERE id like {id}")
    Flux<Death> findById(Integer id);
}
