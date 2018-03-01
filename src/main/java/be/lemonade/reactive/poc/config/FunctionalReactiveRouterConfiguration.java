package be.lemonade.reactive.poc.config;

import be.lemonade.reactive.poc.service.TeamService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class FunctionalReactiveRouterConfiguration {
    @Bean
    RouterFunction<?> routes (TeamService teamService){
        return RouterFunctions.route(RequestPredicates.GET("/teams"), new HandlerFunction<ServerResponse>(){
            @Override
            public Mono<ServerResponse> handle (ServerRequest serverRequest) {
                return null;
            }
        });
    }
}
