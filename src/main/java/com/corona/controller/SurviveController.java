package com.corona.controller;

import com.corona.dto.SurviveDto;
import com.corona.service.SurviveService;
import com.corona.service.impl.SurviveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(value = "/survive")
public class SurviveController {
    @Autowired
    private SurviveServiceImpl surviveServiceImpl;

    @PostMapping(value = "/create")
    public void create(@RequestBody SurviveDto survivors) {
        surviveServiceImpl.create(survivors);
    }

    @GetMapping(value ="/find")
    public Mono<SurviveDto> findById(){
        Mono<SurviveDto> survivors = surviveServiceImpl.findById();
        return survivors;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SurviveDto> findAll() {
        Flux<SurviveDto> survivors = surviveServiceImpl.findAll();
        return survivors;
    }
}
