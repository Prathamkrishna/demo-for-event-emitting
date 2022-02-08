package com.example.demo;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class Controllers {

    private final UserService userService;

    public Controllers(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "https://jx637.csb.app/")
    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUsersFromService(){
        return userService.getAllUsersFlux();
    }
}
