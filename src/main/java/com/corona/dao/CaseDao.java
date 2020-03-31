package com.corona.dao;

import com.corona.model.Case;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CaseDao extends ReactiveCrudRepository<Case, Long> {

    @Query("SELECT * FROM case WHERE id like {id}")
    Flux<Case> findById(Integer id);
}
