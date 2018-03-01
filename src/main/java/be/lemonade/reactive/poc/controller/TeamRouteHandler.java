package be.lemonade.reactive.poc.controller;

import be.lemonade.reactive.poc.model.Team;
import be.lemonade.reactive.poc.model.TeamEvent;
import be.lemonade.reactive.poc.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
@AllArgsConstructor
public class TeamRouteHandler {

    private TeamService teamService;


    Mono<ServerResponse> all (ServerRequest serverRequest) {
        return ServerResponse.ok().body(teamService.findAllTeams(), Team.class);
    }

    Mono<ServerResponse> byName (ServerRequest serverRequest) {
        return ServerResponse.ok().body(teamService.findByName(serverRequest.pathVariable("name")), Team.class);
    }

    Mono<ServerResponse> streams (ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(teamService.getEvents(serverRequest.pathVariable("name")), TeamEvent.class);
    }

    @Bean
    RouterFunction<?> routes (TeamRouteHandler handler){
        return RouterFunctions.route(RequestPredicates.GET("/teams"), handler::all)
                .andRoute(RequestPredicates.GET("/teams/{name}"), handler::byName)
                .andRoute(RequestPredicates.GET("/teams/{name}/events"),handler::streams);
    }
}
