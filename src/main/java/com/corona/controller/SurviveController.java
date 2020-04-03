package com.corona.controller;

import com.corona.dto.SurviveDto;
import com.corona.service.SurviveService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(value = "/survive")
public class SurviveController {
    private SurviveService surviveService;

    @PostMapping(value = "/create")
    public void create(@RequestBody SurviveDto survivors) {
        surviveService.create(survivors);
    }

    @GetMapping(value ="/find")
    public Mono<SurviveDto> findById(){
        Mono<SurviveDto> survivors = surviveService.findById();
        return survivors;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SurviveDto> findAll() {
        Flux<SurviveDto> survivors = surviveService.findAll();
        return survivors;
    }
}
