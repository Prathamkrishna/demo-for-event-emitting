package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class RandomHandler {
    private final UserService userService;

    public RandomHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> loadRandom(ServerRequest request){
        Flux<User> userFlux = userService.getRandom();
        return ServerResponse.ok()
                .body(userFlux, User.class);
    }

    public Mono<ServerResponse> loadRandomStream(ServerRequest request){
        Flux<User> userFlux = userService.getUsers();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userFlux, User.class);
    }
}
