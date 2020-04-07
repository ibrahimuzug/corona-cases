package com.corona.service.impl;

import com.corona.config.SurviveRouterConfig;
import com.corona.dto.SurviveDto;
import com.corona.handler.SurviveHandler;
import com.corona.model.SurviveEntity;
import com.corona.repository.SurviveRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SurviveRouterConfig.class, SurviveHandler.class})
@WebFluxTest
class SurviveServiceImplTest {

    @Autowired
    private ApplicationContext context;

    @MockBean
    private SurviveRepository surviveRepository;

    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void testCreateUser() {

        SurviveDto survivors = SurviveDto.builder().id(1).country("Turkey").survivors(String.valueOf(123)).build();
        Mono<SurviveDto> SurviveMono = Mono.just(survivors);
        when(surviveRepository.save(any())).thenReturn(SurviveMono);

        webTestClient.post()
                .uri("/survive")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(survivors), SurviveDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(SurviveDto.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.getId()).isEqualTo(1);
                            Assertions.assertThat(userResponse.getCountry()).isEqualTo("Turkey");
                            Assertions.assertThat(userResponse.getSurvivors()).isEqualTo(123);
                        }
                );

    }
    @Test
    void findAll() {

        SurviveDto survivor1 = SurviveDto.builder().id(1).country("Turkey").survivors(String.valueOf(12345)).build();
        SurviveDto survivor2 = SurviveDto.builder().id(2).country("USA").survivors(String.valueOf(123)).build();

        when(surviveRepository.findAll()).thenReturn(Flux.just(survivor1, survivor2));

        webTestClient.get()
                .uri("/survivor")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SurviveDto.class)
                .value(survivorsResponse -> {
                            Assertions.assertThat(survivorsResponse.get(0).getId()).isEqualTo(1);
                            Assertions.assertThat(survivorsResponse.get(0).getCountry()).isEqualTo("Turkey");
                            Assertions.assertThat(survivorsResponse.get(0).getSurvivors()).isEqualTo(12345);
                            Assertions.assertThat(survivorsResponse.get(1).getId()).isEqualTo(2);
                            Assertions.assertThat(survivorsResponse.get(1).getCountry()).isEqualTo("USA");
                            Assertions.assertThat(survivorsResponse.get(1).getSurvivors()).isEqualTo(123);
                        }
                );
    }
}