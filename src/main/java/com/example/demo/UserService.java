package com.example.demo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {

    public List<User> getAllUsers(){
//        return getUsers();
        return null;
    }
    public Flux<User> getAllUsersFlux(){
        return getUsers();
    }

    public Flux<User> getUsers(){
        return Flux
                .range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(System.out::println)
                .map(i->new User(i, "user"+i));
    }
    public Flux<User> getRandom(){
        return Flux
                .range(1,50)
//                .delayElements(Duration.ofSeconds(1))
                .doOnNext(System.out::println)
                .map(i->new User(i, "user"+i));
    }
}
