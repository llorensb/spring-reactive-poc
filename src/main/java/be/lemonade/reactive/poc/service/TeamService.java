package be.lemonade.reactive.poc.service;

import be.lemonade.reactive.poc.model.Team;
import be.lemonade.reactive.poc.model.TeamEvent;
import be.lemonade.reactive.poc.repo.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Mono<Team> findByName(String name) {
        return this.teamRepository.findById(name);
    }

    public Flux<Team> findAllTeams() {
        return this.teamRepository.findAll();
    }

    public Flux<TeamEvent> getEvents (String name){
        return findByName(name).flatMapMany(team -> {
            Flux<TeamEvent> eventFlux = Flux.fromStream(Stream.generate(() -> new TeamEvent(team, new Date())));
            return eventFlux.zipWith(Flux.interval(Duration.ofSeconds(1))).map(Tuple2::getT1);
        });
    }
}


