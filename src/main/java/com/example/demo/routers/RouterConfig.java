package com.example.demo.routers;

import com.example.demo.RandomHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    private final RandomHandler randomHandler;

    public RouterConfig(RandomHandler randomHandler) {
        this.randomHandler = randomHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/random", randomHandler::loadRandom)
                .GET("/random/stream", randomHandler::loadRandomStream)
                .build();
    }
}
