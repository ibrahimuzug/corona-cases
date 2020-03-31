package com.corona.controller;

import com.corona.model.Survive;
import com.corona.service.SurviveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/case")
public class SurviveController {
    private SurviveService surviveService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Survive>> findById(@PathVariable("id") Integer id) {
        Mono<Survive> survive = surviveService.findById(id);
        HttpStatus status = survive != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Survive>>(survive, status);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Survive> findAll() {
        Flux<Survive> survivors = surviveService.findAll();
        return survivors;
    }
}
